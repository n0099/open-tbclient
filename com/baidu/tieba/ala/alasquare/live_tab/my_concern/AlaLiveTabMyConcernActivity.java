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
    private a dwI;
    private MyConcernTabModel dwJ;
    private h dwK;
    private boolean mHasMore = true;
    private boolean isLoading = false;
    private boolean dwL = false;
    private CustomMessageListener dwM = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveTabMyConcernActivity.this.o(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    };
    private a.InterfaceC0330a dwN = new a.InterfaceC0330a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0330a
        public void onScrollToBottom() {
            if (l.isNetOk() && AlaLiveTabMyConcernActivity.this.mHasMore && !AlaLiveTabMyConcernActivity.this.isLoading) {
                AlaLiveTabMyConcernActivity.this.isLoading = true;
                AlaLiveTabMyConcernActivity.this.dwJ.aJr();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.InterfaceC0330a
        public void onListPullRefresh(boolean z) {
            if (!j.isNetWorkAvailable() || AlaLiveTabMyConcernActivity.this.isLoading) {
                if (AlaLiveTabMyConcernActivity.this.dwI != null) {
                    AlaLiveTabMyConcernActivity.this.dwI.fU(false);
                    return;
                }
                return;
            }
            AlaLiveTabMyConcernActivity.this.refreshData();
        }
    };
    private MyConcernTabModel.a dwO = new MyConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.3
        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void c(List<m> list, boolean z, boolean z2) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.aJm();
            AlaLiveTabMyConcernActivity.this.dwI.fU(false);
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.dwI.aJw());
            if (!v.isEmpty(list)) {
                AlaLiveTabMyConcernActivity.this.dwI.setData(list);
            } else {
                AlaLiveTabMyConcernActivity.this.gC(z2);
            }
            AlaLiveTabMyConcernActivity.this.mHasMore = z;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.model.MyConcernTabModel.a
        public void gD(boolean z) {
            AlaLiveTabMyConcernActivity.this.isLoading = false;
            AlaLiveTabMyConcernActivity.this.hideLoadingView(AlaLiveTabMyConcernActivity.this.dwI.aJw());
            AlaLiveTabMyConcernActivity.this.dwI.fU(false);
            AlaLiveTabMyConcernActivity.this.gC(z);
        }
    };
    private View.OnClickListener dwP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity.4
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
        this.dwL = com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.h(getPageContext());
        this.dwJ = new MyConcernTabModel(getPageContext());
        this.dwJ.a(this.dwO);
        if (!l.isNetOk()) {
            a(R.drawable.new_pic_emotion_09, getResources().getString(R.string.recommend_pb_no_net_text), this.dwP);
        } else {
            showLoadingView(this.dwI.aJw(), false, getResources().getDimensionPixelSize(R.dimen.ds340));
            refreshData();
        }
        registerListener(this.dwM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.dwL && com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.h(getPageContext())) {
            o(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Class<? extends b> cls) {
        if (this.dwJ != null) {
            this.dwJ.p(cls);
        }
        if (this.dwI != null) {
            this.dwI.p(cls);
        }
    }

    private void initView() {
        this.dwI = new a(getPageContext());
        this.dwI.a(this.dwN);
        setContentView(this.dwI.getView());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dwI != null) {
            this.dwI.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(boolean z) {
        if (z) {
            if (l.isNetOk()) {
                a(R.drawable.new_pic_emotion_08, getResources().getString(R.string.load_error_new_tip), this.dwP);
            } else {
                a(R.drawable.new_pic_emotion_09, getResources().getString(R.string.recommend_pb_no_net_text), this.dwP);
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
        if (this.dwK == null) {
            this.dwK = new h(getPageContext().getPageActivity(), onClickListener);
            this.dwK.setButtonText(null);
            this.dwK.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.ds340));
            this.dwK.showRefreshButton();
            this.dwK.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.dwK.jZ(i);
        this.dwK.setSubText(null);
        this.dwK.setTitle(str);
        this.dwK.onChangeSkinType();
        this.dwK.dettachView(this.dwI.aJA());
        this.dwK.attachView(this.dwI.aJA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJm() {
        if (this.dwK != null) {
            this.dwK.dettachView(this.dwI.aJA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.isLoading = true;
        this.dwJ.vV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isLoading = false;
        if (this.dwI != null) {
            this.dwI.fU(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dwJ != null) {
            this.dwJ.onDestroy();
        }
        hideLoadingView(this.dwI.aJw());
        if (this.dwI != null) {
            this.dwI.onDestroy();
        }
    }
}
