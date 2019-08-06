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
    TextView cCl;
    private View cCm;
    TbPageContext<GroupAddressEditActivity> ffP;
    private boolean gEs;
    private TextView gEu;
    private String[] gEv;
    l gEw;
    NavigationBar mNavigationBar;
    View mParent;

    public View bCs() {
        return this.cCl;
    }

    public View getBackButton() {
        return this.cCm;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.ffP = null;
        this.cCl = null;
        this.cCm = null;
        this.Ni = null;
        this.gEu = null;
        this.gEv = null;
        this.gEs = false;
        this.gEw = null;
        this.gEv = strArr;
        this.gEs = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.cCm.setOnClickListener(groupAddressEditActivity);
        this.cCl.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.ffP = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.Ni = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.gEw = new l(groupAddressEditActivity, this.gEv);
        this.Ni.setAdapter((ListAdapter) this.gEw);
        this.Ni.setOnItemClickListener(groupAddressEditActivity);
        this.gEu = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.gEv == null || this.gEv.length < 1) {
            this.Ni.setVisibility(8);
            this.gEu.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.gEs) {
            settingTextSwitchView.nm();
        } else {
            settingTextSwitchView.nn();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cCm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cCl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bCt() {
        this.gEw.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.ffP.getLayoutMode().setNightMode(i == 1);
        this.ffP.getLayoutMode().onModeChanged(this.mParent);
        am.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.l(this.mParent, R.color.common_color_10041);
        am.f(this.cCl, R.color.cp_cont_f, 1);
    }
}
