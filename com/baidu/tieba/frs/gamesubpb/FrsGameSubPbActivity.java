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
    private com.baidu.tieba.frs.gamesubpb.view.a dPH;
    private c dPI;
    private com.baidu.tieba.frs.gamesubpb.model.a dPJ;
    private boolean dPK;
    private boolean dPL;
    private String dPM;
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
        akW();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.dPM)) {
            finish();
        }
        aDk();
        this.dPH = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.dPM);
        setContentView(this.dPH.getRootView());
        this.dPI = new c(this, this.dPH.getListView(), this.dPH.aaO());
        this.dPI.aDp();
        this.dPI.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean dPN = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aDl() {
                FrsGameSubPbActivity.this.dPH.he(false);
                this.dPN = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void aDm() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean aDn() {
                if (!this.dPN) {
                    return FrsGameSubPbActivity.this.dPH.aDB() != null && FrsGameSubPbActivity.this.dPH.aDB().getTop() == 0;
                }
                this.dPN = false;
                return false;
            }
        });
        this.dPH.e(this.dPI);
        this.dPH.he(true);
        this.dPH.a(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.dPJ != null) {
                    FrsGameSubPbActivity.this.dPJ.loadData(true);
                }
            }
        });
        this.dPJ = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.dPM);
        this.dPJ.a(new a.InterfaceC0215a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0215a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
                if (FrsGameSubPbActivity.this.dPI != null && FrsGameSubPbActivity.this.dPI.aDq()) {
                    FrsGameSubPbActivity.this.dPI.my(e.d.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.dPH.getRootView());
                    FrsGameSubPbActivity.this.dPH.a(z2, bVar, list);
                    if (!v.I(list)) {
                        h hVar = list.get(list.size() - 1);
                        if (hVar instanceof d) {
                            FrsGameSubPbActivity.this.dPJ.nO(((d) hVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(e.C0200e.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.dPH.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(e.j.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.dPI != null) {
                        FrsGameSubPbActivity.this.dPI.aDo();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0215a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dPH.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dPK = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0215a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.dPH.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.dPL = true;
                }
            }
        });
        this.dPJ.loadData(false);
    }

    private void aDk() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.dPH != null) && view == FrsGameSubPbActivity.this.dPH.aDC() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.dPI != null) {
                        FrsGameSubPbActivity.this.dPI.aDo();
                    }
                    FrsGameSubPbActivity.this.dPH.nQ(null);
                }
            }
        };
    }

    private void akW() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.dPM = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dPH.onChangeSkinType(i);
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
        this.dPJ.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dPH != null) {
            this.dPH.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dPK || this.dPL) {
            setResult(1002);
        }
        super.finish();
    }
}
