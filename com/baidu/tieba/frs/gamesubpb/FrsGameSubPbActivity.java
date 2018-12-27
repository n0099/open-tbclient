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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private com.baidu.tieba.frs.gamesubpb.view.a dZa;
    private c dZb;
    private com.baidu.tieba.frs.gamesubpb.model.a dZc;
    private boolean dZd;
    private boolean dZe;
    private String dZf;
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
        amF();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dZf)) {
            finish();
        }
        aFL();
        this.dZa = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dZf);
        setContentView(this.dZa.getRootView());
        this.dZb = new c(this, this.dZa.getListView(), this.dZa.abW());
        this.dZb.aFQ();
        this.dZb.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dZg = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aFM() {
                FrsGameSubPbActivity.this.dZa.hj(false);
                this.dZg = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aFN() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean aFO() {
                if (!this.dZg) {
                    return FrsGameSubPbActivity.this.dZa.aGc() != null && FrsGameSubPbActivity.this.dZa.aGc().getTop() == 0;
                }
                this.dZg = false;
                return false;
            }
        });
        this.dZa.e(this.dZb);
        this.dZa.hj(true);
        this.dZa.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dZc != null) {
                    FrsGameSubPbActivity.this.dZc.loadData(true);
                }
            }
        });
        this.dZc = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dZf);
        this.dZc.a(new a.InterfaceC0226a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0226a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.dZb != null && FrsGameSubPbActivity.this.dZb.aFR()) {
                    FrsGameSubPbActivity.this.dZb.nb(e.d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dZa.getRootView());
                    FrsGameSubPbActivity.this.dZa.a(z2, bVar, list);
                    if (!v.I(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof d) {
                            FrsGameSubPbActivity.this.dZc.os(((d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(e.C0210e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dZa.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(e.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dZb != null) {
                        FrsGameSubPbActivity.this.dZb.aFP();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0226a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dZa.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dZd = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0226a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dZa.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dZe = true;
                }
            }
        });
        this.dZc.loadData(false);
    }

    private void aFL() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dZa != null) && view == FrsGameSubPbActivity.this.dZa.aGd() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dZb != null) {
                        FrsGameSubPbActivity.this.dZb.aFP();
                    }
                    FrsGameSubPbActivity.this.dZa.ou(null);
                }
            }
        };
    }

    private void amF() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dZf = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dZa.onChangeSkinType(i);
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
        this.dZc.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dZa != null) {
            this.dZa.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dZd || this.dZe) {
            setResult(1002);
        }
        super.finish();
    }
}
