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
    private TextView biF;
    private View biG;
    private int eOW;
    private com.baidu.tieba.im.util.b ePW;
    private TextView eQA;
    private ImageView eQB;
    private TextView eQC;
    private View eQD;
    private TextView eQE;
    private ImageView eQF;
    private BdListView eQG;
    private AnimationDrawable eQH;
    private SettingTextSwitchView eQI;
    private m eQJ;
    private String eQe;
    private String eQf;
    private boolean eQi;
    private String eQp;
    private String eQq;
    private a.b eQu;
    private a.b eQv;
    private GroupAddressLocateActivity eQy;
    private View eQz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.eOW = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eQy = null;
        this.biF = null;
        this.biG = null;
        this.eQz = null;
        this.eQA = null;
        this.eQB = null;
        this.eQC = null;
        this.eQD = null;
        this.eQE = null;
        this.eQF = null;
        this.eQG = null;
        this.eQH = null;
        this.eQI = null;
        this.eQp = "";
        this.eQq = "";
        this.eQi = false;
        this.eQJ = null;
        this.ePW = null;
        this.eQe = "";
        this.eQf = "";
        this.eQv = null;
        this.eQu = null;
        this.eQp = str;
        this.eQq = str2;
        this.eQi = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aQV() {
        this.ePW.RP();
    }

    public void aQW() {
        if (this.ePW != null) {
            this.ePW.cancelLoad();
            this.ePW = null;
        }
    }

    public void aRl() {
        this.eQB.setVisibility(8);
    }

    public void aRm() {
        this.eQB.setVisibility(0);
    }

    public void aRi() {
        if (this.eQJ != null) {
            this.eQJ.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eQy = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(e.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(e.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(e.g.address_content_currentpos);
        this.eQA = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_currentpos);
        this.eQz = groupAddressLocateActivity.findViewById(e.g.address_content_container);
        this.eQz.setOnClickListener(this.eQy);
        this.eQB = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.eQp)) {
            stringBuffer.append(this.eQp);
        }
        if (!TextUtils.isEmpty(this.eQq)) {
            stringBuffer.append(this.eQq);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.eQz.setVisibility(0);
            this.eQA.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.eQz.setVisibility(8);
            this.eQA.setVisibility(8);
        }
        this.eQD = groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_layout);
        this.eQD.setOnClickListener(this.eQy);
        this.eQE = (TextView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_textview);
        this.eQF = (ImageView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_locatearea_rightarrow);
        this.eQF.setVisibility(8);
        this.eQC = (TextView) groupAddressLocateActivity.findViewById(e.g.address_title_poslist);
        this.eQG = (BdListView) groupAddressLocateActivity.findViewById(e.g.group_address_locate_addresslist_listview);
        this.eQG.setOnItemClickListener(this.eQy);
        this.eQI = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(e.g.address_showorhidden);
        if (this.eQi) {
            this.eQI.nV();
        } else {
            this.eQI.nW();
        }
        this.eQI.setSwitchStateChangeListener(this.eQy);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(e.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.biG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.biF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(e.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.biG.setOnClickListener(groupAddressLocateActivity);
        this.biF.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.ePW = new com.baidu.tieba.im.util.b(this.eQy);
        this.ePW.setUniqueId(this.eQy.getUniqueId());
        aQV();
    }

    public void aRn() {
        this.eQC.setText(e.j.address_pos_list);
        this.eQE.setText(e.j.location_loading);
        this.eQF.setVisibility(8);
        this.eOW = 3;
        aRp();
    }

    public void aRo() {
        this.eQC.setText(e.j.address_locate_noaddresslist);
        this.eQE.setText(e.j.address_locate_failed_tryagain);
        this.eQF.setVisibility(0);
        this.eOW = 2;
        aRp();
    }

    public void z(String[] strArr) {
        this.eQD.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.eQC.setText(e.j.address_pos_list);
            this.eQJ = new m(this.eQy, strArr);
            this.eQG.setAdapter((ListAdapter) this.eQJ);
            this.eQG.setVisibility(0);
        } else {
            this.eQC.setText(e.j.address_locate_noaddresslist);
        }
        aRp();
    }

    public void aQg() {
        this.eQC.setText(e.j.address_pos_list);
        this.eQE.setText(e.j.address_locate_failed_opengps);
        this.eQF.setVisibility(0);
        this.eOW = 1;
        aRp();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.eQE.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.eQH = (AnimationDrawable) compoundDrawables[0];
            aRp();
        }
    }

    private void aRp() {
        if (this.eQH != null) {
            if (this.eOW == 3) {
                this.eQH.start();
                return;
            }
            this.eQH.stop();
            this.eQH.selectDrawable(0);
        }
    }

    public void pX(String str) {
        this.eQe = str;
    }

    public void pY(String str) {
        this.eQf = str;
    }

    public View aRh() {
        return this.biF;
    }

    public View getBackButton() {
        return this.biG;
    }

    public View aRq() {
        return this.eQz;
    }

    public View aRr() {
        return this.eQD;
    }

    public int aQe() {
        return this.eOW;
    }

    public void a(a.b bVar) {
        this.eQv = bVar;
    }

    public void b(a.b bVar) {
        this.eQu = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eQy.getPageContext().getPageActivity());
        aVar.bg(false);
        aVar.db(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eQv != null) {
                    n.this.eQv.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.eQu != null) {
                    n.this.eQu.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eQy.getPageContext());
        aVar.BS();
    }

    public void onChangeSkinType(int i) {
        this.eQy.getLayoutMode().setNightMode(i == 1);
        this.eQy.getLayoutMode().onModeChanged(this.mParent);
        al.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.j(this.mParent, e.d.common_color_10041);
        al.c(this.biF, e.d.cp_cont_f, 1);
    }
}
