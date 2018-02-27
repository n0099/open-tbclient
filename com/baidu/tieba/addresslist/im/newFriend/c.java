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
    private View aHS;
    private NewFriendsActivity bVf;
    private BdListView bVg;
    private a bVh;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private k mPullView;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bVf = newFriendsActivity;
        this.aHS = this.bVf.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bVf.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bVf.getPageContext().getString(d.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.TX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, this.bVf).findViewById(d.g.new_friend_search);
        aj.a(this.TX, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.bVg = (BdListView) this.bVf.findViewById(d.g.new_friend_listview);
        this.bVh = new a(this.bVf);
        this.bVg.setAdapter((ListAdapter) this.bVh);
        this.bVg.setOnItemClickListener(this.bVf);
        this.bVg.setOnItemLongClickListener(this.bVf);
        this.mPullView = new k(newFriendsActivity.getPageContext());
        this.bVg.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bVf.getActivity(), this.bVg, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bVf.getPageContext().getPageActivity(), this.aHS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.bVf.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bVg.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bVg.completePullRefreshPostDelayed(2000L);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bVh.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.aQ(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bVf.getPageContext(), i);
        this.mPullView.gx(i);
        cVar.aM(this.aHS);
        this.mNoDataView.onChangeSkinType(this.bVf.getPageContext(), i);
        aj.a(this.TX, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bVg.setEmptyView(this.mNoDataView);
        this.bVh.setData(list);
        this.bVh.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bVh.a(aVar);
        this.bVh.notifyDataSetChanged();
    }

    public void ad(List<com.baidu.tieba.im.data.a> list) {
        this.bVh.ad(list);
        this.bVh.notifyDataSetChanged();
    }

    public a UY() {
        return this.bVh;
    }
}
