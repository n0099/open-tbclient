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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView cCl;
    private View cCm;
    private int gDg;
    private String gEA;
    private a.b gEE;
    private a.b gEF;
    private GroupAddressLocateActivity gEI;
    private View gEJ;
    private TextView gEK;
    private ImageView gEL;
    private TextView gEM;
    private View gEN;
    private TextView gEO;
    private ImageView gEP;
    private BdListView gEQ;
    private AnimationDrawable gER;
    private SettingTextSwitchView gES;
    private m gET;
    private com.baidu.tieba.im.util.b gEg;
    private String gEo;
    private String gEp;
    private boolean gEs;
    private String gEz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.gDg = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.gEI = null;
        this.cCl = null;
        this.cCm = null;
        this.gEJ = null;
        this.gEK = null;
        this.gEL = null;
        this.gEM = null;
        this.gEN = null;
        this.gEO = null;
        this.gEP = null;
        this.gEQ = null;
        this.gER = null;
        this.gES = null;
        this.gEz = "";
        this.gEA = "";
        this.gEs = false;
        this.gET = null;
        this.gEg = null;
        this.gEo = "";
        this.gEp = "";
        this.gEF = null;
        this.gEE = null;
        this.gEz = str;
        this.gEA = str2;
        this.gEs = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bCg() {
        this.gEg.ayc();
    }

    public void bCh() {
        if (this.gEg != null) {
            this.gEg.cancelLoad();
            this.gEg = null;
        }
    }

    public void bCw() {
        this.gEL.setVisibility(8);
    }

    public void bCx() {
        this.gEL.setVisibility(0);
    }

    public void bCt() {
        if (this.gET != null) {
            this.gET.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.gEI = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.gEK = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.gEJ = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.gEJ.setOnClickListener(this.gEI);
        this.gEL = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.gEz)) {
            stringBuffer.append(this.gEz);
        }
        if (!TextUtils.isEmpty(this.gEA)) {
            stringBuffer.append(this.gEA);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.gEJ.setVisibility(0);
            this.gEK.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.gEJ.setVisibility(8);
            this.gEK.setVisibility(8);
        }
        this.gEN = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.gEN.setOnClickListener(this.gEI);
        this.gEO = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.gEP = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.gEP.setVisibility(8);
        this.gEM = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.gEQ = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.gEQ.setOnItemClickListener(this.gEI);
        this.gES = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.gEs) {
            this.gES.nm();
        } else {
            this.gES.nn();
        }
        this.gES.setSwitchStateChangeListener(this.gEI);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cCm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cCl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.cCm.setOnClickListener(groupAddressLocateActivity);
        this.cCl.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.gEg = new com.baidu.tieba.im.util.b(this.gEI);
        this.gEg.setUniqueId(this.gEI.getUniqueId());
        bCg();
    }

    public void bCy() {
        this.gEM.setText(R.string.address_pos_list);
        this.gEO.setText(R.string.location_loading);
        this.gEP.setVisibility(8);
        this.gDg = 3;
        bCA();
    }

    public void bCz() {
        this.gEM.setText(R.string.address_locate_noaddresslist);
        this.gEO.setText(R.string.address_locate_failed_tryagain);
        this.gEP.setVisibility(0);
        this.gDg = 2;
        bCA();
    }

    public void x(String[] strArr) {
        this.gEN.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.gEM.setText(R.string.address_pos_list);
            this.gET = new m(this.gEI, strArr);
            this.gEQ.setAdapter((ListAdapter) this.gET);
            this.gEQ.setVisibility(0);
        } else {
            this.gEM.setText(R.string.address_locate_noaddresslist);
        }
        bCA();
    }

    public void bBq() {
        this.gEM.setText(R.string.address_pos_list);
        this.gEO.setText(R.string.address_locate_failed_opengps);
        this.gEP.setVisibility(0);
        this.gDg = 1;
        bCA();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.gEO.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.gER = (AnimationDrawable) compoundDrawables[0];
            bCA();
        }
    }

    private void bCA() {
        if (this.gER != null) {
            if (this.gDg == 3) {
                this.gER.start();
                return;
            }
            this.gER.stop();
            this.gER.selectDrawable(0);
        }
    }

    public void yC(String str) {
        this.gEo = str;
    }

    public void yD(String str) {
        this.gEp = str;
    }

    public View bCs() {
        return this.cCl;
    }

    public View getBackButton() {
        return this.cCm;
    }

    public View bCB() {
        return this.gEJ;
    }

    public View bCC() {
        return this.gEN;
    }

    public int bBo() {
        return this.gDg;
    }

    public void b(a.b bVar) {
        this.gEF = bVar;
    }

    public void c(a.b bVar) {
        this.gEE = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gEI.getPageContext().getPageActivity());
        aVar.dQ(false);
        aVar.hu(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gEF != null) {
                    n.this.gEF.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gEE != null) {
                    n.this.gEE.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gEI.getPageContext());
        aVar.agK();
    }

    public void onChangeSkinType(int i) {
        this.gEI.getLayoutMode().setNightMode(i == 1);
        this.gEI.getLayoutMode().onModeChanged(this.mParent);
        am.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.l(this.mParent, R.color.common_color_10041);
        am.f(this.cCl, R.color.cp_cont_f, 1);
    }
}
