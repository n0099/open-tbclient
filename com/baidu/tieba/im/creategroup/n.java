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
    private TextView cAM;
    private View cAN;
    private int gwb;
    private a.b gxA;
    private GroupAddressLocateActivity gxD;
    private View gxE;
    private TextView gxF;
    private ImageView gxG;
    private TextView gxH;
    private View gxI;
    private TextView gxJ;
    private ImageView gxK;
    private BdListView gxL;
    private AnimationDrawable gxM;
    private SettingTextSwitchView gxN;
    private m gxO;
    private com.baidu.tieba.im.util.b gxb;
    private String gxj;
    private String gxk;
    private boolean gxn;
    private String gxu;
    private String gxv;
    private a.b gxz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.gwb = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.gxD = null;
        this.cAM = null;
        this.cAN = null;
        this.gxE = null;
        this.gxF = null;
        this.gxG = null;
        this.gxH = null;
        this.gxI = null;
        this.gxJ = null;
        this.gxK = null;
        this.gxL = null;
        this.gxM = null;
        this.gxN = null;
        this.gxu = "";
        this.gxv = "";
        this.gxn = false;
        this.gxO = null;
        this.gxb = null;
        this.gxj = "";
        this.gxk = "";
        this.gxA = null;
        this.gxz = null;
        this.gxu = str;
        this.gxv = str2;
        this.gxn = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bzm() {
        this.gxb.awO();
    }

    public void bzn() {
        if (this.gxb != null) {
            this.gxb.cancelLoad();
            this.gxb = null;
        }
    }

    public void bzC() {
        this.gxG.setVisibility(8);
    }

    public void bzD() {
        this.gxG.setVisibility(0);
    }

    public void bzz() {
        if (this.gxO != null) {
            this.gxO.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.gxD = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.gxF = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.gxE = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.gxE.setOnClickListener(this.gxD);
        this.gxG = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.gxu)) {
            stringBuffer.append(this.gxu);
        }
        if (!TextUtils.isEmpty(this.gxv)) {
            stringBuffer.append(this.gxv);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.gxE.setVisibility(0);
            this.gxF.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.gxE.setVisibility(8);
            this.gxF.setVisibility(8);
        }
        this.gxI = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.gxI.setOnClickListener(this.gxD);
        this.gxJ = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.gxK = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.gxK.setVisibility(8);
        this.gxH = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.gxL = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.gxL.setOnItemClickListener(this.gxD);
        this.gxN = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.gxn) {
            this.gxN.mV();
        } else {
            this.gxN.mW();
        }
        this.gxN.setSwitchStateChangeListener(this.gxD);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cAN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cAM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.cAN.setOnClickListener(groupAddressLocateActivity);
        this.cAM.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.gxb = new com.baidu.tieba.im.util.b(this.gxD);
        this.gxb.setUniqueId(this.gxD.getUniqueId());
        bzm();
    }

    public void bzE() {
        this.gxH.setText(R.string.address_pos_list);
        this.gxJ.setText(R.string.location_loading);
        this.gxK.setVisibility(8);
        this.gwb = 3;
        bzG();
    }

    public void bzF() {
        this.gxH.setText(R.string.address_locate_noaddresslist);
        this.gxJ.setText(R.string.address_locate_failed_tryagain);
        this.gxK.setVisibility(0);
        this.gwb = 2;
        bzG();
    }

    public void x(String[] strArr) {
        this.gxI.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.gxH.setText(R.string.address_pos_list);
            this.gxO = new m(this.gxD, strArr);
            this.gxL.setAdapter((ListAdapter) this.gxO);
            this.gxL.setVisibility(0);
        } else {
            this.gxH.setText(R.string.address_locate_noaddresslist);
        }
        bzG();
    }

    public void byx() {
        this.gxH.setText(R.string.address_pos_list);
        this.gxJ.setText(R.string.address_locate_failed_opengps);
        this.gxK.setVisibility(0);
        this.gwb = 1;
        bzG();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.gxJ.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.gxM = (AnimationDrawable) compoundDrawables[0];
            bzG();
        }
    }

    private void bzG() {
        if (this.gxM != null) {
            if (this.gwb == 3) {
                this.gxM.start();
                return;
            }
            this.gxM.stop();
            this.gxM.selectDrawable(0);
        }
    }

    public void xP(String str) {
        this.gxj = str;
    }

    public void xQ(String str) {
        this.gxk = str;
    }

    public View bzy() {
        return this.cAM;
    }

    public View getBackButton() {
        return this.cAN;
    }

    public View bzH() {
        return this.gxE;
    }

    public View bzI() {
        return this.gxI;
    }

    public int byv() {
        return this.gwb;
    }

    public void b(a.b bVar) {
        this.gxA = bVar;
    }

    public void c(a.b bVar) {
        this.gxz = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gxD.getPageContext().getPageActivity());
        aVar.dM(false);
        aVar.ho(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gxA != null) {
                    n.this.gxA.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gxz != null) {
                    n.this.gxz.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gxD.getPageContext());
        aVar.afG();
    }

    public void onChangeSkinType(int i) {
        this.gxD.getLayoutMode().setNightMode(i == 1);
        this.gxD.getLayoutMode().onModeChanged(this.mParent);
        al.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.l(this.mParent, R.color.common_color_10041);
        al.f(this.cAM, R.color.cp_cont_f, 1);
    }
}
