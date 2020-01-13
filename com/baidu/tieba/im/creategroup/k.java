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
/* loaded from: classes8.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView Ao;
    TextView dBH;
    private View dBI;
    TbPageContext<GroupAddressEditActivity> gbi;
    private boolean hva;
    private TextView hvc;
    private String[] hvd;
    l hve;
    NavigationBar mNavigationBar;
    View mParent;

    public View bSo() {
        return this.dBH;
    }

    public View getBackButton() {
        return this.dBI;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.gbi = null;
        this.dBH = null;
        this.dBI = null;
        this.Ao = null;
        this.hvc = null;
        this.hvd = null;
        this.hva = false;
        this.hve = null;
        this.hvd = strArr;
        this.hva = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.dBI.setOnClickListener(groupAddressEditActivity);
        this.dBH.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.gbi = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.Ao = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.hve = new l(groupAddressEditActivity, this.hvd);
        this.Ao.setAdapter((ListAdapter) this.hve);
        this.Ao.setOnItemClickListener(groupAddressEditActivity);
        this.hvc = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.hvd == null || this.hvd.length < 1) {
            this.Ao.setVisibility(8);
            this.hvc.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.hva) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dBI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dBH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bSp() {
        this.hve.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.gbi.getLayoutMode().setNightMode(i == 1);
        this.gbi.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dBH, R.color.cp_cont_f, 1);
    }
}
