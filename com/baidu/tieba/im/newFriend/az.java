package com.baidu.tieba.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.g<NewFriendsActivity> {
    private NewFriendsActivity blC;
    private BdListView blD;
    private ah blE;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private com.baidu.tbadk.core.view.ak mPullView;
    private View mRoot;

    public az(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.blC = newFriendsActivity;
        this.mRoot = this.blC.findViewById(com.baidu.tieba.w.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.blC.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.blC.getPageContext().getString(com.baidu.tieba.z.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.add_new_friend_text, this.blC);
        this.blD = (BdListView) this.blC.findViewById(com.baidu.tieba.w.new_friend_listview);
        this.blE = new ah(this.blC);
        this.blD.setAdapter((ListAdapter) this.blE);
        this.blD.setOnItemClickListener(this.blC);
        this.blD.setOnItemLongClickListener(this.blC);
        this.mPullView = new com.baidu.tbadk.core.view.ak(newFriendsActivity.getPageContext());
        this.blD.setPullRefresh(this.mPullView);
        this.mNoDataView = NoDataViewFactory.a(this.blC.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.no_new_friend_hint), null);
    }

    public void jC() {
        this.blD.jC();
    }

    public void jB() {
        this.blD.jB();
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void a(aj ajVar) {
        this.blE.a(ajVar);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        cVar.ab(i == 1);
        this.mNavigationBar.onChangeSkinType(this.blC.getPageContext(), i);
        this.mPullView.cs(i);
        cVar.h(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.blC.getPageContext(), i);
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.blD.setEmptyView(this.mNoDataView);
        this.blE.setData(list);
        this.blE.notifyDataSetChanged();
    }

    public void d(com.baidu.tieba.im.data.b bVar) {
        this.blE.d(bVar);
        this.blE.notifyDataSetChanged();
    }

    public void aB(List<com.baidu.tieba.im.data.b> list) {
        this.blE.aB(list);
        this.blE.notifyDataSetChanged();
    }

    public ah RZ() {
        return this.blE;
    }
}
