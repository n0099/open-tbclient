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
    private View.OnClickListener aYB;
    private com.baidu.tieba.frs.gamesubpb.view.a juZ;
    private c jva;
    private com.baidu.tieba.frs.gamesubpb.model.a jvb;
    private boolean jvc;
    private boolean jvd;
    private String jve;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        clm();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.jve)) {
            finish();
        }
        bYg();
        this.juZ = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aYB, this.jve);
        setContentView(this.juZ.getRootView());
        this.jva = new c(this, this.juZ.getListView(), this.juZ.bUz());
        this.jva.cHa();
        this.jva.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean jvf = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cGW() {
                FrsGameSubPbActivity.this.juZ.re(false);
                this.jvf = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cGX() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cGY() {
                if (!this.jvf) {
                    return FrsGameSubPbActivity.this.juZ.cve() != null && FrsGameSubPbActivity.this.juZ.cve().getTop() == 0;
                }
                this.jvf = false;
                return false;
            }
        });
        this.juZ.e(this.jva);
        this.juZ.re(true);
        this.juZ.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.jvb != null) {
                    FrsGameSubPbActivity.this.jvb.mD(true);
                }
            }
        });
        this.jvb = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.jve);
        this.jvb.a(new a.InterfaceC0731a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0731a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<n> list) {
                if (FrsGameSubPbActivity.this.jva != null && FrsGameSubPbActivity.this.jva.cHb()) {
                    FrsGameSubPbActivity.this.jva.zE(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.juZ.getRootView());
                    FrsGameSubPbActivity.this.juZ.a(z2, bVar, list);
                    if (!x.isEmpty(list)) {
                        n nVar = list.get(list.size() - 1);
                        if (nVar instanceof d) {
                            FrsGameSubPbActivity.this.jvb.JX(((d) nVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.juZ.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.jva != null) {
                        FrsGameSubPbActivity.this.jva.cGZ();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0731a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.juZ.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jvc = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0731a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.juZ.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jvd = true;
                }
            }
        });
        this.jvb.mD(false);
    }

    private void bYg() {
        this.aYB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.juZ != null) && view == FrsGameSubPbActivity.this.juZ.cHl() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.jva != null) {
                        FrsGameSubPbActivity.this.jva.cGZ();
                    }
                    FrsGameSubPbActivity.this.juZ.JZ(null);
                }
            }
        };
    }

    private void clm() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.jve = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.juZ.onChangeSkinType(i);
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
        this.jvb.mD(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.juZ != null) {
            this.juZ.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.jvc || this.jvd) {
            setResult(1002);
        }
        super.finish();
    }
}
