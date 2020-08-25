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
/* loaded from: classes16.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener aRU;
    private c ikA;
    private com.baidu.tieba.frs.gamesubpb.model.a ikB;
    private boolean ikC;
    private boolean ikD;
    private String ikE;
    private com.baidu.tieba.frs.gamesubpb.view.a ikz;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bXZ();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.ikE)) {
            finish();
        }
        bMg();
        this.ikz = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aRU, this.ikE);
        setContentView(this.ikz.getRootView());
        this.ikA = new c(this, this.ikz.getListView(), this.ikz.bJH());
        this.ikA.cqI();
        this.ikA.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean ikF = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cqE() {
                FrsGameSubPbActivity.this.ikz.oS(false);
                this.ikF = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cqF() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cqG() {
                if (!this.ikF) {
                    return FrsGameSubPbActivity.this.ikz.cfN() != null && FrsGameSubPbActivity.this.ikz.cfN().getTop() == 0;
                }
                this.ikF = false;
                return false;
            }
        });
        this.ikz.e(this.ikA);
        this.ikz.oS(true);
        this.ikz.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.ikB != null) {
                    FrsGameSubPbActivity.this.ikB.kL(true);
                }
            }
        });
        this.ikB = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.ikE);
        this.ikB.a(new a.InterfaceC0686a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0686a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.ikA != null && FrsGameSubPbActivity.this.ikA.cqJ()) {
                    FrsGameSubPbActivity.this.ikA.yb(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.ikz.getRootView());
                    FrsGameSubPbActivity.this.ikz.a(z2, bVar, list);
                    if (!y.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.ikB.IA(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.ikz.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.ikA != null) {
                        FrsGameSubPbActivity.this.ikA.cqH();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0686a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.ikz.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.ikC = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0686a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.ikz.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.ikD = true;
                }
            }
        });
        this.ikB.kL(false);
    }

    private void bMg() {
        this.aRU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.ikz != null) && view == FrsGameSubPbActivity.this.ikz.cqT() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.ikA != null) {
                        FrsGameSubPbActivity.this.ikA.cqH();
                    }
                    FrsGameSubPbActivity.this.ikz.IC(null);
                }
            }
        };
    }

    private void bXZ() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.ikE = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ikz.onChangeSkinType(i);
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
        this.ikB.kL(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ikz != null) {
            this.ikz.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.ikC || this.ikD) {
            setResult(1002);
        }
        super.finish();
    }
}
