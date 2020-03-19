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
/* loaded from: classes9.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener akE;
    private com.baidu.tieba.frs.gamesubpb.view.a gEg;
    private c gEh;
    private com.baidu.tieba.frs.gamesubpb.model.a gEi;
    private boolean gEj;
    private boolean gEk;
    private String gEl;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bgf();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.gEl)) {
            finish();
        }
        initListeners();
        this.gEg = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.akE, this.gEl);
        setContentView(this.gEg.getRootView());
        this.gEh = new c(this, this.gEg.getListView(), this.gEg.beR());
        this.gEh.bIp();
        this.gEh.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean gEm = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bIl() {
                FrsGameSubPbActivity.this.gEg.lY(false);
                this.gEm = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bIm() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bIn() {
                if (!this.gEm) {
                    return FrsGameSubPbActivity.this.gEg.byL() != null && FrsGameSubPbActivity.this.gEg.byL().getTop() == 0;
                }
                this.gEm = false;
                return false;
            }
        });
        this.gEg.e(this.gEh);
        this.gEg.lY(true);
        this.gEg.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.gEi != null) {
                    FrsGameSubPbActivity.this.gEi.loadData(true);
                }
            }
        });
        this.gEi = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.gEl);
        this.gEi.a(new a.InterfaceC0509a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.gEh != null && FrsGameSubPbActivity.this.gEh.bIq()) {
                    FrsGameSubPbActivity.this.gEh.tG(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.gEg.getRootView());
                    FrsGameSubPbActivity.this.gEg.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.gEi.Bp(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.gEg.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.gEh != null) {
                        FrsGameSubPbActivity.this.gEh.bIo();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gEg.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gEj = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gEg.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gEk = true;
                }
            }
        });
        this.gEi.loadData(false);
    }

    private void initListeners() {
        this.akE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.gEg != null) && view == FrsGameSubPbActivity.this.gEg.bIB() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.gEh != null) {
                        FrsGameSubPbActivity.this.gEh.bIo();
                    }
                    FrsGameSubPbActivity.this.gEg.Br(null);
                }
            }
        };
    }

    private void bgf() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.gEl = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gEg.onChangeSkinType(i);
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
        this.gEi.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gEg != null) {
            this.gEg.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.gEj || this.gEk) {
            setResult(1002);
        }
        super.finish();
    }
}
