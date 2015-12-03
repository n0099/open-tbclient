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
    private NoNetworkView aQl;
    private PbListView aRt;
    private RelateTopicForumActivity bGa;
    private u bGb;
    private List<RelateForumItemData> bGc;
    private AdapterView.OnItemClickListener bGd;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public h(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.mListView = null;
        this.bGc = null;
        this.bGd = new i(this);
        this.bGa = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.bGc = list.subList(0, 20);
            } else {
                this.bGc = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.bGa.getLayoutMode().af(i == 1);
        this.bGa.getLayoutMode().k(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.bGa.getPageContext(), i);
        this.aQl.onChangeSkinType(this.bGa.getPageContext(), i);
        this.aRt.cV(i);
    }

    private void initView() {
        if (this.bGa != null) {
            this.bGa.setContentView(n.g.hot_topic_more_activity);
        }
        this.mRootView = this.bGa.findViewById(n.f.topic_list_root_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.hot_topic_list_navigationbar_title);
        this.aQl = (NoNetworkView) this.mRootView.findViewById(n.f.view_no_network);
        this.mListView = (BdListView) this.mRootView.findViewById(n.f.hot_topic_more_list);
        this.bGb = new u(this.bGa);
        this.aRt = new PbListView(this.bGa.getPageContext().getPageActivity());
        this.aRt.nv();
        this.aRt.cU(n.c.cp_bg_line_d);
        this.mListView.setAdapter((ListAdapter) this.bGb);
        this.bGb.setData(this.bGc);
        this.mListView.setOnItemClickListener(this.bGd);
    }

    public void NS() {
        if (this.mListView != null && this.aRt != null) {
            this.mListView.setNextPage(this.aRt);
            this.aRt.wf();
            this.aRt.setText(this.bGa.getResources().getString(n.i.list_no_more));
        }
    }

    public void NT() {
        if (this.mListView != null && this.aRt != null) {
            this.mListView.setNextPage(null);
            this.aRt.wg();
        }
    }

    public u UH() {
        return this.bGb;
    }
}
