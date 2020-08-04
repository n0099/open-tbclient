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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.c;
import com.baidu.tieba.frs.gamesubpb.model.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    private View.OnClickListener aMH;
    private com.baidu.tieba.frs.gamesubpb.view.a hWs;
    private c hWt;
    private com.baidu.tieba.frs.gamesubpb.model.a hWu;
    private boolean hWv;
    private boolean hWw;
    private String hWx;
    private int mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        bNZ();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.hWx)) {
            finish();
        }
        bCM();
        this.hWs = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aMH, this.hWx);
        setContentView(this.hWs.getRootView());
        this.hWt = new c(this, this.hWs.getListView(), this.hWs.bAm());
        this.hWt.cgd();
        this.hWt.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean hWy = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cfZ() {
                FrsGameSubPbActivity.this.hWs.oo(false);
                this.hWy = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cga() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cgb() {
                if (!this.hWy) {
                    return FrsGameSubPbActivity.this.hWs.bVw() != null && FrsGameSubPbActivity.this.hWs.bVw().getTop() == 0;
                }
                this.hWy = false;
                return false;
            }
        });
        this.hWs.e(this.hWt);
        this.hWs.oo(true);
        this.hWs.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.hWu != null) {
                    FrsGameSubPbActivity.this.hWu.kn(true);
                }
            }
        });
        this.hWu = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.hWx);
        this.hWu.a(new a.InterfaceC0635a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0635a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.hWt != null && FrsGameSubPbActivity.this.hWt.cge()) {
                    FrsGameSubPbActivity.this.hWt.vI(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.hWs.getRootView());
                    FrsGameSubPbActivity.this.hWs.a(z2, bVar, list);
                    if (!x.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.hWu.FY(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.hWs.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.hWt != null) {
                        FrsGameSubPbActivity.this.hWt.cgc();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0635a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hWs.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hWv = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0635a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hWs.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hWw = true;
                }
            }
        });
        this.hWu.kn(false);
    }

    private void bCM() {
        this.aMH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.hWs != null) && view == FrsGameSubPbActivity.this.hWs.cgo() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.hWt != null) {
                        FrsGameSubPbActivity.this.hWt.cgc();
                    }
                    FrsGameSubPbActivity.this.hWs.Ga(null);
                }
            }
        };
    }

    private void bNZ() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.hWx = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hWs.onChangeSkinType(i);
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
        this.hWu.kn(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hWs != null) {
            this.hWs.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.hWv || this.hWw) {
            setResult(1002);
        }
        super.finish();
    }
}
