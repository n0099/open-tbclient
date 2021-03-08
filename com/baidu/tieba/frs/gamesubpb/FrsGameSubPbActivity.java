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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener bdi;
    private com.baidu.tieba.frs.gamesubpb.view.a jCC;
    private c jCD;
    private com.baidu.tieba.frs.gamesubpb.model.a jCE;
    private boolean jCF;
    private boolean jCG;
    private String jCH;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        cmx();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.jCH)) {
            finish();
        }
        bZr();
        this.jCC = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.bdi, this.jCH);
        setContentView(this.jCC.getRootView());
        this.jCD = new c(this, this.jCC.getListView(), this.jCC.bVq());
        this.jCD.cIA();
        this.jCD.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean jCI = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cIw() {
                FrsGameSubPbActivity.this.jCC.ro(false);
                this.jCI = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cIx() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cIy() {
                if (!this.jCI) {
                    return FrsGameSubPbActivity.this.jCC.cwD() != null && FrsGameSubPbActivity.this.jCC.cwD().getTop() == 0;
                }
                this.jCI = false;
                return false;
            }
        });
        this.jCC.e(this.jCD);
        this.jCC.ro(true);
        this.jCC.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.jCE != null) {
                    FrsGameSubPbActivity.this.jCE.mH(true);
                }
            }
        });
        this.jCE = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.jCH);
        this.jCE.a(new a.InterfaceC0738a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0738a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<n> list) {
                if (FrsGameSubPbActivity.this.jCD != null && FrsGameSubPbActivity.this.jCD.cIB()) {
                    FrsGameSubPbActivity.this.jCD.zP(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.jCC.getRootView());
                    FrsGameSubPbActivity.this.jCC.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        n nVar = list.get(list.size() - 1);
                        if (nVar instanceof d) {
                            FrsGameSubPbActivity.this.jCE.KS(((d) nVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.jCC.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.jCD != null) {
                        FrsGameSubPbActivity.this.jCD.cIz();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0738a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jCC.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jCF = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0738a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jCC.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jCG = true;
                }
            }
        });
        this.jCE.mH(false);
    }

    private void bZr() {
        this.bdi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.jCC != null) && view == FrsGameSubPbActivity.this.jCC.cIL() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.jCD != null) {
                        FrsGameSubPbActivity.this.jCD.cIz();
                    }
                    FrsGameSubPbActivity.this.jCC.KU(null);
                }
            }
        };
    }

    private void cmx() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.jCH = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jCC.onChangeSkinType(i);
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
        this.jCE.mH(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jCC != null) {
            this.jCC.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.jCF || this.jCG) {
            setResult(1002);
        }
        super.finish();
    }
}
