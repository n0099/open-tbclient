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
    private com.baidu.tieba.hottopic.view.b iXV;
    private HotRanklistModel iXW;
    private b iXX;
    private List<j> iYb;
    private List<p> iYc;
    private String callFrom = "";
    private String iXY = "";
    private long iXZ = System.currentTimeMillis();
    private boolean iYa = false;
    private CustomMessageListener iYd = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a = HotRanklistActivity.this.iXV.a((p) data);
                    if (a >= 0) {
                        HotRanklistActivity.this.iXV.setCurrentTab(a);
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
        bMg();
        czz();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.iXY = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.iXY = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.iXV = new com.baidu.tieba.hottopic.view.b(this);
        this.iXX = new b(this);
        this.iXW = new HotRanklistModel(getPageContext());
        this.iXW.a(this);
    }

    private void bMg() {
        registerListener(this.iYd);
        this.iXV.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.iXW != null) {
                    j jVar = (j) HotRanklistActivity.this.iYb.get(HotRanklistActivity.this.iXV.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cAf())) {
                        HotRanklistActivity.this.iXV.bFW();
                        HotRanklistActivity.this.iXV.showLoadingView();
                        HotRanklistActivity.this.czy();
                    }
                }
            }
        });
    }

    public void czy() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.iXV.cAq();
        } else if (this.iXW != null) {
            String str = this.iYa ? "0" : "1";
            if (!y.isEmpty(this.iYc)) {
                this.iXY = this.iYc.get(this.iXV.getCurrentTab()).geM;
            }
            this.iXW.c(this.callFrom, this.iXY, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iXV.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.iXV.cAq();
        hideLoadingView(this.iXV.cAo());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.iXV != null) {
            if (!y.isEmpty(jVar.iZJ) && !this.iYa) {
                this.iYc = jVar.iZJ;
                this.iYb = new ArrayList();
                for (p pVar : jVar.iZJ) {
                    j jVar2 = new j();
                    jVar2.type = pVar.geM;
                    this.iYb.add(jVar2);
                }
            }
            if (y.isEmpty(this.iYb)) {
                this.iYb = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.iYb.size()) {
                        i2 = -1;
                        break;
                    } else if (this.iYb.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.iZJ = this.iYc;
                } else if (y.isEmpty(this.iYb.get(0).iZJ)) {
                    this.iYb.get(0).iZJ = this.iYc;
                }
                this.iYb.add(i2, jVar);
                this.iYb.remove(i2 + 1);
            }
            this.iXV.du(this.iYb);
            if (!this.iYa && !y.isEmpty(this.iYb) && !y.isEmpty(this.iYb.get(0).iZJ) && !y.isEmpty(this.iYc)) {
                this.iYa = true;
                this.iXV.cAm();
                if (i2 >= 0) {
                    this.iXV.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.iXY)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.iXY);
        }
    }

    private void czz() {
        showLoadingView(this.iXV.cAo(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.iXV.cAo());
            showNetRefreshView(this.iXV.cAo(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.iXV.As(0);
            this.iXV.At(8);
            this.iXV.Au(8);
            return;
        }
        this.iXV.As(8);
        this.iXV.At(0);
        this.iXV.Au(0);
        czy();
    }

    public void czA() {
        p pVar;
        if (!y.isEmpty(this.iYc) && (pVar = this.iYc.get(this.iXV.getCurrentTab())) != null) {
            this.iXX.b(null, pVar.shareTitle, pVar.shareUrl, pVar.iTh, pVar.iZZ, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.iXV.cAo());
            czz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        czB();
    }

    private void czB() {
        if (this.iXV != null) {
            this.iXV.cAp();
        }
    }

    private void czC() {
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
        czC();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new aq("c10818").dD("obj_duration", "" + (System.currentTimeMillis() - this.iXZ)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.iXV.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
