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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameRecommendFragment extends BaseFragment implements ah {
    private com.baidu.tieba.frs.gamerecommend.c.a fHx;
    private AlaGameRecommendModel fHy;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener dtv = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.f(split[1], 0)) {
                    FrsGameRecommendFragment.this.aKj();
                }
            }
        }
    };
    private AlaGameRecommendModel.a fHz = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void a(boolean z, List<m> list) {
            FrsGameRecommendFragment.this.fHx.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.fHx.bqc());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.fHx.bqc());
            FrsGameRecommendFragment.this.fHx.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void e(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.fHx.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.fHx.bqc(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(R.string.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.fHx.aJR();
        }
    };
    private h.c caJ = new h.c() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (j.kc()) {
                if (FrsGameRecommendFragment.this.fHy != null) {
                    FrsGameRecommendFragment.this.fHy.loadData();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(R.string.neterror);
            FrsGameRecommendFragment.this.fHx.completePullRefresh();
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.fHy != null) {
                FrsGameRecommendFragment.this.fHy.aIS();
            }
        }
    };

    public static FrsGameRecommendFragment cY(String str, String str2) {
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
            this.fHx = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.fHx.setListPullRefreshListener(this.caJ);
            this.fHx.b(this.mOnScrollToBottomListener);
            MessageManager.getInstance().registerListener(2001446, this.dtv);
            this.fHy = new AlaGameRecommendModel(this.mForumId, this.fHz);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.fHx.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKj() {
        this.fHx.aKj();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.fHy != null) {
            this.fHy.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aLj() {
        return this.fHx.aLj();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.fHy != null) {
            if (this.fHy.hasData()) {
                aKj();
                return;
            }
            this.fHy.loadData();
            showLoadingView(this.fHx.bqc());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fHx != null) {
            this.fHx.onDestroy();
        }
        if (this.fHy != null) {
            this.fHy.onDestroy();
        }
        if (this.dtv != null) {
            MessageManager.getInstance().unRegisterListener(this.dtv);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fHx != null) {
            this.fHx.onChangeSkinType(i);
        }
    }
}
