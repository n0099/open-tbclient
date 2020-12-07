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
/* loaded from: classes21.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private com.baidu.tieba.hottopic.view.b kcq;
    private HotRanklistModel kcr;
    private b kcs;
    private List<j> kcw;
    private List<p> kcx;
    private String callFrom = "";
    private String kct = "";
    private long kcu = System.currentTimeMillis();
    private boolean kcv = false;
    private CustomMessageListener kcy = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.kcq.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.kcq.setCurrentTab(a2);
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
        bZp();
        cRt();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.kct = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.kct = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.kcq = new com.baidu.tieba.hottopic.view.b(this);
        this.kcs = new b(this);
        this.kcr = new HotRanklistModel(getPageContext());
        this.kcr.a(this);
    }

    private void bZp() {
        registerListener(this.kcy);
        this.kcq.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.kcr != null) {
                    j jVar = (j) HotRanklistActivity.this.kcw.get(HotRanklistActivity.this.kcq.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cRZ())) {
                        HotRanklistActivity.this.kcq.Yb();
                        HotRanklistActivity.this.kcq.showLoadingView();
                        HotRanklistActivity.this.cRs();
                    }
                }
            }
        });
    }

    public void cRs() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.kcq.cSj();
        } else if (this.kcr != null) {
            String str = this.kcv ? "0" : "1";
            if (!y.isEmpty(this.kcx)) {
                this.kct = this.kcx.get(this.kcq.getCurrentTab()).gSX;
            }
            this.kcr.g(this.callFrom, this.kct, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kcq.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.kcq.cSj();
        hideLoadingView(this.kcq.cSh());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.kcq != null) {
            if (!y.isEmpty(jVar.ked) && !this.kcv) {
                this.kcx = jVar.ked;
                this.kcw = new ArrayList();
                for (p pVar : jVar.ked) {
                    j jVar2 = new j();
                    jVar2.type = pVar.gSX;
                    this.kcw.add(jVar2);
                }
            }
            if (y.isEmpty(this.kcw)) {
                this.kcw = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.kcw.size()) {
                        i2 = -1;
                        break;
                    } else if (this.kcw.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.ked = this.kcx;
                } else if (y.isEmpty(this.kcw.get(0).ked)) {
                    this.kcw.get(0).ked = this.kcx;
                }
                this.kcw.add(i2, jVar);
                this.kcw.remove(i2 + 1);
            }
            this.kcq.eh(this.kcw);
            if (!this.kcv && !y.isEmpty(this.kcw) && !y.isEmpty(this.kcw.get(0).ked) && !y.isEmpty(this.kcx)) {
                this.kcv = true;
                this.kcq.cSg();
                if (i2 >= 0) {
                    this.kcq.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.kct)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.kct);
        }
    }

    private void cRt() {
        showLoadingView(this.kcq.cSh(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.kcq.cSh());
            showNetRefreshView(this.kcq.cSh(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.kcq.Ds(0);
            this.kcq.Dt(8);
            this.kcq.Du(8);
            return;
        }
        this.kcq.Ds(8);
        this.kcq.Dt(0);
        this.kcq.Du(0);
        cRs();
    }

    public void cRu() {
        p pVar;
        if (!y.isEmpty(this.kcx) && (pVar = this.kcx.get(this.kcq.getCurrentTab())) != null) {
            this.kcs.a((String) null, pVar.shareTitle, pVar.shareUrl, pVar.jXD, pVar.ket, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.kcq.cSh());
            cRt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cRv();
    }

    private void cRv() {
        if (this.kcq != null) {
            this.kcq.cSi();
        }
    }

    private void cRw() {
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
        cRw();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new ar("c10818").dY("obj_duration", "" + (System.currentTimeMillis() - this.kcu)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kcq.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
