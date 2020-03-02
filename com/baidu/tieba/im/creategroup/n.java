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
/* loaded from: classes10.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView dFJ;
    private View dFK;
    private int hvP;
    private com.baidu.tieba.im.util.b hwP;
    private String hwX;
    private String hwY;
    private AnimationDrawable hxA;
    private SettingTextSwitchView hxB;
    private m hxC;
    private boolean hxb;
    private String hxi;
    private String hxj;
    private a.b hxn;
    private a.b hxo;
    private GroupAddressLocateActivity hxr;
    private View hxs;
    private TextView hxt;
    private ImageView hxu;
    private TextView hxv;
    private View hxw;
    private TextView hxx;
    private ImageView hxy;
    private BdListView hxz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.hvP = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.hxr = null;
        this.dFJ = null;
        this.dFK = null;
        this.hxs = null;
        this.hxt = null;
        this.hxu = null;
        this.hxv = null;
        this.hxw = null;
        this.hxx = null;
        this.hxy = null;
        this.hxz = null;
        this.hxA = null;
        this.hxB = null;
        this.hxi = "";
        this.hxj = "";
        this.hxb = false;
        this.hxC = null;
        this.hwP = null;
        this.hwX = "";
        this.hwY = "";
        this.hxo = null;
        this.hxn = null;
        this.hxi = str;
        this.hxj = str2;
        this.hxb = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bTF() {
        this.hwP.startLoad();
    }

    public void bTG() {
        if (this.hwP != null) {
            this.hwP.cancelLoad();
            this.hwP = null;
        }
    }

    public void bTV() {
        this.hxu.setVisibility(8);
    }

    public void bTW() {
        this.hxu.setVisibility(0);
    }

    public void bTS() {
        if (this.hxC != null) {
            this.hxC.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.hxr = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.hxt = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.hxs = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.hxs.setOnClickListener(this.hxr);
        this.hxu = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.hxi)) {
            stringBuffer.append(this.hxi);
        }
        if (!TextUtils.isEmpty(this.hxj)) {
            stringBuffer.append(this.hxj);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.hxs.setVisibility(0);
            this.hxt.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.hxs.setVisibility(8);
            this.hxt.setVisibility(8);
        }
        this.hxw = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.hxw.setOnClickListener(this.hxr);
        this.hxx = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.hxy = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.hxy.setVisibility(8);
        this.hxv = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.hxz = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.hxz.setOnItemClickListener(this.hxr);
        this.hxB = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.hxb) {
            this.hxB.turnOn();
        } else {
            this.hxB.turnOff();
        }
        this.hxB.setSwitchStateChangeListener(this.hxr);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dFK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.dFK.setOnClickListener(groupAddressLocateActivity);
        this.dFJ.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.hwP = new com.baidu.tieba.im.util.b(this.hxr);
        this.hwP.setUniqueId(this.hxr.getUniqueId());
        bTF();
    }

    public void bTX() {
        this.hxv.setText(R.string.address_pos_list);
        this.hxx.setText(R.string.location_loading);
        this.hxy.setVisibility(8);
        this.hvP = 3;
        bTZ();
    }

    public void bTY() {
        this.hxv.setText(R.string.address_locate_noaddresslist);
        this.hxx.setText(R.string.address_locate_failed_tryagain);
        this.hxy.setVisibility(0);
        this.hvP = 2;
        bTZ();
    }

    public void I(String[] strArr) {
        this.hxw.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.hxv.setText(R.string.address_pos_list);
            this.hxC = new m(this.hxr, strArr);
            this.hxz.setAdapter((ListAdapter) this.hxC);
            this.hxz.setVisibility(0);
        } else {
            this.hxv.setText(R.string.address_locate_noaddresslist);
        }
        bTZ();
    }

    public void bSQ() {
        this.hxv.setText(R.string.address_pos_list);
        this.hxx.setText(R.string.address_locate_failed_opengps);
        this.hxy.setVisibility(0);
        this.hvP = 1;
        bTZ();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.hxx.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.hxA = (AnimationDrawable) compoundDrawables[0];
            bTZ();
        }
    }

    private void bTZ() {
        if (this.hxA != null) {
            if (this.hvP == 3) {
                this.hxA.start();
                return;
            }
            this.hxA.stop();
            this.hxA.selectDrawable(0);
        }
    }

    public void CD(String str) {
        this.hwX = str;
    }

    public void CE(String str) {
        this.hwY = str;
    }

    public View bTR() {
        return this.dFJ;
    }

    public View getBackButton() {
        return this.dFK;
    }

    public View bUa() {
        return this.hxs;
    }

    public View bUb() {
        return this.hxw;
    }

    public int bSO() {
        return this.hvP;
    }

    public void b(a.b bVar) {
        this.hxo = bVar;
    }

    public void c(a.b bVar) {
        this.hxn = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hxr.getPageContext().getPageActivity());
        aVar.fG(false);
        aVar.jW(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hxo != null) {
                    n.this.hxo.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hxn != null) {
                    n.this.hxn.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hxr.getPageContext());
        aVar.aEC();
    }

    public void onChangeSkinType(int i) {
        this.hxr.getLayoutMode().setNightMode(i == 1);
        this.hxr.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dFJ, R.color.cp_cont_f, 1);
    }
}
