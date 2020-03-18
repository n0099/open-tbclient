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
    private TextView dGm;
    private View dGn;
    private int hxB;
    private com.baidu.tieba.im.util.b hyB;
    private String hyJ;
    private String hyK;
    private boolean hyN;
    private String hyU;
    private String hyV;
    private a.b hyZ;
    private a.b hza;
    private GroupAddressLocateActivity hzd;
    private View hze;
    private TextView hzf;
    private ImageView hzg;
    private TextView hzh;
    private View hzi;
    private TextView hzj;
    private ImageView hzk;
    private BdListView hzl;
    private AnimationDrawable hzm;
    private SettingTextSwitchView hzn;
    private m hzo;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.hxB = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.hzd = null;
        this.dGm = null;
        this.dGn = null;
        this.hze = null;
        this.hzf = null;
        this.hzg = null;
        this.hzh = null;
        this.hzi = null;
        this.hzj = null;
        this.hzk = null;
        this.hzl = null;
        this.hzm = null;
        this.hzn = null;
        this.hyU = "";
        this.hyV = "";
        this.hyN = false;
        this.hzo = null;
        this.hyB = null;
        this.hyJ = "";
        this.hyK = "";
        this.hza = null;
        this.hyZ = null;
        this.hyU = str;
        this.hyV = str2;
        this.hyN = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void bTY() {
        this.hyB.startLoad();
    }

    public void bTZ() {
        if (this.hyB != null) {
            this.hyB.cancelLoad();
            this.hyB = null;
        }
    }

    public void bUo() {
        this.hzg.setVisibility(8);
    }

    public void bUp() {
        this.hzg.setVisibility(0);
    }

    public void bUl() {
        if (this.hzo != null) {
            this.hzo.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.hzd = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.hzf = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.hze = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.hze.setOnClickListener(this.hzd);
        this.hzg = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.hyU)) {
            stringBuffer.append(this.hyU);
        }
        if (!TextUtils.isEmpty(this.hyV)) {
            stringBuffer.append(this.hyV);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.hze.setVisibility(0);
            this.hzf.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.hze.setVisibility(8);
            this.hzf.setVisibility(8);
        }
        this.hzi = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.hzi.setOnClickListener(this.hzd);
        this.hzj = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.hzk = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.hzk.setVisibility(8);
        this.hzh = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.hzl = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.hzl.setOnItemClickListener(this.hzd);
        this.hzn = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.hyN) {
            this.hzn.turnOn();
        } else {
            this.hzn.turnOff();
        }
        this.hzn.setSwitchStateChangeListener(this.hzd);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.dGn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dGm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.dGn.setOnClickListener(groupAddressLocateActivity);
        this.dGm.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.hyB = new com.baidu.tieba.im.util.b(this.hzd);
        this.hyB.setUniqueId(this.hzd.getUniqueId());
        if (!ab.e(this.hzd, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            bTY();
        }
    }

    public void bUq() {
        this.hzh.setText(R.string.address_pos_list);
        this.hzj.setText(R.string.location_loading);
        this.hzk.setVisibility(8);
        this.hxB = 3;
        bUs();
    }

    public void bUr() {
        this.hzh.setText(R.string.address_locate_noaddresslist);
        this.hzj.setText(R.string.address_locate_failed_tryagain);
        this.hzk.setVisibility(0);
        this.hxB = 2;
        bUs();
    }

    public void I(String[] strArr) {
        this.hzi.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.hzh.setText(R.string.address_pos_list);
            this.hzo = new m(this.hzd, strArr);
            this.hzl.setAdapter((ListAdapter) this.hzo);
            this.hzl.setVisibility(0);
        } else {
            this.hzh.setText(R.string.address_locate_noaddresslist);
        }
        bUs();
    }

    public void bTj() {
        this.hzh.setText(R.string.address_pos_list);
        this.hzj.setText(R.string.address_locate_failed_opengps);
        this.hzk.setVisibility(0);
        this.hxB = 1;
        bUs();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.hzj.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.hzm = (AnimationDrawable) compoundDrawables[0];
            bUs();
        }
    }

    private void bUs() {
        if (this.hzm != null) {
            if (this.hxB == 3) {
                this.hzm.start();
                return;
            }
            this.hzm.stop();
            this.hzm.selectDrawable(0);
        }
    }

    public void CD(String str) {
        this.hyJ = str;
    }

    public void CE(String str) {
        this.hyK = str;
    }

    public View bUk() {
        return this.dGm;
    }

    public View getBackButton() {
        return this.dGn;
    }

    public View bUt() {
        return this.hze;
    }

    public View bUu() {
        return this.hzi;
    }

    public int bTh() {
        return this.hxB;
    }

    public void b(a.b bVar) {
        this.hza = bVar;
    }

    public void c(a.b bVar) {
        this.hyZ = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hzd.getPageContext().getPageActivity());
        aVar.fH(false);
        aVar.jW(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hza != null) {
                    n.this.hza.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.hyZ != null) {
                    n.this.hyZ.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hzd.getPageContext());
        aVar.aEG();
    }

    public void onChangeSkinType(int i) {
        this.hzd.getLayoutMode().setNightMode(i == 1);
        this.hzd.getLayoutMode().onModeChanged(this.mParent);
        am.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        am.setBackgroundColor(this.mParent, R.color.common_color_10041);
        am.setViewTextColor(this.dGm, R.color.cp_cont_f, 1);
    }
}
