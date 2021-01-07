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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private com.baidu.tieba.hottopic.view.b kpE;
    private HotRanklistModel kpF;
    private b kpG;
    private List<j> kpK;
    private List<p> kpL;
    private String callFrom = "";
    private String kpH = "";
    private long kpI = System.currentTimeMillis();
    private boolean kpJ = false;
    private CustomMessageListener kpM = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.kpE.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.kpE.setCurrentTab(a2);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        initUI();
        cbY();
        cUB();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.kpH = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.kpH = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.kpE = new com.baidu.tieba.hottopic.view.b(this);
        this.kpG = new b(this);
        this.kpF = new HotRanklistModel(getPageContext());
        this.kpF.a(this);
    }

    private void cbY() {
        registerListener(this.kpM);
        this.kpE.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.kpF != null) {
                    j jVar = (j) HotRanklistActivity.this.kpK.get(HotRanklistActivity.this.kpE.getCurrentTab());
                    if (jVar == null || x.isEmpty(jVar.cVh())) {
                        HotRanklistActivity.this.kpE.Zj();
                        HotRanklistActivity.this.kpE.showLoadingView();
                        HotRanklistActivity.this.cUA();
                    }
                }
            }
        });
    }

    public void cUA() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.kpE.cVr();
        } else if (this.kpF != null) {
            String str = this.kpJ ? "0" : "1";
            if (!x.isEmpty(this.kpL)) {
                this.kpH = this.kpL.get(this.kpE.getCurrentTab()).heM;
            }
            this.kpF.g(this.callFrom, this.kpH, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kpE.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.kpE.cVr();
        hideLoadingView(this.kpE.cVp());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.kpE != null) {
            if (!x.isEmpty(jVar.krs) && !this.kpJ) {
                this.kpL = jVar.krs;
                this.kpK = new ArrayList();
                for (p pVar : jVar.krs) {
                    j jVar2 = new j();
                    jVar2.type = pVar.heM;
                    this.kpK.add(jVar2);
                }
            }
            if (x.isEmpty(this.kpK)) {
                this.kpK = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.kpK.size()) {
                        i2 = -1;
                        break;
                    } else if (this.kpK.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.krs = this.kpL;
                } else if (x.isEmpty(this.kpK.get(0).krs)) {
                    this.kpK.get(0).krs = this.kpL;
                }
                this.kpK.add(i2, jVar);
                this.kpK.remove(i2 + 1);
            }
            this.kpE.eo(this.kpK);
            if (!this.kpJ && !x.isEmpty(this.kpK) && !x.isEmpty(this.kpK.get(0).krs) && !x.isEmpty(this.kpL)) {
                this.kpJ = true;
                this.kpE.cVo();
                if (i2 >= 0) {
                    this.kpE.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.kpH)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.kpH);
        }
    }

    private void cUB() {
        showLoadingView(this.kpE.cVp(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.kpE.cVp());
            showNetRefreshView(this.kpE.cVp(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.kpE.DG(0);
            this.kpE.DH(8);
            this.kpE.DI(8);
            return;
        }
        this.kpE.DG(8);
        this.kpE.DH(0);
        this.kpE.DI(0);
        cUA();
    }

    public void cUC() {
        p pVar;
        if (!x.isEmpty(this.kpL) && (pVar = this.kpL.get(this.kpE.getCurrentTab())) != null) {
            this.kpG.a((String) null, pVar.shareTitle, pVar.shareUrl, pVar.kkR, pVar.krI, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.kpE.cVp());
            cUB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cUD();
    }

    private void cUD() {
        if (this.kpE != null) {
            this.kpE.cVq();
        }
    }

    private void cUE() {
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
        cUE();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new aq("c10818").dX("obj_duration", "" + (System.currentTimeMillis() - this.kpI)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kpE.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
