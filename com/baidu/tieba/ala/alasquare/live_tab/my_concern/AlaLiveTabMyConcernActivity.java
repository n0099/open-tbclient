package com.baidu.tieba.ala.alasquare.live_tab.my_concern;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel;
import com.baidu.tieba.card.data.b;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    private h eiA;
    private a eiy;
    private MyConcernTabModel eiz;
    private boolean mHasMore = true;
    private boolean isLoading = false;
    private boolean eiB = false;
    private CustomMessageListener eiC = new CustomMessageListener(2921421) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveTabMyConcernActivity.this.v(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    };
    private a.InterfaceC0412a eiD = new a.InterfaceC0412a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0412a
        public void onScrollToBottom() {
            if (l.isNetOk() && AlaLiveTabMyConcernActivity.this.mHasMore && !AlaLiveTabMyConcernActivity.this.isLoading) {
                AlaLiveTabMyConcernActivity.this.isLoading = true;
                AlaLiveTabMyConcernActivity.this.eiz.bao();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0412a
        public void onListPullRefresh(boolean z) {
            if (!j.isNetWorkAvailable() || AlaLiveTabMyConcernActivity.this.isLoading) {
                if (AlaLiveTabMyConcernActivity.this.eiy != null) {
                    AlaLiveTabMyConcernActivity.this.eiy.hn(false);
                    return;
                }
                return;
            }
            AlaLiveTabMyConcernActivity.this.refreshData();
        }
    };
    private MyConcernTabModel.a eiE = new MyConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void c(List<m> list, boolean z, boolean z2) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.baf();
            AlaLiveTabMyConcernActivity.this.eiy.hn(false);
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.eiy.bat());
            if (!v.isEmpty(list)) {
                AlaLiveTabMyConcernActivity.this.eiy.setData(list);
            } else {
                AlaLiveTabMyConcernActivity.this.hP(z2);
            }
            AlaLiveTabMyConcernActivity.this.mHasMore = z;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void hQ(boolean z) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.eiy.bat());
            AlaLiveTabMyConcernActivity.this.eiy.hn(false);
            AlaLiveTabMyConcernActivity.this.hP(z);
        }
    };
    private View.OnClickListener eiF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.4
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
        this.eiB = com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.j(getPageContext());
        this.eiz = new MyConcernTabModel(getPageContext());
        this.eiz.a(this.eiE);
        if (!l.isNetOk()) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.eiF);
        } else {
            showLoadingView(this.eiy.bat(), false, getResources().getDimensionPixelSize(R.dimen.ds340));
            refreshData();
        }
        registerListener(this.eiC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.eiB && com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.j(getPageContext())) {
            v(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Class<? extends b> cls) {
        if (this.eiz != null) {
            this.eiz.w(cls);
        }
        if (this.eiy != null) {
            this.eiy.w(cls);
        }
    }

    private void initView() {
        this.eiy = new a(getPageContext());
        this.eiy.a(this.eiD);
        setContentView(this.eiy.getView());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eiy != null) {
            this.eiy.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP(boolean z) {
        if (z) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.eiF);
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
        if (this.eiA == null) {
            this.eiA = new h(getPageContext().getPageActivity(), onClickListener);
            this.eiA.setButtonText(null);
            this.eiA.showRefreshButton();
            this.eiA.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.eiA.mn(i);
        this.eiA.setSubText(null);
        this.eiA.setTitle(str);
        this.eiA.onChangeSkinType();
        this.eiA.dettachView(this.eiy.bax());
        this.eiA.attachView(this.eiy.bax());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baf() {
        if (this.eiA != null) {
            this.eiA.dettachView(this.eiy.bax());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.isLoading = true;
        this.eiz.yj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isLoading = false;
        if (this.eiy != null) {
            this.eiy.hn(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eiz != null) {
            this.eiz.onDestroy();
        }
        hideLoadingView(this.eiy.bat());
        if (this.eiy != null) {
            this.eiy.onDestroy();
        }
    }
}
