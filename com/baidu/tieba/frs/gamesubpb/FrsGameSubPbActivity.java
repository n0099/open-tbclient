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
/* loaded from: classes4.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener ZF;
    private String fJA;
    private com.baidu.tieba.frs.gamesubpb.view.a fJv;
    private c fJw;
    private com.baidu.tieba.frs.gamesubpb.model.a fJx;
    private boolean fJy;
    private boolean fJz;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        aXe();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.fJA)) {
            finish();
        }
        aNb();
        this.fJv = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.ZF, this.fJA);
        setContentView(this.fJv.getRootView());
        this.fJw = new c(this, this.fJv.getListView(), this.fJv.aKP());
        this.fJw.bnZ();
        this.fJw.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean fJB = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bnV() {
                FrsGameSubPbActivity.this.fJv.kt(false);
                this.fJB = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bnW() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bnX() {
                if (!this.fJB) {
                    return FrsGameSubPbActivity.this.fJv.beB() != null && FrsGameSubPbActivity.this.fJv.beB().getTop() == 0;
                }
                this.fJB = false;
                return false;
            }
        });
        this.fJv.e(this.fJw);
        this.fJv.kt(true);
        this.fJv.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.fJx != null) {
                    FrsGameSubPbActivity.this.fJx.loadData(true);
                }
            }
        });
        this.fJx = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.fJA);
        this.fJx.a(new a.InterfaceC0410a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0410a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.fJw != null && FrsGameSubPbActivity.this.fJw.boa()) {
                    FrsGameSubPbActivity.this.fJw.rj(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.fJv.getRootView());
                    FrsGameSubPbActivity.this.fJv.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.fJx.vZ(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.fJv.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.fJw != null) {
                        FrsGameSubPbActivity.this.fJw.bnY();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0410a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fJv.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fJy = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0410a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fJv.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fJz = true;
                }
            }
        });
        this.fJx.loadData(false);
    }

    private void aNb() {
        this.ZF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.fJv != null) && view == FrsGameSubPbActivity.this.fJv.bol() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.fJw != null) {
                        FrsGameSubPbActivity.this.fJw.bnY();
                    }
                    FrsGameSubPbActivity.this.fJv.wb(null);
                }
            }
        };
    }

    private void aXe() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.fJA = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fJv.onChangeSkinType(i);
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
        this.fJx.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fJv != null) {
            this.fJv.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.fJy || this.fJz) {
            setResult(1002);
        }
        super.finish();
    }
}
