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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsGameRecommendFragment extends BaseFragment implements am {
    private com.baidu.tieba.frs.gamerecommend.c.a hBB;
    private AlaGameRecommendModel hBC;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener fie = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.toInt(split[1], 0)) {
                    FrsGameRecommendFragment.this.brL();
                }
            }
        }
    };
    private AlaGameRecommendModel.a hBD = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void d(boolean z, List<o> list) {
            FrsGameRecommendFragment.this.hBB.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.hBB.bZi());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.hBB.bZi());
            FrsGameRecommendFragment.this.hBB.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void g(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.hBB.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.hBB.bZi(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(R.string.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.hBB.brw();
        }
    };
    private f.c dVt = new f.c() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (FrsGameRecommendFragment.this.hBC != null) {
                    FrsGameRecommendFragment.this.hBC.loadData();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(R.string.neterror);
            FrsGameRecommendFragment.this.hBB.completePullRefresh();
        }
    };
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.hBC != null) {
                FrsGameRecommendFragment.this.hBC.bqx();
            }
        }
    };

    public static FrsGameRecommendFragment ed(String str, String str2) {
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
            this.hBB = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.hBB.setListPullRefreshListener(this.dVt);
            this.hBB.b(this.Uf);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fie);
            this.hBC = new AlaGameRecommendModel(this.mForumId, this.hBD);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.hBB.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brL() {
        this.hBB.brL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.hBC != null) {
            this.hBC.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar bua() {
        return this.hBB.bua();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.hBC != null) {
            if (this.hBC.hasData()) {
                brL();
                return;
            }
            this.hBC.loadData();
            showLoadingView(this.hBB.bZi());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hBB != null) {
            this.hBB.onDestroy();
        }
        if (this.hBC != null) {
            this.hBC.onDestroy();
        }
        if (this.fie != null) {
            MessageManager.getInstance().unRegisterListener(this.fie);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hBB != null) {
            this.hBB.onChangeSkinType(i);
        }
    }
}
