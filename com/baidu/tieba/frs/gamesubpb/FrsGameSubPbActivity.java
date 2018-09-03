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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private String dAa;
    private com.baidu.tieba.frs.gamesubpb.view.a dzV;
    private c dzW;
    private com.baidu.tieba.frs.gamesubpb.model.a dzX;
    private boolean dzY;
    private boolean dzZ;
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
        agf();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dAa)) {
            finish();
        }
        ayh();
        this.dzV = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dAa);
        setContentView(this.dzV.getRootView());
        this.dzW = new c(this, this.dzV.getListView(), this.dzV.Vj());
        this.dzW.aym();
        this.dzW.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dAb = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ayi() {
                FrsGameSubPbActivity.this.dzV.gf(false);
                this.dAb = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ayj() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean ayk() {
                if (!this.dAb) {
                    return FrsGameSubPbActivity.this.dzV.ayy() != null && FrsGameSubPbActivity.this.dzV.ayy().getTop() == 0;
                }
                this.dAb = false;
                return false;
            }
        });
        this.dzV.e(this.dzW);
        this.dzV.gf(true);
        this.dzV.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dzX != null) {
                    FrsGameSubPbActivity.this.dzX.loadData(true);
                }
            }
        });
        this.dzX = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dAa);
        this.dzX.a(new a.InterfaceC0156a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.dzW != null && FrsGameSubPbActivity.this.dzW.ayn()) {
                    FrsGameSubPbActivity.this.dzW.lg(f.d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dzV.getRootView());
                    FrsGameSubPbActivity.this.dzV.a(z2, bVar, list);
                    if (!w.z(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof d) {
                            FrsGameSubPbActivity.this.dzX.mI(((d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(f.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dzV.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(f.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dzW != null) {
                        FrsGameSubPbActivity.this.dzW.ayl();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dzV.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dzY = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dzV.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dzZ = true;
                }
            }
        });
        this.dzX.loadData(false);
    }

    private void ayh() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dzV != null) && view == FrsGameSubPbActivity.this.dzV.ayz() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dzW != null) {
                        FrsGameSubPbActivity.this.dzW.ayl();
                    }
                    FrsGameSubPbActivity.this.dzV.mK(null);
                }
            }
        };
    }

    private void agf() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dAa = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dzV.onChangeSkinType(i);
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
        this.dzX.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dzV != null) {
            this.dzV.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dzY || this.dzZ) {
            setResult(1002);
        }
        super.finish();
    }
}
