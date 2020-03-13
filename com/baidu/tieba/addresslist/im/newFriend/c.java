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
    private NewFriendsActivity ebU;
    private BdListView ebV;
    private a ebW;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.ebU = newFriendsActivity;
        this.mRoot = this.ebU.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.ebU.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ebU.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.ebU).findViewById(R.id.new_friend_search);
        SvgManager.aGC().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ebV = (BdListView) this.ebU.findViewById(R.id.new_friend_listview);
        this.ebW = new a(this.ebU);
        this.ebV.setAdapter((ListAdapter) this.ebW);
        this.ebV.setOnItemClickListener(this.ebU);
        this.ebV.setOnItemLongClickListener(this.ebU);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.ebV.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.ebU.getActivity(), this.ebV, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.ebU.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.ebU.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.ebV.startPullRefresh();
    }

    public void completePullRefresh() {
        this.ebV.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.ebW.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.ebU.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.ebU.getPageContext(), i);
        SvgManager.aGC().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.ebV.setEmptyView(this.mNoDataView);
        this.ebW.setData(list);
        this.ebW.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.ebW.a(aVar);
        this.ebW.notifyDataSetChanged();
    }

    public void aZ(List<com.baidu.tieba.im.data.a> list) {
        this.ebW.aZ(list);
        this.ebW.notifyDataSetChanged();
    }

    public a aYT() {
        return this.ebW;
    }
}
