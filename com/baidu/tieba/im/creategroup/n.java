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
    private TextView dFI;
    private View dFJ;
    private int hvN;
    private com.baidu.tieba.im.util.b hwN;
    private String hwV;
    private String hwW;
    private boolean hwZ;
    private m hxA;
    private String hxg;
    private String hxh;
    private a.b hxl;
    private a.b hxm;
    private GroupAddressLocateActivity hxp;
    private View hxq;
    private TextView hxr;
    private ImageView hxs;
    private TextView hxt;
    private View hxu;
    private TextView hxv;
    private ImageView hxw;
    private BdListView hxx;
    private AnimationDrawable hxy;
    private SettingTextSwitchView hxz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.hvN = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.hxp = null;
        this.dFI = null;
        this.dFJ = null;
        this.hxq = null;
        this.hxr = null;
        this.hxs = null;
        this.hxt = null;
        this.hxu = null;
        this.hxv = null;
        this.hxw = null;
        this.hxx = null;
        this.hxy = null;
        this.hxz = null;
        this.hxg = "";
        this.hxh = "";
        this.hwZ = false;
        this.hxA = null;
        this.hwN = null;
        this.hwV = "";
        this.hwW = "";
        this.hxm = null;
        this.hxl = null;
        this.hxg = str;
        this.hxh = str2;
        this.hwZ = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bTD() {
        this.hwN.startLoad();
    }

    public void bTE() {
        if (this.hwN != null) {
            this.hwN.cancelLoad();
            this.hwN = null;
        }
    }

    public void bTT() {
        this.hxs.setVisibility(8);
    }

    public void bTU() {
        this.hxs.setVisibility(0);
    }

    public void bTQ() {
        if (this.hxA != null) {
            this.hxA.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.hxp = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.hxr = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.hxq = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.hxq.setOnClickListener(this.hxp);
        this.hxs = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.hxg)) {
            stringBuffer.append(this.hxg);
        }
        if (!TextUtils.isEmpty(this.hxh)) {
            stringBuffer.append(this.hxh);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.hxq.setVisibility(0);
            this.hxr.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.hxq.setVisibility(8);
            this.hxr.setVisibility(8);
        }
        this.hxu = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.hxu.setOnClickListener(this.hxp);
        this.hxv = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.hxw = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.hxw.setVisibility(8);
        this.hxt = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.hxx = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.hxx.setOnItemClickListener(this.hxp);
        this.hxz = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.hwZ) {
            this.hxz.turnOn();
        } else {
            this.hxz.turnOff();
        }
        this.hxz.setSwitchStateChangeListener(this.hxp);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dFJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.dFJ.setOnClickListener(groupAddressLocateActivity);
        this.dFI.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.hwN = new com.baidu.tieba.im.util.b(this.hxp);
        this.hwN.setUniqueId(this.hxp.getUniqueId());
        bTD();
    }

    public void bTV() {
        this.hxt.setText(R.string.address_pos_list);
        this.hxv.setText(R.string.location_loading);
        this.hxw.setVisibility(8);
        this.hvN = 3;
        bTX();
    }

    public void bTW() {
        this.hxt.setText(R.string.address_locate_noaddresslist);
        this.hxv.setText(R.string.address_locate_failed_tryagain);
        this.hxw.setVisibility(0);
        this.hvN = 2;
        bTX();
    }

    public void I(String[] strArr) {
        this.hxu.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.hxt.setText(R.string.address_pos_list);
            this.hxA = new m(this.hxp, strArr);
            this.hxx.setAdapter((ListAdapter) this.hxA);
            this.hxx.setVisibility(0);
        } else {
            this.hxt.setText(R.string.address_locate_noaddresslist);
        }
        bTX();
    }

    public void bSO() {
        this.hxt.setText(R.string.address_pos_list);
        this.hxv.setText(R.string.address_locate_failed_opengps);
        this.hxw.setVisibility(0);
        this.hvN = 1;
        bTX();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.hxv.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.hxy = (AnimationDrawable) compoundDrawables[0];
            bTX();
        }
    }

    private void bTX() {
        if (this.hxy != null) {
            if (this.hvN == 3) {
                this.hxy.start();
                return;
            }
            this.hxy.stop();
            this.hxy.selectDrawable(0);
        }
    }

    public void CD(String str) {
        this.hwV = str;
    }

    public void CE(String str) {
        this.hwW = str;
    }

    public View bTP() {
        return this.dFI;
    }

    public View getBackButton() {
        return this.dFJ;
    }

    public View bTY() {
        return this.hxq;
    }

    public View bTZ() {
        return this.hxu;
    }

    public int bSM() {
        return this.hvN;
    }

    public void b(a.b bVar) {
        this.hxm = bVar;
    }

    public void c(a.b bVar) {
        this.hxl = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hxp.getPageContext().getPageActivity());
        aVar.fG(false);
        aVar.jW(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hxm != null) {
                    n.this.hxm.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hxl != null) {
                    n.this.hxl.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hxp.getPageContext());
        aVar.aEA();
    }

    public void onChangeSkinType(int i) {
        this.hxp.getLayoutMode().setNightMode(i == 1);
        this.hxp.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dFI, R.color.cp_cont_f, 1);
    }
}
