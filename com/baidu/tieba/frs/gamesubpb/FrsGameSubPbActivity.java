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
    private com.baidu.tieba.frs.gamesubpb.view.a gCU;
    private c gCV;
    private com.baidu.tieba.frs.gamesubpb.model.a gCW;
    private boolean gCX;
    private boolean gCY;
    private String gCZ;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bfX();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.gCZ)) {
            finish();
        }
        initListeners();
        this.gCU = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.akt, this.gCZ);
        setContentView(this.gCU.getRootView());
        this.gCV = new c(this, this.gCU.getListView(), this.gCU.beJ());
        this.gCV.bIa();
        this.gCV.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean gDa = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bHW() {
                FrsGameSubPbActivity.this.gCU.lT(false);
                this.gDa = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bHX() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bHY() {
                if (!this.gDa) {
                    return FrsGameSubPbActivity.this.gCU.byC() != null && FrsGameSubPbActivity.this.gCU.byC().getTop() == 0;
                }
                this.gDa = false;
                return false;
            }
        });
        this.gCU.e(this.gCV);
        this.gCU.lT(true);
        this.gCU.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.gCW != null) {
                    FrsGameSubPbActivity.this.gCW.loadData(true);
                }
            }
        });
        this.gCW = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.gCZ);
        this.gCW.a(new a.InterfaceC0509a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.gCV != null && FrsGameSubPbActivity.this.gCV.bIb()) {
                    FrsGameSubPbActivity.this.gCV.tA(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.gCU.getRootView());
                    FrsGameSubPbActivity.this.gCU.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.gCW.Bo(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.gCU.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.gCV != null) {
                        FrsGameSubPbActivity.this.gCV.bHZ();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gCU.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gCX = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gCU.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gCY = true;
                }
            }
        });
        this.gCW.loadData(false);
    }

    private void initListeners() {
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.gCU != null) && view == FrsGameSubPbActivity.this.gCU.bIm() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.gCV != null) {
                        FrsGameSubPbActivity.this.gCV.bHZ();
                    }
                    FrsGameSubPbActivity.this.gCU.Bq(null);
                }
            }
        };
    }

    private void bfX() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.gCZ = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gCU.onChangeSkinType(i);
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
        this.gCW.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gCU != null) {
            this.gCU.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.gCX || this.gCY) {
            setResult(1002);
        }
        super.finish();
    }
}
