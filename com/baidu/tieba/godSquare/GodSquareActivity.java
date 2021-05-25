package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.m0.r.f0.f;
import d.a.n0.w0.c.b;
import java.util.List;
/* loaded from: classes4.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements f.g, BdListView.p {
    public d.a.n0.w0.c.b mModel;
    public d.a.n0.w0.a mView;
    public boolean mHasMore = true;
    public boolean needRefreshView = false;
    public b.c mCallBack = new a();
    public CustomMessageListener mAttentionListener = new b(2001115);
    public NoNetworkView.b mNetworkChangeListener = new c();

    /* loaded from: classes4.dex */
    public class a implements b.c {
        public a() {
        }

        @Override // d.a.n0.w0.c.b.c
        public void a(List<n> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.mView.a().A(0L);
            GodSquareActivity.this.mView.b();
            if (ListUtils.isEmpty(list)) {
                GodSquareActivity.this.mView.d();
                if (ListUtils.isEmpty(GodSquareActivity.this.mModel.f62473e)) {
                    GodSquareActivity.this.mView.k(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.D()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.mView.c();
            if (z) {
                GodSquareActivity.this.mModel.f62473e = list;
                GodSquareActivity.this.mView.m(GodSquareActivity.this.mModel.f62473e);
            } else {
                GodSquareActivity.this.mModel.f62473e.addAll(list);
                GodSquareActivity.this.mView.g();
            }
            if (z2) {
                GodSquareActivity.this.mView.f();
            } else {
                GodSquareActivity.this.mView.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12576c)) {
                    return;
                }
                if (GodSquareActivity.this.mModel.g(d.a.c.e.m.b.f(updateAttentionMessage.getData().f12576c, 0L))) {
                    GodSquareActivity.this.needRefreshView = true;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements NoNetworkView.b {
        public c() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                if (ListUtils.isEmpty(GodSquareActivity.this.mModel.f62473e)) {
                    GodSquareActivity.this.loadFirstTime();
                } else {
                    GodSquareActivity.this.mView.l();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFirstTime() {
        this.mView.j();
        this.mModel.l();
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a009";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.h(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a.n0.w0.a aVar = new d.a.n0.w0.a(this);
        this.mView = aVar;
        aVar.i(this.mNetworkChangeListener);
        this.mModel = new d.a.n0.w0.c.b(this.mCallBack, this);
        registerListener(this.mAttentionListener);
        loadFirstTime();
    }

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.needRefreshView = false;
        this.mModel.l();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.A()) {
            loadFirstTime();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mView.g();
        if (this.needRefreshView) {
            this.mView.l();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.mModel.j();
            this.mView.f();
        }
    }
}
