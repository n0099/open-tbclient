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
/* loaded from: classes6.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener ahD;
    private com.baidu.tieba.frs.gamesubpb.view.a gxK;
    private c gxL;
    private com.baidu.tieba.frs.gamesubpb.model.a gxM;
    private boolean gxN;
    private boolean gxO;
    private String gxP;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bds();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.gxP)) {
            finish();
        }
        initListeners();
        this.gxK = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.ahD, this.gxP);
        setContentView(this.gxK.getRootView());
        this.gxL = new c(this, this.gxK.getListView(), this.gxK.bcb());
        this.gxL.bFw();
        this.gxL.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean gxQ = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bFs() {
                FrsGameSubPbActivity.this.gxK.lF(false);
                this.gxQ = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bFt() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bFu() {
                if (!this.gxQ) {
                    return FrsGameSubPbActivity.this.gxK.bvV() != null && FrsGameSubPbActivity.this.gxK.bvV().getTop() == 0;
                }
                this.gxQ = false;
                return false;
            }
        });
        this.gxK.e(this.gxL);
        this.gxK.lF(true);
        this.gxK.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.gxM != null) {
                    FrsGameSubPbActivity.this.gxM.loadData(true);
                }
            }
        });
        this.gxM = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.gxP);
        this.gxM.a(new a.InterfaceC0498a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0498a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.gxL != null && FrsGameSubPbActivity.this.gxL.bFx()) {
                    FrsGameSubPbActivity.this.gxL.tp(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.gxK.getRootView());
                    FrsGameSubPbActivity.this.gxK.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.gxM.AO(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.gxK.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.gxL != null) {
                        FrsGameSubPbActivity.this.gxL.bFv();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0498a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gxK.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gxN = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0498a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gxK.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gxO = true;
                }
            }
        });
        this.gxM.loadData(false);
    }

    private void initListeners() {
        this.ahD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.gxK != null) && view == FrsGameSubPbActivity.this.gxK.bFI() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.gxL != null) {
                        FrsGameSubPbActivity.this.gxL.bFv();
                    }
                    FrsGameSubPbActivity.this.gxK.AQ(null);
                }
            }
        };
    }

    private void bds() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.gxP = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gxK.onChangeSkinType(i);
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
        this.gxM.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gxK != null) {
            this.gxK.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.gxN || this.gxO) {
            setResult(1002);
        }
        super.finish();
    }
}
