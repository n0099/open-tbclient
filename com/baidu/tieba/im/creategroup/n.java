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
    private TextView aMR;
    private View aMS;
    private int dUb;
    private a.b dVA;
    private GroupAddressLocateActivity dVD;
    private View dVE;
    private TextView dVF;
    private ImageView dVG;
    private TextView dVH;
    private View dVI;
    private TextView dVJ;
    private ImageView dVK;
    private BdListView dVL;
    private AnimationDrawable dVM;
    private SettingTextSwitchView dVN;
    private m dVO;
    private com.baidu.tieba.im.util.b dVb;
    private String dVj;
    private String dVk;
    private boolean dVn;
    private String dVu;
    private String dVv;
    private a.b dVz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.dUb = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dVD = null;
        this.aMR = null;
        this.aMS = null;
        this.dVE = null;
        this.dVF = null;
        this.dVG = null;
        this.dVH = null;
        this.dVI = null;
        this.dVJ = null;
        this.dVK = null;
        this.dVL = null;
        this.dVM = null;
        this.dVN = null;
        this.dVu = "";
        this.dVv = "";
        this.dVn = false;
        this.dVO = null;
        this.dVb = null;
        this.dVj = "";
        this.dVk = "";
        this.dVA = null;
        this.dVz = null;
        this.dVu = str;
        this.dVv = str2;
        this.dVn = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aCs() {
        this.dVb.Jc();
    }

    public void aCt() {
        if (this.dVb != null) {
            this.dVb.cancelLoad();
            this.dVb = null;
        }
    }

    public void aCH() {
        this.dVG.setVisibility(8);
    }

    public void aCI() {
        this.dVG.setVisibility(0);
    }

    public void aCE() {
        if (this.dVO != null) {
            this.dVO.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.dVD = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.i.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.dVF = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.dVE = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.dVE.setOnClickListener(this.dVD);
        this.dVG = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.dVu)) {
            stringBuffer.append(this.dVu);
        }
        if (!TextUtils.isEmpty(this.dVv)) {
            stringBuffer.append(this.dVv);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.dVE.setVisibility(0);
            this.dVF.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.dVE.setVisibility(8);
            this.dVF.setVisibility(8);
        }
        this.dVI = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.dVI.setOnClickListener(this.dVD);
        this.dVJ = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.dVK = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.dVK.setVisibility(8);
        this.dVH = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.dVL = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.dVL.setOnItemClickListener(this.dVD);
        this.dVN = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.dVn) {
            this.dVN.jO();
        } else {
            this.dVN.jP();
        }
        this.dVN.setSwitchStateChangeListener(this.dVD);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(d.k.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aMS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(d.k.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aMS.setOnClickListener(groupAddressLocateActivity);
        this.aMR.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.dVb = new com.baidu.tieba.im.util.b(this.dVD);
        this.dVb.setUniqueId(this.dVD.getUniqueId());
        aCs();
    }

    public void aCJ() {
        this.dVH.setText(d.k.address_pos_list);
        this.dVJ.setText(d.k.location_loading);
        this.dVK.setVisibility(8);
        this.dUb = 3;
        aCL();
    }

    public void aCK() {
        this.dVH.setText(d.k.address_locate_noaddresslist);
        this.dVJ.setText(d.k.address_locate_failed_tryagain);
        this.dVK.setVisibility(0);
        this.dUb = 2;
        aCL();
    }

    public void u(String[] strArr) {
        this.dVI.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.dVH.setText(d.k.address_pos_list);
            this.dVO = new m(this.dVD, strArr);
            this.dVL.setAdapter((ListAdapter) this.dVO);
            this.dVL.setVisibility(0);
        } else {
            this.dVH.setText(d.k.address_locate_noaddresslist);
        }
        aCL();
    }

    public void aBC() {
        this.dVH.setText(d.k.address_pos_list);
        this.dVJ.setText(d.k.address_locate_failed_opengps);
        this.dVK.setVisibility(0);
        this.dUb = 1;
        aCL();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.dVJ.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.dVM = (AnimationDrawable) compoundDrawables[0];
            aCL();
        }
    }

    private void aCL() {
        if (this.dVM != null) {
            if (this.dUb == 3) {
                this.dVM.start();
                return;
            }
            this.dVM.stop();
            this.dVM.selectDrawable(0);
        }
    }

    public void mY(String str) {
        this.dVj = str;
    }

    public void mZ(String str) {
        this.dVk = str;
    }

    public View aCD() {
        return this.aMR;
    }

    public View getBackButton() {
        return this.aMS;
    }

    public View aCM() {
        return this.dVE;
    }

    public View aCN() {
        return this.dVI;
    }

    public int aBA() {
        return this.dUb;
    }

    public void a(a.b bVar) {
        this.dVA = bVar;
    }

    public void b(a.b bVar) {
        this.dVz = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVD.getPageContext().getPageActivity());
        aVar.ar(false);
        aVar.bZ(d.k.group_update_alert_save);
        aVar.a(d.k.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.dVA != null) {
                    n.this.dVA.onClick(aVar2);
                }
            }
        });
        aVar.b(d.k.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.dVz != null) {
                    n.this.dVz.onClick(aVar2);
                }
            }
        });
        aVar.b(this.dVD.getPageContext());
        aVar.tD();
    }

    public void onChangeSkinType(int i) {
        this.dVD.getLayoutMode().setNightMode(i == 1);
        this.dVD.getLayoutMode().u(this.mParent);
        ak.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ak.j(this.mParent, d.C0126d.common_color_10041);
        ak.c(this.aMR, d.C0126d.cp_cont_f, 1);
    }
}
