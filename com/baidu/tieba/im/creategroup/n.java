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
    private int gwa;
    private GroupAddressLocateActivity gxC;
    private View gxD;
    private TextView gxE;
    private ImageView gxF;
    private TextView gxG;
    private View gxH;
    private TextView gxI;
    private ImageView gxJ;
    private BdListView gxK;
    private AnimationDrawable gxL;
    private SettingTextSwitchView gxM;
    private m gxN;
    private com.baidu.tieba.im.util.b gxa;
    private String gxi;
    private String gxj;
    private boolean gxm;
    private String gxt;
    private String gxu;
    private a.b gxy;
    private a.b gxz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.gwa = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.gxC = null;
        this.cAM = null;
        this.cAN = null;
        this.gxD = null;
        this.gxE = null;
        this.gxF = null;
        this.gxG = null;
        this.gxH = null;
        this.gxI = null;
        this.gxJ = null;
        this.gxK = null;
        this.gxL = null;
        this.gxM = null;
        this.gxt = "";
        this.gxu = "";
        this.gxm = false;
        this.gxN = null;
        this.gxa = null;
        this.gxi = "";
        this.gxj = "";
        this.gxz = null;
        this.gxy = null;
        this.gxt = str;
        this.gxu = str2;
        this.gxm = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bzj() {
        this.gxa.awN();
    }

    public void bzk() {
        if (this.gxa != null) {
            this.gxa.cancelLoad();
            this.gxa = null;
        }
    }

    public void bzz() {
        this.gxF.setVisibility(8);
    }

    public void bzA() {
        this.gxF.setVisibility(0);
    }

    public void bzw() {
        if (this.gxN != null) {
            this.gxN.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.gxC = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.gxE = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.gxD = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.gxD.setOnClickListener(this.gxC);
        this.gxF = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.gxt)) {
            stringBuffer.append(this.gxt);
        }
        if (!TextUtils.isEmpty(this.gxu)) {
            stringBuffer.append(this.gxu);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.gxD.setVisibility(0);
            this.gxE.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.gxD.setVisibility(8);
            this.gxE.setVisibility(8);
        }
        this.gxH = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.gxH.setOnClickListener(this.gxC);
        this.gxI = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.gxJ = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.gxJ.setVisibility(8);
        this.gxG = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.gxK = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.gxK.setOnItemClickListener(this.gxC);
        this.gxM = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.gxm) {
            this.gxM.mV();
        } else {
            this.gxM.mW();
        }
        this.gxM.setSwitchStateChangeListener(this.gxC);
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
        this.gxa = new com.baidu.tieba.im.util.b(this.gxC);
        this.gxa.setUniqueId(this.gxC.getUniqueId());
        bzj();
    }

    public void bzB() {
        this.gxG.setText(R.string.address_pos_list);
        this.gxI.setText(R.string.location_loading);
        this.gxJ.setVisibility(8);
        this.gwa = 3;
        bzD();
    }

    public void bzC() {
        this.gxG.setText(R.string.address_locate_noaddresslist);
        this.gxI.setText(R.string.address_locate_failed_tryagain);
        this.gxJ.setVisibility(0);
        this.gwa = 2;
        bzD();
    }

    public void x(String[] strArr) {
        this.gxH.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.gxG.setText(R.string.address_pos_list);
            this.gxN = new m(this.gxC, strArr);
            this.gxK.setAdapter((ListAdapter) this.gxN);
            this.gxK.setVisibility(0);
        } else {
            this.gxG.setText(R.string.address_locate_noaddresslist);
        }
        bzD();
    }

    public void byu() {
        this.gxG.setText(R.string.address_pos_list);
        this.gxI.setText(R.string.address_locate_failed_opengps);
        this.gxJ.setVisibility(0);
        this.gwa = 1;
        bzD();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.gxI.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.gxL = (AnimationDrawable) compoundDrawables[0];
            bzD();
        }
    }

    private void bzD() {
        if (this.gxL != null) {
            if (this.gwa == 3) {
                this.gxL.start();
                return;
            }
            this.gxL.stop();
            this.gxL.selectDrawable(0);
        }
    }

    public void xP(String str) {
        this.gxi = str;
    }

    public void xQ(String str) {
        this.gxj = str;
    }

    public View bzv() {
        return this.cAM;
    }

    public View getBackButton() {
        return this.cAN;
    }

    public View bzE() {
        return this.gxD;
    }

    public View bzF() {
        return this.gxH;
    }

    public int bys() {
        return this.gwa;
    }

    public void b(a.b bVar) {
        this.gxz = bVar;
    }

    public void c(a.b bVar) {
        this.gxy = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gxC.getPageContext().getPageActivity());
        aVar.dM(false);
        aVar.ho(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gxz != null) {
                    n.this.gxz.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gxy != null) {
                    n.this.gxy.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gxC.getPageContext());
        aVar.afG();
    }

    public void onChangeSkinType(int i) {
        this.gxC.getLayoutMode().setNightMode(i == 1);
        this.gxC.getLayoutMode().onModeChanged(this.mParent);
        al.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.l(this.mParent, R.color.common_color_10041);
        al.f(this.cAM, R.color.cp_cont_f, 1);
    }
}
