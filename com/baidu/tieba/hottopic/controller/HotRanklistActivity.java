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
    private com.baidu.tieba.hottopic.view.b iIX;
    private HotRanklistModel iIY;
    private b iIZ;
    private List<j> iJd;
    private List<p> iJe;
    private String callFrom = "";
    private String iJa = "";
    private long iJb = System.currentTimeMillis();
    private boolean iJc = false;
    private CustomMessageListener iJf = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a = HotRanklistActivity.this.iIX.a((p) data);
                    if (a >= 0) {
                        HotRanklistActivity.this.iIX.setCurrentTab(a);
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
            this.iJa = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.iJa = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.iIX = new com.baidu.tieba.hottopic.view.b(this);
        this.iIZ = new b(this);
        this.iIY = new HotRanklistModel(getPageContext());
        this.iIY.a(this);
    }

    private void bCM() {
        registerListener(this.iJf);
        this.iIX.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.iIY != null) {
                    j jVar = (j) HotRanklistActivity.this.iJd.get(HotRanklistActivity.this.iIX.getCurrentTab());
                    if (jVar == null || x.isEmpty(jVar.cpm())) {
                        HotRanklistActivity.this.iIX.bwX();
                        HotRanklistActivity.this.iIX.showLoadingView();
                        HotRanklistActivity.this.coF();
                    }
                }
            }
        });
    }

    public void coF() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.iIX.cpx();
        } else if (this.iIY != null) {
            String str = this.iJc ? "0" : "1";
            if (!x.isEmpty(this.iJe)) {
                this.iJa = this.iJe.get(this.iIX.getCurrentTab()).fSN;
            }
            this.iIY.c(this.callFrom, this.iJa, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iIX.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.iIX.cpx();
        hideLoadingView(this.iIX.cpv());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.iIX != null) {
            if (!x.isEmpty(jVar.iKL) && !this.iJc) {
                this.iJe = jVar.iKL;
                this.iJd = new ArrayList();
                for (p pVar : jVar.iKL) {
                    j jVar2 = new j();
                    jVar2.type = pVar.fSN;
                    this.iJd.add(jVar2);
                }
            }
            if (x.isEmpty(this.iJd)) {
                this.iJd = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.iJd.size()) {
                        i2 = -1;
                        break;
                    } else if (this.iJd.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.iKL = this.iJe;
                } else if (x.isEmpty(this.iJd.get(0).iKL)) {
                    this.iJd.get(0).iKL = this.iJe;
                }
                this.iJd.add(i2, jVar);
                this.iJd.remove(i2 + 1);
            }
            this.iIX.dn(this.iJd);
            if (!this.iJc && !x.isEmpty(this.iJd) && !x.isEmpty(this.iJd.get(0).iKL) && !x.isEmpty(this.iJe)) {
                this.iJc = true;
                this.iIX.cpt();
                if (i2 >= 0) {
                    this.iIX.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.iJa)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.iJa);
        }
    }

    private void coG() {
        showLoadingView(this.iIX.cpv(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.iIX.cpv());
            showNetRefreshView(this.iIX.cpv(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.iIX.xY(0);
            this.iIX.xZ(8);
            this.iIX.ya(8);
            return;
        }
        this.iIX.xY(8);
        this.iIX.xZ(0);
        this.iIX.ya(0);
        coF();
    }

    public void coH() {
        p pVar;
        if (!x.isEmpty(this.iJe) && (pVar = this.iJe.get(this.iIX.getCurrentTab())) != null) {
            this.iIZ.b(null, pVar.shareTitle, pVar.shareUrl, pVar.iEj, pVar.iLb, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.iIX.cpv());
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
        if (this.iIX != null) {
            this.iIX.cpw();
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
        TiebaStatic.log(new ap("c10818").dn("obj_duration", "" + (System.currentTimeMillis() - this.iJb)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.iIX.cpy()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
