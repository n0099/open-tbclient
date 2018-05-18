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
    BdListView FH;
    TextView aMS;
    private View aMT;
    TbPageContext<GroupAddressEditActivity> cOe;
    private boolean dWu;
    private TextView dWw;
    private String[] dWx;
    l dWy;
    NavigationBar mNavigationBar;
    View mParent;

    public View aCB() {
        return this.aMS;
    }

    public View getBackButton() {
        return this.aMT;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.cOe = null;
        this.aMS = null;
        this.aMT = null;
        this.FH = null;
        this.dWw = null;
        this.dWx = null;
        this.dWu = false;
        this.dWy = null;
        this.dWx = strArr;
        this.dWu = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.aMT.setOnClickListener(groupAddressEditActivity);
        this.aMS.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.cOe = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.i.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.FH = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.dWy = new l(groupAddressEditActivity, this.dWx);
        this.FH.setAdapter((ListAdapter) this.dWy);
        this.FH.setOnItemClickListener(groupAddressEditActivity);
        this.dWw = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.dWx == null || this.dWx.length < 1) {
            this.FH.setVisibility(8);
            this.dWw.setText(d.k.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.dWu) {
            settingTextSwitchView.jO();
        } else {
            settingTextSwitchView.jP();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(d.k.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aMT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(d.k.save));
    }

    public void aCC() {
        this.dWy.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.cOe.getLayoutMode().setNightMode(i == 1);
        this.cOe.getLayoutMode().u(this.mParent);
        ak.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ak.j(this.mParent, d.C0126d.common_color_10041);
        ak.c(this.aMS, d.C0126d.cp_cont_f, 1);
    }
}
