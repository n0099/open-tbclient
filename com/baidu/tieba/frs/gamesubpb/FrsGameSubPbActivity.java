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
    private com.baidu.tieba.frs.gamesubpb.view.a hWq;
    private c hWr;
    private com.baidu.tieba.frs.gamesubpb.model.a hWs;
    private boolean hWt;
    private boolean hWu;
    private String hWv;
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
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.hWv)) {
            finish();
        }
        bCM();
        this.hWq = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.aMH, this.hWv);
        setContentView(this.hWq.getRootView());
        this.hWr = new c(this, this.hWq.getListView(), this.hWq.bAm());
        this.hWr.cgd();
        this.hWr.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean hWw = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cfZ() {
                FrsGameSubPbActivity.this.hWq.oo(false);
                this.hWw = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void cga() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean cgb() {
                if (!this.hWw) {
                    return FrsGameSubPbActivity.this.hWq.bVw() != null && FrsGameSubPbActivity.this.hWq.bVw().getTop() == 0;
                }
                this.hWw = false;
                return false;
            }
        });
        this.hWq.e(this.hWr);
        this.hWq.oo(true);
        this.hWq.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.hWs != null) {
                    FrsGameSubPbActivity.this.hWs.kn(true);
                }
            }
        });
        this.hWs = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.hWv);
        this.hWs.a(new a.InterfaceC0635a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0635a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
                if (FrsGameSubPbActivity.this.hWr != null && FrsGameSubPbActivity.this.hWr.cge()) {
                    FrsGameSubPbActivity.this.hWr.vI(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.hWq.getRootView());
                    FrsGameSubPbActivity.this.hWq.a(z2, bVar, list);
                    if (!x.isEmpty(list)) {
                        q qVar = list.get(list.size() - 1);
                        if (qVar instanceof d) {
                            FrsGameSubPbActivity.this.hWs.FY(((d) qVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.hWq.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.hWr != null) {
                        FrsGameSubPbActivity.this.hWr.cgc();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0635a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hWq.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hWt = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0635a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.hWq.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.hWu = true;
                }
            }
        });
        this.hWs.kn(false);
    }

    private void bCM() {
        this.aMH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.hWq != null) && view == FrsGameSubPbActivity.this.hWq.cgo() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.hWr != null) {
                        FrsGameSubPbActivity.this.hWr.cgc();
                    }
                    FrsGameSubPbActivity.this.hWq.Ga(null);
                }
            }
        };
    }

    private void bNZ() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.hWv = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hWq.onChangeSkinType(i);
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
        this.hWs.kn(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hWq != null) {
            this.hWq.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.hWt || this.hWu) {
            setResult(1002);
        }
        super.finish();
    }
}
