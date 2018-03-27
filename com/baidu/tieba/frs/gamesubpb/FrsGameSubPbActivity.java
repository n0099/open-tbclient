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
    private boolean dPA;
    private boolean dPB;
    private String dPC;
    private com.baidu.tieba.frs.gamesubpb.view.b dPx;
    private c dPy;
    private com.baidu.tieba.frs.gamesubpb.model.a dPz;
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
        ahv();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dPC)) {
            finish();
        }
        ayg();
        this.dPx = new com.baidu.tieba.frs.gamesubpb.view.b(this, this.mCommonClickListener, this.dPC);
        setContentView(this.dPx.getRootView());
        this.dPy = new c(this, this.dPx.getListView(), this.dPx.avk());
        this.dPy.ayl();
        this.dPy.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dPD = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ayh() {
                FrsGameSubPbActivity.this.dPx.gk(false);
                this.dPD = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ayi() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean ayj() {
                if (!this.dPD) {
                    return FrsGameSubPbActivity.this.dPx.ayx() != null && FrsGameSubPbActivity.this.dPx.ayx().getTop() == 0;
                }
                this.dPD = false;
                return false;
            }
        });
        this.dPx.e(this.dPy);
        this.dPx.gk(true);
        this.dPx.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dPz != null) {
                    FrsGameSubPbActivity.this.dPz.loadData(true);
                }
            }
        });
        this.dPz = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dPC);
        this.dPz.a(new a.InterfaceC0157a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0157a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<i> list) {
                if (FrsGameSubPbActivity.this.dPy != null && FrsGameSubPbActivity.this.dPy.aym()) {
                    FrsGameSubPbActivity.this.dPy.nx(d.C0141d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dPx.getRootView());
                    FrsGameSubPbActivity.this.dPx.a(z2, bVar, list);
                    if (!v.E(list)) {
                        i iVar = list.get(list.size() - 1);
                        if (iVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.dPz.lT(((com.baidu.tieba.frs.gamesubpb.model.d) iVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dPx.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dPy != null) {
                        FrsGameSubPbActivity.this.dPy.ayk();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0157a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dPx.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dPA = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0157a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dPx.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dPB = true;
                }
            }
        });
        this.dPz.loadData(false);
    }

    private void ayg() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dPx != null) && view == FrsGameSubPbActivity.this.dPx.ayy() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dPy != null) {
                        FrsGameSubPbActivity.this.dPy.ayk();
                    }
                    FrsGameSubPbActivity.this.dPx.lV(null);
                }
            }
        };
    }

    private void ahv() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra("arg_forum_id", -1);
        this.dPC = intent.getStringExtra("arg_main_tower_id");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dPx.onChangeSkinType(i);
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
        this.dPz.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dPx != null) {
            this.dPx.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dPA || this.dPB) {
            setResult(1002);
        }
        super.finish();
    }
}
