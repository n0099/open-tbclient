package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView UL;
    TextView eJF;
    private View eJG;
    TbPageContext<GroupAddressEditActivity> huq;
    private boolean iWk;
    private TextView iWm;
    private String[] iWn;
    l iWo;
    NavigationBar mNavigationBar;
    View mParent;

    public View csL() {
        return this.eJF;
    }

    public View getBackButton() {
        return this.eJG;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.huq = null;
        this.eJF = null;
        this.eJG = null;
        this.UL = null;
        this.iWm = null;
        this.iWn = null;
        this.iWk = false;
        this.iWo = null;
        this.iWn = strArr;
        this.iWk = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.eJG.setOnClickListener(groupAddressEditActivity);
        this.eJF.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.huq = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.UL = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.iWo = new l(groupAddressEditActivity, this.iWn);
        this.UL.setAdapter((ListAdapter) this.iWo);
        this.UL.setOnItemClickListener(groupAddressEditActivity);
        this.iWm = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.iWn == null || this.iWn.length < 1) {
            this.UL.setVisibility(8);
            this.iWm.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.iWk) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eJG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eJF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void csM() {
        this.iWo.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.huq.getLayoutMode().setNightMode(i == 1);
        this.huq.getLayoutMode().onModeChanged(this.mParent);
        ao.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ao.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ao.setViewTextColor(this.eJF, R.color.cp_cont_f, 1);
    }
}
