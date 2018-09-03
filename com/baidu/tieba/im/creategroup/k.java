package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView LO;
    TextView aVO;
    private View aVP;
    TbPageContext<GroupAddressEditActivity> cXW;
    private boolean epp;
    private TextView epr;
    private String[] eps;
    l ept;
    NavigationBar mNavigationBar;
    View mParent;

    public View aJb() {
        return this.aVO;
    }

    public View getBackButton() {
        return this.aVP;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.cXW = null;
        this.aVO = null;
        this.aVP = null;
        this.LO = null;
        this.epr = null;
        this.eps = null;
        this.epp = false;
        this.ept = null;
        this.eps = strArr;
        this.epp = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.aVP.setOnClickListener(groupAddressEditActivity);
        this.aVO.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.cXW = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(f.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(f.g.parent);
        this.LO = (BdListView) groupAddressEditActivity.findViewById(f.g.lv_address);
        this.ept = new l(groupAddressEditActivity, this.eps);
        this.LO.setAdapter((ListAdapter) this.ept);
        this.LO.setOnItemClickListener(groupAddressEditActivity);
        this.epr = (TextView) groupAddressEditActivity.findViewById(f.g.address_title_poslist);
        if (this.eps == null || this.eps.length < 1) {
            this.LO.setVisibility(8);
            this.epr.setText(f.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(f.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.epp) {
            settingTextSwitchView.mE();
        } else {
            settingTextSwitchView.mF();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(f.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(f.j.save));
    }

    public void aJc() {
        this.ept.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.cXW.getLayoutMode().setNightMode(i == 1);
        this.cXW.getLayoutMode().onModeChanged(this.mParent);
        am.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.j(this.mParent, f.d.common_color_10041);
        am.c(this.aVO, f.d.cp_cont_f, 1);
    }
}
