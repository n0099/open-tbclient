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
import com.baidu.tbadk.core.util.ao;
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
    private g gGD;
    private BdTypeListView gwr;
    private NoNetworkView gxx;
    private PbListView gxy;
    private com.baidu.tieba.faceshop.emotioncenter.a iTi;
    private LinearLayout iUH;
    private ForumEmotionVoteEntryView iUO;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mRootView = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.gxx = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gwr = (BdTypeListView) this.mRootView.findViewById(R.id.forum_emotion_list);
        this.gwr.addHeaderView(this.iUH);
        this.gwr.setDivider(null);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gwr.setPullRefresh(this.mPullView);
        this.gxy = new PbListView(tbPageContext.getPageActivity());
        this.gxy.createView();
        czc();
        cze();
        czd();
        showLoadingView();
    }

    public BdTypeListView getListView() {
        return this.gwr;
    }

    private void czc() {
        this.iUH = new LinearLayout(this.mPageContext.getPageActivity());
        this.iUH.setGravity(17);
        this.gwr.addHeaderView(this.iUH);
    }

    private void czd() {
        this.iUO = new ForumEmotionVoteEntryView(this.mPageContext.getPageActivity());
        this.gwr.addHeaderView(this.iUO);
    }

    private void cze() {
        this.iTi = new com.baidu.tieba.faceshop.emotioncenter.a(this.mPageContext);
        this.iTi.getView().setVisibility(8);
        this.gwr.addHeaderView(this.iTi.getView());
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gGD = new g(this.mPageContext.getPageActivity());
            this.gGD.attachView(this.mRootView, false);
            this.gGD.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.mRootView);
            this.gGD = null;
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.iTi.getView().setVisibility(0);
        this.iUO.setVisibility(0);
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.iUH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.d.dX(null, this.mPageContext.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.mNoDataView.setVisibility(0);
        this.iTi.getView().setVisibility(4);
        this.iUO.setVisibility(4);
        this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public ViewGroup getView() {
        return this.mRootView;
    }

    public View cyO() {
        return this.gxx;
    }

    public void c(ForumEmotionData forumEmotionData) {
        if (forumEmotionData != null) {
            hideLoadingView();
            if (forumEmotionData.banner != null) {
                this.iTi.getView().setVisibility(0);
                this.iTi.l(this.mPageContext.getUniqueId());
                this.iTi.a(new c(forumEmotionData.banner));
                this.iTi.bvb();
            }
            if (forumEmotionData.forum_avatar != null) {
                this.iUO.setAvatarList(forumEmotionData.forum_avatar);
            }
        }
    }

    public void completePullRefresh() {
        this.gwr.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public ForumEmotionVoteEntryView czf() {
        return this.iUO;
    }

    public void bQM() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gwr.setNextPage(this.gxy);
            }
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gxy.endLoadData();
        }
    }

    public void bQN() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gwr.setNextPage(this.gxy);
            }
            this.gxy.showLoadingViewWithoutEmptyView();
            this.gxy.startLoadData();
        }
    }

    public void bRO() {
        if (this.gxy != null) {
            this.gxy.endLoadData();
        }
        this.gwr.setNextPage(null);
    }

    public void b(BdListView.e eVar) {
        this.gwr.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gxy.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.gwr.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gxx.onChangeSkinType(this.mPageContext, i);
        if (this.iUO != null) {
            this.iUO.onChangeSkin(i);
        }
    }
}
