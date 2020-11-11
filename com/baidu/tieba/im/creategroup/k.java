package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView VY;
    TextView fxI;
    private View fxJ;
    TbPageContext<GroupAddressEditActivity> iwh;
    private boolean kbo;
    private TextView kbq;
    private String[] kbr;
    l kbs;
    NavigationBar mNavigationBar;
    View mParent;

    public View cQA() {
        return this.fxI;
    }

    public View getBackButton() {
        return this.fxJ;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.iwh = null;
        this.fxI = null;
        this.fxJ = null;
        this.VY = null;
        this.kbq = null;
        this.kbr = null;
        this.kbo = false;
        this.kbs = null;
        this.kbr = strArr;
        this.kbo = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.fxJ.setOnClickListener(groupAddressEditActivity);
        this.fxI.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.iwh = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.VY = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.kbs = new l(groupAddressEditActivity, this.kbr);
        this.VY.setAdapter((ListAdapter) this.kbs);
        this.VY.setOnItemClickListener(groupAddressEditActivity);
        this.kbq = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.kbr == null || this.kbr.length < 1) {
            this.VY.setVisibility(8);
            this.kbq.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.kbo) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.fxJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fxI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void cQB() {
        this.kbs.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.iwh.getLayoutMode().setNightMode(i == 1);
        this.iwh.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.fxI, R.color.cp_cont_f, 1);
    }
}
