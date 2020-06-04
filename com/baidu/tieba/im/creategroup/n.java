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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView eum;
    private View eun;
    private int iwQ;
    private com.baidu.tieba.im.util.b ixQ;
    private String ixY;
    private String ixZ;
    private BdListView iyA;
    private AnimationDrawable iyB;
    private SettingTextSwitchView iyC;
    private m iyD;
    private boolean iyc;
    private String iyj;
    private String iyk;
    private a.b iyo;
    private a.b iyp;
    private GroupAddressLocateActivity iys;
    private View iyt;
    private TextView iyu;
    private ImageView iyv;
    private TextView iyw;
    private View iyx;
    private TextView iyy;
    private ImageView iyz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.iwQ = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.iys = null;
        this.eum = null;
        this.eun = null;
        this.iyt = null;
        this.iyu = null;
        this.iyv = null;
        this.iyw = null;
        this.iyx = null;
        this.iyy = null;
        this.iyz = null;
        this.iyA = null;
        this.iyB = null;
        this.iyC = null;
        this.iyj = "";
        this.iyk = "";
        this.iyc = false;
        this.iyD = null;
        this.ixQ = null;
        this.ixY = "";
        this.ixZ = "";
        this.iyp = null;
        this.iyo = null;
        this.iyj = str;
        this.iyk = str2;
        this.iyc = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cle() {
        this.ixQ.startLoad();
    }

    public void clf() {
        if (this.ixQ != null) {
            this.ixQ.cancelLoad();
            this.ixQ = null;
        }
    }

    public void clu() {
        this.iyv.setVisibility(8);
    }

    public void clv() {
        this.iyv.setVisibility(0);
    }

    public void clr() {
        if (this.iyD != null) {
            this.iyD.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.iys = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.iyu = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.iyt = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.iyt.setOnClickListener(this.iys);
        this.iyv = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.iyj)) {
            stringBuffer.append(this.iyj);
        }
        if (!TextUtils.isEmpty(this.iyk)) {
            stringBuffer.append(this.iyk);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.iyt.setVisibility(0);
            this.iyu.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.iyt.setVisibility(8);
            this.iyu.setVisibility(8);
        }
        this.iyx = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.iyx.setOnClickListener(this.iys);
        this.iyy = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.iyz = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.iyz.setVisibility(8);
        this.iyw = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.iyA = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.iyA.setOnItemClickListener(this.iys);
        this.iyC = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.iyc) {
            this.iyC.turnOn();
        } else {
            this.iyC.turnOff();
        }
        this.iyC.setSwitchStateChangeListener(this.iys);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eum = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.eun.setOnClickListener(groupAddressLocateActivity);
        this.eum.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.ixQ = new com.baidu.tieba.im.util.b(this.iys);
        this.ixQ.setUniqueId(this.iys.getUniqueId());
        if (!ab.d(this.iys, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cle();
        }
    }

    public void clw() {
        this.iyw.setText(R.string.address_pos_list);
        this.iyy.setText(R.string.location_loading);
        this.iyz.setVisibility(8);
        this.iwQ = 3;
        cly();
    }

    public void clx() {
        this.iyw.setText(R.string.address_locate_noaddresslist);
        this.iyy.setText(R.string.address_locate_failed_tryagain);
        this.iyz.setVisibility(0);
        this.iwQ = 2;
        cly();
    }

    public void L(String[] strArr) {
        this.iyx.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.iyw.setText(R.string.address_pos_list);
            this.iyD = new m(this.iys, strArr);
            this.iyA.setAdapter((ListAdapter) this.iyD);
            this.iyA.setVisibility(0);
        } else {
            this.iyw.setText(R.string.address_locate_noaddresslist);
        }
        cly();
    }

    public void ckp() {
        this.iyw.setText(R.string.address_pos_list);
        this.iyy.setText(R.string.address_locate_failed_opengps);
        this.iyz.setVisibility(0);
        this.iwQ = 1;
        cly();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.iyy.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.iyB = (AnimationDrawable) compoundDrawables[0];
            cly();
        }
    }

    private void cly() {
        if (this.iyB != null) {
            if (this.iwQ == 3) {
                this.iyB.start();
                return;
            }
            this.iyB.stop();
            this.iyB.selectDrawable(0);
        }
    }

    public void FY(String str) {
        this.ixY = str;
    }

    public void FZ(String str) {
        this.ixZ = str;
    }

    public View clq() {
        return this.eum;
    }

    public View getBackButton() {
        return this.eun;
    }

    public View clz() {
        return this.iyt;
    }

    public View clA() {
        return this.iyx;
    }

    public int ckn() {
        return this.iwQ;
    }

    public void b(a.b bVar) {
        this.iyp = bVar;
    }

    public void c(a.b bVar) {
        this.iyo = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iys.getPageContext().getPageActivity());
        aVar.gW(false);
        aVar.kF(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iyp != null) {
                    n.this.iyp.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.iyo != null) {
                    n.this.iyo.onClick(aVar2);
                }
            }
        });
        aVar.b(this.iys.getPageContext());
        aVar.aST();
    }

    public void onChangeSkinType(int i) {
        this.iys.getLayoutMode().setNightMode(i == 1);
        this.iys.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.eum, R.color.cp_cont_f, 1);
    }
}
