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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
/* loaded from: classes16.dex */
public class HotUserRankFragment extends BaseFragment {
    private com.baidu.tieba.enterForum.hotuserrank.model.a hwG;
    private c hwO;
    private boolean isGod;
    private String mCategory;
    private long mForumId;
    private View mRootView;
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (HotUserRankFragment.this.hwG.hasMore()) {
                HotUserRankFragment.this.cfR();
                HotUserRankFragment.this.hwO.bGR();
            }
        }
    };
    private a.InterfaceC0670a hwM = new a.InterfaceC0670a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankFragment.2
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0670a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            if (HotUserRankFragment.this.isLoadingViewAttached()) {
                HotUserRankFragment.this.hideLoadingView(HotUserRankFragment.this.mRootView);
            }
            if (cVar != null) {
                if (HotUserRankFragment.this.hwG.cfU() == 2) {
                    if (HotUserRankFragment.this.mForumId > 0 || TextUtils.isEmpty(HotUserRankFragment.this.mCategory)) {
                        cVar.hxJ.hxy = HotUserRankFragment.this.getResources().getString(R.string.forum_hot_user_rank);
                    } else if (cVar.hxJ != null) {
                        if (HotUserRankFragment.this.isGod) {
                            cVar.hxJ.hxy = String.format(HotUserRankFragment.this.getResources().getString(R.string.god_rank_category_name), HotUserRankFragment.this.mCategory);
                        } else {
                            cVar.hxJ.hxy = String.format(HotUserRankFragment.this.getResources().getString(R.string.hot_user_rank_category_name), HotUserRankFragment.this.mCategory);
                        }
                    }
                    HotUserRankFragment.this.hwO.b(cVar.hxJ, at.isEmpty(HotUserRankFragment.this.mCategory) ? false : true);
                    if (HotUserRankFragment.this.isResumed() || HotUserRankFragment.this.getBaseFragmentActivity() != null) {
                        CustomMessage customMessage = new CustomMessage(2921447);
                        customMessage.setTag(HotUserRankFragment.this.getBaseFragmentActivity().getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
                if (HotUserRankFragment.this.hwG.getPageData() != null) {
                    HotUserRankFragment.this.hwO.cl(HotUserRankFragment.this.hwG.getPageData().hxK);
                }
                if (!HotUserRankFragment.this.hwG.hasMore()) {
                    HotUserRankFragment.this.hwO.Hw(HotUserRankFragment.this.mCategory);
                }
            }
        }

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0670a
        public void onError(int i, String str) {
            HotUserRankFragment.this.hideLoadingView(HotUserRankFragment.this.mRootView);
            HotUserRankFragment.this.showNetRefreshView(HotUserRankFragment.this.mRootView, str, false);
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hwG = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.hwG.a(this.hwM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
            this.hwO = new c(this.mRootView.findViewById(R.id.rank_list), this.mCategory, this.mForumId);
            this.hwO.setOnSrollToBottomListener(this.Vh);
        }
        if (this.hwG.getPageData() == null || y.isEmpty(this.hwG.getPageData().hxK)) {
            cfR();
            showLoadingView(this.mRootView);
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfR() {
        if (!TextUtils.isEmpty(this.mCategory)) {
            this.hwG.Hx(this.mCategory);
        } else if (this.mForumId > 0) {
            this.hwG.ez(this.mForumId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hwO.onChangeSkinType(i);
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

    public com.baidu.tieba.enterForum.hotuserrank.model.a cfS() {
        return this.hwG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        cfR();
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.hwG.onDestroy();
    }
}
