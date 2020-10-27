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
    private View.OnClickListener aYF;
    private com.baidu.tieba.frs.gamesubpb.view.a iSW;
    private c iSX;
    private com.baidu.tieba.frs.gamesubpb.model.a iSY;
    private boolean iSZ;
    private boolean iTa;
    private String iTb;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        cgw();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.iTb)) {
            finish();
        }
        bTF();
        this.iSW = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aYF, this.iTb);
        setContentView(this.iSW.getRootView());
        this.iSX = new c(this, this.iSW.getListView(), this.iSW.bQh());
        this.iSX.cAA();
        this.iSX.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean iTc = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cAw() {
                FrsGameSubPbActivity.this.iSW.pX(false);
                this.iTc = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cAx() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cAy() {
                if (!this.iTc) {
                    return FrsGameSubPbActivity.this.iSW.cpI() != null && FrsGameSubPbActivity.this.iSW.cpI().getTop() == 0;
                }
                this.iTc = false;
                return false;
            }
        });
        this.iSW.e(this.iSX);
        this.iSW.pX(true);
        this.iSW.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.iSY != null) {
                    FrsGameSubPbActivity.this.iSY.lF(true);
                }
            }
        });
        this.iSY = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.iTb);
        this.iSY.a(new a.InterfaceC0717a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0717a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.iSX != null && FrsGameSubPbActivity.this.iSX.cAB()) {
                    FrsGameSubPbActivity.this.iSX.zz(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.iSW.getRootView());
                    FrsGameSubPbActivity.this.iSW.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.iSY.Kk(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.iSW.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.iSX != null) {
                        FrsGameSubPbActivity.this.iSX.cAz();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0717a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.iSW.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.iSZ = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0717a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.iSW.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.iTa = true;
                }
            }
        });
        this.iSY.lF(false);
    }

    private void bTF() {
        this.aYF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.iSW != null) && view == FrsGameSubPbActivity.this.iSW.cAL() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.iSX != null) {
                        FrsGameSubPbActivity.this.iSX.cAz();
                    }
                    FrsGameSubPbActivity.this.iSW.Km(null);
                }
            }
        };
    }

    private void cgw() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.iTb = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iSW.onChangeSkinType(i);
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
        this.iSY.lF(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iSW != null) {
            this.iSW.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.iSZ || this.iTa) {
            setResult(1002);
        }
        super.finish();
    }
}
