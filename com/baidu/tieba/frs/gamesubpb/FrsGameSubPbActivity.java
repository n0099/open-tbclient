package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private com.baidu.tieba.frs.gamesubpb.view.a fmV;
    private c fmW;
    private com.baidu.tieba.frs.gamesubpb.model.a fmX;
    private boolean fmY;
    private boolean fmZ;
    private String fna;
    private View.OnClickListener mCommonClickListener;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        aNG();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.fna)) {
            finish();
        }
        bgy();
        this.fmV = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.fna);
        setContentView(this.fmV.getRootView());
        this.fmW = new c(this, this.fmV.getListView(), this.fmV.aDm());
        this.fmW.bgD();
        this.fmW.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean fnb = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bgz() {
                FrsGameSubPbActivity.this.fmV.jH(false);
                this.fnb = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bgA() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bgB() {
                if (!this.fnb) {
                    return FrsGameSubPbActivity.this.fmV.bgP() != null && FrsGameSubPbActivity.this.fmV.bgP().getTop() == 0;
                }
                this.fnb = false;
                return false;
            }
        });
        this.fmV.e(this.fmW);
        this.fmV.jH(true);
        this.fmV.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.fmX != null) {
                    FrsGameSubPbActivity.this.fmX.loadData(true);
                }
            }
        });
        this.fmX = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.fna);
        this.fmX.a(new a.InterfaceC0294a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0294a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.fmW != null && FrsGameSubPbActivity.this.fmW.bgE()) {
                    FrsGameSubPbActivity.this.fmW.qL(d.C0277d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.fmV.getRootView());
                    FrsGameSubPbActivity.this.fmV.a(z2, bVar, list);
                    if (!v.T(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.fmX.vk(((com.baidu.tieba.frs.gamesubpb.model.d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.fmV.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.fmW != null) {
                        FrsGameSubPbActivity.this.fmW.bgC();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0294a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.fmV.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fmY = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0294a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.fmV.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fmZ = true;
                }
            }
        });
        this.fmX.loadData(false);
    }

    private void bgy() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.fmV != null) && view == FrsGameSubPbActivity.this.fmV.bgQ() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.fmW != null) {
                        FrsGameSubPbActivity.this.fmW.bgC();
                    }
                    FrsGameSubPbActivity.this.fmV.vm(null);
                }
            }
        };
    }

    private void aNG() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.fna = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fmV.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        this.fmX.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fmV != null) {
            this.fmV.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.fmY || this.fmZ) {
            setResult(1002);
        }
        super.finish();
    }
}
