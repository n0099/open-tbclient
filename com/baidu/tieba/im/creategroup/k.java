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
    BdListView VG;
    TextView eXf;
    private View eXg;
    TbPageContext<GroupAddressEditActivity> hON;
    private boolean jtV;
    private TextView jtX;
    private String[] jtY;
    l jtZ;
    NavigationBar mNavigationBar;
    View mParent;

    public View cHj() {
        return this.eXf;
    }

    public View getBackButton() {
        return this.eXg;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.hON = null;
        this.eXf = null;
        this.eXg = null;
        this.VG = null;
        this.jtX = null;
        this.jtY = null;
        this.jtV = false;
        this.jtZ = null;
        this.jtY = strArr;
        this.jtV = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.eXg.setOnClickListener(groupAddressEditActivity);
        this.eXf.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.hON = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.VG = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.jtZ = new l(groupAddressEditActivity, this.jtY);
        this.VG.setAdapter((ListAdapter) this.jtZ);
        this.VG.setOnItemClickListener(groupAddressEditActivity);
        this.jtX = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.jtY == null || this.jtY.length < 1) {
            this.VG.setVisibility(8);
            this.jtX.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.jtV) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eXg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eXf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void cHk() {
        this.jtZ.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.hON.getLayoutMode().setNightMode(i == 1);
        this.hON.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.eXf, R.color.cp_cont_f, 1);
    }
}
