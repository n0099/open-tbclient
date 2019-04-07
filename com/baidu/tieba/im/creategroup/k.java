package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView Pj;
    TextView csC;
    private View csD;
    TbPageContext<GroupAddressEditActivity> eKd;
    private boolean gga;
    private TextView ggc;
    private String[] ggd;
    l gge;
    NavigationBar mNavigationBar;
    View mParent;

    public View brJ() {
        return this.csC;
    }

    public View getBackButton() {
        return this.csD;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.eKd = null;
        this.csC = null;
        this.csD = null;
        this.Pj = null;
        this.ggc = null;
        this.ggd = null;
        this.gga = false;
        this.gge = null;
        this.ggd = strArr;
        this.gga = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.csD.setOnClickListener(groupAddressEditActivity);
        this.csC.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.eKd = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.Pj = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.gge = new l(groupAddressEditActivity, this.ggd);
        this.Pj.setAdapter((ListAdapter) this.gge);
        this.Pj.setOnItemClickListener(groupAddressEditActivity);
        this.ggc = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.ggd == null || this.ggd.length < 1) {
            this.Pj.setVisibility(8);
            this.ggc.setText(d.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.gga) {
            settingTextSwitchView.oa();
        } else {
            settingTextSwitchView.ob();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.csD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(d.j.save));
    }

    public void brK() {
        this.gge.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.eKd.getLayoutMode().setNightMode(i == 1);
        this.eKd.getLayoutMode().onModeChanged(this.mParent);
        al.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.l(this.mParent, d.C0277d.common_color_10041);
        al.d(this.csC, d.C0277d.cp_cont_f, 1);
    }
}
