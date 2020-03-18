package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity eck;
    private BdListView ecl;
    private a ecm;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.eck = newFriendsActivity;
        this.mRoot = this.eck.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.eck.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eck.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.eck).findViewById(R.id.new_friend_search);
        SvgManager.aGG().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ecl = (BdListView) this.eck.findViewById(R.id.new_friend_listview);
        this.ecm = new a(this.eck);
        this.ecl.setAdapter((ListAdapter) this.ecm);
        this.ecl.setOnItemClickListener(this.eck);
        this.ecl.setOnItemLongClickListener(this.eck);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.ecl.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.eck.getActivity(), this.ecl, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.eck.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.eck.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.ecl.startPullRefresh();
    }

    public void completePullRefresh() {
        this.ecl.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.ecm.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.eck.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.eck.getPageContext(), i);
        SvgManager.aGG().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.ecl.setEmptyView(this.mNoDataView);
        this.ecm.setData(list);
        this.ecm.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.ecm.a(aVar);
        this.ecm.notifyDataSetChanged();
    }

    public void aZ(List<com.baidu.tieba.im.data.a> list) {
        this.ecm.aZ(list);
        this.ecm.notifyDataSetChanged();
    }

    public a aYX() {
        return this.ecm;
    }
}
