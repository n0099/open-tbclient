package com.baidu.tieba.ala.alasquare.live_tab.my_concern;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
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
/* loaded from: classes3.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    private a fdJ;
    private MyConcernTabModel fdK;
    private h fdL;
    private boolean mHasMore = true;
    private boolean isLoading = false;
    private boolean fdM = false;
    private CustomMessageListener fdN = new CustomMessageListener(2921421) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveTabMyConcernActivity.this.w(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    };
    private a.InterfaceC0524a fdO = new a.InterfaceC0524a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0524a
        public void onScrollToBottom() {
            if (l.isNetOk() && AlaLiveTabMyConcernActivity.this.mHasMore && !AlaLiveTabMyConcernActivity.this.isLoading) {
                AlaLiveTabMyConcernActivity.this.isLoading = true;
                AlaLiveTabMyConcernActivity.this.fdK.bqZ();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0524a
        public void onListPullRefresh(boolean z) {
            if (!j.isNetWorkAvailable() || AlaLiveTabMyConcernActivity.this.isLoading) {
                if (AlaLiveTabMyConcernActivity.this.fdJ != null) {
                    AlaLiveTabMyConcernActivity.this.fdJ.iQ(false);
                    return;
                }
                return;
            }
            AlaLiveTabMyConcernActivity.this.refreshData();
        }
    };
    private MyConcernTabModel.a fdP = new MyConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void c(List<o> list, boolean z, boolean z2) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.bqQ();
            AlaLiveTabMyConcernActivity.this.fdJ.iQ(false);
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.fdJ.bre());
            if (!v.isEmpty(list)) {
                AlaLiveTabMyConcernActivity.this.fdJ.setData(list);
            } else {
                AlaLiveTabMyConcernActivity.this.jp(z2);
            }
            AlaLiveTabMyConcernActivity.this.mHasMore = z;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void jq(boolean z) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.fdJ.bre());
            AlaLiveTabMyConcernActivity.this.fdJ.iQ(false);
            AlaLiveTabMyConcernActivity.this.jp(z);
        }
    };
    private View.OnClickListener fdQ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.4
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
        this.fdM = com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.k(getPageContext());
        this.fdK = new MyConcernTabModel(getPageContext());
        this.fdK.a(this.fdP);
        if (!l.isNetOk()) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.fdQ);
        } else {
            showLoadingView(this.fdJ.bre(), false, getResources().getDimensionPixelSize(R.dimen.ds340));
            refreshData();
        }
        registerListener(this.fdN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.fdM && com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.k(getPageContext())) {
            w(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Class<? extends b> cls) {
        if (this.fdK != null) {
            this.fdK.x(cls);
        }
        if (this.fdJ != null) {
            this.fdJ.x(cls);
        }
    }

    private void initView() {
        this.fdJ = new a(getPageContext());
        this.fdJ.a(this.fdO);
        setContentView(this.fdJ.getView());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fdJ != null) {
            this.fdJ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jp(boolean z) {
        if (z) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.fdQ);
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
        if (this.fdL == null) {
            this.fdL = new h(getPageContext().getPageActivity(), onClickListener);
            this.fdL.setButtonText(null);
            this.fdL.showRefreshButton();
            this.fdL.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.fdL.nv(i);
        this.fdL.setSubText(null);
        this.fdL.setTitle(str);
        this.fdL.onChangeSkinType();
        this.fdL.dettachView(this.fdJ.bri());
        this.fdL.attachView(this.fdJ.bri());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqQ() {
        if (this.fdL != null) {
            this.fdL.dettachView(this.fdJ.bri());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.isLoading = true;
        this.fdK.Ho();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isLoading = false;
        if (this.fdJ != null) {
            this.fdJ.iQ(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fdK != null) {
            this.fdK.onDestroy();
        }
        hideLoadingView(this.fdJ.bre());
        if (this.fdJ != null) {
            this.fdJ.onDestroy();
        }
    }
}
