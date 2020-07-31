package com.baidu.tieba.enterForum.hotuserrank;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
/* loaded from: classes16.dex */
public class HotUserRankFragment extends BaseFragment {
    private com.baidu.tieba.enterForum.hotuserrank.model.a hjP;
    private c hjX;
    private String mCategory;
    private long mForumId;
    private View mRootView;
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (HotUserRankFragment.this.hjP.hasMore()) {
                HotUserRankFragment.this.bVE();
                HotUserRankFragment.this.hjX.bxS();
            }
        }
    };
    private a.InterfaceC0619a hjV = new a.InterfaceC0619a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankFragment.2
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0619a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            if (HotUserRankFragment.this.isLoadingViewAttached()) {
                HotUserRankFragment.this.hideLoadingView(HotUserRankFragment.this.mRootView);
            }
            if (cVar != null) {
                if (HotUserRankFragment.this.hjP.bVH() == 2) {
                    if (HotUserRankFragment.this.mForumId > 0 || TextUtils.isEmpty(HotUserRankFragment.this.mCategory)) {
                        cVar.hkS.hkH = HotUserRankFragment.this.getResources().getString(R.string.forum_hot_user_rank);
                    } else if (cVar.hkS != null) {
                        cVar.hkS.hkH = String.format(HotUserRankFragment.this.getResources().getString(R.string.hot_user_rank_category_name), HotUserRankFragment.this.mCategory);
                    }
                    HotUserRankFragment.this.hjX.b(cVar.hkS, as.isEmpty(HotUserRankFragment.this.mCategory) ? false : true);
                    if (HotUserRankFragment.this.isResumed() || HotUserRankFragment.this.getBaseFragmentActivity() != null) {
                        CustomMessage customMessage = new CustomMessage(2921447);
                        customMessage.setTag(HotUserRankFragment.this.getBaseFragmentActivity().getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
                if (HotUserRankFragment.this.hjP.getPageData() != null) {
                    HotUserRankFragment.this.hjX.cj(HotUserRankFragment.this.hjP.getPageData().hkT);
                }
                if (!HotUserRankFragment.this.hjP.hasMore()) {
                    HotUserRankFragment.this.hjX.EX(HotUserRankFragment.this.mCategory);
                }
            }
        }

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0619a
        public void onError(int i, String str) {
            HotUserRankFragment.this.hideLoadingView(HotUserRankFragment.this.mRootView);
            HotUserRankFragment.this.showNetRefreshView(HotUserRankFragment.this.mRootView, str, false);
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hjP = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.hjP.a(this.hjV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
            this.hjX = new c(this.mRootView.findViewById(R.id.rank_list), this.mCategory, this.mForumId);
            this.hjX.setOnSrollToBottomListener(this.UC);
        }
        if (this.hjP.getPageData() == null || x.isEmpty(this.hjP.getPageData().hkT)) {
            bVE();
            showLoadingView(this.mRootView);
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVE() {
        if (!TextUtils.isEmpty(this.mCategory)) {
            this.hjP.EY(this.mCategory);
        } else if (this.mForumId > 0) {
            this.hjP.eo(this.mForumId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hjX.onChangeSkinType(i);
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public com.baidu.tieba.enterForum.hotuserrank.model.a bVF() {
        return this.hjP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        bVE();
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.hjP.onDestroy();
    }
}
