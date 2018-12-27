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
    BdListView OF;
    TextView bhU;
    private View bhV;
    TbPageContext<GroupAddressEditActivity> dws;
    l ePA;
    private boolean ePw;
    private TextView ePy;
    private String[] ePz;
    NavigationBar mNavigationBar;
    View mParent;

    public View aQH() {
        return this.bhU;
    }

    public View getBackButton() {
        return this.bhV;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.dws = null;
        this.bhU = null;
        this.bhV = null;
        this.OF = null;
        this.ePy = null;
        this.ePz = null;
        this.ePw = false;
        this.ePA = null;
        this.ePz = strArr;
        this.ePw = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.bhV.setOnClickListener(groupAddressEditActivity);
        this.bhU.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.dws = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(e.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(e.g.parent);
        this.OF = (BdListView) groupAddressEditActivity.findViewById(e.g.lv_address);
        this.ePA = new l(groupAddressEditActivity, this.ePz);
        this.OF.setAdapter((ListAdapter) this.ePA);
        this.OF.setOnItemClickListener(groupAddressEditActivity);
        this.ePy = (TextView) groupAddressEditActivity.findViewById(e.g.address_title_poslist);
        if (this.ePz == null || this.ePz.length < 1) {
            this.OF.setVisibility(8);
            this.ePy.setText(e.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(e.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.ePw) {
            settingTextSwitchView.nR();
        } else {
            settingTextSwitchView.nS();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bhV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bhU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(e.j.save));
    }

    public void aQI() {
        this.ePA.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.dws.getLayoutMode().setNightMode(i == 1);
        this.dws.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.bhU, e.d.cp_cont_f, 1);
    }
}
