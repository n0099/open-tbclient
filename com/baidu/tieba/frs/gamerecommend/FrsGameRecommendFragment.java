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
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsGameRecommendFragment extends BaseFragment implements ar {
    private com.baidu.tieba.frs.gamerecommend.c.a hUI;
    private AlaGameRecommendModel hUJ;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener fyz = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.toInt(split[1], 0)) {
                    FrsGameRecommendFragment.this.bxR();
                }
            }
        }
    };
    private AlaGameRecommendModel.a hUK = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void e(boolean z, List<q> list) {
            FrsGameRecommendFragment.this.hUI.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.hUI.cfX());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.hUI.cfX());
            FrsGameRecommendFragment.this.hUI.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void g(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.hUI.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.hUI.cfX(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(R.string.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.hUI.bxC();
        }
    };
    private f.c ejc = new f.c() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (FrsGameRecommendFragment.this.hUJ != null) {
                    FrsGameRecommendFragment.this.hUJ.loadData();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(R.string.neterror);
            FrsGameRecommendFragment.this.hUI.completePullRefresh();
        }
    };
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.hUJ != null) {
                FrsGameRecommendFragment.this.hUJ.bwE();
            }
        }
    };

    public static FrsGameRecommendFragment el(String str, String str2) {
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
            this.hUI = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.hUI.setListPullRefreshListener(this.ejc);
            this.hUI.b(this.UC);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fyz);
            this.hUJ = new AlaGameRecommendModel(this.mForumId, this.hUK);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.hUI.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxR() {
        this.hUI.bxR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.hUJ != null) {
            this.hUJ.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public NavigationBar bAm() {
        return this.hUI.bAm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.hUJ != null) {
            if (this.hUJ.hasData()) {
                bxR();
                return;
            }
            this.hUJ.loadData();
            showLoadingView(this.hUI.cfX());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hUI != null) {
            this.hUI.onDestroy();
        }
        if (this.hUJ != null) {
            this.hUJ.onDestroy();
        }
        if (this.fyz != null) {
            MessageManager.getInstance().unRegisterListener(this.fyz);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hUI != null) {
            this.hUI.onChangeSkinType(i);
        }
    }
}
