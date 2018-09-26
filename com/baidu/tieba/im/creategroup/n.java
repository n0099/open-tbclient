package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView aZd;
    private View aZe;
    private int evw;
    private String ewE;
    private String ewF;
    private boolean ewI;
    private String ewP;
    private String ewQ;
    private a.b ewU;
    private a.b ewV;
    private GroupAddressLocateActivity ewY;
    private View ewZ;
    private com.baidu.tieba.im.util.b eww;
    private TextView exa;
    private ImageView exb;
    private TextView exc;
    private View exd;
    private TextView exe;
    private ImageView exf;
    private BdListView exg;
    private AnimationDrawable exh;
    private SettingTextSwitchView exi;
    private m exj;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.evw = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.ewY = null;
        this.aZd = null;
        this.aZe = null;
        this.ewZ = null;
        this.exa = null;
        this.exb = null;
        this.exc = null;
        this.exd = null;
        this.exe = null;
        this.exf = null;
        this.exg = null;
        this.exh = null;
        this.exi = null;
        this.ewP = "";
        this.ewQ = "";
        this.ewI = false;
        this.exj = null;
        this.eww = null;
        this.ewE = "";
        this.ewF = "";
        this.ewV = null;
        this.ewU = null;
        this.ewP = str;
        this.ewQ = str2;
        this.ewI = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aLe() {
        this.eww.Og();
    }

    public void aLf() {
        if (this.eww != null) {
            this.eww.cancelLoad();
            this.eww = null;
        }
    }

    public void aLu() {
        this.exb.setVisibility(8);
    }

    public void aLv() {
        this.exb.setVisibility(0);
    }

    public void aLr() {
        if (this.exj != null) {
            this.exj.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.ewY = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(e.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(e.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(e.g.address_content_currentpos);
        this.exa = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_currentpos);
        this.ewZ = groupAddressLocateActivity.findViewById(e.g.address_content_container);
        this.ewZ.setOnClickListener(this.ewY);
        this.exb = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.ewP)) {
            stringBuffer.append(this.ewP);
        }
        if (!TextUtils.isEmpty(this.ewQ)) {
            stringBuffer.append(this.ewQ);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.ewZ.setVisibility(0);
            this.exa.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.ewZ.setVisibility(8);
            this.exa.setVisibility(8);
        }
        this.exd = groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_layout);
        this.exd.setOnClickListener(this.ewY);
        this.exe = (TextView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_textview);
        this.exf = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_rightarrow);
        this.exf.setVisibility(8);
        this.exc = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_poslist);
        this.exg = (BdListView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_addresslist_listview);
        this.exg.setOnItemClickListener(this.ewY);
        this.exi = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(e.g.address_showorhidden);
        if (this.ewI) {
            this.exi.nK();
        } else {
            this.exi.nL();
        }
        this.exi.setSwitchStateChangeListener(this.ewY);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aZe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aZd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(e.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aZe.setOnClickListener(groupAddressLocateActivity);
        this.aZd.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.eww = new com.baidu.tieba.im.util.b(this.ewY);
        this.eww.setUniqueId(this.ewY.getUniqueId());
        aLe();
    }

    public void aLw() {
        this.exc.setText(e.j.address_pos_list);
        this.exe.setText(e.j.location_loading);
        this.exf.setVisibility(8);
        this.evw = 3;
        aLy();
    }

    public void aLx() {
        this.exc.setText(e.j.address_locate_noaddresslist);
        this.exe.setText(e.j.address_locate_failed_tryagain);
        this.exf.setVisibility(0);
        this.evw = 2;
        aLy();
    }

    public void v(String[] strArr) {
        this.exd.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.exc.setText(e.j.address_pos_list);
            this.exj = new m(this.ewY, strArr);
            this.exg.setAdapter((ListAdapter) this.exj);
            this.exg.setVisibility(0);
        } else {
            this.exc.setText(e.j.address_locate_noaddresslist);
        }
        aLy();
    }

    public void aKo() {
        this.exc.setText(e.j.address_pos_list);
        this.exe.setText(e.j.address_locate_failed_opengps);
        this.exf.setVisibility(0);
        this.evw = 1;
        aLy();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.exe.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.exh = (AnimationDrawable) compoundDrawables[0];
            aLy();
        }
    }

    private void aLy() {
        if (this.exh != null) {
            if (this.evw == 3) {
                this.exh.start();
                return;
            }
            this.exh.stop();
            this.exh.selectDrawable(0);
        }
    }

    public void oz(String str) {
        this.ewE = str;
    }

    public void oA(String str) {
        this.ewF = str;
    }

    public View aLq() {
        return this.aZd;
    }

    public View getBackButton() {
        return this.aZe;
    }

    public View aLz() {
        return this.ewZ;
    }

    public View aLA() {
        return this.exd;
    }

    public int aKm() {
        return this.evw;
    }

    public void a(a.b bVar) {
        this.ewV = bVar;
    }

    public void b(a.b bVar) {
        this.ewU = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ewY.getPageContext().getPageActivity());
        aVar.aE(false);
        aVar.cp(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ewV != null) {
                    n.this.ewV.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ewU != null) {
                    n.this.ewU.onClick(aVar2);
                }
            }
        });
        aVar.b(this.ewY.getPageContext());
        aVar.yl();
    }

    public void onChangeSkinType(int i) {
        this.ewY.getLayoutMode().setNightMode(i == 1);
        this.ewY.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.aZd, e.d.cp_cont_f, 1);
    }
}
