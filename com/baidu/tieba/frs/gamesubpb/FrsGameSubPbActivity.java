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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener aLl;
    private com.baidu.tieba.frs.gamesubpb.view.a hQr;
    private c hQs;
    private com.baidu.tieba.frs.gamesubpb.model.a hQt;
    private boolean hQu;
    private boolean hQv;
    private String hQw;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bKP();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.hQw)) {
            finish();
        }
        bzx();
        this.hQr = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aLl, this.hQw);
        setContentView(this.hQr.getRootView());
        this.hQs = new c(this, this.hQr.getListView(), this.hQr.bwV());
        this.hQs.ccE();
        this.hQs.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean hQx = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ccA() {
                FrsGameSubPbActivity.this.hQr.nJ(false);
                this.hQx = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void ccB() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean ccC() {
                if (!this.hQx) {
                    return FrsGameSubPbActivity.this.hQr.bSe() != null && FrsGameSubPbActivity.this.hQr.bSe().getTop() == 0;
                }
                this.hQx = false;
                return false;
            }
        });
        this.hQr.e(this.hQs);
        this.hQr.nJ(true);
        this.hQr.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.hQt != null) {
                    FrsGameSubPbActivity.this.hQt.jJ(true);
                }
            }
        });
        this.hQt = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.hQw);
        this.hQt.a(new a.InterfaceC0625a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0625a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.hQs != null && FrsGameSubPbActivity.this.hQs.ccF()) {
                    FrsGameSubPbActivity.this.hQs.vq(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.hQr.getRootView());
                    FrsGameSubPbActivity.this.hQr.a(z2, bVar, list);
                    if (!w.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.hQt.Fm(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.hQr.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.hQs != null) {
                        FrsGameSubPbActivity.this.hQs.ccD();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0625a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hQr.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hQu = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0625a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hQr.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hQv = true;
                }
            }
        });
        this.hQt.jJ(false);
    }

    private void bzx() {
        this.aLl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.hQr != null) && view == FrsGameSubPbActivity.this.hQr.ccP() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.hQs != null) {
                        FrsGameSubPbActivity.this.hQs.ccD();
                    }
                    FrsGameSubPbActivity.this.hQr.Fo(null);
                }
            }
        };
    }

    private void bKP() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.hQw = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hQr.onChangeSkinType(i);
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
        this.hQt.jJ(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hQr != null) {
            this.hQr.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.hQu || this.hQv) {
            setResult(1002);
        }
        super.finish();
    }
}
