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
    BdListView auZ;
    TextView bCr;
    private View bCs;
    TbPageContext<GroupAddressEditActivity> dul;
    private boolean eAM;
    private TextView eAO;
    private String[] eAP;
    m eAQ;
    NavigationBar mNavigationBar;
    View mParent;

    public View aHE() {
        return this.bCr;
    }

    public View getBackButton() {
        return this.bCs;
    }

    public l(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.dul = null;
        this.bCr = null;
        this.bCs = null;
        this.auZ = null;
        this.eAO = null;
        this.eAP = null;
        this.eAM = false;
        this.eAQ = null;
        this.eAP = strArr;
        this.eAM = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.bCs.setOnClickListener(groupAddressEditActivity);
        this.bCr.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.dul = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.auZ = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.eAQ = new m(groupAddressEditActivity, this.eAP);
        this.auZ.setAdapter((ListAdapter) this.eAQ);
        this.auZ.setOnItemClickListener(groupAddressEditActivity);
        this.eAO = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.eAP == null || this.eAP.length < 1) {
            this.auZ.setVisibility(8);
            this.eAO.setText(d.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.eAM) {
            settingTextSwitchView.rJ();
        } else {
            settingTextSwitchView.rK();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bCs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(d.j.save));
    }

    public void aHF() {
        this.eAQ.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.dul.getLayoutMode().aQ(i == 1);
        this.dul.getLayoutMode().aM(this.mParent);
        aj.p(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aj.t(this.mParent, d.C0141d.common_color_10041);
        aj.e(this.bCr, d.C0141d.cp_cont_f, 1);
    }
}
