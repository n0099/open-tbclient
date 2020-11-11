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
    private com.baidu.tieba.hottopic.view.b jOd;
    private HotRanklistModel jOe;
    private b jOf;
    private List<j> jOj;
    private List<p> jOk;
    private String callFrom = "";
    private String jOg = "";
    private long jOh = System.currentTimeMillis();
    private boolean jOi = false;
    private CustomMessageListener jOl = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.jOd.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.jOd.setCurrentTab(a2);
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
        bWm();
        cMy();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.jOg = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.jOg = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.jOd = new com.baidu.tieba.hottopic.view.b(this);
        this.jOf = new b(this);
        this.jOe = new HotRanklistModel(getPageContext());
        this.jOe.a(this);
    }

    private void bWm() {
        registerListener(this.jOl);
        this.jOd.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.jOe != null) {
                    j jVar = (j) HotRanklistActivity.this.jOj.get(HotRanklistActivity.this.jOd.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cNe())) {
                        HotRanklistActivity.this.jOd.Wk();
                        HotRanklistActivity.this.jOd.showLoadingView();
                        HotRanklistActivity.this.cMx();
                    }
                }
            }
        });
    }

    public void cMx() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jOd.cNp();
        } else if (this.jOe != null) {
            String str = this.jOi ? "0" : "1";
            if (!y.isEmpty(this.jOk)) {
                this.jOg = this.jOk.get(this.jOd.getCurrentTab()).gKf;
            }
            this.jOe.f(this.callFrom, this.jOg, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jOd.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.jOd.cNp();
        hideLoadingView(this.jOd.cNn());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.jOd != null) {
            if (!y.isEmpty(jVar.jPQ) && !this.jOi) {
                this.jOk = jVar.jPQ;
                this.jOj = new ArrayList();
                for (p pVar : jVar.jPQ) {
                    j jVar2 = new j();
                    jVar2.type = pVar.gKf;
                    this.jOj.add(jVar2);
                }
            }
            if (y.isEmpty(this.jOj)) {
                this.jOj = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.jOj.size()) {
                        i2 = -1;
                        break;
                    } else if (this.jOj.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.jPQ = this.jOk;
                } else if (y.isEmpty(this.jOj.get(0).jPQ)) {
                    this.jOj.get(0).jPQ = this.jOk;
                }
                this.jOj.add(i2, jVar);
                this.jOj.remove(i2 + 1);
            }
            this.jOd.dW(this.jOj);
            if (!this.jOi && !y.isEmpty(this.jOj) && !y.isEmpty(this.jOj.get(0).jPQ) && !y.isEmpty(this.jOk)) {
                this.jOi = true;
                this.jOd.cNl();
                if (i2 >= 0) {
                    this.jOd.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.jOg)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.jOg);
        }
    }

    private void cMy() {
        showLoadingView(this.jOd.cNn(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.jOd.cNn());
            showNetRefreshView(this.jOd.cNn(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.jOd.Cf(0);
            this.jOd.Cg(8);
            this.jOd.Ch(8);
            return;
        }
        this.jOd.Cf(8);
        this.jOd.Cg(0);
        this.jOd.Ch(0);
        cMx();
    }

    public void cMz() {
        p pVar;
        if (!y.isEmpty(this.jOk) && (pVar = this.jOk.get(this.jOd.getCurrentTab())) != null) {
            this.jOf.b(null, pVar.shareTitle, pVar.shareUrl, pVar.jJp, pVar.jQg, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.jOd.cNn());
            cMy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cMA();
    }

    private void cMA() {
        if (this.jOd != null) {
            this.jOd.cNo();
        }
    }

    private void cMB() {
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
        cMB();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new aq("c10818").dR("obj_duration", "" + (System.currentTimeMillis() - this.jOh)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jOd.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
