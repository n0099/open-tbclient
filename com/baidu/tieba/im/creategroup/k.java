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
/* loaded from: classes23.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView WX;
    TextView fEM;
    private View fEN;
    TbPageContext<GroupAddressEditActivity> iHO;
    private boolean kpC;
    private TextView kpE;
    private String[] kpF;
    l kpG;
    NavigationBar mNavigationBar;
    View mParent;

    public View cVu() {
        return this.fEM;
    }

    public View getBackButton() {
        return this.fEN;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.iHO = null;
        this.fEM = null;
        this.fEN = null;
        this.WX = null;
        this.kpE = null;
        this.kpF = null;
        this.kpC = false;
        this.kpG = null;
        this.kpF = strArr;
        this.kpC = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.fEN.setOnClickListener(groupAddressEditActivity);
        this.fEM.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.iHO = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.WX = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.kpG = new l(groupAddressEditActivity, this.kpF);
        this.WX.setAdapter((ListAdapter) this.kpG);
        this.WX.setOnItemClickListener(groupAddressEditActivity);
        this.kpE = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.kpF == null || this.kpF.length < 1) {
            this.WX.setVisibility(8);
            this.kpE.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.kpC) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.fEN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fEM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void cVv() {
        this.kpG.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.iHO.getLayoutMode().setNightMode(i == 1);
        this.iHO.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.fEM, R.color.CAM_X0106, 1);
    }
}
