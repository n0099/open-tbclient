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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView eJF;
    private View eJG;
    private int iUY;
    private com.baidu.tieba.im.util.b iVY;
    private GroupAddressLocateActivity iWA;
    private View iWB;
    private TextView iWC;
    private ImageView iWD;
    private TextView iWE;
    private View iWF;
    private TextView iWG;
    private ImageView iWH;
    private BdListView iWI;
    private AnimationDrawable iWJ;
    private SettingTextSwitchView iWK;
    private m iWL;
    private String iWg;
    private String iWh;
    private boolean iWk;
    private String iWr;
    private String iWs;
    private a.b iWw;
    private a.b iWx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.iUY = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.iWA = null;
        this.eJF = null;
        this.eJG = null;
        this.iWB = null;
        this.iWC = null;
        this.iWD = null;
        this.iWE = null;
        this.iWF = null;
        this.iWG = null;
        this.iWH = null;
        this.iWI = null;
        this.iWJ = null;
        this.iWK = null;
        this.iWr = "";
        this.iWs = "";
        this.iWk = false;
        this.iWL = null;
        this.iVY = null;
        this.iWg = "";
        this.iWh = "";
        this.iWx = null;
        this.iWw = null;
        this.iWr = str;
        this.iWs = str2;
        this.iWk = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void csz() {
        this.iVY.startLoad();
    }

    public void csA() {
        if (this.iVY != null) {
            this.iVY.cancelLoad();
            this.iVY = null;
        }
    }

    public void csP() {
        this.iWD.setVisibility(8);
    }

    public void csQ() {
        this.iWD.setVisibility(0);
    }

    public void csM() {
        if (this.iWL != null) {
            this.iWL.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.iWA = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.iWC = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.iWB = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.iWB.setOnClickListener(this.iWA);
        this.iWD = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.iWr)) {
            stringBuffer.append(this.iWr);
        }
        if (!TextUtils.isEmpty(this.iWs)) {
            stringBuffer.append(this.iWs);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.iWB.setVisibility(0);
            this.iWC.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.iWB.setVisibility(8);
            this.iWC.setVisibility(8);
        }
        this.iWF = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.iWF.setOnClickListener(this.iWA);
        this.iWG = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.iWH = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.iWH.setVisibility(8);
        this.iWE = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.iWI = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.iWI.setOnItemClickListener(this.iWA);
        this.iWK = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.iWk) {
            this.iWK.turnOn();
        } else {
            this.iWK.turnOff();
        }
        this.iWK.setSwitchStateChangeListener(this.iWA);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eJG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eJF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eJG.setOnClickListener(groupAddressLocateActivity);
        this.eJF.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.iVY = new com.baidu.tieba.im.util.b(this.iWA);
        this.iVY.setUniqueId(this.iWA.getUniqueId());
        if (!ad.d(this.iWA, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            csz();
        }
    }

    public void csR() {
        this.iWE.setText(R.string.address_pos_list);
        this.iWG.setText(R.string.location_loading);
        this.iWH.setVisibility(8);
        this.iUY = 3;
        csT();
    }

    public void csS() {
        this.iWE.setText(R.string.address_locate_noaddresslist);
        this.iWG.setText(R.string.address_locate_failed_tryagain);
        this.iWH.setVisibility(0);
        this.iUY = 2;
        csT();
    }

    public void I(String[] strArr) {
        this.iWF.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.iWE.setText(R.string.address_pos_list);
            this.iWL = new m(this.iWA, strArr);
            this.iWI.setAdapter((ListAdapter) this.iWL);
            this.iWI.setVisibility(0);
        } else {
            this.iWE.setText(R.string.address_locate_noaddresslist);
        }
        csT();
    }

    public void crK() {
        this.iWE.setText(R.string.address_pos_list);
        this.iWG.setText(R.string.address_locate_failed_opengps);
        this.iWH.setVisibility(0);
        this.iUY = 1;
        csT();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.iWG.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.iWJ = (AnimationDrawable) compoundDrawables[0];
            csT();
        }
    }

    private void csT() {
        if (this.iWJ != null) {
            if (this.iUY == 3) {
                this.iWJ.start();
                return;
            }
            this.iWJ.stop();
            this.iWJ.selectDrawable(0);
        }
    }

    public void Ho(String str) {
        this.iWg = str;
    }

    public void Hp(String str) {
        this.iWh = str;
    }

    public View csL() {
        return this.eJF;
    }

    public View getBackButton() {
        return this.eJG;
    }

    public View csU() {
        return this.iWB;
    }

    public View csV() {
        return this.iWF;
    }

    public int crI() {
        return this.iUY;
    }

    public void b(a.b bVar) {
        this.iWx = bVar;
    }

    public void c(a.b bVar) {
        this.iWw = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iWA.getPageContext().getPageActivity());
        aVar.hJ(false);
        aVar.ln(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iWx != null) {
                    n.this.iWx.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iWw != null) {
                    n.this.iWw.onClick(aVar2);
                }
            }
        });
        aVar.b(this.iWA.getPageContext());
        aVar.aYL();
    }

    public void onChangeSkinType(int i) {
        this.iWA.getLayoutMode().setNightMode(i == 1);
        this.iWA.getLayoutMode().onModeChanged(this.mParent);
        ao.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ao.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ao.setViewTextColor(this.eJF, R.color.cp_cont_f, 1);
    }
}
