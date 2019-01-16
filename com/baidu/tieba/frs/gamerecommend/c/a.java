package com.baidu.tieba.frs.gamerecommend.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private PbListView bPm;
    private com.baidu.tieba.frs.gamerecommend.a.a dYU;
    private FrameLayout dYV;
    private String mForumId;
    private String mForumName;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private k mPullView;
    private View mRootView;

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.mForumId = str;
        this.mForumName = str2;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.frs_game_recommend_layout, (ViewGroup) null);
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        this.dYV = (FrameLayout) this.mRootView.findViewById(e.g.game_recom_container);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.game_recom_listview);
        this.mListView.setDivider(null);
        this.mPullView = new k(this.mPageContext);
        this.mPullView.setTag(this.mPageContext.getUniqueId());
        this.mListView.setPullRefresh(this.mPullView);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamerecommend.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.goBack();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bPm = new PbListView(this.mPageContext.getPageActivity());
        this.bPm.oH();
        this.dYU = new com.baidu.tieba.frs.gamerecommend.a.a(this.mPageContext, this.mListView, this.mForumId, this.mForumName);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(List<h> list, boolean z) {
        if (z) {
            aaO();
        } else {
            aaN();
        }
        this.dYU.setData(list);
    }

    private void aaN() {
        if (this.bPm != null) {
            if (this.bPm.getView().getParent() == null) {
                this.mListView.setNextPage(this.bPm);
            }
            this.bPm.setText(this.mPageContext.getPageActivity().getResources().getString(e.j.list_no_more));
            this.bPm.Fq();
        }
    }

    private void aaO() {
        if (this.bPm != null) {
            if (this.bPm.getView().getParent() == null) {
                this.mListView.setNextPage(this.bPm);
            }
            this.bPm.Fu();
            this.bPm.Fp();
        }
    }

    public void aaY() {
        this.mListView.setNextPage(null);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void abv() {
        if (this.mListView != null && com.baidu.adp.lib.util.j.kV()) {
            this.mListView.startPullRefresh();
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public FrameLayout aGe() {
        return this.dYV;
    }

    public NavigationBar act() {
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
