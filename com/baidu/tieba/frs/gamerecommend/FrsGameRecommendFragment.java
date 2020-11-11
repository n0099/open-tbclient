package com.baidu.tieba.frs.gamerecommend;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsGameRecommendFragment extends BaseFragment implements at {
    private com.baidu.tieba.frs.gamerecommend.c.a iXl;
    private AlaGameRecommendModel iXm;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener gps = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.toInt(split[1], 0)) {
                    FrsGameRecommendFragment.this.bPV();
                }
            }
        }
    };
    private AlaGameRecommendModel.a iXn = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void e(boolean z, List<q> list) {
            FrsGameRecommendFragment.this.iXl.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.iXl.cCV());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.iXl.cCV());
            FrsGameRecommendFragment.this.iXl.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void h(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.iXl.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.iXl.cCV(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(R.string.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.iXl.bPG();
        }
    };
    private f.c eVA = new f.c() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (FrsGameRecommendFragment.this.iXm != null) {
                    FrsGameRecommendFragment.this.iXm.loadData();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(R.string.neterror);
            FrsGameRecommendFragment.this.iXl.completePullRefresh();
        }
    };
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.iXm != null) {
                FrsGameRecommendFragment.this.iXm.bOI();
            }
        }
    };

    public static FrsGameRecommendFragment eT(String str, String str2) {
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
            this.iXl = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.iXl.setListPullRefreshListener(this.eVA);
            this.iXl.b(this.VR);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gps);
            this.iXm = new AlaGameRecommendModel(this.mForumId, this.iXn);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.iXl.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPV() {
        this.iXl.bPV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.iXm != null) {
            this.iXm.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bSH() {
        return this.iXl.bSH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.iXm != null) {
            if (this.iXm.hasData()) {
                bPV();
                return;
            }
            this.iXm.loadData();
            showLoadingView(this.iXl.cCV());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iXl != null) {
            this.iXl.onDestroy();
        }
        if (this.iXm != null) {
            this.iXm.onDestroy();
        }
        if (this.gps != null) {
            MessageManager.getInstance().unRegisterListener(this.gps);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iXl != null) {
            this.iXl.onChangeSkinType(i);
        }
    }
}
