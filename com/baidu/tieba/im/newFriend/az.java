package com.baidu.tieba.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.f {
    private com.baidu.tbadk.core.view.y Yc;
    private com.baidu.tbadk.core.view.o ahO;
    private BaseActivity bha;
    private BdListView bhb;
    private ah bhc;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public az(BaseActivity baseActivity) {
        super(baseActivity);
        this.bha = baseActivity;
        this.mRoot = this.bha.findViewById(com.baidu.tieba.v.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bha.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bha.getString(com.baidu.tieba.y.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.add_new_friend_text, this.bha);
        this.bhb = (BdListView) this.bha.findViewById(com.baidu.tieba.v.new_friend_listview);
        this.bhc = new ah(this.bha);
        this.bhb.setAdapter((ListAdapter) this.bhc);
        this.bhb.setOnItemClickListener(this.bha);
        this.bhb.setOnItemLongClickListener(this.bha);
        this.Yc = new com.baidu.tbadk.core.view.y(baseActivity);
        this.bhb.setPullRefresh(this.Yc);
        this.ahO = NoDataViewFactory.a(this.bha, this.mRoot, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.no_new_friend_hint), null);
    }

    public void hO() {
        this.bhb.hO();
    }

    public void hN() {
        this.bhb.hN();
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }

    public void a(aj ajVar) {
        this.bhc.a(ajVar);
    }

    public void a(com.baidu.tbadk.core.d dVar, int i) {
        dVar.L(i == 1);
        this.mNavigationBar.onChangeSkinType(i);
        this.Yc.bM(i);
        dVar.h(this.mRoot);
        this.ahO.onChangeSkinType(i);
    }

    public void setData(List<com.baidu.tieba.im.data.e> list) {
        this.bhb.setEmptyView(this.ahO);
        this.bhc.setData(list);
        this.bhc.notifyDataSetChanged();
    }

    public void c(com.baidu.tieba.im.data.e eVar) {
        this.bhc.c(eVar);
        this.bhc.notifyDataSetChanged();
    }

    public void ab(List<com.baidu.tieba.im.data.e> list) {
        this.bhc.ab(list);
        this.bhc.notifyDataSetChanged();
    }

    public ah Rl() {
        return this.bhc;
    }
}
