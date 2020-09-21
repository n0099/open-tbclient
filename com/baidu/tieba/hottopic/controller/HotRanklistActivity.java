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
/* loaded from: classes20.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private com.baidu.tieba.hottopic.view.b jgH;
    private HotRanklistModel jgI;
    private b jgJ;
    private List<j> jgN;
    private List<p> jgO;
    private String callFrom = "";
    private String jgK = "";
    private long jgL = System.currentTimeMillis();
    private boolean jgM = false;
    private CustomMessageListener jgP = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a = HotRanklistActivity.this.jgH.a((p) data);
                    if (a >= 0) {
                        HotRanklistActivity.this.jgH.setCurrentTab(a);
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
        bNr();
        cDh();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.jgK = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.jgK = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.jgH = new com.baidu.tieba.hottopic.view.b(this);
        this.jgJ = new b(this);
        this.jgI = new HotRanklistModel(getPageContext());
        this.jgI.a(this);
    }

    private void bNr() {
        registerListener(this.jgP);
        this.jgH.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.jgI != null) {
                    j jVar = (j) HotRanklistActivity.this.jgN.get(HotRanklistActivity.this.jgH.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cDN())) {
                        HotRanklistActivity.this.jgH.bHn();
                        HotRanklistActivity.this.jgH.showLoadingView();
                        HotRanklistActivity.this.cDg();
                    }
                }
            }
        });
    }

    public void cDg() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jgH.cDY();
        } else if (this.jgI != null) {
            String str = this.jgM ? "0" : "1";
            if (!y.isEmpty(this.jgO)) {
                this.jgK = this.jgO.get(this.jgH.getCurrentTab()).gia;
            }
            this.jgI.c(this.callFrom, this.jgK, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jgH.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.jgH.cDY();
        hideLoadingView(this.jgH.cDW());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.jgH != null) {
            if (!y.isEmpty(jVar.jiv) && !this.jgM) {
                this.jgO = jVar.jiv;
                this.jgN = new ArrayList();
                for (p pVar : jVar.jiv) {
                    j jVar2 = new j();
                    jVar2.type = pVar.gia;
                    this.jgN.add(jVar2);
                }
            }
            if (y.isEmpty(this.jgN)) {
                this.jgN = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.jgN.size()) {
                        i2 = -1;
                        break;
                    } else if (this.jgN.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.jiv = this.jgO;
                } else if (y.isEmpty(this.jgN.get(0).jiv)) {
                    this.jgN.get(0).jiv = this.jgO;
                }
                this.jgN.add(i2, jVar);
                this.jgN.remove(i2 + 1);
            }
            this.jgH.dC(this.jgN);
            if (!this.jgM && !y.isEmpty(this.jgN) && !y.isEmpty(this.jgN.get(0).jiv) && !y.isEmpty(this.jgO)) {
                this.jgM = true;
                this.jgH.cDU();
                if (i2 >= 0) {
                    this.jgH.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.jgK)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.jgK);
        }
    }

    private void cDh() {
        showLoadingView(this.jgH.cDW(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.jgH.cDW());
            showNetRefreshView(this.jgH.cDW(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.jgH.AT(0);
            this.jgH.AU(8);
            this.jgH.AV(8);
            return;
        }
        this.jgH.AT(8);
        this.jgH.AU(0);
        this.jgH.AV(0);
        cDg();
    }

    public void cDi() {
        p pVar;
        if (!y.isEmpty(this.jgO) && (pVar = this.jgO.get(this.jgH.getCurrentTab())) != null) {
            this.jgJ.b(null, pVar.shareTitle, pVar.shareUrl, pVar.jbT, pVar.jiL, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.jgH.cDW());
            cDh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cDj();
    }

    private void cDj() {
        if (this.jgH != null) {
            this.jgH.cDX();
        }
    }

    private void cDk() {
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
        cDk();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new aq("c10818").dF("obj_duration", "" + (System.currentTimeMillis() - this.jgL)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jgH.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
