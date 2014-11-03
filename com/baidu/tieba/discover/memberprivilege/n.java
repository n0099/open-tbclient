package com.baidu.tieba.discover.memberprivilege;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f {
    private View HT;
    private NoNetworkView aoS;
    private MemberPrivilegeActivity apI;
    private j aqd;
    private NavigationBar mNavigationBar;
    private BdListView vl;

    public n(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity);
        this.apI = memberPrivilegeActivity;
        nu();
    }

    private void nu() {
        this.apI.setContentView(w.memberprivilege_activity);
        this.HT = this.apI.findViewById(v.root);
        this.mNavigationBar = (NavigationBar) this.HT.findViewById(v.navigationbar);
        this.mNavigationBar.setTitleText(y.member_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aoS = (NoNetworkView) this.HT.findViewById(v.nonetworkview);
        this.aoS.a(new o(this));
        this.vl = (BdListView) this.HT.findViewById(v.listview);
        this.aqd = new j(this.apI);
        this.vl.setAdapter((ListAdapter) this.aqd);
        this.vl.setOnItemClickListener(this.apI);
    }

    public j Ba() {
        return this.aqd;
    }

    public void onChangeSkinType(int i) {
        this.apI.getLayoutMode().L(i == 1);
        this.apI.getLayoutMode().h(this.HT);
        this.mNavigationBar.onChangeSkinType(i);
        this.aoS.onChangeSkinType(i);
    }
}
