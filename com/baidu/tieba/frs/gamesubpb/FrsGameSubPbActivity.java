package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener ZX;
    private com.baidu.tieba.frs.gamesubpb.view.a fKm;
    private c fKn;
    private com.baidu.tieba.frs.gamesubpb.model.a fKo;
    private boolean fKp;
    private boolean fKq;
    private String fKr;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        aXg();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.fKr)) {
            finish();
        }
        aNd();
        this.fKm = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.ZX, this.fKr);
        setContentView(this.fKm.getRootView());
        this.fKn = new c(this, this.fKm.getListView(), this.fKm.aKR());
        this.fKn.bob();
        this.fKn.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean fKs = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bnX() {
                FrsGameSubPbActivity.this.fKm.kt(false);
                this.fKs = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bnY() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bnZ() {
                if (!this.fKs) {
                    return FrsGameSubPbActivity.this.fKm.beD() != null && FrsGameSubPbActivity.this.fKm.beD().getTop() == 0;
                }
                this.fKs = false;
                return false;
            }
        });
        this.fKm.e(this.fKn);
        this.fKm.kt(true);
        this.fKm.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.fKo != null) {
                    FrsGameSubPbActivity.this.fKo.loadData(true);
                }
            }
        });
        this.fKo = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.fKr);
        this.fKo.a(new a.InterfaceC0415a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0415a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.fKn != null && FrsGameSubPbActivity.this.fKn.boc()) {
                    FrsGameSubPbActivity.this.fKn.rk(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.fKm.getRootView());
                    FrsGameSubPbActivity.this.fKm.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.fKo.vZ(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.fKm.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.fKn != null) {
                        FrsGameSubPbActivity.this.fKn.boa();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0415a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fKm.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fKp = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0415a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fKm.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fKq = true;
                }
            }
        });
        this.fKo.loadData(false);
    }

    private void aNd() {
        this.ZX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.fKm != null) && view == FrsGameSubPbActivity.this.fKm.bon() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.fKn != null) {
                        FrsGameSubPbActivity.this.fKn.boa();
                    }
                    FrsGameSubPbActivity.this.fKm.wb(null);
                }
            }
        };
    }

    private void aXg() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.fKr = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fKm.onChangeSkinType(i);
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
        this.fKo.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fKm != null) {
            this.fKm.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.fKp || this.fKq) {
            setResult(1002);
        }
        super.finish();
    }
}
