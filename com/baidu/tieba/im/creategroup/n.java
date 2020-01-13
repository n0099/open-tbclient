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
/* loaded from: classes8.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView dBH;
    private View dBI;
    private int htO;
    private com.baidu.tieba.im.util.b huO;
    private String huW;
    private String huX;
    private SettingTextSwitchView hvA;
    private m hvB;
    private boolean hva;
    private String hvh;
    private String hvi;
    private a.b hvm;
    private a.b hvn;
    private GroupAddressLocateActivity hvq;
    private View hvr;
    private TextView hvs;
    private ImageView hvt;
    private TextView hvu;
    private View hvv;
    private TextView hvw;
    private ImageView hvx;
    private BdListView hvy;
    private AnimationDrawable hvz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.htO = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.hvq = null;
        this.dBH = null;
        this.dBI = null;
        this.hvr = null;
        this.hvs = null;
        this.hvt = null;
        this.hvu = null;
        this.hvv = null;
        this.hvw = null;
        this.hvx = null;
        this.hvy = null;
        this.hvz = null;
        this.hvA = null;
        this.hvh = "";
        this.hvi = "";
        this.hva = false;
        this.hvB = null;
        this.huO = null;
        this.huW = "";
        this.huX = "";
        this.hvn = null;
        this.hvm = null;
        this.hvh = str;
        this.hvi = str2;
        this.hva = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bSc() {
        this.huO.startLoad();
    }

    public void bSd() {
        if (this.huO != null) {
            this.huO.cancelLoad();
            this.huO = null;
        }
    }

    public void bSs() {
        this.hvt.setVisibility(8);
    }

    public void bSt() {
        this.hvt.setVisibility(0);
    }

    public void bSp() {
        if (this.hvB != null) {
            this.hvB.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.hvq = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.hvs = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.hvr = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.hvr.setOnClickListener(this.hvq);
        this.hvt = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.hvh)) {
            stringBuffer.append(this.hvh);
        }
        if (!TextUtils.isEmpty(this.hvi)) {
            stringBuffer.append(this.hvi);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.hvr.setVisibility(0);
            this.hvs.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.hvr.setVisibility(8);
            this.hvs.setVisibility(8);
        }
        this.hvv = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.hvv.setOnClickListener(this.hvq);
        this.hvw = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.hvx = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.hvx.setVisibility(8);
        this.hvu = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.hvy = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.hvy.setOnItemClickListener(this.hvq);
        this.hvA = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.hva) {
            this.hvA.turnOn();
        } else {
            this.hvA.turnOff();
        }
        this.hvA.setSwitchStateChangeListener(this.hvq);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dBI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dBH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.dBI.setOnClickListener(groupAddressLocateActivity);
        this.dBH.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.huO = new com.baidu.tieba.im.util.b(this.hvq);
        this.huO.setUniqueId(this.hvq.getUniqueId());
        bSc();
    }

    public void bSu() {
        this.hvu.setText(R.string.address_pos_list);
        this.hvw.setText(R.string.location_loading);
        this.hvx.setVisibility(8);
        this.htO = 3;
        bSw();
    }

    public void bSv() {
        this.hvu.setText(R.string.address_locate_noaddresslist);
        this.hvw.setText(R.string.address_locate_failed_tryagain);
        this.hvx.setVisibility(0);
        this.htO = 2;
        bSw();
    }

    public void H(String[] strArr) {
        this.hvv.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.hvu.setText(R.string.address_pos_list);
            this.hvB = new m(this.hvq, strArr);
            this.hvy.setAdapter((ListAdapter) this.hvB);
            this.hvy.setVisibility(0);
        } else {
            this.hvu.setText(R.string.address_locate_noaddresslist);
        }
        bSw();
    }

    public void bRn() {
        this.hvu.setText(R.string.address_pos_list);
        this.hvw.setText(R.string.address_locate_failed_opengps);
        this.hvx.setVisibility(0);
        this.htO = 1;
        bSw();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.hvw.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.hvz = (AnimationDrawable) compoundDrawables[0];
            bSw();
        }
    }

    private void bSw() {
        if (this.hvz != null) {
            if (this.htO == 3) {
                this.hvz.start();
                return;
            }
            this.hvz.stop();
            this.hvz.selectDrawable(0);
        }
    }

    public void Cn(String str) {
        this.huW = str;
    }

    public void Co(String str) {
        this.huX = str;
    }

    public View bSo() {
        return this.dBH;
    }

    public View getBackButton() {
        return this.dBI;
    }

    public View bSx() {
        return this.hvr;
    }

    public View bSy() {
        return this.hvv;
    }

    public int bRl() {
        return this.htO;
    }

    public void b(a.b bVar) {
        this.hvn = bVar;
    }

    public void c(a.b bVar) {
        this.hvm = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hvq.getPageContext().getPageActivity());
        aVar.fz(false);
        aVar.jF(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hvn != null) {
                    n.this.hvn.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hvm != null) {
                    n.this.hvm.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hvq.getPageContext());
        aVar.aCp();
    }

    public void onChangeSkinType(int i) {
        this.hvq.getLayoutMode().setNightMode(i == 1);
        this.hvq.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dBH, R.color.cp_cont_f, 1);
    }
}
