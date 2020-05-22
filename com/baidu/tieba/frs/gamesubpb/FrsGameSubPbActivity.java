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
    private boolean hCA;
    private String hCB;
    private com.baidu.tieba.frs.gamesubpb.view.a hCw;
    private c hCx;
    private com.baidu.tieba.frs.gamesubpb.model.a hCy;
    private boolean hCz;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bHJ();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.hCB)) {
            finish();
        }
        bwA();
        this.hCw = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aIH, this.hCB);
        setContentView(this.hCw.getRootView());
        this.hCx = new c(this, this.hCw.getListView(), this.hCw.btY());
        this.hCx.bZi();
        this.hCx.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean hCC = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bZe() {
                FrsGameSubPbActivity.this.hCw.nx(false);
                this.hCC = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bZf() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bZg() {
                if (!this.hCC) {
                    return FrsGameSubPbActivity.this.hCw.bOZ() != null && FrsGameSubPbActivity.this.hCw.bOZ().getTop() == 0;
                }
                this.hCC = false;
                return false;
            }
        });
        this.hCw.e(this.hCx);
        this.hCw.nx(true);
        this.hCw.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.hCy != null) {
                    FrsGameSubPbActivity.this.hCy.jw(true);
                }
            }
        });
        this.hCy = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.hCB);
        this.hCy.a(new a.InterfaceC0617a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0617a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<o> list) {
                if (FrsGameSubPbActivity.this.hCx != null && FrsGameSubPbActivity.this.hCx.bZj()) {
                    FrsGameSubPbActivity.this.hCx.uJ(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.hCw.getRootView());
                    FrsGameSubPbActivity.this.hCw.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        o oVar = list.get(list.size() - 1);
                        if (oVar instanceof d) {
                            FrsGameSubPbActivity.this.hCy.EL(((d) oVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.hCw.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.hCx != null) {
                        FrsGameSubPbActivity.this.hCx.bZh();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0617a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hCw.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hCz = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0617a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hCw.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hCA = true;
                }
            }
        });
        this.hCy.jw(false);
    }

    private void bwA() {
        this.aIH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.hCw != null) && view == FrsGameSubPbActivity.this.hCw.bZu() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.hCx != null) {
                        FrsGameSubPbActivity.this.hCx.bZh();
                    }
                    FrsGameSubPbActivity.this.hCw.EN(null);
                }
            }
        };
    }

    private void bHJ() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.hCB = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hCw.onChangeSkinType(i);
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
        this.hCy.jw(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hCw != null) {
            this.hCw.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.hCz || this.hCA) {
            setResult(1002);
        }
        super.finish();
    }
}
