package com.baidu.tieba.frs.gamesubpb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.a.c.k.e.n;
import d.a.o0.r0.w1.c;
import d.a.o0.r0.w1.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameSubPbActivity extends BaseActivity<FrsGameSubPbActivity> {
    public static final int COMMENT_PUBLISH_SUCCESS = 1002;
    public static final int START_ACTIVITY_REQUEST_CODE = 1001;
    public boolean isAddComment;
    public boolean isDelComment;
    public View.OnClickListener mCommonClickListener;
    public int mForumId;
    public d.a.o0.r0.w1.c mHalfToFullScreenController;
    public String mMainTowerId;
    public d.a.o0.r0.w1.d.a mSubPbModel;
    public d.a.o0.r0.w1.e.a mSubPbView;

    /* loaded from: classes4.dex */
    public class a implements c.e {

        /* renamed from: a  reason: collision with root package name */
        public boolean f15653a = false;

        public a() {
        }

        @Override // d.a.o0.r0.w1.c.e
        public void a() {
            FrsGameSubPbActivity.this.mSubPbView.P(false);
            this.f15653a = true;
        }

        @Override // d.a.o0.r0.w1.c.e
        public void b() {
        }

        @Override // d.a.o0.r0.w1.c.e
        public boolean c() {
            if (!this.f15653a) {
                return FrsGameSubPbActivity.this.mSubPbView.y() != null && FrsGameSubPbActivity.this.mSubPbView.y().getTop() == 0;
            }
            this.f15653a = false;
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (FrsGameSubPbActivity.this.mSubPbModel != null) {
                FrsGameSubPbActivity.this.mSubPbModel.h(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.d {
        public c() {
        }

        @Override // d.a.o0.r0.w1.d.a.d
        public void a(boolean z, int i2, String str, boolean z2, boolean z3, d.a.o0.r0.w1.d.b bVar, List<n> list) {
            if (FrsGameSubPbActivity.this.mHalfToFullScreenController != null && FrsGameSubPbActivity.this.mHalfToFullScreenController.h()) {
                FrsGameSubPbActivity.this.mHalfToFullScreenController.k(R.color.cp_bg_line_k_alpha10_1);
            }
            if (z) {
                FrsGameSubPbActivity frsGameSubPbActivity = FrsGameSubPbActivity.this;
                frsGameSubPbActivity.hideNetRefreshView(frsGameSubPbActivity.mSubPbView.x());
                FrsGameSubPbActivity.this.mSubPbView.O(z2, bVar, list);
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                n nVar = list.get(list.size() - 1);
                if (nVar instanceof d.a.o0.r0.w1.d.d) {
                    FrsGameSubPbActivity.this.mSubPbModel.m(((d.a.o0.r0.w1.d.d) nVar).f63589e);
                }
            } else if (z3) {
            } else {
                FrsGameSubPbActivity frsGameSubPbActivity2 = FrsGameSubPbActivity.this;
                frsGameSubPbActivity2.setNetRefreshViewTopMargin(frsGameSubPbActivity2.getResources().getDimensionPixelSize(R.dimen.ds120));
                FrsGameSubPbActivity frsGameSubPbActivity3 = FrsGameSubPbActivity.this;
                View x = frsGameSubPbActivity3.mSubPbView.x();
                if (TextUtils.isEmpty(str)) {
                    str = FrsGameSubPbActivity.this.getPageContext().getString(R.string.refresh_view_title_text);
                }
                frsGameSubPbActivity3.showNetRefreshView(x, str, false);
                if (FrsGameSubPbActivity.this.mHalfToFullScreenController != null) {
                    FrsGameSubPbActivity.this.mHalfToFullScreenController.i();
                }
            }
        }

        @Override // d.a.o0.r0.w1.d.a.d
        public void b(boolean z, int i2, String str, d.a.o0.r0.w1.d.d dVar) {
            FrsGameSubPbActivity.this.mSubPbView.z(z, str, dVar);
            if (z) {
                FrsGameSubPbActivity.this.isAddComment = true;
            }
        }

        @Override // d.a.o0.r0.w1.d.a.d
        public void c(boolean z, int i2, String str, d.a.o0.r0.w1.d.d dVar) {
            FrsGameSubPbActivity.this.mSubPbView.A(z, str, dVar);
            if (z) {
                FrsGameSubPbActivity.this.isDelComment = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view == null && FrsGameSubPbActivity.this.mSubPbView == null) && view == FrsGameSubPbActivity.this.mSubPbView.w() && FrsGameSubPbActivity.this.checkUpIsLogin()) {
                if (FrsGameSubPbActivity.this.mHalfToFullScreenController != null) {
                    FrsGameSubPbActivity.this.mHalfToFullScreenController.i();
                }
                FrsGameSubPbActivity.this.mSubPbView.t(null);
            }
        }
    }

    private void dealIntent() {
        Intent intent = getIntent();
        this.mForumId = intent.getIntExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, -1);
        this.mMainTowerId = intent.getStringExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID);
    }

    private void initListeners() {
        this.mCommonClickListener = new d();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.isAddComment || this.isDelComment) {
            setResult(1002);
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mSubPbView.D(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
        dealIntent();
        if (this.mForumId <= 0 || TextUtils.isEmpty(this.mMainTowerId)) {
            finish();
        }
        initListeners();
        d.a.o0.r0.w1.e.a aVar = new d.a.o0.r0.w1.e.a(this, this.mCommonClickListener, this.mMainTowerId);
        this.mSubPbView = aVar;
        setContentView(aVar.x());
        d.a.o0.r0.w1.c cVar = new d.a.o0.r0.w1.c(this, this.mSubPbView.u(), this.mSubPbView.v());
        this.mHalfToFullScreenController = cVar;
        cVar.g();
        this.mHalfToFullScreenController.j(new a());
        this.mSubPbView.H(this.mHalfToFullScreenController);
        this.mSubPbView.P(true);
        this.mSubPbView.I(new b());
        d.a.o0.r0.w1.d.a aVar2 = new d.a.o0.r0.w1.d.a(this, this.mForumId, this.mMainTowerId);
        this.mSubPbModel = aVar2;
        aVar2.l(new c());
        this.mSubPbModel.h(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.a.o0.r0.w1.e.a aVar = this.mSubPbView;
        if (aVar != null) {
            aVar.E();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        this.mSubPbModel.h(false);
    }
}
