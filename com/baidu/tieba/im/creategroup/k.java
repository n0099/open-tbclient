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
    BdListView OE;
    TextView bdD;
    private View bdE;
    TbPageContext<GroupAddressEditActivity> dlY;
    private String[] eEA;
    l eEB;
    private boolean eEx;
    private TextView eEz;
    NavigationBar mNavigationBar;
    View mParent;

    public View aOF() {
        return this.bdD;
    }

    public View getBackButton() {
        return this.bdE;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.dlY = null;
        this.bdD = null;
        this.bdE = null;
        this.OE = null;
        this.eEz = null;
        this.eEA = null;
        this.eEx = false;
        this.eEB = null;
        this.eEA = strArr;
        this.eEx = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.bdE.setOnClickListener(groupAddressEditActivity);
        this.bdD.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.dlY = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(e.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(e.g.parent);
        this.OE = (BdListView) groupAddressEditActivity.findViewById(e.g.lv_address);
        this.eEB = new l(groupAddressEditActivity, this.eEA);
        this.OE.setAdapter((ListAdapter) this.eEB);
        this.OE.setOnItemClickListener(groupAddressEditActivity);
        this.eEz = (TextView) groupAddressEditActivity.findViewById(e.g.address_title_poslist);
        if (this.eEA == null || this.eEA.length < 1) {
            this.OE.setVisibility(8);
            this.eEz.setText(e.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(e.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.eEx) {
            settingTextSwitchView.nU();
        } else {
            settingTextSwitchView.nV();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bdE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bdD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(e.j.save));
    }

    public void aOG() {
        this.eEB.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.dlY.getLayoutMode().setNightMode(i == 1);
        this.dlY.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.bdD, e.d.cp_cont_f, 1);
    }
}
