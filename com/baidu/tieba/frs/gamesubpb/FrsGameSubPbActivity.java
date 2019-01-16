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
import com.baidu.tieba.e;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private com.baidu.tieba.frs.gamesubpb.view.a dZG;
    private c dZH;
    private com.baidu.tieba.frs.gamesubpb.model.a dZI;
    private boolean dZJ;
    private boolean dZK;
    private String dZL;
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
        anc();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dZL)) {
            finish();
        }
        aGi();
        this.dZG = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dZL);
        setContentView(this.dZG.getRootView());
        this.dZH = new c(this, this.dZG.getListView(), this.dZG.act());
        this.dZH.aGn();
        this.dZH.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dZM = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aGj() {
                FrsGameSubPbActivity.this.dZG.hm(false);
                this.dZM = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aGk() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean aGl() {
                if (!this.dZM) {
                    return FrsGameSubPbActivity.this.dZG.aGz() != null && FrsGameSubPbActivity.this.dZG.aGz().getTop() == 0;
                }
                this.dZM = false;
                return false;
            }
        });
        this.dZG.e(this.dZH);
        this.dZG.hm(true);
        this.dZG.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dZI != null) {
                    FrsGameSubPbActivity.this.dZI.loadData(true);
                }
            }
        });
        this.dZI = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dZL);
        this.dZI.a(new a.InterfaceC0226a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0226a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.dZH != null && FrsGameSubPbActivity.this.dZH.aGo()) {
                    FrsGameSubPbActivity.this.dZH.nc(e.d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dZG.getRootView());
                    FrsGameSubPbActivity.this.dZG.a(z2, bVar, list);
                    if (!v.I(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof d) {
                            FrsGameSubPbActivity.this.dZI.oI(((d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(e.C0210e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dZG.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(e.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dZH != null) {
                        FrsGameSubPbActivity.this.dZH.aGm();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0226a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dZG.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dZJ = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0226a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dZG.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dZK = true;
                }
            }
        });
        this.dZI.loadData(false);
    }

    private void aGi() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dZG != null) && view == FrsGameSubPbActivity.this.dZG.aGA() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dZH != null) {
                        FrsGameSubPbActivity.this.dZH.aGm();
                    }
                    FrsGameSubPbActivity.this.dZG.oK(null);
                }
            }
        };
    }

    private void anc() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dZL = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dZG.onChangeSkinType(i);
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
        this.dZI.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dZG != null) {
            this.dZG.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dZJ || this.dZK) {
            setResult(1002);
        }
        super.finish();
    }
}
