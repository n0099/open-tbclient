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
    TextView dFW;
    private View dFX;
    TbPageContext<GroupAddressEditActivity> gdy;
    private boolean hxn;
    private TextView hxp;
    private String[] hxq;
    l hxr;
    NavigationBar mNavigationBar;
    View mParent;

    public View bTS() {
        return this.dFW;
    }

    public View getBackButton() {
        return this.dFX;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.gdy = null;
        this.dFW = null;
        this.dFX = null;
        this.AG = null;
        this.hxp = null;
        this.hxq = null;
        this.hxn = false;
        this.hxr = null;
        this.hxq = strArr;
        this.hxn = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.dFX.setOnClickListener(groupAddressEditActivity);
        this.dFW.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.gdy = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.AG = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.hxr = new l(groupAddressEditActivity, this.hxq);
        this.AG.setAdapter((ListAdapter) this.hxr);
        this.AG.setOnItemClickListener(groupAddressEditActivity);
        this.hxp = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.hxq == null || this.hxq.length < 1) {
            this.AG.setVisibility(8);
            this.hxp.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.hxn) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dFX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bTT() {
        this.hxr.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.gdy.getLayoutMode().setNightMode(i == 1);
        this.gdy.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dFW, R.color.cp_cont_f, 1);
    }
}
