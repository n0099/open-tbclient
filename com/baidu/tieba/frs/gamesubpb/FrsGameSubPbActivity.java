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
    private com.baidu.tieba.frs.gamesubpb.model.a dAa;
    private boolean dAb;
    private boolean dAc;
    private String dAd;
    private com.baidu.tieba.frs.gamesubpb.view.a dzY;
    private c dzZ;
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
        agd();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dAd)) {
            finish();
        }
        ayj();
        this.dzY = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dAd);
        setContentView(this.dzY.getRootView());
        this.dzZ = new c(this, this.dzY.getListView(), this.dzY.Vf());
        this.dzZ.ayo();
        this.dzZ.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dAe = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ayk() {
                FrsGameSubPbActivity.this.dzY.gf(false);
                this.dAe = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ayl() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean aym() {
                if (!this.dAe) {
                    return FrsGameSubPbActivity.this.dzY.ayA() != null && FrsGameSubPbActivity.this.dzY.ayA().getTop() == 0;
                }
                this.dAe = false;
                return false;
            }
        });
        this.dzY.e(this.dzZ);
        this.dzY.gf(true);
        this.dzY.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dAa != null) {
                    FrsGameSubPbActivity.this.dAa.loadData(true);
                }
            }
        });
        this.dAa = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dAd);
        this.dAa.a(new a.InterfaceC0156a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.dzZ != null && FrsGameSubPbActivity.this.dzZ.ayp()) {
                    FrsGameSubPbActivity.this.dzZ.lh(d.C0140d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dzY.getRootView());
                    FrsGameSubPbActivity.this.dzY.a(z2, bVar, list);
                    if (!w.z(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.dAa.mG(((com.baidu.tieba.frs.gamesubpb.model.d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dzY.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dzZ != null) {
                        FrsGameSubPbActivity.this.dzZ.ayn();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dzY.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dAb = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dzY.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dAc = true;
                }
            }
        });
        this.dAa.loadData(false);
    }

    private void ayj() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dzY != null) && view == FrsGameSubPbActivity.this.dzY.ayB() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dzZ != null) {
                        FrsGameSubPbActivity.this.dzZ.ayn();
                    }
                    FrsGameSubPbActivity.this.dzY.mI(null);
                }
            }
        };
    }

    private void agd() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dAd = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dzY.onChangeSkinType(i);
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
        this.dAa.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dzY != null) {
            this.dzY.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dAb || this.dAc) {
            setResult(1002);
        }
        super.finish();
    }
}
