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
/* loaded from: classes10.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView AG;
    TextView dGm;
    private View dGn;
    TbPageContext<GroupAddressEditActivity> geg;
    private boolean hyN;
    private TextView hyP;
    private String[] hyQ;
    l hyR;
    NavigationBar mNavigationBar;
    View mParent;

    public View bUk() {
        return this.dGm;
    }

    public View getBackButton() {
        return this.dGn;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.geg = null;
        this.dGm = null;
        this.dGn = null;
        this.AG = null;
        this.hyP = null;
        this.hyQ = null;
        this.hyN = false;
        this.hyR = null;
        this.hyQ = strArr;
        this.hyN = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.dGn.setOnClickListener(groupAddressEditActivity);
        this.dGm.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.geg = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.AG = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.hyR = new l(groupAddressEditActivity, this.hyQ);
        this.AG.setAdapter((ListAdapter) this.hyR);
        this.AG.setOnItemClickListener(groupAddressEditActivity);
        this.hyP = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.hyQ == null || this.hyQ.length < 1) {
            this.AG.setVisibility(8);
            this.hyP.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.hyN) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dGn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dGm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bUl() {
        this.hyR.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.geg.getLayoutMode().setNightMode(i == 1);
        this.geg.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dGm, R.color.cp_cont_f, 1);
    }
}
