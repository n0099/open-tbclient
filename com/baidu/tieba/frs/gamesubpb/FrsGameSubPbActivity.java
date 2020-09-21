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
/* loaded from: classes21.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener aTZ;
    private com.baidu.tieba.frs.gamesubpb.view.a irH;
    private c irI;
    private com.baidu.tieba.frs.gamesubpb.model.a irJ;
    private boolean irK;
    private boolean irL;
    private String irM;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bZW();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.irM)) {
            finish();
        }
        bNr();
        this.irH = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aTZ, this.irM);
        setContentView(this.irH.getRootView());
        this.irI = new c(this, this.irH.getListView(), this.irH.bKS());
        this.irI.ctW();
        this.irI.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean irN = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ctS() {
                FrsGameSubPbActivity.this.irH.pa(false);
                this.irN = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ctT() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean ctU() {
                if (!this.irN) {
                    return FrsGameSubPbActivity.this.irH.cjf() != null && FrsGameSubPbActivity.this.irH.cjf().getTop() == 0;
                }
                this.irN = false;
                return false;
            }
        });
        this.irH.e(this.irI);
        this.irH.pa(true);
        this.irH.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.irJ != null) {
                    FrsGameSubPbActivity.this.irJ.kP(true);
                }
            }
        });
        this.irJ = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.irM);
        this.irJ.a(new a.InterfaceC0683a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0683a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.irI != null && FrsGameSubPbActivity.this.irI.ctX()) {
                    FrsGameSubPbActivity.this.irI.yA(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.irH.getRootView());
                    FrsGameSubPbActivity.this.irH.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.irJ.IY(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.irH.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.irI != null) {
                        FrsGameSubPbActivity.this.irI.ctV();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0683a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.irH.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.irK = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0683a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.irH.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.irL = true;
                }
            }
        });
        this.irJ.kP(false);
    }

    private void bNr() {
        this.aTZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.irH != null) && view == FrsGameSubPbActivity.this.irH.cuh() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.irI != null) {
                        FrsGameSubPbActivity.this.irI.ctV();
                    }
                    FrsGameSubPbActivity.this.irH.Ja(null);
                }
            }
        };
    }

    private void bZW() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.irM = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.irH.onChangeSkinType(i);
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
        this.irJ.kP(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.irH != null) {
            this.irH.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.irK || this.irL) {
            setResult(1002);
        }
        super.finish();
    }
}
