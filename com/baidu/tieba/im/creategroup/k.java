package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView US;
    TextView eDq;
    private View eDr;
    TbPageContext<GroupAddressEditActivity> hoE;
    private boolean iPh;
    private TextView iPj;
    private String[] iPk;
    l iPl;
    NavigationBar mNavigationBar;
    View mParent;

    public View cpf() {
        return this.eDq;
    }

    public View getBackButton() {
        return this.eDr;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.hoE = null;
        this.eDq = null;
        this.eDr = null;
        this.US = null;
        this.iPj = null;
        this.iPk = null;
        this.iPh = false;
        this.iPl = null;
        this.iPk = strArr;
        this.iPh = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.eDr.setOnClickListener(groupAddressEditActivity);
        this.eDq.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.hoE = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.US = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.iPl = new l(groupAddressEditActivity, this.iPk);
        this.US.setAdapter((ListAdapter) this.iPl);
        this.US.setOnItemClickListener(groupAddressEditActivity);
        this.iPj = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.iPk == null || this.iPk.length < 1) {
            this.US.setVisibility(8);
            this.iPj.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.iPh) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eDr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eDq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void cpg() {
        this.iPl.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.hoE.getLayoutMode().setNightMode(i == 1);
        this.hoE.getLayoutMode().onModeChanged(this.mParent);
        an.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        an.setBackgroundColor(this.mParent, R.color.common_color_10041);
        an.setViewTextColor(this.eDq, R.color.cp_cont_f, 1);
    }
}
