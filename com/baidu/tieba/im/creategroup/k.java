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
    TextView biF;
    private View biG;
    TbPageContext<GroupAddressEditActivity> dxb;
    private boolean eQi;
    private TextView eQk;
    private String[] eQl;
    l eQm;
    NavigationBar mNavigationBar;
    View mParent;

    public View aRh() {
        return this.biF;
    }

    public View getBackButton() {
        return this.biG;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.dxb = null;
        this.biF = null;
        this.biG = null;
        this.OQ = null;
        this.eQk = null;
        this.eQl = null;
        this.eQi = false;
        this.eQm = null;
        this.eQl = strArr;
        this.eQi = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.biG.setOnClickListener(groupAddressEditActivity);
        this.biF.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.dxb = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(e.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(e.g.parent);
        this.OQ = (BdListView) groupAddressEditActivity.findViewById(e.g.lv_address);
        this.eQm = new l(groupAddressEditActivity, this.eQl);
        this.OQ.setAdapter((ListAdapter) this.eQm);
        this.OQ.setOnItemClickListener(groupAddressEditActivity);
        this.eQk = (TextView) groupAddressEditActivity.findViewById(e.g.address_title_poslist);
        if (this.eQl == null || this.eQl.length < 1) {
            this.OQ.setVisibility(8);
            this.eQk.setText(e.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(e.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.eQi) {
            settingTextSwitchView.nV();
        } else {
            settingTextSwitchView.nW();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.biG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.biF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(e.j.save));
    }

    public void aRi() {
        this.eQm.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.dxb.getLayoutMode().setNightMode(i == 1);
        this.dxb.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.biF, e.d.cp_cont_f, 1);
    }
}
