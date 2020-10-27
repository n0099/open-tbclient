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
    BdListView VY;
    TextView frQ;
    private View frR;
    TbPageContext<GroupAddressEditActivity> iqk;
    private boolean jVr;
    private TextView jVt;
    private String[] jVu;
    l jVv;
    NavigationBar mNavigationBar;
    View mParent;

    public View cNZ() {
        return this.frQ;
    }

    public View getBackButton() {
        return this.frR;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.iqk = null;
        this.frQ = null;
        this.frR = null;
        this.VY = null;
        this.jVt = null;
        this.jVu = null;
        this.jVr = false;
        this.jVv = null;
        this.jVu = strArr;
        this.jVr = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.frR.setOnClickListener(groupAddressEditActivity);
        this.frQ.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.iqk = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.VY = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.jVv = new l(groupAddressEditActivity, this.jVu);
        this.VY.setAdapter((ListAdapter) this.jVv);
        this.VY.setOnItemClickListener(groupAddressEditActivity);
        this.jVt = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.jVu == null || this.jVu.length < 1) {
            this.VY.setVisibility(8);
            this.jVt.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.jVr) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.frR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.frQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void cOa() {
        this.jVv.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.iqk.getLayoutMode().setNightMode(i == 1);
        this.iqk.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.frQ, R.color.cp_cont_f, 1);
    }
}
