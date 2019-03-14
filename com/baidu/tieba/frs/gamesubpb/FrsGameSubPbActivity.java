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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private com.baidu.tieba.frs.gamesubpb.view.a fnj;
    private c fnk;
    private com.baidu.tieba.frs.gamesubpb.model.a fnl;
    private boolean fnm;
    private boolean fnn;
    private String fno;
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
        aNR();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.fno)) {
            finish();
        }
        bgA();
        this.fnj = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.fno);
        setContentView(this.fnj.getRootView());
        this.fnk = new c(this, this.fnj.getListView(), this.fnj.aDp());
        this.fnk.bgF();
        this.fnk.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean fnp = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bgB() {
                FrsGameSubPbActivity.this.fnj.jH(false);
                this.fnp = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bgC() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bgD() {
                if (!this.fnp) {
                    return FrsGameSubPbActivity.this.fnj.bgR() != null && FrsGameSubPbActivity.this.fnj.bgR().getTop() == 0;
                }
                this.fnp = false;
                return false;
            }
        });
        this.fnj.e(this.fnk);
        this.fnj.jH(true);
        this.fnj.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.fnl != null) {
                    FrsGameSubPbActivity.this.fnl.loadData(true);
                }
            }
        });
        this.fnl = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.fno);
        this.fnl.a(new a.InterfaceC0294a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0294a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.fnk != null && FrsGameSubPbActivity.this.fnk.bgG()) {
                    FrsGameSubPbActivity.this.fnk.qP(d.C0277d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.fnj.getRootView());
                    FrsGameSubPbActivity.this.fnj.a(z2, bVar, list);
                    if (!v.T(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.fnl.vl(((com.baidu.tieba.frs.gamesubpb.model.d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.fnj.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.fnk != null) {
                        FrsGameSubPbActivity.this.fnk.bgE();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0294a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.fnj.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fnm = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0294a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.fnj.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fnn = true;
                }
            }
        });
        this.fnl.loadData(false);
    }

    private void bgA() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.fnj != null) && view == FrsGameSubPbActivity.this.fnj.bgS() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.fnk != null) {
                        FrsGameSubPbActivity.this.fnk.bgE();
                    }
                    FrsGameSubPbActivity.this.fnj.vn(null);
                }
            }
        };
    }

    private void aNR() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.fno = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fnj.onChangeSkinType(i);
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
        this.fnl.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fnj != null) {
            this.fnj.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.fnm || this.fnn) {
            setResult(1002);
        }
        super.finish();
    }
}
