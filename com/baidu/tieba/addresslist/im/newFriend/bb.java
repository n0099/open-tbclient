package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.g<NewFriendsActivity> {
    private NewFriendsActivity aAv;
    private BdListView aAw;
    private ai aAx;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private com.baidu.tbadk.core.view.al mPullView;
    private View mRoot;

    public bb(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.aAv = newFriendsActivity;
        this.mRoot = this.aAv.findViewById(com.baidu.tieba.q.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.aAv.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aAv.getPageContext().getString(com.baidu.tieba.t.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.add_new_friend_text, this.aAv);
        this.aAw = (BdListView) this.aAv.findViewById(com.baidu.tieba.q.new_friend_listview);
        this.aAx = new ai(this.aAv);
        this.aAw.setAdapter((ListAdapter) this.aAx);
        this.aAw.setOnItemClickListener(this.aAv);
        this.aAw.setOnItemLongClickListener(this.aAv);
        this.mPullView = new com.baidu.tbadk.core.view.al(newFriendsActivity.getPageContext());
        this.aAw.setPullRefresh(this.mPullView);
        this.mNoDataView = NoDataViewFactory.a(this.aAv.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.no_new_friend_hint), null);
    }

    public void no() {
        this.aAw.no();
    }

    public void completePullRefresh() {
        this.aAw.completePullRefresh();
    }

    public void a(com.baidu.tbadk.core.view.aj ajVar) {
        this.mPullView.a(ajVar);
    }

    public void a(ak akVar) {
        this.aAx.a(akVar);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        cVar.ab(i == 1);
        this.mNavigationBar.onChangeSkinType(this.aAv.getPageContext(), i);
        this.mPullView.cy(i);
        cVar.j(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.aAv.getPageContext(), i);
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.aAw.setEmptyView(this.mNoDataView);
        this.aAx.setData(list);
        this.aAx.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.b bVar) {
        this.aAx.a(bVar);
        this.aAx.notifyDataSetChanged();
    }

    public void x(List<com.baidu.tieba.im.data.b> list) {
        this.aAx.x(list);
        this.aAx.notifyDataSetChanged();
    }

    public ai Gb() {
        return this.aAx;
    }
}
