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
    private int koq;
    private boolean kpC;
    private String kpJ;
    private String kpK;
    private a.b kpO;
    private a.b kpP;
    private GroupAddressLocateActivity kpS;
    private View kpT;
    private TextView kpU;
    private ImageView kpV;
    private TextView kpW;
    private View kpX;
    private TextView kpY;
    private ImageView kpZ;
    private com.baidu.tieba.im.util.b kpq;
    private String kpy;
    private String kpz;
    private BdListView kqa;
    private AnimationDrawable kqb;
    private SettingTextSwitchView kqc;
    private m kqd;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.koq = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.kpS = null;
        this.fEM = null;
        this.fEN = null;
        this.kpT = null;
        this.kpU = null;
        this.kpV = null;
        this.kpW = null;
        this.kpX = null;
        this.kpY = null;
        this.kpZ = null;
        this.kqa = null;
        this.kqb = null;
        this.kqc = null;
        this.kpJ = "";
        this.kpK = "";
        this.kpC = false;
        this.kqd = null;
        this.kpq = null;
        this.kpy = "";
        this.kpz = "";
        this.kpP = null;
        this.kpO = null;
        this.kpJ = str;
        this.kpK = str2;
        this.kpC = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cVi() {
        this.kpq.startLoad();
    }

    public void cVj() {
        if (this.kpq != null) {
            this.kpq.cancelLoad();
            this.kpq = null;
        }
    }

    public void cVy() {
        this.kpV.setVisibility(8);
    }

    public void cVz() {
        this.kpV.setVisibility(0);
    }

    public void cVv() {
        if (this.kqd != null) {
            this.kqd.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.kpS = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.kpU = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.kpT = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.kpT.setOnClickListener(this.kpS);
        this.kpV = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.kpJ)) {
            stringBuffer.append(this.kpJ);
        }
        if (!TextUtils.isEmpty(this.kpK)) {
            stringBuffer.append(this.kpK);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.kpT.setVisibility(0);
            this.kpU.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.kpT.setVisibility(8);
            this.kpU.setVisibility(8);
        }
        this.kpX = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.kpX.setOnClickListener(this.kpS);
        this.kpY = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.kpZ = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.kpZ.setVisibility(8);
        this.kpW = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.kqa = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.kqa.setOnItemClickListener(this.kpS);
        this.kqc = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.kpC) {
            this.kqc.turnOn();
        } else {
            this.kqc.turnOff();
        }
        this.kqc.setSwitchStateChangeListener(this.kpS);
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
        this.kpq = new com.baidu.tieba.im.util.b(this.kpS);
        this.kpq.setUniqueId(this.kpS.getUniqueId());
        if (!ae.c(this.kpS, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cVi();
        }
    }

    public void cVA() {
        this.kpW.setText(R.string.address_pos_list);
        this.kpY.setText(R.string.location_loading);
        this.kpZ.setVisibility(8);
        this.koq = 3;
        cVC();
    }

    public void cVB() {
        this.kpW.setText(R.string.address_locate_noaddresslist);
        this.kpY.setText(R.string.address_locate_failed_tryagain);
        this.kpZ.setVisibility(0);
        this.koq = 2;
        cVC();
    }

    public void M(String[] strArr) {
        this.kpX.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.kpW.setText(R.string.address_pos_list);
            this.kqd = new m(this.kpS, strArr);
            this.kqa.setAdapter((ListAdapter) this.kqd);
            this.kqa.setVisibility(0);
        } else {
            this.kpW.setText(R.string.address_locate_noaddresslist);
        }
        cVC();
    }

    public void cUu() {
        this.kpW.setText(R.string.address_pos_list);
        this.kpY.setText(R.string.address_locate_failed_opengps);
        this.kpZ.setVisibility(0);
        this.koq = 1;
        cVC();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.kpY.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.kqb = (AnimationDrawable) compoundDrawables[0];
            cVC();
        }
    }

    private void cVC() {
        if (this.kqb != null) {
            if (this.koq == 3) {
                this.kqb.start();
                return;
            }
            this.kqb.stop();
            this.kqb.selectDrawable(0);
        }
    }

    public void MW(String str) {
        this.kpy = str;
    }

    public void MX(String str) {
        this.kpz = str;
    }

    public View cVu() {
        return this.fEM;
    }

    public View getBackButton() {
        return this.fEN;
    }

    public View cVD() {
        return this.kpT;
    }

    public View cVE() {
        return this.kpX;
    }

    public int cUs() {
        return this.koq;
    }

    public void b(a.b bVar) {
        this.kpP = bVar;
    }

    public void c(a.b bVar) {
        this.kpO = bVar;
    }

    public void RU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kpS.getPageContext().getPageActivity());
        aVar.jl(false);
        aVar.oQ(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.kpP != null) {
                    n.this.kpP.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.kpO != null) {
                    n.this.kpO.onClick(aVar2);
                }
            }
        });
        aVar.b(this.kpS.getPageContext());
        aVar.brv();
    }

    public void onChangeSkinType(int i) {
        this.kpS.getLayoutMode().setNightMode(i == 1);
        this.kpS.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.fEM, R.color.CAM_X0106, 1);
    }
}
