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
/* loaded from: classes17.dex */
public class k extends com.baidu.adp.base.c<GroupAddressEditActivity> {
    BdListView Vo;
    TextView eUl;
    private View eUm;
    TbPageContext<GroupAddressEditActivity> hHG;
    private boolean jll;
    private TextView jln;
    private String[] jlo;
    l jlp;
    NavigationBar mNavigationBar;
    View mParent;

    public View cDC() {
        return this.eUl;
    }

    public View getBackButton() {
        return this.eUm;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.hHG = null;
        this.eUl = null;
        this.eUm = null;
        this.Vo = null;
        this.jln = null;
        this.jlo = null;
        this.jll = false;
        this.jlp = null;
        this.jlo = strArr;
        this.jll = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.eUm.setOnClickListener(groupAddressEditActivity);
        this.eUl.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.hHG = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.Vo = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.jlp = new l(groupAddressEditActivity, this.jlo);
        this.Vo.setAdapter((ListAdapter) this.jlp);
        this.Vo.setOnItemClickListener(groupAddressEditActivity);
        this.jln = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.jlo == null || this.jlo.length < 1) {
            this.Vo.setVisibility(8);
            this.jln.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.jll) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eUm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eUl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void cDD() {
        this.jlp.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.hHG.getLayoutMode().setNightMode(i == 1);
        this.hHG.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.eUl, R.color.cp_cont_f, 1);
    }
}
