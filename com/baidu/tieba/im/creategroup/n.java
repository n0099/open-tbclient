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
    private TextView bhU;
    private View bhV;
    private int eOk;
    private String ePD;
    private String ePE;
    private a.b ePI;
    private a.b ePJ;
    private GroupAddressLocateActivity ePM;
    private View ePN;
    private TextView ePO;
    private ImageView ePP;
    private TextView ePQ;
    private View ePR;
    private TextView ePS;
    private ImageView ePT;
    private BdListView ePU;
    private AnimationDrawable ePV;
    private SettingTextSwitchView ePW;
    private m ePX;
    private com.baidu.tieba.im.util.b ePk;
    private String ePs;
    private String ePt;
    private boolean ePw;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.eOk = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.ePM = null;
        this.bhU = null;
        this.bhV = null;
        this.ePN = null;
        this.ePO = null;
        this.ePP = null;
        this.ePQ = null;
        this.ePR = null;
        this.ePS = null;
        this.ePT = null;
        this.ePU = null;
        this.ePV = null;
        this.ePW = null;
        this.ePD = "";
        this.ePE = "";
        this.ePw = false;
        this.ePX = null;
        this.ePk = null;
        this.ePs = "";
        this.ePt = "";
        this.ePJ = null;
        this.ePI = null;
        this.ePD = str;
        this.ePE = str2;
        this.ePw = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aQv() {
        this.ePk.Rt();
    }

    public void aQw() {
        if (this.ePk != null) {
            this.ePk.cancelLoad();
            this.ePk = null;
        }
    }

    public void aQL() {
        this.ePP.setVisibility(8);
    }

    public void aQM() {
        this.ePP.setVisibility(0);
    }

    public void aQI() {
        if (this.ePX != null) {
            this.ePX.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.ePM = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(e.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(e.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(e.g.address_content_currentpos);
        this.ePO = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_currentpos);
        this.ePN = groupAddressLocateActivity.findViewById(e.g.address_content_container);
        this.ePN.setOnClickListener(this.ePM);
        this.ePP = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.ePD)) {
            stringBuffer.append(this.ePD);
        }
        if (!TextUtils.isEmpty(this.ePE)) {
            stringBuffer.append(this.ePE);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.ePN.setVisibility(0);
            this.ePO.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.ePN.setVisibility(8);
            this.ePO.setVisibility(8);
        }
        this.ePR = groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_layout);
        this.ePR.setOnClickListener(this.ePM);
        this.ePS = (TextView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_textview);
        this.ePT = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_rightarrow);
        this.ePT.setVisibility(8);
        this.ePQ = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_poslist);
        this.ePU = (BdListView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_addresslist_listview);
        this.ePU.setOnItemClickListener(this.ePM);
        this.ePW = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(e.g.address_showorhidden);
        if (this.ePw) {
            this.ePW.nR();
        } else {
            this.ePW.nS();
        }
        this.ePW.setSwitchStateChangeListener(this.ePM);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bhV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bhU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(e.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.bhV.setOnClickListener(groupAddressLocateActivity);
        this.bhU.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.ePk = new com.baidu.tieba.im.util.b(this.ePM);
        this.ePk.setUniqueId(this.ePM.getUniqueId());
        aQv();
    }

    public void aQN() {
        this.ePQ.setText(e.j.address_pos_list);
        this.ePS.setText(e.j.location_loading);
        this.ePT.setVisibility(8);
        this.eOk = 3;
        aQP();
    }

    public void aQO() {
        this.ePQ.setText(e.j.address_locate_noaddresslist);
        this.ePS.setText(e.j.address_locate_failed_tryagain);
        this.ePT.setVisibility(0);
        this.eOk = 2;
        aQP();
    }

    public void y(String[] strArr) {
        this.ePR.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.ePQ.setText(e.j.address_pos_list);
            this.ePX = new m(this.ePM, strArr);
            this.ePU.setAdapter((ListAdapter) this.ePX);
            this.ePU.setVisibility(0);
        } else {
            this.ePQ.setText(e.j.address_locate_noaddresslist);
        }
        aQP();
    }

    public void aPG() {
        this.ePQ.setText(e.j.address_pos_list);
        this.ePS.setText(e.j.address_locate_failed_opengps);
        this.ePT.setVisibility(0);
        this.eOk = 1;
        aQP();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.ePS.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.ePV = (AnimationDrawable) compoundDrawables[0];
            aQP();
        }
    }

    private void aQP() {
        if (this.ePV != null) {
            if (this.eOk == 3) {
                this.ePV.start();
                return;
            }
            this.ePV.stop();
            this.ePV.selectDrawable(0);
        }
    }

    public void pH(String str) {
        this.ePs = str;
    }

    public void pI(String str) {
        this.ePt = str;
    }

    public View aQH() {
        return this.bhU;
    }

    public View getBackButton() {
        return this.bhV;
    }

    public View aQQ() {
        return this.ePN;
    }

    public View aQR() {
        return this.ePR;
    }

    public int aPE() {
        return this.eOk;
    }

    public void a(a.b bVar) {
        this.ePJ = bVar;
    }

    public void b(a.b bVar) {
        this.ePI = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ePM.getPageContext().getPageActivity());
        aVar.bf(false);
        aVar.db(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ePJ != null) {
                    n.this.ePJ.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ePI != null) {
                    n.this.ePI.onClick(aVar2);
                }
            }
        });
        aVar.b(this.ePM.getPageContext());
        aVar.BF();
    }

    public void onChangeSkinType(int i) {
        this.ePM.getLayoutMode().setNightMode(i == 1);
        this.ePM.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.bhU, e.d.cp_cont_f, 1);
    }
}
