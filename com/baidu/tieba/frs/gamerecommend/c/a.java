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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private BdTypeListView dvB;
    private PbListView dwJ;
    private FrameLayout fJA;
    private com.baidu.tieba.frs.gamerecommend.a.a fJz;
    private String mForumId;
    private String mForumName;
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
        this.fJA = (FrameLayout) this.mRootView.findViewById(R.id.game_recom_container);
        this.dvB = (BdTypeListView) this.mRootView.findViewById(R.id.game_recom_listview);
        this.dvB.setDivider(null);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.mPageContext.getUniqueId());
        this.dvB.setPullRefresh(this.mPullView);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamerecommend.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.goBack();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.dwJ = new PbListView(this.mPageContext.getPageActivity());
        this.dwJ.createView();
        this.fJz = new com.baidu.tieba.frs.gamerecommend.a.a(this.mPageContext, this.dvB, this.mForumId, this.mForumName);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<m> list, boolean z) {
        if (z) {
            aJl();
        } else {
            aJk();
        }
        this.fJz.setData(list);
    }

    private void aJk() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.dvB.setNextPage(this.dwJ);
            }
            this.dwJ.setText(this.mPageContext.getPageActivity().getResources().getString(R.string.list_no_more));
            this.dwJ.endLoadData();
        }
    }

    private void aJl() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.dvB.setNextPage(this.dwJ);
            }
            this.dwJ.showLoadingViewWithoutEmptyView();
            this.dwJ.startLoadData();
        }
    }

    public void aJS() {
        this.dvB.setNextPage(null);
    }

    public void completePullRefresh() {
        this.dvB.completePullRefresh();
    }

    public void b(BdListView.e eVar) {
        this.dvB.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void aKh() {
        if (this.dvB != null && j.isNetWorkAvailable()) {
            this.dvB.startPullRefresh();
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public FrameLayout bnT() {
        return this.fJA;
    }

    public NavigationBar aKR() {
        return this.mNavigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
        customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.mPageContext.getUniqueId()));
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
