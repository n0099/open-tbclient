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
/* loaded from: classes23.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView fxI;
    private View fxJ;
    private int kab;
    private a.b kbA;
    private a.b kbB;
    private GroupAddressLocateActivity kbE;
    private View kbF;
    private TextView kbG;
    private ImageView kbH;
    private TextView kbI;
    private View kbJ;
    private TextView kbK;
    private ImageView kbL;
    private BdListView kbM;
    private AnimationDrawable kbN;
    private SettingTextSwitchView kbO;
    private m kbP;
    private com.baidu.tieba.im.util.b kbc;
    private String kbk;
    private String kbl;
    private boolean kbo;
    private String kbv;
    private String kbw;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.kab = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.kbE = null;
        this.fxI = null;
        this.fxJ = null;
        this.kbF = null;
        this.kbG = null;
        this.kbH = null;
        this.kbI = null;
        this.kbJ = null;
        this.kbK = null;
        this.kbL = null;
        this.kbM = null;
        this.kbN = null;
        this.kbO = null;
        this.kbv = "";
        this.kbw = "";
        this.kbo = false;
        this.kbP = null;
        this.kbc = null;
        this.kbk = "";
        this.kbl = "";
        this.kbB = null;
        this.kbA = null;
        this.kbv = str;
        this.kbw = str2;
        this.kbo = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cQo() {
        this.kbc.startLoad();
    }

    public void cQp() {
        if (this.kbc != null) {
            this.kbc.cancelLoad();
            this.kbc = null;
        }
    }

    public void cQE() {
        this.kbH.setVisibility(8);
    }

    public void cQF() {
        this.kbH.setVisibility(0);
    }

    public void cQB() {
        if (this.kbP != null) {
            this.kbP.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.kbE = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.kbG = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.kbF = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.kbF.setOnClickListener(this.kbE);
        this.kbH = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.kbv)) {
            stringBuffer.append(this.kbv);
        }
        if (!TextUtils.isEmpty(this.kbw)) {
            stringBuffer.append(this.kbw);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.kbF.setVisibility(0);
            this.kbG.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.kbF.setVisibility(8);
            this.kbG.setVisibility(8);
        }
        this.kbJ = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.kbJ.setOnClickListener(this.kbE);
        this.kbK = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.kbL = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.kbL.setVisibility(8);
        this.kbI = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.kbM = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.kbM.setOnItemClickListener(this.kbE);
        this.kbO = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.kbo) {
            this.kbO.turnOn();
        } else {
            this.kbO.turnOff();
        }
        this.kbO.setSwitchStateChangeListener(this.kbE);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.fxJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fxI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.fxJ.setOnClickListener(groupAddressLocateActivity);
        this.fxI.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.kbc = new com.baidu.tieba.im.util.b(this.kbE);
        this.kbc.setUniqueId(this.kbE.getUniqueId());
        if (!ae.c(this.kbE, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cQo();
        }
    }

    public void cQG() {
        this.kbI.setText(R.string.address_pos_list);
        this.kbK.setText(R.string.location_loading);
        this.kbL.setVisibility(8);
        this.kab = 3;
        cQI();
    }

    public void cQH() {
        this.kbI.setText(R.string.address_locate_noaddresslist);
        this.kbK.setText(R.string.address_locate_failed_tryagain);
        this.kbL.setVisibility(0);
        this.kab = 2;
        cQI();
    }

    public void L(String[] strArr) {
        this.kbJ.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.kbI.setText(R.string.address_pos_list);
            this.kbP = new m(this.kbE, strArr);
            this.kbM.setAdapter((ListAdapter) this.kbP);
            this.kbM.setVisibility(0);
        } else {
            this.kbI.setText(R.string.address_locate_noaddresslist);
        }
        cQI();
    }

    public void cPA() {
        this.kbI.setText(R.string.address_pos_list);
        this.kbK.setText(R.string.address_locate_failed_opengps);
        this.kbL.setVisibility(0);
        this.kab = 1;
        cQI();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.kbK.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.kbN = (AnimationDrawable) compoundDrawables[0];
            cQI();
        }
    }

    private void cQI() {
        if (this.kbN != null) {
            if (this.kab == 3) {
                this.kbN.start();
                return;
            }
            this.kbN.stop();
            this.kbN.selectDrawable(0);
        }
    }

    public void Mn(String str) {
        this.kbk = str;
    }

    public void Mo(String str) {
        this.kbl = str;
    }

    public View cQA() {
        return this.fxI;
    }

    public View getBackButton() {
        return this.fxJ;
    }

    public View cQJ() {
        return this.kbF;
    }

    public View cQK() {
        return this.kbJ;
    }

    public int cPy() {
        return this.kab;
    }

    public void b(a.b bVar) {
        this.kbB = bVar;
    }

    public void c(a.b bVar) {
        this.kbA = bVar;
    }

    public void Qj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kbE.getPageContext().getPageActivity());
        aVar.iV(false);
        aVar.ow(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.kbB != null) {
                    n.this.kbB.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.kbA != null) {
                    n.this.kbA.onClick(aVar2);
                }
            }
        });
        aVar.b(this.kbE.getPageContext());
        aVar.bpc();
    }

    public void onChangeSkinType(int i) {
        this.kbE.getLayoutMode().setNightMode(i == 1);
        this.kbE.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.fxI, R.color.cp_cont_f, 1);
    }
}
