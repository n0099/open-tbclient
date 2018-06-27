package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView LS;
    TextView aVM;
    private View aVN;
    TbPageContext<GroupAddressEditActivity> cVl;
    private boolean elA;
    private TextView elC;
    private String[] elD;
    l elE;
    NavigationBar mNavigationBar;
    View mParent;

    public View aId() {
        return this.aVM;
    }

    public View getBackButton() {
        return this.aVN;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.cVl = null;
        this.aVM = null;
        this.aVN = null;
        this.LS = null;
        this.elC = null;
        this.elD = null;
        this.elA = false;
        this.elE = null;
        this.elD = strArr;
        this.elA = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.aVN.setOnClickListener(groupAddressEditActivity);
        this.aVM.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.cVl = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.i.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.LS = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.elE = new l(groupAddressEditActivity, this.elD);
        this.LS.setAdapter((ListAdapter) this.elE);
        this.LS.setOnItemClickListener(groupAddressEditActivity);
        this.elC = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.elD == null || this.elD.length < 1) {
            this.LS.setVisibility(8);
            this.elC.setText(d.k.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.elA) {
            settingTextSwitchView.mC();
        } else {
            settingTextSwitchView.mD();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(d.k.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aVN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(d.k.save));
    }

    public void aIe() {
        this.elE.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.cVl.getLayoutMode().setNightMode(i == 1);
        this.cVl.getLayoutMode().onModeChanged(this.mParent);
        am.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.j(this.mParent, d.C0142d.common_color_10041);
        am.c(this.aVM, d.C0142d.cp_cont_f, 1);
    }
}
