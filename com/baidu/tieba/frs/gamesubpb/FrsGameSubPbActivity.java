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
/* loaded from: classes9.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener aDi;
    private com.baidu.tieba.frs.gamesubpb.view.a hnI;
    private c hnJ;
    private com.baidu.tieba.frs.gamesubpb.model.a hnK;
    private boolean hnL;
    private boolean hnM;
    private String hnN;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bpu();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.hnN)) {
            finish();
        }
        bqI();
        this.hnI = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aDi, this.hnN);
        setContentView(this.hnI.getRootView());
        this.hnJ = new c(this, this.hnI.getListView(), this.hnI.bof());
        this.hnJ.bSM();
        this.hnJ.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean hnO = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bSI() {
                FrsGameSubPbActivity.this.hnI.nc(false);
                this.hnO = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bSJ() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bSK() {
                if (!this.hnO) {
                    return FrsGameSubPbActivity.this.hnI.bIF() != null && FrsGameSubPbActivity.this.hnI.bIF().getTop() == 0;
                }
                this.hnO = false;
                return false;
            }
        });
        this.hnI.e(this.hnJ);
        this.hnI.nc(true);
        this.hnI.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.hnK != null) {
                    FrsGameSubPbActivity.this.hnK.loadData(true);
                }
            }
        });
        this.hnK = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.hnN);
        this.hnK.a(new a.InterfaceC0567a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0567a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.hnJ != null && FrsGameSubPbActivity.this.hnJ.bSN()) {
                    FrsGameSubPbActivity.this.hnJ.ue(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.hnI.getRootView());
                    FrsGameSubPbActivity.this.hnI.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.hnK.Dc(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.hnI.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.hnJ != null) {
                        FrsGameSubPbActivity.this.hnJ.bSL();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0567a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hnI.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hnL = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0567a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hnI.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hnM = true;
                }
            }
        });
        this.hnK.loadData(false);
    }

    private void bqI() {
        this.aDi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.hnI != null) && view == FrsGameSubPbActivity.this.hnI.bSY() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.hnJ != null) {
                        FrsGameSubPbActivity.this.hnJ.bSL();
                    }
                    FrsGameSubPbActivity.this.hnI.De(null);
                }
            }
        };
    }

    private void bpu() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.hnN = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hnI.onChangeSkinType(i);
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
        this.hnK.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hnI != null) {
            this.hnI.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.hnL || this.hnM) {
            setResult(1002);
        }
        super.finish();
    }
}
