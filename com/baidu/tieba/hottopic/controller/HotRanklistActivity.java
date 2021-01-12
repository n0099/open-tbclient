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
/* loaded from: classes7.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private com.baidu.tieba.hottopic.view.b kkZ;
    private HotRanklistModel kla;
    private b klb;
    private List<j> klf;
    private List<p> klg;
    private String callFrom = "";
    private String klc = "";
    private long kld = System.currentTimeMillis();
    private boolean kle = false;
    private CustomMessageListener klh = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.kkZ.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.kkZ.setCurrentTab(a2);
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
        bYg();
        cQJ();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.klc = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.klc = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.kkZ = new com.baidu.tieba.hottopic.view.b(this);
        this.klb = new b(this);
        this.kla = new HotRanklistModel(getPageContext());
        this.kla.a(this);
    }

    private void bYg() {
        registerListener(this.klh);
        this.kkZ.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.kla != null) {
                    j jVar = (j) HotRanklistActivity.this.klf.get(HotRanklistActivity.this.kkZ.getCurrentTab());
                    if (jVar == null || x.isEmpty(jVar.cRp())) {
                        HotRanklistActivity.this.kkZ.Vq();
                        HotRanklistActivity.this.kkZ.showLoadingView();
                        HotRanklistActivity.this.cQI();
                    }
                }
            }
        });
    }

    public void cQI() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.kkZ.cRz();
        } else if (this.kla != null) {
            String str = this.kle ? "0" : "1";
            if (!x.isEmpty(this.klg)) {
                this.klc = this.klg.get(this.kkZ.getCurrentTab()).hag;
            }
            this.kla.g(this.callFrom, this.klc, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kkZ.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.kkZ.cRz();
        hideLoadingView(this.kkZ.cRx());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.kkZ != null) {
            if (!x.isEmpty(jVar.kmN) && !this.kle) {
                this.klg = jVar.kmN;
                this.klf = new ArrayList();
                for (p pVar : jVar.kmN) {
                    j jVar2 = new j();
                    jVar2.type = pVar.hag;
                    this.klf.add(jVar2);
                }
            }
            if (x.isEmpty(this.klf)) {
                this.klf = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.klf.size()) {
                        i2 = -1;
                        break;
                    } else if (this.klf.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.kmN = this.klg;
                } else if (x.isEmpty(this.klf.get(0).kmN)) {
                    this.klf.get(0).kmN = this.klg;
                }
                this.klf.add(i2, jVar);
                this.klf.remove(i2 + 1);
            }
            this.kkZ.eo(this.klf);
            if (!this.kle && !x.isEmpty(this.klf) && !x.isEmpty(this.klf.get(0).kmN) && !x.isEmpty(this.klg)) {
                this.kle = true;
                this.kkZ.cRw();
                if (i2 >= 0) {
                    this.kkZ.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.klc)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.klc);
        }
    }

    private void cQJ() {
        showLoadingView(this.kkZ.cRx(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.kkZ.cRx());
            showNetRefreshView(this.kkZ.cRx(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.kkZ.Ca(0);
            this.kkZ.Cb(8);
            this.kkZ.Cc(8);
            return;
        }
        this.kkZ.Ca(8);
        this.kkZ.Cb(0);
        this.kkZ.Cc(0);
        cQI();
    }

    public void cQK() {
        p pVar;
        if (!x.isEmpty(this.klg) && (pVar = this.klg.get(this.kkZ.getCurrentTab())) != null) {
            this.klb.a((String) null, pVar.shareTitle, pVar.shareUrl, pVar.kgl, pVar.knd, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.kkZ.cRx());
            cQJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cQL();
    }

    private void cQL() {
        if (this.kkZ != null) {
            this.kkZ.cRy();
        }
    }

    private void cQM() {
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
        cQM();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new aq("c10818").dW("obj_duration", "" + (System.currentTimeMillis() - this.kld)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kkZ.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
