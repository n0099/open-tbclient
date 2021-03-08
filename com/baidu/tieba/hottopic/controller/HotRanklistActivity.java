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
/* loaded from: classes7.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.a {
    private List<j> kvC;
    private List<p> kvD;
    private com.baidu.tieba.hottopic.view.b kvw;
    private HotRanklistModel kvx;
    private b kvy;
    private String callFrom = "";
    private String kvz = "";
    private long kvA = System.currentTimeMillis();
    private boolean kvB = false;
    private CustomMessageListener kvE = new CustomMessageListener(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof p) {
                    int a2 = HotRanklistActivity.this.kvw.a((p) data);
                    if (a2 >= 0) {
                        HotRanklistActivity.this.kvw.setCurrentTab(a2);
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
        bZr();
        cSW();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
            this.kvz = intent.getStringExtra("list_type");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
            this.kvz = bundle.getString("list_type");
        }
    }

    private void initUI() {
        this.kvw = new com.baidu.tieba.hottopic.view.b(this);
        this.kvy = new b(this);
        this.kvx = new HotRanklistModel(getPageContext());
        this.kvx.a(this);
    }

    private void bZr() {
        registerListener(this.kvE);
        this.kvw.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotRanklistActivity.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && HotRanklistActivity.this.kvx != null) {
                    j jVar = (j) HotRanklistActivity.this.kvC.get(HotRanklistActivity.this.kvw.getCurrentTab());
                    if (jVar == null || y.isEmpty(jVar.cTC())) {
                        HotRanklistActivity.this.kvw.Xc();
                        HotRanklistActivity.this.kvw.showLoadingView();
                        HotRanklistActivity.this.cSV();
                    }
                }
            }
        });
    }

    public void cSV() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.kvw.cTM();
        } else if (this.kvx != null) {
            String str = this.kvB ? "0" : "1";
            if (!y.isEmpty(this.kvD)) {
                this.kvz = this.kvD.get(this.kvw.getCurrentTab()).heN;
            }
            this.kvx.f(this.callFrom, this.kvz, str, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kvw.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
    public void a(boolean z, j jVar, int i, String str) {
        int i2;
        this.kvw.cTM();
        hideLoadingView(this.kvw.cTK());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.kvw != null) {
            if (!y.isEmpty(jVar.kxk) && !this.kvB) {
                this.kvD = jVar.kxk;
                this.kvC = new ArrayList();
                for (p pVar : jVar.kxk) {
                    j jVar2 = new j();
                    jVar2.type = pVar.heN;
                    this.kvC.add(jVar2);
                }
            }
            if (y.isEmpty(this.kvC)) {
                this.kvC = new ArrayList();
                i2 = -1;
            } else if (jVar == null) {
                i2 = -1;
            } else {
                i2 = 0;
                while (true) {
                    if (i2 >= this.kvC.size()) {
                        i2 = -1;
                        break;
                    } else if (this.kvC.get(i2).type.equals(jVar.type)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    jVar.kxk = this.kvD;
                } else if (y.isEmpty(this.kvC.get(0).kxk)) {
                    this.kvC.get(0).kxk = this.kvD;
                }
                this.kvC.add(i2, jVar);
                this.kvC.remove(i2 + 1);
            }
            this.kvw.em(this.kvC);
            if (!this.kvB && !y.isEmpty(this.kvC) && !y.isEmpty(this.kvC.get(0).kxk) && !y.isEmpty(this.kvD)) {
                this.kvB = true;
                this.kvw.cTJ();
                if (i2 >= 0) {
                    this.kvw.setCurrentTab(i2);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.callFrom) || !StringUtils.isNull(this.kvz)) {
            bundle.putString("call_from", this.callFrom);
            bundle.putString("list_type", this.kvz);
        }
    }

    private void cSW() {
        showLoadingView(this.kvw.cTK(), true);
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.kvw.cTK());
            showNetRefreshView(this.kvw.cTK(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.getDimens(getActivity(), R.dimen.ds350));
            this.kvw.Cu(0);
            this.kvw.Cv(8);
            this.kvw.Cw(8);
            return;
        }
        this.kvw.Cu(8);
        this.kvw.Cv(0);
        this.kvw.Cw(0);
        cSV();
    }

    public void cSX() {
        p pVar;
        if (!y.isEmpty(this.kvD) && (pVar = this.kvD.get(this.kvw.getCurrentTab())) != null) {
            this.kvy.a((String) null, pVar.shareTitle, pVar.shareUrl, pVar.kqJ, pVar.kxA, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            hideNetRefreshView(this.kvw.cTK());
            cSW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY));
        cSY();
    }

    private void cSY() {
        if (this.kvw != null) {
            this.kvw.cTL();
        }
    }

    private void cSZ() {
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
        cSZ();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new ar("c10818").dR("obj_duration", "" + (System.currentTimeMillis() - this.kvA)));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC_TANK;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kvw.onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
