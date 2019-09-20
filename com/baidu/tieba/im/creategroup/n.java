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
    private TextView cDh;
    private View cDi;
    private int gEX;
    private com.baidu.tieba.im.util.b gFY;
    private GroupAddressLocateActivity gGA;
    private View gGB;
    private TextView gGC;
    private ImageView gGD;
    private TextView gGE;
    private View gGF;
    private TextView gGG;
    private ImageView gGH;
    private BdListView gGI;
    private AnimationDrawable gGJ;
    private SettingTextSwitchView gGK;
    private m gGL;
    private String gGg;
    private String gGh;
    private boolean gGk;
    private String gGr;
    private String gGs;
    private a.b gGw;
    private a.b gGx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.gEX = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.gGA = null;
        this.cDh = null;
        this.cDi = null;
        this.gGB = null;
        this.gGC = null;
        this.gGD = null;
        this.gGE = null;
        this.gGF = null;
        this.gGG = null;
        this.gGH = null;
        this.gGI = null;
        this.gGJ = null;
        this.gGK = null;
        this.gGr = "";
        this.gGs = "";
        this.gGk = false;
        this.gGL = null;
        this.gFY = null;
        this.gGg = "";
        this.gGh = "";
        this.gGx = null;
        this.gGw = null;
        this.gGr = str;
        this.gGs = str2;
        this.gGk = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bCU() {
        this.gFY.ayo();
    }

    public void bCV() {
        if (this.gFY != null) {
            this.gFY.cancelLoad();
            this.gFY = null;
        }
    }

    public void bDk() {
        this.gGD.setVisibility(8);
    }

    public void bDl() {
        this.gGD.setVisibility(0);
    }

    public void bDh() {
        if (this.gGL != null) {
            this.gGL.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.gGA = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.gGC = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.gGB = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.gGB.setOnClickListener(this.gGA);
        this.gGD = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.gGr)) {
            stringBuffer.append(this.gGr);
        }
        if (!TextUtils.isEmpty(this.gGs)) {
            stringBuffer.append(this.gGs);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.gGB.setVisibility(0);
            this.gGC.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.gGB.setVisibility(8);
            this.gGC.setVisibility(8);
        }
        this.gGF = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.gGF.setOnClickListener(this.gGA);
        this.gGG = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.gGH = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.gGH.setVisibility(8);
        this.gGE = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.gGI = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.gGI.setOnItemClickListener(this.gGA);
        this.gGK = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.gGk) {
            this.gGK.nm();
        } else {
            this.gGK.nn();
        }
        this.gGK.setSwitchStateChangeListener(this.gGA);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cDi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cDh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.cDi.setOnClickListener(groupAddressLocateActivity);
        this.cDh.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.gFY = new com.baidu.tieba.im.util.b(this.gGA);
        this.gFY.setUniqueId(this.gGA.getUniqueId());
        bCU();
    }

    public void bDm() {
        this.gGE.setText(R.string.address_pos_list);
        this.gGG.setText(R.string.location_loading);
        this.gGH.setVisibility(8);
        this.gEX = 3;
        bDo();
    }

    public void bDn() {
        this.gGE.setText(R.string.address_locate_noaddresslist);
        this.gGG.setText(R.string.address_locate_failed_tryagain);
        this.gGH.setVisibility(0);
        this.gEX = 2;
        bDo();
    }

    public void x(String[] strArr) {
        this.gGF.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.gGE.setText(R.string.address_pos_list);
            this.gGL = new m(this.gGA, strArr);
            this.gGI.setAdapter((ListAdapter) this.gGL);
            this.gGI.setVisibility(0);
        } else {
            this.gGE.setText(R.string.address_locate_noaddresslist);
        }
        bDo();
    }

    public void bCe() {
        this.gGE.setText(R.string.address_pos_list);
        this.gGG.setText(R.string.address_locate_failed_opengps);
        this.gGH.setVisibility(0);
        this.gEX = 1;
        bDo();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.gGG.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.gGJ = (AnimationDrawable) compoundDrawables[0];
            bDo();
        }
    }

    private void bDo() {
        if (this.gGJ != null) {
            if (this.gEX == 3) {
                this.gGJ.start();
                return;
            }
            this.gGJ.stop();
            this.gGJ.selectDrawable(0);
        }
    }

    public void zb(String str) {
        this.gGg = str;
    }

    public void zc(String str) {
        this.gGh = str;
    }

    public View bDg() {
        return this.cDh;
    }

    public View getBackButton() {
        return this.cDi;
    }

    public View bDp() {
        return this.gGB;
    }

    public View bDq() {
        return this.gGF;
    }

    public int bCc() {
        return this.gEX;
    }

    public void b(a.b bVar) {
        this.gGx = bVar;
    }

    public void c(a.b bVar) {
        this.gGw = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gGA.getPageContext().getPageActivity());
        aVar.dQ(false);
        aVar.hv(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gGx != null) {
                    n.this.gGx.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gGw != null) {
                    n.this.gGw.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gGA.getPageContext());
        aVar.agO();
    }

    public void onChangeSkinType(int i) {
        this.gGA.getLayoutMode().setNightMode(i == 1);
        this.gGA.getLayoutMode().onModeChanged(this.mParent);
        am.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.l(this.mParent, R.color.common_color_10041);
        am.f(this.cDh, R.color.cp_cont_f, 1);
    }
}
