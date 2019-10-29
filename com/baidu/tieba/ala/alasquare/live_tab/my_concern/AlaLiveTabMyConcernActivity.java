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
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel;
import com.baidu.tieba.card.data.b;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    private MyConcernTabModel dxA;
    private h dxB;
    private a dxz;
    private boolean mHasMore = true;
    private boolean isLoading = false;
    private boolean dxC = false;
    private CustomMessageListener dxD = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveTabMyConcernActivity.this.o(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    };
    private a.InterfaceC0335a dxE = new a.InterfaceC0335a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0335a
        public void onScrollToBottom() {
            if (l.isNetOk() && AlaLiveTabMyConcernActivity.this.mHasMore && !AlaLiveTabMyConcernActivity.this.isLoading) {
                AlaLiveTabMyConcernActivity.this.isLoading = true;
                AlaLiveTabMyConcernActivity.this.dxA.aJt();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0335a
        public void onListPullRefresh(boolean z) {
            if (!j.isNetWorkAvailable() || AlaLiveTabMyConcernActivity.this.isLoading) {
                if (AlaLiveTabMyConcernActivity.this.dxz != null) {
                    AlaLiveTabMyConcernActivity.this.dxz.fU(false);
                    return;
                }
                return;
            }
            AlaLiveTabMyConcernActivity.this.refreshData();
        }
    };
    private MyConcernTabModel.a dxF = new MyConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void c(List<m> list, boolean z, boolean z2) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.aJo();
            AlaLiveTabMyConcernActivity.this.dxz.fU(false);
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.dxz.aJy());
            if (!v.isEmpty(list)) {
                AlaLiveTabMyConcernActivity.this.dxz.setData(list);
            } else {
                AlaLiveTabMyConcernActivity.this.gC(z2);
            }
            AlaLiveTabMyConcernActivity.this.mHasMore = z;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void gD(boolean z) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.dxz.aJy());
            AlaLiveTabMyConcernActivity.this.dxz.fU(false);
            AlaLiveTabMyConcernActivity.this.gC(z);
        }
    };
    private View.OnClickListener dxG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.4
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
        this.dxC = com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.h(getPageContext());
        this.dxA = new MyConcernTabModel(getPageContext());
        this.dxA.a(this.dxF);
        if (!l.isNetOk()) {
            a(R.drawable.new_pic_emotion_09, getResources().getString(R.string.recommend_pb_no_net_text), this.dxG);
        } else {
            showLoadingView(this.dxz.aJy(), false, getResources().getDimensionPixelSize(R.dimen.ds340));
            refreshData();
        }
        registerListener(this.dxD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.dxC && com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.h(getPageContext())) {
            o(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Class<? extends b> cls) {
        if (this.dxA != null) {
            this.dxA.p(cls);
        }
        if (this.dxz != null) {
            this.dxz.p(cls);
        }
    }

    private void initView() {
        this.dxz = new a(getPageContext());
        this.dxz.a(this.dxE);
        setContentView(this.dxz.getView());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dxz != null) {
            this.dxz.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(boolean z) {
        if (z) {
            if (l.isNetOk()) {
                a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.load_error_new_tip), this.dxG);
            } else {
                a(R.drawable.new_pic_emotion_09, getResources().getString(R.string.recommend_pb_no_net_text), this.dxG);
            }
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
        if (this.dxB == null) {
            this.dxB = new h(getPageContext().getPageActivity(), onClickListener);
            this.dxB.setButtonText(null);
            this.dxB.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.ds340));
            this.dxB.showRefreshButton();
            this.dxB.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.dxB.ka(i);
        this.dxB.setSubText(null);
        this.dxB.setTitle(str);
        this.dxB.onChangeSkinType();
        this.dxB.dettachView(this.dxz.aJC());
        this.dxB.attachView(this.dxz.aJC());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJo() {
        if (this.dxB != null) {
            this.dxB.dettachView(this.dxz.aJC());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.isLoading = true;
        this.dxA.vU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isLoading = false;
        if (this.dxz != null) {
            this.dxz.fU(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dxA != null) {
            this.dxA.onDestroy();
        }
        hideLoadingView(this.dxz.aJy());
        if (this.dxz != null) {
            this.dxz.onDestroy();
        }
    }
}
