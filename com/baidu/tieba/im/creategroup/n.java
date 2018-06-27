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
    private TextView aVM;
    private View aVN;
    private int eko;
    private boolean elA;
    private String elH;
    private String elI;
    private a.b elM;
    private a.b elN;
    private GroupAddressLocateActivity elQ;
    private View elR;
    private TextView elS;
    private ImageView elT;
    private TextView elU;
    private View elV;
    private TextView elW;
    private ImageView elX;
    private BdListView elY;
    private AnimationDrawable elZ;
    private com.baidu.tieba.im.util.b elo;
    private String elw;
    private String elx;
    private SettingTextSwitchView ema;
    private m emb;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.eko = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.elQ = null;
        this.aVM = null;
        this.aVN = null;
        this.elR = null;
        this.elS = null;
        this.elT = null;
        this.elU = null;
        this.elV = null;
        this.elW = null;
        this.elX = null;
        this.elY = null;
        this.elZ = null;
        this.ema = null;
        this.elH = "";
        this.elI = "";
        this.elA = false;
        this.emb = null;
        this.elo = null;
        this.elw = "";
        this.elx = "";
        this.elN = null;
        this.elM = null;
        this.elH = str;
        this.elI = str2;
        this.elA = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aHS() {
        this.elo.MO();
    }

    public void aHT() {
        if (this.elo != null) {
            this.elo.cancelLoad();
            this.elo = null;
        }
    }

    public void aIh() {
        this.elT.setVisibility(8);
    }

    public void aIi() {
        this.elT.setVisibility(0);
    }

    public void aIe() {
        if (this.emb != null) {
            this.emb.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.elQ = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.i.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.elS = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.elR = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.elR.setOnClickListener(this.elQ);
        this.elT = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.elH)) {
            stringBuffer.append(this.elH);
        }
        if (!TextUtils.isEmpty(this.elI)) {
            stringBuffer.append(this.elI);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.elR.setVisibility(0);
            this.elS.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.elR.setVisibility(8);
            this.elS.setVisibility(8);
        }
        this.elV = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.elV.setOnClickListener(this.elQ);
        this.elW = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.elX = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.elX.setVisibility(8);
        this.elU = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.elY = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.elY.setOnItemClickListener(this.elQ);
        this.ema = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.elA) {
            this.ema.mC();
        } else {
            this.ema.mD();
        }
        this.ema.setSwitchStateChangeListener(this.elQ);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(d.k.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aVN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(d.k.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aVN.setOnClickListener(groupAddressLocateActivity);
        this.aVM.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.elo = new com.baidu.tieba.im.util.b(this.elQ);
        this.elo.setUniqueId(this.elQ.getUniqueId());
        aHS();
    }

    public void aIj() {
        this.elU.setText(d.k.address_pos_list);
        this.elW.setText(d.k.location_loading);
        this.elX.setVisibility(8);
        this.eko = 3;
        aIl();
    }

    public void aIk() {
        this.elU.setText(d.k.address_locate_noaddresslist);
        this.elW.setText(d.k.address_locate_failed_tryagain);
        this.elX.setVisibility(0);
        this.eko = 2;
        aIl();
    }

    public void v(String[] strArr) {
        this.elV.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.elU.setText(d.k.address_pos_list);
            this.emb = new m(this.elQ, strArr);
            this.elY.setAdapter((ListAdapter) this.emb);
            this.elY.setVisibility(0);
        } else {
            this.elU.setText(d.k.address_locate_noaddresslist);
        }
        aIl();
    }

    public void aHc() {
        this.elU.setText(d.k.address_pos_list);
        this.elW.setText(d.k.address_locate_failed_opengps);
        this.elX.setVisibility(0);
        this.eko = 1;
        aIl();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.elW.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.elZ = (AnimationDrawable) compoundDrawables[0];
            aIl();
        }
    }

    private void aIl() {
        if (this.elZ != null) {
            if (this.eko == 3) {
                this.elZ.start();
                return;
            }
            this.elZ.stop();
            this.elZ.selectDrawable(0);
        }
    }

    public void nO(String str) {
        this.elw = str;
    }

    public void nP(String str) {
        this.elx = str;
    }

    public View aId() {
        return this.aVM;
    }

    public View getBackButton() {
        return this.aVN;
    }

    public View aIm() {
        return this.elR;
    }

    public View aIn() {
        return this.elV;
    }

    public int aHa() {
        return this.eko;
    }

    public void a(a.b bVar) {
        this.elN = bVar;
    }

    public void b(a.b bVar) {
        this.elM = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elQ.getPageContext().getPageActivity());
        aVar.aw(false);
        aVar.cd(d.k.group_update_alert_save);
        aVar.a(d.k.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.elN != null) {
                    n.this.elN.onClick(aVar2);
                }
            }
        });
        aVar.b(d.k.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.elM != null) {
                    n.this.elM.onClick(aVar2);
                }
            }
        });
        aVar.b(this.elQ.getPageContext());
        aVar.xn();
    }

    public void onChangeSkinType(int i) {
        this.elQ.getLayoutMode().setNightMode(i == 1);
        this.elQ.getLayoutMode().onModeChanged(this.mParent);
        am.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.j(this.mParent, d.C0142d.common_color_10041);
        am.c(this.aVM, d.C0142d.cp_cont_f, 1);
    }
}
