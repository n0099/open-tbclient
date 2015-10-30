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
    private NoNetworkView aMQ;
    private PbListView aWW;
    private RelateTopicForumActivity bqs;
    private n bqt;
    private List<RelateForumItemData> bqu;
    private AdapterView.OnItemClickListener bqv;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public e(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.mListView = null;
        this.bqu = null;
        this.bqv = new f(this);
        this.bqs = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.bqu = list.subList(0, 20);
            } else {
                this.bqu = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.bqs.getLayoutMode().ad(i == 1);
        this.bqs.getLayoutMode().k(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.bqs.getPageContext(), i);
        this.aMQ.onChangeSkinType(this.bqs.getPageContext(), i);
        this.aWW.cN(i);
    }

    private void initView() {
        if (this.bqs != null) {
            this.bqs.setContentView(i.g.hot_topic_more_activity);
        }
        this.mRootView = this.bqs.findViewById(i.f.topic_list_root_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.hot_topic_list_navigationbar_title);
        this.aMQ = (NoNetworkView) this.mRootView.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRootView.findViewById(i.f.hot_topic_more_list);
        this.bqt = new n(this.bqs);
        this.aWW = new PbListView(this.bqs.getPageContext().getPageActivity());
        this.aWW.no();
        this.aWW.cM(i.c.cp_bg_line_d);
        this.mListView.setAdapter((ListAdapter) this.bqt);
        this.bqt.setData(this.bqu);
        this.mListView.setOnItemClickListener(this.bqv);
    }

    public void Mb() {
        if (this.mListView != null && this.aWW != null) {
            this.mListView.setNextPage(this.aWW);
            this.aWW.vv();
            this.aWW.setText(this.bqs.getResources().getString(i.h.list_no_more));
        }
    }

    public void Mc() {
        if (this.mListView != null && this.aWW != null) {
            this.mListView.setNextPage(null);
            this.aWW.vw();
        }
    }

    public n Rf() {
        return this.bqt;
    }
}
