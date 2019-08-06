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
    private com.baidu.tieba.frs.gamesubpb.view.a fJd;
    private c fJe;
    private com.baidu.tieba.frs.gamesubpb.model.a fJf;
    private boolean fJg;
    private boolean fJh;
    private String fJi;
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
        aVT();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.fJi)) {
            finish();
        }
        bqg();
        this.fJd = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.fJi);
        setContentView(this.fJd.getRootView());
        this.fJe = new c(this, this.fJd.getListView(), this.fJd.aLj());
        this.fJe.bql();
        this.fJe.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean fJj = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bqh() {
                FrsGameSubPbActivity.this.fJd.kD(false);
                this.fJj = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bqi() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bqj() {
                if (!this.fJj) {
                    return FrsGameSubPbActivity.this.fJd.bqx() != null && FrsGameSubPbActivity.this.fJd.bqx().getTop() == 0;
                }
                this.fJj = false;
                return false;
            }
        });
        this.fJd.e(this.fJe);
        this.fJd.kD(true);
        this.fJd.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.fJf != null) {
                    FrsGameSubPbActivity.this.fJf.loadData(true);
                }
            }
        });
        this.fJf = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.fJi);
        this.fJf.a(new a.InterfaceC0315a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0315a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.fJe != null && FrsGameSubPbActivity.this.fJe.bqm()) {
                    FrsGameSubPbActivity.this.fJe.sn(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.fJd.getRootView());
                    FrsGameSubPbActivity.this.fJd.a(z2, bVar, list);
                    if (!v.aa(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.fJf.xi(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.fJd.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.fJe != null) {
                        FrsGameSubPbActivity.this.fJe.bqk();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0315a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fJd.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fJg = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0315a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fJd.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fJh = true;
                }
            }
        });
        this.fJf.loadData(false);
    }

    private void bqg() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.fJd != null) && view == FrsGameSubPbActivity.this.fJd.bqy() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.fJe != null) {
                        FrsGameSubPbActivity.this.fJe.bqk();
                    }
                    FrsGameSubPbActivity.this.fJd.xk(null);
                }
            }
        };
    }

    private void aVT() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.fJi = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fJd.onChangeSkinType(i);
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
        this.fJf.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fJd != null) {
            this.fJd.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.fJg || this.fJh) {
            setResult(1002);
        }
        super.finish();
    }
}
