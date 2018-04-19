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
    private int dUe;
    private a.b dVC;
    private a.b dVD;
    private GroupAddressLocateActivity dVG;
    private View dVH;
    private TextView dVI;
    private ImageView dVJ;
    private TextView dVK;
    private View dVL;
    private TextView dVM;
    private ImageView dVN;
    private BdListView dVO;
    private AnimationDrawable dVP;
    private SettingTextSwitchView dVQ;
    private m dVR;
    private com.baidu.tieba.im.util.b dVe;
    private String dVm;
    private String dVn;
    private boolean dVq;
    private String dVx;
    private String dVy;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.dUe = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dVG = null;
        this.aMR = null;
        this.aMS = null;
        this.dVH = null;
        this.dVI = null;
        this.dVJ = null;
        this.dVK = null;
        this.dVL = null;
        this.dVM = null;
        this.dVN = null;
        this.dVO = null;
        this.dVP = null;
        this.dVQ = null;
        this.dVx = "";
        this.dVy = "";
        this.dVq = false;
        this.dVR = null;
        this.dVe = null;
        this.dVm = "";
        this.dVn = "";
        this.dVD = null;
        this.dVC = null;
        this.dVx = str;
        this.dVy = str2;
        this.dVq = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aCs() {
        this.dVe.Jc();
    }

    public void aCt() {
        if (this.dVe != null) {
            this.dVe.cancelLoad();
            this.dVe = null;
        }
    }

    public void aCH() {
        this.dVJ.setVisibility(8);
    }

    public void aCI() {
        this.dVJ.setVisibility(0);
    }

    public void aCE() {
        if (this.dVR != null) {
            this.dVR.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.dVG = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.i.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.dVI = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.dVH = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.dVH.setOnClickListener(this.dVG);
        this.dVJ = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.dVx)) {
            stringBuffer.append(this.dVx);
        }
        if (!TextUtils.isEmpty(this.dVy)) {
            stringBuffer.append(this.dVy);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.dVH.setVisibility(0);
            this.dVI.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.dVH.setVisibility(8);
            this.dVI.setVisibility(8);
        }
        this.dVL = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.dVL.setOnClickListener(this.dVG);
        this.dVM = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.dVN = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.dVN.setVisibility(8);
        this.dVK = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.dVO = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.dVO.setOnItemClickListener(this.dVG);
        this.dVQ = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.dVq) {
            this.dVQ.jO();
        } else {
            this.dVQ.jP();
        }
        this.dVQ.setSwitchStateChangeListener(this.dVG);
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
        this.dVe = new com.baidu.tieba.im.util.b(this.dVG);
        this.dVe.setUniqueId(this.dVG.getUniqueId());
        aCs();
    }

    public void aCJ() {
        this.dVK.setText(d.k.address_pos_list);
        this.dVM.setText(d.k.location_loading);
        this.dVN.setVisibility(8);
        this.dUe = 3;
        aCL();
    }

    public void aCK() {
        this.dVK.setText(d.k.address_locate_noaddresslist);
        this.dVM.setText(d.k.address_locate_failed_tryagain);
        this.dVN.setVisibility(0);
        this.dUe = 2;
        aCL();
    }

    public void u(String[] strArr) {
        this.dVL.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.dVK.setText(d.k.address_pos_list);
            this.dVR = new m(this.dVG, strArr);
            this.dVO.setAdapter((ListAdapter) this.dVR);
            this.dVO.setVisibility(0);
        } else {
            this.dVK.setText(d.k.address_locate_noaddresslist);
        }
        aCL();
    }

    public void aBC() {
        this.dVK.setText(d.k.address_pos_list);
        this.dVM.setText(d.k.address_locate_failed_opengps);
        this.dVN.setVisibility(0);
        this.dUe = 1;
        aCL();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.dVM.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.dVP = (AnimationDrawable) compoundDrawables[0];
            aCL();
        }
    }

    private void aCL() {
        if (this.dVP != null) {
            if (this.dUe == 3) {
                this.dVP.start();
                return;
            }
            this.dVP.stop();
            this.dVP.selectDrawable(0);
        }
    }

    public void mY(String str) {
        this.dVm = str;
    }

    public void mZ(String str) {
        this.dVn = str;
    }

    public View aCD() {
        return this.aMR;
    }

    public View getBackButton() {
        return this.aMS;
    }

    public View aCM() {
        return this.dVH;
    }

    public View aCN() {
        return this.dVL;
    }

    public int aBA() {
        return this.dUe;
    }

    public void a(a.b bVar) {
        this.dVD = bVar;
    }

    public void b(a.b bVar) {
        this.dVC = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVG.getPageContext().getPageActivity());
        aVar.ar(false);
        aVar.bZ(d.k.group_update_alert_save);
        aVar.a(d.k.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.dVD != null) {
                    n.this.dVD.onClick(aVar2);
                }
            }
        });
        aVar.b(d.k.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.dVC != null) {
                    n.this.dVC.onClick(aVar2);
                }
            }
        });
        aVar.b(this.dVG.getPageContext());
        aVar.tD();
    }

    public void onChangeSkinType(int i) {
        this.dVG.getLayoutMode().setNightMode(i == 1);
        this.dVG.getLayoutMode().u(this.mParent);
        ak.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ak.j(this.mParent, d.C0126d.common_color_10041);
        ak.c(this.aMR, d.C0126d.cp_cont_f, 1);
    }
}
