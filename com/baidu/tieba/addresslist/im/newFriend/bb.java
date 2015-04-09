package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.g<NewFriendsActivity> {
    private NewFriendsActivity ayK;
    private BdListView ayL;
    private ai ayM;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private com.baidu.tbadk.core.view.ag mPullView;
    private View mRoot;

    public bb(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.ayK = newFriendsActivity;
        this.mRoot = this.ayK.findViewById(com.baidu.tieba.v.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.ayK.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ayK.getPageContext().getString(com.baidu.tieba.y.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.add_new_friend_text, this.ayK);
        this.ayL = (BdListView) this.ayK.findViewById(com.baidu.tieba.v.new_friend_listview);
        this.ayM = new ai(this.ayK);
        this.ayL.setAdapter((ListAdapter) this.ayM);
        this.ayL.setOnItemClickListener(this.ayK);
        this.ayL.setOnItemLongClickListener(this.ayK);
        this.mPullView = new com.baidu.tbadk.core.view.ag(newFriendsActivity.getPageContext());
        this.ayL.setPullRefresh(this.mPullView);
        this.mNoDataView = NoDataViewFactory.a(this.ayK.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.no_new_friend_hint), null);
    }

    public void mX() {
        this.ayL.mX();
    }

    public void mW() {
        this.ayL.mW();
    }

    public void a(com.baidu.tbadk.core.view.ae aeVar) {
        this.mPullView.a(aeVar);
    }

    public void a(ak akVar) {
        this.ayM.a(akVar);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        cVar.X(i == 1);
        this.mNavigationBar.onChangeSkinType(this.ayK.getPageContext(), i);
        this.mPullView.ct(i);
        cVar.h(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.ayK.getPageContext(), i);
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.ayL.setEmptyView(this.mNoDataView);
        this.ayM.setData(list);
        this.ayM.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.b bVar) {
        this.ayM.a(bVar);
        this.ayM.notifyDataSetChanged();
    }

    public void w(List<com.baidu.tieba.im.data.b> list) {
        this.ayM.w(list);
        this.ayM.notifyDataSetChanged();
    }

    public ai Fi() {
        return this.ayM;
    }
}
