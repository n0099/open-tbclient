package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.g<NewFriendsActivity> {
    private NewFriendsActivity aAw;
    private BdListView aAx;
    private ai aAy;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private com.baidu.tbadk.core.view.al mPullView;
    private View mRoot;

    public bb(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.aAw = newFriendsActivity;
        this.mRoot = this.aAw.findViewById(com.baidu.tieba.q.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.aAw.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aAw.getPageContext().getString(com.baidu.tieba.t.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.add_new_friend_text, this.aAw);
        this.aAx = (BdListView) this.aAw.findViewById(com.baidu.tieba.q.new_friend_listview);
        this.aAy = new ai(this.aAw);
        this.aAx.setAdapter((ListAdapter) this.aAy);
        this.aAx.setOnItemClickListener(this.aAw);
        this.aAx.setOnItemLongClickListener(this.aAw);
        this.mPullView = new com.baidu.tbadk.core.view.al(newFriendsActivity.getPageContext());
        this.aAx.setPullRefresh(this.mPullView);
        this.mNoDataView = NoDataViewFactory.a(this.aAw.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.no_new_friend_hint), null);
    }

    public void no() {
        this.aAx.no();
    }

    public void completePullRefresh() {
        this.aAx.completePullRefresh();
    }

    public void a(com.baidu.tbadk.core.view.aj ajVar) {
        this.mPullView.a(ajVar);
    }

    public void a(ak akVar) {
        this.aAy.a(akVar);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        cVar.ab(i == 1);
        this.mNavigationBar.onChangeSkinType(this.aAw.getPageContext(), i);
        this.mPullView.cy(i);
        cVar.j(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.aAw.getPageContext(), i);
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.aAx.setEmptyView(this.mNoDataView);
        this.aAy.setData(list);
        this.aAy.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.b bVar) {
        this.aAy.a(bVar);
        this.aAy.notifyDataSetChanged();
    }

    public void x(List<com.baidu.tieba.im.data.b> list) {
        this.aAy.x(list);
        this.aAy.notifyDataSetChanged();
    }

    public ai Gc() {
        return this.aAy;
    }
}
