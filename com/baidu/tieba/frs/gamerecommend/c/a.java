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
/* loaded from: classes16.dex */
public class a {
    private BdTypeListView frv;
    private PbListView fsC;
    private com.baidu.tieba.frs.gamerecommend.a.a hVF;
    private FrameLayout hVG;
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
        this.hVG = (FrameLayout) this.mRootView.findViewById(R.id.game_recom_container);
        this.frv = (BdTypeListView) this.mRootView.findViewById(R.id.game_recom_listview);
        this.frv.setDivider(null);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.mPageContext.getUniqueId());
        this.frv.setPullRefresh(this.mPullView);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamerecommend.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.goBack();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.fsC = new PbListView(this.mPageContext.getPageActivity());
        this.fsC.createView();
        this.hVF = new com.baidu.tieba.frs.gamerecommend.a.a(this.mPageContext, this.frv, this.mForumId, this.mForumName);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<q> list, boolean z) {
        if (z) {
            bwT();
        } else {
            bwS();
        }
        this.hVF.setData(list);
    }

    private void bwS() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.frv.setNextPage(this.fsC);
            }
            this.fsC.setText(this.mPageContext.getPageActivity().getResources().getString(R.string.list_no_more));
            this.fsC.endLoadData();
        }
    }

    private void bwT() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.frv.setNextPage(this.fsC);
            }
            this.fsC.showLoadingViewWithoutEmptyView();
            this.fsC.startLoadData();
        }
    }

    public void bxC() {
        this.frv.setNextPage(null);
    }

    public void completePullRefresh() {
        this.frv.completePullRefresh();
    }

    public void b(BdListView.e eVar) {
        this.frv.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bxR() {
        if (this.frv != null && j.isNetWorkAvailable()) {
            this.frv.startPullRefresh();
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public FrameLayout cfX() {
        return this.hVG;
    }

    public NavigationBar bAm() {
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
