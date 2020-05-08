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
    BdListView Ua;
    TextView efY;
    private View efZ;
    TbPageContext<GroupAddressEditActivity> gNw;
    private boolean iiG;
    private TextView iiI;
    private String[] iiJ;
    l iiK;
    NavigationBar mNavigationBar;
    View mParent;

    public View ceJ() {
        return this.efY;
    }

    public View getBackButton() {
        return this.efZ;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.gNw = null;
        this.efY = null;
        this.efZ = null;
        this.Ua = null;
        this.iiI = null;
        this.iiJ = null;
        this.iiG = false;
        this.iiK = null;
        this.iiJ = strArr;
        this.iiG = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.efZ.setOnClickListener(groupAddressEditActivity);
        this.efY.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.gNw = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.Ua = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.iiK = new l(groupAddressEditActivity, this.iiJ);
        this.Ua.setAdapter((ListAdapter) this.iiK);
        this.Ua.setOnItemClickListener(groupAddressEditActivity);
        this.iiI = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.iiJ == null || this.iiJ.length < 1) {
            this.Ua.setVisibility(8);
            this.iiI.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.iiG) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.efZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.efY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void ceK() {
        this.iiK.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.gNw.getLayoutMode().setNightMode(i == 1);
        this.gNw.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.efY, R.color.cp_cont_f, 1);
    }
}
