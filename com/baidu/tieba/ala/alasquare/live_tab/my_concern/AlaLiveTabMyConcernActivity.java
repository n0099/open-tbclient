package com.baidu.tieba.ala.alasquare.live_tab.my_concern;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel;
import com.baidu.tieba.card.data.b;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    private a fue;
    private MyConcernTabModel fuf;
    private h fug;
    private boolean mHasMore = true;
    private boolean isLoading = false;
    private boolean fuh = false;
    private CustomMessageListener fui = new CustomMessageListener(2921421) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveTabMyConcernActivity.this.w(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    };
    private a.InterfaceC0543a fuj = new a.InterfaceC0543a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0543a
        public void onScrollToBottom() {
            if (l.isNetOk() && AlaLiveTabMyConcernActivity.this.mHasMore && !AlaLiveTabMyConcernActivity.this.isLoading) {
                AlaLiveTabMyConcernActivity.this.isLoading = true;
                AlaLiveTabMyConcernActivity.this.fuf.bxg();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0543a
        public void onListPullRefresh(boolean z) {
            if (!j.isNetWorkAvailable() || AlaLiveTabMyConcernActivity.this.isLoading) {
                if (AlaLiveTabMyConcernActivity.this.fue != null) {
                    AlaLiveTabMyConcernActivity.this.fue.jH(false);
                    return;
                }
                return;
            }
            AlaLiveTabMyConcernActivity.this.refreshData();
        }
    };
    private MyConcernTabModel.a fuk = new MyConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void b(List<q> list, boolean z, boolean z2) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.bwX();
            AlaLiveTabMyConcernActivity.this.fue.jH(false);
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.fue.bxk());
            if (!x.isEmpty(list)) {
                AlaLiveTabMyConcernActivity.this.fue.setData(list);
            } else {
                AlaLiveTabMyConcernActivity.this.kg(z2);
            }
            AlaLiveTabMyConcernActivity.this.mHasMore = z;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void kh(boolean z) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.fue.bxk());
            AlaLiveTabMyConcernActivity.this.fue.jH(false);
            AlaLiveTabMyConcernActivity.this.kg(z);
        }
    };
    private View.OnClickListener ful = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaLiveTabMyConcernActivity.this.refreshData();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            finish();
            return;
        }
        initView();
        this.fuh = com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.m(getPageContext());
        this.fuf = new MyConcernTabModel(getPageContext());
        this.fuf.a(this.fuk);
        if (!l.isNetOk()) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.ful);
        } else {
            showLoadingView(this.fue.bxk(), false, getResources().getDimensionPixelSize(R.dimen.ds340));
            refreshData();
        }
        registerListener(this.fui);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.fuh && com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.m(getPageContext())) {
            w(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Class<? extends b> cls) {
        if (this.fuf != null) {
            this.fuf.x(cls);
        }
        if (this.fue != null) {
            this.fue.x(cls);
        }
    }

    private void initView() {
        this.fue = new a(getPageContext());
        this.fue.a(this.fuj);
        setContentView(this.fue.getView());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fue != null) {
            this.fue.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kg(boolean z) {
        if (z) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.ful);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.f
    public TbPageContext<AlaLiveTabMyConcernActivity> getPageContext() {
        return super.getPageContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void a(int i, String str, View.OnClickListener onClickListener) {
        if (this.fug == null) {
            this.fug = new h(getPageContext().getPageActivity(), onClickListener);
            this.fug.setButtonText(null);
            this.fug.showRefreshButton();
            this.fug.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.fug.oi(i);
        this.fug.setSubText(null);
        this.fug.setTitle(str);
        this.fug.onChangeSkinType();
        this.fug.dettachView(this.fue.bxo());
        this.fug.attachView(this.fue.bxo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        if (this.fug != null) {
            this.fug.dettachView(this.fue.bxo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.isLoading = true;
        this.fuf.IH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isLoading = false;
        if (this.fue != null) {
            this.fue.jH(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fuf != null) {
            this.fuf.onDestroy();
        }
        hideLoadingView(this.fue.bxk());
        if (this.fue != null) {
            this.fue.onDestroy();
        }
    }
}
