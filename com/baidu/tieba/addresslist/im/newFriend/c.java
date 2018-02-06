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
    private ImageView Ud;
    private View aId;
    private NewFriendsActivity bVr;
    private BdListView bVs;
    private a bVt;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private k mPullView;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bVr = newFriendsActivity;
        this.aId = this.bVr.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bVr.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bVr.getPageContext().getString(d.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.Ud = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, this.bVr).findViewById(d.g.new_friend_search);
        aj.a(this.Ud, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.bVs = (BdListView) this.bVr.findViewById(d.g.new_friend_listview);
        this.bVt = new a(this.bVr);
        this.bVs.setAdapter((ListAdapter) this.bVt);
        this.bVs.setOnItemClickListener(this.bVr);
        this.bVs.setOnItemLongClickListener(this.bVr);
        this.mPullView = new k(newFriendsActivity.getPageContext());
        this.bVs.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bVr.getActivity(), this.bVs, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bVr.getPageContext().getPageActivity(), this.aId, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.bVr.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bVs.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bVs.completePullRefreshPostDelayed(2000L);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bVt.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.aQ(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bVr.getPageContext(), i);
        this.mPullView.gx(i);
        cVar.aM(this.aId);
        this.mNoDataView.onChangeSkinType(this.bVr.getPageContext(), i);
        aj.a(this.Ud, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bVs.setEmptyView(this.mNoDataView);
        this.bVt.setData(list);
        this.bVt.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bVt.a(aVar);
        this.bVt.notifyDataSetChanged();
    }

    public void ad(List<com.baidu.tieba.im.data.a> list) {
        this.bVt.ad(list);
        this.bVt.notifyDataSetChanged();
    }

    public a UZ() {
        return this.bVt;
    }
}
