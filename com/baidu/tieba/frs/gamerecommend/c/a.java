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
import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes22.dex */
public class a {
    private BdTypeListView gih;
    private PbListView gjo;
    private com.baidu.tieba.frs.gamerecommend.a.a iYg;
    private FrameLayout iYh;
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
        this.iYh = (FrameLayout) this.mRootView.findViewById(R.id.game_recom_container);
        this.gih = (BdTypeListView) this.mRootView.findViewById(R.id.game_recom_listview);
        this.gih.setDivider(null);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.mPageContext.getUniqueId());
        this.gih.setPullRefresh(this.mPullView);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamerecommend.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.goBack();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gjo = new PbListView(this.mPageContext.getPageActivity());
        this.gjo.createView();
        this.iYg = new com.baidu.tieba.frs.gamerecommend.a.a(this.mPageContext, this.gih, this.mForumId, this.mForumName);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<q> list, boolean z) {
        if (z) {
            bOX();
        } else {
            bOW();
        }
        this.iYg.setData(list);
    }

    private void bOW() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.gih.setNextPage(this.gjo);
            }
            this.gjo.setText(this.mPageContext.getPageActivity().getResources().getString(R.string.list_no_more));
            this.gjo.endLoadData();
        }
    }

    private void bOX() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.gih.setNextPage(this.gjo);
            }
            this.gjo.showLoadingViewWithoutEmptyView();
            this.gjo.startLoadData();
        }
    }

    public void bPG() {
        this.gih.setNextPage(null);
    }

    public void completePullRefresh() {
        this.gih.completePullRefresh();
    }

    public void b(BdListView.e eVar) {
        this.gih.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bPV() {
        if (this.gih != null && j.isNetWorkAvailable()) {
            this.gih.startPullRefresh();
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public FrameLayout cCV() {
        return this.iYh;
    }

    public NavigationBar bSH() {
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
