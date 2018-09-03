package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private View aaW;
    private NewFriendsActivity bpE;
    private BdListView bpF;
    private a bpG;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bpE = newFriendsActivity;
        this.aaW = this.bpE.findViewById(f.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bpE.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bpE.getPageContext().getString(f.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.add_new_friend_text, this.bpE).findViewById(f.g.new_friend_search);
        am.a(this.mSearchButton, f.C0146f.icon_search_bg_s, f.C0146f.icon_search_bg);
        this.bpF = (BdListView) this.bpE.findViewById(f.g.new_friend_listview);
        this.bpG = new a(this.bpE);
        this.bpF.setAdapter((ListAdapter) this.bpG);
        this.bpF.setOnItemClickListener(this.bpE);
        this.bpF.setOnItemLongClickListener(this.bpE);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.bpF.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bpE.getActivity(), this.bpF, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bpE.getPageContext().getPageActivity(), this.aaW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.bpE.getActivity(), f.e.ds320)), NoDataViewFactory.d.dt(f.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bpF.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bpF.completePullRefreshPostDelayed(2000L);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bpG.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bpE.getPageContext(), i);
        this.mPullView.dB(i);
        cVar.onModeChanged(this.aaW);
        this.mNoDataView.onChangeSkinType(this.bpE.getPageContext(), i);
        am.a(this.mSearchButton, f.C0146f.icon_search_bg_s, f.C0146f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bpF.setEmptyView(this.mNoDataView);
        this.bpG.setData(list);
        this.bpG.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bpG.a(aVar);
        this.bpG.notifyDataSetChanged();
    }

    public void X(List<com.baidu.tieba.im.data.a> list) {
        this.bpG.X(list);
        this.bpG.notifyDataSetChanged();
    }

    public a RG() {
        return this.bpG;
    }
}
