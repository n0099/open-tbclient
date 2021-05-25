package com.baidu.tieba.ala.alasquare.live_tab.my_concern;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.m0.d0.h;
import d.a.n0.v.d.c.f.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    public d.a.n0.v.d.c.f.d.a mAlaLiveTabMyConcernView;
    public MyConcernTabModel mModel;
    public h mNetRefreshView;
    public boolean mHasMore = true;
    public boolean isLoading = false;
    public boolean hasNotificationAccessOpen = false;
    public CustomMessageListener mNotificationRemovedListener = new a(2921421);
    public a.f onListViewCallBack = new b();
    public MyConcernTabModel.b mDataCallback = new c();
    public View.OnClickListener mNetRefreshListener = new d();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveTabMyConcernActivity.this.deleteItem(d.a.n0.v.d.c.f.b.a.class);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.f {
        public b() {
        }

        @Override // d.a.n0.v.d.c.f.d.a.f
        public void onListPullRefresh(boolean z) {
            if (!j.z() || AlaLiveTabMyConcernActivity.this.isLoading) {
                if (AlaLiveTabMyConcernActivity.this.mAlaLiveTabMyConcernView != null) {
                    AlaLiveTabMyConcernActivity.this.mAlaLiveTabMyConcernView.q(false);
                    return;
                }
                return;
            }
            AlaLiveTabMyConcernActivity.this.refreshData();
        }

        @Override // d.a.n0.v.d.c.f.d.a.f
        public void onScrollToBottom() {
            if (l.D() && AlaLiveTabMyConcernActivity.this.mHasMore && !AlaLiveTabMyConcernActivity.this.isLoading) {
                AlaLiveTabMyConcernActivity.this.isLoading = true;
                AlaLiveTabMyConcernActivity.this.mModel.x();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MyConcernTabModel.b {
        public c() {
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.b
        public void a(List<n> list, boolean z, boolean z2) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.hideNetRefreshView();
            AlaLiveTabMyConcernActivity.this.mAlaLiveTabMyConcernView.q(false);
            AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity = AlaLiveTabMyConcernActivity.this;
            alaLiveTabMyConcernActivity.hideLoadingView(alaLiveTabMyConcernActivity.mAlaLiveTabMyConcernView.g());
            if (!ListUtils.isEmpty(list)) {
                AlaLiveTabMyConcernActivity.this.mAlaLiveTabMyConcernView.p(list);
            } else {
                AlaLiveTabMyConcernActivity.this.errorDealing(z2);
            }
            AlaLiveTabMyConcernActivity.this.mHasMore = z;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.b
        public void b(boolean z) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity alaLiveTabMyConcernActivity = AlaLiveTabMyConcernActivity.this;
            alaLiveTabMyConcernActivity.hideLoadingView(alaLiveTabMyConcernActivity.mAlaLiveTabMyConcernView.g());
            AlaLiveTabMyConcernActivity.this.mAlaLiveTabMyConcernView.q(false);
            AlaLiveTabMyConcernActivity.this.errorDealing(z);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaLiveTabMyConcernActivity.this.refreshData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteItem(Class<? extends BaseCardInfo> cls) {
        MyConcernTabModel myConcernTabModel = this.mModel;
        if (myConcernTabModel != null) {
            myConcernTabModel.A(cls);
        }
        d.a.n0.v.d.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
        if (aVar != null) {
            aVar.o(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorDealing(boolean z) {
        if (z) {
            showNetRefreshView(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.mNetRefreshListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView() {
        h hVar = this.mNetRefreshView;
        if (hVar != null) {
            hVar.dettachView(this.mAlaLiveTabMyConcernView.f());
        }
    }

    private void initView() {
        d.a.n0.v.d.c.f.d.a aVar = new d.a.n0.v.d.c.f.d.a(getPageContext());
        this.mAlaLiveTabMyConcernView = aVar;
        aVar.r(this.onListViewCallBack);
        setContentView(this.mAlaLiveTabMyConcernView.h());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.isLoading = true;
        this.mModel.y();
    }

    private void showNetRefreshView(int i2, String str, View.OnClickListener onClickListener) {
        if (this.mNetRefreshView == null) {
            h hVar = new h(getPageContext().getPageActivity(), onClickListener);
            this.mNetRefreshView = hVar;
            hVar.g(null);
            this.mNetRefreshView.o();
            this.mNetRefreshView.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mNetRefreshView.i(i2);
        this.mNetRefreshView.l(null);
        this.mNetRefreshView.m(str);
        this.mNetRefreshView.onChangeSkinType();
        this.mNetRefreshView.dettachView(this.mAlaLiveTabMyConcernView.f());
        this.mNetRefreshView.attachView(this.mAlaLiveTabMyConcernView.f());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.v.d.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
        if (aVar != null) {
            aVar.l(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            finish();
            return;
        }
        initView();
        this.hasNotificationAccessOpen = d.a.n0.v.d.c.f.c.a.a(getPageContext());
        MyConcernTabModel myConcernTabModel = new MyConcernTabModel(getPageContext());
        this.mModel = myConcernTabModel;
        myConcernTabModel.B(this.mDataCallback);
        if (!l.D()) {
            showNetRefreshView(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.mNetRefreshListener);
        } else {
            showLoadingView(this.mAlaLiveTabMyConcernView.g(), false, getResources().getDimensionPixelSize(R.dimen.ds340));
            refreshData();
        }
        registerListener(this.mNotificationRemovedListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MyConcernTabModel myConcernTabModel = this.mModel;
        if (myConcernTabModel != null) {
            myConcernTabModel.onDestroy();
        }
        hideLoadingView(this.mAlaLiveTabMyConcernView.g());
        d.a.n0.v.d.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
        if (aVar != null) {
            aVar.m();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isLoading = false;
        d.a.n0.v.d.c.f.d.a aVar = this.mAlaLiveTabMyConcernView;
        if (aVar != null) {
            aVar.q(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hasNotificationAccessOpen || !d.a.n0.v.d.c.f.c.a.a(getPageContext())) {
            return;
        }
        deleteItem(d.a.n0.v.d.c.f.b.a.class);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, d.a.c.a.g
    public TbPageContext<AlaLiveTabMyConcernActivity> getPageContext() {
        return super.getPageContext();
    }
}
