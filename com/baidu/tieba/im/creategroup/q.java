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
    private View aTJ;
    private boolean aUg;
    GroupAddressEditActivity aUi;
    TextView aUj;
    private TextView aUk;
    private String[] aUl;
    r aUm;
    View agA;
    NavigationBar mNavigationBar;
    BdListView vl;

    public View LV() {
        return this.aUj;
    }

    public View LW() {
        return this.aTJ;
    }

    public q(GroupAddressEditActivity groupAddressEditActivity, String[] strArr, boolean z) {
        super(groupAddressEditActivity);
        this.mNavigationBar = null;
        this.agA = null;
        this.aUi = null;
        this.aUj = null;
        this.aTJ = null;
        this.vl = null;
        this.aUk = null;
        this.aUl = null;
        this.aUg = false;
        this.aUm = null;
        this.aUl = strArr;
        this.aUg = z;
        b(groupAddressEditActivity);
        a(groupAddressEditActivity);
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.aTJ.setOnClickListener(groupAddressEditActivity);
        this.aUj.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.aUi = groupAddressEditActivity;
        groupAddressEditActivity.setContentView(com.baidu.tieba.w.group_address_activity);
        this.agA = groupAddressEditActivity.findViewById(com.baidu.tieba.v.parent);
        this.vl = (BdListView) groupAddressEditActivity.findViewById(com.baidu.tieba.v.lv_address);
        this.aUm = new r(this.aUi, this.aUl);
        this.vl.setAdapter((ListAdapter) this.aUm);
        this.vl.setOnItemClickListener(this.aUi);
        this.aUk = (TextView) groupAddressEditActivity.findViewById(com.baidu.tieba.v.address_title_poslist);
        if (this.aUl == null || this.aUl.length < 1) {
            this.vl.setVisibility(8);
            this.aUk.setText(com.baidu.tieba.y.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(com.baidu.tieba.v.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(this.aUi);
        if (this.aUg) {
            settingTextSwitchView.gN();
        } else {
            settingTextSwitchView.gO();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(com.baidu.tieba.y.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aTJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(com.baidu.tieba.y.save));
    }

    public void LX() {
        this.aUm.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.aUi.getLayoutMode().L(i == 1);
        this.aUi.getLayoutMode().h(this.agA);
        aw.e(this.agA, i);
        this.mNavigationBar.onChangeSkinType(i);
        aw.i(this.agA, com.baidu.tieba.s.group_info_bg);
    }
}
