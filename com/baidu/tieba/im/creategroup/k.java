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
    BdListView LO;
    TextView aVO;
    private View aVP;
    TbPageContext<GroupAddressEditActivity> cYa;
    private boolean ept;
    private TextView epv;
    private String[] epw;
    l epx;
    NavigationBar mNavigationBar;
    View mParent;

    public View aJe() {
        return this.aVO;
    }

    public View getBackButton() {
        return this.aVP;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.cYa = null;
        this.aVO = null;
        this.aVP = null;
        this.LO = null;
        this.epv = null;
        this.epw = null;
        this.ept = false;
        this.epx = null;
        this.epw = strArr;
        this.ept = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.aVP.setOnClickListener(groupAddressEditActivity);
        this.aVO.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.cYa = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(d.h.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(d.g.parent);
        this.LO = (BdListView) groupAddressEditActivity.findViewById(d.g.lv_address);
        this.epx = new l(groupAddressEditActivity, this.epw);
        this.LO.setAdapter((ListAdapter) this.epx);
        this.LO.setOnItemClickListener(groupAddressEditActivity);
        this.epv = (TextView) groupAddressEditActivity.findViewById(d.g.address_title_poslist);
        if (this.epw == null || this.epw.length < 1) {
            this.LO.setVisibility(8);
            this.epv.setText(d.j.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(d.g.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.ept) {
            settingTextSwitchView.mE();
        } else {
            settingTextSwitchView.mF();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(d.j.save));
    }

    public void aJf() {
        this.epx.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.cYa.getLayoutMode().setNightMode(i == 1);
        this.cYa.getLayoutMode().onModeChanged(this.mParent);
        am.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.j(this.mParent, d.C0140d.common_color_10041);
        am.c(this.aVO, d.C0140d.cp_cont_f, 1);
    }
}
