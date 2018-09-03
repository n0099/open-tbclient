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
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameRecommendFragment extends BaseFragment implements ak {
    private com.baidu.tieba.frs.gamerecommend.c.a dyo;
    private AlaGameRecommendModel dyp;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener bxz = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.g(split[1], 0)) {
                    FrsGameRecommendFragment.this.Ul();
                }
            }
        }
    };
    private AlaGameRecommendModel.a dyq = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(boolean z, List<h> list) {
            FrsGameRecommendFragment.this.dyo.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.dyo.ayd());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.dyo.ayd());
            FrsGameRecommendFragment.this.dyo.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.dyo.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.dyo.ayd(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(f.j.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.dyo.TO();
        }
    };
    private g.b awt = new g.b() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.g.b
        public void aT(boolean z) {
            if (j.jE()) {
                if (FrsGameRecommendFragment.this.dyp != null) {
                    FrsGameRecommendFragment.this.dyp.loadData();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(f.j.neterror);
            FrsGameRecommendFragment.this.dyo.completePullRefresh();
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.dyp != null) {
                FrsGameRecommendFragment.this.dyp.Tq();
            }
        }
    };

    public static FrsGameRecommendFragment be(String str, String str2) {
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
            this.dyo = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.dyo.a(this.awt);
            this.dyo.a(this.mOnScrollToBottomListener);
            MessageManager.getInstance().registerListener(2001446, this.bxz);
            this.dyp = new AlaGameRecommendModel(this.mForumId, this.dyq);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.dyo.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ul() {
        this.dyo.Ul();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dyp != null) {
            this.dyp.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar Vj() {
        return this.dyo.Vj();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dyp != null) {
            if (this.dyp.hasData()) {
                Ul();
                return;
            }
            this.dyp.loadData();
            showLoadingView(this.dyo.ayd());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dyo != null) {
            this.dyo.onDestroy();
        }
        if (this.dyp != null) {
            this.dyp.onDestroy();
        }
        if (this.bxz != null) {
            MessageManager.getInstance().unRegisterListener(this.bxz);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dyo != null) {
            this.dyo.onChangeSkinType(i);
        }
    }
}
