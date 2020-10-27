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
    private com.baidu.tieba.hottopic.view.b jIf;
    private HotRanklistModel jIg;
    private b jIh;
    private List<j> jIl;
    private List<p> jIm;
    private String callFrom = "";
    private String jIi = "";
    private long jIj = System.currentTimeMillis();
    private boolean jIk = false;
    private CustomMessageListener jIn = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.jIf.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.jIf.setCurrentTab(a2);
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
        bTF();
        cJX();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.jIi = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.jIi = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.jIf = new com.baidu.tieba.hottopic.view.b(this);
        this.jIh = new b(this);
        this.jIg = new HotRanklistModel(getPageContext());
        this.jIg.a(this);
    }

    private void bTF() {
        registerListener(this.jIn);
        this.jIf.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.jIg != null) {
                    j jVar = (j) HotRanklistActivity.this.jIl.get(HotRanklistActivity.this.jIf.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cKD())) {
                        HotRanklistActivity.this.jIf.TK();
                        HotRanklistActivity.this.jIf.showLoadingView();
                        HotRanklistActivity.this.cJW();
                    }
                }
            }
        });
    }

    public void cJW() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jIf.cKO();
        } else if (this.jIg != null) {
            String str = this.jIk ? "0" : "1";
            if (!y.isEmpty(this.jIm)) {
                this.jIi = this.jIm.get(this.jIf.getCurrentTab()).gEs;
            }
            this.jIg.f(this.callFrom, this.jIi, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jIf.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.jIf.cKO();
        hideLoadingView(this.jIf.cKM());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.jIf != null) {
            if (!y.isEmpty(jVar.jJS) && !this.jIk) {
                this.jIm = jVar.jJS;
                this.jIl = new ArrayList();
                for (p pVar : jVar.jJS) {
                    j jVar2 = new j();
                    jVar2.type = pVar.gEs;
                    this.jIl.add(jVar2);
                }
            }
            if (y.isEmpty(this.jIl)) {
                this.jIl = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.jIl.size()) {
                        i2 = -1;
                        break;
                    } else if (this.jIl.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.jJS = this.jIm;
                } else if (y.isEmpty(this.jIl.get(0).jJS)) {
                    this.jIl.get(0).jJS = this.jIm;
                }
                this.jIl.add(i2, jVar);
                this.jIl.remove(i2 + 1);
            }
            this.jIf.dO(this.jIl);
            if (!this.jIk && !y.isEmpty(this.jIl) && !y.isEmpty(this.jIl.get(0).jJS) && !y.isEmpty(this.jIm)) {
                this.jIk = true;
                this.jIf.cKK();
                if (i2 >= 0) {
                    this.jIf.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.jIi)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.jIi);
        }
    }

    private void cJX() {
        showLoadingView(this.jIf.cKM(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.jIf.cKM());
            showNetRefreshView(this.jIf.cKM(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.jIf.BS(0);
            this.jIf.BT(8);
            this.jIf.BU(8);
            return;
        }
        this.jIf.BS(8);
        this.jIf.BT(0);
        this.jIf.BU(0);
        cJW();
    }

    public void cJY() {
        p pVar;
        if (!y.isEmpty(this.jIm) && (pVar = this.jIm.get(this.jIf.getCurrentTab())) != null) {
            this.jIh.b(null, pVar.shareTitle, pVar.shareUrl, pVar.jDs, pVar.jKi, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.jIf.cKM());
            cJX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cJZ();
    }

    private void cJZ() {
        if (this.jIf != null) {
            this.jIf.cKN();
        }
    }

    private void cKa() {
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
        cKa();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new aq("c10818").dR("obj_duration", "" + (System.currentTimeMillis() - this.jIj)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jIf.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
