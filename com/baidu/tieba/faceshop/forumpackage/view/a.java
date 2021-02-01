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
    private NoNetworkView gAh;
    private PbListView gAi;
    private g gJn;
    private BdTypeListView gzb;
    private com.baidu.tieba.faceshop.emotioncenter.a iYP;
    private LinearLayout jao;
    private ForumEmotionVoteEntryView jav;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mRootView = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.gAh = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gzb = (BdTypeListView) this.mRootView.findViewById(R.id.forum_emotion_list);
        this.gzb.addHeaderView(this.jao);
        this.gzb.setDivider(null);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gzb.setPullRefresh(this.mPullView);
        this.gAi = new PbListView(tbPageContext.getPageActivity());
        this.gAi.createView();
        cAn();
        cAp();
        cAo();
        showLoadingView();
    }

    public BdTypeListView getListView() {
        return this.gzb;
    }

    private void cAn() {
        this.jao = new LinearLayout(this.mPageContext.getPageActivity());
        this.jao.setGravity(17);
        this.gzb.addHeaderView(this.jao);
    }

    private void cAo() {
        this.jav = new ForumEmotionVoteEntryView(this.mPageContext.getPageActivity());
        this.gzb.addHeaderView(this.jav);
    }

    private void cAp() {
        this.iYP = new com.baidu.tieba.faceshop.emotioncenter.a(this.mPageContext);
        this.iYP.getView().setVisibility(8);
        this.gzb.addHeaderView(this.iYP.getView());
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gJn = new g(this.mPageContext.getPageActivity());
            this.gJn.attachView(this.mRootView, false);
            this.gJn.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this.mRootView);
            this.gJn = null;
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.iYP.getView().setVisibility(0);
        this.jav.setVisibility(0);
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.jao, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.d.dS(null, this.mPageContext.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.mNoDataView.setVisibility(0);
        this.iYP.getView().setVisibility(4);
        this.jav.setVisibility(4);
        this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public ViewGroup getView() {
        return this.mRootView;
    }

    public View czZ() {
        return this.gAh;
    }

    public void c(ForumEmotionData forumEmotionData) {
        if (forumEmotionData != null) {
            hideLoadingView();
            if (forumEmotionData.banner != null) {
                this.iYP.getView().setVisibility(0);
                this.iYP.l(this.mPageContext.getUniqueId());
                this.iYP.a(new c(forumEmotionData.banner));
                this.iYP.bvv();
            }
            if (forumEmotionData.forum_avatar != null) {
                this.jav.setAvatarList(forumEmotionData.forum_avatar);
            }
        }
    }

    public void completePullRefresh() {
        this.gzb.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public ForumEmotionVoteEntryView cAq() {
        return this.jav;
    }

    public void bRq() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gzb.setNextPage(this.gAi);
            }
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gAi.endLoadData();
        }
    }

    public void bRr() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gzb.setNextPage(this.gAi);
            }
            this.gAi.showLoadingViewWithoutEmptyView();
            this.gAi.startLoadData();
        }
    }

    public void bSr() {
        if (this.gAi != null) {
            this.gAi.endLoadData();
        }
        this.gzb.setNextPage(null);
    }

    public void b(BdListView.e eVar) {
        this.gzb.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAi.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.gzb.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gAh.onChangeSkinType(this.mPageContext, i);
        if (this.jav != null) {
            this.jav.onChangeSkin(i);
        }
    }
}
