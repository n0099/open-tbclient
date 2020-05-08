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
    private TextView efY;
    private View efZ;
    private int ihu;
    private String iiC;
    private String iiD;
    private boolean iiG;
    private String iiN;
    private String iiO;
    private a.b iiS;
    private a.b iiT;
    private GroupAddressLocateActivity iiW;
    private View iiX;
    private TextView iiY;
    private ImageView iiZ;
    private com.baidu.tieba.im.util.b iiu;
    private TextView ija;
    private View ijb;
    private TextView ijc;
    private ImageView ijd;
    private BdListView ije;
    private AnimationDrawable ijf;
    private SettingTextSwitchView ijg;
    private m ijh;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.ihu = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.iiW = null;
        this.efY = null;
        this.efZ = null;
        this.iiX = null;
        this.iiY = null;
        this.iiZ = null;
        this.ija = null;
        this.ijb = null;
        this.ijc = null;
        this.ijd = null;
        this.ije = null;
        this.ijf = null;
        this.ijg = null;
        this.iiN = "";
        this.iiO = "";
        this.iiG = false;
        this.ijh = null;
        this.iiu = null;
        this.iiC = "";
        this.iiD = "";
        this.iiT = null;
        this.iiS = null;
        this.iiN = str;
        this.iiO = str2;
        this.iiG = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cex() {
        this.iiu.startLoad();
    }

    public void cey() {
        if (this.iiu != null) {
            this.iiu.cancelLoad();
            this.iiu = null;
        }
    }

    public void ceN() {
        this.iiZ.setVisibility(8);
    }

    public void ceO() {
        this.iiZ.setVisibility(0);
    }

    public void ceK() {
        if (this.ijh != null) {
            this.ijh.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.iiW = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.iiY = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.iiX = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.iiX.setOnClickListener(this.iiW);
        this.iiZ = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.iiN)) {
            stringBuffer.append(this.iiN);
        }
        if (!TextUtils.isEmpty(this.iiO)) {
            stringBuffer.append(this.iiO);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.iiX.setVisibility(0);
            this.iiY.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.iiX.setVisibility(8);
            this.iiY.setVisibility(8);
        }
        this.ijb = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.ijb.setOnClickListener(this.iiW);
        this.ijc = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.ijd = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.ijd.setVisibility(8);
        this.ija = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.ije = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.ije.setOnItemClickListener(this.iiW);
        this.ijg = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.iiG) {
            this.ijg.turnOn();
        } else {
            this.ijg.turnOff();
        }
        this.ijg.setSwitchStateChangeListener(this.iiW);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.efZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.efY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.efZ.setOnClickListener(groupAddressLocateActivity);
        this.efY.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.iiu = new com.baidu.tieba.im.util.b(this.iiW);
        this.iiu.setUniqueId(this.iiW.getUniqueId());
        if (!ab.d(this.iiW, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cex();
        }
    }

    public void ceP() {
        this.ija.setText(R.string.address_pos_list);
        this.ijc.setText(R.string.location_loading);
        this.ijd.setVisibility(8);
        this.ihu = 3;
        ceR();
    }

    public void ceQ() {
        this.ija.setText(R.string.address_locate_noaddresslist);
        this.ijc.setText(R.string.address_locate_failed_tryagain);
        this.ijd.setVisibility(0);
        this.ihu = 2;
        ceR();
    }

    public void I(String[] strArr) {
        this.ijb.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.ija.setText(R.string.address_pos_list);
            this.ijh = new m(this.iiW, strArr);
            this.ije.setAdapter((ListAdapter) this.ijh);
            this.ije.setVisibility(0);
        } else {
            this.ija.setText(R.string.address_locate_noaddresslist);
        }
        ceR();
    }

    public void cdH() {
        this.ija.setText(R.string.address_pos_list);
        this.ijc.setText(R.string.address_locate_failed_opengps);
        this.ijd.setVisibility(0);
        this.ihu = 1;
        ceR();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.ijc.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.ijf = (AnimationDrawable) compoundDrawables[0];
            ceR();
        }
    }

    private void ceR() {
        if (this.ijf != null) {
            if (this.ihu == 3) {
                this.ijf.start();
                return;
            }
            this.ijf.stop();
            this.ijf.selectDrawable(0);
        }
    }

    public void Ep(String str) {
        this.iiC = str;
    }

    public void Eq(String str) {
        this.iiD = str;
    }

    public View ceJ() {
        return this.efY;
    }

    public View getBackButton() {
        return this.efZ;
    }

    public View ceS() {
        return this.iiX;
    }

    public View ceT() {
        return this.ijb;
    }

    public int cdF() {
        return this.ihu;
    }

    public void b(a.b bVar) {
        this.iiT = bVar;
    }

    public void c(a.b bVar) {
        this.iiS = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iiW.getPageContext().getPageActivity());
        aVar.gE(false);
        aVar.kd(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iiT != null) {
                    n.this.iiT.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iiS != null) {
                    n.this.iiS.onClick(aVar2);
                }
            }
        });
        aVar.b(this.iiW.getPageContext());
        aVar.aMS();
    }

    public void onChangeSkinType(int i) {
        this.iiW.getLayoutMode().setNightMode(i == 1);
        this.iiW.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.efY, R.color.cp_cont_f, 1);
    }
}
