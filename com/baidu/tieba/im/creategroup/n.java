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
    private int eDl;
    private String eEE;
    private String eEF;
    private a.b eEJ;
    private a.b eEK;
    private GroupAddressLocateActivity eEN;
    private View eEO;
    private TextView eEP;
    private ImageView eEQ;
    private TextView eER;
    private View eES;
    private TextView eET;
    private ImageView eEU;
    private BdListView eEV;
    private AnimationDrawable eEW;
    private SettingTextSwitchView eEX;
    private m eEY;
    private com.baidu.tieba.im.util.b eEl;
    private String eEt;
    private String eEu;
    private boolean eEx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.eDl = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eEN = null;
        this.bdD = null;
        this.bdE = null;
        this.eEO = null;
        this.eEP = null;
        this.eEQ = null;
        this.eER = null;
        this.eES = null;
        this.eET = null;
        this.eEU = null;
        this.eEV = null;
        this.eEW = null;
        this.eEX = null;
        this.eEE = "";
        this.eEF = "";
        this.eEx = false;
        this.eEY = null;
        this.eEl = null;
        this.eEt = "";
        this.eEu = "";
        this.eEK = null;
        this.eEJ = null;
        this.eEE = str;
        this.eEF = str2;
        this.eEx = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aOt() {
        this.eEl.Qc();
    }

    public void aOu() {
        if (this.eEl != null) {
            this.eEl.cancelLoad();
            this.eEl = null;
        }
    }

    public void aOJ() {
        this.eEQ.setVisibility(8);
    }

    public void aOK() {
        this.eEQ.setVisibility(0);
    }

    public void aOG() {
        if (this.eEY != null) {
            this.eEY.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eEN = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(e.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(e.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(e.g.address_content_currentpos);
        this.eEP = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_currentpos);
        this.eEO = groupAddressLocateActivity.findViewById(e.g.address_content_container);
        this.eEO.setOnClickListener(this.eEN);
        this.eEQ = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.eEE)) {
            stringBuffer.append(this.eEE);
        }
        if (!TextUtils.isEmpty(this.eEF)) {
            stringBuffer.append(this.eEF);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.eEO.setVisibility(0);
            this.eEP.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.eEO.setVisibility(8);
            this.eEP.setVisibility(8);
        }
        this.eES = groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_layout);
        this.eES.setOnClickListener(this.eEN);
        this.eET = (TextView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_textview);
        this.eEU = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_rightarrow);
        this.eEU.setVisibility(8);
        this.eER = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_poslist);
        this.eEV = (BdListView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_addresslist_listview);
        this.eEV.setOnItemClickListener(this.eEN);
        this.eEX = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(e.g.address_showorhidden);
        if (this.eEx) {
            this.eEX.nU();
        } else {
            this.eEX.nV();
        }
        this.eEX.setSwitchStateChangeListener(this.eEN);
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
        this.eEl = new com.baidu.tieba.im.util.b(this.eEN);
        this.eEl.setUniqueId(this.eEN.getUniqueId());
        aOt();
    }

    public void aOL() {
        this.eER.setText(e.j.address_pos_list);
        this.eET.setText(e.j.location_loading);
        this.eEU.setVisibility(8);
        this.eDl = 3;
        aON();
    }

    public void aOM() {
        this.eER.setText(e.j.address_locate_noaddresslist);
        this.eET.setText(e.j.address_locate_failed_tryagain);
        this.eEU.setVisibility(0);
        this.eDl = 2;
        aON();
    }

    public void w(String[] strArr) {
        this.eES.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.eER.setText(e.j.address_pos_list);
            this.eEY = new m(this.eEN, strArr);
            this.eEV.setAdapter((ListAdapter) this.eEY);
            this.eEV.setVisibility(0);
        } else {
            this.eER.setText(e.j.address_locate_noaddresslist);
        }
        aON();
    }

    public void aNE() {
        this.eER.setText(e.j.address_pos_list);
        this.eET.setText(e.j.address_locate_failed_opengps);
        this.eEU.setVisibility(0);
        this.eDl = 1;
        aON();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.eET.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.eEW = (AnimationDrawable) compoundDrawables[0];
            aON();
        }
    }

    private void aON() {
        if (this.eEW != null) {
            if (this.eDl == 3) {
                this.eEW.start();
                return;
            }
            this.eEW.stop();
            this.eEW.selectDrawable(0);
        }
    }

    public void pb(String str) {
        this.eEt = str;
    }

    public void pc(String str) {
        this.eEu = str;
    }

    public View aOF() {
        return this.bdD;
    }

    public View getBackButton() {
        return this.bdE;
    }

    public View aOO() {
        return this.eEO;
    }

    public View aOP() {
        return this.eES;
    }

    public int aNC() {
        return this.eDl;
    }

    public void a(a.b bVar) {
        this.eEK = bVar;
    }

    public void b(a.b bVar) {
        this.eEJ = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eEN.getPageContext().getPageActivity());
        aVar.aO(false);
        aVar.cz(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eEK != null) {
                    n.this.eEK.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eEJ != null) {
                    n.this.eEJ.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eEN.getPageContext());
        aVar.Au();
    }

    public void onChangeSkinType(int i) {
        this.eEN.getLayoutMode().setNightMode(i == 1);
        this.eEN.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.bdD, e.d.cp_cont_f, 1);
    }
}
