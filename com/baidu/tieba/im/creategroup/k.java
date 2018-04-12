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
    TbPageContext<GroupAddressEditActivity> cNa;
    private boolean dVq;
    private TextView dVs;
    private String[] dVt;
    l dVu;
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
        this.cNa = null;
        this.aMR = null;
        this.aMS = null;
        this.FL = null;
        this.dVs = null;
        this.dVt = null;
        this.dVq = false;
        this.dVu = null;
        this.dVt = strArr;
        this.dVq = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.aMS.setOnClickListener(groupAddressEditActivity);
        this.aMR.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.cNa = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.i.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.FL = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.dVu = new l(groupAddressEditActivity, this.dVt);
        this.FL.setAdapter((ListAdapter) this.dVu);
        this.FL.setOnItemClickListener(groupAddressEditActivity);
        this.dVs = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.dVt == null || this.dVt.length < 1) {
            this.FL.setVisibility(8);
            this.dVs.setText(d.k.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.dVq) {
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
        this.dVu.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.cNa.getLayoutMode().setNightMode(i == 1);
        this.cNa.getLayoutMode().u(this.mParent);
        ak.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ak.j(this.mParent, d.C0126d.common_color_10041);
        ak.c(this.aMR, d.C0126d.cp_cont_f, 1);
    }
}
