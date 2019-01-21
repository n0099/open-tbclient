package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView OQ;
    TextView biG;
    private View biH;
    TbPageContext<GroupAddressEditActivity> dxc;
    private boolean eQj;
    private TextView eQl;
    private String[] eQm;
    l eQn;
    NavigationBar mNavigationBar;
    View mParent;

    public View aRh() {
        return this.biG;
    }

    public View getBackButton() {
        return this.biH;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.dxc = null;
        this.biG = null;
        this.biH = null;
        this.OQ = null;
        this.eQl = null;
        this.eQm = null;
        this.eQj = false;
        this.eQn = null;
        this.eQm = strArr;
        this.eQj = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.biH.setOnClickListener(groupAddressEditActivity);
        this.biG.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.dxc = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(e.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(e.g.parent);
        this.OQ = (BdListView) groupAddressEditActivity.findViewById(e.g.lv_address);
        this.eQn = new l(groupAddressEditActivity, this.eQm);
        this.OQ.setAdapter((ListAdapter) this.eQn);
        this.OQ.setOnItemClickListener(groupAddressEditActivity);
        this.eQl = (TextView) groupAddressEditActivity.findViewById(e.g.address_title_poslist);
        if (this.eQm == null || this.eQm.length < 1) {
            this.OQ.setVisibility(8);
            this.eQl.setText(e.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(e.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.eQj) {
            settingTextSwitchView.nV();
        } else {
            settingTextSwitchView.nW();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.biH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.biG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(e.j.save));
    }

    public void aRi() {
        this.eQn.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.dxc.getLayoutMode().setNightMode(i == 1);
        this.dxc.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.biG, e.d.cp_cont_f, 1);
    }
}
