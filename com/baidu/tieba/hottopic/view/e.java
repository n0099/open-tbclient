package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.hottopic.a.n;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f<RelateTopicForumActivity> {
    private NoNetworkView aMY;
    private PbListView aXe;
    private RelateTopicForumActivity bqW;
    private n bqX;
    private List<RelateForumItemData> bqY;
    private AdapterView.OnItemClickListener bqZ;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public e(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.mListView = null;
        this.bqY = null;
        this.bqZ = new f(this);
        this.bqW = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.bqY = list.subList(0, 20);
            } else {
                this.bqY = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.bqW.getLayoutMode().ad(i == 1);
        this.bqW.getLayoutMode().k(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.bqW.getPageContext(), i);
        this.aMY.onChangeSkinType(this.bqW.getPageContext(), i);
        this.aXe.cN(i);
    }

    private void initView() {
        if (this.bqW != null) {
            this.bqW.setContentView(i.g.hot_topic_more_activity);
        }
        this.mRootView = this.bqW.findViewById(i.f.topic_list_root_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.hot_topic_list_navigationbar_title);
        this.aMY = (NoNetworkView) this.mRootView.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRootView.findViewById(i.f.hot_topic_more_list);
        this.bqX = new n(this.bqW);
        this.aXe = new PbListView(this.bqW.getPageContext().getPageActivity());
        this.aXe.np();
        this.aXe.cM(i.c.cp_bg_line_d);
        this.mListView.setAdapter((ListAdapter) this.bqX);
        this.bqX.setData(this.bqY);
        this.mListView.setOnItemClickListener(this.bqZ);
    }

    public void Mr() {
        if (this.mListView != null && this.aXe != null) {
            this.mListView.setNextPage(this.aXe);
            this.aXe.vz();
            this.aXe.setText(this.bqW.getResources().getString(i.h.list_no_more));
        }
    }

    public void Ms() {
        if (this.mListView != null && this.aXe != null) {
            this.mListView.setNextPage(null);
            this.aXe.vA();
        }
    }

    public n RB() {
        return this.bqX;
    }
}
