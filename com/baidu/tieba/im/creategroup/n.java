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
/* loaded from: classes22.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView fwX;
    private View fwY;
    private int kaM;
    private com.baidu.tieba.im.util.b kbM;
    private String kbU;
    private String kbV;
    private boolean kbY;
    private String kcf;
    private String kcg;
    private a.b kck;
    private a.b kcl;
    private GroupAddressLocateActivity kco;
    private View kcp;
    private TextView kcq;
    private ImageView kcr;
    private TextView kcs;
    private View kct;
    private TextView kcu;
    private ImageView kcv;
    private BdListView kcw;
    private AnimationDrawable kcx;
    private SettingTextSwitchView kcy;
    private m kcz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.kaM = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.kco = null;
        this.fwX = null;
        this.fwY = null;
        this.kcp = null;
        this.kcq = null;
        this.kcr = null;
        this.kcs = null;
        this.kct = null;
        this.kcu = null;
        this.kcv = null;
        this.kcw = null;
        this.kcx = null;
        this.kcy = null;
        this.kcf = "";
        this.kcg = "";
        this.kbY = false;
        this.kcz = null;
        this.kbM = null;
        this.kbU = "";
        this.kbV = "";
        this.kcl = null;
        this.kck = null;
        this.kcf = str;
        this.kcg = str2;
        this.kbY = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cPU() {
        this.kbM.startLoad();
    }

    public void cPV() {
        if (this.kbM != null) {
            this.kbM.cancelLoad();
            this.kbM = null;
        }
    }

    public void cQk() {
        this.kcr.setVisibility(8);
    }

    public void cQl() {
        this.kcr.setVisibility(0);
    }

    public void cQh() {
        if (this.kcz != null) {
            this.kcz.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.kco = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.kcq = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.kcp = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.kcp.setOnClickListener(this.kco);
        this.kcr = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.kcf)) {
            stringBuffer.append(this.kcf);
        }
        if (!TextUtils.isEmpty(this.kcg)) {
            stringBuffer.append(this.kcg);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.kcp.setVisibility(0);
            this.kcq.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.kcp.setVisibility(8);
            this.kcq.setVisibility(8);
        }
        this.kct = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.kct.setOnClickListener(this.kco);
        this.kcu = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.kcv = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.kcv.setVisibility(8);
        this.kcs = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.kcw = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.kcw.setOnItemClickListener(this.kco);
        this.kcy = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.kbY) {
            this.kcy.turnOn();
        } else {
            this.kcy.turnOff();
        }
        this.kcy.setSwitchStateChangeListener(this.kco);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.fwY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fwX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.fwY.setOnClickListener(groupAddressLocateActivity);
        this.fwX.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.kbM = new com.baidu.tieba.im.util.b(this.kco);
        this.kbM.setUniqueId(this.kco.getUniqueId());
        if (!ae.c(this.kco, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cPU();
        }
    }

    public void cQm() {
        this.kcs.setText(R.string.address_pos_list);
        this.kcu.setText(R.string.location_loading);
        this.kcv.setVisibility(8);
        this.kaM = 3;
        cQo();
    }

    public void cQn() {
        this.kcs.setText(R.string.address_locate_noaddresslist);
        this.kcu.setText(R.string.address_locate_failed_tryagain);
        this.kcv.setVisibility(0);
        this.kaM = 2;
        cQo();
    }

    public void M(String[] strArr) {
        this.kct.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.kcs.setText(R.string.address_pos_list);
            this.kcz = new m(this.kco, strArr);
            this.kcw.setAdapter((ListAdapter) this.kcz);
            this.kcw.setVisibility(0);
        } else {
            this.kcs.setText(R.string.address_locate_noaddresslist);
        }
        cQo();
    }

    public void cPg() {
        this.kcs.setText(R.string.address_pos_list);
        this.kcu.setText(R.string.address_locate_failed_opengps);
        this.kcv.setVisibility(0);
        this.kaM = 1;
        cQo();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.kcu.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.kcx = (AnimationDrawable) compoundDrawables[0];
            cQo();
        }
    }

    private void cQo() {
        if (this.kcx != null) {
            if (this.kaM == 3) {
                this.kcx.start();
                return;
            }
            this.kcx.stop();
            this.kcx.selectDrawable(0);
        }
    }

    public void LO(String str) {
        this.kbU = str;
    }

    public void LP(String str) {
        this.kbV = str;
    }

    public View cQg() {
        return this.fwX;
    }

    public View getBackButton() {
        return this.fwY;
    }

    public View cQp() {
        return this.kcp;
    }

    public View cQq() {
        return this.kct;
    }

    public int cPe() {
        return this.kaM;
    }

    public void b(a.b bVar) {
        this.kcl = bVar;
    }

    public void c(a.b bVar) {
        this.kck = bVar;
    }

    public void PA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kco.getPageContext().getPageActivity());
        aVar.iW(false);
        aVar.os(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.kcl != null) {
                    n.this.kcl.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.kck != null) {
                    n.this.kck.onClick(aVar2);
                }
            }
        });
        aVar.b(this.kco.getPageContext());
        aVar.bog();
    }

    public void onChangeSkinType(int i) {
        this.kco.getLayoutMode().setNightMode(i == 1);
        this.kco.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.fwX, R.color.CAM_X0106, 1);
    }
}
