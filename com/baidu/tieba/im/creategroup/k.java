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
    TextView cOq;
    private View cOr;
    TbPageContext<GroupAddressEditActivity> fkq;
    private boolean gEj;
    private TextView gEl;
    private String[] gEm;
    l gEn;
    NavigationBar mNavigationBar;
    View mParent;
    BdListView yl;

    public View bzR() {
        return this.cOq;
    }

    public View getBackButton() {
        return this.cOr;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.fkq = null;
        this.cOq = null;
        this.cOr = null;
        this.yl = null;
        this.gEl = null;
        this.gEm = null;
        this.gEj = false;
        this.gEn = null;
        this.gEm = strArr;
        this.gEj = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.cOr.setOnClickListener(groupAddressEditActivity);
        this.cOq.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.fkq = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.yl = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.gEn = new l(groupAddressEditActivity, this.gEm);
        this.yl.setAdapter((ListAdapter) this.gEn);
        this.yl.setOnItemClickListener(groupAddressEditActivity);
        this.gEl = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.gEm == null || this.gEm.length < 1) {
            this.yl.setVisibility(8);
            this.gEl.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.gEj) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cOr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cOq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bzS() {
        this.gEn.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.fkq.getLayoutMode().setNightMode(i == 1);
        this.fkq.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.cOq, R.color.cp_cont_f, 1);
    }
}
