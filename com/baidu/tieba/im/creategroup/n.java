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
    private TextView eum;
    private View eun;
    private int iwd;
    private a.b ixB;
    private a.b ixC;
    private GroupAddressLocateActivity ixF;
    private View ixG;
    private TextView ixH;
    private ImageView ixI;
    private TextView ixJ;
    private View ixK;
    private TextView ixL;
    private ImageView ixM;
    private BdListView ixN;
    private AnimationDrawable ixO;
    private SettingTextSwitchView ixP;
    private m ixQ;
    private com.baidu.tieba.im.util.b ixd;
    private String ixl;
    private String ixm;
    private boolean ixp;
    private String ixw;
    private String ixx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.iwd = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.ixF = null;
        this.eum = null;
        this.eun = null;
        this.ixG = null;
        this.ixH = null;
        this.ixI = null;
        this.ixJ = null;
        this.ixK = null;
        this.ixL = null;
        this.ixM = null;
        this.ixN = null;
        this.ixO = null;
        this.ixP = null;
        this.ixw = "";
        this.ixx = "";
        this.ixp = false;
        this.ixQ = null;
        this.ixd = null;
        this.ixl = "";
        this.ixm = "";
        this.ixC = null;
        this.ixB = null;
        this.ixw = str;
        this.ixx = str2;
        this.ixp = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void ckV() {
        this.ixd.startLoad();
    }

    public void ckW() {
        if (this.ixd != null) {
            this.ixd.cancelLoad();
            this.ixd = null;
        }
    }

    public void cll() {
        this.ixI.setVisibility(8);
    }

    public void clm() {
        this.ixI.setVisibility(0);
    }

    public void cli() {
        if (this.ixQ != null) {
            this.ixQ.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.ixF = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.ixH = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.ixG = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.ixG.setOnClickListener(this.ixF);
        this.ixI = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.ixw)) {
            stringBuffer.append(this.ixw);
        }
        if (!TextUtils.isEmpty(this.ixx)) {
            stringBuffer.append(this.ixx);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.ixG.setVisibility(0);
            this.ixH.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.ixG.setVisibility(8);
            this.ixH.setVisibility(8);
        }
        this.ixK = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.ixK.setOnClickListener(this.ixF);
        this.ixL = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.ixM = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.ixM.setVisibility(8);
        this.ixJ = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.ixN = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.ixN.setOnItemClickListener(this.ixF);
        this.ixP = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.ixp) {
            this.ixP.turnOn();
        } else {
            this.ixP.turnOff();
        }
        this.ixP.setSwitchStateChangeListener(this.ixF);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eum = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eun.setOnClickListener(groupAddressLocateActivity);
        this.eum.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.ixd = new com.baidu.tieba.im.util.b(this.ixF);
        this.ixd.setUniqueId(this.ixF.getUniqueId());
        if (!ab.d(this.ixF, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            ckV();
        }
    }

    public void cln() {
        this.ixJ.setText(R.string.address_pos_list);
        this.ixL.setText(R.string.location_loading);
        this.ixM.setVisibility(8);
        this.iwd = 3;
        clp();
    }

    public void clo() {
        this.ixJ.setText(R.string.address_locate_noaddresslist);
        this.ixL.setText(R.string.address_locate_failed_tryagain);
        this.ixM.setVisibility(0);
        this.iwd = 2;
        clp();
    }

    public void L(String[] strArr) {
        this.ixK.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.ixJ.setText(R.string.address_pos_list);
            this.ixQ = new m(this.ixF, strArr);
            this.ixN.setAdapter((ListAdapter) this.ixQ);
            this.ixN.setVisibility(0);
        } else {
            this.ixJ.setText(R.string.address_locate_noaddresslist);
        }
        clp();
    }

    public void ckg() {
        this.ixJ.setText(R.string.address_pos_list);
        this.ixL.setText(R.string.address_locate_failed_opengps);
        this.ixM.setVisibility(0);
        this.iwd = 1;
        clp();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.ixL.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.ixO = (AnimationDrawable) compoundDrawables[0];
            clp();
        }
    }

    private void clp() {
        if (this.ixO != null) {
            if (this.iwd == 3) {
                this.ixO.start();
                return;
            }
            this.ixO.stop();
            this.ixO.selectDrawable(0);
        }
    }

    public void FY(String str) {
        this.ixl = str;
    }

    public void FZ(String str) {
        this.ixm = str;
    }

    public View clh() {
        return this.eum;
    }

    public View getBackButton() {
        return this.eun;
    }

    public View clq() {
        return this.ixG;
    }

    public View clr() {
        return this.ixK;
    }

    public int cke() {
        return this.iwd;
    }

    public void b(a.b bVar) {
        this.ixC = bVar;
    }

    public void c(a.b bVar) {
        this.ixB = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ixF.getPageContext().getPageActivity());
        aVar.gW(false);
        aVar.kD(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ixC != null) {
                    n.this.ixC.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ixB != null) {
                    n.this.ixB.onClick(aVar2);
                }
            }
        });
        aVar.b(this.ixF.getPageContext());
        aVar.aST();
    }

    public void onChangeSkinType(int i) {
        this.ixF.getLayoutMode().setNightMode(i == 1);
        this.ixF.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.eum, R.color.cp_cont_f, 1);
    }
}
