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
    private View.OnClickListener akt;
    private com.baidu.tieba.frs.gamesubpb.view.a gCW;
    private c gCX;
    private com.baidu.tieba.frs.gamesubpb.model.a gCY;
    private boolean gCZ;
    private boolean gDa;
    private String gDb;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bfZ();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.gDb)) {
            finish();
        }
        initListeners();
        this.gCW = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.akt, this.gDb);
        setContentView(this.gCW.getRootView());
        this.gCX = new c(this, this.gCW.getListView(), this.gCW.beL());
        this.gCX.bIc();
        this.gCX.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean gDc = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bHY() {
                FrsGameSubPbActivity.this.gCW.lT(false);
                this.gDc = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bHZ() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bIa() {
                if (!this.gDc) {
                    return FrsGameSubPbActivity.this.gCW.byE() != null && FrsGameSubPbActivity.this.gCW.byE().getTop() == 0;
                }
                this.gDc = false;
                return false;
            }
        });
        this.gCW.e(this.gCX);
        this.gCW.lT(true);
        this.gCW.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.gCY != null) {
                    FrsGameSubPbActivity.this.gCY.loadData(true);
                }
            }
        });
        this.gCY = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.gDb);
        this.gCY.a(new a.InterfaceC0509a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.gCX != null && FrsGameSubPbActivity.this.gCX.bId()) {
                    FrsGameSubPbActivity.this.gCX.tA(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.gCW.getRootView());
                    FrsGameSubPbActivity.this.gCW.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.gCY.Bo(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.gCW.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.gCX != null) {
                        FrsGameSubPbActivity.this.gCX.bIb();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gCW.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gCZ = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gCW.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gDa = true;
                }
            }
        });
        this.gCY.loadData(false);
    }

    private void initListeners() {
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.gCW != null) && view == FrsGameSubPbActivity.this.gCW.bIo() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.gCX != null) {
                        FrsGameSubPbActivity.this.gCX.bIb();
                    }
                    FrsGameSubPbActivity.this.gCW.Bq(null);
                }
            }
        };
    }

    private void bfZ() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.gDb = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gCW.onChangeSkinType(i);
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
        this.gCY.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gCW != null) {
            this.gCW.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.gCZ || this.gDa) {
            setResult(1002);
        }
        super.finish();
    }
}
