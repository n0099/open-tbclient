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
    private TextView eXf;
    private View eXg;
    private int jsJ;
    private com.baidu.tieba.im.util.b jtJ;
    private String jtR;
    private String jtS;
    private boolean jtV;
    private String juc;
    private String jud;
    private a.b juh;
    private a.b jui;
    private GroupAddressLocateActivity jul;
    private View jum;
    private TextView jun;
    private ImageView juo;
    private TextView jup;
    private View juq;
    private TextView jur;
    private ImageView jus;
    private BdListView jut;
    private AnimationDrawable juu;
    private SettingTextSwitchView juv;
    private m juw;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.jsJ = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.jul = null;
        this.eXf = null;
        this.eXg = null;
        this.jum = null;
        this.jun = null;
        this.juo = null;
        this.jup = null;
        this.juq = null;
        this.jur = null;
        this.jus = null;
        this.jut = null;
        this.juu = null;
        this.juv = null;
        this.juc = "";
        this.jud = "";
        this.jtV = false;
        this.juw = null;
        this.jtJ = null;
        this.jtR = "";
        this.jtS = "";
        this.jui = null;
        this.juh = null;
        this.juc = str;
        this.jud = str2;
        this.jtV = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cGX() {
        this.jtJ.startLoad();
    }

    public void cGY() {
        if (this.jtJ != null) {
            this.jtJ.cancelLoad();
            this.jtJ = null;
        }
    }

    public void cHn() {
        this.juo.setVisibility(8);
    }

    public void cHo() {
        this.juo.setVisibility(0);
    }

    public void cHk() {
        if (this.juw != null) {
            this.juw.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.jul = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.jun = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.jum = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.jum.setOnClickListener(this.jul);
        this.juo = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.juc)) {
            stringBuffer.append(this.juc);
        }
        if (!TextUtils.isEmpty(this.jud)) {
            stringBuffer.append(this.jud);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.jum.setVisibility(0);
            this.jun.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.jum.setVisibility(8);
            this.jun.setVisibility(8);
        }
        this.juq = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.juq.setOnClickListener(this.jul);
        this.jur = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.jus = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.jus.setVisibility(8);
        this.jup = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.jut = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.jut.setOnItemClickListener(this.jul);
        this.juv = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.jtV) {
            this.juv.turnOn();
        } else {
            this.juv.turnOff();
        }
        this.juv.setSwitchStateChangeListener(this.jul);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eXg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eXf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eXg.setOnClickListener(groupAddressLocateActivity);
        this.eXf.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.jtJ = new com.baidu.tieba.im.util.b(this.jul);
        this.jtJ.setUniqueId(this.jul.getUniqueId());
        if (!ae.c(this.jul, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cGX();
        }
    }

    public void cHp() {
        this.jup.setText(R.string.address_pos_list);
        this.jur.setText(R.string.location_loading);
        this.jus.setVisibility(8);
        this.jsJ = 3;
        cHr();
    }

    public void cHq() {
        this.jup.setText(R.string.address_locate_noaddresslist);
        this.jur.setText(R.string.address_locate_failed_tryagain);
        this.jus.setVisibility(0);
        this.jsJ = 2;
        cHr();
    }

    public void J(String[] strArr) {
        this.juq.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.jup.setText(R.string.address_pos_list);
            this.juw = new m(this.jul, strArr);
            this.jut.setAdapter((ListAdapter) this.juw);
            this.jut.setVisibility(0);
        } else {
            this.jup.setText(R.string.address_locate_noaddresslist);
        }
        cHr();
    }

    public void cGj() {
        this.jup.setText(R.string.address_pos_list);
        this.jur.setText(R.string.address_locate_failed_opengps);
        this.jus.setVisibility(0);
        this.jsJ = 1;
        cHr();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.jur.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.juu = (AnimationDrawable) compoundDrawables[0];
            cHr();
        }
    }

    private void cHr() {
        if (this.juu != null) {
            if (this.jsJ == 3) {
                this.juu.start();
                return;
            }
            this.juu.stop();
            this.juu.selectDrawable(0);
        }
    }

    public void KJ(String str) {
        this.jtR = str;
    }

    public void KK(String str) {
        this.jtS = str;
    }

    public View cHj() {
        return this.eXf;
    }

    public View getBackButton() {
        return this.eXg;
    }

    public View cHs() {
        return this.jum;
    }

    public View cHt() {
        return this.juq;
    }

    public int cGh() {
        return this.jsJ;
    }

    public void b(a.b bVar) {
        this.jui = bVar;
    }

    public void c(a.b bVar) {
        this.juh = bVar;
    }

    public void NY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jul.getPageContext().getPageActivity());
        aVar.id(false);
        aVar.nE(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.jui != null) {
                    n.this.jui.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.juh != null) {
                    n.this.juh.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jul.getPageContext());
        aVar.bia();
    }

    public void onChangeSkinType(int i) {
        this.jul.getLayoutMode().setNightMode(i == 1);
        this.jul.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.eXf, R.color.cp_cont_f, 1);
    }
}
