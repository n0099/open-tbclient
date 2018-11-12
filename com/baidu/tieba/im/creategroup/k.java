package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView OF;
    TextView ber;
    private View bes;
    TbPageContext<GroupAddressEditActivity> dnc;
    private boolean eFQ;
    private TextView eFS;
    private String[] eFT;
    l eFU;
    NavigationBar mNavigationBar;
    View mParent;

    public View aOc() {
        return this.ber;
    }

    public View getBackButton() {
        return this.bes;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.dnc = null;
        this.ber = null;
        this.bes = null;
        this.OF = null;
        this.eFS = null;
        this.eFT = null;
        this.eFQ = false;
        this.eFU = null;
        this.eFT = strArr;
        this.eFQ = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.bes.setOnClickListener(groupAddressEditActivity);
        this.ber.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.dnc = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(e.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(e.g.parent);
        this.OF = (BdListView) groupAddressEditActivity.findViewById(e.g.lv_address);
        this.eFU = new l(groupAddressEditActivity, this.eFT);
        this.OF.setAdapter((ListAdapter) this.eFU);
        this.OF.setOnItemClickListener(groupAddressEditActivity);
        this.eFS = (TextView) groupAddressEditActivity.findViewById(e.g.address_title_poslist);
        if (this.eFT == null || this.eFT.length < 1) {
            this.OF.setVisibility(8);
            this.eFS.setText(e.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(e.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.eFQ) {
            settingTextSwitchView.nS();
        } else {
            settingTextSwitchView.nT();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bes = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ber = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(e.j.save));
    }

    public void aOd() {
        this.eFU.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.dnc.getLayoutMode().setNightMode(i == 1);
        this.dnc.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.ber, e.d.cp_cont_f, 1);
    }
}
