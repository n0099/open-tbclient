package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private com.baidu.tieba.frs.gamesubpb.view.a dxm;
    private c dxn;
    private com.baidu.tieba.frs.gamesubpb.model.a dxo;
    private boolean dxp;
    private boolean dxq;
    private String dxr;
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
        afJ();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dxr)) {
            finish();
        }
        axE();
        this.dxm = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dxr);
        setContentView(this.dxm.getRootView());
        this.dxn = new c(this, this.dxm.getListView(), this.dxm.UW());
        this.dxn.axJ();
        this.dxn.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dxs = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void axF() {
                FrsGameSubPbActivity.this.dxm.gd(false);
                this.dxs = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void axG() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean axH() {
                if (!this.dxs) {
                    return FrsGameSubPbActivity.this.dxm.axV() != null && FrsGameSubPbActivity.this.dxm.axV().getTop() == 0;
                }
                this.dxs = false;
                return false;
            }
        });
        this.dxm.e(this.dxn);
        this.dxm.gd(true);
        this.dxm.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dxo != null) {
                    FrsGameSubPbActivity.this.dxo.loadData(true);
                }
            }
        });
        this.dxo = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dxr);
        this.dxo.a(new a.InterfaceC0158a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0158a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.dxn != null && FrsGameSubPbActivity.this.dxn.axK()) {
                    FrsGameSubPbActivity.this.dxn.kW(d.C0142d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dxm.getRootView());
                    FrsGameSubPbActivity.this.dxm.a(z2, bVar, list);
                    if (!w.A(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.dxo.mH(((com.baidu.tieba.frs.gamesubpb.model.d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dxm.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.k.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dxn != null) {
                        FrsGameSubPbActivity.this.dxn.axI();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0158a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dxm.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dxp = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0158a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dxm.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dxq = true;
                }
            }
        });
        this.dxo.loadData(false);
    }

    private void axE() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dxm != null) && view == FrsGameSubPbActivity.this.dxm.axW() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dxn != null) {
                        FrsGameSubPbActivity.this.dxn.axI();
                    }
                    FrsGameSubPbActivity.this.dxm.mJ(null);
                }
            }
        };
    }

    private void afJ() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dxr = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dxm.onChangeSkinType(i);
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
        this.dxo.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dxm != null) {
            this.dxm.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dxp || this.dxq) {
            setResult(1002);
        }
        super.finish();
    }
}
