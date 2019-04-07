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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class n extends com.baidu.adp.base.c<GroupAddressLocateActivity> {
    private TextView csC;
    private View csD;
    private int geO;
    private com.baidu.tieba.im.util.b gfO;
    private String gfW;
    private String gfX;
    private SettingTextSwitchView ggA;
    private m ggB;
    private boolean gga;
    private String ggh;
    private String ggi;
    private a.b ggm;
    private a.b ggn;
    private GroupAddressLocateActivity ggq;
    private View ggr;
    private TextView ggs;
    private ImageView ggt;
    private TextView ggu;
    private View ggv;
    private TextView ggw;
    private ImageView ggx;
    private BdListView ggy;
    private AnimationDrawable ggz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.geO = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.ggq = null;
        this.csC = null;
        this.csD = null;
        this.ggr = null;
        this.ggs = null;
        this.ggt = null;
        this.ggu = null;
        this.ggv = null;
        this.ggw = null;
        this.ggx = null;
        this.ggy = null;
        this.ggz = null;
        this.ggA = null;
        this.ggh = "";
        this.ggi = "";
        this.gga = false;
        this.ggB = null;
        this.gfO = null;
        this.gfW = "";
        this.gfX = "";
        this.ggn = null;
        this.ggm = null;
        this.ggh = str;
        this.ggi = str2;
        this.gga = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void brx() {
        this.gfO.arH();
    }

    public void bry() {
        if (this.gfO != null) {
            this.gfO.cancelLoad();
            this.gfO = null;
        }
    }

    public void brN() {
        this.ggt.setVisibility(8);
    }

    public void brO() {
        this.ggt.setVisibility(0);
    }

    public void brK() {
        if (this.ggB != null) {
            this.ggB.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.ggq = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(d.h.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(d.g.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(d.g.address_content_currentpos);
        this.ggs = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_currentpos);
        this.ggr = groupAddressLocateActivity.findViewById(d.g.address_content_container);
        this.ggr.setOnClickListener(this.ggq);
        this.ggt = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.ggh)) {
            stringBuffer.append(this.ggh);
        }
        if (!TextUtils.isEmpty(this.ggi)) {
            stringBuffer.append(this.ggi);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.ggr.setVisibility(0);
            this.ggs.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.ggr.setVisibility(8);
            this.ggs.setVisibility(8);
        }
        this.ggv = groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_layout);
        this.ggv.setOnClickListener(this.ggq);
        this.ggw = (TextView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_textview);
        this.ggx = (ImageView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_locatearea_rightarrow);
        this.ggx.setVisibility(8);
        this.ggu = (TextView) groupAddressLocateActivity.findViewById(d.g.address_title_poslist);
        this.ggy = (BdListView) groupAddressLocateActivity.findViewById(d.g.group_address_locate_addresslist_listview);
        this.ggy.setOnItemClickListener(this.ggq);
        this.ggA = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(d.g.address_showorhidden);
        if (this.gga) {
            this.ggA.oa();
        } else {
            this.ggA.ob();
        }
        this.ggA.setSwitchStateChangeListener(this.ggq);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(d.j.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.csD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(d.j.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.csD.setOnClickListener(groupAddressLocateActivity);
        this.csC.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.gfO = new com.baidu.tieba.im.util.b(this.ggq);
        this.gfO.setUniqueId(this.ggq.getUniqueId());
        brx();
    }

    public void brP() {
        this.ggu.setText(d.j.address_pos_list);
        this.ggw.setText(d.j.location_loading);
        this.ggx.setVisibility(8);
        this.geO = 3;
        brR();
    }

    public void brQ() {
        this.ggu.setText(d.j.address_locate_noaddresslist);
        this.ggw.setText(d.j.address_locate_failed_tryagain);
        this.ggx.setVisibility(0);
        this.geO = 2;
        brR();
    }

    public void y(String[] strArr) {
        this.ggv.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.ggu.setText(d.j.address_pos_list);
            this.ggB = new m(this.ggq, strArr);
            this.ggy.setAdapter((ListAdapter) this.ggB);
            this.ggy.setVisibility(0);
        } else {
            this.ggu.setText(d.j.address_locate_noaddresslist);
        }
        brR();
    }

    public void bqI() {
        this.ggu.setText(d.j.address_pos_list);
        this.ggw.setText(d.j.address_locate_failed_opengps);
        this.ggx.setVisibility(0);
        this.geO = 1;
        brR();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.ggw.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.ggz = (AnimationDrawable) compoundDrawables[0];
            brR();
        }
    }

    private void brR() {
        if (this.ggz != null) {
            if (this.geO == 3) {
                this.ggz.start();
                return;
            }
            this.ggz.stop();
            this.ggz.selectDrawable(0);
        }
    }

    public void wA(String str) {
        this.gfW = str;
    }

    public void wB(String str) {
        this.gfX = str;
    }

    public View brJ() {
        return this.csC;
    }

    public View getBackButton() {
        return this.csD;
    }

    public View brS() {
        return this.ggr;
    }

    public View brT() {
        return this.ggv;
    }

    public int bqG() {
        return this.geO;
    }

    public void b(a.b bVar) {
        this.ggn = bVar;
    }

    public void c(a.b bVar) {
        this.ggm = bVar;
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ggq.getPageContext().getPageActivity());
        aVar.dq(false);
        aVar.gC(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ggn != null) {
                    n.this.ggn.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.ggm != null) {
                    n.this.ggm.onClick(aVar2);
                }
            }
        });
        aVar.b(this.ggq.getPageContext());
        aVar.aaW();
    }

    public void onChangeSkinType(int i) {
        this.ggq.getLayoutMode().setNightMode(i == 1);
        this.ggq.getLayoutMode().onModeChanged(this.mParent);
        al.h(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        al.l(this.mParent, d.C0277d.common_color_10041);
        al.d(this.csC, d.C0277d.cp_cont_f, 1);
    }
}
