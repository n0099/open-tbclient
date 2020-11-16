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
    private View.OnClickListener aYm;
    private com.baidu.tieba.frs.gamesubpb.view.a iZF;
    private c iZG;
    private com.baidu.tieba.frs.gamesubpb.model.a iZH;
    private boolean iZI;
    private boolean iZJ;
    private String iZK;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        cir();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.iZK)) {
            finish();
        }
        bVF();
        this.iZF = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aYm, this.iZK);
        setContentView(this.iZF.getRootView());
        this.iZG = new c(this, this.iZF.getListView(), this.iZF.bSa());
        this.iZG.cCF();
        this.iZG.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean iZL = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cCB() {
                FrsGameSubPbActivity.this.iZF.qj(false);
                this.iZL = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cCC() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cCD() {
                if (!this.iZL) {
                    return FrsGameSubPbActivity.this.iZF.crM() != null && FrsGameSubPbActivity.this.iZF.crM().getTop() == 0;
                }
                this.iZL = false;
                return false;
            }
        });
        this.iZF.e(this.iZG);
        this.iZF.qj(true);
        this.iZF.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.iZH != null) {
                    FrsGameSubPbActivity.this.iZH.lP(true);
                }
            }
        });
        this.iZH = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.iZK);
        this.iZH.a(new a.InterfaceC0732a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0732a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.iZG != null && FrsGameSubPbActivity.this.iZG.cCG()) {
                    FrsGameSubPbActivity.this.iZG.Ak(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.iZF.getRootView());
                    FrsGameSubPbActivity.this.iZF.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.iZH.Kc(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.iZF.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.iZG != null) {
                        FrsGameSubPbActivity.this.iZG.cCE();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0732a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.iZF.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.iZI = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0732a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.iZF.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.iZJ = true;
                }
            }
        });
        this.iZH.lP(false);
    }

    private void bVF() {
        this.aYm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.iZF != null) && view == FrsGameSubPbActivity.this.iZF.cCQ() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.iZG != null) {
                        FrsGameSubPbActivity.this.iZG.cCE();
                    }
                    FrsGameSubPbActivity.this.iZF.Ke(null);
                }
            }
        };
    }

    private void cir() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.iZK = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iZF.onChangeSkinType(i);
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
        this.iZH.lP(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iZF != null) {
            this.iZF.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.iZI || this.iZJ) {
            setResult(1002);
        }
        super.finish();
    }
}
