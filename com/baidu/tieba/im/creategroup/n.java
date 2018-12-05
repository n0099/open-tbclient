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
    private TextView bhR;
    private View bhS;
    private int eLt;
    private String eMB;
    private String eMC;
    private boolean eMF;
    private String eMM;
    private String eMN;
    private a.b eMR;
    private a.b eMS;
    private GroupAddressLocateActivity eMV;
    private View eMW;
    private TextView eMX;
    private ImageView eMY;
    private TextView eMZ;
    private com.baidu.tieba.im.util.b eMt;
    private View eNa;
    private TextView eNb;
    private ImageView eNc;
    private BdListView eNd;
    private AnimationDrawable eNe;
    private SettingTextSwitchView eNf;
    private m eNg;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.eLt = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eMV = null;
        this.bhR = null;
        this.bhS = null;
        this.eMW = null;
        this.eMX = null;
        this.eMY = null;
        this.eMZ = null;
        this.eNa = null;
        this.eNb = null;
        this.eNc = null;
        this.eNd = null;
        this.eNe = null;
        this.eNf = null;
        this.eMM = "";
        this.eMN = "";
        this.eMF = false;
        this.eNg = null;
        this.eMt = null;
        this.eMB = "";
        this.eMC = "";
        this.eMS = null;
        this.eMR = null;
        this.eMM = str;
        this.eMN = str2;
        this.eMF = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aPI() {
        this.eMt.Rr();
    }

    public void aPJ() {
        if (this.eMt != null) {
            this.eMt.cancelLoad();
            this.eMt = null;
        }
    }

    public void aPY() {
        this.eMY.setVisibility(8);
    }

    public void aPZ() {
        this.eMY.setVisibility(0);
    }

    public void aPV() {
        if (this.eNg != null) {
            this.eNg.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eMV = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(e.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(e.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(e.g.address_content_currentpos);
        this.eMX = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_currentpos);
        this.eMW = groupAddressLocateActivity.findViewById(e.g.address_content_container);
        this.eMW.setOnClickListener(this.eMV);
        this.eMY = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.eMM)) {
            stringBuffer.append(this.eMM);
        }
        if (!TextUtils.isEmpty(this.eMN)) {
            stringBuffer.append(this.eMN);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.eMW.setVisibility(0);
            this.eMX.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.eMW.setVisibility(8);
            this.eMX.setVisibility(8);
        }
        this.eNa = groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_layout);
        this.eNa.setOnClickListener(this.eMV);
        this.eNb = (TextView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_textview);
        this.eNc = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_rightarrow);
        this.eNc.setVisibility(8);
        this.eMZ = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_poslist);
        this.eNd = (BdListView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_addresslist_listview);
        this.eNd.setOnItemClickListener(this.eMV);
        this.eNf = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(e.g.address_showorhidden);
        if (this.eMF) {
            this.eNf.nR();
        } else {
            this.eNf.nS();
        }
        this.eNf.setSwitchStateChangeListener(this.eMV);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bhS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bhR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(e.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.bhS.setOnClickListener(groupAddressLocateActivity);
        this.bhR.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.eMt = new com.baidu.tieba.im.util.b(this.eMV);
        this.eMt.setUniqueId(this.eMV.getUniqueId());
        aPI();
    }

    public void aQa() {
        this.eMZ.setText(e.j.address_pos_list);
        this.eNb.setText(e.j.location_loading);
        this.eNc.setVisibility(8);
        this.eLt = 3;
        aQc();
    }

    public void aQb() {
        this.eMZ.setText(e.j.address_locate_noaddresslist);
        this.eNb.setText(e.j.address_locate_failed_tryagain);
        this.eNc.setVisibility(0);
        this.eLt = 2;
        aQc();
    }

    public void y(String[] strArr) {
        this.eNa.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.eMZ.setText(e.j.address_pos_list);
            this.eNg = new m(this.eMV, strArr);
            this.eNd.setAdapter((ListAdapter) this.eNg);
            this.eNd.setVisibility(0);
        } else {
            this.eMZ.setText(e.j.address_locate_noaddresslist);
        }
        aQc();
    }

    public void aOT() {
        this.eMZ.setText(e.j.address_pos_list);
        this.eNb.setText(e.j.address_locate_failed_opengps);
        this.eNc.setVisibility(0);
        this.eLt = 1;
        aQc();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.eNb.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.eNe = (AnimationDrawable) compoundDrawables[0];
            aQc();
        }
    }

    private void aQc() {
        if (this.eNe != null) {
            if (this.eLt == 3) {
                this.eNe.start();
                return;
            }
            this.eNe.stop();
            this.eNe.selectDrawable(0);
        }
    }

    public void pE(String str) {
        this.eMB = str;
    }

    public void pF(String str) {
        this.eMC = str;
    }

    public View aPU() {
        return this.bhR;
    }

    public View getBackButton() {
        return this.bhS;
    }

    public View aQd() {
        return this.eMW;
    }

    public View aQe() {
        return this.eNa;
    }

    public int aOR() {
        return this.eLt;
    }

    public void a(a.b bVar) {
        this.eMS = bVar;
    }

    public void b(a.b bVar) {
        this.eMR = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eMV.getPageContext().getPageActivity());
        aVar.bf(false);
        aVar.db(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eMS != null) {
                    n.this.eMS.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eMR != null) {
                    n.this.eMR.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eMV.getPageContext());
        aVar.BF();
    }

    public void onChangeSkinType(int i) {
        this.eMV.getLayoutMode().setNightMode(i == 1);
        this.eMV.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.bhR, e.d.cp_cont_f, 1);
    }
}
