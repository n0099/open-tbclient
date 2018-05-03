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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private com.baidu.tieba.frs.gamesubpb.view.a djI;
    private c djJ;
    private com.baidu.tieba.frs.gamesubpb.model.a djK;
    private boolean djL;
    private boolean djM;
    private String djN;
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
        abB();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.djN)) {
            finish();
        }
        asV();
        this.djI = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.djN);
        setContentView(this.djI.getRootView());
        this.djJ = new c(this, this.djI.getListView(), this.djI.Rg());
        this.djJ.ata();
        this.djJ.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean djO = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void asW() {
                FrsGameSubPbActivity.this.djI.fP(false);
                this.djO = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void asX() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean asY() {
                if (!this.djO) {
                    return FrsGameSubPbActivity.this.djI.atm() != null && FrsGameSubPbActivity.this.djI.atm().getTop() == 0;
                }
                this.djO = false;
                return false;
            }
        });
        this.djI.e(this.djJ);
        this.djI.fP(true);
        this.djI.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.djK != null) {
                    FrsGameSubPbActivity.this.djK.loadData(true);
                }
            }
        });
        this.djK = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.djN);
        this.djK.a(new a.InterfaceC0141a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0141a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.djJ != null && FrsGameSubPbActivity.this.djJ.atb()) {
                    FrsGameSubPbActivity.this.djJ.kL(d.C0126d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.djI.getRootView());
                    FrsGameSubPbActivity.this.djI.a(z2, bVar, list);
                    if (!v.w(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.djK.lX(((com.baidu.tieba.frs.gamesubpb.model.d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.djI.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.k.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.djJ != null) {
                        FrsGameSubPbActivity.this.djJ.asZ();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0141a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.djI.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.djL = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0141a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.djI.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.djM = true;
                }
            }
        });
        this.djK.loadData(false);
    }

    private void asV() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if ((view2 != null || FrsGameSubPbActivity.this.djI != null) && view2 == FrsGameSubPbActivity.this.djI.atn() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.djJ != null) {
                        FrsGameSubPbActivity.this.djJ.asZ();
                    }
                    FrsGameSubPbActivity.this.djI.lZ(null);
                }
            }
        };
    }

    private void abB() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.djN = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.djI.onChangeSkinType(i);
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
        this.djK.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.djI != null) {
            this.djI.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.djL || this.djM) {
            setResult(1002);
        }
        super.finish();
    }
}
