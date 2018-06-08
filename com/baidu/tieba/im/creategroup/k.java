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
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView LQ;
    TextView aUQ;
    private View aUR;
    TbPageContext<GroupAddressEditActivity> cXj;
    private boolean ehH;
    private TextView ehJ;
    private String[] ehK;
    l ehL;
    NavigationBar mNavigationBar;
    View mParent;

    public View aHw() {
        return this.aUQ;
    }

    public View getBackButton() {
        return this.aUR;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.cXj = null;
        this.aUQ = null;
        this.aUR = null;
        this.LQ = null;
        this.ehJ = null;
        this.ehK = null;
        this.ehH = false;
        this.ehL = null;
        this.ehK = strArr;
        this.ehH = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.aUR.setOnClickListener(groupAddressEditActivity);
        this.aUQ.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.cXj = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.i.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.LQ = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.ehL = new l(groupAddressEditActivity, this.ehK);
        this.LQ.setAdapter((ListAdapter) this.ehL);
        this.LQ.setOnItemClickListener(groupAddressEditActivity);
        this.ehJ = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.ehK == null || this.ehK.length < 1) {
            this.LQ.setVisibility(8);
            this.ehJ.setText(d.k.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.ehH) {
            settingTextSwitchView.mC();
        } else {
            settingTextSwitchView.mD();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(d.k.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aUR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(d.k.save));
    }

    public void aHx() {
        this.ehL.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.cXj.getLayoutMode().setNightMode(i == 1);
        this.cXj.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, d.C0141d.common_color_10041);
        al.c(this.aUQ, d.C0141d.cp_cont_f, 1);
    }
}
