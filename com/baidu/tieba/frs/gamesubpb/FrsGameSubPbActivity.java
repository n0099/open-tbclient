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
/* loaded from: classes7.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener ain;
    private com.baidu.tieba.frs.gamesubpb.view.a gAU;
    private c gAV;
    private com.baidu.tieba.frs.gamesubpb.model.a gAW;
    private boolean gAX;
    private boolean gAY;
    private String gAZ;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bdN();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.gAZ)) {
            finish();
        }
        initListeners();
        this.gAU = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.ain, this.gAZ);
        setContentView(this.gAU.getRootView());
        this.gAV = new c(this, this.gAU.getListView(), this.gAU.bcw());
        this.gAV.bGy();
        this.gAV.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean gBa = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bGu() {
                FrsGameSubPbActivity.this.gAU.lQ(false);
                this.gBa = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bGv() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bGw() {
                if (!this.gBa) {
                    return FrsGameSubPbActivity.this.gAU.bwX() != null && FrsGameSubPbActivity.this.gAU.bwX().getTop() == 0;
                }
                this.gBa = false;
                return false;
            }
        });
        this.gAU.e(this.gAV);
        this.gAU.lQ(true);
        this.gAU.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.gAW != null) {
                    FrsGameSubPbActivity.this.gAW.loadData(true);
                }
            }
        });
        this.gAW = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.gAZ);
        this.gAW.a(new a.InterfaceC0502a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0502a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.gAV != null && FrsGameSubPbActivity.this.gAV.bGz()) {
                    FrsGameSubPbActivity.this.gAV.tu(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.gAU.getRootView());
                    FrsGameSubPbActivity.this.gAU.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.gAW.AY(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.gAU.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.gAV != null) {
                        FrsGameSubPbActivity.this.gAV.bGx();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0502a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gAU.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gAX = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0502a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gAU.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gAY = true;
                }
            }
        });
        this.gAW.loadData(false);
    }

    private void initListeners() {
        this.ain = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.gAU != null) && view == FrsGameSubPbActivity.this.gAU.bGK() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.gAV != null) {
                        FrsGameSubPbActivity.this.gAV.bGx();
                    }
                    FrsGameSubPbActivity.this.gAU.Ba(null);
                }
            }
        };
    }

    private void bdN() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.gAZ = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gAU.onChangeSkinType(i);
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
        this.gAW.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gAU != null) {
            this.gAU.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.gAX || this.gAY) {
            setResult(1002);
        }
        super.finish();
    }
}
