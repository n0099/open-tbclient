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
    BdListView Um;
    TextView eum;
    private View eun;
    TbPageContext<GroupAddressEditActivity> hct;
    private boolean iyc;
    private TextView iye;
    private String[] iyf;
    l iyg;
    NavigationBar mNavigationBar;
    View mParent;

    public View clq() {
        return this.eum;
    }

    public View getBackButton() {
        return this.eun;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.hct = null;
        this.eum = null;
        this.eun = null;
        this.Um = null;
        this.iye = null;
        this.iyf = null;
        this.iyc = false;
        this.iyg = null;
        this.iyf = strArr;
        this.iyc = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.eun.setOnClickListener(groupAddressEditActivity);
        this.eum.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.hct = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.Um = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.iyg = new l(groupAddressEditActivity, this.iyf);
        this.Um.setAdapter((ListAdapter) this.iyg);
        this.Um.setOnItemClickListener(groupAddressEditActivity);
        this.iye = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.iyf == null || this.iyf.length < 1) {
            this.Um.setVisibility(8);
            this.iye.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.iyc) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eum = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void clr() {
        this.iyg.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.hct.getLayoutMode().setNightMode(i == 1);
        this.hct.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.eum, R.color.cp_cont_f, 1);
    }
}
