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
    private com.baidu.tieba.frs.gamesubpb.view.b dPE;
    private c dPF;
    private com.baidu.tieba.frs.gamesubpb.model.a dPG;
    private boolean dPH;
    private boolean dPI;
    private String dPJ;
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
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dPJ)) {
            finish();
        }
        ayf();
        this.dPE = new com.baidu.tieba.frs.gamesubpb.view.b(this, this.mCommonClickListener, this.dPJ);
        setContentView(this.dPE.getRootView());
        this.dPF = new c(this, this.dPE.getListView(), this.dPE.avk());
        this.dPF.ayk();
        this.dPF.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dPK = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ayg() {
                FrsGameSubPbActivity.this.dPE.gj(false);
                this.dPK = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ayh() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean ayi() {
                if (!this.dPK) {
                    return FrsGameSubPbActivity.this.dPE.ayw() != null && FrsGameSubPbActivity.this.dPE.ayw().getTop() == 0;
                }
                this.dPK = false;
                return false;
            }
        });
        this.dPE.e(this.dPF);
        this.dPE.gj(true);
        this.dPE.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dPG != null) {
                    FrsGameSubPbActivity.this.dPG.loadData(true);
                }
            }
        });
        this.dPG = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dPJ);
        this.dPG.a(new a.InterfaceC0156a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<i> list) {
                if (FrsGameSubPbActivity.this.dPF != null && FrsGameSubPbActivity.this.dPF.ayl()) {
                    FrsGameSubPbActivity.this.dPF.nx(d.C0140d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dPE.getRootView());
                    FrsGameSubPbActivity.this.dPE.a(z2, bVar, list);
                    if (!v.E(list)) {
                        i iVar = list.get(list.size() - 1);
                        if (iVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.dPG.lT(((com.baidu.tieba.frs.gamesubpb.model.d) iVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dPE.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dPF != null) {
                        FrsGameSubPbActivity.this.dPF.ayj();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dPE.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dPH = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dPE.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dPI = true;
                }
            }
        });
        this.dPG.loadData(false);
    }

    private void ayf() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dPE != null) && view == FrsGameSubPbActivity.this.dPE.ayx() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dPF != null) {
                        FrsGameSubPbActivity.this.dPF.ayj();
                    }
                    FrsGameSubPbActivity.this.dPE.lV(null);
                }
            }
        };
    }

    private void ahv() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra("arg_forum_id", -1);
        this.dPJ = intent.getStringExtra("arg_main_tower_id");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dPE.onChangeSkinType(i);
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
        this.dPG.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dPE != null) {
            this.dPE.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dPH || this.dPI) {
            setResult(1002);
        }
        super.finish();
    }
}
