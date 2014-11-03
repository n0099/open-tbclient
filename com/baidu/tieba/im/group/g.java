package com.baidu.tieba.im.group;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.f {
    private DiscoverMoreActivity aYI;
    private b aYJ;
    private NavigationBar aop;
    private View mRoot;
    private BdListView vl;

    public g(DiscoverMoreActivity discoverMoreActivity) {
        super(discoverMoreActivity);
        this.aYI = discoverMoreActivity;
        nu();
    }

    private void nu() {
        this.mRoot = View.inflate(this.aYI, w.discover_group_activity, null);
        this.aYI.setContentView(this.mRoot);
        this.aop = (NavigationBar) this.mRoot.findViewById(v.discovergroup_navigation_bar);
        this.aop.setTitleText(y.msglist_personInfo);
        this.aop.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.vl = (BdListView) this.mRoot.findViewById(v.list_view);
        this.aYJ = new b(this.aYI);
        this.vl.setAdapter((ListAdapter) this.aYJ);
    }

    public void x(ArrayList<com.baidu.tbadk.b.a.a> arrayList) {
        if (arrayList != null) {
            this.aYJ.w(arrayList);
        }
    }

    public BdListView uf() {
        return this.vl;
    }

    public b NZ() {
        return this.aYJ;
    }

    public void onChangeSkinType(int i) {
        this.aYI.getLayoutMode().L(i == 1);
        this.aYI.getLayoutMode().h(this.mRoot);
        this.aop.onChangeSkinType(i);
    }

    public void fL(int i) {
        if (this.aYJ != null) {
            this.aYJ.fL(i);
        }
    }

    public void gf(String str) {
        if (this.aYJ != null) {
            this.aYJ.gf(str);
        }
    }
}
