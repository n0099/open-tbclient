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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private com.baidu.tieba.frs.gamesubpb.view.a fDq;
    private c fDr;
    private com.baidu.tieba.frs.gamesubpb.model.a fDs;
    private boolean fDt;
    private boolean fDu;
    private String fDv;
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
        aTQ();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.fDv)) {
            finish();
        }
        bnP();
        this.fDq = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.fDv);
        setContentView(this.fDq.getRootView());
        this.fDr = new c(this, this.fDq.getListView(), this.fDq.aJz());
        this.fDr.bnU();
        this.fDr.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean fDw = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bnQ() {
                FrsGameSubPbActivity.this.fDq.kt(false);
                this.fDw = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bnR() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bnS() {
                if (!this.fDw) {
                    return FrsGameSubPbActivity.this.fDq.bog() != null && FrsGameSubPbActivity.this.fDq.bog().getTop() == 0;
                }
                this.fDw = false;
                return false;
            }
        });
        this.fDq.e(this.fDr);
        this.fDq.kt(true);
        this.fDq.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.fDs != null) {
                    FrsGameSubPbActivity.this.fDs.loadData(true);
                }
            }
        });
        this.fDs = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.fDv);
        this.fDs.a(new a.InterfaceC0312a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0312a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.fDr != null && FrsGameSubPbActivity.this.fDr.bnV()) {
                    FrsGameSubPbActivity.this.fDr.rT(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.fDq.getRootView());
                    FrsGameSubPbActivity.this.fDq.a(z2, bVar, list);
                    if (!v.aa(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.fDs.wD(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.fDq.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.fDr != null) {
                        FrsGameSubPbActivity.this.fDr.bnT();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0312a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fDq.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fDt = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0312a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fDq.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fDu = true;
                }
            }
        });
        this.fDs.loadData(false);
    }

    private void bnP() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.fDq != null) && view == FrsGameSubPbActivity.this.fDq.boh() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.fDr != null) {
                        FrsGameSubPbActivity.this.fDr.bnT();
                    }
                    FrsGameSubPbActivity.this.fDq.wF(null);
                }
            }
        };
    }

    private void aTQ() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.fDv = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fDq.onChangeSkinType(i);
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
        this.fDs.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fDq != null) {
            this.fDq.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.fDt || this.fDu) {
            setResult(1002);
        }
        super.finish();
    }
}
