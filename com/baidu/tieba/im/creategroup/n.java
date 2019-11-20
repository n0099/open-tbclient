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
    private View cNA;
    private TextView cNz;
    private int gCg;
    private String gDA;
    private a.b gDE;
    private a.b gDF;
    private GroupAddressLocateActivity gDI;
    private View gDJ;
    private TextView gDK;
    private ImageView gDL;
    private TextView gDM;
    private View gDN;
    private TextView gDO;
    private ImageView gDP;
    private BdListView gDQ;
    private AnimationDrawable gDR;
    private SettingTextSwitchView gDS;
    private m gDT;
    private com.baidu.tieba.im.util.b gDg;
    private String gDo;
    private String gDp;
    private boolean gDs;
    private String gDz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.gCg = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.gDI = null;
        this.cNz = null;
        this.cNA = null;
        this.gDJ = null;
        this.gDK = null;
        this.gDL = null;
        this.gDM = null;
        this.gDN = null;
        this.gDO = null;
        this.gDP = null;
        this.gDQ = null;
        this.gDR = null;
        this.gDS = null;
        this.gDz = "";
        this.gDA = "";
        this.gDs = false;
        this.gDT = null;
        this.gDg = null;
        this.gDo = "";
        this.gDp = "";
        this.gDF = null;
        this.gDE = null;
        this.gDz = str;
        this.gDA = str2;
        this.gDs = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bzD() {
        this.gDg.startLoad();
    }

    public void bzE() {
        if (this.gDg != null) {
            this.gDg.cancelLoad();
            this.gDg = null;
        }
    }

    public void bzT() {
        this.gDL.setVisibility(8);
    }

    public void bzU() {
        this.gDL.setVisibility(0);
    }

    public void bzQ() {
        if (this.gDT != null) {
            this.gDT.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.gDI = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.gDK = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.gDJ = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.gDJ.setOnClickListener(this.gDI);
        this.gDL = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.gDz)) {
            stringBuffer.append(this.gDz);
        }
        if (!TextUtils.isEmpty(this.gDA)) {
            stringBuffer.append(this.gDA);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.gDJ.setVisibility(0);
            this.gDK.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.gDJ.setVisibility(8);
            this.gDK.setVisibility(8);
        }
        this.gDN = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.gDN.setOnClickListener(this.gDI);
        this.gDO = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.gDP = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.gDP.setVisibility(8);
        this.gDM = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.gDQ = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.gDQ.setOnItemClickListener(this.gDI);
        this.gDS = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.gDs) {
            this.gDS.turnOn();
        } else {
            this.gDS.turnOff();
        }
        this.gDS.setSwitchStateChangeListener(this.gDI);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cNA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cNz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.cNA.setOnClickListener(groupAddressLocateActivity);
        this.cNz.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.gDg = new com.baidu.tieba.im.util.b(this.gDI);
        this.gDg.setUniqueId(this.gDI.getUniqueId());
        bzD();
    }

    public void bzV() {
        this.gDM.setText(R.string.address_pos_list);
        this.gDO.setText(R.string.location_loading);
        this.gDP.setVisibility(8);
        this.gCg = 3;
        bzX();
    }

    public void bzW() {
        this.gDM.setText(R.string.address_locate_noaddresslist);
        this.gDO.setText(R.string.address_locate_failed_tryagain);
        this.gDP.setVisibility(0);
        this.gCg = 2;
        bzX();
    }

    public void y(String[] strArr) {
        this.gDN.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.gDM.setText(R.string.address_pos_list);
            this.gDT = new m(this.gDI, strArr);
            this.gDQ.setAdapter((ListAdapter) this.gDT);
            this.gDQ.setVisibility(0);
        } else {
            this.gDM.setText(R.string.address_locate_noaddresslist);
        }
        bzX();
    }

    public void byN() {
        this.gDM.setText(R.string.address_pos_list);
        this.gDO.setText(R.string.address_locate_failed_opengps);
        this.gDP.setVisibility(0);
        this.gCg = 1;
        bzX();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.gDO.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.gDR = (AnimationDrawable) compoundDrawables[0];
            bzX();
        }
    }

    private void bzX() {
        if (this.gDR != null) {
            if (this.gCg == 3) {
                this.gDR.start();
                return;
            }
            this.gDR.stop();
            this.gDR.selectDrawable(0);
        }
    }

    public void xu(String str) {
        this.gDo = str;
    }

    public void xv(String str) {
        this.gDp = str;
    }

    public View bzP() {
        return this.cNz;
    }

    public View getBackButton() {
        return this.cNA;
    }

    public View bzY() {
        return this.gDJ;
    }

    public View bzZ() {
        return this.gDN;
    }

    public int byL() {
        return this.gCg;
    }

    public void b(a.b bVar) {
        this.gDF = bVar;
    }

    public void c(a.b bVar) {
        this.gDE = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gDI.getPageContext().getPageActivity());
        aVar.eg(false);
        aVar.hT(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gDF != null) {
                    n.this.gDF.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gDE != null) {
                    n.this.gDE.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gDI.getPageContext());
        aVar.akM();
    }

    public void onChangeSkinType(int i) {
        this.gDI.getLayoutMode().setNightMode(i == 1);
        this.gDI.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.cNz, R.color.cp_cont_f, 1);
    }
}
