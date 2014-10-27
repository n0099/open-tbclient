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
    private int aSO;
    private View aTJ;
    private com.baidu.tieba.im.util.d aTT;
    private View aUA;
    private TextView aUB;
    private ImageView aUC;
    private TextView aUD;
    private View aUE;
    private TextView aUF;
    private ImageView aUG;
    private BdListView aUH;
    private AnimationDrawable aUI;
    private SettingTextSwitchView aUJ;
    private u aUK;
    private String aUb;
    private String aUc;
    private boolean aUg;
    private TextView aUj;
    private String aUp;
    private String aUq;
    private DialogInterface.OnClickListener aUv;
    private DialogInterface.OnClickListener aUw;
    private GroupAddressLocateActivity aUz;
    private View agA;
    private NavigationBar mNavigationBar;

    public v(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity);
        this.aSO = 3;
        this.mNavigationBar = null;
        this.agA = null;
        this.aUz = null;
        this.aUj = null;
        this.aTJ = null;
        this.aUA = null;
        this.aUB = null;
        this.aUC = null;
        this.aUD = null;
        this.aUE = null;
        this.aUF = null;
        this.aUG = null;
        this.aUH = null;
        this.aUI = null;
        this.aUJ = null;
        this.aUp = "";
        this.aUq = "";
        this.aUg = false;
        this.aUK = null;
        this.aTT = null;
        this.aUb = "";
        this.aUc = "";
        this.aUw = null;
        this.aUv = null;
        this.aUp = str;
        this.aUq = str2;
        this.aUg = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void LJ() {
        this.aTT.Nj();
    }

    public void LK() {
        if (this.aTT != null) {
            this.aTT.RQ();
            this.aTT = null;
        }
    }

    public void Ma() {
        this.aUC.setVisibility(8);
    }

    public void Mb() {
        this.aUC.setVisibility(0);
    }

    public void LX() {
        if (this.aUK != null) {
            this.aUK.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aUz = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(com.baidu.tieba.w.group_address_locate_activity);
        this.agA = groupAddressLocateActivity.findViewById(com.baidu.tieba.v.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_content_currentpos);
        this.aUB = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_title_currentpos);
        this.aUA = groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_content_container);
        this.aUA.setOnClickListener(this.aUz);
        this.aUC = (ImageView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.aUp)) {
            stringBuffer.append(this.aUp);
        }
        if (!TextUtils.isEmpty(this.aUq)) {
            stringBuffer.append(this.aUq);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.aUA.setVisibility(0);
            this.aUB.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.aUA.setVisibility(8);
            this.aUB.setVisibility(8);
        }
        this.aUE = groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_locatearea_layout);
        this.aUE.setOnClickListener(this.aUz);
        this.aUF = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_locatearea_textview);
        this.aUG = (ImageView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_locatearea_rightarrow);
        this.aUG.setVisibility(8);
        this.aUD = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_title_poslist);
        this.aUH = (BdListView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_addresslist_listview);
        this.aUH.setOnItemClickListener(this.aUz);
        this.aUJ = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_showorhidden);
        if (this.aUg) {
            this.aUJ.gN();
        } else {
            this.aUJ.gO();
        }
        this.aUJ.setSwitchStateChangeListener(this.aUz);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(com.baidu.tieba.y.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.aTJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(com.baidu.tieba.y.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aTJ.setOnClickListener(groupAddressLocateActivity);
        this.aUj.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.aTT = new com.baidu.tieba.im.util.d(this.aUz);
        this.aTT.setUniqueId(this.aUz.getUniqueId());
        LJ();
    }

    public void Mc() {
        this.aUD.setText(com.baidu.tieba.y.address_pos_list);
        this.aUF.setText(com.baidu.tieba.y.address_locating);
        this.aUG.setVisibility(8);
        this.aSO = 3;
        Me();
    }

    public void Md() {
        this.aUD.setText(com.baidu.tieba.y.address_locate_noaddresslist);
        this.aUF.setText(com.baidu.tieba.y.address_locate_failed_tryagain);
        this.aUG.setVisibility(0);
        this.aSO = 2;
        Me();
    }

    public void w(String[] strArr) {
        this.aUE.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.aUD.setText(com.baidu.tieba.y.address_pos_list);
            this.aUK = new u(this.aUz, strArr);
            this.aUH.setAdapter((ListAdapter) this.aUK);
            this.aUH.setVisibility(0);
        } else {
            this.aUD.setText(com.baidu.tieba.y.address_locate_noaddresslist);
        }
        Me();
    }

    public void KT() {
        this.aUD.setText(com.baidu.tieba.y.address_pos_list);
        this.aUF.setText(com.baidu.tieba.y.address_locate_failed_opengps);
        this.aUG.setVisibility(0);
        this.aSO = 1;
        Me();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.aUF.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.aUI = (AnimationDrawable) compoundDrawables[0];
            Me();
        }
    }

    private void Me() {
        if (this.aUI != null) {
            if (this.aSO == 3) {
                this.aUI.start();
                return;
            }
            this.aUI.stop();
            this.aUI.selectDrawable(0);
        }
    }

    public void fM(String str) {
        this.aUb = str;
    }

    public void fN(String str) {
        this.aUc = str;
    }

    public View LV() {
        return this.aUj;
    }

    public View LW() {
        return this.aTJ;
    }

    public View Mf() {
        return this.aUA;
    }

    public View Mg() {
        return this.aUE;
    }

    public int KR() {
        return this.aSO;
    }

    public void c(DialogInterface.OnClickListener onClickListener) {
        this.aUw = onClickListener;
    }

    public void d(DialogInterface.OnClickListener onClickListener) {
        this.aUv = onClickListener;
    }

    public void Mh() {
        com.baidu.adp.lib.g.j.a(new AlertDialog.Builder(this.aUz).setTitle(com.baidu.tieba.y.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.group_update_alert_save).setPositiveButton(com.baidu.tieba.y.group_update_canel, new w(this)).setNegativeButton(com.baidu.tieba.y.group_update_done, new x(this)).create(), this.aUz);
    }

    public void onChangeSkinType(int i) {
        this.aUz.getLayoutMode().L(i == 1);
        this.aUz.getLayoutMode().h(this.agA);
        aw.e(this.agA, i);
        this.mNavigationBar.onChangeSkinType(i);
        aw.i(this.agA, com.baidu.tieba.s.group_info_bg);
    }
}
