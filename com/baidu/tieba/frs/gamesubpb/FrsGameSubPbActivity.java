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
    private com.baidu.tieba.frs.gamesubpb.view.a fDr;
    private c fDs;
    private com.baidu.tieba.frs.gamesubpb.model.a fDt;
    private boolean fDu;
    private boolean fDv;
    private String fDw;
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
        aTT();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.fDw)) {
            finish();
        }
        bnS();
        this.fDr = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.fDw);
        setContentView(this.fDr.getRootView());
        this.fDs = new c(this, this.fDr.getListView(), this.fDr.aJC());
        this.fDs.bnX();
        this.fDs.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean fDx = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bnT() {
                FrsGameSubPbActivity.this.fDr.kt(false);
                this.fDx = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bnU() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bnV() {
                if (!this.fDx) {
                    return FrsGameSubPbActivity.this.fDr.boj() != null && FrsGameSubPbActivity.this.fDr.boj().getTop() == 0;
                }
                this.fDx = false;
                return false;
            }
        });
        this.fDr.e(this.fDs);
        this.fDr.kt(true);
        this.fDr.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.fDt != null) {
                    FrsGameSubPbActivity.this.fDt.loadData(true);
                }
            }
        });
        this.fDt = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.fDw);
        this.fDt.a(new a.InterfaceC0312a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0312a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.fDs != null && FrsGameSubPbActivity.this.fDs.bnY()) {
                    FrsGameSubPbActivity.this.fDs.rT(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.fDr.getRootView());
                    FrsGameSubPbActivity.this.fDr.a(z2, bVar, list);
                    if (!v.aa(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.fDt.wC(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.fDr.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.fDs != null) {
                        FrsGameSubPbActivity.this.fDs.bnW();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0312a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fDr.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fDu = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0312a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fDr.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fDv = true;
                }
            }
        });
        this.fDt.loadData(false);
    }

    private void bnS() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.fDr != null) && view == FrsGameSubPbActivity.this.fDr.bok() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.fDs != null) {
                        FrsGameSubPbActivity.this.fDs.bnW();
                    }
                    FrsGameSubPbActivity.this.fDr.wE(null);
                }
            }
        };
    }

    private void aTT() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.fDw = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fDr.onChangeSkinType(i);
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
        this.fDt.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fDr != null) {
            this.fDr.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.fDu || this.fDv) {
            setResult(1002);
        }
        super.finish();
    }
}
