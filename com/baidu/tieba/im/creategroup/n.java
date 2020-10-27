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
    private TextView frQ;
    private View frR;
    private int jUf;
    private a.b jVD;
    private a.b jVE;
    private GroupAddressLocateActivity jVH;
    private View jVI;
    private TextView jVJ;
    private ImageView jVK;
    private TextView jVL;
    private View jVM;
    private TextView jVN;
    private ImageView jVO;
    private BdListView jVP;
    private AnimationDrawable jVQ;
    private SettingTextSwitchView jVR;
    private m jVS;
    private com.baidu.tieba.im.util.b jVf;
    private String jVn;
    private String jVo;
    private boolean jVr;
    private String jVy;
    private String jVz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity.getPageContext());
        this.jUf = 3;
        this.mNavigationBar = null;
        this.mParent = null;
        this.jVH = null;
        this.frQ = null;
        this.frR = null;
        this.jVI = null;
        this.jVJ = null;
        this.jVK = null;
        this.jVL = null;
        this.jVM = null;
        this.jVN = null;
        this.jVO = null;
        this.jVP = null;
        this.jVQ = null;
        this.jVR = null;
        this.jVy = "";
        this.jVz = "";
        this.jVr = false;
        this.jVS = null;
        this.jVf = null;
        this.jVn = "";
        this.jVo = "";
        this.jVE = null;
        this.jVD = null;
        this.jVy = str;
        this.jVz = str2;
        this.jVr = z;
        b(groupAddressLocateActivity);
        c(groupAddressLocateActivity);
        initData();
    }

    public void cNN() {
        this.jVf.startLoad();
    }

    public void cNO() {
        if (this.jVf != null) {
            this.jVf.cancelLoad();
            this.jVf = null;
        }
    }

    public void cOd() {
        this.jVK.setVisibility(8);
    }

    public void cOe() {
        this.jVK.setVisibility(0);
    }

    public void cOa() {
        if (this.jVS != null) {
            this.jVS.notifyDataSetChanged();
        }
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.jVH = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.mParent = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.jVJ = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.jVI = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.jVI.setOnClickListener(this.jVH);
        this.jVK = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.jVy)) {
            stringBuffer.append(this.jVy);
        }
        if (!TextUtils.isEmpty(this.jVz)) {
            stringBuffer.append(this.jVz);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.jVI.setVisibility(0);
            this.jVJ.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.jVI.setVisibility(8);
            this.jVJ.setVisibility(8);
        }
        this.jVM = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.jVM.setOnClickListener(this.jVH);
        this.jVN = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.jVO = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.jVO.setVisibility(8);
        this.jVL = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.jVP = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.jVP.setOnItemClickListener(this.jVH);
        this.jVR = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.jVr) {
            this.jVR.turnOn();
        } else {
            this.jVR.turnOff();
        }
        this.jVR.setSwitchStateChangeListener(this.jVH);
        this.mNavigationBar = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.mNavigationBar.setSystemClickable(false);
        this.frR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.frQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void c(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.frR.setOnClickListener(groupAddressLocateActivity);
        this.frQ.setOnClickListener(groupAddressLocateActivity);
    }

    private void initData() {
        this.jVf = new com.baidu.tieba.im.util.b(this.jVH);
        this.jVf.setUniqueId(this.jVH.getUniqueId());
        if (!ae.c(this.jVH, RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB)) {
            cNN();
        }
    }

    public void cOf() {
        this.jVL.setText(R.string.address_pos_list);
        this.jVN.setText(R.string.location_loading);
        this.jVO.setVisibility(8);
        this.jUf = 3;
        cOh();
    }

    public void cOg() {
        this.jVL.setText(R.string.address_locate_noaddresslist);
        this.jVN.setText(R.string.address_locate_failed_tryagain);
        this.jVO.setVisibility(0);
        this.jUf = 2;
        cOh();
    }

    public void L(String[] strArr) {
        this.jVM.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.jVL.setText(R.string.address_pos_list);
            this.jVS = new m(this.jVH, strArr);
            this.jVP.setAdapter((ListAdapter) this.jVS);
            this.jVP.setVisibility(0);
        } else {
            this.jVL.setText(R.string.address_locate_noaddresslist);
        }
        cOh();
    }

    public void cMZ() {
        this.jVL.setText(R.string.address_pos_list);
        this.jVN.setText(R.string.address_locate_failed_opengps);
        this.jVO.setVisibility(0);
        this.jUf = 1;
        cOh();
    }

    public void onResume() {
        Drawable[] compoundDrawables = this.jVN.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.jVQ = (AnimationDrawable) compoundDrawables[0];
            cOh();
        }
    }

    private void cOh() {
        if (this.jVQ != null) {
            if (this.jUf == 3) {
                this.jVQ.start();
                return;
            }
            this.jVQ.stop();
            this.jVQ.selectDrawable(0);
        }
    }

    public void LW(String str) {
        this.jVn = str;
    }

    public void LX(String str) {
        this.jVo = str;
    }

    public View cNZ() {
        return this.frQ;
    }

    public View getBackButton() {
        return this.frR;
    }

    public View cOi() {
        return this.jVI;
    }

    public View cOj() {
        return this.jVM;
    }

    public int cMX() {
        return this.jUf;
    }

    public void b(a.b bVar) {
        this.jVE = bVar;
    }

    public void c(a.b bVar) {
        this.jVD = bVar;
    }

    public void PJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jVH.getPageContext().getPageActivity());
        aVar.iM(false);
        aVar.om(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.jVE != null) {
                    n.this.jVE.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.creategroup.n.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (n.this.jVD != null) {
                    n.this.jVD.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jVH.getPageContext());
        aVar.bmC();
    }

    public void onChangeSkinType(int i) {
        this.jVH.getLayoutMode().setNightMode(i == 1);
        this.jVH.getLayoutMode().onModeChanged(this.mParent);
        ap.setFrsPBBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.mContext, i);
        ap.setBackgroundColor(this.mParent, R.color.common_color_10041);
        ap.setViewTextColor(this.frQ, R.color.cp_cont_f, 1);
    }
}
