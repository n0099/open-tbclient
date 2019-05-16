package com.baidu.tieba.frs.gamerecommend.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private PbListView dlX;
    private com.baidu.tieba.frs.gamerecommend.a.a fCE;
    private FrameLayout fCF;
    private String mForumId;
    private String mForumName;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private i mPullView;
    private View mRootView;

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.mForumId = str;
        this.mForumName = str2;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        this.fCF = (FrameLayout) this.mRootView.findViewById(R.id.game_recom_container);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(R.id.game_recom_listview);
        this.mListView.setDivider(null);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.mPageContext.getUniqueId());
        this.mListView.setPullRefresh(this.mPullView);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamerecommend.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.goBack();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.dlX = new PbListView(this.mPageContext.getPageActivity());
        this.dlX.nG();
        this.fCE = new com.baidu.tieba.frs.gamerecommend.a.a(this.mPageContext, this.mListView, this.mForumId, this.mForumName);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<m> list, boolean z) {
        if (z) {
            aHE();
        } else {
            aHD();
        }
        this.fCE.setData(list);
    }

    private void aHD() {
        if (this.dlX != null) {
            if (this.dlX.getView().getParent() == null) {
                this.mListView.setNextPage(this.dlX);
            }
            this.dlX.setText(this.mPageContext.getPageActivity().getResources().getString(R.string.list_no_more));
            this.dlX.ajz();
        }
    }

    private void aHE() {
        if (this.dlX != null) {
            if (this.dlX.getView().getParent() == null) {
                this.mListView.setNextPage(this.dlX);
            }
            this.dlX.ajE();
            this.dlX.ajy();
        }
    }

    public void aIm() {
        this.mListView.setNextPage(null);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void b(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void aID() {
        if (this.mListView != null && j.jS()) {
            this.mListView.startPullRefresh();
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public FrameLayout bnL() {
        return this.fCF;
    }

    public NavigationBar aJz() {
        return this.mNavigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void onChangeSkinType(int i) {
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(this.mPageContext, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void onDestroy() {
    }
}
