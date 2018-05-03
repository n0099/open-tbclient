package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView FL;
    TextView aMR;
    private View aMS;
    TbPageContext<GroupAddressEditActivity> cMX;
    private boolean dVn;
    private TextView dVp;
    private String[] dVq;
    l dVr;
    NavigationBar mNavigationBar;
    View mParent;

    public View aCD() {
        return this.aMR;
    }

    public View getBackButton() {
        return this.aMS;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.cMX = null;
        this.aMR = null;
        this.aMS = null;
        this.FL = null;
        this.dVp = null;
        this.dVq = null;
        this.dVn = false;
        this.dVr = null;
        this.dVq = strArr;
        this.dVn = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.aMS.setOnClickListener(groupAddressEditActivity);
        this.aMR.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.cMX = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.i.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.FL = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.dVr = new l(groupAddressEditActivity, this.dVq);
        this.FL.setAdapter((ListAdapter) this.dVr);
        this.FL.setOnItemClickListener(groupAddressEditActivity);
        this.dVp = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.dVq == null || this.dVq.length < 1) {
            this.FL.setVisibility(8);
            this.dVp.setText(d.k.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.dVn) {
            settingTextSwitchView.jO();
        } else {
            settingTextSwitchView.jP();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(d.k.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aMS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(d.k.save));
    }

    public void aCE() {
        this.dVr.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.cMX.getLayoutMode().setNightMode(i == 1);
        this.cMX.getLayoutMode().u(this.mParent);
        ak.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ak.j(this.mParent, d.C0126d.common_color_10041);
        ak.c(this.aMR, d.C0126d.cp_cont_f, 1);
    }
}
