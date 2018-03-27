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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class o extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView bCr;
    private View bCs;
    private com.baidu.tieba.im.util.b eAA;
    private String eAI;
    private String eAJ;
    private boolean eAM;
    private String eAT;
    private String eAU;
    private a.b eAY;
    private a.b eAZ;
    private GroupAddressLocateActivity eBc;
    private View eBd;
    private TextView eBe;
    private ImageView eBf;
    private TextView eBg;
    private View eBh;
    private TextView eBi;
    private ImageView eBj;
    private BdListView eBk;
    private AnimationDrawable eBl;
    private SettingTextSwitchView eBm;
    private n eBn;
    private int ezA;
    private NavigationBar mNavigationBar;
    private View mParent;

    public o(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.ezA = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eBc = null;
        this.bCr = null;
        this.bCs = null;
        this.eBd = null;
        this.eBe = null;
        this.eBf = null;
        this.eBg = null;
        this.eBh = null;
        this.eBi = null;
        this.eBj = null;
        this.eBk = null;
        this.eBl = null;
        this.eBm = null;
        this.eAT = "";
        this.eAU = "";
        this.eAM = false;
        this.eBn = null;
        this.eAA = null;
        this.eAI = "";
        this.eAJ = "";
        this.eAZ = null;
        this.eAY = null;
        this.eAT = str;
        this.eAU = str2;
        this.eAM = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aHs() {
        this.eAA.QA();
    }

    public void aHt() {
        if (this.eAA != null) {
            this.eAA.dE();
            this.eAA = null;
        }
    }

    public void aHI() {
        this.eBf.setVisibility(8);
    }

    public void aHJ() {
        this.eBf.setVisibility(0);
    }

    public void aHF() {
        if (this.eBn != null) {
            this.eBn.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eBc = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.eBe = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.eBd = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.eBd.setOnClickListener(this.eBc);
        this.eBf = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.eAT)) {
            stringBuffer.append(this.eAT);
        }
        if (!TextUtils.isEmpty(this.eAU)) {
            stringBuffer.append(this.eAU);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.eBd.setVisibility(0);
            this.eBe.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.eBd.setVisibility(8);
            this.eBe.setVisibility(8);
        }
        this.eBh = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.eBh.setOnClickListener(this.eBc);
        this.eBi = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.eBj = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.eBj.setVisibility(8);
        this.eBg = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.eBk = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.eBk.setOnItemClickListener(this.eBc);
        this.eBm = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.eAM) {
            this.eBm.rJ();
        } else {
            this.eBm.rK();
        }
        this.eBm.setSwitchStateChangeListener(this.eBc);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bCs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(d.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.bCs.setOnClickListener(groupAddressLocateActivity);
        this.bCr.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.eAA = new com.baidu.tieba.im.util.b(this.eBc);
        this.eAA.setUniqueId(this.eBc.getUniqueId());
        aHs();
    }

    public void aHK() {
        this.eBg.setText(d.j.address_pos_list);
        this.eBi.setText(d.j.location_loading);
        this.eBj.setVisibility(8);
        this.ezA = 3;
        aHM();
    }

    public void aHL() {
        this.eBg.setText(d.j.address_locate_noaddresslist);
        this.eBi.setText(d.j.address_locate_failed_tryagain);
        this.eBj.setVisibility(0);
        this.ezA = 2;
        aHM();
    }

    public void s(String[] strArr) {
        this.eBh.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.eBg.setText(d.j.address_pos_list);
            this.eBn = new n(this.eBc, strArr);
            this.eBk.setAdapter((ListAdapter) this.eBn);
            this.eBk.setVisibility(0);
        } else {
            this.eBg.setText(d.j.address_locate_noaddresslist);
        }
        aHM();
    }

    public void aGC() {
        this.eBg.setText(d.j.address_pos_list);
        this.eBi.setText(d.j.address_locate_failed_opengps);
        this.eBj.setVisibility(0);
        this.ezA = 1;
        aHM();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.eBi.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.eBl = (AnimationDrawable) compoundDrawables[0];
            aHM();
        }
    }

    private void aHM() {
        if (this.eBl != null) {
            if (this.ezA == 3) {
                this.eBl.start();
                return;
            }
            this.eBl.stop();
            this.eBl.selectDrawable(0);
        }
    }

    public void mU(String str) {
        this.eAI = str;
    }

    public void mV(String str) {
        this.eAJ = str;
    }

    public View aHE() {
        return this.bCr;
    }

    public View getBackButton() {
        return this.bCs;
    }

    public View aHN() {
        return this.eBd;
    }

    public View aHO() {
        return this.eBh;
    }

    public int aGA() {
        return this.ezA;
    }

    public void a(a.b bVar) {
        this.eAZ = bVar;
    }

    public void b(a.b bVar) {
        this.eAY = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eBc.getPageContext().getPageActivity());
        aVar.aZ(false);
        aVar.fb(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.o.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (o.this.eAZ != null) {
                    o.this.eAZ.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.o.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (o.this.eAY != null) {
                    o.this.eAY.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eBc.getPageContext());
        aVar.AV();
    }

    public void onChangeSkinType(int i) {
        this.eBc.getLayoutMode().aQ(i == 1);
        this.eBc.getLayoutMode().aM(this.mParent);
        aj.p(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aj.t(this.mParent, d.C0141d.common_color_10041);
        aj.e(this.bCr, d.C0141d.cp_cont_f, 1);
    }
}
