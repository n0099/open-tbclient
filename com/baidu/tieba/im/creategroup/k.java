package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView Ni;
    TextView cCe;
    private View cCf;
    TbPageContext<GroupAddressEditActivity> ffp;
    private boolean gDA;
    private TextView gDC;
    private String[] gDD;
    l gDE;
    NavigationBar mNavigationBar;
    View mParent;

    public View bCe() {
        return this.cCe;
    }

    public View getBackButton() {
        return this.cCf;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.ffp = null;
        this.cCe = null;
        this.cCf = null;
        this.Ni = null;
        this.gDC = null;
        this.gDD = null;
        this.gDA = false;
        this.gDE = null;
        this.gDD = strArr;
        this.gDA = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.cCf.setOnClickListener(groupAddressEditActivity);
        this.cCe.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.ffp = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.Ni = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.gDE = new l(groupAddressEditActivity, this.gDD);
        this.Ni.setAdapter((ListAdapter) this.gDE);
        this.Ni.setOnItemClickListener(groupAddressEditActivity);
        this.gDC = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.gDD == null || this.gDD.length < 1) {
            this.Ni.setVisibility(8);
            this.gDC.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.gDA) {
            settingTextSwitchView.nm();
        } else {
            settingTextSwitchView.nn();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cCf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cCe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bCf() {
        this.gDE.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.ffp.getLayoutMode().setNightMode(i == 1);
        this.ffp.getLayoutMode().onModeChanged(this.mParent);
        am.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.l(this.mParent, R.color.common_color_10041);
        am.f(this.cCe, R.color.cp_cont_f, 1);
    }
}
