package com.baidu.tieba.im.nearbygroups;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.PinnedHeaderListView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.view.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.f {
    private y Yc;
    private View agA;
    private NoNetworkView aty;
    private NearbyGroupsActivity bgd;
    private TextView bgs;
    private h bgt;
    private PinnedHeaderListView bgu;
    private s bgv;
    private NavigationBar mNavigationBar;

    public m(NearbyGroupsActivity nearbyGroupsActivity) {
        super(nearbyGroupsActivity);
        this.mNavigationBar = null;
        this.bgd = null;
        this.agA = null;
        this.bgs = null;
        this.bgt = null;
        this.bgu = null;
        this.Yc = null;
        this.aty = null;
        this.bgv = null;
        this.bgd = nearbyGroupsActivity;
        init();
    }

    private void init() {
        this.bgt = new h(this.bgd);
        this.bgv = new s(this.bgd);
        this.bgd.setContentView(w.nearby_group_activity);
        this.agA = this.bgd.findViewById(v.parent);
        this.bgu = (PinnedHeaderListView) this.bgd.findViewById(v.nearby_list);
        this.mNavigationBar = (NavigationBar) this.bgd.findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bgd.getResources().getString(com.baidu.tieba.y.nearby_group_title));
        this.bgs = this.mNavigationBar.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bgd);
        this.aty = (NoNetworkView) this.bgd.findViewById(v.view_no_network);
        this.Yc = new y(this.bgd);
        this.bgu.setPullRefresh(this.Yc);
        this.bgu.setAdapter((ListAdapter) this.bgt);
        this.bgu.setNextPage(this.bgv);
    }

    public PinnedHeaderListView Ra() {
        return this.bgu;
    }

    public void Ep() {
        this.bgv.Ep();
    }

    public void DG() {
        this.bgv.DG();
    }

    public void DF() {
        this.bgv.DF();
    }

    public void a(aa aaVar) {
        this.bgu.setOnSrollToBottomListener(aaVar);
    }

    public void h(View.OnClickListener onClickListener) {
        this.bgv.setOnClickListener(onClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }

    public void NP() {
        this.bgu.hO();
    }

    public void Rb() {
        this.bgu.hN();
    }

    public int Rc() {
        return this.bgs.getId();
    }

    public void dq(boolean z) {
        this.bgt.dq(z);
        Rd();
    }

    public void dr(boolean z) {
        this.bgt.dr(z);
        Rd();
    }

    public NearbyGroupsData QY() {
        return this.bgt.QY();
    }

    public void a(NearbyGroupsData nearbyGroupsData) {
        this.bgt.a(nearbyGroupsData);
        Rd();
    }

    private void Rd() {
        NearbyGroupsData QY = this.bgt.QY();
        if (QY == null || QY.size() == 0) {
            this.bgv.hide();
        } else {
            this.bgv.Ba();
        }
    }

    public void onChangeSkinType(int i) {
        this.bgd.getLayoutMode().L(i == 1);
        aw.d(this.agA, i);
        this.Yc.bM(i);
        this.mNavigationBar.onChangeSkinType(i);
        this.aty.onChangeSkinType(i);
        this.bgv.cu(i);
        this.bgd.getLayoutMode().h(this.agA);
    }
}
