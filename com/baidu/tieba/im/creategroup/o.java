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
    private TextView bCo;
    private View bCp;
    private String eAD;
    private String eAE;
    private a.b eAI;
    private a.b eAJ;
    private GroupAddressLocateActivity eAM;
    private View eAN;
    private TextView eAO;
    private ImageView eAP;
    private TextView eAQ;
    private View eAR;
    private TextView eAS;
    private ImageView eAT;
    private BdListView eAU;
    private AnimationDrawable eAV;
    private SettingTextSwitchView eAW;
    private n eAX;
    private com.baidu.tieba.im.util.b eAk;
    private String eAs;
    private String eAt;
    private boolean eAw;
    private int ezk;
    private NavigationBar mNavigationBar;
    private View mParent;

    public o(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.ezk = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eAM = null;
        this.bCo = null;
        this.bCp = null;
        this.eAN = null;
        this.eAO = null;
        this.eAP = null;
        this.eAQ = null;
        this.eAR = null;
        this.eAS = null;
        this.eAT = null;
        this.eAU = null;
        this.eAV = null;
        this.eAW = null;
        this.eAD = "";
        this.eAE = "";
        this.eAw = false;
        this.eAX = null;
        this.eAk = null;
        this.eAs = "";
        this.eAt = "";
        this.eAJ = null;
        this.eAI = null;
        this.eAD = str;
        this.eAE = str2;
        this.eAw = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aHr() {
        this.eAk.Qz();
    }

    public void aHs() {
        if (this.eAk != null) {
            this.eAk.dE();
            this.eAk = null;
        }
    }

    public void aHH() {
        this.eAP.setVisibility(8);
    }

    public void aHI() {
        this.eAP.setVisibility(0);
    }

    public void aHE() {
        if (this.eAX != null) {
            this.eAX.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eAM = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.eAO = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.eAN = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.eAN.setOnClickListener(this.eAM);
        this.eAP = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.eAD)) {
            stringBuffer.append(this.eAD);
        }
        if (!TextUtils.isEmpty(this.eAE)) {
            stringBuffer.append(this.eAE);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.eAN.setVisibility(0);
            this.eAO.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.eAN.setVisibility(8);
            this.eAO.setVisibility(8);
        }
        this.eAR = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.eAR.setOnClickListener(this.eAM);
        this.eAS = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.eAT = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.eAT.setVisibility(8);
        this.eAQ = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.eAU = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.eAU.setOnItemClickListener(this.eAM);
        this.eAW = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.eAw) {
            this.eAW.rJ();
        } else {
            this.eAW.rK();
        }
        this.eAW.setSwitchStateChangeListener(this.eAM);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bCp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(d.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.bCp.setOnClickListener(groupAddressLocateActivity);
        this.bCo.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.eAk = new com.baidu.tieba.im.util.b(this.eAM);
        this.eAk.setUniqueId(this.eAM.getUniqueId());
        aHr();
    }

    public void aHJ() {
        this.eAQ.setText(d.j.address_pos_list);
        this.eAS.setText(d.j.location_loading);
        this.eAT.setVisibility(8);
        this.ezk = 3;
        aHL();
    }

    public void aHK() {
        this.eAQ.setText(d.j.address_locate_noaddresslist);
        this.eAS.setText(d.j.address_locate_failed_tryagain);
        this.eAT.setVisibility(0);
        this.ezk = 2;
        aHL();
    }

    public void s(String[] strArr) {
        this.eAR.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.eAQ.setText(d.j.address_pos_list);
            this.eAX = new n(this.eAM, strArr);
            this.eAU.setAdapter((ListAdapter) this.eAX);
            this.eAU.setVisibility(0);
        } else {
            this.eAQ.setText(d.j.address_locate_noaddresslist);
        }
        aHL();
    }

    public void aGB() {
        this.eAQ.setText(d.j.address_pos_list);
        this.eAS.setText(d.j.address_locate_failed_opengps);
        this.eAT.setVisibility(0);
        this.ezk = 1;
        aHL();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.eAS.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.eAV = (AnimationDrawable) compoundDrawables[0];
            aHL();
        }
    }

    private void aHL() {
        if (this.eAV != null) {
            if (this.ezk == 3) {
                this.eAV.start();
                return;
            }
            this.eAV.stop();
            this.eAV.selectDrawable(0);
        }
    }

    public void mU(String str) {
        this.eAs = str;
    }

    public void mV(String str) {
        this.eAt = str;
    }

    public View aHD() {
        return this.bCo;
    }

    public View getBackButton() {
        return this.bCp;
    }

    public View aHM() {
        return this.eAN;
    }

    public View aHN() {
        return this.eAR;
    }

    public int aGz() {
        return this.ezk;
    }

    public void a(a.b bVar) {
        this.eAJ = bVar;
    }

    public void b(a.b bVar) {
        this.eAI = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eAM.getPageContext().getPageActivity());
        aVar.aZ(false);
        aVar.fb(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.o.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (o.this.eAJ != null) {
                    o.this.eAJ.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.o.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (o.this.eAI != null) {
                    o.this.eAI.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eAM.getPageContext());
        aVar.AU();
    }

    public void onChangeSkinType(int i) {
        this.eAM.getLayoutMode().aQ(i == 1);
        this.eAM.getLayoutMode().aM(this.mParent);
        aj.p(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aj.t(this.mParent, d.C0141d.common_color_10041);
        aj.e(this.bCo, d.C0141d.cp_cont_f, 1);
    }
}
