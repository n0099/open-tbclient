package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView fEM;
    private View fEN;
    private int kos;
    private String kpA;
    private String kpB;
    private boolean kpE;
    private String kpL;
    private String kpM;
    private a.b kpQ;
    private a.b kpR;
    private GroupAddressLocateActivity kpU;
    private View kpV;
    private TextView kpW;
    private ImageView kpX;
    private TextView kpY;
    private View kpZ;
    private com.baidu.tieba.im.util.b kps;
    private TextView kqa;
    private ImageView kqb;
    private BdListView kqc;
    private AnimationDrawable kqd;
    private SettingTextSwitchView kqe;
    private m kqf;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.kos = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.kpU = null;
        this.fEM = null;
        this.fEN = null;
        this.kpV = null;
        this.kpW = null;
        this.kpX = null;
        this.kpY = null;
        this.kpZ = null;
        this.kqa = null;
        this.kqb = null;
        this.kqc = null;
        this.kqd = null;
        this.kqe = null;
        this.kpL = "";
        this.kpM = "";
        this.kpE = false;
        this.kqf = null;
        this.kps = null;
        this.kpA = "";
        this.kpB = "";
        this.kpR = null;
        this.kpQ = null;
        this.kpL = str;
        this.kpM = str2;
        this.kpE = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cVj() {
        this.kps.startLoad();
    }

    public void cVk() {
        if (this.kps != null) {
            this.kps.cancelLoad();
            this.kps = null;
        }
    }

    public void cVz() {
        this.kpX.setVisibility(8);
    }

    public void cVA() {
        this.kpX.setVisibility(0);
    }

    public void cVw() {
        if (this.kqf != null) {
            this.kqf.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.kpU = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.kpW = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.kpV = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.kpV.setOnClickListener(this.kpU);
        this.kpX = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.kpL)) {
            stringBuffer.append(this.kpL);
        }
        if (!TextUtils.isEmpty(this.kpM)) {
            stringBuffer.append(this.kpM);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.kpV.setVisibility(0);
            this.kpW.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.kpV.setVisibility(8);
            this.kpW.setVisibility(8);
        }
        this.kpZ = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.kpZ.setOnClickListener(this.kpU);
        this.kqa = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.kqb = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.kqb.setVisibility(8);
        this.kpY = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.kqc = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.kqc.setOnItemClickListener(this.kpU);
        this.kqe = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.kpE) {
            this.kqe.turnOn();
        } else {
            this.kqe.turnOff();
        }
        this.kqe.setSwitchStateChangeListener(this.kpU);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.fEN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fEM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.fEN.setOnClickListener(groupAddressLocateActivity);
        this.fEM.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.kps = new com.baidu.tieba.im.util.b(this.kpU);
        this.kps.setUniqueId(this.kpU.getUniqueId());
        if (!ae.c(this.kpU, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cVj();
        }
    }

    public void cVB() {
        this.kpY.setText(R.string.address_pos_list);
        this.kqa.setText(R.string.location_loading);
        this.kqb.setVisibility(8);
        this.kos = 3;
        cVD();
    }

    public void cVC() {
        this.kpY.setText(R.string.address_locate_noaddresslist);
        this.kqa.setText(R.string.address_locate_failed_tryagain);
        this.kqb.setVisibility(0);
        this.kos = 2;
        cVD();
    }

    public void M(String[] strArr) {
        this.kpZ.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.kpY.setText(R.string.address_pos_list);
            this.kqf = new m(this.kpU, strArr);
            this.kqc.setAdapter((ListAdapter) this.kqf);
            this.kqc.setVisibility(0);
        } else {
            this.kpY.setText(R.string.address_locate_noaddresslist);
        }
        cVD();
    }

    public void cUv() {
        this.kpY.setText(R.string.address_pos_list);
        this.kqa.setText(R.string.address_locate_failed_opengps);
        this.kqb.setVisibility(0);
        this.kos = 1;
        cVD();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.kqa.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.kqd = (AnimationDrawable) compoundDrawables[0];
            cVD();
        }
    }

    private void cVD() {
        if (this.kqd != null) {
            if (this.kos == 3) {
                this.kqd.start();
                return;
            }
            this.kqd.stop();
            this.kqd.selectDrawable(0);
        }
    }

    public void MW(String str) {
        this.kpA = str;
    }

    public void MX(String str) {
        this.kpB = str;
    }

    public View cVv() {
        return this.fEM;
    }

    public View getBackButton() {
        return this.fEN;
    }

    public View cVE() {
        return this.kpV;
    }

    public View cVF() {
        return this.kpZ;
    }

    public int cUt() {
        return this.kos;
    }

    public void b(a.b bVar) {
        this.kpR = bVar;
    }

    public void c(a.b bVar) {
        this.kpQ = bVar;
    }

    public void RU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kpU.getPageContext().getPageActivity());
        aVar.jl(false);
        aVar.oQ(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.kpR != null) {
                    n.this.kpR.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.kpQ != null) {
                    n.this.kpQ.onClick(aVar2);
                }
            }
        });
        aVar.b(this.kpU.getPageContext());
        aVar.brv();
    }

    public void onChangeSkinType(int i) {
        this.kpU.getLayoutMode().setNightMode(i == 1);
        this.kpU.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.fEM, R.color.CAM_X0106, 1);
    }
}
