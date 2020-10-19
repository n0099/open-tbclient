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
/* loaded from: classes22.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener aXk;
    private com.baidu.tieba.frs.gamesubpb.view.a iGA;
    private c iGB;
    private com.baidu.tieba.frs.gamesubpb.model.a iGC;
    private boolean iGD;
    private boolean iGE;
    private String iGF;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        cdu();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.iGF)) {
            finish();
        }
        bQI();
        this.iGA = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aXk, this.iGF);
        setContentView(this.iGA.getRootView());
        this.iGB = new c(this, this.iGA.getListView(), this.iGA.bNC());
        this.iGB.cxt();
        this.iGB.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean iGG = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cxp() {
                FrsGameSubPbActivity.this.iGA.pF(false);
                this.iGG = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cxq() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cxr() {
                if (!this.iGG) {
                    return FrsGameSubPbActivity.this.iGA.cmB() != null && FrsGameSubPbActivity.this.iGA.cmB().getTop() == 0;
                }
                this.iGG = false;
                return false;
            }
        });
        this.iGA.e(this.iGB);
        this.iGA.pF(true);
        this.iGA.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.iGC != null) {
                    FrsGameSubPbActivity.this.iGC.ln(true);
                }
            }
        });
        this.iGC = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.iGF);
        this.iGC.a(new a.InterfaceC0701a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0701a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.iGB != null && FrsGameSubPbActivity.this.iGB.cxu()) {
                    FrsGameSubPbActivity.this.iGB.zg(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.iGA.getRootView());
                    FrsGameSubPbActivity.this.iGA.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.iGC.JL(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.iGA.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.iGB != null) {
                        FrsGameSubPbActivity.this.iGB.cxs();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0701a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.iGA.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.iGD = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0701a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.iGA.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.iGE = true;
                }
            }
        });
        this.iGC.ln(false);
    }

    private void bQI() {
        this.aXk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.iGA != null) && view == FrsGameSubPbActivity.this.iGA.cxE() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.iGB != null) {
                        FrsGameSubPbActivity.this.iGB.cxs();
                    }
                    FrsGameSubPbActivity.this.iGA.JN(null);
                }
            }
        };
    }

    private void cdu() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.iGF = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iGA.onChangeSkinType(i);
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
        this.iGC.ln(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iGA != null) {
            this.iGA.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.iGD || this.iGE) {
            setResult(1002);
        }
        super.finish();
    }
}
