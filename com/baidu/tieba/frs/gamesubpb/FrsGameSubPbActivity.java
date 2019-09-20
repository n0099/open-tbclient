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
    private com.baidu.tieba.frs.gamesubpb.view.a fKS;
    private c fKT;
    private com.baidu.tieba.frs.gamesubpb.model.a fKU;
    private boolean fKV;
    private boolean fKW;
    private String fKX;
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
        aWx();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.fKX)) {
            finish();
        }
        bqS();
        this.fKS = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.fKX);
        setContentView(this.fKS.getRootView());
        this.fKT = new c(this, this.fKS.getListView(), this.fKS.aLN());
        this.fKT.bqX();
        this.fKT.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean fKY = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bqT() {
                FrsGameSubPbActivity.this.fKS.kG(false);
                this.fKY = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bqU() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bqV() {
                if (!this.fKY) {
                    return FrsGameSubPbActivity.this.fKS.bgK() != null && FrsGameSubPbActivity.this.fKS.bgK().getTop() == 0;
                }
                this.fKY = false;
                return false;
            }
        });
        this.fKS.e(this.fKT);
        this.fKS.kG(true);
        this.fKS.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.fKU != null) {
                    FrsGameSubPbActivity.this.fKU.loadData(true);
                }
            }
        });
        this.fKU = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.fKX);
        this.fKU.a(new a.InterfaceC0326a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0326a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.fKT != null && FrsGameSubPbActivity.this.fKT.bqY()) {
                    FrsGameSubPbActivity.this.fKT.sr(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.fKS.getRootView());
                    FrsGameSubPbActivity.this.fKS.a(z2, bVar, list);
                    if (!v.aa(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.fKU.xH(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.fKS.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.fKT != null) {
                        FrsGameSubPbActivity.this.fKT.bqW();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0326a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fKS.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fKV = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0326a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fKS.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fKW = true;
                }
            }
        });
        this.fKU.loadData(false);
    }

    private void bqS() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.fKS != null) && view == FrsGameSubPbActivity.this.fKS.brj() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.fKT != null) {
                        FrsGameSubPbActivity.this.fKT.bqW();
                    }
                    FrsGameSubPbActivity.this.fKS.xJ(null);
                }
            }
        };
    }

    private void aWx() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.fKX = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fKS.onChangeSkinType(i);
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
        this.fKU.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fKS != null) {
            this.fKS.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.fKV || this.fKW) {
            setResult(1002);
        }
        super.finish();
    }
}
