package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener bdp;
    private com.baidu.tieba.frs.gamesubpb.view.a jzF;
    private c jzG;
    private com.baidu.tieba.frs.gamesubpb.model.a jzH;
    private boolean jzI;
    private boolean jzJ;
    private String jzK;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        cpd();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.jzK)) {
            finish();
        }
        cbX();
        this.jzF = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.bdp, this.jzK);
        setContentView(this.jzF.getRootView());
        this.jzG = new c(this, this.jzF.getListView(), this.jzF.bYq());
        this.jzG.cKR();
        this.jzG.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean jzL = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cKN() {
                FrsGameSubPbActivity.this.jzF.ri(false);
                this.jzL = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cKO() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cKP() {
                if (!this.jzL) {
                    return FrsGameSubPbActivity.this.jzF.cyV() != null && FrsGameSubPbActivity.this.jzF.cyV().getTop() == 0;
                }
                this.jzL = false;
                return false;
            }
        });
        this.jzF.e(this.jzG);
        this.jzF.ri(true);
        this.jzF.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.jzH != null) {
                    FrsGameSubPbActivity.this.jzH.mH(true);
                }
            }
        });
        this.jzH = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.jzK);
        this.jzH.a(new a.InterfaceC0741a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0741a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<n> list) {
                if (FrsGameSubPbActivity.this.jzG != null && FrsGameSubPbActivity.this.jzG.cKS()) {
                    FrsGameSubPbActivity.this.jzG.Bk(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.jzF.getRootView());
                    FrsGameSubPbActivity.this.jzF.a(z2, bVar, list);
                    if (!x.isEmpty(list)) {
                        n nVar = list.get(list.size() - 1);
                        if (nVar instanceof d) {
                            FrsGameSubPbActivity.this.jzH.Li(((d) nVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.jzF.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.jzG != null) {
                        FrsGameSubPbActivity.this.jzG.cKQ();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0741a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jzF.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jzI = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0741a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jzF.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jzJ = true;
                }
            }
        });
        this.jzH.mH(false);
    }

    private void cbX() {
        this.bdp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.jzF != null) && view == FrsGameSubPbActivity.this.jzF.cLc() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.jzG != null) {
                        FrsGameSubPbActivity.this.jzG.cKQ();
                    }
                    FrsGameSubPbActivity.this.jzF.Lk(null);
                }
            }
        };
    }

    private void cpd() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.jzK = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jzF.onChangeSkinType(i);
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
        this.jzH.mH(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jzF != null) {
            this.jzF.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.jzI || this.jzJ) {
            setResult(1002);
        }
        super.finish();
    }
}
