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
/* loaded from: classes7.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView Ak;
    TextView dBx;
    private View dBy;
    TbPageContext<GroupAddressEditActivity> fXZ;
    private String[] hrA;
    l hrB;
    private boolean hrx;
    private TextView hrz;
    NavigationBar mNavigationBar;
    View mParent;

    public View bRf() {
        return this.dBx;
    }

    public View getBackButton() {
        return this.dBy;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.fXZ = null;
        this.dBx = null;
        this.dBy = null;
        this.Ak = null;
        this.hrz = null;
        this.hrA = null;
        this.hrx = false;
        this.hrB = null;
        this.hrA = strArr;
        this.hrx = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.dBy.setOnClickListener(groupAddressEditActivity);
        this.dBx.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.fXZ = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.Ak = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.hrB = new l(groupAddressEditActivity, this.hrA);
        this.Ak.setAdapter((ListAdapter) this.hrB);
        this.Ak.setOnItemClickListener(groupAddressEditActivity);
        this.hrz = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.hrA == null || this.hrA.length < 1) {
            this.Ak.setVisibility(8);
            this.hrz.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.hrx) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dBy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dBx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bRg() {
        this.hrB.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.fXZ.getLayoutMode().setNightMode(i == 1);
        this.fXZ.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dBx, R.color.cp_cont_f, 1);
    }
}
