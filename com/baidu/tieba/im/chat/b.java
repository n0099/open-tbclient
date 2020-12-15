package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private GroupSettingActivity kjF;
    private RelativeLayout kjG;
    private com.baidu.tbadk.core.dialog.b kjH;
    private com.baidu.tbadk.core.dialog.a kjI;
    private SettingTextSwitchView kjJ;
    private SettingTextSwitchView kjK;
    private TbSettingTextTipView kjL;
    private TbSettingTextTipView kjM;
    private TbSettingTextTipView kjN;
    private Button kjO;
    private Button kjP;
    private com.baidu.tbadk.core.dialog.a kjQ;
    private View kjR;
    private b.InterfaceC0586b kju;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0586b interfaceC0586b) {
        this.kju = interfaceC0586b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.kjF = null;
        this.kjG = null;
        this.kjH = null;
        this.kjJ = null;
        this.kjK = null;
        this.kjL = null;
        this.kjM = null;
        this.kjN = null;
        this.kju = null;
        this.kjF = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.kjJ.rY(i);
        this.kjK.rY(i);
        this.kjF.getLayoutMode().setNightMode(i == 1);
        this.kjF.getLayoutMode().onModeChanged(this.kjG);
        this.mNavigationBar.onChangeSkinType(this.kjF.getPageContext(), i);
        ap.setBackgroundResource(this.kjO, R.drawable.big_red_button);
        ap.setBackgroundResource(this.kjP, R.drawable.big_red_button);
    }

    public View cTp() {
        return this.kjR;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kjL.setText(str);
        }
    }

    private void initView() {
        this.kjF.setContentView(R.layout.group_setting_activity);
        this.kjJ = (SettingTextSwitchView) this.kjF.findViewById(R.id.sv_group_msg_notify);
        this.kjK = (SettingTextSwitchView) this.kjF.findViewById(R.id.sv_group_add_group);
        this.kjL = (TbSettingTextTipView) this.kjF.findViewById(R.id.tv_change_name);
        this.kjM = (TbSettingTextTipView) this.kjF.findViewById(R.id.sv_report);
        this.kjN = (TbSettingTextTipView) this.kjF.findViewById(R.id.sv_delete_msg);
        this.kjO = (Button) this.kjF.findViewById(R.id.btn_dismiss);
        this.kjP = (Button) this.kjF.findViewById(R.id.btn_quit);
        this.kjG = (RelativeLayout) this.kjF.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.kjF.findViewById(R.id.view_navigation_bar);
        this.kjR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.kjJ.setSwitchStateChangeListener(this.kjF);
        this.kjK.setSwitchStateChangeListener(this.kjF);
        this.kjL.setOnClickListener(this.kjF);
        this.kjM.setOnClickListener(this.kjF);
        this.kjO.setOnClickListener(this.kjF);
        this.kjP.setOnClickListener(this.kjF);
        this.kjN.setOnClickListener(this.kjF);
    }

    public TbSettingTextTipView cTq() {
        return this.kjL;
    }

    public Button cTr() {
        return this.kjP;
    }

    public Button cTs() {
        return this.kjO;
    }

    public TbSettingTextTipView cTt() {
        return this.kjM;
    }

    public TbSettingTextTipView cTu() {
        return this.kjN;
    }

    public void cTv() {
        if (this.kjI == null) {
            this.kjI = new com.baidu.tbadk.core.dialog.a(this.kjF.getPageContext().getPageActivity());
            this.kjI.oP(R.string.inform);
            this.kjI.oQ(R.string.group_quit_alert);
            this.kjI.jl(false);
            this.kjI.a(R.string.alert_yes_button, this.kjF);
            this.kjI.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kjI.b(this.kjF.getPageContext());
            this.kjI.jm(true);
        }
        this.kjI.brv();
    }

    public com.baidu.tbadk.core.dialog.a cTw() {
        return this.kjI;
    }

    public void cTx() {
        if (this.kjH == null) {
            this.kjH = new com.baidu.tbadk.core.dialog.b(this.kjF.getPageContext().getPageActivity());
            this.kjH.oV(R.string.group_report);
            this.kjH.a(new CharSequence[]{new SpannableString(this.kjF.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.kjF.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.kjF.getPageContext().getString(R.string.group_report_lllegal))}, this.kju);
            this.kjH.d(this.kjF.getPageContext());
        }
        this.kjH.brx();
    }

    public void cTy() {
        if (this.kjP != null) {
            this.kjP.setVisibility(8);
        }
    }

    public void cTz() {
        if (this.kjO != null) {
            this.kjO.setVisibility(8);
        }
    }

    public void rX(boolean z) {
        if (this.kjK != null) {
            this.kjK.setVisibility(z ? 0 : 8);
        }
    }

    public void rY(boolean z) {
        if (z) {
            this.kjK.turnOn();
        } else {
            this.kjK.turnOff();
        }
    }

    public void cTA() {
        if (this.kjP != null) {
            this.kjP.setVisibility(0);
        }
    }

    public void cTB() {
        if (this.kjO != null) {
            this.kjO.setVisibility(0);
        }
    }

    public void cmI() {
        if (this.kjM != null) {
            this.kjM.setVisibility(0);
        }
    }

    public void cTC() {
        if (this.kjM != null) {
            this.kjM.setVisibility(8);
        }
    }

    public BdSwitchView cTD() {
        return this.kjK.getSwitchView();
    }

    public BdSwitchView cTE() {
        return this.kjJ.getSwitchView();
    }

    public void cTF() {
        if (this.kjQ == null) {
            this.kjQ = new com.baidu.tbadk.core.dialog.a(this.kjF.getPageContext().getPageActivity());
            this.kjQ.oQ(R.string.group_dismiss_alert);
            this.kjQ.jl(false);
            this.kjQ.a(R.string.alert_yes_button, this.kjF);
            this.kjQ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kjQ.b(this.kjF.getPageContext());
        }
        this.kjQ.brv();
    }

    public com.baidu.tbadk.core.dialog.a cTG() {
        return this.kjQ;
    }

    public void cTH() {
        if (this.kjQ != null) {
            this.kjQ.dismiss();
            this.kjQ = null;
        }
        if (this.kjH != null) {
            this.kjH.dismiss();
            this.kjH = null;
        }
        if (this.kjI != null) {
            this.kjI.dismiss();
            this.kjI = null;
        }
    }
}
