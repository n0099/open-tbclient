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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView ber;
    private View bes;
    private int eEE;
    private com.baidu.tieba.im.util.b eFE;
    private String eFM;
    private String eFN;
    private boolean eFQ;
    private String eFX;
    private String eFY;
    private a.b eGc;
    private a.b eGd;
    private GroupAddressLocateActivity eGg;
    private View eGh;
    private TextView eGi;
    private ImageView eGj;
    private TextView eGk;
    private View eGl;
    private TextView eGm;
    private ImageView eGn;
    private BdListView eGo;
    private AnimationDrawable eGp;
    private SettingTextSwitchView eGq;
    private m eGr;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.eEE = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eGg = null;
        this.ber = null;
        this.bes = null;
        this.eGh = null;
        this.eGi = null;
        this.eGj = null;
        this.eGk = null;
        this.eGl = null;
        this.eGm = null;
        this.eGn = null;
        this.eGo = null;
        this.eGp = null;
        this.eGq = null;
        this.eFX = "";
        this.eFY = "";
        this.eFQ = false;
        this.eGr = null;
        this.eFE = null;
        this.eFM = "";
        this.eFN = "";
        this.eGd = null;
        this.eGc = null;
        this.eFX = str;
        this.eFY = str2;
        this.eFQ = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aNQ() {
        this.eFE.Ql();
    }

    public void aNR() {
        if (this.eFE != null) {
            this.eFE.cancelLoad();
            this.eFE = null;
        }
    }

    public void aOg() {
        this.eGj.setVisibility(8);
    }

    public void aOh() {
        this.eGj.setVisibility(0);
    }

    public void aOd() {
        if (this.eGr != null) {
            this.eGr.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eGg = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(e.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(e.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(e.g.address_content_currentpos);
        this.eGi = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_currentpos);
        this.eGh = groupAddressLocateActivity.findViewById(e.g.address_content_container);
        this.eGh.setOnClickListener(this.eGg);
        this.eGj = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.eFX)) {
            stringBuffer.append(this.eFX);
        }
        if (!TextUtils.isEmpty(this.eFY)) {
            stringBuffer.append(this.eFY);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.eGh.setVisibility(0);
            this.eGi.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.eGh.setVisibility(8);
            this.eGi.setVisibility(8);
        }
        this.eGl = groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_layout);
        this.eGl.setOnClickListener(this.eGg);
        this.eGm = (TextView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_textview);
        this.eGn = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_rightarrow);
        this.eGn.setVisibility(8);
        this.eGk = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_poslist);
        this.eGo = (BdListView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_addresslist_listview);
        this.eGo.setOnItemClickListener(this.eGg);
        this.eGq = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(e.g.address_showorhidden);
        if (this.eFQ) {
            this.eGq.nS();
        } else {
            this.eGq.nT();
        }
        this.eGq.setSwitchStateChangeListener(this.eGg);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.bes = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ber = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(e.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.bes.setOnClickListener(groupAddressLocateActivity);
        this.ber.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.eFE = new com.baidu.tieba.im.util.b(this.eGg);
        this.eFE.setUniqueId(this.eGg.getUniqueId());
        aNQ();
    }

    public void aOi() {
        this.eGk.setText(e.j.address_pos_list);
        this.eGm.setText(e.j.location_loading);
        this.eGn.setVisibility(8);
        this.eEE = 3;
        aOk();
    }

    public void aOj() {
        this.eGk.setText(e.j.address_locate_noaddresslist);
        this.eGm.setText(e.j.address_locate_failed_tryagain);
        this.eGn.setVisibility(0);
        this.eEE = 2;
        aOk();
    }

    public void y(String[] strArr) {
        this.eGl.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.eGk.setText(e.j.address_pos_list);
            this.eGr = new m(this.eGg, strArr);
            this.eGo.setAdapter((ListAdapter) this.eGr);
            this.eGo.setVisibility(0);
        } else {
            this.eGk.setText(e.j.address_locate_noaddresslist);
        }
        aOk();
    }

    public void aNb() {
        this.eGk.setText(e.j.address_pos_list);
        this.eGm.setText(e.j.address_locate_failed_opengps);
        this.eGn.setVisibility(0);
        this.eEE = 1;
        aOk();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.eGm.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.eGp = (AnimationDrawable) compoundDrawables[0];
            aOk();
        }
    }

    private void aOk() {
        if (this.eGp != null) {
            if (this.eEE == 3) {
                this.eGp.start();
                return;
            }
            this.eGp.stop();
            this.eGp.selectDrawable(0);
        }
    }

    public void pc(String str) {
        this.eFM = str;
    }

    public void pd(String str) {
        this.eFN = str;
    }

    public View aOc() {
        return this.ber;
    }

    public View getBackButton() {
        return this.bes;
    }

    public View aOl() {
        return this.eGh;
    }

    public View aOm() {
        return this.eGl;
    }

    public int aMZ() {
        return this.eEE;
    }

    public void a(a.b bVar) {
        this.eGd = bVar;
    }

    public void b(a.b bVar) {
        this.eGc = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGg.getPageContext().getPageActivity());
        aVar.be(false);
        aVar.cN(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eGd != null) {
                    n.this.eGd.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eGc != null) {
                    n.this.eGc.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eGg.getPageContext());
        aVar.AB();
    }

    public void onChangeSkinType(int i) {
        this.eGg.getLayoutMode().setNightMode(i == 1);
        this.eGg.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.ber, e.d.cp_cont_f, 1);
    }
}
