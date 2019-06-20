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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView cAN;
    private View cAO;
    private int gwd;
    private a.b gxB;
    private a.b gxC;
    private GroupAddressLocateActivity gxF;
    private View gxG;
    private TextView gxH;
    private ImageView gxI;
    private TextView gxJ;
    private View gxK;
    private TextView gxL;
    private ImageView gxM;
    private BdListView gxN;
    private AnimationDrawable gxO;
    private SettingTextSwitchView gxP;
    private m gxQ;
    private com.baidu.tieba.im.util.b gxd;
    private String gxl;
    private String gxm;
    private boolean gxp;
    private String gxw;
    private String gxx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.gwd = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.gxF = null;
        this.cAN = null;
        this.cAO = null;
        this.gxG = null;
        this.gxH = null;
        this.gxI = null;
        this.gxJ = null;
        this.gxK = null;
        this.gxL = null;
        this.gxM = null;
        this.gxN = null;
        this.gxO = null;
        this.gxP = null;
        this.gxw = "";
        this.gxx = "";
        this.gxp = false;
        this.gxQ = null;
        this.gxd = null;
        this.gxl = "";
        this.gxm = "";
        this.gxC = null;
        this.gxB = null;
        this.gxw = str;
        this.gxx = str2;
        this.gxp = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bzn() {
        this.gxd.awO();
    }

    public void bzo() {
        if (this.gxd != null) {
            this.gxd.cancelLoad();
            this.gxd = null;
        }
    }

    public void bzD() {
        this.gxI.setVisibility(8);
    }

    public void bzE() {
        this.gxI.setVisibility(0);
    }

    public void bzA() {
        if (this.gxQ != null) {
            this.gxQ.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.gxF = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.gxH = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.gxG = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.gxG.setOnClickListener(this.gxF);
        this.gxI = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.gxw)) {
            stringBuffer.append(this.gxw);
        }
        if (!TextUtils.isEmpty(this.gxx)) {
            stringBuffer.append(this.gxx);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.gxG.setVisibility(0);
            this.gxH.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.gxG.setVisibility(8);
            this.gxH.setVisibility(8);
        }
        this.gxK = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.gxK.setOnClickListener(this.gxF);
        this.gxL = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.gxM = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.gxM.setVisibility(8);
        this.gxJ = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.gxN = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.gxN.setOnItemClickListener(this.gxF);
        this.gxP = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.gxp) {
            this.gxP.mV();
        } else {
            this.gxP.mW();
        }
        this.gxP.setSwitchStateChangeListener(this.gxF);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cAO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cAN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.cAO.setOnClickListener(groupAddressLocateActivity);
        this.cAN.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.gxd = new com.baidu.tieba.im.util.b(this.gxF);
        this.gxd.setUniqueId(this.gxF.getUniqueId());
        bzn();
    }

    public void bzF() {
        this.gxJ.setText(R.string.address_pos_list);
        this.gxL.setText(R.string.location_loading);
        this.gxM.setVisibility(8);
        this.gwd = 3;
        bzH();
    }

    public void bzG() {
        this.gxJ.setText(R.string.address_locate_noaddresslist);
        this.gxL.setText(R.string.address_locate_failed_tryagain);
        this.gxM.setVisibility(0);
        this.gwd = 2;
        bzH();
    }

    public void x(String[] strArr) {
        this.gxK.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.gxJ.setText(R.string.address_pos_list);
            this.gxQ = new m(this.gxF, strArr);
            this.gxN.setAdapter((ListAdapter) this.gxQ);
            this.gxN.setVisibility(0);
        } else {
            this.gxJ.setText(R.string.address_locate_noaddresslist);
        }
        bzH();
    }

    public void byy() {
        this.gxJ.setText(R.string.address_pos_list);
        this.gxL.setText(R.string.address_locate_failed_opengps);
        this.gxM.setVisibility(0);
        this.gwd = 1;
        bzH();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.gxL.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.gxO = (AnimationDrawable) compoundDrawables[0];
            bzH();
        }
    }

    private void bzH() {
        if (this.gxO != null) {
            if (this.gwd == 3) {
                this.gxO.start();
                return;
            }
            this.gxO.stop();
            this.gxO.selectDrawable(0);
        }
    }

    public void xR(String str) {
        this.gxl = str;
    }

    public void xS(String str) {
        this.gxm = str;
    }

    public View bzz() {
        return this.cAN;
    }

    public View getBackButton() {
        return this.cAO;
    }

    public View bzI() {
        return this.gxG;
    }

    public View bzJ() {
        return this.gxK;
    }

    public int byw() {
        return this.gwd;
    }

    public void b(a.b bVar) {
        this.gxC = bVar;
    }

    public void c(a.b bVar) {
        this.gxB = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gxF.getPageContext().getPageActivity());
        aVar.dM(false);
        aVar.ho(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gxC != null) {
                    n.this.gxC.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gxB != null) {
                    n.this.gxB.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gxF.getPageContext());
        aVar.afG();
    }

    public void onChangeSkinType(int i) {
        this.gxF.getLayoutMode().setNightMode(i == 1);
        this.gxF.getLayoutMode().onModeChanged(this.mParent);
        al.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.l(this.mParent, R.color.common_color_10041);
        al.f(this.cAN, R.color.cp_cont_f, 1);
    }
}
