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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView aUQ;
    private View aUR;
    private int egv;
    private String ehD;
    private String ehE;
    private boolean ehH;
    private String ehO;
    private String ehP;
    private a.b ehT;
    private a.b ehU;
    private GroupAddressLocateActivity ehX;
    private View ehY;
    private TextView ehZ;
    private com.baidu.tieba.im.util.b ehv;
    private ImageView eia;
    private TextView eib;
    private View eic;
    private TextView eid;
    private ImageView eie;
    private BdListView eif;
    private AnimationDrawable eig;
    private SettingTextSwitchView eih;
    private m eii;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.egv = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.ehX = null;
        this.aUQ = null;
        this.aUR = null;
        this.ehY = null;
        this.ehZ = null;
        this.eia = null;
        this.eib = null;
        this.eic = null;
        this.eid = null;
        this.eie = null;
        this.eif = null;
        this.eig = null;
        this.eih = null;
        this.ehO = "";
        this.ehP = "";
        this.ehH = false;
        this.eii = null;
        this.ehv = null;
        this.ehD = "";
        this.ehE = "";
        this.ehU = null;
        this.ehT = null;
        this.ehO = str;
        this.ehP = str2;
        this.ehH = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aHl() {
        this.ehv.Mw();
    }

    public void aHm() {
        if (this.ehv != null) {
            this.ehv.cancelLoad();
            this.ehv = null;
        }
    }

    public void aHA() {
        this.eia.setVisibility(8);
    }

    public void aHB() {
        this.eia.setVisibility(0);
    }

    public void aHx() {
        if (this.eii != null) {
            this.eii.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.ehX = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.i.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.ehZ = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.ehY = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.ehY.setOnClickListener(this.ehX);
        this.eia = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.ehO)) {
            stringBuffer.append(this.ehO);
        }
        if (!TextUtils.isEmpty(this.ehP)) {
            stringBuffer.append(this.ehP);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.ehY.setVisibility(0);
            this.ehZ.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.ehY.setVisibility(8);
            this.ehZ.setVisibility(8);
        }
        this.eic = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.eic.setOnClickListener(this.ehX);
        this.eid = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.eie = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.eie.setVisibility(8);
        this.eib = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.eif = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.eif.setOnItemClickListener(this.ehX);
        this.eih = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.ehH) {
            this.eih.mC();
        } else {
            this.eih.mD();
        }
        this.eih.setSwitchStateChangeListener(this.ehX);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(d.k.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aUR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(d.k.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aUR.setOnClickListener(groupAddressLocateActivity);
        this.aUQ.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.ehv = new com.baidu.tieba.im.util.b(this.ehX);
        this.ehv.setUniqueId(this.ehX.getUniqueId());
        aHl();
    }

    public void aHC() {
        this.eib.setText(d.k.address_pos_list);
        this.eid.setText(d.k.location_loading);
        this.eie.setVisibility(8);
        this.egv = 3;
        aHE();
    }

    public void aHD() {
        this.eib.setText(d.k.address_locate_noaddresslist);
        this.eid.setText(d.k.address_locate_failed_tryagain);
        this.eie.setVisibility(0);
        this.egv = 2;
        aHE();
    }

    public void u(String[] strArr) {
        this.eic.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.eib.setText(d.k.address_pos_list);
            this.eii = new m(this.ehX, strArr);
            this.eif.setAdapter((ListAdapter) this.eii);
            this.eif.setVisibility(0);
        } else {
            this.eib.setText(d.k.address_locate_noaddresslist);
        }
        aHE();
    }

    public void aGv() {
        this.eib.setText(d.k.address_pos_list);
        this.eid.setText(d.k.address_locate_failed_opengps);
        this.eie.setVisibility(0);
        this.egv = 1;
        aHE();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.eid.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.eig = (AnimationDrawable) compoundDrawables[0];
            aHE();
        }
    }

    private void aHE() {
        if (this.eig != null) {
            if (this.egv == 3) {
                this.eig.start();
                return;
            }
            this.eig.stop();
            this.eig.selectDrawable(0);
        }
    }

    public void nN(String str) {
        this.ehD = str;
    }

    public void nO(String str) {
        this.ehE = str;
    }

    public View aHw() {
        return this.aUQ;
    }

    public View getBackButton() {
        return this.aUR;
    }

    public View aHF() {
        return this.ehY;
    }

    public View aHG() {
        return this.eic;
    }

    public int aGt() {
        return this.egv;
    }

    public void a(a.b bVar) {
        this.ehU = bVar;
    }

    public void b(a.b bVar) {
        this.ehT = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehX.getPageContext().getPageActivity());
        aVar.au(false);
        aVar.cc(d.k.group_update_alert_save);
        aVar.a(d.k.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ehU != null) {
                    n.this.ehU.onClick(aVar2);
                }
            }
        });
        aVar.b(d.k.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ehT != null) {
                    n.this.ehT.onClick(aVar2);
                }
            }
        });
        aVar.b(this.ehX.getPageContext());
        aVar.xa();
    }

    public void onChangeSkinType(int i) {
        this.ehX.getLayoutMode().setNightMode(i == 1);
        this.ehX.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, d.C0141d.common_color_10041);
        al.c(this.aUQ, d.C0141d.cp_cont_f, 1);
    }
}
