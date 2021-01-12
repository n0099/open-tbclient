package com.baidu.tieba.enterForum.hotuserrank;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
/* loaded from: classes2.dex */
public class HotUserRankFragment extends BaseFragment {
    private com.baidu.tieba.enterForum.hotuserrank.model.a iEA;
    private RankListViewController iEI;
    private boolean isGod;
    private String mCategory;
    private long mForumId;
    private View mRootView;
    private BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (HotUserRankFragment.this.iEA.hasMore()) {
                HotUserRankFragment.this.cvi();
                HotUserRankFragment.this.iEI.Vo();
            }
        }
    };
    private a.InterfaceC0706a iEG = new a.InterfaceC0706a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankFragment.2
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0706a
        public void a(c cVar) {
            if (HotUserRankFragment.this.isLoadingViewAttached()) {
                HotUserRankFragment.this.hideLoadingView(HotUserRankFragment.this.mRootView);
            }
            if (cVar != null) {
                if (HotUserRankFragment.this.iEA.cvl() == 2) {
                    if (HotUserRankFragment.this.mForumId > 0 || TextUtils.isEmpty(HotUserRankFragment.this.mCategory)) {
                        cVar.iFA.rankName = HotUserRankFragment.this.getResources().getString(R.string.forum_hot_user_rank);
                    } else if (cVar.iFA != null) {
                        if (HotUserRankFragment.this.isGod) {
                            cVar.iFA.rankName = String.format(HotUserRankFragment.this.getResources().getString(R.string.god_rank_category_name), HotUserRankFragment.this.mCategory);
                        } else {
                            cVar.iFA.rankName = String.format(HotUserRankFragment.this.getResources().getString(R.string.hot_user_rank_category_name), HotUserRankFragment.this.mCategory);
                        }
                    }
                    HotUserRankFragment.this.iEI.b(cVar.iFA, at.isEmpty(HotUserRankFragment.this.mCategory) ? false : true);
                    if (HotUserRankFragment.this.isResumed() || HotUserRankFragment.this.getBaseFragmentActivity() != null) {
                        CustomMessage customMessage = new CustomMessage(2921447);
                        customMessage.setTag(HotUserRankFragment.this.getBaseFragmentActivity().getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
                if (HotUserRankFragment.this.iEA.getPageData() != null) {
                    HotUserRankFragment.this.iEI.cW(HotUserRankFragment.this.iEA.getPageData().iFB);
                }
                if (!HotUserRankFragment.this.iEA.hasMore()) {
                    HotUserRankFragment.this.iEI.IA(HotUserRankFragment.this.mCategory);
                }
            }
        }

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0706a
        public void onError(int i, String str) {
            HotUserRankFragment.this.hideLoadingView(HotUserRankFragment.this.mRootView);
            HotUserRankFragment.this.showNetRefreshView(HotUserRankFragment.this.mRootView, str, false);
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iEA = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.iEA.a(this.iEG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
            this.iEI = new RankListViewController(this.mRootView.findViewById(R.id.rank_list), this.mCategory, this.mForumId);
            this.iEI.setOnSrollToBottomListener(this.WL);
        }
        if (this.iEA.getPageData() == null || x.isEmpty(this.iEA.getPageData().iFB)) {
            cvi();
            showLoadingView(this.mRootView);
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvi() {
        if (!TextUtils.isEmpty(this.mCategory)) {
            this.iEA.IB(this.mCategory);
        } else if (this.mForumId > 0) {
            this.iEA.ge(this.mForumId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iEI.onChangeSkinType(i);
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public com.baidu.tieba.enterForum.hotuserrank.model.a cvj() {
        return this.iEA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        cvi();
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.iEA.onDestroy();
    }
}
