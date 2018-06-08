package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private GroupSettingActivity ecA;
    private com.baidu.tbadk.core.dialog.b ecB;
    private com.baidu.tbadk.core.dialog.a ecC;
    private SettingTextSwitchView ecD;
    private SettingTextSwitchView ecE;
    private TbSettingTextTipView ecF;
    private TbSettingTextTipView ecG;
    private TbSettingTextTipView ecH;
    private Button ecI;
    private Button ecJ;
    private com.baidu.tbadk.core.dialog.a ecK;
    private View ecL;
    private b.InterfaceC0103b eco;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0103b interfaceC0103b) {
        this.eco = interfaceC0103b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.ecA = null;
        this.mParent = null;
        this.ecB = null;
        this.ecD = null;
        this.ecE = null;
        this.ecF = null;
        this.ecG = null;
        this.ecH = null;
        this.eco = null;
        this.ecA = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ecD.eu(i);
        this.ecE.eu(i);
        this.ecA.getLayoutMode().setNightMode(i == 1);
        this.ecA.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ecA.getPageContext(), i);
        al.i(this.ecI, d.f.big_red_button);
        al.i(this.ecJ, d.f.big_red_button);
    }

    public View aFr() {
        return this.ecL;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ecF.setText(str);
        }
    }

    private void initView() {
        this.ecA.setContentView(d.i.group_setting_activity);
        this.ecD = (SettingTextSwitchView) this.ecA.findViewById(d.g.sv_group_msg_notify);
        this.ecE = (SettingTextSwitchView) this.ecA.findViewById(d.g.sv_group_add_group);
        this.ecF = (TbSettingTextTipView) this.ecA.findViewById(d.g.tv_change_name);
        this.ecG = (TbSettingTextTipView) this.ecA.findViewById(d.g.sv_report);
        this.ecH = (TbSettingTextTipView) this.ecA.findViewById(d.g.sv_delete_msg);
        this.ecI = (Button) this.ecA.findViewById(d.g.btn_dismiss);
        this.ecJ = (Button) this.ecA.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.ecA.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.ecA.findViewById(d.g.view_navigation_bar);
        this.ecL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.group_setting);
    }

    public void initListener() {
        this.ecD.setSwitchStateChangeListener(this.ecA);
        this.ecE.setSwitchStateChangeListener(this.ecA);
        this.ecF.setOnClickListener(this.ecA);
        this.ecG.setOnClickListener(this.ecA);
        this.ecI.setOnClickListener(this.ecA);
        this.ecJ.setOnClickListener(this.ecA);
        this.ecH.setOnClickListener(this.ecA);
    }

    public TbSettingTextTipView aFs() {
        return this.ecF;
    }

    public Button aFt() {
        return this.ecJ;
    }

    public Button aFu() {
        return this.ecI;
    }

    public TbSettingTextTipView aFv() {
        return this.ecG;
    }

    public TbSettingTextTipView aFw() {
        return this.ecH;
    }

    public void aFx() {
        if (this.ecC == null) {
            this.ecC = new com.baidu.tbadk.core.dialog.a(this.ecA.getPageContext().getPageActivity());
            this.ecC.cb(d.k.inform);
            this.ecC.cc(d.k.group_quit_alert);
            this.ecC.au(false);
            this.ecC.a(d.k.alert_yes_button, this.ecA);
            this.ecC.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ecC.b(this.ecA.getPageContext());
            this.ecC.av(true);
        }
        this.ecC.xa();
    }

    public com.baidu.tbadk.core.dialog.a aFy() {
        return this.ecC;
    }

    public void AG() {
        if (this.ecB == null) {
            this.ecB = new com.baidu.tbadk.core.dialog.b(this.ecA.getPageContext().getPageActivity());
            this.ecB.cf(d.k.group_report);
            this.ecB.a(new CharSequence[]{new SpannableString(this.ecA.getPageContext().getString(d.k.group_report_ad)), new SpannableString(this.ecA.getPageContext().getString(d.k.group_report_sex)), new SpannableString(this.ecA.getPageContext().getString(d.k.group_report_lllegal))}, this.eco);
            this.ecB.d(this.ecA.getPageContext());
        }
        this.ecB.xd();
    }

    public void aFz() {
        if (this.ecJ != null) {
            this.ecJ.setVisibility(8);
        }
    }

    public void aFA() {
        if (this.ecI != null) {
            this.ecI.setVisibility(8);
        }
    }

    public void gL(boolean z) {
        if (this.ecE != null) {
            this.ecE.setVisibility(z ? 0 : 8);
        }
    }

    public void gM(boolean z) {
        if (z) {
            this.ecE.mC();
        } else {
            this.ecE.mD();
        }
    }

    public void aFB() {
        if (this.ecJ != null) {
            this.ecJ.setVisibility(0);
        }
    }

    public void aFC() {
        if (this.ecI != null) {
            this.ecI.setVisibility(0);
        }
    }

    public void afy() {
        if (this.ecG != null) {
            this.ecG.setVisibility(0);
        }
    }

    public void aFD() {
        if (this.ecG != null) {
            this.ecG.setVisibility(8);
        }
    }

    public BdSwitchView aFE() {
        return this.ecE.getSwitchView();
    }

    public BdSwitchView aFF() {
        return this.ecD.getSwitchView();
    }

    public void aFG() {
        if (this.ecK == null) {
            this.ecK = new com.baidu.tbadk.core.dialog.a(this.ecA.getPageContext().getPageActivity());
            this.ecK.cc(d.k.group_dismiss_alert);
            this.ecK.au(false);
            this.ecK.a(d.k.alert_yes_button, this.ecA);
            this.ecK.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ecK.b(this.ecA.getPageContext());
        }
        this.ecK.xa();
    }

    public com.baidu.tbadk.core.dialog.a aFH() {
        return this.ecK;
    }

    public void aFI() {
        if (this.ecK != null) {
            this.ecK.dismiss();
            this.ecK = null;
        }
        if (this.ecB != null) {
            this.ecB.dismiss();
            this.ecB = null;
        }
        if (this.ecC != null) {
            this.ecC.dismiss();
            this.ecC = null;
        }
    }
}
