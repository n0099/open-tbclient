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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private com.baidu.tbadk.core.dialog.b eHA;
    private com.baidu.tbadk.core.dialog.a eHB;
    private SettingTextSwitchView eHC;
    private SettingTextSwitchView eHD;
    private TbSettingTextTipView eHE;
    private TbSettingTextTipView eHF;
    private TbSettingTextTipView eHG;
    private Button eHH;
    private Button eHI;
    private com.baidu.tbadk.core.dialog.a eHJ;
    private View eHK;
    private b.InterfaceC0158b eHn;
    private GroupSettingActivity eHz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0158b interfaceC0158b) {
        this.eHn = interfaceC0158b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.eHz = null;
        this.mParent = null;
        this.eHA = null;
        this.eHC = null;
        this.eHD = null;
        this.eHE = null;
        this.eHF = null;
        this.eHG = null;
        this.eHn = null;
        this.eHz = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.eHC.fu(i);
        this.eHD.fu(i);
        this.eHz.getLayoutMode().setNightMode(i == 1);
        this.eHz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eHz.getPageContext(), i);
        al.i(this.eHH, e.f.big_red_button);
        al.i(this.eHI, e.f.big_red_button);
    }

    public View aNR() {
        return this.eHK;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eHE.setText(str);
        }
    }

    private void initView() {
        this.eHz.setContentView(e.h.group_setting_activity);
        this.eHC = (SettingTextSwitchView) this.eHz.findViewById(e.g.sv_group_msg_notify);
        this.eHD = (SettingTextSwitchView) this.eHz.findViewById(e.g.sv_group_add_group);
        this.eHE = (TbSettingTextTipView) this.eHz.findViewById(e.g.tv_change_name);
        this.eHF = (TbSettingTextTipView) this.eHz.findViewById(e.g.sv_report);
        this.eHG = (TbSettingTextTipView) this.eHz.findViewById(e.g.sv_delete_msg);
        this.eHH = (Button) this.eHz.findViewById(e.g.btn_dismiss);
        this.eHI = (Button) this.eHz.findViewById(e.g.btn_quit);
        this.mParent = (RelativeLayout) this.eHz.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eHz.findViewById(e.g.view_navigation_bar);
        this.eHK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.group_setting);
    }

    public void initListener() {
        this.eHC.setSwitchStateChangeListener(this.eHz);
        this.eHD.setSwitchStateChangeListener(this.eHz);
        this.eHE.setOnClickListener(this.eHz);
        this.eHF.setOnClickListener(this.eHz);
        this.eHH.setOnClickListener(this.eHz);
        this.eHI.setOnClickListener(this.eHz);
        this.eHG.setOnClickListener(this.eHz);
    }

    public TbSettingTextTipView aNS() {
        return this.eHE;
    }

    public Button aNT() {
        return this.eHI;
    }

    public Button aNU() {
        return this.eHH;
    }

    public TbSettingTextTipView aNV() {
        return this.eHF;
    }

    public TbSettingTextTipView aNW() {
        return this.eHG;
    }

    public void aNX() {
        if (this.eHB == null) {
            this.eHB = new com.baidu.tbadk.core.dialog.a(this.eHz.getPageContext().getPageActivity());
            this.eHB.da(e.j.inform);
            this.eHB.db(e.j.group_quit_alert);
            this.eHB.bf(false);
            this.eHB.a(e.j.alert_yes_button, this.eHz);
            this.eHB.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eHB.b(this.eHz.getPageContext());
            this.eHB.bg(true);
        }
        this.eHB.BF();
    }

    public com.baidu.tbadk.core.dialog.a aNY() {
        return this.eHB;
    }

    public void Fr() {
        if (this.eHA == null) {
            this.eHA = new com.baidu.tbadk.core.dialog.b(this.eHz.getPageContext().getPageActivity());
            this.eHA.de(e.j.group_report);
            this.eHA.a(new CharSequence[]{new SpannableString(this.eHz.getPageContext().getString(e.j.group_report_ad)), new SpannableString(this.eHz.getPageContext().getString(e.j.group_report_sex)), new SpannableString(this.eHz.getPageContext().getString(e.j.group_report_lllegal))}, this.eHn);
            this.eHA.d(this.eHz.getPageContext());
        }
        this.eHA.BI();
    }

    public void aNZ() {
        if (this.eHI != null) {
            this.eHI.setVisibility(8);
        }
    }

    public void aOa() {
        if (this.eHH != null) {
            this.eHH.setVisibility(8);
        }
    }

    public void ia(boolean z) {
        if (this.eHD != null) {
            this.eHD.setVisibility(z ? 0 : 8);
        }
    }

    public void ib(boolean z) {
        if (z) {
            this.eHD.nR();
        } else {
            this.eHD.nS();
        }
    }

    public void aOb() {
        if (this.eHI != null) {
            this.eHI.setVisibility(0);
        }
    }

    public void aOc() {
        if (this.eHH != null) {
            this.eHH.setVisibility(0);
        }
    }

    public void amA() {
        if (this.eHF != null) {
            this.eHF.setVisibility(0);
        }
    }

    public void aOd() {
        if (this.eHF != null) {
            this.eHF.setVisibility(8);
        }
    }

    public BdSwitchView aOe() {
        return this.eHD.getSwitchView();
    }

    public BdSwitchView aOf() {
        return this.eHC.getSwitchView();
    }

    public void aOg() {
        if (this.eHJ == null) {
            this.eHJ = new com.baidu.tbadk.core.dialog.a(this.eHz.getPageContext().getPageActivity());
            this.eHJ.db(e.j.group_dismiss_alert);
            this.eHJ.bf(false);
            this.eHJ.a(e.j.alert_yes_button, this.eHz);
            this.eHJ.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eHJ.b(this.eHz.getPageContext());
        }
        this.eHJ.BF();
    }

    public com.baidu.tbadk.core.dialog.a aOh() {
        return this.eHJ;
    }

    public void aOi() {
        if (this.eHJ != null) {
            this.eHJ.dismiss();
            this.eHJ = null;
        }
        if (this.eHA != null) {
            this.eHA.dismiss();
            this.eHA = null;
        }
        if (this.eHB != null) {
            this.eHB.dismiss();
            this.eHB = null;
        }
    }
}
