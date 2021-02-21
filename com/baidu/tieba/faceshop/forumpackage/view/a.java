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
/* loaded from: classes9.dex */
public class a {
    private NoNetworkView gAv;
    private PbListView gAw;
    private g gJB;
    private BdTypeListView gzp;
    private com.baidu.tieba.faceshop.emotioncenter.a iZd;
    private LinearLayout jaC;
    private ForumEmotionVoteEntryView jaJ;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mRootView = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.gAv = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gzp = (BdTypeListView) this.mRootView.findViewById(R.id.forum_emotion_list);
        this.gzp.addHeaderView(this.jaC);
        this.gzp.setDivider(null);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gzp.setPullRefresh(this.mPullView);
        this.gAw = new PbListView(tbPageContext.getPageActivity());
        this.gAw.createView();
        cAu();
        cAw();
        cAv();
        showLoadingView();
    }

    public BdTypeListView getListView() {
        return this.gzp;
    }

    private void cAu() {
        this.jaC = new LinearLayout(this.mPageContext.getPageActivity());
        this.jaC.setGravity(17);
        this.gzp.addHeaderView(this.jaC);
    }

    private void cAv() {
        this.jaJ = new ForumEmotionVoteEntryView(this.mPageContext.getPageActivity());
        this.gzp.addHeaderView(this.jaJ);
    }

    private void cAw() {
        this.iZd = new com.baidu.tieba.faceshop.emotioncenter.a(this.mPageContext);
        this.iZd.getView().setVisibility(8);
        this.gzp.addHeaderView(this.iZd.getView());
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gJB = new g(this.mPageContext.getPageActivity());
            this.gJB.attachView(this.mRootView, false);
            this.gJB.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.mRootView);
            this.gJB = null;
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.iZd.getView().setVisibility(0);
        this.jaJ.setVisibility(0);
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.jaC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.d.dS(null, this.mPageContext.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.mNoDataView.setVisibility(0);
        this.iZd.getView().setVisibility(4);
        this.jaJ.setVisibility(4);
        this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public ViewGroup getView() {
        return this.mRootView;
    }

    public View cAg() {
        return this.gAv;
    }

    public void c(ForumEmotionData forumEmotionData) {
        if (forumEmotionData != null) {
            hideLoadingView();
            if (forumEmotionData.banner != null) {
                this.iZd.getView().setVisibility(0);
                this.iZd.l(this.mPageContext.getUniqueId());
                this.iZd.a(new c(forumEmotionData.banner));
                this.iZd.bvv();
            }
            if (forumEmotionData.forum_avatar != null) {
                this.jaJ.setAvatarList(forumEmotionData.forum_avatar);
            }
        }
    }

    public void completePullRefresh() {
        this.gzp.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public ForumEmotionVoteEntryView cAx() {
        return this.jaJ;
    }

    public void bRx() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gzp.setNextPage(this.gAw);
            }
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gAw.endLoadData();
        }
    }

    public void bRy() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gzp.setNextPage(this.gAw);
            }
            this.gAw.showLoadingViewWithoutEmptyView();
            this.gAw.startLoadData();
        }
    }

    public void bSy() {
        if (this.gAw != null) {
            this.gAw.endLoadData();
        }
        this.gzp.setNextPage(null);
    }

    public void b(BdListView.e eVar) {
        this.gzp.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAw.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.gzp.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gAv.onChangeSkinType(this.mPageContext, i);
        if (this.jaJ != null) {
            this.jaJ.onChangeSkin(i);
        }
    }
}
