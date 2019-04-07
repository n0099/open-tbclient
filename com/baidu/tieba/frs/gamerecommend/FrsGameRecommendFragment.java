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
    private com.baidu.tieba.frs.gamerecommend.c.a flp;
    private AlaGameRecommendModel flq;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener dgA = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.l(split[1], 0)) {
                    FrsGameRecommendFragment.this.aCq();
                }
            }
        }
    };
    private AlaGameRecommendModel.a flr = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(boolean z, List<m> list) {
            FrsGameRecommendFragment.this.flp.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.flp.bgu());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.flp.bgu());
            FrsGameRecommendFragment.this.flp.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void e(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.flp.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.flp.bgu(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(d.j.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.flp.aBY();
        }
    };
    private h.c bRI = new h.c() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (j.kY()) {
                if (FrsGameRecommendFragment.this.flq != null) {
                    FrsGameRecommendFragment.this.flq.loadData();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(d.j.neterror);
            FrsGameRecommendFragment.this.flp.completePullRefresh();
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.flq != null) {
                FrsGameRecommendFragment.this.flq.aAZ();
            }
        }
    };

    public static FrsGameRecommendFragment cK(String str, String str2) {
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
            this.flp = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.flp.setListPullRefreshListener(this.bRI);
            this.flp.b(this.mOnScrollToBottomListener);
            MessageManager.getInstance().registerListener(2001446, this.dgA);
            this.flq = new AlaGameRecommendModel(this.mForumId, this.flr);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.flp.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCq() {
        this.flp.aCq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.flq != null) {
            this.flq.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aDm() {
        return this.flp.aDm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.flq != null) {
            if (this.flq.hasData()) {
                aCq();
                return;
            }
            this.flq.loadData();
            showLoadingView(this.flp.bgu());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.flp != null) {
            this.flp.onDestroy();
        }
        if (this.flq != null) {
            this.flq.onDestroy();
        }
        if (this.dgA != null) {
            MessageManager.getInstance().unRegisterListener(this.dgA);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.flp != null) {
            this.flp.onChangeSkinType(i);
        }
    }
}
