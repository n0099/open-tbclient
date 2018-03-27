package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private ImageView TX;
    private View aHT;
    private NewFriendsActivity bVi;
    private BdListView bVj;
    private a bVk;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private k mPullView;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bVi = newFriendsActivity;
        this.aHT = this.bVi.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bVi.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bVi.getPageContext().getString(d.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.TX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, this.bVi).findViewById(d.g.new_friend_search);
        aj.a(this.TX, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.bVj = (BdListView) this.bVi.findViewById(d.g.new_friend_listview);
        this.bVk = new a(this.bVi);
        this.bVj.setAdapter((ListAdapter) this.bVk);
        this.bVj.setOnItemClickListener(this.bVi);
        this.bVj.setOnItemLongClickListener(this.bVi);
        this.mPullView = new k(newFriendsActivity.getPageContext());
        this.bVj.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bVi.getActivity(), this.bVj, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bVi.getPageContext().getPageActivity(), this.aHT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.bVi.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bVj.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bVj.completePullRefreshPostDelayed(2000L);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bVk.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.aQ(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bVi.getPageContext(), i);
        this.mPullView.gx(i);
        cVar.aM(this.aHT);
        this.mNoDataView.onChangeSkinType(this.bVi.getPageContext(), i);
        aj.a(this.TX, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bVj.setEmptyView(this.mNoDataView);
        this.bVk.setData(list);
        this.bVk.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bVk.a(aVar);
        this.bVk.notifyDataSetChanged();
    }

    public void ad(List<com.baidu.tieba.im.data.a> list) {
        this.bVk.ad(list);
        this.bVk.notifyDataSetChanged();
    }

    public a UZ() {
        return this.bVk;
    }
}
