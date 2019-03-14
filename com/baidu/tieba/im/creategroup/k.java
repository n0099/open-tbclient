package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView Pj;
    TextView csA;
    private View csB;
    TbPageContext<GroupAddressEditActivity> eKr;
    private boolean ggm;
    private TextView ggo;
    private String[] ggp;
    l ggq;
    NavigationBar mNavigationBar;
    View mParent;

    public View brM() {
        return this.csA;
    }

    public View getBackButton() {
        return this.csB;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.eKr = null;
        this.csA = null;
        this.csB = null;
        this.Pj = null;
        this.ggo = null;
        this.ggp = null;
        this.ggm = false;
        this.ggq = null;
        this.ggp = strArr;
        this.ggm = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.csB.setOnClickListener(groupAddressEditActivity);
        this.csA.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.eKr = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.Pj = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.ggq = new l(groupAddressEditActivity, this.ggp);
        this.Pj.setAdapter((ListAdapter) this.ggq);
        this.Pj.setOnItemClickListener(groupAddressEditActivity);
        this.ggo = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.ggp == null || this.ggp.length < 1) {
            this.Pj.setVisibility(8);
            this.ggo.setText(d.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.ggm) {
            settingTextSwitchView.oa();
        } else {
            settingTextSwitchView.ob();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.csB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(d.j.save));
    }

    public void brN() {
        this.ggq.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.eKr.getLayoutMode().setNightMode(i == 1);
        this.eKr.getLayoutMode().onModeChanged(this.mParent);
        al.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.l(this.mParent, d.C0277d.common_color_10041);
        al.d(this.csA, d.C0277d.cp_cont_f, 1);
    }
}
