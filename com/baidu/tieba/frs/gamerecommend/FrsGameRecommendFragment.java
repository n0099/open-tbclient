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
    private com.baidu.tieba.frs.gamerecommend.c.a dMX;
    private AlaGameRecommendModel dMY;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener bLT = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.l(split[1], 0)) {
                    FrsGameRecommendFragment.this.ZG();
                }
            }
        }
    };
    private AlaGameRecommendModel.a dMZ = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(boolean z, List<h> list) {
            FrsGameRecommendFragment.this.dMX.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.dMX.aDM());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.dMX.aDM());
            FrsGameRecommendFragment.this.dMX.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void e(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.dMX.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.dMX.aDM(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(e.j.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.dMX.Zj();
        }
    };
    private j.b aEo = new j.b() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.j.b
        public void bp(boolean z) {
            if (com.baidu.adp.lib.util.j.kX()) {
                if (FrsGameRecommendFragment.this.dMY != null) {
                    FrsGameRecommendFragment.this.dMY.loadData();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(e.j.neterror);
            FrsGameRecommendFragment.this.dMX.completePullRefresh();
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.dMY != null) {
                FrsGameRecommendFragment.this.dMY.YL();
            }
        }
    };

    public static FrsGameRecommendFragment by(String str, String str2) {
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
            this.dMX = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.dMX.a(this.aEo);
            this.dMX.a(this.mOnScrollToBottomListener);
            MessageManager.getInstance().registerListener(2001446, this.bLT);
            this.dMY = new AlaGameRecommendModel(this.mForumId, this.dMZ);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.dMX.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZG() {
        this.dMX.ZG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dMY != null) {
            this.dMY.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar aaE() {
        return this.dMX.aaE();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dMY != null) {
            if (this.dMY.hasData()) {
                ZG();
                return;
            }
            this.dMY.loadData();
            showLoadingView(this.dMX.aDM());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dMX != null) {
            this.dMX.onDestroy();
        }
        if (this.dMY != null) {
            this.dMY.onDestroy();
        }
        if (this.bLT != null) {
            MessageManager.getInstance().unRegisterListener(this.bLT);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dMX != null) {
            this.dMX.onChangeSkinType(i);
        }
    }
}
