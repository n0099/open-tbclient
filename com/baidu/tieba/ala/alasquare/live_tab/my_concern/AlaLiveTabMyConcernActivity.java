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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    private a gzh;
    private MyConcernTabModel gzi;
    private h gzj;
    private boolean mHasMore = true;
    private boolean isLoading = false;
    private boolean gzk = false;
    private CustomMessageListener gzl = new CustomMessageListener(2921421) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveTabMyConcernActivity.this.p(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    };
    private a.InterfaceC0616a gzm = new a.InterfaceC0616a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.InterfaceC0616a
        public void onScrollToBottom() {
            if (l.isNetOk() && AlaLiveTabMyConcernActivity.this.mHasMore && !AlaLiveTabMyConcernActivity.this.isLoading) {
                AlaLiveTabMyConcernActivity.this.isLoading = true;
                AlaLiveTabMyConcernActivity.this.gzi.bRa();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.InterfaceC0616a
        public void onListPullRefresh(boolean z) {
            if (!j.isNetWorkAvailable() || AlaLiveTabMyConcernActivity.this.isLoading) {
                if (AlaLiveTabMyConcernActivity.this.gzh != null) {
                    AlaLiveTabMyConcernActivity.this.gzh.lQ(false);
                    return;
                }
                return;
            }
            AlaLiveTabMyConcernActivity.this.refreshData();
        }
    };
    private MyConcernTabModel.a gzn = new MyConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void b(List<n> list, boolean z, boolean z2) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.Vq();
            AlaLiveTabMyConcernActivity.this.gzh.lQ(false);
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.gzh.bRe());
            if (!x.isEmpty(list)) {
                AlaLiveTabMyConcernActivity.this.gzh.setData(list);
            } else {
                AlaLiveTabMyConcernActivity.this.mx(z2);
            }
            AlaLiveTabMyConcernActivity.this.mHasMore = z;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void my(boolean z) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.gzh.bRe());
            AlaLiveTabMyConcernActivity.this.gzh.lQ(false);
            AlaLiveTabMyConcernActivity.this.mx(z);
        }
    };
    private View.OnClickListener gzo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.4
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
        this.gzk = com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.m(getPageContext());
        this.gzi = new MyConcernTabModel(getPageContext());
        this.gzi.a(this.gzn);
        if (!l.isNetOk()) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.gzo);
        } else {
            showLoadingView(this.gzh.bRe(), false, getResources().getDimensionPixelSize(R.dimen.ds340));
            refreshData();
        }
        registerListener(this.gzl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gzk && com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.m(getPageContext())) {
            p(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Class<? extends BaseCardInfo> cls) {
        if (this.gzi != null) {
            this.gzi.q(cls);
        }
        if (this.gzh != null) {
            this.gzh.q(cls);
        }
    }

    private void initView() {
        this.gzh = new a(getPageContext());
        this.gzh.a(this.gzm);
        setContentView(this.gzh.getView());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gzh != null) {
            this.gzh.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(boolean z) {
        if (z) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.gzo);
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
        if (this.gzj == null) {
            this.gzj = new h(getPageContext().getPageActivity(), onClickListener);
            this.gzj.setButtonText(null);
            this.gzj.showRefreshButton();
            this.gzj.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.gzj.ri(i);
        this.gzj.setSubText(null);
        this.gzj.setTitle(str);
        this.gzj.onChangeSkinType();
        this.gzj.dettachView(this.gzh.bRi());
        this.gzj.attachView(this.gzh.bRi());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        if (this.gzj != null) {
            this.gzj.dettachView(this.gzh.bRi());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.isLoading = true;
        this.gzi.SM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isLoading = false;
        if (this.gzh != null) {
            this.gzh.lQ(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gzi != null) {
            this.gzi.onDestroy();
        }
        hideLoadingView(this.gzh.bRe());
        if (this.gzh != null) {
            this.gzh.onDestroy();
        }
    }
}
