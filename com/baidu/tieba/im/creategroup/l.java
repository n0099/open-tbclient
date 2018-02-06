package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class l extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView avh;
    TextView bCB;
    private View bCC;
    TbPageContext<GroupAddressEditActivity> duu;
    private boolean eAI;
    private TextView eAK;
    private String[] eAL;
    m eAM;
    NavigationBar mNavigationBar;
    View mParent;

    public View aHE() {
        return this.bCB;
    }

    public View getBackButton() {
        return this.bCC;
    }

    public l(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.duu = null;
        this.bCB = null;
        this.bCC = null;
        this.avh = null;
        this.eAK = null;
        this.eAL = null;
        this.eAI = false;
        this.eAM = null;
        this.eAL = strArr;
        this.eAI = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.bCC.setOnClickListener(groupAddressEditActivity);
        this.bCB.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.duu = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.avh = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.eAM = new m(groupAddressEditActivity, this.eAL);
        this.avh.setAdapter((ListAdapter) this.eAM);
        this.avh.setOnItemClickListener(groupAddressEditActivity);
        this.eAK = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.eAL == null || this.eAL.length < 1) {
            this.avh.setVisibility(8);
            this.eAK.setText(d.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.eAI) {
            settingTextSwitchView.rJ();
        } else {
            settingTextSwitchView.rK();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bCC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(d.j.save));
    }

    public void aHF() {
        this.eAM.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.duu.getLayoutMode().aQ(i == 1);
        this.duu.getLayoutMode().aM(this.mParent);
        aj.p(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aj.t(this.mParent, d.C0140d.common_color_10041);
        aj.e(this.bCB, d.C0140d.cp_cont_f, 1);
    }
}
