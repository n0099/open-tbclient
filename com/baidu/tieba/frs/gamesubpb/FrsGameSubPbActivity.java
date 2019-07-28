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
    private com.baidu.tieba.frs.gamesubpb.view.a fIp;
    private c fIq;
    private com.baidu.tieba.frs.gamesubpb.model.a fIr;
    private boolean fIs;
    private boolean fIt;
    private String fIu;
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
        aVR();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.fIu)) {
            finish();
        }
        bpT();
        this.fIp = new com.baidu.tieba.frs.gamesubpb.view.a(this, this.mCommonClickListener, this.fIu);
        setContentView(this.fIp.getRootView());
        this.fIq = new c(this, this.fIp.getListView(), this.fIp.aLh());
        this.fIq.bpY();
        this.fIq.a(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.1
            private boolean fIv = false;

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bpU() {
                FrsGameSubPbActivity.this.fIp.kD(false);
                this.fIv = true;
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public void bpV() {
            }

            @Override // com.baidu.tieba.frs.gamesubpb.c.a
            public boolean bpW() {
                if (!this.fIv) {
                    return FrsGameSubPbActivity.this.fIp.bqk() != null && FrsGameSubPbActivity.this.fIp.bqk().getTop() == 0;
                }
                this.fIv = false;
                return false;
            }
        });
        this.fIp.e(this.fIq);
        this.fIp.kD(true);
        this.fIp.b(new BdListView.e() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (FrsGameSubPbActivity.this.fIr != null) {
                    FrsGameSubPbActivity.this.fIr.loadData(true);
                }
            }
        });
        this.fIr = new com.baidu.tieba.frs.gamesubpb.model.a(this, this.mForumId, this.fIu);
        this.fIr.a(new a.InterfaceC0315a() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.3
            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0315a
            public void a(boolean z, int i, String str, boolean z2, boolean z3, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
                if (FrsGameSubPbActivity.this.fIq != null && FrsGameSubPbActivity.this.fIq.bpZ()) {
                    FrsGameSubPbActivity.this.fIq.sl(R.color.cp_bg_line_k_alpha10_1);
                }
                if (z) {
                    FrsGameSubPbActivity.this.hideNetRefreshView(FrsGameSubPbActivity.this.fIp.getRootView());
                    FrsGameSubPbActivity.this.fIp.a(z2, bVar, list);
                    if (!v.aa(list)) {
                        m mVar = list.get(list.size() - 1);
                        if (mVar instanceof d) {
                            FrsGameSubPbActivity.this.fIr.xh(((d) mVar).id);
                        }
                    }
                } else if (!z3) {
                    FrsGameSubPbActivity.this.setNetRefreshViewTopMargin(FrsGameSubPbActivity.this.getResources().getDimensionPixelSize(R.dimen.ds120));
                    FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                    View rootView = FrsGameSubPbActivity.this.fIp.getRootView();
                    if (TextUtils.isEmpty(str)) {
                        str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                    }
                    frsGameSubPbActivity.showNetRefreshView(rootView, str, false);
                    if (FrsGameSubPbActivity.this.fIq != null) {
                        FrsGameSubPbActivity.this.fIq.bpX();
                    }
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0315a
            public void a(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fIp.a(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fIs = true;
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.model.a.InterfaceC0315a
            public void b(boolean z, int i, String str, d dVar) {
                FrsGameSubPbActivity.this.fIp.b(z, str, dVar);
                if (z) {
                    FrsGameSubPbActivity.this.fIt = true;
                }
            }
        });
        this.fIr.loadData(false);
    }

    private void bpT() {
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((view != null || FrsGameSubPbActivity.this.fIp != null) && view == FrsGameSubPbActivity.this.fIp.bql() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                    if (FrsGameSubPbActivity.this.fIq != null) {
                        FrsGameSubPbActivity.this.fIq.bpX();
                    }
                    FrsGameSubPbActivity.this.fIp.xj(null);
                }
            }
        };
    }

    private void aVR() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.fIu = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fIp.onChangeSkinType(i);
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
        this.fIr.loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fIp != null) {
            this.fIp.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.fIs || this.fIt) {
            setResult(1002);
        }
        super.finish();
    }
}
