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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView csA;
    private View csB;
    private int gfa;
    private GroupAddressLocateActivity ggC;
    private View ggD;
    private TextView ggE;
    private ImageView ggF;
    private TextView ggG;
    private View ggH;
    private TextView ggI;
    private ImageView ggJ;
    private BdListView ggK;
    private AnimationDrawable ggL;
    private SettingTextSwitchView ggM;
    private m ggN;
    private com.baidu.tieba.im.util.b gga;
    private String ggi;
    private String ggj;
    private boolean ggm;
    private String ggt;
    private String ggu;
    private a.b ggy;
    private a.b ggz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.gfa = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.ggC = null;
        this.csA = null;
        this.csB = null;
        this.ggD = null;
        this.ggE = null;
        this.ggF = null;
        this.ggG = null;
        this.ggH = null;
        this.ggI = null;
        this.ggJ = null;
        this.ggK = null;
        this.ggL = null;
        this.ggM = null;
        this.ggt = "";
        this.ggu = "";
        this.ggm = false;
        this.ggN = null;
        this.gga = null;
        this.ggi = "";
        this.ggj = "";
        this.ggz = null;
        this.ggy = null;
        this.ggt = str;
        this.ggu = str2;
        this.ggm = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void brA() {
        this.gga.arK();
    }

    public void brB() {
        if (this.gga != null) {
            this.gga.cancelLoad();
            this.gga = null;
        }
    }

    public void brQ() {
        this.ggF.setVisibility(8);
    }

    public void brR() {
        this.ggF.setVisibility(0);
    }

    public void brN() {
        if (this.ggN != null) {
            this.ggN.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.ggC = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.ggE = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.ggD = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.ggD.setOnClickListener(this.ggC);
        this.ggF = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.ggt)) {
            stringBuffer.append(this.ggt);
        }
        if (!TextUtils.isEmpty(this.ggu)) {
            stringBuffer.append(this.ggu);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.ggD.setVisibility(0);
            this.ggE.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.ggD.setVisibility(8);
            this.ggE.setVisibility(8);
        }
        this.ggH = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.ggH.setOnClickListener(this.ggC);
        this.ggI = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.ggJ = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.ggJ.setVisibility(8);
        this.ggG = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.ggK = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.ggK.setOnItemClickListener(this.ggC);
        this.ggM = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.ggm) {
            this.ggM.oa();
        } else {
            this.ggM.ob();
        }
        this.ggM.setSwitchStateChangeListener(this.ggC);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.csB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(d.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.csB.setOnClickListener(groupAddressLocateActivity);
        this.csA.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.gga = new com.baidu.tieba.im.util.b(this.ggC);
        this.gga.setUniqueId(this.ggC.getUniqueId());
        brA();
    }

    public void brS() {
        this.ggG.setText(d.j.address_pos_list);
        this.ggI.setText(d.j.location_loading);
        this.ggJ.setVisibility(8);
        this.gfa = 3;
        brU();
    }

    public void brT() {
        this.ggG.setText(d.j.address_locate_noaddresslist);
        this.ggI.setText(d.j.address_locate_failed_tryagain);
        this.ggJ.setVisibility(0);
        this.gfa = 2;
        brU();
    }

    public void y(String[] strArr) {
        this.ggH.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.ggG.setText(d.j.address_pos_list);
            this.ggN = new m(this.ggC, strArr);
            this.ggK.setAdapter((ListAdapter) this.ggN);
            this.ggK.setVisibility(0);
        } else {
            this.ggG.setText(d.j.address_locate_noaddresslist);
        }
        brU();
    }

    public void bqL() {
        this.ggG.setText(d.j.address_pos_list);
        this.ggI.setText(d.j.address_locate_failed_opengps);
        this.ggJ.setVisibility(0);
        this.gfa = 1;
        brU();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.ggI.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.ggL = (AnimationDrawable) compoundDrawables[0];
            brU();
        }
    }

    private void brU() {
        if (this.ggL != null) {
            if (this.gfa == 3) {
                this.ggL.start();
                return;
            }
            this.ggL.stop();
            this.ggL.selectDrawable(0);
        }
    }

    public void wB(String str) {
        this.ggi = str;
    }

    public void wC(String str) {
        this.ggj = str;
    }

    public View brM() {
        return this.csA;
    }

    public View getBackButton() {
        return this.csB;
    }

    public View brV() {
        return this.ggD;
    }

    public View brW() {
        return this.ggH;
    }

    public int bqJ() {
        return this.gfa;
    }

    public void b(a.b bVar) {
        this.ggz = bVar;
    }

    public void c(a.b bVar) {
        this.ggy = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ggC.getPageContext().getPageActivity());
        aVar.dq(false);
        aVar.gD(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ggz != null) {
                    n.this.ggz.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ggy != null) {
                    n.this.ggy.onClick(aVar2);
                }
            }
        });
        aVar.b(this.ggC.getPageContext());
        aVar.aaZ();
    }

    public void onChangeSkinType(int i) {
        this.ggC.getLayoutMode().setNightMode(i == 1);
        this.ggC.getLayoutMode().onModeChanged(this.mParent);
        al.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.l(this.mParent, d.C0277d.common_color_10041);
        al.d(this.csA, d.C0277d.cp_cont_f, 1);
    }
}
