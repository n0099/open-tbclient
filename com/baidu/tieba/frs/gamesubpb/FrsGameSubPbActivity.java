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
import com.baidu.tieba.e;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private com.baidu.tieba.frs.gamesubpb.view.a dOE;
    private c dOF;
    private com.baidu.tieba.frs.gamesubpb.model.a dOG;
    private boolean dOH;
    private boolean dOI;
    private String dOJ;
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
        alx();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dOJ)) {
            finish();
        }
        aDQ();
        this.dOE = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dOJ);
        setContentView(this.dOE.getRootView());
        this.dOF = new c(this, this.dOE.getListView(), this.dOE.aaE());
        this.dOF.aDV();
        this.dOF.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dOK = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aDR() {
                FrsGameSubPbActivity.this.dOE.gV(false);
                this.dOK = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aDS() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean aDT() {
                if (!this.dOK) {
                    return FrsGameSubPbActivity.this.dOE.aEh() != null && FrsGameSubPbActivity.this.dOE.aEh().getTop() == 0;
                }
                this.dOK = false;
                return false;
            }
        });
        this.dOE.e(this.dOF);
        this.dOE.gV(true);
        this.dOE.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dOG != null) {
                    FrsGameSubPbActivity.this.dOG.loadData(true);
                }
            }
        });
        this.dOG = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dOJ);
        this.dOG.a(new a.InterfaceC0190a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0190a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.dOF != null && FrsGameSubPbActivity.this.dOF.aDW()) {
                    FrsGameSubPbActivity.this.dOF.mh(e.d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dOE.getRootView());
                    FrsGameSubPbActivity.this.dOE.a(z2, bVar, list);
                    if (!v.J(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof d) {
                            FrsGameSubPbActivity.this.dOG.nN(((d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(e.C0175e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dOE.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(e.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dOF != null) {
                        FrsGameSubPbActivity.this.dOF.aDU();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0190a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dOE.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dOH = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0190a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dOE.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dOI = true;
                }
            }
        });
        this.dOG.loadData(false);
    }

    private void aDQ() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dOE != null) && view == FrsGameSubPbActivity.this.dOE.aEi() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dOF != null) {
                        FrsGameSubPbActivity.this.dOF.aDU();
                    }
                    FrsGameSubPbActivity.this.dOE.nP(null);
                }
            }
        };
    }

    private void alx() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dOJ = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dOE.onChangeSkinType(i);
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
        this.dOG.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dOE != null) {
            this.dOE.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dOH || this.dOI) {
            setResult(1002);
        }
        super.finish();
    }
}
