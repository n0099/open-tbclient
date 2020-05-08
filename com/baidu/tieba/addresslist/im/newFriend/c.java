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
    private NewFriendsActivity eCc;
    private BdListView eCd;
    private a eCe;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.eCc = newFriendsActivity;
        this.mRoot = this.eCc.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.eCc.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eCc.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.eCc).findViewById(R.id.new_friend_search);
        SvgManager.aOR().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.eCd = (BdListView) this.eCc.findViewById(R.id.new_friend_listview);
        this.eCe = new a(this.eCc);
        this.eCd.setAdapter((ListAdapter) this.eCe);
        this.eCd.setOnItemClickListener(this.eCc);
        this.eCd.setOnItemLongClickListener(this.eCc);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.eCd.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.eCc.getActivity(), this.eCd, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.eCc.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.eCc.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lr(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.eCd.startPullRefresh();
    }

    public void completePullRefresh() {
        this.eCd.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.eCe.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.eCc.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.eCc.getPageContext(), i);
        SvgManager.aOR().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.eCd.setEmptyView(this.mNoDataView);
        this.eCe.setData(list);
        this.eCe.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.eCe.a(aVar);
        this.eCe.notifyDataSetChanged();
    }

    public void bj(List<com.baidu.tieba.im.data.a> list) {
        this.eCe.bj(list);
        this.eCe.notifyDataSetChanged();
    }

    public a bgZ() {
        return this.eCe;
    }
}
