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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView aMS;
    private View aMT;
    private int dVi;
    private String dWB;
    private String dWC;
    private a.b dWG;
    private a.b dWH;
    private GroupAddressLocateActivity dWK;
    private View dWL;
    private TextView dWM;
    private ImageView dWN;
    private TextView dWO;
    private View dWP;
    private TextView dWQ;
    private ImageView dWR;
    private BdListView dWS;
    private AnimationDrawable dWT;
    private SettingTextSwitchView dWU;
    private m dWV;
    private com.baidu.tieba.im.util.b dWi;
    private String dWq;
    private String dWr;
    private boolean dWu;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.dVi = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dWK = null;
        this.aMS = null;
        this.aMT = null;
        this.dWL = null;
        this.dWM = null;
        this.dWN = null;
        this.dWO = null;
        this.dWP = null;
        this.dWQ = null;
        this.dWR = null;
        this.dWS = null;
        this.dWT = null;
        this.dWU = null;
        this.dWB = "";
        this.dWC = "";
        this.dWu = false;
        this.dWV = null;
        this.dWi = null;
        this.dWq = "";
        this.dWr = "";
        this.dWH = null;
        this.dWG = null;
        this.dWB = str;
        this.dWC = str2;
        this.dWu = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aCq() {
        this.dWi.Ja();
    }

    public void aCr() {
        if (this.dWi != null) {
            this.dWi.cancelLoad();
            this.dWi = null;
        }
    }

    public void aCF() {
        this.dWN.setVisibility(8);
    }

    public void aCG() {
        this.dWN.setVisibility(0);
    }

    public void aCC() {
        if (this.dWV != null) {
            this.dWV.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.dWK = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.i.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.dWM = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.dWL = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.dWL.setOnClickListener(this.dWK);
        this.dWN = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.dWB)) {
            stringBuffer.append(this.dWB);
        }
        if (!TextUtils.isEmpty(this.dWC)) {
            stringBuffer.append(this.dWC);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.dWL.setVisibility(0);
            this.dWM.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.dWL.setVisibility(8);
            this.dWM.setVisibility(8);
        }
        this.dWP = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.dWP.setOnClickListener(this.dWK);
        this.dWQ = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.dWR = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.dWR.setVisibility(8);
        this.dWO = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.dWS = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.dWS.setOnItemClickListener(this.dWK);
        this.dWU = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.dWu) {
            this.dWU.jO();
        } else {
            this.dWU.jP();
        }
        this.dWU.setSwitchStateChangeListener(this.dWK);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(d.k.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aMT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(d.k.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aMT.setOnClickListener(groupAddressLocateActivity);
        this.aMS.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.dWi = new com.baidu.tieba.im.util.b(this.dWK);
        this.dWi.setUniqueId(this.dWK.getUniqueId());
        aCq();
    }

    public void aCH() {
        this.dWO.setText(d.k.address_pos_list);
        this.dWQ.setText(d.k.location_loading);
        this.dWR.setVisibility(8);
        this.dVi = 3;
        aCJ();
    }

    public void aCI() {
        this.dWO.setText(d.k.address_locate_noaddresslist);
        this.dWQ.setText(d.k.address_locate_failed_tryagain);
        this.dWR.setVisibility(0);
        this.dVi = 2;
        aCJ();
    }

    public void u(String[] strArr) {
        this.dWP.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.dWO.setText(d.k.address_pos_list);
            this.dWV = new m(this.dWK, strArr);
            this.dWS.setAdapter((ListAdapter) this.dWV);
            this.dWS.setVisibility(0);
        } else {
            this.dWO.setText(d.k.address_locate_noaddresslist);
        }
        aCJ();
    }

    public void aBA() {
        this.dWO.setText(d.k.address_pos_list);
        this.dWQ.setText(d.k.address_locate_failed_opengps);
        this.dWR.setVisibility(0);
        this.dVi = 1;
        aCJ();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.dWQ.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.dWT = (AnimationDrawable) compoundDrawables[0];
            aCJ();
        }
    }

    private void aCJ() {
        if (this.dWT != null) {
            if (this.dVi == 3) {
                this.dWT.start();
                return;
            }
            this.dWT.stop();
            this.dWT.selectDrawable(0);
        }
    }

    public void nb(String str) {
        this.dWq = str;
    }

    public void nc(String str) {
        this.dWr = str;
    }

    public View aCB() {
        return this.aMS;
    }

    public View getBackButton() {
        return this.aMT;
    }

    public View aCK() {
        return this.dWL;
    }

    public View aCL() {
        return this.dWP;
    }

    public int aBy() {
        return this.dVi;
    }

    public void a(a.b bVar) {
        this.dWH = bVar;
    }

    public void b(a.b bVar) {
        this.dWG = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dWK.getPageContext().getPageActivity());
        aVar.ar(false);
        aVar.ca(d.k.group_update_alert_save);
        aVar.a(d.k.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.dWH != null) {
                    n.this.dWH.onClick(aVar2);
                }
            }
        });
        aVar.b(d.k.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.dWG != null) {
                    n.this.dWG.onClick(aVar2);
                }
            }
        });
        aVar.b(this.dWK.getPageContext());
        aVar.tC();
    }

    public void onChangeSkinType(int i) {
        this.dWK.getLayoutMode().setNightMode(i == 1);
        this.dWK.getLayoutMode().u(this.mParent);
        ak.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ak.j(this.mParent, d.C0126d.common_color_10041);
        ak.c(this.aMS, d.C0126d.cp_cont_f, 1);
    }
}
