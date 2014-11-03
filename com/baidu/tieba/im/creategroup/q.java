package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.f {
    private View aTX;
    r aUA;
    private boolean aUu;
    GroupAddressEditActivity aUw;
    TextView aUx;
    private TextView aUy;
    private String[] aUz;
    View agI;
    NavigationBar mNavigationBar;
    BdListView vl;

    public View LZ() {
        return this.aUx;
    }

    public View Ma() {
        return this.aTX;
    }

    public q(GroupAddressEditActivity groupAddressEditActivity, String[] strArr, boolean z) {
        super(groupAddressEditActivity);
        this.mNavigationBar = null;
        this.agI = null;
        this.aUw = null;
        this.aUx = null;
        this.aTX = null;
        this.vl = null;
        this.aUy = null;
        this.aUz = null;
        this.aUu = false;
        this.aUA = null;
        this.aUz = strArr;
        this.aUu = z;
        b(groupAddressEditActivity);
        a(groupAddressEditActivity);
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.aTX.setOnClickListener(groupAddressEditActivity);
        this.aUx.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.aUw = groupAddressEditActivity;
        groupAddressEditActivity.setContentView(com.baidu.tieba.w.group_address_activity);
        this.agI = groupAddressEditActivity.findViewById(com.baidu.tieba.v.parent);
        this.vl = (BdListView) groupAddressEditActivity.findViewById(com.baidu.tieba.v.lv_address);
        this.aUA = new r(this.aUw, this.aUz);
        this.vl.setAdapter((ListAdapter) this.aUA);
        this.vl.setOnItemClickListener(this.aUw);
        this.aUy = (TextView) groupAddressEditActivity.findViewById(com.baidu.tieba.v.address_title_poslist);
        if (this.aUz == null || this.aUz.length < 1) {
            this.vl.setVisibility(8);
            this.aUy.setText(com.baidu.tieba.y.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(com.baidu.tieba.v.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(this.aUw);
        if (this.aUu) {
            settingTextSwitchView.gN();
        } else {
            settingTextSwitchView.gO();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(com.baidu.tieba.y.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aTX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(com.baidu.tieba.y.save));
    }

    public void Mb() {
        this.aUA.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.aUw.getLayoutMode().L(i == 1);
        this.aUw.getLayoutMode().h(this.agI);
        aw.e(this.agI, i);
        this.mNavigationBar.onChangeSkinType(i);
        aw.i(this.agI, com.baidu.tieba.s.group_info_bg);
    }
}
