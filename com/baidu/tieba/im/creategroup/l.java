package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class l extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView auY;
    TextView bCo;
    private View bCp;
    TbPageContext<GroupAddressEditActivity> dui;
    m eAA;
    private boolean eAw;
    private TextView eAy;
    private String[] eAz;
    NavigationBar mNavigationBar;
    View mParent;

    public View aHD() {
        return this.bCo;
    }

    public View getBackButton() {
        return this.bCp;
    }

    public l(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.dui = null;
        this.bCo = null;
        this.bCp = null;
        this.auY = null;
        this.eAy = null;
        this.eAz = null;
        this.eAw = false;
        this.eAA = null;
        this.eAz = strArr;
        this.eAw = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.bCp.setOnClickListener(groupAddressEditActivity);
        this.bCo.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.dui = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.auY = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.eAA = new m(groupAddressEditActivity, this.eAz);
        this.auY.setAdapter((ListAdapter) this.eAA);
        this.auY.setOnItemClickListener(groupAddressEditActivity);
        this.eAy = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.eAz == null || this.eAz.length < 1) {
            this.auY.setVisibility(8);
            this.eAy.setText(d.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.eAw) {
            settingTextSwitchView.rJ();
        } else {
            settingTextSwitchView.rK();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bCp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(d.j.save));
    }

    public void aHE() {
        this.eAA.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.dui.getLayoutMode().aQ(i == 1);
        this.dui.getLayoutMode().aM(this.mParent);
        aj.p(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aj.t(this.mParent, d.C0141d.common_color_10041);
        aj.e(this.bCo, d.C0141d.cp_cont_f, 1);
    }
}
