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
/* loaded from: classes23.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView fjr;
    private View fjs;
    private int jHG;
    private com.baidu.tieba.im.util.b jIG;
    private String jIO;
    private String jIP;
    private boolean jIS;
    private String jIZ;
    private String jJa;
    private a.b jJe;
    private a.b jJf;
    private GroupAddressLocateActivity jJi;
    private View jJj;
    private TextView jJk;
    private ImageView jJl;
    private TextView jJm;
    private View jJn;
    private TextView jJo;
    private ImageView jJp;
    private BdListView jJq;
    private AnimationDrawable jJr;
    private SettingTextSwitchView jJs;
    private m jJt;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.jHG = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.jJi = null;
        this.fjr = null;
        this.fjs = null;
        this.jJj = null;
        this.jJk = null;
        this.jJl = null;
        this.jJm = null;
        this.jJn = null;
        this.jJo = null;
        this.jJp = null;
        this.jJq = null;
        this.jJr = null;
        this.jJs = null;
        this.jIZ = "";
        this.jJa = "";
        this.jIS = false;
        this.jJt = null;
        this.jIG = null;
        this.jIO = "";
        this.jIP = "";
        this.jJf = null;
        this.jJe = null;
        this.jIZ = str;
        this.jJa = str2;
        this.jIS = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cKG() {
        this.jIG.startLoad();
    }

    public void cKH() {
        if (this.jIG != null) {
            this.jIG.cancelLoad();
            this.jIG = null;
        }
    }

    public void cKW() {
        this.jJl.setVisibility(8);
    }

    public void cKX() {
        this.jJl.setVisibility(0);
    }

    public void cKT() {
        if (this.jJt != null) {
            this.jJt.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.jJi = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.jJk = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.jJj = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.jJj.setOnClickListener(this.jJi);
        this.jJl = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.jIZ)) {
            stringBuffer.append(this.jIZ);
        }
        if (!TextUtils.isEmpty(this.jJa)) {
            stringBuffer.append(this.jJa);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.jJj.setVisibility(0);
            this.jJk.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.jJj.setVisibility(8);
            this.jJk.setVisibility(8);
        }
        this.jJn = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.jJn.setOnClickListener(this.jJi);
        this.jJo = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.jJp = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.jJp.setVisibility(8);
        this.jJm = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.jJq = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.jJq.setOnItemClickListener(this.jJi);
        this.jJs = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.jIS) {
            this.jJs.turnOn();
        } else {
            this.jJs.turnOff();
        }
        this.jJs.setSwitchStateChangeListener(this.jJi);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.fjs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fjr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.fjs.setOnClickListener(groupAddressLocateActivity);
        this.fjr.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.jIG = new com.baidu.tieba.im.util.b(this.jJi);
        this.jIG.setUniqueId(this.jJi.getUniqueId());
        if (!ae.c(this.jJi, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cKG();
        }
    }

    public void cKY() {
        this.jJm.setText(R.string.address_pos_list);
        this.jJo.setText(R.string.location_loading);
        this.jJp.setVisibility(8);
        this.jHG = 3;
        cLa();
    }

    public void cKZ() {
        this.jJm.setText(R.string.address_locate_noaddresslist);
        this.jJo.setText(R.string.address_locate_failed_tryagain);
        this.jJp.setVisibility(0);
        this.jHG = 2;
        cLa();
    }

    public void K(String[] strArr) {
        this.jJn.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.jJm.setText(R.string.address_pos_list);
            this.jJt = new m(this.jJi, strArr);
            this.jJq.setAdapter((ListAdapter) this.jJt);
            this.jJq.setVisibility(0);
        } else {
            this.jJm.setText(R.string.address_locate_noaddresslist);
        }
        cLa();
    }

    public void cJS() {
        this.jJm.setText(R.string.address_pos_list);
        this.jJo.setText(R.string.address_locate_failed_opengps);
        this.jJp.setVisibility(0);
        this.jHG = 1;
        cLa();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.jJo.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.jJr = (AnimationDrawable) compoundDrawables[0];
            cLa();
        }
    }

    private void cLa() {
        if (this.jJr != null) {
            if (this.jHG == 3) {
                this.jJr.start();
                return;
            }
            this.jJr.stop();
            this.jJr.selectDrawable(0);
        }
    }

    public void Ly(String str) {
        this.jIO = str;
    }

    public void Lz(String str) {
        this.jIP = str;
    }

    public View cKS() {
        return this.fjr;
    }

    public View getBackButton() {
        return this.fjs;
    }

    public View cLb() {
        return this.jJj;
    }

    public View cLc() {
        return this.jJn;
    }

    public int cJQ() {
        return this.jHG;
    }

    public void b(a.b bVar) {
        this.jJf = bVar;
    }

    public void c(a.b bVar) {
        this.jJe = bVar;
    }

    public void Pd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jJi.getPageContext().getPageActivity());
        aVar.iz(false);
        aVar.ob(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.jJf != null) {
                    n.this.jJf.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.jJe != null) {
                    n.this.jJe.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jJi.getPageContext());
        aVar.bkJ();
    }

    public void onChangeSkinType(int i) {
        this.jJi.getLayoutMode().setNightMode(i == 1);
        this.jJi.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.fjr, R.color.cp_cont_f, 1);
    }
}
