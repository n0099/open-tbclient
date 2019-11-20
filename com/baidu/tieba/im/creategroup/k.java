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
    private View cNA;
    TextView cNz;
    TbPageContext<GroupAddressEditActivity> fjz;
    private boolean gDs;
    private TextView gDu;
    private String[] gDv;
    l gDw;
    NavigationBar mNavigationBar;
    View mParent;
    BdListView xL;

    public View bzP() {
        return this.cNz;
    }

    public View getBackButton() {
        return this.cNA;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.fjz = null;
        this.cNz = null;
        this.cNA = null;
        this.xL = null;
        this.gDu = null;
        this.gDv = null;
        this.gDs = false;
        this.gDw = null;
        this.gDv = strArr;
        this.gDs = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.cNA.setOnClickListener(groupAddressEditActivity);
        this.cNz.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.fjz = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.xL = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.gDw = new l(groupAddressEditActivity, this.gDv);
        this.xL.setAdapter((ListAdapter) this.gDw);
        this.xL.setOnItemClickListener(groupAddressEditActivity);
        this.gDu = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.gDv == null || this.gDv.length < 1) {
            this.xL.setVisibility(8);
            this.gDu.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.gDs) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cNA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cNz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bzQ() {
        this.gDw.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.fjz.getLayoutMode().setNightMode(i == 1);
        this.fjz.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.cNz, R.color.cp_cont_f, 1);
    }
}
