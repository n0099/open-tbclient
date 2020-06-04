package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.o;
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
    private View.OnClickListener aIH;
    private com.baidu.tieba.frs.gamesubpb.view.a hDj;
    private c hDk;
    private com.baidu.tieba.frs.gamesubpb.model.a hDl;
    private boolean hDm;
    private boolean hDn;
    private String hDo;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bHL();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.hDo)) {
            finish();
        }
        bwC();
        this.hDj = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aIH, this.hDo);
        setContentView(this.hDj.getRootView());
        this.hDk = new c(this, this.hDj.getListView(), this.hDj.bua());
        this.hDk.bZq();
        this.hDk.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean hDp = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bZm() {
                FrsGameSubPbActivity.this.hDj.nx(false);
                this.hDp = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bZn() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bZo() {
                if (!this.hDp) {
                    return FrsGameSubPbActivity.this.hDj.bPb() != null && FrsGameSubPbActivity.this.hDj.bPb().getTop() == 0;
                }
                this.hDp = false;
                return false;
            }
        });
        this.hDj.e(this.hDk);
        this.hDj.nx(true);
        this.hDj.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.hDl != null) {
                    FrsGameSubPbActivity.this.hDl.jw(true);
                }
            }
        });
        this.hDl = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.hDo);
        this.hDl.a(new a.InterfaceC0617a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0617a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<o> list) {
                if (FrsGameSubPbActivity.this.hDk != null && FrsGameSubPbActivity.this.hDk.bZr()) {
                    FrsGameSubPbActivity.this.hDk.uL(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.hDj.getRootView());
                    FrsGameSubPbActivity.this.hDj.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        o oVar = list.get(list.size() - 1);
                        if (oVar instanceof d) {
                            FrsGameSubPbActivity.this.hDl.EL(((d) oVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.hDj.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.hDk != null) {
                        FrsGameSubPbActivity.this.hDk.bZp();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0617a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hDj.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hDm = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0617a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hDj.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hDn = true;
                }
            }
        });
        this.hDl.jw(false);
    }

    private void bwC() {
        this.aIH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.hDj != null) && view == FrsGameSubPbActivity.this.hDj.bZC() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.hDk != null) {
                        FrsGameSubPbActivity.this.hDk.bZp();
                    }
                    FrsGameSubPbActivity.this.hDj.EN(null);
                }
            }
        };
    }

    private void bHL() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.hDo = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hDj.onChangeSkinType(i);
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
        this.hDl.jw(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hDj != null) {
            this.hDj.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.hDm || this.hDn) {
            setResult(1002);
        }
        super.finish();
    }
}
