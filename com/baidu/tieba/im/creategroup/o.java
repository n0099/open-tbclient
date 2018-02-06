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
    private TextView bCB;
    private View bCC;
    private String eAE;
    private String eAF;
    private boolean eAI;
    private String eAP;
    private String eAQ;
    private a.b eAU;
    private a.b eAV;
    private GroupAddressLocateActivity eAY;
    private View eAZ;
    private com.baidu.tieba.im.util.b eAw;
    private TextView eBa;
    private ImageView eBb;
    private TextView eBc;
    private View eBd;
    private TextView eBe;
    private ImageView eBf;
    private BdListView eBg;
    private AnimationDrawable eBh;
    private SettingTextSwitchView eBi;
    private n eBj;
    private int ezw;
    private NavigationBar mNavigationBar;
    private View mParent;

    public o(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.ezw = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eAY = null;
        this.bCB = null;
        this.bCC = null;
        this.eAZ = null;
        this.eBa = null;
        this.eBb = null;
        this.eBc = null;
        this.eBd = null;
        this.eBe = null;
        this.eBf = null;
        this.eBg = null;
        this.eBh = null;
        this.eBi = null;
        this.eAP = "";
        this.eAQ = "";
        this.eAI = false;
        this.eBj = null;
        this.eAw = null;
        this.eAE = "";
        this.eAF = "";
        this.eAV = null;
        this.eAU = null;
        this.eAP = str;
        this.eAQ = str2;
        this.eAI = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aHs() {
        this.eAw.QA();
    }

    public void aHt() {
        if (this.eAw != null) {
            this.eAw.dE();
            this.eAw = null;
        }
    }

    public void aHI() {
        this.eBb.setVisibility(8);
    }

    public void aHJ() {
        this.eBb.setVisibility(0);
    }

    public void aHF() {
        if (this.eBj != null) {
            this.eBj.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eAY = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.eBa = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.eAZ = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.eAZ.setOnClickListener(this.eAY);
        this.eBb = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.eAP)) {
            stringBuffer.append(this.eAP);
        }
        if (!TextUtils.isEmpty(this.eAQ)) {
            stringBuffer.append(this.eAQ);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.eAZ.setVisibility(0);
            this.eBa.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.eAZ.setVisibility(8);
            this.eBa.setVisibility(8);
        }
        this.eBd = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.eBd.setOnClickListener(this.eAY);
        this.eBe = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.eBf = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.eBf.setVisibility(8);
        this.eBc = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.eBg = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.eBg.setOnItemClickListener(this.eAY);
        this.eBi = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.eAI) {
            this.eBi.rJ();
        } else {
            this.eBi.rK();
        }
        this.eBi.setSwitchStateChangeListener(this.eAY);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bCC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(d.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.bCC.setOnClickListener(groupAddressLocateActivity);
        this.bCB.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.eAw = new com.baidu.tieba.im.util.b(this.eAY);
        this.eAw.setUniqueId(this.eAY.getUniqueId());
        aHs();
    }

    public void aHK() {
        this.eBc.setText(d.j.address_pos_list);
        this.eBe.setText(d.j.location_loading);
        this.eBf.setVisibility(8);
        this.ezw = 3;
        aHM();
    }

    public void aHL() {
        this.eBc.setText(d.j.address_locate_noaddresslist);
        this.eBe.setText(d.j.address_locate_failed_tryagain);
        this.eBf.setVisibility(0);
        this.ezw = 2;
        aHM();
    }

    public void s(String[] strArr) {
        this.eBd.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.eBc.setText(d.j.address_pos_list);
            this.eBj = new n(this.eAY, strArr);
            this.eBg.setAdapter((ListAdapter) this.eBj);
            this.eBg.setVisibility(0);
        } else {
            this.eBc.setText(d.j.address_locate_noaddresslist);
        }
        aHM();
    }

    public void aGC() {
        this.eBc.setText(d.j.address_pos_list);
        this.eBe.setText(d.j.address_locate_failed_opengps);
        this.eBf.setVisibility(0);
        this.ezw = 1;
        aHM();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.eBe.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.eBh = (AnimationDrawable) compoundDrawables[0];
            aHM();
        }
    }

    private void aHM() {
        if (this.eBh != null) {
            if (this.ezw == 3) {
                this.eBh.start();
                return;
            }
            this.eBh.stop();
            this.eBh.selectDrawable(0);
        }
    }

    public void mU(String str) {
        this.eAE = str;
    }

    public void mV(String str) {
        this.eAF = str;
    }

    public View aHE() {
        return this.bCB;
    }

    public View getBackButton() {
        return this.bCC;
    }

    public View aHN() {
        return this.eAZ;
    }

    public View aHO() {
        return this.eBd;
    }

    public int aGA() {
        return this.ezw;
    }

    public void a(a.b bVar) {
        this.eAV = bVar;
    }

    public void b(a.b bVar) {
        this.eAU = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eAY.getPageContext().getPageActivity());
        aVar.aZ(false);
        aVar.fb(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.o.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (o.this.eAV != null) {
                    o.this.eAV.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.o.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (o.this.eAU != null) {
                    o.this.eAU.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eAY.getPageContext());
        aVar.AU();
    }

    public void onChangeSkinType(int i) {
        this.eAY.getLayoutMode().aQ(i == 1);
        this.eAY.getLayoutMode().aM(this.mParent);
        aj.p(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        aj.t(this.mParent, d.C0140d.common_color_10041);
        aj.e(this.bCB, d.C0140d.cp_cont_f, 1);
    }
}
