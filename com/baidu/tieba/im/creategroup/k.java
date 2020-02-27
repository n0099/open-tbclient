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
    BdListView AG;
    TextView dFI;
    private View dFJ;
    TbPageContext<GroupAddressEditActivity> gdj;
    private boolean hwZ;
    private TextView hxb;
    private String[] hxc;
    l hxd;
    NavigationBar mNavigationBar;
    View mParent;

    public View bTP() {
        return this.dFI;
    }

    public View getBackButton() {
        return this.dFJ;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.gdj = null;
        this.dFI = null;
        this.dFJ = null;
        this.AG = null;
        this.hxb = null;
        this.hxc = null;
        this.hwZ = false;
        this.hxd = null;
        this.hxc = strArr;
        this.hwZ = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.dFJ.setOnClickListener(groupAddressEditActivity);
        this.dFI.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.gdj = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.AG = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.hxd = new l(groupAddressEditActivity, this.hxc);
        this.AG.setAdapter((ListAdapter) this.hxd);
        this.AG.setOnItemClickListener(groupAddressEditActivity);
        this.hxb = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.hxc == null || this.hxc.length < 1) {
            this.AG.setVisibility(8);
            this.hxb.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.hwZ) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dFJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bTQ() {
        this.hxd.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.gdj.getLayoutMode().setNightMode(i == 1);
        this.gdj.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dFI, R.color.cp_cont_f, 1);
    }
}
