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
    private com.baidu.tieba.frs.gamesubpb.view.a djL;
    private c djM;
    private com.baidu.tieba.frs.gamesubpb.model.a djN;
    private boolean djO;
    private boolean djP;
    private String djQ;
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
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.djQ)) {
            finish();
        }
        asV();
        this.djL = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.djQ);
        setContentView(this.djL.getRootView());
        this.djM = new c(this, this.djL.getListView(), this.djL.Rg());
        this.djM.ata();
        this.djM.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean djR = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void asW() {
                FrsGameSubPbActivity.this.djL.fP(false);
                this.djR = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void asX() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean asY() {
                if (!this.djR) {
                    return FrsGameSubPbActivity.this.djL.atm() != null && FrsGameSubPbActivity.this.djL.atm().getTop() == 0;
                }
                this.djR = false;
                return false;
            }
        });
        this.djL.e(this.djM);
        this.djL.fP(true);
        this.djL.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.djN != null) {
                    FrsGameSubPbActivity.this.djN.loadData(true);
                }
            }
        });
        this.djN = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.djQ);
        this.djN.a(new a.InterfaceC0141a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0141a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.djM != null && FrsGameSubPbActivity.this.djM.atb()) {
                    FrsGameSubPbActivity.this.djM.kM(d.C0126d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.djL.getRootView());
                    FrsGameSubPbActivity.this.djL.a(z2, bVar, list);
                    if (!v.w(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.djN.lX(((com.baidu.tieba.frs.gamesubpb.model.d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.djL.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.k.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.djM != null) {
                        FrsGameSubPbActivity.this.djM.asZ();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0141a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.djL.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.djO = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0141a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.djL.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.djP = true;
                }
            }
        });
        this.djN.loadData(false);
    }

    private void asV() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if ((view2 != null || FrsGameSubPbActivity.this.djL != null) && view2 == FrsGameSubPbActivity.this.djL.atn() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.djM != null) {
                        FrsGameSubPbActivity.this.djM.asZ();
                    }
                    FrsGameSubPbActivity.this.djL.lZ(null);
                }
            }
        };
    }

    private void abB() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.djQ = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.djL.onChangeSkinType(i);
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
        this.djN.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.djL != null) {
            this.djL.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.djO || this.djP) {
            setResult(1002);
        }
        super.finish();
    }
}
