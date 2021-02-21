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
    private View.OnClickListener bbI;
    private com.baidu.tieba.frs.gamesubpb.view.a jAT;
    private c jAU;
    private com.baidu.tieba.frs.gamesubpb.model.a jAV;
    private boolean jAW;
    private boolean jAX;
    private String jAY;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        cmr();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.jAY)) {
            finish();
        }
        bZl();
        this.jAT = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.bbI, this.jAY);
        setContentView(this.jAT.getRootView());
        this.jAU = new c(this, this.jAT.getListView(), this.jAT.bVk());
        this.jAU.cIu();
        this.jAU.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean jAZ = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cIq() {
                FrsGameSubPbActivity.this.jAT.ro(false);
                this.jAZ = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cIr() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cIs() {
                if (!this.jAZ) {
                    return FrsGameSubPbActivity.this.jAT.cwx() != null && FrsGameSubPbActivity.this.jAT.cwx().getTop() == 0;
                }
                this.jAZ = false;
                return false;
            }
        });
        this.jAT.e(this.jAU);
        this.jAT.ro(true);
        this.jAT.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.jAV != null) {
                    FrsGameSubPbActivity.this.jAV.mH(true);
                }
            }
        });
        this.jAV = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.jAY);
        this.jAV.a(new a.InterfaceC0732a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0732a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<n> list) {
                if (FrsGameSubPbActivity.this.jAU != null && FrsGameSubPbActivity.this.jAU.cIv()) {
                    FrsGameSubPbActivity.this.jAU.zO(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.jAT.getRootView());
                    FrsGameSubPbActivity.this.jAT.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        n nVar = list.get(list.size() - 1);
                        if (nVar instanceof d) {
                            FrsGameSubPbActivity.this.jAV.KJ(((d) nVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.jAT.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.jAU != null) {
                        FrsGameSubPbActivity.this.jAU.cIt();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0732a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jAT.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jAW = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0732a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jAT.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jAX = true;
                }
            }
        });
        this.jAV.mH(false);
    }

    private void bZl() {
        this.bbI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.jAT != null) && view == FrsGameSubPbActivity.this.jAT.cIF() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.jAU != null) {
                        FrsGameSubPbActivity.this.jAU.cIt();
                    }
                    FrsGameSubPbActivity.this.jAT.KL(null);
                }
            }
        };
    }

    private void cmr() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.jAY = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jAT.onChangeSkinType(i);
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
        this.jAV.mH(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jAT != null) {
            this.jAT.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.jAW || this.jAX) {
            setResult(1002);
        }
        super.finish();
    }
}
