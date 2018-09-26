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
    private com.baidu.tieba.frs.gamesubpb.view.a dGF;
    private c dGG;
    private com.baidu.tieba.frs.gamesubpb.model.a dGH;
    private boolean dGI;
    private boolean dGJ;
    private String dGK;
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
        ahR();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dGK)) {
            finish();
        }
        aAw();
        this.dGF = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dGK);
        setContentView(this.dGF.getRootView());
        this.dGG = new c(this, this.dGF.getListView(), this.dGF.WW());
        this.dGG.aAB();
        this.dGG.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dGL = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aAx() {
                FrsGameSubPbActivity.this.dGF.gD(false);
                this.dGL = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aAy() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean aAz() {
                if (!this.dGL) {
                    return FrsGameSubPbActivity.this.dGF.aAN() != null && FrsGameSubPbActivity.this.dGF.aAN().getTop() == 0;
                }
                this.dGL = false;
                return false;
            }
        });
        this.dGF.e(this.dGG);
        this.dGF.gD(true);
        this.dGF.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dGH != null) {
                    FrsGameSubPbActivity.this.dGH.loadData(true);
                }
            }
        });
        this.dGH = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dGK);
        this.dGH.a(new a.InterfaceC0156a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.dGG != null && FrsGameSubPbActivity.this.dGG.aAC()) {
                    FrsGameSubPbActivity.this.dGG.lJ(e.d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dGF.getRootView());
                    FrsGameSubPbActivity.this.dGF.a(z2, bVar, list);
                    if (!v.z(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof d) {
                            FrsGameSubPbActivity.this.dGH.nl(((d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(e.C0141e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dGF.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(e.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dGG != null) {
                        FrsGameSubPbActivity.this.dGG.aAA();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dGF.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dGI = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0156a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dGF.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dGJ = true;
                }
            }
        });
        this.dGH.loadData(false);
    }

    private void aAw() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dGF != null) && view == FrsGameSubPbActivity.this.dGF.aAO() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dGG != null) {
                        FrsGameSubPbActivity.this.dGG.aAA();
                    }
                    FrsGameSubPbActivity.this.dGF.nn(null);
                }
            }
        };
    }

    private void ahR() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dGK = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dGF.onChangeSkinType(i);
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
        this.dGH.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dGF != null) {
            this.dGF.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dGI || this.dGJ) {
            setResult(1002);
        }
        super.finish();
    }
}
