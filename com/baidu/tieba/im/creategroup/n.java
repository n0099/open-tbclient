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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView eDq;
    private View eDr;
    private int iNV;
    private com.baidu.tieba.im.util.b iOV;
    private ImageView iPA;
    private TextView iPB;
    private View iPC;
    private TextView iPD;
    private ImageView iPE;
    private BdListView iPF;
    private AnimationDrawable iPG;
    private SettingTextSwitchView iPH;
    private m iPI;
    private String iPd;
    private String iPe;
    private boolean iPh;
    private String iPo;
    private String iPp;
    private a.b iPt;
    private a.b iPu;
    private GroupAddressLocateActivity iPx;
    private View iPy;
    private TextView iPz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.iNV = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.iPx = null;
        this.eDq = null;
        this.eDr = null;
        this.iPy = null;
        this.iPz = null;
        this.iPA = null;
        this.iPB = null;
        this.iPC = null;
        this.iPD = null;
        this.iPE = null;
        this.iPF = null;
        this.iPG = null;
        this.iPH = null;
        this.iPo = "";
        this.iPp = "";
        this.iPh = false;
        this.iPI = null;
        this.iOV = null;
        this.iPd = "";
        this.iPe = "";
        this.iPu = null;
        this.iPt = null;
        this.iPo = str;
        this.iPp = str2;
        this.iPh = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void coU() {
        this.iOV.startLoad();
    }

    public void coV() {
        if (this.iOV != null) {
            this.iOV.cancelLoad();
            this.iOV = null;
        }
    }

    public void cpk() {
        this.iPA.setVisibility(8);
    }

    public void cpl() {
        this.iPA.setVisibility(0);
    }

    public void cph() {
        if (this.iPI != null) {
            this.iPI.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.iPx = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.iPz = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.iPy = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.iPy.setOnClickListener(this.iPx);
        this.iPA = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.iPo)) {
            stringBuffer.append(this.iPo);
        }
        if (!TextUtils.isEmpty(this.iPp)) {
            stringBuffer.append(this.iPp);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.iPy.setVisibility(0);
            this.iPz.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.iPy.setVisibility(8);
            this.iPz.setVisibility(8);
        }
        this.iPC = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.iPC.setOnClickListener(this.iPx);
        this.iPD = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.iPE = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.iPE.setVisibility(8);
        this.iPB = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.iPF = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.iPF.setOnItemClickListener(this.iPx);
        this.iPH = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.iPh) {
            this.iPH.turnOn();
        } else {
            this.iPH.turnOff();
        }
        this.iPH.setSwitchStateChangeListener(this.iPx);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eDr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eDq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eDr.setOnClickListener(groupAddressLocateActivity);
        this.eDq.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.iOV = new com.baidu.tieba.im.util.b(this.iPx);
        this.iOV.setUniqueId(this.iPx.getUniqueId());
        if (!ac.d(this.iPx, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            coU();
        }
    }

    public void cpm() {
        this.iPB.setText(R.string.address_pos_list);
        this.iPD.setText(R.string.location_loading);
        this.iPE.setVisibility(8);
        this.iNV = 3;
        cpo();
    }

    public void cpn() {
        this.iPB.setText(R.string.address_locate_noaddresslist);
        this.iPD.setText(R.string.address_locate_failed_tryagain);
        this.iPE.setVisibility(0);
        this.iNV = 2;
        cpo();
    }

    public void K(String[] strArr) {
        this.iPC.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.iPB.setText(R.string.address_pos_list);
            this.iPI = new m(this.iPx, strArr);
            this.iPF.setAdapter((ListAdapter) this.iPI);
            this.iPF.setVisibility(0);
        } else {
            this.iPB.setText(R.string.address_locate_noaddresslist);
        }
        cpo();
    }

    public void cof() {
        this.iPB.setText(R.string.address_pos_list);
        this.iPD.setText(R.string.address_locate_failed_opengps);
        this.iPE.setVisibility(0);
        this.iNV = 1;
        cpo();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.iPD.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.iPG = (AnimationDrawable) compoundDrawables[0];
            cpo();
        }
    }

    private void cpo() {
        if (this.iPG != null) {
            if (this.iNV == 3) {
                this.iPG.start();
                return;
            }
            this.iPG.stop();
            this.iPG.selectDrawable(0);
        }
    }

    public void GA(String str) {
        this.iPd = str;
    }

    public void GB(String str) {
        this.iPe = str;
    }

    public View cpg() {
        return this.eDq;
    }

    public View getBackButton() {
        return this.eDr;
    }

    public View cpp() {
        return this.iPy;
    }

    public View cpq() {
        return this.iPC;
    }

    public int cod() {
        return this.iNV;
    }

    public void b(a.b bVar) {
        this.iPu = bVar;
    }

    public void c(a.b bVar) {
        this.iPt = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iPx.getPageContext().getPageActivity());
        aVar.hf(false);
        aVar.kT(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iPu != null) {
                    n.this.iPu.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iPt != null) {
                    n.this.iPt.onClick(aVar2);
                }
            }
        });
        aVar.b(this.iPx.getPageContext());
        aVar.aUN();
    }

    public void onChangeSkinType(int i) {
        this.iPx.getLayoutMode().setNightMode(i == 1);
        this.iPx.getLayoutMode().onModeChanged(this.mParent);
        an.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        an.setBackgroundColor(this.mParent, R.color.common_color_10041);
        an.setViewTextColor(this.eDq, R.color.cp_cont_f, 1);
    }
}
