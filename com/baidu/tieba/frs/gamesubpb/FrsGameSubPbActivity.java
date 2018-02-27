package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private com.baidu.tieba.frs.gamesubpb.view.b dPs;
    private c dPt;
    private com.baidu.tieba.frs.gamesubpb.model.a dPu;
    private boolean dPv;
    private boolean dPw;
    private String dPx;
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
        ahu();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dPx)) {
            finish();
        }
        aye();
        this.dPs = new com.baidu.tieba.frs.gamesubpb.view.b(this, this.mCommonClickListener, this.dPx);
        setContentView(this.dPs.getRootView());
        this.dPt = new c(this, this.dPs.getListView(), this.dPs.avj());
        this.dPt.ayj();
        this.dPt.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dPy = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ayf() {
                FrsGameSubPbActivity.this.dPs.gj(false);
                this.dPy = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ayg() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean ayh() {
                if (!this.dPy) {
                    return FrsGameSubPbActivity.this.dPs.ayv() != null && FrsGameSubPbActivity.this.dPs.ayv().getTop() == 0;
                }
                this.dPy = false;
                return false;
            }
        });
        this.dPs.e(this.dPt);
        this.dPs.gj(true);
        this.dPs.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dPu != null) {
                    FrsGameSubPbActivity.this.dPu.loadData(true);
                }
            }
        });
        this.dPu = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dPx);
        this.dPu.a(new a.InterfaceC0157a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0157a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<i> list) {
                if (FrsGameSubPbActivity.this.dPt != null && FrsGameSubPbActivity.this.dPt.ayk()) {
                    FrsGameSubPbActivity.this.dPt.nx(d.C0141d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dPs.getRootView());
                    FrsGameSubPbActivity.this.dPs.a(z2, bVar, list);
                    if (!v.E(list)) {
                        i iVar = list.get(list.size() - 1);
                        if (iVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.dPu.lT(((com.baidu.tieba.frs.gamesubpb.model.d) iVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dPs.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dPt != null) {
                        FrsGameSubPbActivity.this.dPt.ayi();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0157a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dPs.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dPv = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0157a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dPs.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dPw = true;
                }
            }
        });
        this.dPu.loadData(false);
    }

    private void aye() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dPs != null) && view == FrsGameSubPbActivity.this.dPs.ayw() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dPt != null) {
                        FrsGameSubPbActivity.this.dPt.ayi();
                    }
                    FrsGameSubPbActivity.this.dPs.lV(null);
                }
            }
        };
    }

    private void ahu() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra("arg_forum_id", -1);
        this.dPx = intent.getStringExtra("arg_main_tower_id");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dPs.onChangeSkinType(i);
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
        this.dPu.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dPs != null) {
            this.dPs.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dPv || this.dPw) {
            setResult(1002);
        }
        super.finish();
    }
}
