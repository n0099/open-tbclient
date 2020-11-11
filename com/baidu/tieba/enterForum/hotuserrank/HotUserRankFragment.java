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
/* loaded from: classes22.dex */
public class HotUserRankFragment extends BaseFragment {
    private com.baidu.tieba.enterForum.hotuserrank.model.a ilk;
    private c ils;
    private boolean isGod;
    private String mCategory;
    private long mForumId;
    private View mRootView;
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (HotUserRankFragment.this.ilk.hasMore()) {
                HotUserRankFragment.this.csn();
                HotUserRankFragment.this.ils.Wi();
            }
        }
    };
    private a.InterfaceC0715a ilq = new a.InterfaceC0715a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankFragment.2
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0715a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            if (HotUserRankFragment.this.isLoadingViewAttached()) {
                HotUserRankFragment.this.hideLoadingView(HotUserRankFragment.this.mRootView);
            }
            if (cVar != null) {
                if (HotUserRankFragment.this.ilk.csq() == 2) {
                    if (HotUserRankFragment.this.mForumId > 0 || TextUtils.isEmpty(HotUserRankFragment.this.mCategory)) {
                        cVar.iml.rankName = HotUserRankFragment.this.getResources().getString(R.string.forum_hot_user_rank);
                    } else if (cVar.iml != null) {
                        if (HotUserRankFragment.this.isGod) {
                            cVar.iml.rankName = String.format(HotUserRankFragment.this.getResources().getString(R.string.god_rank_category_name), HotUserRankFragment.this.mCategory);
                        } else {
                            cVar.iml.rankName = String.format(HotUserRankFragment.this.getResources().getString(R.string.hot_user_rank_category_name), HotUserRankFragment.this.mCategory);
                        }
                    }
                    HotUserRankFragment.this.ils.b(cVar.iml, at.isEmpty(HotUserRankFragment.this.mCategory) ? false : true);
                    if (HotUserRankFragment.this.isResumed() || HotUserRankFragment.this.getBaseFragmentActivity() != null) {
                        CustomMessage customMessage = new CustomMessage(2921447);
                        customMessage.setTag(HotUserRankFragment.this.getBaseFragmentActivity().getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
                if (HotUserRankFragment.this.ilk.getPageData() != null) {
                    HotUserRankFragment.this.ils.cL(HotUserRankFragment.this.ilk.getPageData().imm);
                }
                if (!HotUserRankFragment.this.ilk.hasMore()) {
                    HotUserRankFragment.this.ils.Jx(HotUserRankFragment.this.mCategory);
                }
            }
        }

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0715a
        public void onError(int i, String str) {
            HotUserRankFragment.this.hideLoadingView(HotUserRankFragment.this.mRootView);
            HotUserRankFragment.this.showNetRefreshView(HotUserRankFragment.this.mRootView, str, false);
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilk = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.ilk.a(this.ilq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
            this.ils = new c(this.mRootView.findViewById(R.id.rank_list), this.mCategory, this.mForumId);
            this.ils.setOnSrollToBottomListener(this.VR);
        }
        if (this.ilk.getPageData() == null || y.isEmpty(this.ilk.getPageData().imm)) {
            csn();
            showLoadingView(this.mRootView);
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        if (!TextUtils.isEmpty(this.mCategory)) {
            this.ilk.Jy(this.mCategory);
        } else if (this.mForumId > 0) {
            this.ilk.fx(this.mForumId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ils.onChangeSkinType(i);
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

    public com.baidu.tieba.enterForum.hotuserrank.model.a cso() {
        return this.ilk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        csn();
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ilk.onDestroy();
    }
}
