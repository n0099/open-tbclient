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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameRecommendFragment extends BaseFragment implements ah {
    private com.baidu.tieba.frs.gamerecommend.c.a fIE;
    private AlaGameRecommendModel fIF;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener dBH = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.toInt(split[1], 0)) {
                    FrsGameRecommendFragment.this.aKh();
                }
            }
        }
    };
    private AlaGameRecommendModel.a fIG = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void d(boolean z, List<m> list) {
            FrsGameRecommendFragment.this.fIE.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.fIE.bnT());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.fIE.bnT());
            FrsGameRecommendFragment.this.fIE.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void d(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.fIE.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.fIE.bnT(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(R.string.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.fIE.aJS();
        }
    };
    private h.c cpS = new h.c() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (FrsGameRecommendFragment.this.fIF != null) {
                    FrsGameRecommendFragment.this.fIF.loadData();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(R.string.neterror);
            FrsGameRecommendFragment.this.fIE.completePullRefresh();
        }
    };
    private BdListView.e ye = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.fIF != null) {
                FrsGameRecommendFragment.this.fIF.aIW();
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
            this.fIE = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.fIE.setListPullRefreshListener(this.cpS);
            this.fIE.b(this.ye);
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.dBH);
            this.fIF = new AlaGameRecommendModel(this.mForumId, this.fIG);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.fIE.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
        this.fIE.aKh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.fIF != null) {
            this.fIF.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aKR() {
        return this.fIE.aKR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.fIF != null) {
            if (this.fIF.hasData()) {
                aKh();
                return;
            }
            this.fIF.loadData();
            showLoadingView(this.fIE.bnT());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fIE != null) {
            this.fIE.onDestroy();
        }
        if (this.fIF != null) {
            this.fIF.onDestroy();
        }
        if (this.dBH != null) {
            MessageManager.getInstance().unRegisterListener(this.dBH);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fIE != null) {
            this.fIE.onChangeSkinType(i);
        }
    }
}
