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
    TbPageContext<GroupAddressEditActivity> iHQ;
    private boolean kpE;
    private TextView kpG;
    private String[] kpH;
    l kpI;
    NavigationBar mNavigationBar;
    View mParent;

    public View cVv() {
        return this.fEM;
    }

    public View getBackButton() {
        return this.fEN;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.iHQ = null;
        this.fEM = null;
        this.fEN = null;
        this.WX = null;
        this.kpG = null;
        this.kpH = null;
        this.kpE = false;
        this.kpI = null;
        this.kpH = strArr;
        this.kpE = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.fEN.setOnClickListener(groupAddressEditActivity);
        this.fEM.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.iHQ = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.WX = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.kpI = new l(groupAddressEditActivity, this.kpH);
        this.WX.setAdapter((ListAdapter) this.kpI);
        this.WX.setOnItemClickListener(groupAddressEditActivity);
        this.kpG = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.kpH == null || this.kpH.length < 1) {
            this.WX.setVisibility(8);
            this.kpG.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.kpE) {
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

    public void cVw() {
        this.kpI.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.iHQ.getLayoutMode().setNightMode(i == 1);
        this.iHQ.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.fEM, R.color.CAM_X0106, 1);
    }
}
