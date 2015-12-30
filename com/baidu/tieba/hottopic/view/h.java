package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.hottopic.a.u;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f<RelateTopicForumActivity> {
    private NoNetworkView aUd;
    private PbListView aVj;
    private RelateTopicForumActivity bJH;
    private u bJI;
    private List<RelateForumItemData> bJJ;
    private AdapterView.OnItemClickListener bJK;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public h(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.mListView = null;
        this.bJJ = null;
        this.bJK = new i(this);
        this.bJH = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.bJJ = list.subList(0, 20);
            } else {
                this.bJJ = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.bJH.getLayoutMode().ac(i == 1);
        this.bJH.getLayoutMode().k(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.bJH.getPageContext(), i);
        this.aUd.onChangeSkinType(this.bJH.getPageContext(), i);
        this.aVj.cP(i);
    }

    private void initView() {
        if (this.bJH != null) {
            this.bJH.setContentView(n.h.hot_topic_more_activity);
        }
        this.mRootView = this.bJH.findViewById(n.g.topic_list_root_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.hot_topic_list_navigationbar_title);
        this.aUd = (NoNetworkView) this.mRootView.findViewById(n.g.view_no_network);
        this.mListView = (BdListView) this.mRootView.findViewById(n.g.hot_topic_more_list);
        this.bJI = new u(this.bJH);
        this.aVj = new PbListView(this.bJH.getPageContext().getPageActivity());
        this.aVj.mT();
        this.aVj.cO(n.d.cp_bg_line_d);
        this.mListView.setAdapter((ListAdapter) this.bJI);
        this.bJI.setData(this.bJJ);
        this.mListView.setOnItemClickListener(this.bJK);
    }

    public void Ol() {
        if (this.mListView != null && this.aVj != null) {
            this.mListView.setNextPage(this.aVj);
            this.aVj.vP();
            this.aVj.setText(this.bJH.getResources().getString(n.j.list_no_more));
        }
    }

    public void Om() {
        if (this.mListView != null && this.aVj != null) {
            this.mListView.setNextPage(null);
            this.aVj.vQ();
        }
    }

    public u VN() {
        return this.bJI;
    }
}
