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
    private View.OnClickListener aZX;
    private com.baidu.tieba.frs.gamesubpb.view.a iYT;
    private c iYU;
    private com.baidu.tieba.frs.gamesubpb.model.a iYV;
    private boolean iYW;
    private boolean iYX;
    private String iYY;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        ciY();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.iYY)) {
            finish();
        }
        bWm();
        this.iYT = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aZX, this.iYY);
        setContentView(this.iYT.getRootView());
        this.iYU = new c(this, this.iYT.getListView(), this.iYT.bSH());
        this.iYU.cDb();
        this.iYU.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean iYZ = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cCX() {
                FrsGameSubPbActivity.this.iYT.qg(false);
                this.iYZ = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cCY() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cCZ() {
                if (!this.iYZ) {
                    return FrsGameSubPbActivity.this.iYT.csj() != null && FrsGameSubPbActivity.this.iYT.csj().getTop() == 0;
                }
                this.iYZ = false;
                return false;
            }
        });
        this.iYT.e(this.iYU);
        this.iYT.qg(true);
        this.iYT.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.iYV != null) {
                    FrsGameSubPbActivity.this.iYV.lO(true);
                }
            }
        });
        this.iYV = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.iYY);
        this.iYV.a(new a.InterfaceC0731a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0731a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.iYU != null && FrsGameSubPbActivity.this.iYU.cDc()) {
                    FrsGameSubPbActivity.this.iYU.zM(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.iYT.getRootView());
                    FrsGameSubPbActivity.this.iYT.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.iYV.KB(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.iYT.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.iYU != null) {
                        FrsGameSubPbActivity.this.iYU.cDa();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0731a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.iYT.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.iYW = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0731a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.iYT.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.iYX = true;
                }
            }
        });
        this.iYV.lO(false);
    }

    private void bWm() {
        this.aZX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.iYT != null) && view == FrsGameSubPbActivity.this.iYT.cDm() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.iYU != null) {
                        FrsGameSubPbActivity.this.iYU.cDa();
                    }
                    FrsGameSubPbActivity.this.iYT.KD(null);
                }
            }
        };
    }

    private void ciY() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.iYY = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iYT.onChangeSkinType(i);
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
        this.iYV.lO(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iYT != null) {
            this.iYT.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.iYW || this.iYX) {
            setResult(1002);
        }
        super.finish();
    }
}
