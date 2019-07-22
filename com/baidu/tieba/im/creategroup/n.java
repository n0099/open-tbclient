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
/* loaded from: classes5.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView cCe;
    private View cCf;
    private int gCo;
    private boolean gDA;
    private String gDH;
    private String gDI;
    private a.b gDM;
    private a.b gDN;
    private GroupAddressLocateActivity gDQ;
    private View gDR;
    private TextView gDS;
    private ImageView gDT;
    private TextView gDU;
    private View gDV;
    private TextView gDW;
    private ImageView gDX;
    private BdListView gDY;
    private AnimationDrawable gDZ;
    private com.baidu.tieba.im.util.b gDo;
    private String gDw;
    private String gDx;
    private SettingTextSwitchView gEa;
    private m gEb;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.gCo = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.gDQ = null;
        this.cCe = null;
        this.cCf = null;
        this.gDR = null;
        this.gDS = null;
        this.gDT = null;
        this.gDU = null;
        this.gDV = null;
        this.gDW = null;
        this.gDX = null;
        this.gDY = null;
        this.gDZ = null;
        this.gEa = null;
        this.gDH = "";
        this.gDI = "";
        this.gDA = false;
        this.gEb = null;
        this.gDo = null;
        this.gDw = "";
        this.gDx = "";
        this.gDN = null;
        this.gDM = null;
        this.gDH = str;
        this.gDI = str2;
        this.gDA = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bBS() {
        this.gDo.aya();
    }

    public void bBT() {
        if (this.gDo != null) {
            this.gDo.cancelLoad();
            this.gDo = null;
        }
    }

    public void bCi() {
        this.gDT.setVisibility(8);
    }

    public void bCj() {
        this.gDT.setVisibility(0);
    }

    public void bCf() {
        if (this.gEb != null) {
            this.gEb.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.gDQ = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.gDS = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.gDR = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.gDR.setOnClickListener(this.gDQ);
        this.gDT = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.gDH)) {
            stringBuffer.append(this.gDH);
        }
        if (!TextUtils.isEmpty(this.gDI)) {
            stringBuffer.append(this.gDI);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.gDR.setVisibility(0);
            this.gDS.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.gDR.setVisibility(8);
            this.gDS.setVisibility(8);
        }
        this.gDV = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.gDV.setOnClickListener(this.gDQ);
        this.gDW = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.gDX = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.gDX.setVisibility(8);
        this.gDU = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.gDY = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.gDY.setOnItemClickListener(this.gDQ);
        this.gEa = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.gDA) {
            this.gEa.nm();
        } else {
            this.gEa.nn();
        }
        this.gEa.setSwitchStateChangeListener(this.gDQ);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cCf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cCe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.cCf.setOnClickListener(groupAddressLocateActivity);
        this.cCe.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.gDo = new com.baidu.tieba.im.util.b(this.gDQ);
        this.gDo.setUniqueId(this.gDQ.getUniqueId());
        bBS();
    }

    public void bCk() {
        this.gDU.setText(R.string.address_pos_list);
        this.gDW.setText(R.string.location_loading);
        this.gDX.setVisibility(8);
        this.gCo = 3;
        bCm();
    }

    public void bCl() {
        this.gDU.setText(R.string.address_locate_noaddresslist);
        this.gDW.setText(R.string.address_locate_failed_tryagain);
        this.gDX.setVisibility(0);
        this.gCo = 2;
        bCm();
    }

    public void x(String[] strArr) {
        this.gDV.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.gDU.setText(R.string.address_pos_list);
            this.gEb = new m(this.gDQ, strArr);
            this.gDY.setAdapter((ListAdapter) this.gEb);
            this.gDY.setVisibility(0);
        } else {
            this.gDU.setText(R.string.address_locate_noaddresslist);
        }
        bCm();
    }

    public void bBc() {
        this.gDU.setText(R.string.address_pos_list);
        this.gDW.setText(R.string.address_locate_failed_opengps);
        this.gDX.setVisibility(0);
        this.gCo = 1;
        bCm();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.gDW.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.gDZ = (AnimationDrawable) compoundDrawables[0];
            bCm();
        }
    }

    private void bCm() {
        if (this.gDZ != null) {
            if (this.gCo == 3) {
                this.gDZ.start();
                return;
            }
            this.gDZ.stop();
            this.gDZ.selectDrawable(0);
        }
    }

    public void yB(String str) {
        this.gDw = str;
    }

    public void yC(String str) {
        this.gDx = str;
    }

    public View bCe() {
        return this.cCe;
    }

    public View getBackButton() {
        return this.cCf;
    }

    public View bCn() {
        return this.gDR;
    }

    public View bCo() {
        return this.gDV;
    }

    public int bBa() {
        return this.gCo;
    }

    public void b(a.b bVar) {
        this.gDN = bVar;
    }

    public void c(a.b bVar) {
        this.gDM = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gDQ.getPageContext().getPageActivity());
        aVar.dQ(false);
        aVar.hu(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gDN != null) {
                    n.this.gDN.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gDM != null) {
                    n.this.gDM.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gDQ.getPageContext());
        aVar.agI();
    }

    public void onChangeSkinType(int i) {
        this.gDQ.getLayoutMode().setNightMode(i == 1);
        this.gDQ.getLayoutMode().onModeChanged(this.mParent);
        am.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.l(this.mParent, R.color.common_color_10041);
        am.f(this.cCe, R.color.cp_cont_f, 1);
    }
}
