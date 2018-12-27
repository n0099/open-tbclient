package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private View amM;
    private NewFriendsActivity bDH;
    private BdListView bDI;
    private a bDJ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bDH = newFriendsActivity;
        this.amM = this.bDH.findViewById(e.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bDH.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bDH.getPageContext().getString(e.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, this.bDH).findViewById(e.g.new_friend_search);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.bDI = (BdListView) this.bDH.findViewById(e.g.new_friend_listview);
        this.bDJ = new a(this.bDH);
        this.bDI.setAdapter((ListAdapter) this.bDJ);
        this.bDI.setOnItemClickListener(this.bDH);
        this.bDI.setOnItemLongClickListener(this.bDH);
        this.mPullView = new k(newFriendsActivity.getPageContext());
        this.bDI.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bDH.getActivity(), this.bDI, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bDH.getPageContext().getPageActivity(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bDH.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bDI.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bDI.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bDJ.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bDH.getPageContext(), i);
        this.mPullView.ey(i);
        cVar.onModeChanged(this.amM);
        this.mNoDataView.onChangeSkinType(this.bDH.getPageContext(), i);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bDI.setEmptyView(this.mNoDataView);
        this.bDJ.setData(list);
        this.bDJ.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bDJ.a(aVar);
        this.bDJ.notifyDataSetChanged();
    }

    public void ag(List<com.baidu.tieba.im.data.a> list) {
        this.bDJ.ag(list);
        this.bDJ.notifyDataSetChanged();
    }

    public a WH() {
        return this.bDJ;
    }
}
