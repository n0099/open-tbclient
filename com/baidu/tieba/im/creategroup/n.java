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
    private TextView biG;
    private View biH;
    private int eOX;
    private com.baidu.tieba.im.util.b ePX;
    private View eQA;
    private TextView eQB;
    private ImageView eQC;
    private TextView eQD;
    private View eQE;
    private TextView eQF;
    private ImageView eQG;
    private BdListView eQH;
    private AnimationDrawable eQI;
    private SettingTextSwitchView eQJ;
    private m eQK;
    private String eQf;
    private String eQg;
    private boolean eQj;
    private String eQq;
    private String eQr;
    private a.b eQv;
    private a.b eQw;
    private GroupAddressLocateActivity eQz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.eOX = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eQz = null;
        this.biG = null;
        this.biH = null;
        this.eQA = null;
        this.eQB = null;
        this.eQC = null;
        this.eQD = null;
        this.eQE = null;
        this.eQF = null;
        this.eQG = null;
        this.eQH = null;
        this.eQI = null;
        this.eQJ = null;
        this.eQq = "";
        this.eQr = "";
        this.eQj = false;
        this.eQK = null;
        this.ePX = null;
        this.eQf = "";
        this.eQg = "";
        this.eQw = null;
        this.eQv = null;
        this.eQq = str;
        this.eQr = str2;
        this.eQj = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aQV() {
        this.ePX.RP();
    }

    public void aQW() {
        if (this.ePX != null) {
            this.ePX.cancelLoad();
            this.ePX = null;
        }
    }

    public void aRl() {
        this.eQC.setVisibility(8);
    }

    public void aRm() {
        this.eQC.setVisibility(0);
    }

    public void aRi() {
        if (this.eQK != null) {
            this.eQK.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eQz = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(e.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(e.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(e.g.address_content_currentpos);
        this.eQB = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_currentpos);
        this.eQA = groupAddressLocateActivity.findViewById(e.g.address_content_container);
        this.eQA.setOnClickListener(this.eQz);
        this.eQC = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.eQq)) {
            stringBuffer.append(this.eQq);
        }
        if (!TextUtils.isEmpty(this.eQr)) {
            stringBuffer.append(this.eQr);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.eQA.setVisibility(0);
            this.eQB.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.eQA.setVisibility(8);
            this.eQB.setVisibility(8);
        }
        this.eQE = groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_layout);
        this.eQE.setOnClickListener(this.eQz);
        this.eQF = (TextView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_textview);
        this.eQG = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_rightarrow);
        this.eQG.setVisibility(8);
        this.eQD = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_poslist);
        this.eQH = (BdListView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_addresslist_listview);
        this.eQH.setOnItemClickListener(this.eQz);
        this.eQJ = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(e.g.address_showorhidden);
        if (this.eQj) {
            this.eQJ.nV();
        } else {
            this.eQJ.nW();
        }
        this.eQJ.setSwitchStateChangeListener(this.eQz);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.biH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.biG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(e.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.biH.setOnClickListener(groupAddressLocateActivity);
        this.biG.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.ePX = new com.baidu.tieba.im.util.b(this.eQz);
        this.ePX.setUniqueId(this.eQz.getUniqueId());
        aQV();
    }

    public void aRn() {
        this.eQD.setText(e.j.address_pos_list);
        this.eQF.setText(e.j.location_loading);
        this.eQG.setVisibility(8);
        this.eOX = 3;
        aRp();
    }

    public void aRo() {
        this.eQD.setText(e.j.address_locate_noaddresslist);
        this.eQF.setText(e.j.address_locate_failed_tryagain);
        this.eQG.setVisibility(0);
        this.eOX = 2;
        aRp();
    }

    public void z(String[] strArr) {
        this.eQE.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.eQD.setText(e.j.address_pos_list);
            this.eQK = new m(this.eQz, strArr);
            this.eQH.setAdapter((ListAdapter) this.eQK);
            this.eQH.setVisibility(0);
        } else {
            this.eQD.setText(e.j.address_locate_noaddresslist);
        }
        aRp();
    }

    public void aQg() {
        this.eQD.setText(e.j.address_pos_list);
        this.eQF.setText(e.j.address_locate_failed_opengps);
        this.eQG.setVisibility(0);
        this.eOX = 1;
        aRp();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.eQF.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.eQI = (AnimationDrawable) compoundDrawables[0];
            aRp();
        }
    }

    private void aRp() {
        if (this.eQI != null) {
            if (this.eOX == 3) {
                this.eQI.start();
                return;
            }
            this.eQI.stop();
            this.eQI.selectDrawable(0);
        }
    }

    public void pX(String str) {
        this.eQf = str;
    }

    public void pY(String str) {
        this.eQg = str;
    }

    public View aRh() {
        return this.biG;
    }

    public View getBackButton() {
        return this.biH;
    }

    public View aRq() {
        return this.eQA;
    }

    public View aRr() {
        return this.eQE;
    }

    public int aQe() {
        return this.eOX;
    }

    public void a(a.b bVar) {
        this.eQw = bVar;
    }

    public void b(a.b bVar) {
        this.eQv = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eQz.getPageContext().getPageActivity());
        aVar.bg(false);
        aVar.db(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eQw != null) {
                    n.this.eQw.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eQv != null) {
                    n.this.eQv.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eQz.getPageContext());
        aVar.BS();
    }

    public void onChangeSkinType(int i) {
        this.eQz.getLayoutMode().setNightMode(i == 1);
        this.eQz.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.biG, e.d.cp_cont_f, 1);
    }
}
