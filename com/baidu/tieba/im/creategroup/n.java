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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView aVO;
    private View aVP;
    private int eoc;
    private a.b epB;
    private a.b epC;
    private GroupAddressLocateActivity epF;
    private View epG;
    private TextView epH;
    private ImageView epI;
    private TextView epJ;
    private View epK;
    private TextView epL;
    private ImageView epM;
    private BdListView epN;
    private AnimationDrawable epO;
    private SettingTextSwitchView epP;
    private m epQ;
    private com.baidu.tieba.im.util.b epd;
    private String epl;
    private String epm;
    private boolean epp;
    private String epw;
    private String epx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.eoc = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.epF = null;
        this.aVO = null;
        this.aVP = null;
        this.epG = null;
        this.epH = null;
        this.epI = null;
        this.epJ = null;
        this.epK = null;
        this.epL = null;
        this.epM = null;
        this.epN = null;
        this.epO = null;
        this.epP = null;
        this.epw = "";
        this.epx = "";
        this.epp = false;
        this.epQ = null;
        this.epd = null;
        this.epl = "";
        this.epm = "";
        this.epC = null;
        this.epB = null;
        this.epw = str;
        this.epx = str2;
        this.epp = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void aIP() {
        this.epd.MO();
    }

    public void aIQ() {
        if (this.epd != null) {
            this.epd.cancelLoad();
            this.epd = null;
        }
    }

    public void aJf() {
        this.epI.setVisibility(8);
    }

    public void aJg() {
        this.epI.setVisibility(0);
    }

    public void aJc() {
        if (this.epQ != null) {
            this.epQ.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.epF = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(f.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(f.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(f.g.address_content_currentpos);
        this.epH = (TextView) groupAddressLocateActivity.findViewById(f.g.address_title_currentpos);
        this.epG = groupAddressLocateActivity.findViewById(f.g.address_content_container);
        this.epG.setOnClickListener(this.epF);
        this.epI = (ImageView) groupAddressLocateActivity.findViewById(f.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.epw)) {
            stringBuffer.append(this.epw);
        }
        if (!TextUtils.isEmpty(this.epx)) {
            stringBuffer.append(this.epx);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.epG.setVisibility(0);
            this.epH.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.epG.setVisibility(8);
            this.epH.setVisibility(8);
        }
        this.epK = groupAddressLocateActivity.findViewById(f.g.group_address_locate_locatearea_layout);
        this.epK.setOnClickListener(this.epF);
        this.epL = (TextView) groupAddressLocateActivity.findViewById(f.g.group_address_locate_locatearea_textview);
        this.epM = (ImageView) groupAddressLocateActivity.findViewById(f.g.group_address_locate_locatearea_rightarrow);
        this.epM.setVisibility(8);
        this.epJ = (TextView) groupAddressLocateActivity.findViewById(f.g.address_title_poslist);
        this.epN = (BdListView) groupAddressLocateActivity.findViewById(f.g.group_address_locate_addresslist_listview);
        this.epN.setOnItemClickListener(this.epF);
        this.epP = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(f.g.address_showorhidden);
        if (this.epp) {
            this.epP.mE();
        } else {
            this.epP.mF();
        }
        this.epP.setSwitchStateChangeListener(this.epF);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(f.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(f.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aVP.setOnClickListener(groupAddressLocateActivity);
        this.aVO.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.epd = new com.baidu.tieba.im.util.b(this.epF);
        this.epd.setUniqueId(this.epF.getUniqueId());
        aIP();
    }

    public void aJh() {
        this.epJ.setText(f.j.address_pos_list);
        this.epL.setText(f.j.location_loading);
        this.epM.setVisibility(8);
        this.eoc = 3;
        aJj();
    }

    public void aJi() {
        this.epJ.setText(f.j.address_locate_noaddresslist);
        this.epL.setText(f.j.address_locate_failed_tryagain);
        this.epM.setVisibility(0);
        this.eoc = 2;
        aJj();
    }

    public void t(String[] strArr) {
        this.epK.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.epJ.setText(f.j.address_pos_list);
            this.epQ = new m(this.epF, strArr);
            this.epN.setAdapter((ListAdapter) this.epQ);
            this.epN.setVisibility(0);
        } else {
            this.epJ.setText(f.j.address_locate_noaddresslist);
        }
        aJj();
    }

    public void aHZ() {
        this.epJ.setText(f.j.address_pos_list);
        this.epL.setText(f.j.address_locate_failed_opengps);
        this.epM.setVisibility(0);
        this.eoc = 1;
        aJj();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.epL.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.epO = (AnimationDrawable) compoundDrawables[0];
            aJj();
        }
    }

    private void aJj() {
        if (this.epO != null) {
            if (this.eoc == 3) {
                this.epO.start();
                return;
            }
            this.epO.stop();
            this.epO.selectDrawable(0);
        }
    }

    public void nS(String str) {
        this.epl = str;
    }

    public void nT(String str) {
        this.epm = str;
    }

    public View aJb() {
        return this.aVO;
    }

    public View getBackButton() {
        return this.aVP;
    }

    public View aJk() {
        return this.epG;
    }

    public View aJl() {
        return this.epK;
    }

    public int aHX() {
        return this.eoc;
    }

    public void a(a.b bVar) {
        this.epC = bVar;
    }

    public void b(a.b bVar) {
        this.epB = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.epF.getPageContext().getPageActivity());
        aVar.av(false);
        aVar.cf(f.j.group_update_alert_save);
        aVar.a(f.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.epC != null) {
                    n.this.epC.onClick(aVar2);
                }
            }
        });
        aVar.b(f.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.epB != null) {
                    n.this.epB.onClick(aVar2);
                }
            }
        });
        aVar.b(this.epF.getPageContext());
        aVar.xe();
    }

    public void onChangeSkinType(int i) {
        this.epF.getLayoutMode().setNightMode(i == 1);
        this.epF.getLayoutMode().onModeChanged(this.mParent);
        am.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.j(this.mParent, f.d.common_color_10041);
        am.c(this.aVO, f.d.cp_cont_f, 1);
    }
}
