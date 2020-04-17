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
    private View.OnClickListener aDc;
    private com.baidu.tieba.frs.gamesubpb.view.a hnC;
    private c hnD;
    private com.baidu.tieba.frs.gamesubpb.model.a hnE;
    private boolean hnF;
    private boolean hnG;
    private String hnH;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bpw();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.hnH)) {
            finish();
        }
        bqK();
        this.hnC = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aDc, this.hnH);
        setContentView(this.hnC.getRootView());
        this.hnD = new c(this, this.hnC.getListView(), this.hnC.boh());
        this.hnD.bSO();
        this.hnD.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean hnI = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bSK() {
                FrsGameSubPbActivity.this.hnC.nc(false);
                this.hnI = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bSL() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bSM() {
                if (!this.hnI) {
                    return FrsGameSubPbActivity.this.hnC.bIH() != null && FrsGameSubPbActivity.this.hnC.bIH().getTop() == 0;
                }
                this.hnI = false;
                return false;
            }
        });
        this.hnC.e(this.hnD);
        this.hnC.nc(true);
        this.hnC.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.hnE != null) {
                    FrsGameSubPbActivity.this.hnE.loadData(true);
                }
            }
        });
        this.hnE = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.hnH);
        this.hnE.a(new a.InterfaceC0546a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0546a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.hnD != null && FrsGameSubPbActivity.this.hnD.bSP()) {
                    FrsGameSubPbActivity.this.hnD.ue(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.hnC.getRootView());
                    FrsGameSubPbActivity.this.hnC.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.hnE.CZ(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.hnC.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.hnD != null) {
                        FrsGameSubPbActivity.this.hnD.bSN();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0546a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hnC.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hnF = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0546a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hnC.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hnG = true;
                }
            }
        });
        this.hnE.loadData(false);
    }

    private void bqK() {
        this.aDc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.hnC != null) && view == FrsGameSubPbActivity.this.hnC.bTa() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.hnD != null) {
                        FrsGameSubPbActivity.this.hnD.bSN();
                    }
                    FrsGameSubPbActivity.this.hnC.Db(null);
                }
            }
        };
    }

    private void bpw() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.hnH = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hnC.onChangeSkinType(i);
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
        this.hnE.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hnC != null) {
            this.hnC.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.hnF || this.hnG) {
            setResult(1002);
        }
        super.finish();
    }
}
