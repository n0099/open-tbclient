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
    private TextView efT;
    private View efU;
    private int iho;
    private boolean iiA;
    private String iiH;
    private String iiI;
    private a.b iiM;
    private a.b iiN;
    private GroupAddressLocateActivity iiQ;
    private View iiR;
    private TextView iiS;
    private ImageView iiT;
    private TextView iiU;
    private View iiV;
    private TextView iiW;
    private ImageView iiX;
    private BdListView iiY;
    private AnimationDrawable iiZ;
    private com.baidu.tieba.im.util.b iio;
    private String iiw;
    private String iix;
    private SettingTextSwitchView ija;
    private m ijb;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.iho = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.iiQ = null;
        this.efT = null;
        this.efU = null;
        this.iiR = null;
        this.iiS = null;
        this.iiT = null;
        this.iiU = null;
        this.iiV = null;
        this.iiW = null;
        this.iiX = null;
        this.iiY = null;
        this.iiZ = null;
        this.ija = null;
        this.iiH = "";
        this.iiI = "";
        this.iiA = false;
        this.ijb = null;
        this.iio = null;
        this.iiw = "";
        this.iix = "";
        this.iiN = null;
        this.iiM = null;
        this.iiH = str;
        this.iiI = str2;
        this.iiA = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cez() {
        this.iio.startLoad();
    }

    public void ceA() {
        if (this.iio != null) {
            this.iio.cancelLoad();
            this.iio = null;
        }
    }

    public void ceP() {
        this.iiT.setVisibility(8);
    }

    public void ceQ() {
        this.iiT.setVisibility(0);
    }

    public void ceM() {
        if (this.ijb != null) {
            this.ijb.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.iiQ = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.iiS = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.iiR = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.iiR.setOnClickListener(this.iiQ);
        this.iiT = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.iiH)) {
            stringBuffer.append(this.iiH);
        }
        if (!TextUtils.isEmpty(this.iiI)) {
            stringBuffer.append(this.iiI);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.iiR.setVisibility(0);
            this.iiS.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.iiR.setVisibility(8);
            this.iiS.setVisibility(8);
        }
        this.iiV = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.iiV.setOnClickListener(this.iiQ);
        this.iiW = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.iiX = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.iiX.setVisibility(8);
        this.iiU = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.iiY = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.iiY.setOnItemClickListener(this.iiQ);
        this.ija = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.iiA) {
            this.ija.turnOn();
        } else {
            this.ija.turnOff();
        }
        this.ija.setSwitchStateChangeListener(this.iiQ);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.efU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.efT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.efU.setOnClickListener(groupAddressLocateActivity);
        this.efT.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.iio = new com.baidu.tieba.im.util.b(this.iiQ);
        this.iio.setUniqueId(this.iiQ.getUniqueId());
        if (!ab.d(this.iiQ, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cez();
        }
    }

    public void ceR() {
        this.iiU.setText(R.string.address_pos_list);
        this.iiW.setText(R.string.location_loading);
        this.iiX.setVisibility(8);
        this.iho = 3;
        ceT();
    }

    public void ceS() {
        this.iiU.setText(R.string.address_locate_noaddresslist);
        this.iiW.setText(R.string.address_locate_failed_tryagain);
        this.iiX.setVisibility(0);
        this.iho = 2;
        ceT();
    }

    public void I(String[] strArr) {
        this.iiV.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.iiU.setText(R.string.address_pos_list);
            this.ijb = new m(this.iiQ, strArr);
            this.iiY.setAdapter((ListAdapter) this.ijb);
            this.iiY.setVisibility(0);
        } else {
            this.iiU.setText(R.string.address_locate_noaddresslist);
        }
        ceT();
    }

    public void cdJ() {
        this.iiU.setText(R.string.address_pos_list);
        this.iiW.setText(R.string.address_locate_failed_opengps);
        this.iiX.setVisibility(0);
        this.iho = 1;
        ceT();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.iiW.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.iiZ = (AnimationDrawable) compoundDrawables[0];
            ceT();
        }
    }

    private void ceT() {
        if (this.iiZ != null) {
            if (this.iho == 3) {
                this.iiZ.start();
                return;
            }
            this.iiZ.stop();
            this.iiZ.selectDrawable(0);
        }
    }

    public void Em(String str) {
        this.iiw = str;
    }

    public void En(String str) {
        this.iix = str;
    }

    public View ceL() {
        return this.efT;
    }

    public View getBackButton() {
        return this.efU;
    }

    public View ceU() {
        return this.iiR;
    }

    public View ceV() {
        return this.iiV;
    }

    public int cdH() {
        return this.iho;
    }

    public void b(a.b bVar) {
        this.iiN = bVar;
    }

    public void c(a.b bVar) {
        this.iiM = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iiQ.getPageContext().getPageActivity());
        aVar.gE(false);
        aVar.kd(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iiN != null) {
                    n.this.iiN.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iiM != null) {
                    n.this.iiM.onClick(aVar2);
                }
            }
        });
        aVar.b(this.iiQ.getPageContext());
        aVar.aMU();
    }

    public void onChangeSkinType(int i) {
        this.iiQ.getLayoutMode().setNightMode(i == 1);
        this.iiQ.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.efT, R.color.cp_cont_f, 1);
    }
}
