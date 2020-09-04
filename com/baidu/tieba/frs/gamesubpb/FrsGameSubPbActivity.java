package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener aRW;
    private com.baidu.tieba.frs.gamesubpb.view.a ikF;
    private c ikG;
    private com.baidu.tieba.frs.gamesubpb.model.a ikH;
    private boolean ikI;
    private boolean ikJ;
    private String ikK;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bYa();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.ikK)) {
            finish();
        }
        bMh();
        this.ikF = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aRW, this.ikK);
        setContentView(this.ikF.getRootView());
        this.ikG = new c(this, this.ikF.getListView(), this.ikF.bJI());
        this.ikG.cqJ();
        this.ikG.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean ikL = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cqF() {
                FrsGameSubPbActivity.this.ikF.oU(false);
                this.ikL = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cqG() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cqH() {
                if (!this.ikL) {
                    return FrsGameSubPbActivity.this.ikF.cfO() != null && FrsGameSubPbActivity.this.ikF.cfO().getTop() == 0;
                }
                this.ikL = false;
                return false;
            }
        });
        this.ikF.e(this.ikG);
        this.ikF.oU(true);
        this.ikF.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.ikH != null) {
                    FrsGameSubPbActivity.this.ikH.kN(true);
                }
            }
        });
        this.ikH = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.ikK);
        this.ikH.a(new a.InterfaceC0686a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0686a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.ikG != null && FrsGameSubPbActivity.this.ikG.cqK()) {
                    FrsGameSubPbActivity.this.ikG.yb(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.ikF.getRootView());
                    FrsGameSubPbActivity.this.ikF.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.ikH.IB(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.ikF.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.ikG != null) {
                        FrsGameSubPbActivity.this.ikG.cqI();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0686a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.ikF.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.ikI = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0686a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.ikF.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.ikJ = true;
                }
            }
        });
        this.ikH.kN(false);
    }

    private void bMh() {
        this.aRW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.ikF != null) && view == FrsGameSubPbActivity.this.ikF.cqU() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.ikG != null) {
                        FrsGameSubPbActivity.this.ikG.cqI();
                    }
                    FrsGameSubPbActivity.this.ikF.ID(null);
                }
            }
        };
    }

    private void bYa() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.ikK = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ikF.onChangeSkinType(i);
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
        this.ikH.kN(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ikF != null) {
            this.ikF.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.ikI || this.ikJ) {
            setResult(1002);
        }
        super.finish();
    }
}
