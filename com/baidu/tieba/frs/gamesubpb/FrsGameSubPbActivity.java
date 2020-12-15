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
    private com.baidu.tieba.frs.gamesubpb.view.a jnh;
    private c jni;
    private com.baidu.tieba.frs.gamesubpb.model.a jnj;
    private boolean jnk;
    private boolean jnl;
    private String jnm;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        cmm();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.jnm)) {
            finish();
        }
        bZq();
        this.jnh = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.bbH, this.jnm);
        setContentView(this.jnh.getRootView());
        this.jni = new c(this, this.jnh.getListView(), this.jnh.bVL());
        this.jni.cHR();
        this.jni.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean jnn = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cHN() {
                FrsGameSubPbActivity.this.jnh.qK(false);
                this.jnn = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cHO() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cHP() {
                if (!this.jnn) {
                    return FrsGameSubPbActivity.this.jnh.cwc() != null && FrsGameSubPbActivity.this.jnh.cwc().getTop() == 0;
                }
                this.jnn = false;
                return false;
            }
        });
        this.jnh.e(this.jni);
        this.jnh.qK(true);
        this.jnh.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.jnj != null) {
                    FrsGameSubPbActivity.this.jnj.mk(true);
                }
            }
        });
        this.jnj = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.jnm);
        this.jnj.a(new a.InterfaceC0748a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0748a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.jni != null && FrsGameSubPbActivity.this.jni.cHS()) {
                    FrsGameSubPbActivity.this.jni.AY(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.jnh.getRootView());
                    FrsGameSubPbActivity.this.jnh.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.jnj.Li(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.jnh.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.jni != null) {
                        FrsGameSubPbActivity.this.jni.cHQ();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0748a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jnh.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jnk = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0748a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jnh.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jnl = true;
                }
            }
        });
        this.jnj.mk(false);
    }

    private void bZq() {
        this.bbH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.jnh != null) && view == FrsGameSubPbActivity.this.jnh.cIc() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.jni != null) {
                        FrsGameSubPbActivity.this.jni.cHQ();
                    }
                    FrsGameSubPbActivity.this.jnh.Lk(null);
                }
            }
        };
    }

    private void cmm() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.jnm = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jnh.onChangeSkinType(i);
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
        this.jnj.mk(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jnh != null) {
            this.jnh.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.jnk || this.jnl) {
            setResult(1002);
        }
        super.finish();
    }
}
