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
    BdListView VX;
    TextView fjr;
    private View fjs;
    TbPageContext<GroupAddressEditActivity> idM;
    private boolean jIS;
    private TextView jIU;
    private String[] jIV;
    l jIW;
    NavigationBar mNavigationBar;
    View mParent;

    public View cKS() {
        return this.fjr;
    }

    public View getBackButton() {
        return this.fjs;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.idM = null;
        this.fjr = null;
        this.fjs = null;
        this.VX = null;
        this.jIU = null;
        this.jIV = null;
        this.jIS = false;
        this.jIW = null;
        this.jIV = strArr;
        this.jIS = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.fjs.setOnClickListener(groupAddressEditActivity);
        this.fjr.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.idM = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.VX = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.jIW = new l(groupAddressEditActivity, this.jIV);
        this.VX.setAdapter((ListAdapter) this.jIW);
        this.VX.setOnItemClickListener(groupAddressEditActivity);
        this.jIU = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.jIV == null || this.jIV.length < 1) {
            this.VX.setVisibility(8);
            this.jIU.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.jIS) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.fjs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fjr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void cKT() {
        this.jIW.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.idM.getLayoutMode().setNightMode(i == 1);
        this.idM.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.fjr, R.color.cp_cont_f, 1);
    }
}
