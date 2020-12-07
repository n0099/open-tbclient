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
    private GroupSettingActivity kjD;
    private RelativeLayout kjE;
    private com.baidu.tbadk.core.dialog.b kjF;
    private com.baidu.tbadk.core.dialog.a kjG;
    private SettingTextSwitchView kjH;
    private SettingTextSwitchView kjI;
    private TbSettingTextTipView kjJ;
    private TbSettingTextTipView kjK;
    private TbSettingTextTipView kjL;
    private Button kjM;
    private Button kjN;
    private com.baidu.tbadk.core.dialog.a kjO;
    private View kjP;
    private b.InterfaceC0586b kjs;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0586b interfaceC0586b) {
        this.kjs = interfaceC0586b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.kjD = null;
        this.kjE = null;
        this.kjF = null;
        this.kjH = null;
        this.kjI = null;
        this.kjJ = null;
        this.kjK = null;
        this.kjL = null;
        this.kjs = null;
        this.kjD = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.kjH.rY(i);
        this.kjI.rY(i);
        this.kjD.getLayoutMode().setNightMode(i == 1);
        this.kjD.getLayoutMode().onModeChanged(this.kjE);
        this.mNavigationBar.onChangeSkinType(this.kjD.getPageContext(), i);
        ap.setBackgroundResource(this.kjM, R.drawable.big_red_button);
        ap.setBackgroundResource(this.kjN, R.drawable.big_red_button);
    }

    public View cTo() {
        return this.kjP;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kjJ.setText(str);
        }
    }

    private void initView() {
        this.kjD.setContentView(R.layout.group_setting_activity);
        this.kjH = (SettingTextSwitchView) this.kjD.findViewById(R.id.sv_group_msg_notify);
        this.kjI = (SettingTextSwitchView) this.kjD.findViewById(R.id.sv_group_add_group);
        this.kjJ = (TbSettingTextTipView) this.kjD.findViewById(R.id.tv_change_name);
        this.kjK = (TbSettingTextTipView) this.kjD.findViewById(R.id.sv_report);
        this.kjL = (TbSettingTextTipView) this.kjD.findViewById(R.id.sv_delete_msg);
        this.kjM = (Button) this.kjD.findViewById(R.id.btn_dismiss);
        this.kjN = (Button) this.kjD.findViewById(R.id.btn_quit);
        this.kjE = (RelativeLayout) this.kjD.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.kjD.findViewById(R.id.view_navigation_bar);
        this.kjP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.kjH.setSwitchStateChangeListener(this.kjD);
        this.kjI.setSwitchStateChangeListener(this.kjD);
        this.kjJ.setOnClickListener(this.kjD);
        this.kjK.setOnClickListener(this.kjD);
        this.kjM.setOnClickListener(this.kjD);
        this.kjN.setOnClickListener(this.kjD);
        this.kjL.setOnClickListener(this.kjD);
    }

    public TbSettingTextTipView cTp() {
        return this.kjJ;
    }

    public Button cTq() {
        return this.kjN;
    }

    public Button cTr() {
        return this.kjM;
    }

    public TbSettingTextTipView cTs() {
        return this.kjK;
    }

    public TbSettingTextTipView cTt() {
        return this.kjL;
    }

    public void cTu() {
        if (this.kjG == null) {
            this.kjG = new com.baidu.tbadk.core.dialog.a(this.kjD.getPageContext().getPageActivity());
            this.kjG.oP(R.string.inform);
            this.kjG.oQ(R.string.group_quit_alert);
            this.kjG.jl(false);
            this.kjG.a(R.string.alert_yes_button, this.kjD);
            this.kjG.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kjG.b(this.kjD.getPageContext());
            this.kjG.jm(true);
        }
        this.kjG.brv();
    }

    public com.baidu.tbadk.core.dialog.a cTv() {
        return this.kjG;
    }

    public void cTw() {
        if (this.kjF == null) {
            this.kjF = new com.baidu.tbadk.core.dialog.b(this.kjD.getPageContext().getPageActivity());
            this.kjF.oV(R.string.group_report);
            this.kjF.a(new CharSequence[]{new SpannableString(this.kjD.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.kjD.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.kjD.getPageContext().getString(R.string.group_report_lllegal))}, this.kjs);
            this.kjF.d(this.kjD.getPageContext());
        }
        this.kjF.brx();
    }

    public void cTx() {
        if (this.kjN != null) {
            this.kjN.setVisibility(8);
        }
    }

    public void cTy() {
        if (this.kjM != null) {
            this.kjM.setVisibility(8);
        }
    }

    public void rX(boolean z) {
        if (this.kjI != null) {
            this.kjI.setVisibility(z ? 0 : 8);
        }
    }

    public void rY(boolean z) {
        if (z) {
            this.kjI.turnOn();
        } else {
            this.kjI.turnOff();
        }
    }

    public void cTz() {
        if (this.kjN != null) {
            this.kjN.setVisibility(0);
        }
    }

    public void cTA() {
        if (this.kjM != null) {
            this.kjM.setVisibility(0);
        }
    }

    public void cmH() {
        if (this.kjK != null) {
            this.kjK.setVisibility(0);
        }
    }

    public void cTB() {
        if (this.kjK != null) {
            this.kjK.setVisibility(8);
        }
    }

    public BdSwitchView cTC() {
        return this.kjI.getSwitchView();
    }

    public BdSwitchView cTD() {
        return this.kjH.getSwitchView();
    }

    public void cTE() {
        if (this.kjO == null) {
            this.kjO = new com.baidu.tbadk.core.dialog.a(this.kjD.getPageContext().getPageActivity());
            this.kjO.oQ(R.string.group_dismiss_alert);
            this.kjO.jl(false);
            this.kjO.a(R.string.alert_yes_button, this.kjD);
            this.kjO.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kjO.b(this.kjD.getPageContext());
        }
        this.kjO.brv();
    }

    public com.baidu.tbadk.core.dialog.a cTF() {
        return this.kjO;
    }

    public void cTG() {
        if (this.kjO != null) {
            this.kjO.dismiss();
            this.kjO = null;
        }
        if (this.kjF != null) {
            this.kjF.dismiss();
            this.kjF = null;
        }
        if (this.kjG != null) {
            this.kjG.dismiss();
            this.kjG = null;
        }
    }
}
