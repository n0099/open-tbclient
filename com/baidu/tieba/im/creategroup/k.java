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
    BdListView Op;
    TextView aZd;
    private View aZe;
    TbPageContext<GroupAddressEditActivity> ddS;
    private boolean ewI;
    private TextView ewK;
    private String[] ewL;
    l ewM;
    NavigationBar mNavigationBar;
    View mParent;

    public View aLq() {
        return this.aZd;
    }

    public View getBackButton() {
        return this.aZe;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.ddS = null;
        this.aZd = null;
        this.aZe = null;
        this.Op = null;
        this.ewK = null;
        this.ewL = null;
        this.ewI = false;
        this.ewM = null;
        this.ewL = strArr;
        this.ewI = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.aZe.setOnClickListener(groupAddressEditActivity);
        this.aZd.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.ddS = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(e.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(e.g.parent);
        this.Op = (BdListView) groupAddressEditActivity.findViewById(e.g.lv_address);
        this.ewM = new l(groupAddressEditActivity, this.ewL);
        this.Op.setAdapter((ListAdapter) this.ewM);
        this.Op.setOnItemClickListener(groupAddressEditActivity);
        this.ewK = (TextView) groupAddressEditActivity.findViewById(e.g.address_title_poslist);
        if (this.ewL == null || this.ewL.length < 1) {
            this.Op.setVisibility(8);
            this.ewK.setText(e.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(e.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.ewI) {
            settingTextSwitchView.nK();
        } else {
            settingTextSwitchView.nL();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aZe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aZd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(e.j.save));
    }

    public void aLr() {
        this.ewM.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.ddS.getLayoutMode().setNightMode(i == 1);
        this.ddS.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.aZd, e.d.cp_cont_f, 1);
    }
}
