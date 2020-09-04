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
    TextView eUp;
    private View eUq;
    TbPageContext<GroupAddressEditActivity> hHM;
    private boolean jlr;
    private TextView jlt;
    private String[] jlu;
    l jlv;
    NavigationBar mNavigationBar;
    View mParent;

    public View cDD() {
        return this.eUp;
    }

    public View getBackButton() {
        return this.eUq;
    }

    public k(TbPageContext<GroupAddressEditActivity> tbPageContext, String[] strArr, boolean z) {
        super(tbPageContext);
        this.mNavigationBar = null;
        this.mParent = null;
        this.hHM = null;
        this.eUp = null;
        this.eUq = null;
        this.Vo = null;
        this.jlt = null;
        this.jlu = null;
        this.jlr = false;
        this.jlv = null;
        this.jlu = strArr;
        this.jlr = z;
        b(tbPageContext.getOrignalPage());
        a(tbPageContext.getOrignalPage());
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.eUq.setOnClickListener(groupAddressEditActivity);
        this.eUp.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.hHM = groupAddressEditActivity.getPageContext();
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.mParent = groupAddressEditActivity.findViewById(R.id.parent);
        this.Vo = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.jlv = new l(groupAddressEditActivity, this.jlu);
        this.Vo.setAdapter((ListAdapter) this.jlv);
        this.Vo.setOnItemClickListener(groupAddressEditActivity);
        this.jlt = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.jlu == null || this.jlu.length < 1) {
            this.Vo.setVisibility(8);
            this.jlt.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(groupAddressEditActivity);
        if (this.jlr) {
            settingTextSwitchView.turnOn();
        } else {
            settingTextSwitchView.turnOff();
        }
        this.mNavigationBar = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eUq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eUp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
    }

    public void cDE() {
        this.jlv.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        this.hHM.getLayoutMode().setNightMode(i == 1);
        this.hHM.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.eUp, R.color.cp_cont_f, 1);
    }
}
