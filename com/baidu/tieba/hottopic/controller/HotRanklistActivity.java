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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private com.baidu.tieba.hottopic.view.b iYb;
    private HotRanklistModel iYc;
    private b iYd;
    private List<j> iYh;
    private List<p> iYi;
    private String callFrom = "";
    private String iYe = "";
    private long iYf = System.currentTimeMillis();
    private boolean iYg = false;
    private CustomMessageListener iYj = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a = HotRanklistActivity.this.iYb.a((p) data);
                    if (a >= 0) {
                        HotRanklistActivity.this.iYb.setCurrentTab(a);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        initUI();
        bMh();
        czA();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.iYe = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.iYe = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.iYb = new com.baidu.tieba.hottopic.view.b(this);
        this.iYd = new b(this);
        this.iYc = new HotRanklistModel(getPageContext());
        this.iYc.a(this);
    }

    private void bMh() {
        registerListener(this.iYj);
        this.iYb.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.iYc != null) {
                    j jVar = (j) HotRanklistActivity.this.iYh.get(HotRanklistActivity.this.iYb.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cAg())) {
                        HotRanklistActivity.this.iYb.bFX();
                        HotRanklistActivity.this.iYb.showLoadingView();
                        HotRanklistActivity.this.czz();
                    }
                }
            }
        });
    }

    public void czz() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.iYb.cAr();
        } else if (this.iYc != null) {
            String str = this.iYg ? "0" : "1";
            if (!y.isEmpty(this.iYi)) {
                this.iYe = this.iYi.get(this.iYb.getCurrentTab()).geQ;
            }
            this.iYc.c(this.callFrom, this.iYe, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iYb.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.iYb.cAr();
        hideLoadingView(this.iYb.cAp());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.iYb != null) {
            if (!y.isEmpty(jVar.iZP) && !this.iYg) {
                this.iYi = jVar.iZP;
                this.iYh = new ArrayList();
                for (p pVar : jVar.iZP) {
                    j jVar2 = new j();
                    jVar2.type = pVar.geQ;
                    this.iYh.add(jVar2);
                }
            }
            if (y.isEmpty(this.iYh)) {
                this.iYh = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.iYh.size()) {
                        i2 = -1;
                        break;
                    } else if (this.iYh.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.iZP = this.iYi;
                } else if (y.isEmpty(this.iYh.get(0).iZP)) {
                    this.iYh.get(0).iZP = this.iYi;
                }
                this.iYh.add(i2, jVar);
                this.iYh.remove(i2 + 1);
            }
            this.iYb.du(this.iYh);
            if (!this.iYg && !y.isEmpty(this.iYh) && !y.isEmpty(this.iYh.get(0).iZP) && !y.isEmpty(this.iYi)) {
                this.iYg = true;
                this.iYb.cAn();
                if (i2 >= 0) {
                    this.iYb.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.iYe)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.iYe);
        }
    }

    private void czA() {
        showLoadingView(this.iYb.cAp(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.iYb.cAp());
            showNetRefreshView(this.iYb.cAp(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.iYb.As(0);
            this.iYb.At(8);
            this.iYb.Au(8);
            return;
        }
        this.iYb.As(8);
        this.iYb.At(0);
        this.iYb.Au(0);
        czz();
    }

    public void czB() {
        p pVar;
        if (!y.isEmpty(this.iYi) && (pVar = this.iYi.get(this.iYb.getCurrentTab())) != null) {
            this.iYd.b(null, pVar.shareTitle, pVar.shareUrl, pVar.iTn, pVar.jaf, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.iYb.cAp());
            czA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        czC();
    }

    private void czC() {
        if (this.iYb != null) {
            this.iYb.cAq();
        }
    }

    private void czD() {
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
        czD();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new aq("c10818").dD("obj_duration", "" + (System.currentTimeMillis() - this.iYf)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.iYb.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
