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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private com.baidu.tieba.hottopic.view.b iCR;
    private HotRanklistModel iCS;
    private b iCT;
    private List<j> iCX;
    private List<p> iCY;
    private String callFrom = "";
    private String iCU = "";
    private long iCV = System.currentTimeMillis();
    private boolean iCW = false;
    private CustomMessageListener iCZ = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a = HotRanklistActivity.this.iCR.a((p) data);
                    if (a >= 0) {
                        HotRanklistActivity.this.iCR.setCurrentTab(a);
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
        bzx();
        clf();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.iCU = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.iCU = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.iCR = new com.baidu.tieba.hottopic.view.b(this);
        this.iCT = new b(this);
        this.iCS = new HotRanklistModel(getPageContext());
        this.iCS.a(this);
    }

    private void bzx() {
        registerListener(this.iCZ);
        this.iCR.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.iCS != null) {
                    j jVar = (j) HotRanklistActivity.this.iCX.get(HotRanklistActivity.this.iCR.getCurrentTab());
                    if (jVar == null || w.isEmpty(jVar.clL())) {
                        HotRanklistActivity.this.iCR.btN();
                        HotRanklistActivity.this.iCR.showLoadingView();
                        HotRanklistActivity.this.cle();
                    }
                }
            }
        });
    }

    public void cle() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.iCR.clW();
        } else if (this.iCS != null) {
            String str = this.iCW ? "0" : "1";
            if (!w.isEmpty(this.iCY)) {
                this.iCU = this.iCY.get(this.iCR.getCurrentTab()).fNu;
            }
            this.iCS.c(this.callFrom, this.iCU, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iCR.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.iCR.clW();
        hideLoadingView(this.iCR.clU());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.iCR != null) {
            if (!w.isEmpty(jVar.iEF) && !this.iCW) {
                this.iCY = jVar.iEF;
                this.iCX = new ArrayList();
                for (p pVar : jVar.iEF) {
                    j jVar2 = new j();
                    jVar2.type = pVar.fNu;
                    this.iCX.add(jVar2);
                }
            }
            if (w.isEmpty(this.iCX)) {
                this.iCX = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.iCX.size()) {
                        i2 = -1;
                        break;
                    } else if (this.iCX.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.iEF = this.iCY;
                } else if (w.isEmpty(this.iCX.get(0).iEF)) {
                    this.iCX.get(0).iEF = this.iCY;
                }
                this.iCX.add(i2, jVar);
                this.iCX.remove(i2 + 1);
            }
            this.iCR.di(this.iCX);
            if (!this.iCW && !w.isEmpty(this.iCX) && !w.isEmpty(this.iCX.get(0).iEF) && !w.isEmpty(this.iCY)) {
                this.iCW = true;
                this.iCR.clS();
                if (i2 >= 0) {
                    this.iCR.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.iCU)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.iCU);
        }
    }

    private void clf() {
        showLoadingView(this.iCR.clU(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.iCR.clU());
            showNetRefreshView(this.iCR.clU(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.iCR.xG(0);
            this.iCR.xH(8);
            this.iCR.xI(8);
            return;
        }
        this.iCR.xG(8);
        this.iCR.xH(0);
        this.iCR.xI(0);
        cle();
    }

    public void clg() {
        p pVar;
        if (!w.isEmpty(this.iCY) && (pVar = this.iCY.get(this.iCR.getCurrentTab())) != null) {
            this.iCT.b(null, pVar.shareTitle, pVar.shareUrl, pVar.iyd, pVar.iEV, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.iCR.clU());
            clf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        clh();
    }

    private void clh() {
        if (this.iCR != null) {
            this.iCR.clV();
        }
    }

    private void cli() {
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
        cli();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new ao("c10818").dk("obj_duration", "" + (System.currentTimeMillis() - this.iCV)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.iCR.clX()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
