package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private GroupSettingActivity htK;
    private RelativeLayout htL;
    private com.baidu.tbadk.core.dialog.b htM;
    private com.baidu.tbadk.core.dialog.a htN;
    private SettingTextSwitchView htO;
    private SettingTextSwitchView htP;
    private TbSettingTextTipView htQ;
    private TbSettingTextTipView htR;
    private TbSettingTextTipView htS;
    private Button htT;
    private Button htU;
    private com.baidu.tbadk.core.dialog.a htV;
    private View htW;
    private b.a htz;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.htz = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.htK = null;
        this.htL = null;
        this.htM = null;
        this.htO = null;
        this.htP = null;
        this.htQ = null;
        this.htR = null;
        this.htS = null;
        this.htz = null;
        this.htK = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.htO.mg(i);
        this.htP.mg(i);
        this.htK.getLayoutMode().setNightMode(i == 1);
        this.htK.getLayoutMode().onModeChanged(this.htL);
        this.mNavigationBar.onChangeSkinType(this.htK.getPageContext(), i);
        am.setBackgroundResource(this.htT, R.drawable.big_red_button);
        am.setBackgroundResource(this.htU, R.drawable.big_red_button);
    }

    public View bSi() {
        return this.htW;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.htQ.setText(str);
        }
    }

    private void initView() {
        this.htK.setContentView(R.layout.group_setting_activity);
        this.htO = (SettingTextSwitchView) this.htK.findViewById(R.id.sv_group_msg_notify);
        this.htP = (SettingTextSwitchView) this.htK.findViewById(R.id.sv_group_add_group);
        this.htQ = (TbSettingTextTipView) this.htK.findViewById(R.id.tv_change_name);
        this.htR = (TbSettingTextTipView) this.htK.findViewById(R.id.sv_report);
        this.htS = (TbSettingTextTipView) this.htK.findViewById(R.id.sv_delete_msg);
        this.htT = (Button) this.htK.findViewById(R.id.btn_dismiss);
        this.htU = (Button) this.htK.findViewById(R.id.btn_quit);
        this.htL = (RelativeLayout) this.htK.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.htK.findViewById(R.id.view_navigation_bar);
        this.htW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.htO.setSwitchStateChangeListener(this.htK);
        this.htP.setSwitchStateChangeListener(this.htK);
        this.htQ.setOnClickListener(this.htK);
        this.htR.setOnClickListener(this.htK);
        this.htT.setOnClickListener(this.htK);
        this.htU.setOnClickListener(this.htK);
        this.htS.setOnClickListener(this.htK);
    }

    public TbSettingTextTipView bSj() {
        return this.htQ;
    }

    public Button bSk() {
        return this.htU;
    }

    public Button bSl() {
        return this.htT;
    }

    public TbSettingTextTipView bSm() {
        return this.htR;
    }

    public TbSettingTextTipView bSn() {
        return this.htS;
    }

    public void bSo() {
        if (this.htN == null) {
            this.htN = new com.baidu.tbadk.core.dialog.a(this.htK.getPageContext().getPageActivity());
            this.htN.jV(R.string.inform);
            this.htN.jW(R.string.group_quit_alert);
            this.htN.fH(false);
            this.htN.a(R.string.alert_yes_button, this.htK);
            this.htN.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.htN.b(this.htK.getPageContext());
            this.htN.fI(true);
        }
        this.htN.aEG();
    }

    public com.baidu.tbadk.core.dialog.a bSp() {
        return this.htN;
    }

    public void bSq() {
        if (this.htM == null) {
            this.htM = new com.baidu.tbadk.core.dialog.b(this.htK.getPageContext().getPageActivity());
            this.htM.ka(R.string.group_report);
            this.htM.a(new CharSequence[]{new SpannableString(this.htK.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.htK.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.htK.getPageContext().getString(R.string.group_report_lllegal))}, this.htz);
            this.htM.d(this.htK.getPageContext());
        }
        this.htM.aEH();
    }

    public void bSr() {
        if (this.htU != null) {
            this.htU.setVisibility(8);
        }
    }

    public void bSs() {
        if (this.htT != null) {
            this.htT.setVisibility(8);
        }
    }

    public void ng(boolean z) {
        if (this.htP != null) {
            this.htP.setVisibility(z ? 0 : 8);
        }
    }

    public void nh(boolean z) {
        if (z) {
            this.htP.turnOn();
        } else {
            this.htP.turnOff();
        }
    }

    public void bSt() {
        if (this.htU != null) {
            this.htU.setVisibility(0);
        }
    }

    public void bSu() {
        if (this.htT != null) {
            this.htT.setVisibility(0);
        }
    }

    public void bsj() {
        if (this.htR != null) {
            this.htR.setVisibility(0);
        }
    }

    public void bSv() {
        if (this.htR != null) {
            this.htR.setVisibility(8);
        }
    }

    public BdSwitchView bSw() {
        return this.htP.getSwitchView();
    }

    public BdSwitchView bSx() {
        return this.htO.getSwitchView();
    }

    public void bSy() {
        if (this.htV == null) {
            this.htV = new com.baidu.tbadk.core.dialog.a(this.htK.getPageContext().getPageActivity());
            this.htV.jW(R.string.group_dismiss_alert);
            this.htV.fH(false);
            this.htV.a(R.string.alert_yes_button, this.htK);
            this.htV.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.htV.b(this.htK.getPageContext());
        }
        this.htV.aEG();
    }

    public com.baidu.tbadk.core.dialog.a bSz() {
        return this.htV;
    }

    public void bSA() {
        if (this.htV != null) {
            this.htV.dismiss();
            this.htV = null;
        }
        if (this.htM != null) {
            this.htM.dismiss();
            this.htM = null;
        }
        if (this.htN != null) {
            this.htN.dismiss();
            this.htN = null;
        }
    }
}
