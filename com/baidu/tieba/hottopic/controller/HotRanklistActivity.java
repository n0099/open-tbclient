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
    private List<j> ktA;
    private List<p> ktB;
    private com.baidu.tieba.hottopic.view.b ktu;
    private HotRanklistModel ktv;
    private b ktw;
    private String callFrom = "";
    private String ktx = "";
    private long kty = System.currentTimeMillis();
    private boolean ktz = false;
    private CustomMessageListener ktC = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.ktu.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.ktu.setCurrentTab(a2);
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
        bZl();
        cSP();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.ktx = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.ktx = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.ktu = new com.baidu.tieba.hottopic.view.b(this);
        this.ktw = new b(this);
        this.ktv = new HotRanklistModel(getPageContext());
        this.ktv.a(this);
    }

    private void bZl() {
        registerListener(this.ktC);
        this.ktu.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.ktv != null) {
                    j jVar = (j) HotRanklistActivity.this.ktA.get(HotRanklistActivity.this.ktu.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cTv())) {
                        HotRanklistActivity.this.ktu.WZ();
                        HotRanklistActivity.this.ktu.showLoadingView();
                        HotRanklistActivity.this.cSO();
                    }
                }
            }
        });
    }

    public void cSO() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.ktu.cTF();
        } else if (this.ktv != null) {
            String str = this.ktz ? "0" : "1";
            if (!y.isEmpty(this.ktB)) {
                this.ktx = this.ktB.get(this.ktu.getCurrentTab()).hde;
            }
            this.ktv.f(this.callFrom, this.ktx, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ktu.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.ktu.cTF();
        hideLoadingView(this.ktu.cTD());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.ktu != null) {
            if (!y.isEmpty(jVar.kvi) && !this.ktz) {
                this.ktB = jVar.kvi;
                this.ktA = new ArrayList();
                for (p pVar : jVar.kvi) {
                    j jVar2 = new j();
                    jVar2.type = pVar.hde;
                    this.ktA.add(jVar2);
                }
            }
            if (y.isEmpty(this.ktA)) {
                this.ktA = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.ktA.size()) {
                        i2 = -1;
                        break;
                    } else if (this.ktA.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.kvi = this.ktB;
                } else if (y.isEmpty(this.ktA.get(0).kvi)) {
                    this.ktA.get(0).kvi = this.ktB;
                }
                this.ktA.add(i2, jVar);
                this.ktA.remove(i2 + 1);
            }
            this.ktu.em(this.ktA);
            if (!this.ktz && !y.isEmpty(this.ktA) && !y.isEmpty(this.ktA.get(0).kvi) && !y.isEmpty(this.ktB)) {
                this.ktz = true;
                this.ktu.cTC();
                if (i2 >= 0) {
                    this.ktu.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.ktx)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.ktx);
        }
    }

    private void cSP() {
        showLoadingView(this.ktu.cTD(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.ktu.cTD());
            showNetRefreshView(this.ktu.cTD(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.ktu.Cr(0);
            this.ktu.Cs(8);
            this.ktu.Ct(8);
            return;
        }
        this.ktu.Cr(8);
        this.ktu.Cs(0);
        this.ktu.Ct(0);
        cSO();
    }

    public void cSQ() {
        p pVar;
        if (!y.isEmpty(this.ktB) && (pVar = this.ktB.get(this.ktu.getCurrentTab())) != null) {
            this.ktw.a((String) null, pVar.shareTitle, pVar.shareUrl, pVar.koH, pVar.kvy, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.ktu.cTD());
            cSP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cSR();
    }

    private void cSR() {
        if (this.ktu != null) {
            this.ktu.cTE();
        }
    }

    private void cSS() {
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
        cSS();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new ar("c10818").dR("obj_duration", "" + (System.currentTimeMillis() - this.kty)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ktu.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
