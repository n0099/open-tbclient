package com.baidu.tieba.frs.gamerecommend.b;

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
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private PbListView gAi;
    private BdTypeListView gzb;
    private com.baidu.tieba.frs.gamerecommend.adapter.a jzS;
    private FrameLayout jzT;
    private String mForumId;
    private String mForumName;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
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
        this.jzT = (FrameLayout) this.mRootView.findViewById(R.id.game_recom_container);
        this.gzb = (BdTypeListView) this.mRootView.findViewById(R.id.game_recom_listview);
        this.gzb.setDivider(null);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.mPageContext.getUniqueId());
        this.gzb.setPullRefresh(this.mPullView);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamerecommend.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.goBack();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gAi = new PbListView(this.mPageContext.getPageActivity());
        this.gAi.createView();
        this.jzS = new com.baidu.tieba.frs.gamerecommend.adapter.a(this.mPageContext, this.gzb, this.mForumId, this.mForumName);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<n> list, boolean z) {
        if (z) {
            bRr();
        } else {
            bRq();
        }
        this.jzS.setData(list);
    }

    private void bRq() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gzb.setNextPage(this.gAi);
            }
            this.gAi.setText(this.mPageContext.getPageActivity().getResources().getString(R.string.list_no_more));
            this.gAi.endLoadData();
        }
    }

    private void bRr() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gzb.setNextPage(this.gAi);
            }
            this.gAi.showLoadingViewWithoutEmptyView();
            this.gAi.startLoadData();
        }
    }

    public void bSb() {
        this.gzb.setNextPage(null);
    }

    public void completePullRefresh() {
        this.gzb.completePullRefresh();
    }

    public void b(BdListView.e eVar) {
        this.gzb.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bSq() {
        if (this.gzb != null && j.isNetWorkAvailable()) {
            this.gzb.startPullRefresh();
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public FrameLayout cIh() {
        return this.jzT;
    }

    public NavigationBar bVd() {
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
