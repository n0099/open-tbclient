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
    TextView dFJ;
    private View dFK;
    TbPageContext<GroupAddressEditActivity> gdl;
    private boolean hxb;
    private TextView hxd;
    private String[] hxe;
    l hxf;
    NavigationBar mNavigationBar;
    View mParent;

    public View bTR() {
        return this.dFJ;
    }

    public View getBackButton() {
        return this.dFK;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.gdl = null;
        this.dFJ = null;
        this.dFK = null;
        this.AG = null;
        this.hxd = null;
        this.hxe = null;
        this.hxb = false;
        this.hxf = null;
        this.hxe = strArr;
        this.hxb = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.dFK.setOnClickListener(groupAddressEditActivity);
        this.dFJ.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.gdl = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.AG = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.hxf = new l(groupAddressEditActivity, this.hxe);
        this.AG.setAdapter((ListAdapter) this.hxf);
        this.AG.setOnItemClickListener(groupAddressEditActivity);
        this.hxd = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.hxe == null || this.hxe.length < 1) {
            this.AG.setVisibility(8);
            this.hxd.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.hxb) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dFK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bTS() {
        this.hxf.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.gdl.getLayoutMode().setNightMode(i == 1);
        this.gdl.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dFJ, R.color.cp_cont_f, 1);
    }
}
