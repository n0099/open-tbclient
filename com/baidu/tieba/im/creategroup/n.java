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
    private TextView bdD;
    private View bdE;
    private int eDk;
    private String eED;
    private String eEE;
    private a.b eEI;
    private a.b eEJ;
    private GroupAddressLocateActivity eEM;
    private View eEN;
    private TextView eEO;
    private ImageView eEP;
    private TextView eEQ;
    private View eER;
    private TextView eES;
    private ImageView eET;
    private BdListView eEU;
    private AnimationDrawable eEV;
    private SettingTextSwitchView eEW;
    private m eEX;
    private com.baidu.tieba.im.util.b eEk;
    private String eEs;
    private String eEt;
    private boolean eEw;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.eDk = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eEM = null;
        this.bdD = null;
        this.bdE = null;
        this.eEN = null;
        this.eEO = null;
        this.eEP = null;
        this.eEQ = null;
        this.eER = null;
        this.eES = null;
        this.eET = null;
        this.eEU = null;
        this.eEV = null;
        this.eEW = null;
        this.eED = "";
        this.eEE = "";
        this.eEw = false;
        this.eEX = null;
        this.eEk = null;
        this.eEs = "";
        this.eEt = "";
        this.eEJ = null;
        this.eEI = null;
        this.eED = str;
        this.eEE = str2;
        this.eEw = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aOt() {
        this.eEk.Qc();
    }

    public void aOu() {
        if (this.eEk != null) {
            this.eEk.cancelLoad();
            this.eEk = null;
        }
    }

    public void aOJ() {
        this.eEP.setVisibility(8);
    }

    public void aOK() {
        this.eEP.setVisibility(0);
    }

    public void aOG() {
        if (this.eEX != null) {
            this.eEX.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eEM = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(e.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(e.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(e.g.address_content_currentpos);
        this.eEO = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_currentpos);
        this.eEN = groupAddressLocateActivity.findViewById(e.g.address_content_container);
        this.eEN.setOnClickListener(this.eEM);
        this.eEP = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.eED)) {
            stringBuffer.append(this.eED);
        }
        if (!TextUtils.isEmpty(this.eEE)) {
            stringBuffer.append(this.eEE);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.eEN.setVisibility(0);
            this.eEO.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.eEN.setVisibility(8);
            this.eEO.setVisibility(8);
        }
        this.eER = groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_layout);
        this.eER.setOnClickListener(this.eEM);
        this.eES = (TextView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_textview);
        this.eET = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_rightarrow);
        this.eET.setVisibility(8);
        this.eEQ = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_poslist);
        this.eEU = (BdListView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_addresslist_listview);
        this.eEU.setOnItemClickListener(this.eEM);
        this.eEW = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(e.g.address_showorhidden);
        if (this.eEw) {
            this.eEW.nU();
        } else {
            this.eEW.nV();
        }
        this.eEW.setSwitchStateChangeListener(this.eEM);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bdE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bdD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(e.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.bdE.setOnClickListener(groupAddressLocateActivity);
        this.bdD.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.eEk = new com.baidu.tieba.im.util.b(this.eEM);
        this.eEk.setUniqueId(this.eEM.getUniqueId());
        aOt();
    }

    public void aOL() {
        this.eEQ.setText(e.j.address_pos_list);
        this.eES.setText(e.j.location_loading);
        this.eET.setVisibility(8);
        this.eDk = 3;
        aON();
    }

    public void aOM() {
        this.eEQ.setText(e.j.address_locate_noaddresslist);
        this.eES.setText(e.j.address_locate_failed_tryagain);
        this.eET.setVisibility(0);
        this.eDk = 2;
        aON();
    }

    public void w(String[] strArr) {
        this.eER.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.eEQ.setText(e.j.address_pos_list);
            this.eEX = new m(this.eEM, strArr);
            this.eEU.setAdapter((ListAdapter) this.eEX);
            this.eEU.setVisibility(0);
        } else {
            this.eEQ.setText(e.j.address_locate_noaddresslist);
        }
        aON();
    }

    public void aNE() {
        this.eEQ.setText(e.j.address_pos_list);
        this.eES.setText(e.j.address_locate_failed_opengps);
        this.eET.setVisibility(0);
        this.eDk = 1;
        aON();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.eES.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.eEV = (AnimationDrawable) compoundDrawables[0];
            aON();
        }
    }

    private void aON() {
        if (this.eEV != null) {
            if (this.eDk == 3) {
                this.eEV.start();
                return;
            }
            this.eEV.stop();
            this.eEV.selectDrawable(0);
        }
    }

    public void pb(String str) {
        this.eEs = str;
    }

    public void pc(String str) {
        this.eEt = str;
    }

    public View aOF() {
        return this.bdD;
    }

    public View getBackButton() {
        return this.bdE;
    }

    public View aOO() {
        return this.eEN;
    }

    public View aOP() {
        return this.eER;
    }

    public int aNC() {
        return this.eDk;
    }

    public void a(a.b bVar) {
        this.eEJ = bVar;
    }

    public void b(a.b bVar) {
        this.eEI = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eEM.getPageContext().getPageActivity());
        aVar.aO(false);
        aVar.cz(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eEJ != null) {
                    n.this.eEJ.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eEI != null) {
                    n.this.eEI.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eEM.getPageContext());
        aVar.Au();
    }

    public void onChangeSkinType(int i) {
        this.eEM.getLayoutMode().setNightMode(i == 1);
        this.eEM.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.bdD, e.d.cp_cont_f, 1);
    }
}
