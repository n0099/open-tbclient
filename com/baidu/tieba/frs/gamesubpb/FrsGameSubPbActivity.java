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
    private com.baidu.tieba.frs.gamesubpb.view.a dud;
    private c due;
    private com.baidu.tieba.frs.gamesubpb.model.a duf;
    private boolean dug;
    private boolean duh;
    private String dui;
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
        afb();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dui)) {
            finish();
        }
        axa();
        this.dud = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dui);
        setContentView(this.dud.getRootView());
        this.due = new c(this, this.dud.getListView(), this.dud.UB());
        this.due.axf();
        this.due.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean duj = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void axb() {
                FrsGameSubPbActivity.this.dud.fV(false);
                this.duj = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void axc() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean axd() {
                if (!this.duj) {
                    return FrsGameSubPbActivity.this.dud.axr() != null && FrsGameSubPbActivity.this.dud.axr().getTop() == 0;
                }
                this.duj = false;
                return false;
            }
        });
        this.dud.e(this.due);
        this.dud.fV(true);
        this.dud.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.duf != null) {
                    FrsGameSubPbActivity.this.duf.loadData(true);
                }
            }
        });
        this.duf = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dui);
        this.duf.a(new a.InterfaceC0156a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.due != null && FrsGameSubPbActivity.this.due.axg()) {
                    FrsGameSubPbActivity.this.due.kP(d.C0141d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dud.getRootView());
                    FrsGameSubPbActivity.this.dud.a(z2, bVar, list);
                    if (!w.z(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.duf.mH(((com.baidu.tieba.frs.gamesubpb.model.d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dud.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.k.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.due != null) {
                        FrsGameSubPbActivity.this.due.axe();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dud.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dug = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dud.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.duh = true;
                }
            }
        });
        this.duf.loadData(false);
    }

    private void axa() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dud != null) && view == FrsGameSubPbActivity.this.dud.axs() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.due != null) {
                        FrsGameSubPbActivity.this.due.axe();
                    }
                    FrsGameSubPbActivity.this.dud.mJ(null);
                }
            }
        };
    }

    private void afb() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dui = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dud.onChangeSkinType(i);
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
        this.duf.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dud != null) {
            this.dud.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dug || this.duh) {
            setResult(1002);
        }
        super.finish();
    }
}
