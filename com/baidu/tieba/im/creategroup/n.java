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
    private int iVa;
    private GroupAddressLocateActivity iWC;
    private View iWD;
    private TextView iWE;
    private ImageView iWF;
    private TextView iWG;
    private View iWH;
    private TextView iWI;
    private ImageView iWJ;
    private BdListView iWK;
    private AnimationDrawable iWL;
    private SettingTextSwitchView iWM;
    private m iWN;
    private com.baidu.tieba.im.util.b iWa;
    private String iWi;
    private String iWj;
    private boolean iWm;
    private String iWt;
    private String iWu;
    private a.b iWy;
    private a.b iWz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.iVa = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.iWC = null;
        this.eJF = null;
        this.eJG = null;
        this.iWD = null;
        this.iWE = null;
        this.iWF = null;
        this.iWG = null;
        this.iWH = null;
        this.iWI = null;
        this.iWJ = null;
        this.iWK = null;
        this.iWL = null;
        this.iWM = null;
        this.iWt = "";
        this.iWu = "";
        this.iWm = false;
        this.iWN = null;
        this.iWa = null;
        this.iWi = "";
        this.iWj = "";
        this.iWz = null;
        this.iWy = null;
        this.iWt = str;
        this.iWu = str2;
        this.iWm = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void csz() {
        this.iWa.startLoad();
    }

    public void csA() {
        if (this.iWa != null) {
            this.iWa.cancelLoad();
            this.iWa = null;
        }
    }

    public void csP() {
        this.iWF.setVisibility(8);
    }

    public void csQ() {
        this.iWF.setVisibility(0);
    }

    public void csM() {
        if (this.iWN != null) {
            this.iWN.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.iWC = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.iWE = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.iWD = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.iWD.setOnClickListener(this.iWC);
        this.iWF = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.iWt)) {
            stringBuffer.append(this.iWt);
        }
        if (!TextUtils.isEmpty(this.iWu)) {
            stringBuffer.append(this.iWu);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.iWD.setVisibility(0);
            this.iWE.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.iWD.setVisibility(8);
            this.iWE.setVisibility(8);
        }
        this.iWH = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.iWH.setOnClickListener(this.iWC);
        this.iWI = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.iWJ = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.iWJ.setVisibility(8);
        this.iWG = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.iWK = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.iWK.setOnItemClickListener(this.iWC);
        this.iWM = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.iWm) {
            this.iWM.turnOn();
        } else {
            this.iWM.turnOff();
        }
        this.iWM.setSwitchStateChangeListener(this.iWC);
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
        this.iWa = new com.baidu.tieba.im.util.b(this.iWC);
        this.iWa.setUniqueId(this.iWC.getUniqueId());
        if (!ad.d(this.iWC, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            csz();
        }
    }

    public void csR() {
        this.iWG.setText(R.string.address_pos_list);
        this.iWI.setText(R.string.location_loading);
        this.iWJ.setVisibility(8);
        this.iVa = 3;
        csT();
    }

    public void csS() {
        this.iWG.setText(R.string.address_locate_noaddresslist);
        this.iWI.setText(R.string.address_locate_failed_tryagain);
        this.iWJ.setVisibility(0);
        this.iVa = 2;
        csT();
    }

    public void I(String[] strArr) {
        this.iWH.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.iWG.setText(R.string.address_pos_list);
            this.iWN = new m(this.iWC, strArr);
            this.iWK.setAdapter((ListAdapter) this.iWN);
            this.iWK.setVisibility(0);
        } else {
            this.iWG.setText(R.string.address_locate_noaddresslist);
        }
        csT();
    }

    public void crK() {
        this.iWG.setText(R.string.address_pos_list);
        this.iWI.setText(R.string.address_locate_failed_opengps);
        this.iWJ.setVisibility(0);
        this.iVa = 1;
        csT();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.iWI.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.iWL = (AnimationDrawable) compoundDrawables[0];
            csT();
        }
    }

    private void csT() {
        if (this.iWL != null) {
            if (this.iVa == 3) {
                this.iWL.start();
                return;
            }
            this.iWL.stop();
            this.iWL.selectDrawable(0);
        }
    }

    public void Ho(String str) {
        this.iWi = str;
    }

    public void Hp(String str) {
        this.iWj = str;
    }

    public View csL() {
        return this.eJF;
    }

    public View getBackButton() {
        return this.eJG;
    }

    public View csU() {
        return this.iWD;
    }

    public View csV() {
        return this.iWH;
    }

    public int crI() {
        return this.iVa;
    }

    public void b(a.b bVar) {
        this.iWz = bVar;
    }

    public void c(a.b bVar) {
        this.iWy = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iWC.getPageContext().getPageActivity());
        aVar.hJ(false);
        aVar.ln(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iWz != null) {
                    n.this.iWz.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iWy != null) {
                    n.this.iWy.onClick(aVar2);
                }
            }
        });
        aVar.b(this.iWC.getPageContext());
        aVar.aYL();
    }

    public void onChangeSkinType(int i) {
        this.iWC.getLayoutMode().setNightMode(i == 1);
        this.iWC.getLayoutMode().onModeChanged(this.mParent);
        ao.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ao.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ao.setViewTextColor(this.eJF, R.color.cp_cont_f, 1);
    }
}
