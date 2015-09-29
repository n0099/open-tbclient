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
    private NoNetworkView aMF;
    private PbListView aWL;
    private RelateTopicForumActivity bqh;
    private n bqi;
    private List<RelateForumItemData> bqj;
    private AdapterView.OnItemClickListener bqk;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public e(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.mListView = null;
        this.bqj = null;
        this.bqk = new f(this);
        this.bqh = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.bqj = list.subList(0, 20);
            } else {
                this.bqj = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.bqh.getLayoutMode().ad(i == 1);
        this.bqh.getLayoutMode().k(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.bqh.getPageContext(), i);
        this.aMF.onChangeSkinType(this.bqh.getPageContext(), i);
        this.aWL.cN(i);
    }

    private void initView() {
        if (this.bqh != null) {
            this.bqh.setContentView(i.g.hot_topic_more_activity);
        }
        this.mRootView = this.bqh.findViewById(i.f.topic_list_root_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.hot_topic_list_navigationbar_title);
        this.aMF = (NoNetworkView) this.mRootView.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRootView.findViewById(i.f.hot_topic_more_list);
        this.bqi = new n(this.bqh);
        this.aWL = new PbListView(this.bqh.getPageContext().getPageActivity());
        this.aWL.no();
        this.aWL.cM(i.c.cp_bg_line_d);
        this.mListView.setAdapter((ListAdapter) this.bqi);
        this.bqi.setData(this.bqj);
        this.mListView.setOnItemClickListener(this.bqk);
    }

    public void Mf() {
        if (this.mListView != null && this.aWL != null) {
            this.mListView.setNextPage(this.aWL);
            this.aWL.vy();
            this.aWL.setText(this.bqh.getResources().getString(i.h.list_no_more));
        }
    }

    public void Mg() {
        if (this.mListView != null && this.aWL != null) {
            this.mListView.setNextPage(null);
            this.aWL.vz();
        }
    }

    public n Rj() {
        return this.bqi;
    }
}
