package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f {
    private View aTX;
    private int aTc;
    private String aUD;
    private String aUE;
    private DialogInterface.OnClickListener aUJ;
    private DialogInterface.OnClickListener aUK;
    private GroupAddressLocateActivity aUN;
    private View aUO;
    private TextView aUP;
    private ImageView aUQ;
    private TextView aUR;
    private View aUS;
    private TextView aUT;
    private ImageView aUU;
    private BdListView aUV;
    private AnimationDrawable aUW;
    private SettingTextSwitchView aUX;
    private u aUY;
    private com.baidu.tieba.im.util.d aUh;
    private String aUp;
    private String aUq;
    private boolean aUu;
    private TextView aUx;
    private View agI;
    private NavigationBar mNavigationBar;

    public v(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity);
        this.aTc = 3;
        this.mNavigationBar = null;
        this.agI = null;
        this.aUN = null;
        this.aUx = null;
        this.aTX = null;
        this.aUO = null;
        this.aUP = null;
        this.aUQ = null;
        this.aUR = null;
        this.aUS = null;
        this.aUT = null;
        this.aUU = null;
        this.aUV = null;
        this.aUW = null;
        this.aUX = null;
        this.aUD = "";
        this.aUE = "";
        this.aUu = false;
        this.aUY = null;
        this.aUh = null;
        this.aUp = "";
        this.aUq = "";
        this.aUK = null;
        this.aUJ = null;
        this.aUD = str;
        this.aUE = str2;
        this.aUu = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void LN() {
        this.aUh.Nn();
    }

    public void LO() {
        if (this.aUh != null) {
            this.aUh.RT();
            this.aUh = null;
        }
    }

    public void Me() {
        this.aUQ.setVisibility(8);
    }

    public void Mf() {
        this.aUQ.setVisibility(0);
    }

    public void Mb() {
        if (this.aUY != null) {
            this.aUY.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aUN = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(com.baidu.tieba.w.group_address_locate_activity);
        this.agI = groupAddressLocateActivity.findViewById(com.baidu.tieba.v.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_content_currentpos);
        this.aUP = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_title_currentpos);
        this.aUO = groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_content_container);
        this.aUO.setOnClickListener(this.aUN);
        this.aUQ = (ImageView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.aUD)) {
            stringBuffer.append(this.aUD);
        }
        if (!TextUtils.isEmpty(this.aUE)) {
            stringBuffer.append(this.aUE);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.aUO.setVisibility(0);
            this.aUP.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.aUO.setVisibility(8);
            this.aUP.setVisibility(8);
        }
        this.aUS = groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_locatearea_layout);
        this.aUS.setOnClickListener(this.aUN);
        this.aUT = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_locatearea_textview);
        this.aUU = (ImageView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_locatearea_rightarrow);
        this.aUU.setVisibility(8);
        this.aUR = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_title_poslist);
        this.aUV = (BdListView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_addresslist_listview);
        this.aUV.setOnItemClickListener(this.aUN);
        this.aUX = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_showorhidden);
        if (this.aUu) {
            this.aUX.gN();
        } else {
            this.aUX.gO();
        }
        this.aUX.setSwitchStateChangeListener(this.aUN);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(com.baidu.tieba.y.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aTX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(com.baidu.tieba.y.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aTX.setOnClickListener(groupAddressLocateActivity);
        this.aUx.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.aUh = new com.baidu.tieba.im.util.d(this.aUN);
        this.aUh.setUniqueId(this.aUN.getUniqueId());
        LN();
    }

    public void Mg() {
        this.aUR.setText(com.baidu.tieba.y.address_pos_list);
        this.aUT.setText(com.baidu.tieba.y.address_locating);
        this.aUU.setVisibility(8);
        this.aTc = 3;
        Mi();
    }

    public void Mh() {
        this.aUR.setText(com.baidu.tieba.y.address_locate_noaddresslist);
        this.aUT.setText(com.baidu.tieba.y.address_locate_failed_tryagain);
        this.aUU.setVisibility(0);
        this.aTc = 2;
        Mi();
    }

    public void w(String[] strArr) {
        this.aUS.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.aUR.setText(com.baidu.tieba.y.address_pos_list);
            this.aUY = new u(this.aUN, strArr);
            this.aUV.setAdapter((ListAdapter) this.aUY);
            this.aUV.setVisibility(0);
        } else {
            this.aUR.setText(com.baidu.tieba.y.address_locate_noaddresslist);
        }
        Mi();
    }

    public void KX() {
        this.aUR.setText(com.baidu.tieba.y.address_pos_list);
        this.aUT.setText(com.baidu.tieba.y.address_locate_failed_opengps);
        this.aUU.setVisibility(0);
        this.aTc = 1;
        Mi();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.aUT.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.aUW = (AnimationDrawable) compoundDrawables[0];
            Mi();
        }
    }

    private void Mi() {
        if (this.aUW != null) {
            if (this.aTc == 3) {
                this.aUW.start();
                return;
            }
            this.aUW.stop();
            this.aUW.selectDrawable(0);
        }
    }

    public void fM(String str) {
        this.aUp = str;
    }

    public void fN(String str) {
        this.aUq = str;
    }

    public View LZ() {
        return this.aUx;
    }

    public View Ma() {
        return this.aTX;
    }

    public View Mj() {
        return this.aUO;
    }

    public View Mk() {
        return this.aUS;
    }

    public int KV() {
        return this.aTc;
    }

    public void c(DialogInterface.OnClickListener onClickListener) {
        this.aUK = onClickListener;
    }

    public void d(DialogInterface.OnClickListener onClickListener) {
        this.aUJ = onClickListener;
    }

    public void Ml() {
        com.baidu.adp.lib.g.j.a(new AlertDialog.Builder(this.aUN).setTitle(com.baidu.tieba.y.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.group_update_alert_save).setPositiveButton(com.baidu.tieba.y.group_update_canel, new w(this)).setNegativeButton(com.baidu.tieba.y.group_update_done, new x(this)).create(), this.aUN);
    }

    public void onChangeSkinType(int i) {
        this.aUN.getLayoutMode().L(i == 1);
        this.aUN.getLayoutMode().h(this.agI);
        aw.e(this.agI, i);
        this.mNavigationBar.onChangeSkinType(i);
        aw.i(this.agI, com.baidu.tieba.s.group_info_bg);
    }
}
