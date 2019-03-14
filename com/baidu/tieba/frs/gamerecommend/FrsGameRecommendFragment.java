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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameRecommendFragment extends BaseFragment implements ah {
    private com.baidu.tieba.frs.gamerecommend.c.a flD;
    private AlaGameRecommendModel flE;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener dgw = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.l(split[1], 0)) {
                    FrsGameRecommendFragment.this.aCt();
                }
            }
        }
    };
    private AlaGameRecommendModel.a flF = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(boolean z, List<m> list) {
            FrsGameRecommendFragment.this.flD.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.flD.bgw());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.flD.bgw());
            FrsGameRecommendFragment.this.flD.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void e(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.flD.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.flD.bgw(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(d.j.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.flD.aCb();
        }
    };
    private h.c bRG = new h.c() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (j.kY()) {
                if (FrsGameRecommendFragment.this.flE != null) {
                    FrsGameRecommendFragment.this.flE.loadData();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(d.j.neterror);
            FrsGameRecommendFragment.this.flD.completePullRefresh();
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.flE != null) {
                FrsGameRecommendFragment.this.flE.aBc();
            }
        }
    };

    public static FrsGameRecommendFragment cJ(String str, String str2) {
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
            this.flD = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.flD.setListPullRefreshListener(this.bRG);
            this.flD.b(this.mOnScrollToBottomListener);
            MessageManager.getInstance().registerListener(2001446, this.dgw);
            this.flE = new AlaGameRecommendModel(this.mForumId, this.flF);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.flD.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCt() {
        this.flD.aCt();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.flE != null) {
            this.flE.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aDp() {
        return this.flD.aDp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.flE != null) {
            if (this.flE.hasData()) {
                aCt();
                return;
            }
            this.flE.loadData();
            showLoadingView(this.flD.bgw());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.flD != null) {
            this.flD.onDestroy();
        }
        if (this.flE != null) {
            this.flE.onDestroy();
        }
        if (this.dgw != null) {
            MessageManager.getInstance().unRegisterListener(this.dgw);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.flD != null) {
            this.flD.onChangeSkinType(i);
        }
    }
}
