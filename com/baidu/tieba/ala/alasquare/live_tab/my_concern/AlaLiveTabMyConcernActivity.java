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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel;
import com.baidu.tieba.card.data.b;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveTabMyConcernActivity extends BaseActivity<AlaLiveTabMyConcernActivity> {
    private a gkX;
    private MyConcernTabModel gkY;
    private h gkZ;
    private boolean mHasMore = true;
    private boolean isLoading = false;
    private boolean gla = false;
    private CustomMessageListener glb = new CustomMessageListener(2921421) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveTabMyConcernActivity.this.w(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    };
    private a.InterfaceC0630a glc = new a.InterfaceC0630a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0630a
        public void onScrollToBottom() {
            if (l.isNetOk() && AlaLiveTabMyConcernActivity.this.mHasMore && !AlaLiveTabMyConcernActivity.this.isLoading) {
                AlaLiveTabMyConcernActivity.this.isLoading = true;
                AlaLiveTabMyConcernActivity.this.gkY.bPk();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0630a
        public void onListPullRefresh(boolean z) {
            if (!j.isNetWorkAvailable() || AlaLiveTabMyConcernActivity.this.isLoading) {
                if (AlaLiveTabMyConcernActivity.this.gkX != null) {
                    AlaLiveTabMyConcernActivity.this.gkX.lc(false);
                    return;
                }
                return;
            }
            AlaLiveTabMyConcernActivity.this.refreshData();
        }
    };
    private MyConcernTabModel.a gld = new MyConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void b(List<q> list, boolean z, boolean z2) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.Wk();
            AlaLiveTabMyConcernActivity.this.gkX.lc(false);
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.gkX.bPo());
            if (!y.isEmpty(list)) {
                AlaLiveTabMyConcernActivity.this.gkX.setData(list);
            } else {
                AlaLiveTabMyConcernActivity.this.lI(z2);
            }
            AlaLiveTabMyConcernActivity.this.mHasMore = z;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void lJ(boolean z) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.gkX.bPo());
            AlaLiveTabMyConcernActivity.this.gkX.lc(false);
            AlaLiveTabMyConcernActivity.this.lI(z);
        }
    };
    private View.OnClickListener gle = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.4
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
        this.gla = com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.m(getPageContext());
        this.gkY = new MyConcernTabModel(getPageContext());
        this.gkY.a(this.gld);
        if (!l.isNetOk()) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.gle);
        } else {
            showLoadingView(this.gkX.bPo(), false, getResources().getDimensionPixelSize(R.dimen.ds340));
            refreshData();
        }
        registerListener(this.glb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gla && com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.m(getPageContext())) {
            w(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Class<? extends b> cls) {
        if (this.gkY != null) {
            this.gkY.x(cls);
        }
        if (this.gkX != null) {
            this.gkX.x(cls);
        }
    }

    private void initView() {
        this.gkX = new a(getPageContext());
        this.gkX.a(this.glc);
        setContentView(this.gkX.getView());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gkX != null) {
            this.gkX.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        if (z) {
            a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.refresh_view_title_text), this.gle);
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
        if (this.gkZ == null) {
            this.gkZ = new h(getPageContext().getPageActivity(), onClickListener);
            this.gkZ.setButtonText(null);
            this.gkZ.showRefreshButton();
            this.gkZ.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.gkZ.rD(i);
        this.gkZ.setSubText(null);
        this.gkZ.setTitle(str);
        this.gkZ.onChangeSkinType();
        this.gkZ.dettachView(this.gkX.bPs());
        this.gkZ.attachView(this.gkX.bPs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wk() {
        if (this.gkZ != null) {
            this.gkZ.dettachView(this.gkX.bPs());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.isLoading = true;
        this.gkY.TL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isLoading = false;
        if (this.gkX != null) {
            this.gkX.lc(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gkY != null) {
            this.gkY.onDestroy();
        }
        hideLoadingView(this.gkX.bPo());
        if (this.gkX != null) {
            this.gkX.onDestroy();
        }
    }
}
