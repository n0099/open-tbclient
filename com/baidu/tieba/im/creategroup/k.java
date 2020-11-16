package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView Wa;
    TextView fwX;
    private View fwY;
    TbPageContext<GroupAddressEditActivity> iwW;
    private boolean kbY;
    private TextView kca;
    private String[] kcb;
    l kcc;
    NavigationBar mNavigationBar;
    View mParent;

    public View cQg() {
        return this.fwX;
    }

    public View getBackButton() {
        return this.fwY;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.iwW = null;
        this.fwX = null;
        this.fwY = null;
        this.Wa = null;
        this.kca = null;
        this.kcb = null;
        this.kbY = false;
        this.kcc = null;
        this.kcb = strArr;
        this.kbY = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.fwY.setOnClickListener(groupAddressEditActivity);
        this.fwX.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.iwW = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.Wa = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.kcc = new l(groupAddressEditActivity, this.kcb);
        this.Wa.setAdapter((ListAdapter) this.kcc);
        this.Wa.setOnItemClickListener(groupAddressEditActivity);
        this.kca = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.kcb == null || this.kcb.length < 1) {
            this.Wa.setVisibility(8);
            this.kca.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.kbY) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.fwY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fwX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void cQh() {
        this.kcc.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.iwW.getLayoutMode().setNightMode(i == 1);
        this.iwW.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.fwX, R.color.CAM_X0106, 1);
    }
}
