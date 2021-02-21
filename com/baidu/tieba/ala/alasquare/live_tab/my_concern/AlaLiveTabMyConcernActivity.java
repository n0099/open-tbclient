package com.baidu.tieba.ala.alasquare.live_tab.my_concern;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    private a gCf;
    private MyConcernTabModel gCg;
    private h gCh;
    private boolean mHasMore = true;
    private boolean isLoading = false;
    private boolean gCi = false;
    private CustomMessageListener gCj = new CustomMessageListener(2921421) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveTabMyConcernActivity.this.p(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    };
    private a.InterfaceC0616a gCk = new a.InterfaceC0616a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.InterfaceC0616a
        public void onScrollToBottom() {
            if (l.isNetOk() && AlaLiveTabMyConcernActivity.this.mHasMore && !AlaLiveTabMyConcernActivity.this.isLoading) {
                AlaLiveTabMyConcernActivity.this.isLoading = true;
                AlaLiveTabMyConcernActivity.this.gCg.bRL();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.InterfaceC0616a
        public void onListPullRefresh(boolean z) {
            if (!j.isNetWorkAvailable() || AlaLiveTabMyConcernActivity.this.isLoading) {
                if (AlaLiveTabMyConcernActivity.this.gCf != null) {
                    AlaLiveTabMyConcernActivity.this.gCf.lU(false);
                    return;
                }
                return;
            }
            AlaLiveTabMyConcernActivity.this.refreshData();
        }
    };
    private MyConcernTabModel.a gCl = new MyConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void b(List<n> list, boolean z, boolean z2) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.WZ();
            AlaLiveTabMyConcernActivity.this.gCf.lU(false);
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.gCf.getContainerView());
            if (!y.isEmpty(list)) {
                AlaLiveTabMyConcernActivity.this.gCf.setData(list);
            } else {
                AlaLiveTabMyConcernActivity.this.mB(z2);
            }
            AlaLiveTabMyConcernActivity.this.mHasMore = z;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void mC(boolean z) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.gCf.getContainerView());
            AlaLiveTabMyConcernActivity.this.gCf.lU(false);
            AlaLiveTabMyConcernActivity.this.mB(z);
        }
    };
    private View.OnClickListener gCm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.4
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
        this.gCi = com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.m(getPageContext());
        this.gCg = new MyConcernTabModel(getPageContext());
        this.gCg.a(this.gCl);
        if (!l.isNetOk()) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.gCm);
        } else {
            showLoadingView(this.gCf.getContainerView(), false, getResources().getDimensionPixelSize(R.dimen.ds340));
            refreshData();
        }
        registerListener(this.gCj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gCi && com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.m(getPageContext())) {
            p(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Class<? extends BaseCardInfo> cls) {
        if (this.gCg != null) {
            this.gCg.q(cls);
        }
        if (this.gCf != null) {
            this.gCf.q(cls);
        }
    }

    private void initView() {
        this.gCf = new a(getPageContext());
        this.gCf.a(this.gCk);
        setContentView(this.gCf.getView());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gCf != null) {
            this.gCf.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB(boolean z) {
        if (z) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.gCm);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.g
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
        if (this.gCh == null) {
            this.gCh = new h(getPageContext().getPageActivity(), onClickListener);
            this.gCh.setButtonText(null);
            this.gCh.showRefreshButton();
            this.gCh.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.gCh.rn(i);
        this.gCh.setSubText(null);
        this.gCh.setTitle(str);
        this.gCh.onChangeSkinType();
        this.gCh.dettachView(this.gCf.bRS());
        this.gCh.attachView(this.gCf.bRS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        if (this.gCh != null) {
            this.gCh.dettachView(this.gCf.bRS());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.isLoading = true;
        this.gCg.Ut();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isLoading = false;
        if (this.gCf != null) {
            this.gCf.lU(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gCg != null) {
            this.gCg.onDestroy();
        }
        hideLoadingView(this.gCf.getContainerView());
        if (this.gCf != null) {
            this.gCf.onDestroy();
        }
    }
}
