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
/* loaded from: classes17.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView eUp;
    private View eUq;
    private int jkf;
    private a.b jlD;
    private a.b jlE;
    private GroupAddressLocateActivity jlH;
    private View jlI;
    private TextView jlJ;
    private ImageView jlK;
    private TextView jlL;
    private View jlM;
    private TextView jlN;
    private ImageView jlO;
    private BdListView jlP;
    private AnimationDrawable jlQ;
    private SettingTextSwitchView jlR;
    private m jlS;
    private com.baidu.tieba.im.util.b jlf;
    private String jln;
    private String jlo;
    private boolean jlr;
    private String jly;
    private String jlz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.jkf = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.jlH = null;
        this.eUp = null;
        this.eUq = null;
        this.jlI = null;
        this.jlJ = null;
        this.jlK = null;
        this.jlL = null;
        this.jlM = null;
        this.jlN = null;
        this.jlO = null;
        this.jlP = null;
        this.jlQ = null;
        this.jlR = null;
        this.jly = "";
        this.jlz = "";
        this.jlr = false;
        this.jlS = null;
        this.jlf = null;
        this.jln = "";
        this.jlo = "";
        this.jlE = null;
        this.jlD = null;
        this.jly = str;
        this.jlz = str2;
        this.jlr = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cDr() {
        this.jlf.startLoad();
    }

    public void cDs() {
        if (this.jlf != null) {
            this.jlf.cancelLoad();
            this.jlf = null;
        }
    }

    public void cDH() {
        this.jlK.setVisibility(8);
    }

    public void cDI() {
        this.jlK.setVisibility(0);
    }

    public void cDE() {
        if (this.jlS != null) {
            this.jlS.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.jlH = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.jlJ = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.jlI = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.jlI.setOnClickListener(this.jlH);
        this.jlK = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.jly)) {
            stringBuffer.append(this.jly);
        }
        if (!TextUtils.isEmpty(this.jlz)) {
            stringBuffer.append(this.jlz);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.jlI.setVisibility(0);
            this.jlJ.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.jlI.setVisibility(8);
            this.jlJ.setVisibility(8);
        }
        this.jlM = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.jlM.setOnClickListener(this.jlH);
        this.jlN = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.jlO = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.jlO.setVisibility(8);
        this.jlL = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.jlP = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.jlP.setOnItemClickListener(this.jlH);
        this.jlR = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.jlr) {
            this.jlR.turnOn();
        } else {
            this.jlR.turnOff();
        }
        this.jlR.setSwitchStateChangeListener(this.jlH);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eUq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eUp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eUq.setOnClickListener(groupAddressLocateActivity);
        this.eUp.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.jlf = new com.baidu.tieba.im.util.b(this.jlH);
        this.jlf.setUniqueId(this.jlH.getUniqueId());
        if (!ae.d(this.jlH, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cDr();
        }
    }

    public void cDJ() {
        this.jlL.setText(R.string.address_pos_list);
        this.jlN.setText(R.string.location_loading);
        this.jlO.setVisibility(8);
        this.jkf = 3;
        cDL();
    }

    public void cDK() {
        this.jlL.setText(R.string.address_locate_noaddresslist);
        this.jlN.setText(R.string.address_locate_failed_tryagain);
        this.jlO.setVisibility(0);
        this.jkf = 2;
        cDL();
    }

    public void J(String[] strArr) {
        this.jlM.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.jlL.setText(R.string.address_pos_list);
            this.jlS = new m(this.jlH, strArr);
            this.jlP.setAdapter((ListAdapter) this.jlS);
            this.jlP.setVisibility(0);
        } else {
            this.jlL.setText(R.string.address_locate_noaddresslist);
        }
        cDL();
    }

    public void cCD() {
        this.jlL.setText(R.string.address_pos_list);
        this.jlN.setText(R.string.address_locate_failed_opengps);
        this.jlO.setVisibility(0);
        this.jkf = 1;
        cDL();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.jlN.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.jlQ = (AnimationDrawable) compoundDrawables[0];
            cDL();
        }
    }

    private void cDL() {
        if (this.jlQ != null) {
            if (this.jkf == 3) {
                this.jlQ.start();
                return;
            }
            this.jlQ.stop();
            this.jlQ.selectDrawable(0);
        }
    }

    public void Kh(String str) {
        this.jln = str;
    }

    public void Ki(String str) {
        this.jlo = str;
    }

    public View cDD() {
        return this.eUp;
    }

    public View getBackButton() {
        return this.eUq;
    }

    public View cDM() {
        return this.jlI;
    }

    public View cDN() {
        return this.jlM;
    }

    public int cCB() {
        return this.jkf;
    }

    public void b(a.b bVar) {
        this.jlE = bVar;
    }

    public void c(a.b bVar) {
        this.jlD = bVar;
    }

    public void Nv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jlH.getPageContext().getPageActivity());
        aVar.ig(false);
        aVar.nt(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.jlE != null) {
                    n.this.jlE.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.jlD != null) {
                    n.this.jlD.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jlH.getPageContext());
        aVar.bhg();
    }

    public void onChangeSkinType(int i) {
        this.jlH.getLayoutMode().setNightMode(i == 1);
        this.jlH.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.eUp, R.color.cp_cont_f, 1);
    }
}
