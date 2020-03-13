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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView dFW;
    private View dFX;
    private int hwb;
    private a.b hxA;
    private GroupAddressLocateActivity hxD;
    private View hxE;
    private TextView hxF;
    private ImageView hxG;
    private TextView hxH;
    private View hxI;
    private TextView hxJ;
    private ImageView hxK;
    private BdListView hxL;
    private AnimationDrawable hxM;
    private SettingTextSwitchView hxN;
    private m hxO;
    private com.baidu.tieba.im.util.b hxb;
    private String hxj;
    private String hxk;
    private boolean hxn;
    private String hxu;
    private String hxv;
    private a.b hxz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.hwb = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.hxD = null;
        this.dFW = null;
        this.dFX = null;
        this.hxE = null;
        this.hxF = null;
        this.hxG = null;
        this.hxH = null;
        this.hxI = null;
        this.hxJ = null;
        this.hxK = null;
        this.hxL = null;
        this.hxM = null;
        this.hxN = null;
        this.hxu = "";
        this.hxv = "";
        this.hxn = false;
        this.hxO = null;
        this.hxb = null;
        this.hxj = "";
        this.hxk = "";
        this.hxA = null;
        this.hxz = null;
        this.hxu = str;
        this.hxv = str2;
        this.hxn = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bTG() {
        this.hxb.startLoad();
    }

    public void bTH() {
        if (this.hxb != null) {
            this.hxb.cancelLoad();
            this.hxb = null;
        }
    }

    public void bTW() {
        this.hxG.setVisibility(8);
    }

    public void bTX() {
        this.hxG.setVisibility(0);
    }

    public void bTT() {
        if (this.hxO != null) {
            this.hxO.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.hxD = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.hxF = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.hxE = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.hxE.setOnClickListener(this.hxD);
        this.hxG = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.hxu)) {
            stringBuffer.append(this.hxu);
        }
        if (!TextUtils.isEmpty(this.hxv)) {
            stringBuffer.append(this.hxv);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.hxE.setVisibility(0);
            this.hxF.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.hxE.setVisibility(8);
            this.hxF.setVisibility(8);
        }
        this.hxI = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.hxI.setOnClickListener(this.hxD);
        this.hxJ = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.hxK = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.hxK.setVisibility(8);
        this.hxH = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.hxL = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.hxL.setOnItemClickListener(this.hxD);
        this.hxN = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.hxn) {
            this.hxN.turnOn();
        } else {
            this.hxN.turnOff();
        }
        this.hxN.setSwitchStateChangeListener(this.hxD);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dFX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.dFX.setOnClickListener(groupAddressLocateActivity);
        this.dFW.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.hxb = new com.baidu.tieba.im.util.b(this.hxD);
        this.hxb.setUniqueId(this.hxD.getUniqueId());
        if (!ab.e(this.hxD, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            bTG();
        }
    }

    public void bTY() {
        this.hxH.setText(R.string.address_pos_list);
        this.hxJ.setText(R.string.location_loading);
        this.hxK.setVisibility(8);
        this.hwb = 3;
        bUa();
    }

    public void bTZ() {
        this.hxH.setText(R.string.address_locate_noaddresslist);
        this.hxJ.setText(R.string.address_locate_failed_tryagain);
        this.hxK.setVisibility(0);
        this.hwb = 2;
        bUa();
    }

    public void I(String[] strArr) {
        this.hxI.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.hxH.setText(R.string.address_pos_list);
            this.hxO = new m(this.hxD, strArr);
            this.hxL.setAdapter((ListAdapter) this.hxO);
            this.hxL.setVisibility(0);
        } else {
            this.hxH.setText(R.string.address_locate_noaddresslist);
        }
        bUa();
    }

    public void bSR() {
        this.hxH.setText(R.string.address_pos_list);
        this.hxJ.setText(R.string.address_locate_failed_opengps);
        this.hxK.setVisibility(0);
        this.hwb = 1;
        bUa();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.hxJ.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.hxM = (AnimationDrawable) compoundDrawables[0];
            bUa();
        }
    }

    private void bUa() {
        if (this.hxM != null) {
            if (this.hwb == 3) {
                this.hxM.start();
                return;
            }
            this.hxM.stop();
            this.hxM.selectDrawable(0);
        }
    }

    public void CE(String str) {
        this.hxj = str;
    }

    public void CF(String str) {
        this.hxk = str;
    }

    public View bTS() {
        return this.dFW;
    }

    public View getBackButton() {
        return this.dFX;
    }

    public View bUb() {
        return this.hxE;
    }

    public View bUc() {
        return this.hxI;
    }

    public int bSP() {
        return this.hwb;
    }

    public void b(a.b bVar) {
        this.hxA = bVar;
    }

    public void c(a.b bVar) {
        this.hxz = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hxD.getPageContext().getPageActivity());
        aVar.fG(false);
        aVar.jW(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hxA != null) {
                    n.this.hxA.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hxz != null) {
                    n.this.hxz.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hxD.getPageContext());
        aVar.aEC();
    }

    public void onChangeSkinType(int i) {
        this.hxD.getLayoutMode().setNightMode(i == 1);
        this.hxD.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dFW, R.color.cp_cont_f, 1);
    }
}
