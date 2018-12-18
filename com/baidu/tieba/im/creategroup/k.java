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
    TextView bhR;
    private View bhS;
    TbPageContext<GroupAddressEditActivity> dtE;
    private boolean eMF;
    private TextView eMH;
    private String[] eMI;
    l eMJ;
    NavigationBar mNavigationBar;
    View mParent;

    public View aPT() {
        return this.bhR;
    }

    public View getBackButton() {
        return this.bhS;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.dtE = null;
        this.bhR = null;
        this.bhS = null;
        this.OF = null;
        this.eMH = null;
        this.eMI = null;
        this.eMF = false;
        this.eMJ = null;
        this.eMI = strArr;
        this.eMF = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.bhS.setOnClickListener(groupAddressEditActivity);
        this.bhR.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.dtE = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(e.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(e.g.parent);
        this.OF = (BdListView) groupAddressEditActivity.findViewById(e.g.lv_address);
        this.eMJ = new l(groupAddressEditActivity, this.eMI);
        this.OF.setAdapter((ListAdapter) this.eMJ);
        this.OF.setOnItemClickListener(groupAddressEditActivity);
        this.eMH = (TextView) groupAddressEditActivity.findViewById(e.g.address_title_poslist);
        if (this.eMI == null || this.eMI.length < 1) {
            this.OF.setVisibility(8);
            this.eMH.setText(e.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(e.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.eMF) {
            settingTextSwitchView.nR();
        } else {
            settingTextSwitchView.nS();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bhS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bhR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(e.j.save));
    }

    public void aPU() {
        this.eMJ.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.dtE.getLayoutMode().setNightMode(i == 1);
        this.dtE.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.bhR, e.d.cp_cont_f, 1);
    }
}
