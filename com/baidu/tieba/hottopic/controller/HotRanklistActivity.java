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
    private com.baidu.tieba.hottopic.view.b kcs;
    private HotRanklistModel kct;
    private b kcu;
    private List<j> kcy;
    private List<p> kcz;
    private String callFrom = "";
    private String kcv = "";
    private long kcw = System.currentTimeMillis();
    private boolean kcx = false;
    private CustomMessageListener kcA = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.kcs.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.kcs.setCurrentTab(a2);
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
        bZq();
        cRu();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.kcv = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.kcv = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.kcs = new com.baidu.tieba.hottopic.view.b(this);
        this.kcu = new b(this);
        this.kct = new HotRanklistModel(getPageContext());
        this.kct.a(this);
    }

    private void bZq() {
        registerListener(this.kcA);
        this.kcs.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.kct != null) {
                    j jVar = (j) HotRanklistActivity.this.kcy.get(HotRanklistActivity.this.kcs.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cSa())) {
                        HotRanklistActivity.this.kcs.Yb();
                        HotRanklistActivity.this.kcs.showLoadingView();
                        HotRanklistActivity.this.cRt();
                    }
                }
            }
        });
    }

    public void cRt() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.kcs.cSk();
        } else if (this.kct != null) {
            String str = this.kcx ? "0" : "1";
            if (!y.isEmpty(this.kcz)) {
                this.kcv = this.kcz.get(this.kcs.getCurrentTab()).gSZ;
            }
            this.kct.g(this.callFrom, this.kcv, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kcs.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.kcs.cSk();
        hideLoadingView(this.kcs.cSi());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.kcs != null) {
            if (!y.isEmpty(jVar.kef) && !this.kcx) {
                this.kcz = jVar.kef;
                this.kcy = new ArrayList();
                for (p pVar : jVar.kef) {
                    j jVar2 = new j();
                    jVar2.type = pVar.gSZ;
                    this.kcy.add(jVar2);
                }
            }
            if (y.isEmpty(this.kcy)) {
                this.kcy = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.kcy.size()) {
                        i2 = -1;
                        break;
                    } else if (this.kcy.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.kef = this.kcz;
                } else if (y.isEmpty(this.kcy.get(0).kef)) {
                    this.kcy.get(0).kef = this.kcz;
                }
                this.kcy.add(i2, jVar);
                this.kcy.remove(i2 + 1);
            }
            this.kcs.eh(this.kcy);
            if (!this.kcx && !y.isEmpty(this.kcy) && !y.isEmpty(this.kcy.get(0).kef) && !y.isEmpty(this.kcz)) {
                this.kcx = true;
                this.kcs.cSh();
                if (i2 >= 0) {
                    this.kcs.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.kcv)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.kcv);
        }
    }

    private void cRu() {
        showLoadingView(this.kcs.cSi(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.kcs.cSi());
            showNetRefreshView(this.kcs.cSi(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.kcs.Ds(0);
            this.kcs.Dt(8);
            this.kcs.Du(8);
            return;
        }
        this.kcs.Ds(8);
        this.kcs.Dt(0);
        this.kcs.Du(0);
        cRt();
    }

    public void cRv() {
        p pVar;
        if (!y.isEmpty(this.kcz) && (pVar = this.kcz.get(this.kcs.getCurrentTab())) != null) {
            this.kcu.a((String) null, pVar.shareTitle, pVar.shareUrl, pVar.jXF, pVar.kev, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.kcs.cSi());
            cRu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cRw();
    }

    private void cRw() {
        if (this.kcs != null) {
            this.kcs.cSj();
        }
    }

    private void cRx() {
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
        cRx();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new ar("c10818").dY("obj_duration", "" + (System.currentTimeMillis() - this.kcw)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kcs.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
