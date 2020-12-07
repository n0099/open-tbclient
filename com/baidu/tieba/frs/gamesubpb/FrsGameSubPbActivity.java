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
    private View.OnClickListener bbH;
    private com.baidu.tieba.frs.gamesubpb.view.a jnf;
    private c jng;
    private com.baidu.tieba.frs.gamesubpb.model.a jnh;
    private boolean jni;
    private boolean jnj;
    private String jnk;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        cml();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.jnk)) {
            finish();
        }
        bZp();
        this.jnf = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.bbH, this.jnk);
        setContentView(this.jnf.getRootView());
        this.jng = new c(this, this.jnf.getListView(), this.jnf.bVK());
        this.jng.cHQ();
        this.jng.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean jnl = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cHM() {
                FrsGameSubPbActivity.this.jnf.qK(false);
                this.jnl = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cHN() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cHO() {
                if (!this.jnl) {
                    return FrsGameSubPbActivity.this.jnf.cwb() != null && FrsGameSubPbActivity.this.jnf.cwb().getTop() == 0;
                }
                this.jnl = false;
                return false;
            }
        });
        this.jnf.e(this.jng);
        this.jnf.qK(true);
        this.jnf.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.jnh != null) {
                    FrsGameSubPbActivity.this.jnh.mk(true);
                }
            }
        });
        this.jnh = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.jnk);
        this.jnh.a(new a.InterfaceC0748a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0748a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.jng != null && FrsGameSubPbActivity.this.jng.cHR()) {
                    FrsGameSubPbActivity.this.jng.AY(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.jnf.getRootView());
                    FrsGameSubPbActivity.this.jnf.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.jnh.Li(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.jnf.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.jng != null) {
                        FrsGameSubPbActivity.this.jng.cHP();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0748a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jnf.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jni = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0748a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jnf.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jnj = true;
                }
            }
        });
        this.jnh.mk(false);
    }

    private void bZp() {
        this.bbH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.jnf != null) && view == FrsGameSubPbActivity.this.jnf.cIb() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.jng != null) {
                        FrsGameSubPbActivity.this.jng.cHP();
                    }
                    FrsGameSubPbActivity.this.jnf.Lk(null);
                }
            }
        };
    }

    private void cml() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.jnk = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jnf.onChangeSkinType(i);
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
        this.jnh.mk(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jnf != null) {
            this.jnf.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.jni || this.jnj) {
            setResult(1002);
        }
        super.finish();
    }
}
