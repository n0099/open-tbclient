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
/* loaded from: classes7.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView dBx;
    private View dBy;
    private int hql;
    private String hrE;
    private String hrF;
    private a.b hrJ;
    private a.b hrK;
    private GroupAddressLocateActivity hrN;
    private View hrO;
    private TextView hrP;
    private ImageView hrQ;
    private TextView hrR;
    private View hrS;
    private TextView hrT;
    private ImageView hrU;
    private BdListView hrV;
    private AnimationDrawable hrW;
    private SettingTextSwitchView hrX;
    private m hrY;
    private com.baidu.tieba.im.util.b hrl;
    private String hrt;
    private String hru;
    private boolean hrx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.hql = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.hrN = null;
        this.dBx = null;
        this.dBy = null;
        this.hrO = null;
        this.hrP = null;
        this.hrQ = null;
        this.hrR = null;
        this.hrS = null;
        this.hrT = null;
        this.hrU = null;
        this.hrV = null;
        this.hrW = null;
        this.hrX = null;
        this.hrE = "";
        this.hrF = "";
        this.hrx = false;
        this.hrY = null;
        this.hrl = null;
        this.hrt = "";
        this.hru = "";
        this.hrK = null;
        this.hrJ = null;
        this.hrE = str;
        this.hrF = str2;
        this.hrx = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bQT() {
        this.hrl.startLoad();
    }

    public void bQU() {
        if (this.hrl != null) {
            this.hrl.cancelLoad();
            this.hrl = null;
        }
    }

    public void bRj() {
        this.hrQ.setVisibility(8);
    }

    public void bRk() {
        this.hrQ.setVisibility(0);
    }

    public void bRg() {
        if (this.hrY != null) {
            this.hrY.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.hrN = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.hrP = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.hrO = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.hrO.setOnClickListener(this.hrN);
        this.hrQ = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.hrE)) {
            stringBuffer.append(this.hrE);
        }
        if (!TextUtils.isEmpty(this.hrF)) {
            stringBuffer.append(this.hrF);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.hrO.setVisibility(0);
            this.hrP.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.hrO.setVisibility(8);
            this.hrP.setVisibility(8);
        }
        this.hrS = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.hrS.setOnClickListener(this.hrN);
        this.hrT = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.hrU = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.hrU.setVisibility(8);
        this.hrR = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.hrV = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.hrV.setOnItemClickListener(this.hrN);
        this.hrX = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.hrx) {
            this.hrX.turnOn();
        } else {
            this.hrX.turnOff();
        }
        this.hrX.setSwitchStateChangeListener(this.hrN);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dBy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dBx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.dBy.setOnClickListener(groupAddressLocateActivity);
        this.dBx.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.hrl = new com.baidu.tieba.im.util.b(this.hrN);
        this.hrl.setUniqueId(this.hrN.getUniqueId());
        bQT();
    }

    public void bRl() {
        this.hrR.setText(R.string.address_pos_list);
        this.hrT.setText(R.string.location_loading);
        this.hrU.setVisibility(8);
        this.hql = 3;
        bRn();
    }

    public void bRm() {
        this.hrR.setText(R.string.address_locate_noaddresslist);
        this.hrT.setText(R.string.address_locate_failed_tryagain);
        this.hrU.setVisibility(0);
        this.hql = 2;
        bRn();
    }

    public void H(String[] strArr) {
        this.hrS.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.hrR.setText(R.string.address_pos_list);
            this.hrY = new m(this.hrN, strArr);
            this.hrV.setAdapter((ListAdapter) this.hrY);
            this.hrV.setVisibility(0);
        } else {
            this.hrR.setText(R.string.address_locate_noaddresslist);
        }
        bRn();
    }

    public void bQe() {
        this.hrR.setText(R.string.address_pos_list);
        this.hrT.setText(R.string.address_locate_failed_opengps);
        this.hrU.setVisibility(0);
        this.hql = 1;
        bRn();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.hrT.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.hrW = (AnimationDrawable) compoundDrawables[0];
            bRn();
        }
    }

    private void bRn() {
        if (this.hrW != null) {
            if (this.hql == 3) {
                this.hrW.start();
                return;
            }
            this.hrW.stop();
            this.hrW.selectDrawable(0);
        }
    }

    public void Cd(String str) {
        this.hrt = str;
    }

    public void Ce(String str) {
        this.hru = str;
    }

    public View bRf() {
        return this.dBx;
    }

    public View getBackButton() {
        return this.dBy;
    }

    public View bRo() {
        return this.hrO;
    }

    public View bRp() {
        return this.hrS;
    }

    public int bQc() {
        return this.hql;
    }

    public void b(a.b bVar) {
        this.hrK = bVar;
    }

    public void c(a.b bVar) {
        this.hrJ = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hrN.getPageContext().getPageActivity());
        aVar.fu(false);
        aVar.jF(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hrK != null) {
                    n.this.hrK.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hrJ != null) {
                    n.this.hrJ.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hrN.getPageContext());
        aVar.aBW();
    }

    public void onChangeSkinType(int i) {
        this.hrN.getLayoutMode().setNightMode(i == 1);
        this.hrN.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dBx, R.color.cp_cont_f, 1);
    }
}
