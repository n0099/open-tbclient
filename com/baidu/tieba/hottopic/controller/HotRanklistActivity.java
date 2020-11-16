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
/* loaded from: classes20.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private com.baidu.tieba.hottopic.view.b jON;
    private HotRanklistModel jOO;
    private b jOP;
    private List<j> jOT;
    private List<p> jOU;
    private String callFrom = "";
    private String jOQ = "";
    private long jOR = System.currentTimeMillis();
    private boolean jOS = false;
    private CustomMessageListener jOV = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.jON.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.jON.setCurrentTab(a2);
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
        bVF();
        cMf();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.jOQ = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.jOQ = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.jON = new com.baidu.tieba.hottopic.view.b(this);
        this.jOP = new b(this);
        this.jOO = new HotRanklistModel(getPageContext());
        this.jOO.a(this);
    }

    private void bVF() {
        registerListener(this.jOV);
        this.jON.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.jOO != null) {
                    j jVar = (j) HotRanklistActivity.this.jOT.get(HotRanklistActivity.this.jON.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cML())) {
                        HotRanklistActivity.this.jON.VB();
                        HotRanklistActivity.this.jON.showLoadingView();
                        HotRanklistActivity.this.cMe();
                    }
                }
            }
        });
    }

    public void cMe() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jON.cMV();
        } else if (this.jOO != null) {
            String str = this.jOS ? "0" : "1";
            if (!y.isEmpty(this.jOU)) {
                this.jOQ = this.jOU.get(this.jON.getCurrentTab()).gJM;
            }
            this.jOO.f(this.callFrom, this.jOQ, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jON.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.jON.cMV();
        hideLoadingView(this.jON.cMT());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.jON != null) {
            if (!y.isEmpty(jVar.jQA) && !this.jOS) {
                this.jOU = jVar.jQA;
                this.jOT = new ArrayList();
                for (p pVar : jVar.jQA) {
                    j jVar2 = new j();
                    jVar2.type = pVar.gJM;
                    this.jOT.add(jVar2);
                }
            }
            if (y.isEmpty(this.jOT)) {
                this.jOT = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.jOT.size()) {
                        i2 = -1;
                        break;
                    } else if (this.jOT.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.jQA = this.jOU;
                } else if (y.isEmpty(this.jOT.get(0).jQA)) {
                    this.jOT.get(0).jQA = this.jOU;
                }
                this.jOT.add(i2, jVar);
                this.jOT.remove(i2 + 1);
            }
            this.jON.dW(this.jOT);
            if (!this.jOS && !y.isEmpty(this.jOT) && !y.isEmpty(this.jOT.get(0).jQA) && !y.isEmpty(this.jOU)) {
                this.jOS = true;
                this.jON.cMS();
                if (i2 >= 0) {
                    this.jON.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.jOQ)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.jOQ);
        }
    }

    private void cMf() {
        showLoadingView(this.jON.cMT(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.jON.cMT());
            showNetRefreshView(this.jON.cMT(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.jON.CD(0);
            this.jON.CE(8);
            this.jON.CF(8);
            return;
        }
        this.jON.CD(8);
        this.jON.CE(0);
        this.jON.CF(0);
        cMe();
    }

    public void cMg() {
        p pVar;
        if (!y.isEmpty(this.jOU) && (pVar = this.jOU.get(this.jON.getCurrentTab())) != null) {
            this.jOP.b(null, pVar.shareTitle, pVar.shareUrl, pVar.jKa, pVar.jQQ, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.jON.cMT());
            cMf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cMh();
    }

    private void cMh() {
        if (this.jON != null) {
            this.jON.cMU();
        }
    }

    private void cMi() {
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
        cMi();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new ar("c10818").dR("obj_duration", "" + (System.currentTimeMillis() - this.jOR)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jON.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
