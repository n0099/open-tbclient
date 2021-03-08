package com.baidu.tieba.faceshop.forumpackage.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotioncenter.data.c;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
/* loaded from: classes8.dex */
public class a {
    private BdTypeListView gAY;
    private NoNetworkView gCe;
    private PbListView gCf;
    private g gLk;
    private com.baidu.tieba.faceshop.emotioncenter.a jaM;
    private LinearLayout jcl;
    private ForumEmotionVoteEntryView jcs;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mRootView = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gAY = (BdTypeListView) this.mRootView.findViewById(R.id.forum_emotion_list);
        this.gAY.addHeaderView(this.jcl);
        this.gAY.setDivider(null);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gAY.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(tbPageContext.getPageActivity());
        this.gCf.createView();
        cAA();
        cAC();
        cAB();
        showLoadingView();
    }

    public BdTypeListView getListView() {
        return this.gAY;
    }

    private void cAA() {
        this.jcl = new LinearLayout(this.mPageContext.getPageActivity());
        this.jcl.setGravity(17);
        this.gAY.addHeaderView(this.jcl);
    }

    private void cAB() {
        this.jcs = new ForumEmotionVoteEntryView(this.mPageContext.getPageActivity());
        this.gAY.addHeaderView(this.jcs);
    }

    private void cAC() {
        this.jaM = new com.baidu.tieba.faceshop.emotioncenter.a(this.mPageContext);
        this.jaM.getView().setVisibility(8);
        this.gAY.addHeaderView(this.jaM.getView());
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gLk = new g(this.mPageContext.getPageActivity());
            this.gLk.attachView(this.mRootView, false);
            this.gLk.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this.mRootView);
            this.gLk = null;
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.jaM.getView().setVisibility(0);
        this.jcs.setVisibility(0);
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.jcl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.d.dS(null, this.mPageContext.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.mNoDataView.setVisibility(0);
        this.jaM.getView().setVisibility(4);
        this.jcs.setVisibility(4);
        this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public ViewGroup getView() {
        return this.mRootView;
    }

    public View cAm() {
        return this.gCe;
    }

    public void c(ForumEmotionData forumEmotionData) {
        if (forumEmotionData != null) {
            hideLoadingView();
            if (forumEmotionData.banner != null) {
                this.jaM.getView().setVisibility(0);
                this.jaM.l(this.mPageContext.getUniqueId());
                this.jaM.a(new c(forumEmotionData.banner));
                this.jaM.bvy();
            }
            if (forumEmotionData.forum_avatar != null) {
                this.jcs.setAvatarList(forumEmotionData.forum_avatar);
            }
        }
    }

    public void completePullRefresh() {
        this.gAY.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public ForumEmotionVoteEntryView cAD() {
        return this.jcs;
    }

    public void bRD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    public void bRE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.showLoadingViewWithoutEmptyView();
            this.gCf.startLoadData();
        }
    }

    public void bSE() {
        if (this.gCf != null) {
            this.gCf.endLoadData();
        }
        this.gAY.setNextPage(null);
    }

    public void b(BdListView.e eVar) {
        this.gAY.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.gAY.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gCe.onChangeSkinType(this.mPageContext, i);
        if (this.jcs != null) {
            this.jcs.onChangeSkin(i);
        }
    }
}
