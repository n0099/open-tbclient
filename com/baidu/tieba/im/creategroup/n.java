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
    private TextView cOq;
    private View cOr;
    private int gCX;
    private com.baidu.tieba.im.util.b gDX;
    private View gEA;
    private TextView gEB;
    private ImageView gEC;
    private TextView gED;
    private View gEE;
    private TextView gEF;
    private ImageView gEG;
    private BdListView gEH;
    private AnimationDrawable gEI;
    private SettingTextSwitchView gEJ;
    private m gEK;
    private String gEf;
    private String gEg;
    private boolean gEj;
    private String gEq;
    private String gEr;
    private a.b gEv;
    private a.b gEw;
    private GroupAddressLocateActivity gEz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.gCX = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.gEz = null;
        this.cOq = null;
        this.cOr = null;
        this.gEA = null;
        this.gEB = null;
        this.gEC = null;
        this.gED = null;
        this.gEE = null;
        this.gEF = null;
        this.gEG = null;
        this.gEH = null;
        this.gEI = null;
        this.gEJ = null;
        this.gEq = "";
        this.gEr = "";
        this.gEj = false;
        this.gEK = null;
        this.gDX = null;
        this.gEf = "";
        this.gEg = "";
        this.gEw = null;
        this.gEv = null;
        this.gEq = str;
        this.gEr = str2;
        this.gEj = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bzF() {
        this.gDX.startLoad();
    }

    public void bzG() {
        if (this.gDX != null) {
            this.gDX.cancelLoad();
            this.gDX = null;
        }
    }

    public void bzV() {
        this.gEC.setVisibility(8);
    }

    public void bzW() {
        this.gEC.setVisibility(0);
    }

    public void bzS() {
        if (this.gEK != null) {
            this.gEK.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.gEz = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.gEB = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.gEA = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.gEA.setOnClickListener(this.gEz);
        this.gEC = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.gEq)) {
            stringBuffer.append(this.gEq);
        }
        if (!TextUtils.isEmpty(this.gEr)) {
            stringBuffer.append(this.gEr);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.gEA.setVisibility(0);
            this.gEB.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.gEA.setVisibility(8);
            this.gEB.setVisibility(8);
        }
        this.gEE = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.gEE.setOnClickListener(this.gEz);
        this.gEF = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.gEG = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.gEG.setVisibility(8);
        this.gED = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.gEH = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.gEH.setOnItemClickListener(this.gEz);
        this.gEJ = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.gEj) {
            this.gEJ.turnOn();
        } else {
            this.gEJ.turnOff();
        }
        this.gEJ.setSwitchStateChangeListener(this.gEz);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.cOr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cOq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.cOr.setOnClickListener(groupAddressLocateActivity);
        this.cOq.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.gDX = new com.baidu.tieba.im.util.b(this.gEz);
        this.gDX.setUniqueId(this.gEz.getUniqueId());
        bzF();
    }

    public void bzX() {
        this.gED.setText(R.string.address_pos_list);
        this.gEF.setText(R.string.location_loading);
        this.gEG.setVisibility(8);
        this.gCX = 3;
        bzZ();
    }

    public void bzY() {
        this.gED.setText(R.string.address_locate_noaddresslist);
        this.gEF.setText(R.string.address_locate_failed_tryagain);
        this.gEG.setVisibility(0);
        this.gCX = 2;
        bzZ();
    }

    public void y(String[] strArr) {
        this.gEE.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.gED.setText(R.string.address_pos_list);
            this.gEK = new m(this.gEz, strArr);
            this.gEH.setAdapter((ListAdapter) this.gEK);
            this.gEH.setVisibility(0);
        } else {
            this.gED.setText(R.string.address_locate_noaddresslist);
        }
        bzZ();
    }

    public void byP() {
        this.gED.setText(R.string.address_pos_list);
        this.gEF.setText(R.string.address_locate_failed_opengps);
        this.gEG.setVisibility(0);
        this.gCX = 1;
        bzZ();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.gEF.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.gEI = (AnimationDrawable) compoundDrawables[0];
            bzZ();
        }
    }

    private void bzZ() {
        if (this.gEI != null) {
            if (this.gCX == 3) {
                this.gEI.start();
                return;
            }
            this.gEI.stop();
            this.gEI.selectDrawable(0);
        }
    }

    public void xu(String str) {
        this.gEf = str;
    }

    public void xv(String str) {
        this.gEg = str;
    }

    public View bzR() {
        return this.cOq;
    }

    public View getBackButton() {
        return this.cOr;
    }

    public View bAa() {
        return this.gEA;
    }

    public View bAb() {
        return this.gEE;
    }

    public int byN() {
        return this.gCX;
    }

    public void b(a.b bVar) {
        this.gEw = bVar;
    }

    public void c(a.b bVar) {
        this.gEv = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gEz.getPageContext().getPageActivity());
        aVar.eg(false);
        aVar.hU(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gEw != null) {
                    n.this.gEw.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.gEv != null) {
                    n.this.gEv.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gEz.getPageContext());
        aVar.akO();
    }

    public void onChangeSkinType(int i) {
        this.gEz.getLayoutMode().setNightMode(i == 1);
        this.gEz.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.cOq, R.color.cp_cont_f, 1);
    }
}
