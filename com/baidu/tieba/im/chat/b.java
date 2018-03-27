package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private GroupSettingActivity evD;
    private com.baidu.tbadk.core.dialog.b evE;
    private com.baidu.tbadk.core.dialog.a evF;
    private SettingTextSwitchView evG;
    private SettingTextSwitchView evH;
    private TbSettingTextTipView evI;
    private TbSettingTextTipView evJ;
    private TbSettingTextTipView evK;
    private Button evL;
    private Button evM;
    private com.baidu.tbadk.core.dialog.a evN;
    private View evO;
    private b.InterfaceC0097b evr;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0097b interfaceC0097b) {
        this.evr = interfaceC0097b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.evD = null;
        this.mParent = null;
        this.evE = null;
        this.evG = null;
        this.evH = null;
        this.evI = null;
        this.evJ = null;
        this.evK = null;
        this.evr = null;
        this.evD = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.evG.hr(i);
        this.evH.hr(i);
        this.evD.getLayoutMode().aQ(i == 1);
        this.evD.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.evD.getPageContext(), i);
        aj.s(this.evL, d.f.big_red_button);
        aj.s(this.evM, d.f.big_red_button);
    }

    public View aFy() {
        return this.evO;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.evI.setText(str);
        }
    }

    private void initView() {
        this.evD.setContentView(d.h.group_setting_activity);
        this.evG = (SettingTextSwitchView) this.evD.findViewById(d.g.sv_group_msg_notify);
        this.evH = (SettingTextSwitchView) this.evD.findViewById(d.g.sv_group_add_group);
        this.evI = (TbSettingTextTipView) this.evD.findViewById(d.g.tv_change_name);
        this.evJ = (TbSettingTextTipView) this.evD.findViewById(d.g.sv_report);
        this.evK = (TbSettingTextTipView) this.evD.findViewById(d.g.sv_delete_msg);
        this.evL = (Button) this.evD.findViewById(d.g.btn_dismiss);
        this.evM = (Button) this.evD.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.evD.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.evD.findViewById(d.g.view_navigation_bar);
        this.evO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.group_setting);
    }

    public void initListener() {
        this.evG.setSwitchStateChangeListener(this.evD);
        this.evH.setSwitchStateChangeListener(this.evD);
        this.evI.setOnClickListener(this.evD);
        this.evJ.setOnClickListener(this.evD);
        this.evL.setOnClickListener(this.evD);
        this.evM.setOnClickListener(this.evD);
        this.evK.setOnClickListener(this.evD);
    }

    public TbSettingTextTipView aFz() {
        return this.evI;
    }

    public Button aFA() {
        return this.evM;
    }

    public Button aFB() {
        return this.evL;
    }

    public TbSettingTextTipView aFC() {
        return this.evJ;
    }

    public TbSettingTextTipView aFD() {
        return this.evK;
    }

    public void aFE() {
        if (this.evF == null) {
            this.evF = new com.baidu.tbadk.core.dialog.a(this.evD.getPageContext().getPageActivity());
            this.evF.fa(d.j.inform);
            this.evF.fb(d.j.group_quit_alert);
            this.evF.aZ(false);
            this.evF.a(d.j.alert_yes_button, this.evD);
            this.evF.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.evF.b(this.evD.getPageContext());
            this.evF.ba(true);
        }
        this.evF.AV();
    }

    public com.baidu.tbadk.core.dialog.a aFF() {
        return this.evF;
    }

    public void Ev() {
        if (this.evE == null) {
            this.evE = new com.baidu.tbadk.core.dialog.b(this.evD.getPageContext().getPageActivity());
            this.evE.fe(d.j.group_report);
            this.evE.a(new CharSequence[]{new SpannableString(this.evD.getPageContext().getString(d.j.group_report_ad)), new SpannableString(this.evD.getPageContext().getString(d.j.group_report_sex)), new SpannableString(this.evD.getPageContext().getString(d.j.group_report_lllegal))}, this.evr);
            this.evE.d(this.evD.getPageContext());
        }
        this.evE.AY();
    }

    public void aFG() {
        if (this.evM != null) {
            this.evM.setVisibility(8);
        }
    }

    public void aFH() {
        if (this.evL != null) {
            this.evL.setVisibility(8);
        }
    }

    public void he(boolean z) {
        if (this.evH != null) {
            this.evH.setVisibility(z ? 0 : 8);
        }
    }

    public void hf(boolean z) {
        if (z) {
            this.evH.rJ();
        } else {
            this.evH.rK();
        }
    }

    public void aFI() {
        if (this.evM != null) {
            this.evM.setVisibility(0);
        }
    }

    public void aFJ() {
        if (this.evL != null) {
            this.evL.setVisibility(0);
        }
    }

    public void ahT() {
        if (this.evJ != null) {
            this.evJ.setVisibility(0);
        }
    }

    public void aFK() {
        if (this.evJ != null) {
            this.evJ.setVisibility(8);
        }
    }

    public BdSwitchView aFL() {
        return this.evH.getSwitchView();
    }

    public BdSwitchView aFM() {
        return this.evG.getSwitchView();
    }

    public void aFN() {
        if (this.evN == null) {
            this.evN = new com.baidu.tbadk.core.dialog.a(this.evD.getPageContext().getPageActivity());
            this.evN.fb(d.j.group_dismiss_alert);
            this.evN.aZ(false);
            this.evN.a(d.j.alert_yes_button, this.evD);
            this.evN.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.evN.b(this.evD.getPageContext());
        }
        this.evN.AV();
    }

    public com.baidu.tbadk.core.dialog.a aFO() {
        return this.evN;
    }

    public void aFP() {
        if (this.evN != null) {
            this.evN.dismiss();
            this.evN = null;
        }
        if (this.evE != null) {
            this.evE.dismiss();
            this.evE = null;
        }
        if (this.evF != null) {
            this.evF.dismiss();
            this.evF = null;
        }
    }
}
