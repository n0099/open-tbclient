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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity djK;
    private BdListView djL;
    private a djM;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.djK = newFriendsActivity;
        this.mRoot = this.djK.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.djK.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.djK.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.djK).findViewById(R.id.new_friend_search);
        SvgManager.amL().a(this.mSearchButton, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.djL = (BdListView) this.djK.findViewById(R.id.new_friend_listview);
        this.djM = new a(this.djK);
        this.djL.setAdapter((ListAdapter) this.djM);
        this.djL.setOnItemClickListener(this.djK);
        this.djL.setOnItemLongClickListener(this.djK);
        this.mPullView = new i(newFriendsActivity.getPageContext());
        this.djL.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.djK.getActivity(), this.djL, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.djK.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.djK.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iK(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.djL.startPullRefresh();
    }

    public void completePullRefresh() {
        this.djL.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.djM.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.djK.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.djK.getPageContext(), i);
        SvgManager.amL().a(this.mSearchButton, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.djL.setEmptyView(this.mNoDataView);
        this.djM.setData(list);
        this.djM.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.djM.a(aVar);
        this.djM.notifyDataSetChanged();
    }

    public void aT(List<com.baidu.tieba.im.data.a> list) {
        this.djM.aT(list);
        this.djM.notifyDataSetChanged();
    }

    public a aEo() {
        return this.djM;
    }
}
