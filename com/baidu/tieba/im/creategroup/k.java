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
    BdListView Nj;
    TextView cDh;
    private View cDi;
    TbPageContext<GroupAddressEditActivity> fhC;
    private boolean gGk;
    private TextView gGm;
    private String[] gGn;
    l gGo;
    NavigationBar mNavigationBar;
    View mParent;

    public View bDg() {
        return this.cDh;
    }

    public View getBackButton() {
        return this.cDi;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.fhC = null;
        this.cDh = null;
        this.cDi = null;
        this.Nj = null;
        this.gGm = null;
        this.gGn = null;
        this.gGk = false;
        this.gGo = null;
        this.gGn = strArr;
        this.gGk = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.cDi.setOnClickListener(groupAddressEditActivity);
        this.cDh.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.fhC = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.Nj = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.gGo = new l(groupAddressEditActivity, this.gGn);
        this.Nj.setAdapter((ListAdapter) this.gGo);
        this.Nj.setOnItemClickListener(groupAddressEditActivity);
        this.gGm = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.gGn == null || this.gGn.length < 1) {
            this.Nj.setVisibility(8);
            this.gGm.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.gGk) {
            settingTextSwitchView.nm();
        } else {
            settingTextSwitchView.nn();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cDi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cDh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void bDh() {
        this.gGo.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.fhC.getLayoutMode().setNightMode(i == 1);
        this.fhC.getLayoutMode().onModeChanged(this.mParent);
        am.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.l(this.mParent, R.color.common_color_10041);
        am.f(this.cDh, R.color.cp_cont_f, 1);
    }
}
