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
    private View.OnClickListener aku;
    private com.baidu.tieba.frs.gamesubpb.view.a gDi;
    private c gDj;
    private com.baidu.tieba.frs.gamesubpb.model.a gDk;
    private boolean gDl;
    private boolean gDm;
    private String gDn;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bga();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.gDn)) {
            finish();
        }
        initListeners();
        this.gDi = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aku, this.gDn);
        setContentView(this.gDi.getRootView());
        this.gDj = new c(this, this.gDi.getListView(), this.gDi.beM());
        this.gDj.bId();
        this.gDj.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean gDo = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bHZ() {
                FrsGameSubPbActivity.this.gDi.lT(false);
                this.gDo = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bIa() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bIb() {
                if (!this.gDo) {
                    return FrsGameSubPbActivity.this.gDi.byF() != null && FrsGameSubPbActivity.this.gDi.byF().getTop() == 0;
                }
                this.gDo = false;
                return false;
            }
        });
        this.gDi.e(this.gDj);
        this.gDi.lT(true);
        this.gDi.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.gDk != null) {
                    FrsGameSubPbActivity.this.gDk.loadData(true);
                }
            }
        });
        this.gDk = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.gDn);
        this.gDk.a(new a.InterfaceC0509a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.gDj != null && FrsGameSubPbActivity.this.gDj.bIe()) {
                    FrsGameSubPbActivity.this.gDj.tA(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.gDi.getRootView());
                    FrsGameSubPbActivity.this.gDi.a(z2, bVar, list);
                    if (!v.isEmpty(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.gDk.Bp(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.gDi.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.gDj != null) {
                        FrsGameSubPbActivity.this.gDj.bIc();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gDi.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gDl = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0509a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.gDi.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.gDm = true;
                }
            }
        });
        this.gDk.loadData(false);
    }

    private void initListeners() {
        this.aku = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.gDi != null) && view == FrsGameSubPbActivity.this.gDi.bIp() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.gDj != null) {
                        FrsGameSubPbActivity.this.gDj.bIc();
                    }
                    FrsGameSubPbActivity.this.gDi.Br(null);
                }
            }
        };
    }

    private void bga() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.gDn = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gDi.onChangeSkinType(i);
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
        this.gDk.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gDi != null) {
            this.gDi.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.gDl || this.gDm) {
            setResult(1002);
        }
        super.finish();
    }
}
