package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private com.baidu.tieba.frs.gamesubpb.view.a dkP;
    private c dkQ;
    private com.baidu.tieba.frs.gamesubpb.model.a dkR;
    private boolean dkS;
    private boolean dkT;
    private String dkU;
    private View.OnClickListener mCommonClickListener;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        abD();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dkU)) {
            finish();
        }
        asU();
        this.dkP = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dkU);
        setContentView(this.dkP.getRootView());
        this.dkQ = new c(this, this.dkP.getListView(), this.dkP.Rd());
        this.dkQ.asZ();
        this.dkQ.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dkV = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void asV() {
                FrsGameSubPbActivity.this.dkP.fQ(false);
                this.dkV = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void asW() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean asX() {
                if (!this.dkV) {
                    return FrsGameSubPbActivity.this.dkP.atl() != null && FrsGameSubPbActivity.this.dkP.atl().getTop() == 0;
                }
                this.dkV = false;
                return false;
            }
        });
        this.dkP.e(this.dkQ);
        this.dkP.fQ(true);
        this.dkP.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dkR != null) {
                    FrsGameSubPbActivity.this.dkR.loadData(true);
                }
            }
        });
        this.dkR = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dkU);
        this.dkR.a(new a.InterfaceC0141a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0141a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.dkQ != null && FrsGameSubPbActivity.this.dkQ.ata()) {
                    FrsGameSubPbActivity.this.dkQ.kK(d.C0126d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dkP.getRootView());
                    FrsGameSubPbActivity.this.dkP.a(z2, bVar, list);
                    if (!v.w(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof com.baidu.tieba.frs.gamesubpb.model.d) {
                            FrsGameSubPbActivity.this.dkR.ma(((com.baidu.tieba.frs.gamesubpb.model.d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(d.e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dkP.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(d.k.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dkQ != null) {
                        FrsGameSubPbActivity.this.dkQ.asY();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0141a
            public void a(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dkP.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dkS = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0141a
            public void b(boolean z, int i, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                FrsGameSubPbActivity.this.dkP.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dkT = true;
                }
            }
        });
        this.dkR.loadData(false);
    }

    private void asU() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if ((view2 != null || FrsGameSubPbActivity.this.dkP != null) && view2 == FrsGameSubPbActivity.this.dkP.atm() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dkQ != null) {
                        FrsGameSubPbActivity.this.dkQ.asY();
                    }
                    FrsGameSubPbActivity.this.dkP.mc(null);
                }
            }
        };
    }

    private void abD() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dkU = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dkP.onChangeSkinType(i);
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
        this.dkR.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dkP != null) {
            this.dkP.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dkS || this.dkT) {
            setResult(1002);
        }
        super.finish();
    }
}
