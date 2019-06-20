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
    BdListView MR;
    TextView cAN;
    private View cAO;
    TbPageContext<GroupAddressEditActivity> fao;
    private boolean gxp;
    private TextView gxr;
    private String[] gxs;
    l gxt;
    NavigationBar mNavigationBar;
    View mParent;

    public View bzz() {
        return this.cAN;
    }

    public View getBackButton() {
        return this.cAO;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.fao = null;
        this.cAN = null;
        this.cAO = null;
        this.MR = null;
        this.gxr = null;
        this.gxs = null;
        this.gxp = false;
        this.gxt = null;
        this.gxs = strArr;
        this.gxp = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.cAO.setOnClickListener(groupAddressEditActivity);
        this.cAN.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.fao = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.MR = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.gxt = new l(groupAddressEditActivity, this.gxs);
        this.MR.setAdapter((ListAdapter) this.gxt);
        this.MR.setOnItemClickListener(groupAddressEditActivity);
        this.gxr = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.gxs == null || this.gxs.length < 1) {
            this.MR.setVisibility(8);
            this.gxr.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.gxp) {
            settingTextSwitchView.mV();
        } else {
            settingTextSwitchView.mW();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cAO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cAN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bzA() {
        this.gxt.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.fao.getLayoutMode().setNightMode(i == 1);
        this.fao.getLayoutMode().onModeChanged(this.mParent);
        al.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.l(this.mParent, R.color.common_color_10041);
        al.f(this.cAN, R.color.cp_cont_f, 1);
    }
}
