package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView MS;
    TextView cAM;
    private View cAN;
    TbPageContext<GroupAddressEditActivity> fao;
    private boolean gxn;
    private TextView gxp;
    private String[] gxq;
    l gxr;
    NavigationBar mNavigationBar;
    View mParent;

    public View bzy() {
        return this.cAM;
    }

    public View getBackButton() {
        return this.cAN;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.fao = null;
        this.cAM = null;
        this.cAN = null;
        this.MS = null;
        this.gxp = null;
        this.gxq = null;
        this.gxn = false;
        this.gxr = null;
        this.gxq = strArr;
        this.gxn = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.cAN.setOnClickListener(groupAddressEditActivity);
        this.cAM.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.fao = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.MS = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.gxr = new l(groupAddressEditActivity, this.gxq);
        this.MS.setAdapter((ListAdapter) this.gxr);
        this.MS.setOnItemClickListener(groupAddressEditActivity);
        this.gxp = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.gxq == null || this.gxq.length < 1) {
            this.MS.setVisibility(8);
            this.gxp.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.gxn) {
            settingTextSwitchView.mV();
        } else {
            settingTextSwitchView.mW();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cAN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cAM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bzz() {
        this.gxr.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.fao.getLayoutMode().setNightMode(i == 1);
        this.fao.getLayoutMode().onModeChanged(this.mParent);
        al.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.l(this.mParent, R.color.common_color_10041);
        al.f(this.cAM, R.color.cp_cont_f, 1);
    }
}
