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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
/* loaded from: classes2.dex */
public class HotUserRankFragment extends BaseFragment {
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (HotUserRankFragment.this.iKx.hasMore()) {
                HotUserRankFragment.this.cwB();
                HotUserRankFragment.this.iKF.WX();
            }
        }
    };
    private a.InterfaceC0707a iKD = new a.InterfaceC0707a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankFragment.2
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0707a
        public void a(c cVar) {
            if (HotUserRankFragment.this.isLoadingViewAttached()) {
                HotUserRankFragment.this.hideLoadingView(HotUserRankFragment.this.mRootView);
            }
            if (cVar != null) {
                if (HotUserRankFragment.this.iKx.cwE() == 2) {
                    if (HotUserRankFragment.this.mForumId > 0 || TextUtils.isEmpty(HotUserRankFragment.this.mCategory)) {
                        cVar.iLx.rankName = HotUserRankFragment.this.getResources().getString(R.string.forum_hot_user_rank);
                    } else if (cVar.iLx != null) {
                        if (HotUserRankFragment.this.isGod) {
                            cVar.iLx.rankName = String.format(HotUserRankFragment.this.getResources().getString(R.string.god_rank_category_name), HotUserRankFragment.this.mCategory);
                        } else {
                            cVar.iLx.rankName = String.format(HotUserRankFragment.this.getResources().getString(R.string.hot_user_rank_category_name), HotUserRankFragment.this.mCategory);
                        }
                    }
                    HotUserRankFragment.this.iKF.b(cVar.iLx, au.isEmpty(HotUserRankFragment.this.mCategory) ? false : true);
                    if (HotUserRankFragment.this.isResumed() || HotUserRankFragment.this.getBaseFragmentActivity() != null) {
                        CustomMessage customMessage = new CustomMessage(2921447);
                        customMessage.setTag(HotUserRankFragment.this.getBaseFragmentActivity().getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
                if (HotUserRankFragment.this.iKx.getPageData() != null) {
                    HotUserRankFragment.this.iKF.cR(HotUserRankFragment.this.iKx.getPageData().iLy);
                }
                if (!HotUserRankFragment.this.iKx.hasMore()) {
                    HotUserRankFragment.this.iKF.Jm(HotUserRankFragment.this.mCategory);
                }
            }
        }

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0707a
        public void onError(int i, String str) {
            HotUserRankFragment.this.hideLoadingView(HotUserRankFragment.this.mRootView);
            HotUserRankFragment.this.showNetRefreshView(HotUserRankFragment.this.mRootView, str, false);
        }
    };
    private RankListViewController iKF;
    private com.baidu.tieba.enterForum.hotuserrank.model.a iKx;
    private boolean isGod;
    private String mCategory;
    private long mForumId;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iKx = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.iKx.a(this.iKD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
            this.iKF = new RankListViewController(this.mRootView.findViewById(R.id.rank_list), this.mCategory, this.mForumId);
            this.iKF.setOnSrollToBottomListener(this.WH);
        }
        if (this.iKx.getPageData() == null || y.isEmpty(this.iKx.getPageData().iLy)) {
            cwB();
            showLoadingView(this.mRootView);
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwB() {
        if (!TextUtils.isEmpty(this.mCategory)) {
            this.iKx.Jn(this.mCategory);
        } else if (this.mForumId > 0) {
            this.iKx.gj(this.mForumId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iKF.onChangeSkinType(i);
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

    public com.baidu.tieba.enterForum.hotuserrank.model.a cwC() {
        return this.iKx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        cwB();
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.iKx.onDestroy();
    }
}
