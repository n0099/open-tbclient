package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.hottopic.a.v;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<RelateTopicForumActivity> {
    private BdListView IY;
    private NoNetworkView aWk;
    private PbListView aXw;
    private RelateTopicForumActivity bNq;
    private v bNr;
    private List<RelateForumItemData> bNs;
    private AdapterView.OnItemClickListener bNt;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public p(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.IY = null;
        this.bNs = null;
        this.bNt = new q(this);
        this.bNq = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.bNs = list.subList(0, 20);
            } else {
                this.bNs = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.bNq.getLayoutMode().ac(i == 1);
        this.bNq.getLayoutMode().x(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.bNq.getPageContext(), i);
        this.aWk.onChangeSkinType(this.bNq.getPageContext(), i);
        this.aXw.dg(i);
    }

    private void initView() {
        if (this.bNq != null) {
            this.bNq.setContentView(t.h.hot_topic_more_activity);
        }
        this.mRootView = this.bNq.findViewById(t.g.topic_list_root_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(t.j.hot_topic_list_navigationbar_title);
        this.aWk = (NoNetworkView) this.mRootView.findViewById(t.g.view_no_network);
        this.IY = (BdListView) this.mRootView.findViewById(t.g.hot_topic_more_list);
        this.bNr = new v(this.bNq);
        this.aXw = new PbListView(this.bNq.getPageContext().getPageActivity());
        this.aXw.ni();
        this.aXw.df(t.d.cp_bg_line_d);
        this.IY.setAdapter((ListAdapter) this.bNr);
        this.bNr.setData(this.bNs);
        this.IY.setOnItemClickListener(this.bNt);
    }

    public void Qo() {
        if (this.IY != null && this.aXw != null) {
            this.IY.setNextPage(this.aXw);
            this.aXw.xc();
            this.aXw.setText(this.bNq.getResources().getString(t.j.list_no_more));
        }
    }

    public void Qp() {
        if (this.IY != null && this.aXw != null) {
            this.IY.setNextPage(null);
            this.aXw.xd();
        }
    }

    public v Yh() {
        return this.bNr;
    }
}
