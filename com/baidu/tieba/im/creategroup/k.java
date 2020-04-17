package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView TX;
    TextView efT;
    private View efU;
    TbPageContext<GroupAddressEditActivity> gNq;
    private boolean iiA;
    private TextView iiC;
    private String[] iiD;
    l iiE;
    NavigationBar mNavigationBar;
    View mParent;

    public View ceL() {
        return this.efT;
    }

    public View getBackButton() {
        return this.efU;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.gNq = null;
        this.efT = null;
        this.efU = null;
        this.TX = null;
        this.iiC = null;
        this.iiD = null;
        this.iiA = false;
        this.iiE = null;
        this.iiD = strArr;
        this.iiA = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.efU.setOnClickListener(groupAddressEditActivity);
        this.efT.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.gNq = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.TX = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.iiE = new l(groupAddressEditActivity, this.iiD);
        this.TX.setAdapter((ListAdapter) this.iiE);
        this.TX.setOnItemClickListener(groupAddressEditActivity);
        this.iiC = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.iiD == null || this.iiD.length < 1) {
            this.TX.setVisibility(8);
            this.iiC.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.iiA) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.efU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.efT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void ceM() {
        this.iiE.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.gNq.getLayoutMode().setNightMode(i == 1);
        this.gNq.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.efT, R.color.cp_cont_f, 1);
    }
}
