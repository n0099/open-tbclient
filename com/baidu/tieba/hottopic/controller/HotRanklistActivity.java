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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private com.baidu.tieba.hottopic.view.b ktg;
    private HotRanklistModel kth;
    private b kti;
    private List<j> ktm;
    private List<p> ktn;
    private String callFrom = "";
    private String ktj = "";
    private long ktk = System.currentTimeMillis();
    private boolean ktl = false;
    private CustomMessageListener kto = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.ktg.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.ktg.setCurrentTab(a2);
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
        bZe();
        cSI();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.ktj = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.ktj = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.ktg = new com.baidu.tieba.hottopic.view.b(this);
        this.kti = new b(this);
        this.kth = new HotRanklistModel(getPageContext());
        this.kth.a(this);
    }

    private void bZe() {
        registerListener(this.kto);
        this.ktg.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.kth != null) {
                    j jVar = (j) HotRanklistActivity.this.ktm.get(HotRanklistActivity.this.ktg.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cTo())) {
                        HotRanklistActivity.this.ktg.WZ();
                        HotRanklistActivity.this.ktg.showLoadingView();
                        HotRanklistActivity.this.cSH();
                    }
                }
            }
        });
    }

    public void cSH() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.ktg.cTy();
        } else if (this.kth != null) {
            String str = this.ktl ? "0" : "1";
            if (!y.isEmpty(this.ktn)) {
                this.ktj = this.ktn.get(this.ktg.getCurrentTab()).hcQ;
            }
            this.kth.f(this.callFrom, this.ktj, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ktg.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.ktg.cTy();
        hideLoadingView(this.ktg.cTw());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.ktg != null) {
            if (!y.isEmpty(jVar.kuU) && !this.ktl) {
                this.ktn = jVar.kuU;
                this.ktm = new ArrayList();
                for (p pVar : jVar.kuU) {
                    j jVar2 = new j();
                    jVar2.type = pVar.hcQ;
                    this.ktm.add(jVar2);
                }
            }
            if (y.isEmpty(this.ktm)) {
                this.ktm = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.ktm.size()) {
                        i2 = -1;
                        break;
                    } else if (this.ktm.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.kuU = this.ktn;
                } else if (y.isEmpty(this.ktm.get(0).kuU)) {
                    this.ktm.get(0).kuU = this.ktn;
                }
                this.ktm.add(i2, jVar);
                this.ktm.remove(i2 + 1);
            }
            this.ktg.em(this.ktm);
            if (!this.ktl && !y.isEmpty(this.ktm) && !y.isEmpty(this.ktm.get(0).kuU) && !y.isEmpty(this.ktn)) {
                this.ktl = true;
                this.ktg.cTv();
                if (i2 >= 0) {
                    this.ktg.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.ktj)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.ktj);
        }
    }

    private void cSI() {
        showLoadingView(this.ktg.cTw(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.ktg.cTw());
            showNetRefreshView(this.ktg.cTw(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.ktg.Cr(0);
            this.ktg.Cs(8);
            this.ktg.Ct(8);
            return;
        }
        this.ktg.Cr(8);
        this.ktg.Cs(0);
        this.ktg.Ct(0);
        cSH();
    }

    public void cSJ() {
        p pVar;
        if (!y.isEmpty(this.ktn) && (pVar = this.ktn.get(this.ktg.getCurrentTab())) != null) {
            this.kti.a((String) null, pVar.shareTitle, pVar.shareUrl, pVar.kot, pVar.kvk, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.ktg.cTw());
            cSI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cSK();
    }

    private void cSK() {
        if (this.ktg != null) {
            this.ktg.cTx();
        }
    }

    private void cSL() {
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
        cSL();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new ar("c10818").dR("obj_duration", "" + (System.currentTimeMillis() - this.ktk)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ktg.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
