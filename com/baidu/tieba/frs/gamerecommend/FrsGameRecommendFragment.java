package com.baidu.tieba.frs.gamerecommend;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameRecommendFragment extends BaseFragment implements ak {
    private com.baidu.tieba.frs.gamerecommend.c.a dXu;
    private AlaGameRecommendModel dXv;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener bQx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.l(split[1], 0)) {
                    FrsGameRecommendFragment.this.aaY();
                }
            }
        }
    };
    private AlaGameRecommendModel.a dXw = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(boolean z, List<h> list) {
            FrsGameRecommendFragment.this.dXu.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.dXu.aFH());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.dXu.aFH());
            FrsGameRecommendFragment.this.dXu.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void e(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.dXu.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.dXu.aFH(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(e.j.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.dXu.aaB();
        }
    };
    private j.b aIF = new j.b() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            if (com.baidu.adp.lib.util.j.kV()) {
                if (FrsGameRecommendFragment.this.dXv != null) {
                    FrsGameRecommendFragment.this.dXv.loadData();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(e.j.neterror);
            FrsGameRecommendFragment.this.dXu.completePullRefresh();
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.dXv != null) {
                FrsGameRecommendFragment.this.dXv.aad();
            }
        }
    };

    public static FrsGameRecommendFragment bD(String str, String str2) {
        FrsGameRecommendFragment frsGameRecommendFragment = new FrsGameRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putString("forum_id", str);
        bundle.putString("forum_name", str2);
        frsGameRecommendFragment.setArguments(bundle);
        return frsGameRecommendFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id");
            this.mForumName = arguments.getString("forum_name");
            this.dXu = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.dXu.a(this.aIF);
            this.dXu.a(this.mOnScrollToBottomListener);
            MessageManager.getInstance().registerListener(2001446, this.bQx);
            this.dXv = new AlaGameRecommendModel(this.mForumId, this.dXw);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.dXu.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaY() {
        this.dXu.aaY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dXv != null) {
            this.dXv.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar abW() {
        return this.dXu.abW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dXv != null) {
            if (this.dXv.hasData()) {
                aaY();
                return;
            }
            this.dXv.loadData();
            showLoadingView(this.dXu.aFH());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dXu != null) {
            this.dXu.onDestroy();
        }
        if (this.dXv != null) {
            this.dXv.onDestroy();
        }
        if (this.bQx != null) {
            MessageManager.getInstance().unRegisterListener(this.bQx);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dXu != null) {
            this.dXu.onChangeSkinType(i);
        }
    }
}
