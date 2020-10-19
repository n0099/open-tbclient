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
/* loaded from: classes21.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private com.baidu.tieba.hottopic.view.b jvG;
    private HotRanklistModel jvH;
    private b jvI;
    private List<j> jvM;
    private List<p> jvN;
    private String callFrom = "";
    private String jvJ = "";
    private long jvK = System.currentTimeMillis();
    private boolean jvL = false;
    private CustomMessageListener jvO = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.jvG.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.jvG.setCurrentTab(a2);
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
        bQI();
        cGQ();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.jvJ = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.jvJ = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.jvG = new com.baidu.tieba.hottopic.view.b(this);
        this.jvI = new b(this);
        this.jvH = new HotRanklistModel(getPageContext());
        this.jvH.a(this);
    }

    private void bQI() {
        registerListener(this.jvO);
        this.jvG.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.jvH != null) {
                    j jVar = (j) HotRanklistActivity.this.jvM.get(HotRanklistActivity.this.jvG.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cHw())) {
                        HotRanklistActivity.this.jvG.SK();
                        HotRanklistActivity.this.jvG.showLoadingView();
                        HotRanklistActivity.this.cGP();
                    }
                }
            }
        });
    }

    public void cGP() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jvG.cHH();
        } else if (this.jvH != null) {
            String str = this.jvL ? "0" : "1";
            if (!y.isEmpty(this.jvN)) {
                this.jvJ = this.jvN.get(this.jvG.getCurrentTab()).guo;
            }
            this.jvH.f(this.callFrom, this.jvJ, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jvG.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.jvG.cHH();
        hideLoadingView(this.jvG.cHF());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.jvG != null) {
            if (!y.isEmpty(jVar.jxt) && !this.jvL) {
                this.jvN = jVar.jxt;
                this.jvM = new ArrayList();
                for (p pVar : jVar.jxt) {
                    j jVar2 = new j();
                    jVar2.type = pVar.guo;
                    this.jvM.add(jVar2);
                }
            }
            if (y.isEmpty(this.jvM)) {
                this.jvM = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.jvM.size()) {
                        i2 = -1;
                        break;
                    } else if (this.jvM.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.jxt = this.jvN;
                } else if (y.isEmpty(this.jvM.get(0).jxt)) {
                    this.jvM.get(0).jxt = this.jvN;
                }
                this.jvM.add(i2, jVar);
                this.jvM.remove(i2 + 1);
            }
            this.jvG.dF(this.jvM);
            if (!this.jvL && !y.isEmpty(this.jvM) && !y.isEmpty(this.jvM.get(0).jxt) && !y.isEmpty(this.jvN)) {
                this.jvL = true;
                this.jvG.cHD();
                if (i2 >= 0) {
                    this.jvG.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.jvJ)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.jvJ);
        }
    }

    private void cGQ() {
        showLoadingView(this.jvG.cHF(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.jvG.cHF());
            showNetRefreshView(this.jvG.cHF(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.jvG.Bz(0);
            this.jvG.BA(8);
            this.jvG.BB(8);
            return;
        }
        this.jvG.Bz(8);
        this.jvG.BA(0);
        this.jvG.BB(0);
        cGP();
    }

    public void cGR() {
        p pVar;
        if (!y.isEmpty(this.jvN) && (pVar = this.jvN.get(this.jvG.getCurrentTab())) != null) {
            this.jvI.c(null, pVar.shareTitle, pVar.shareUrl, pVar.jqS, pVar.jxJ, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.jvG.cHF());
            cGQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cGS();
    }

    private void cGS() {
        if (this.jvG != null) {
            this.jvG.cHG();
        }
    }

    private void cGT() {
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
        cGT();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new aq("c10818").dK("obj_duration", "" + (System.currentTimeMillis() - this.jvK)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jvG.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
