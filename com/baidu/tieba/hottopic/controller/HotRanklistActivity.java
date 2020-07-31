package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private com.baidu.tieba.hottopic.view.b iIV;
    private HotRanklistModel iIW;
    private b iIX;
    private List<j> iJb;
    private List<p> iJc;
    private String callFrom = "";
    private String iIY = "";
    private long iIZ = System.currentTimeMillis();
    private boolean iJa = false;
    private CustomMessageListener iJd = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a = HotRanklistActivity.this.iIV.a((p) data);
                    if (a >= 0) {
                        HotRanklistActivity.this.iIV.setCurrentTab(a);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        at(bundle);
        initUI();
        bCM();
        coG();
    }

    private void at(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.iIY = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.iIY = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.iIV = new com.baidu.tieba.hottopic.view.b(this);
        this.iIX = new b(this);
        this.iIW = new HotRanklistModel(getPageContext());
        this.iIW.a(this);
    }

    private void bCM() {
        registerListener(this.iJd);
        this.iIV.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.iIW != null) {
                    j jVar = (j) HotRanklistActivity.this.iJb.get(HotRanklistActivity.this.iIV.getCurrentTab());
                    if (jVar == null || x.isEmpty(jVar.cpm())) {
                        HotRanklistActivity.this.iIV.bwX();
                        HotRanklistActivity.this.iIV.showLoadingView();
                        HotRanklistActivity.this.coF();
                    }
                }
            }
        });
    }

    public void coF() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.iIV.cpx();
        } else if (this.iIW != null) {
            String str = this.iJa ? "0" : "1";
            if (!x.isEmpty(this.iJc)) {
                this.iIY = this.iJc.get(this.iIV.getCurrentTab()).fSN;
            }
            this.iIW.c(this.callFrom, this.iIY, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iIV.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.iIV.cpx();
        hideLoadingView(this.iIV.cpv());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.iIV != null) {
            if (!x.isEmpty(jVar.iKJ) && !this.iJa) {
                this.iJc = jVar.iKJ;
                this.iJb = new ArrayList();
                for (p pVar : jVar.iKJ) {
                    j jVar2 = new j();
                    jVar2.type = pVar.fSN;
                    this.iJb.add(jVar2);
                }
            }
            if (x.isEmpty(this.iJb)) {
                this.iJb = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.iJb.size()) {
                        i2 = -1;
                        break;
                    } else if (this.iJb.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.iKJ = this.iJc;
                } else if (x.isEmpty(this.iJb.get(0).iKJ)) {
                    this.iJb.get(0).iKJ = this.iJc;
                }
                this.iJb.add(i2, jVar);
                this.iJb.remove(i2 + 1);
            }
            this.iIV.dn(this.iJb);
            if (!this.iJa && !x.isEmpty(this.iJb) && !x.isEmpty(this.iJb.get(0).iKJ) && !x.isEmpty(this.iJc)) {
                this.iJa = true;
                this.iIV.cpt();
                if (i2 >= 0) {
                    this.iIV.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.iIY)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.iIY);
        }
    }

    private void coG() {
        showLoadingView(this.iIV.cpv(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.iIV.cpv());
            showNetRefreshView(this.iIV.cpv(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.iIV.xY(0);
            this.iIV.xZ(8);
            this.iIV.ya(8);
            return;
        }
        this.iIV.xY(8);
        this.iIV.xZ(0);
        this.iIV.ya(0);
        coF();
    }

    public void coH() {
        p pVar;
        if (!x.isEmpty(this.iJc) && (pVar = this.iJc.get(this.iIV.getCurrentTab())) != null) {
            this.iIX.b(null, pVar.shareTitle, pVar.shareUrl, pVar.iEh, pVar.iKZ, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.iIV.cpv());
            coG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        coI();
    }

    private void coI() {
        if (this.iIV != null) {
            this.iIV.cpw();
        }
    }

    private void coJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        coJ();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new ap("c10818").dn("obj_duration", "" + (System.currentTimeMillis() - this.iIZ)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.iIV.cpy()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
