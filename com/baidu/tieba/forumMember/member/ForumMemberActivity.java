package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NoNetworkView;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.m0.r.f0.f;
import d.a.n0.p0.c.d;
import d.a.n0.r0.c1;
import d.a.n0.r0.t0;
import d.a.n0.r0.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.g {
    public String mForumId;
    public String mForumName;
    public d mModel;
    public z0 mPageInfo;
    public d.a.n0.p0.c.o.b mView;
    public List<n> mListViewData = null;
    public t0 mCallback = new a();
    public NoNetworkView.b mNetworkChangeListener = new b();

    /* loaded from: classes4.dex */
    public class a implements t0 {
        public a() {
        }

        @Override // d.a.n0.r0.t0
        public void a(int i2, int i3, c1 c1Var, ArrayList<n> arrayList) {
            ForumMemberActivity.this.mView.d();
            ForumMemberActivity.this.mView.c();
            if (arrayList != null) {
                Iterator<n> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof d.a.n0.r0.n) {
                        it.remove();
                    }
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                ForumMemberActivity.this.mView.e();
                ForumMemberActivity.this.mListViewData = arrayList;
                ForumMemberActivity.this.mView.f(ForumMemberActivity.this.mListViewData);
            } else if (!ListUtils.isEmpty(ForumMemberActivity.this.mListViewData) || c1Var == null) {
            } else {
                ForumMemberActivity.this.mView.l(c1Var.f58408f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NoNetworkView.b {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            ForumMemberActivity.this.mView.b(z);
            if (z) {
                if (ListUtils.isEmpty(ForumMemberActivity.this.mListViewData)) {
                    ForumMemberActivity.this.startFirstTimeLoad();
                } else {
                    ForumMemberActivity.this.mView.m();
                }
            }
        }
    }

    private void initBundle(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() == null) {
                return;
            }
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
        } else {
            this.mForumId = bundle.getString("forum_id", "");
            this.mForumName = bundle.getString("forum_name", "");
        }
        z0 z0Var = new z0();
        this.mPageInfo = z0Var;
        z0Var.f59870b = this.mForumId;
        z0Var.f59869a = this.mForumName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFirstTimeLoad() {
        this.mView.k();
        this.mModel.m(3, 0, this.mPageInfo);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.h(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        d.a.n0.p0.c.o.b bVar = new d.a.n0.p0.c.o.b(this);
        this.mView = bVar;
        bVar.j(this.mNetworkChangeListener);
        d dVar = new d();
        this.mModel = dVar;
        dVar.E(getUniqueId());
        this.mModel.init();
        this.mModel.p(this.mCallback);
        startFirstTimeLoad();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mModel.e();
        d.a.n0.p0.c.o.b bVar = this.mView;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.mModel.m(3, 0, this.mPageInfo);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.A()) {
            startFirstTimeLoad();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("forum_name", this.mForumName);
    }
}
