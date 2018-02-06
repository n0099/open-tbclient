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
    private com.baidu.tbadk.core.dialog.b evA;
    private com.baidu.tbadk.core.dialog.a evB;
    private SettingTextSwitchView evC;
    private SettingTextSwitchView evD;
    private TbSettingTextTipView evE;
    private TbSettingTextTipView evF;
    private TbSettingTextTipView evG;
    private Button evH;
    private Button evI;
    private com.baidu.tbadk.core.dialog.a evJ;
    private View evK;
    private b.InterfaceC0096b evn;
    private GroupSettingActivity evz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0096b interfaceC0096b) {
        this.evn = interfaceC0096b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.evz = null;
        this.mParent = null;
        this.evA = null;
        this.evC = null;
        this.evD = null;
        this.evE = null;
        this.evF = null;
        this.evG = null;
        this.evn = null;
        this.evz = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.evC.hr(i);
        this.evD.hr(i);
        this.evz.getLayoutMode().aQ(i == 1);
        this.evz.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.evz.getPageContext(), i);
        aj.s(this.evH, d.f.big_red_button);
        aj.s(this.evI, d.f.big_red_button);
    }

    public View aFy() {
        return this.evK;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.evE.setText(str);
        }
    }

    private void initView() {
        this.evz.setContentView(d.h.group_setting_activity);
        this.evC = (SettingTextSwitchView) this.evz.findViewById(d.g.sv_group_msg_notify);
        this.evD = (SettingTextSwitchView) this.evz.findViewById(d.g.sv_group_add_group);
        this.evE = (TbSettingTextTipView) this.evz.findViewById(d.g.tv_change_name);
        this.evF = (TbSettingTextTipView) this.evz.findViewById(d.g.sv_report);
        this.evG = (TbSettingTextTipView) this.evz.findViewById(d.g.sv_delete_msg);
        this.evH = (Button) this.evz.findViewById(d.g.btn_dismiss);
        this.evI = (Button) this.evz.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.evz.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.evz.findViewById(d.g.view_navigation_bar);
        this.evK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.group_setting);
    }

    public void initListener() {
        this.evC.setSwitchStateChangeListener(this.evz);
        this.evD.setSwitchStateChangeListener(this.evz);
        this.evE.setOnClickListener(this.evz);
        this.evF.setOnClickListener(this.evz);
        this.evH.setOnClickListener(this.evz);
        this.evI.setOnClickListener(this.evz);
        this.evG.setOnClickListener(this.evz);
    }

    public TbSettingTextTipView aFz() {
        return this.evE;
    }

    public Button aFA() {
        return this.evI;
    }

    public Button aFB() {
        return this.evH;
    }

    public TbSettingTextTipView aFC() {
        return this.evF;
    }

    public TbSettingTextTipView aFD() {
        return this.evG;
    }

    public void aFE() {
        if (this.evB == null) {
            this.evB = new com.baidu.tbadk.core.dialog.a(this.evz.getPageContext().getPageActivity());
            this.evB.fa(d.j.inform);
            this.evB.fb(d.j.group_quit_alert);
            this.evB.aZ(false);
            this.evB.a(d.j.alert_yes_button, this.evz);
            this.evB.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.evB.b(this.evz.getPageContext());
            this.evB.ba(true);
        }
        this.evB.AU();
    }

    public com.baidu.tbadk.core.dialog.a aFF() {
        return this.evB;
    }

    public void Ev() {
        if (this.evA == null) {
            this.evA = new com.baidu.tbadk.core.dialog.b(this.evz.getPageContext().getPageActivity());
            this.evA.fe(d.j.group_report);
            this.evA.a(new CharSequence[]{new SpannableString(this.evz.getPageContext().getString(d.j.group_report_ad)), new SpannableString(this.evz.getPageContext().getString(d.j.group_report_sex)), new SpannableString(this.evz.getPageContext().getString(d.j.group_report_lllegal))}, this.evn);
            this.evA.d(this.evz.getPageContext());
        }
        this.evA.AX();
    }

    public void aFG() {
        if (this.evI != null) {
            this.evI.setVisibility(8);
        }
    }

    public void aFH() {
        if (this.evH != null) {
            this.evH.setVisibility(8);
        }
    }

    public void gZ(boolean z) {
        if (this.evD != null) {
            this.evD.setVisibility(z ? 0 : 8);
        }
    }

    public void ha(boolean z) {
        if (z) {
            this.evD.rJ();
        } else {
            this.evD.rK();
        }
    }

    public void aFI() {
        if (this.evI != null) {
            this.evI.setVisibility(0);
        }
    }

    public void aFJ() {
        if (this.evH != null) {
            this.evH.setVisibility(0);
        }
    }

    public void ahT() {
        if (this.evF != null) {
            this.evF.setVisibility(0);
        }
    }

    public void aFK() {
        if (this.evF != null) {
            this.evF.setVisibility(8);
        }
    }

    public BdSwitchView aFL() {
        return this.evD.getSwitchView();
    }

    public BdSwitchView aFM() {
        return this.evC.getSwitchView();
    }

    public void aFN() {
        if (this.evJ == null) {
            this.evJ = new com.baidu.tbadk.core.dialog.a(this.evz.getPageContext().getPageActivity());
            this.evJ.fb(d.j.group_dismiss_alert);
            this.evJ.aZ(false);
            this.evJ.a(d.j.alert_yes_button, this.evz);
            this.evJ.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.evJ.b(this.evz.getPageContext());
        }
        this.evJ.AU();
    }

    public com.baidu.tbadk.core.dialog.a aFO() {
        return this.evJ;
    }

    public void aFP() {
        if (this.evJ != null) {
            this.evJ.dismiss();
            this.evJ = null;
        }
        if (this.evA != null) {
            this.evA.dismiss();
            this.evA = null;
        }
        if (this.evB != null) {
            this.evB.dismiss();
            this.evB = null;
        }
    }
}
