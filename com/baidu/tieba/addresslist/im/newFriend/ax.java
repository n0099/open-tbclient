package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.addresslist.im.newFriend.ai;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.base.f<NewFriendsActivity> {
    private NewFriendsActivity aJa;
    private BdListView aJb;
    private ai aJc;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private com.baidu.tbadk.core.view.s mPullView;
    private View mRoot;

    public ax(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.aJa = newFriendsActivity;
        this.mRoot = this.aJa.findViewById(n.f.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.aJa.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aJa.getPageContext().getString(n.i.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.add_new_friend_text, this.aJa);
        this.aJb = (BdListView) this.aJa.findViewById(n.f.new_friend_listview);
        this.aJc = new ai(this.aJa);
        this.aJb.setAdapter((ListAdapter) this.aJc);
        this.aJb.setOnItemClickListener(this.aJa);
        this.aJb.setOnItemLongClickListener(this.aJa);
        this.mPullView = new com.baidu.tbadk.core.view.s(newFriendsActivity.getPageContext());
        this.aJb.setPullRefresh(this.mPullView);
        this.mNoDataView = NoDataViewFactory.a(this.aJa.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cS(n.i.no_new_friend_hint), null);
    }

    public void nD() {
        this.aJb.nD();
    }

    public void completePullRefresh() {
        this.aJb.completePullRefresh();
    }

    public void a(q.a aVar) {
        this.mPullView.a(aVar);
    }

    public void a(ai.b bVar) {
        this.aJc.a(bVar);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        cVar.af(i == 1);
        this.mNavigationBar.onChangeSkinType(this.aJa.getPageContext(), i);
        this.mPullView.cV(i);
        cVar.k(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.aJa.getPageContext(), i);
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.aJb.setEmptyView(this.mNoDataView);
        this.aJc.setData(list);
        this.aJc.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.b bVar) {
        this.aJc.a(bVar);
        this.aJc.notifyDataSetChanged();
    }

    public void x(List<com.baidu.tieba.im.data.b> list) {
        this.aJc.x(list);
        this.aJc.notifyDataSetChanged();
    }

    public ai Hw() {
        return this.aJc;
    }
}
