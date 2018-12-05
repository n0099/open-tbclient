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
    private com.baidu.tieba.frs.gamesubpb.view.a dWj;
    private c dWk;
    private com.baidu.tieba.frs.gamesubpb.model.a dWl;
    private boolean dWm;
    private boolean dWn;
    private String dWo;
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
        amd();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dWo)) {
            finish();
        }
        aEW();
        this.dWj = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dWo);
        setContentView(this.dWj.getRootView());
        this.dWk = new c(this, this.dWj.getListView(), this.dWj.abU());
        this.dWk.aFb();
        this.dWk.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dWp = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aEX() {
                FrsGameSubPbActivity.this.dWj.hg(false);
                this.dWp = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aEY() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean aEZ() {
                if (!this.dWp) {
                    return FrsGameSubPbActivity.this.dWj.aFn() != null && FrsGameSubPbActivity.this.dWj.aFn().getTop() == 0;
                }
                this.dWp = false;
                return false;
            }
        });
        this.dWj.e(this.dWk);
        this.dWj.hg(true);
        this.dWj.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dWl != null) {
                    FrsGameSubPbActivity.this.dWl.loadData(true);
                }
            }
        });
        this.dWl = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dWo);
        this.dWl.a(new a.InterfaceC0226a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0226a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.dWk != null && FrsGameSubPbActivity.this.dWk.aFc()) {
                    FrsGameSubPbActivity.this.dWk.mO(e.d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dWj.getRootView());
                    FrsGameSubPbActivity.this.dWj.a(z2, bVar, list);
                    if (!v.I(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof d) {
                            FrsGameSubPbActivity.this.dWl.op(((d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(e.C0210e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dWj.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(e.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dWk != null) {
                        FrsGameSubPbActivity.this.dWk.aFa();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0226a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dWj.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dWm = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0226a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dWj.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dWn = true;
                }
            }
        });
        this.dWl.loadData(false);
    }

    private void aEW() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dWj != null) && view == FrsGameSubPbActivity.this.dWj.aFo() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dWk != null) {
                        FrsGameSubPbActivity.this.dWk.aFa();
                    }
                    FrsGameSubPbActivity.this.dWj.or(null);
                }
            }
        };
    }

    private void amd() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dWo = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dWj.onChangeSkinType(i);
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
        this.dWl.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dWj != null) {
            this.dWj.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dWm || this.dWn) {
            setResult(1002);
        }
        super.finish();
    }
}
