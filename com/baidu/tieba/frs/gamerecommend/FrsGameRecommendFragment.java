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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameRecommendFragment extends BaseFragment implements ak {
    private com.baidu.tieba.frs.gamerecommend.c.a dvE;
    private AlaGameRecommendModel dvF;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener bwS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.g(split[1], 0)) {
                    FrsGameRecommendFragment.this.Ua();
                }
            }
        }
    };
    private AlaGameRecommendModel.a dvG = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(boolean z, List<h> list) {
            FrsGameRecommendFragment.this.dvE.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.dvE.axA());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.dvE.axA());
            FrsGameRecommendFragment.this.dvE.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.dvE.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.dvE.axA(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(d.k.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.dvE.TD();
        }
    };
    private g.b awQ = new g.b() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.g.b
        public void aU(boolean z) {
            if (j.jD()) {
                if (FrsGameRecommendFragment.this.dvF != null) {
                    FrsGameRecommendFragment.this.dvF.SK();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(d.k.neterror);
            FrsGameRecommendFragment.this.dvE.completePullRefresh();
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.dvF != null) {
                FrsGameRecommendFragment.this.dvF.Tf();
            }
        }
    };

    public static FrsGameRecommendFragment bg(String str, String str2) {
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
            this.dvE = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.dvE.a(this.awQ);
            this.dvE.a(this.mOnScrollToBottomListener);
            MessageManager.getInstance().registerListener(2001446, this.bwS);
            this.dvF = new AlaGameRecommendModel(this.mForumId, this.dvG);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.dvE.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ua() {
        this.dvE.Ua();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dvF != null) {
            this.dvF.SK();
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar UW() {
        return this.dvE.UW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dvF != null) {
            if (this.dvF.hasData()) {
                Ua();
                return;
            }
            this.dvF.SK();
            showLoadingView(this.dvE.axA());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dvE != null) {
            this.dvE.onDestroy();
        }
        if (this.dvF != null) {
            this.dvF.onDestroy();
        }
        if (this.bwS != null) {
            MessageManager.getInstance().unRegisterListener(this.bwS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dvE != null) {
            this.dvE.onChangeSkinType(i);
        }
    }
}
