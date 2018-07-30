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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView aVO;
    private View aVP;
    private int eoh;
    private String epA;
    private String epB;
    private a.b epF;
    private a.b epG;
    private GroupAddressLocateActivity epJ;
    private View epK;
    private TextView epL;
    private ImageView epM;
    private TextView epN;
    private View epO;
    private TextView epP;
    private ImageView epQ;
    private BdListView epR;
    private AnimationDrawable epS;
    private SettingTextSwitchView epT;
    private m epU;
    private com.baidu.tieba.im.util.b eph;
    private String epp;
    private String epq;
    private boolean ept;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.eoh = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.epJ = null;
        this.aVO = null;
        this.aVP = null;
        this.epK = null;
        this.epL = null;
        this.epM = null;
        this.epN = null;
        this.epO = null;
        this.epP = null;
        this.epQ = null;
        this.epR = null;
        this.epS = null;
        this.epT = null;
        this.epA = "";
        this.epB = "";
        this.ept = false;
        this.epU = null;
        this.eph = null;
        this.epp = "";
        this.epq = "";
        this.epG = null;
        this.epF = null;
        this.epA = str;
        this.epB = str2;
        this.ept = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aIS() {
        this.eph.MK();
    }

    public void aIT() {
        if (this.eph != null) {
            this.eph.cancelLoad();
            this.eph = null;
        }
    }

    public void aJi() {
        this.epM.setVisibility(8);
    }

    public void aJj() {
        this.epM.setVisibility(0);
    }

    public void aJf() {
        if (this.epU != null) {
            this.epU.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.epJ = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.epL = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.epK = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.epK.setOnClickListener(this.epJ);
        this.epM = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.epA)) {
            stringBuffer.append(this.epA);
        }
        if (!TextUtils.isEmpty(this.epB)) {
            stringBuffer.append(this.epB);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.epK.setVisibility(0);
            this.epL.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.epK.setVisibility(8);
            this.epL.setVisibility(8);
        }
        this.epO = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.epO.setOnClickListener(this.epJ);
        this.epP = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.epQ = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.epQ.setVisibility(8);
        this.epN = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.epR = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.epR.setOnItemClickListener(this.epJ);
        this.epT = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.ept) {
            this.epT.mE();
        } else {
            this.epT.mF();
        }
        this.epT.setSwitchStateChangeListener(this.epJ);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(d.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aVP.setOnClickListener(groupAddressLocateActivity);
        this.aVO.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.eph = new com.baidu.tieba.im.util.b(this.epJ);
        this.eph.setUniqueId(this.epJ.getUniqueId());
        aIS();
    }

    public void aJk() {
        this.epN.setText(d.j.address_pos_list);
        this.epP.setText(d.j.location_loading);
        this.epQ.setVisibility(8);
        this.eoh = 3;
        aJm();
    }

    public void aJl() {
        this.epN.setText(d.j.address_locate_noaddresslist);
        this.epP.setText(d.j.address_locate_failed_tryagain);
        this.epQ.setVisibility(0);
        this.eoh = 2;
        aJm();
    }

    public void u(String[] strArr) {
        this.epO.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.epN.setText(d.j.address_pos_list);
            this.epU = new m(this.epJ, strArr);
            this.epR.setAdapter((ListAdapter) this.epU);
            this.epR.setVisibility(0);
        } else {
            this.epN.setText(d.j.address_locate_noaddresslist);
        }
        aJm();
    }

    public void aIc() {
        this.epN.setText(d.j.address_pos_list);
        this.epP.setText(d.j.address_locate_failed_opengps);
        this.epQ.setVisibility(0);
        this.eoh = 1;
        aJm();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.epP.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.epS = (AnimationDrawable) compoundDrawables[0];
            aJm();
        }
    }

    private void aJm() {
        if (this.epS != null) {
            if (this.eoh == 3) {
                this.epS.start();
                return;
            }
            this.epS.stop();
            this.epS.selectDrawable(0);
        }
    }

    public void nQ(String str) {
        this.epp = str;
    }

    public void nR(String str) {
        this.epq = str;
    }

    public View aJe() {
        return this.aVO;
    }

    public View getBackButton() {
        return this.aVP;
    }

    public View aJn() {
        return this.epK;
    }

    public View aJo() {
        return this.epO;
    }

    public int aIa() {
        return this.eoh;
    }

    public void a(a.b bVar) {
        this.epG = bVar;
    }

    public void b(a.b bVar) {
        this.epF = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.epJ.getPageContext().getPageActivity());
        aVar.au(false);
        aVar.cf(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.epG != null) {
                    n.this.epG.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.epF != null) {
                    n.this.epF.onClick(aVar2);
                }
            }
        });
        aVar.b(this.epJ.getPageContext());
        aVar.xf();
    }

    public void onChangeSkinType(int i) {
        this.epJ.getLayoutMode().setNightMode(i == 1);
        this.epJ.getLayoutMode().onModeChanged(this.mParent);
        am.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.j(this.mParent, d.C0140d.common_color_10041);
        am.c(this.aVO, d.C0140d.cp_cont_f, 1);
    }
}
