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
/* loaded from: classes17.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView eUl;
    private View eUm;
    private int jjZ;
    private com.baidu.tieba.im.util.b jkZ;
    private GroupAddressLocateActivity jlB;
    private View jlC;
    private TextView jlD;
    private ImageView jlE;
    private TextView jlF;
    private View jlG;
    private TextView jlH;
    private ImageView jlI;
    private BdListView jlJ;
    private AnimationDrawable jlK;
    private SettingTextSwitchView jlL;
    private m jlM;
    private String jlh;
    private String jli;
    private boolean jll;
    private String jls;
    private String jlt;
    private a.b jlx;
    private a.b jly;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.jjZ = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.jlB = null;
        this.eUl = null;
        this.eUm = null;
        this.jlC = null;
        this.jlD = null;
        this.jlE = null;
        this.jlF = null;
        this.jlG = null;
        this.jlH = null;
        this.jlI = null;
        this.jlJ = null;
        this.jlK = null;
        this.jlL = null;
        this.jls = "";
        this.jlt = "";
        this.jll = false;
        this.jlM = null;
        this.jkZ = null;
        this.jlh = "";
        this.jli = "";
        this.jly = null;
        this.jlx = null;
        this.jls = str;
        this.jlt = str2;
        this.jll = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cDq() {
        this.jkZ.startLoad();
    }

    public void cDr() {
        if (this.jkZ != null) {
            this.jkZ.cancelLoad();
            this.jkZ = null;
        }
    }

    public void cDG() {
        this.jlE.setVisibility(8);
    }

    public void cDH() {
        this.jlE.setVisibility(0);
    }

    public void cDD() {
        if (this.jlM != null) {
            this.jlM.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.jlB = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.jlD = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.jlC = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.jlC.setOnClickListener(this.jlB);
        this.jlE = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.jls)) {
            stringBuffer.append(this.jls);
        }
        if (!TextUtils.isEmpty(this.jlt)) {
            stringBuffer.append(this.jlt);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.jlC.setVisibility(0);
            this.jlD.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.jlC.setVisibility(8);
            this.jlD.setVisibility(8);
        }
        this.jlG = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.jlG.setOnClickListener(this.jlB);
        this.jlH = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.jlI = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.jlI.setVisibility(8);
        this.jlF = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.jlJ = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.jlJ.setOnItemClickListener(this.jlB);
        this.jlL = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.jll) {
            this.jlL.turnOn();
        } else {
            this.jlL.turnOff();
        }
        this.jlL.setSwitchStateChangeListener(this.jlB);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eUm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eUl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eUm.setOnClickListener(groupAddressLocateActivity);
        this.eUl.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.jkZ = new com.baidu.tieba.im.util.b(this.jlB);
        this.jkZ.setUniqueId(this.jlB.getUniqueId());
        if (!ae.d(this.jlB, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cDq();
        }
    }

    public void cDI() {
        this.jlF.setText(R.string.address_pos_list);
        this.jlH.setText(R.string.location_loading);
        this.jlI.setVisibility(8);
        this.jjZ = 3;
        cDK();
    }

    public void cDJ() {
        this.jlF.setText(R.string.address_locate_noaddresslist);
        this.jlH.setText(R.string.address_locate_failed_tryagain);
        this.jlI.setVisibility(0);
        this.jjZ = 2;
        cDK();
    }

    public void J(String[] strArr) {
        this.jlG.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.jlF.setText(R.string.address_pos_list);
            this.jlM = new m(this.jlB, strArr);
            this.jlJ.setAdapter((ListAdapter) this.jlM);
            this.jlJ.setVisibility(0);
        } else {
            this.jlF.setText(R.string.address_locate_noaddresslist);
        }
        cDK();
    }

    public void cCC() {
        this.jlF.setText(R.string.address_pos_list);
        this.jlH.setText(R.string.address_locate_failed_opengps);
        this.jlI.setVisibility(0);
        this.jjZ = 1;
        cDK();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.jlH.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.jlK = (AnimationDrawable) compoundDrawables[0];
            cDK();
        }
    }

    private void cDK() {
        if (this.jlK != null) {
            if (this.jjZ == 3) {
                this.jlK.start();
                return;
            }
            this.jlK.stop();
            this.jlK.selectDrawable(0);
        }
    }

    public void Kg(String str) {
        this.jlh = str;
    }

    public void Kh(String str) {
        this.jli = str;
    }

    public View cDC() {
        return this.eUl;
    }

    public View getBackButton() {
        return this.eUm;
    }

    public View cDL() {
        return this.jlC;
    }

    public View cDM() {
        return this.jlG;
    }

    public int cCA() {
        return this.jjZ;
    }

    public void b(a.b bVar) {
        this.jly = bVar;
    }

    public void c(a.b bVar) {
        this.jlx = bVar;
    }

    public void Nv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jlB.getPageContext().getPageActivity());
        aVar.m39if(false);
        aVar.nt(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.jly != null) {
                    n.this.jly.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.jlx != null) {
                    n.this.jlx.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jlB.getPageContext());
        aVar.bhg();
    }

    public void onChangeSkinType(int i) {
        this.jlB.getLayoutMode().setNightMode(i == 1);
        this.jlB.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.eUl, R.color.cp_cont_f, 1);
    }
}
