package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener bbI;
    private com.baidu.tieba.frs.gamesubpb.view.a jAF;
    private c jAG;
    private com.baidu.tieba.frs.gamesubpb.model.a jAH;
    private boolean jAI;
    private boolean jAJ;
    private String jAK;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        cmk();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.jAK)) {
            finish();
        }
        bZe();
        this.jAF = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.bbI, this.jAK);
        setContentView(this.jAF.getRootView());
        this.jAG = new c(this, this.jAF.getListView(), this.jAF.bVd());
        this.jAG.cIn();
        this.jAG.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean jAL = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cIj() {
                FrsGameSubPbActivity.this.jAF.ro(false);
                this.jAL = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cIk() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cIl() {
                if (!this.jAL) {
                    return FrsGameSubPbActivity.this.jAF.cwq() != null && FrsGameSubPbActivity.this.jAF.cwq().getTop() == 0;
                }
                this.jAL = false;
                return false;
            }
        });
        this.jAF.e(this.jAG);
        this.jAF.ro(true);
        this.jAF.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.jAH != null) {
                    FrsGameSubPbActivity.this.jAH.mH(true);
                }
            }
        });
        this.jAH = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.jAK);
        this.jAH.a(new a.InterfaceC0731a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0731a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<n> list) {
                if (FrsGameSubPbActivity.this.jAG != null && FrsGameSubPbActivity.this.jAG.cIo()) {
                    FrsGameSubPbActivity.this.jAG.zO(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.jAF.getRootView());
                    FrsGameSubPbActivity.this.jAF.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        n nVar = list.get(list.size() - 1);
                        if (nVar instanceof d) {
                            FrsGameSubPbActivity.this.jAH.KI(((d) nVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.jAF.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.jAG != null) {
                        FrsGameSubPbActivity.this.jAG.cIm();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0731a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jAF.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jAI = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0731a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.jAF.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.jAJ = true;
                }
            }
        });
        this.jAH.mH(false);
    }

    private void bZe() {
        this.bbI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.jAF != null) && view == FrsGameSubPbActivity.this.jAF.cIy() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.jAG != null) {
                        FrsGameSubPbActivity.this.jAG.cIm();
                    }
                    FrsGameSubPbActivity.this.jAF.KK(null);
                }
            }
        };
    }

    private void cmk() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.jAK = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jAF.onChangeSkinType(i);
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
        this.jAH.mH(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jAF != null) {
            this.jAF.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.jAI || this.jAJ) {
            setResult(1002);
        }
        super.finish();
    }
}
