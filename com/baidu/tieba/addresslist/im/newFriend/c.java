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
    private NewFriendsActivity bDE;
    private BdListView bDF;
    private a bDG;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bDE = newFriendsActivity;
        this.amM = this.bDE.findViewById(e.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bDE.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bDE.getPageContext().getString(e.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, this.bDE).findViewById(e.g.new_friend_search);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.bDF = (BdListView) this.bDE.findViewById(e.g.new_friend_listview);
        this.bDG = new a(this.bDE);
        this.bDF.setAdapter((ListAdapter) this.bDG);
        this.bDF.setOnItemClickListener(this.bDE);
        this.bDF.setOnItemLongClickListener(this.bDE);
        this.mPullView = new k(newFriendsActivity.getPageContext());
        this.bDF.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bDE.getActivity(), this.bDF, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bDE.getPageContext().getPageActivity(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bDE.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bDF.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bDF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bDG.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bDE.getPageContext(), i);
        this.mPullView.ey(i);
        cVar.onModeChanged(this.amM);
        this.mNoDataView.onChangeSkinType(this.bDE.getPageContext(), i);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bDF.setEmptyView(this.mNoDataView);
        this.bDG.setData(list);
        this.bDG.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bDG.a(aVar);
        this.bDG.notifyDataSetChanged();
    }

    public void ag(List<com.baidu.tieba.im.data.a> list) {
        this.bDG.ag(list);
        this.bDG.notifyDataSetChanged();
    }

    public a WF() {
        return this.bDG;
    }
}
