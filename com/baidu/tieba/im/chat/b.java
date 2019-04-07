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
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.InterfaceC0225b gaG;
    private GroupSettingActivity gaS;
    private com.baidu.tbadk.core.dialog.b gaT;
    private com.baidu.tbadk.core.dialog.a gaU;
    private SettingTextSwitchView gaV;
    private SettingTextSwitchView gaW;
    private TbSettingTextTipView gaX;
    private TbSettingTextTipView gaY;
    private TbSettingTextTipView gaZ;
    private Button gba;
    private Button gbb;
    private com.baidu.tbadk.core.dialog.a gbc;
    private View gbd;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0225b interfaceC0225b) {
        this.gaG = interfaceC0225b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gaS = null;
        this.mParent = null;
        this.gaT = null;
        this.gaV = null;
        this.gaW = null;
        this.gaX = null;
        this.gaY = null;
        this.gaZ = null;
        this.gaG = null;
        this.gaS = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gaV.jf(i);
        this.gaW.jf(i);
        this.gaS.getLayoutMode().setNightMode(i == 1);
        this.gaS.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gaS.getPageContext(), i);
        al.k(this.gba, d.f.big_red_button);
        al.k(this.gbb, d.f.big_red_button);
    }

    public View bpH() {
        return this.gbd;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gaX.setText(str);
        }
    }

    private void initView() {
        this.gaS.setContentView(d.h.group_setting_activity);
        this.gaV = (SettingTextSwitchView) this.gaS.findViewById(d.g.sv_group_msg_notify);
        this.gaW = (SettingTextSwitchView) this.gaS.findViewById(d.g.sv_group_add_group);
        this.gaX = (TbSettingTextTipView) this.gaS.findViewById(d.g.tv_change_name);
        this.gaY = (TbSettingTextTipView) this.gaS.findViewById(d.g.sv_report);
        this.gaZ = (TbSettingTextTipView) this.gaS.findViewById(d.g.sv_delete_msg);
        this.gba = (Button) this.gaS.findViewById(d.g.btn_dismiss);
        this.gbb = (Button) this.gaS.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.gaS.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.gaS.findViewById(d.g.view_navigation_bar);
        this.gbd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.group_setting);
    }

    public void initListener() {
        this.gaV.setSwitchStateChangeListener(this.gaS);
        this.gaW.setSwitchStateChangeListener(this.gaS);
        this.gaX.setOnClickListener(this.gaS);
        this.gaY.setOnClickListener(this.gaS);
        this.gba.setOnClickListener(this.gaS);
        this.gbb.setOnClickListener(this.gaS);
        this.gaZ.setOnClickListener(this.gaS);
    }

    public TbSettingTextTipView bpI() {
        return this.gaX;
    }

    public Button bpJ() {
        return this.gbb;
    }

    public Button bpK() {
        return this.gba;
    }

    public TbSettingTextTipView bpL() {
        return this.gaY;
    }

    public TbSettingTextTipView bpM() {
        return this.gaZ;
    }

    public void bpN() {
        if (this.gaU == null) {
            this.gaU = new com.baidu.tbadk.core.dialog.a(this.gaS.getPageContext().getPageActivity());
            this.gaU.gB(d.j.inform);
            this.gaU.gC(d.j.group_quit_alert);
            this.gaU.dq(false);
            this.gaU.a(d.j.alert_yes_button, this.gaS);
            this.gaU.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gaU.b(this.gaS.getPageContext());
            this.gaU.dr(true);
        }
        this.gaU.aaW();
    }

    public com.baidu.tbadk.core.dialog.a bpO() {
        return this.gaU;
    }

    public void aeW() {
        if (this.gaT == null) {
            this.gaT = new com.baidu.tbadk.core.dialog.b(this.gaS.getPageContext().getPageActivity());
            this.gaT.gF(d.j.group_report);
            this.gaT.a(new CharSequence[]{new SpannableString(this.gaS.getPageContext().getString(d.j.group_report_ad)), new SpannableString(this.gaS.getPageContext().getString(d.j.group_report_sex)), new SpannableString(this.gaS.getPageContext().getString(d.j.group_report_lllegal))}, this.gaG);
            this.gaT.d(this.gaS.getPageContext());
        }
        this.gaT.aaZ();
    }

    public void bpP() {
        if (this.gbb != null) {
            this.gbb.setVisibility(8);
        }
    }

    public void bpQ() {
        if (this.gba != null) {
            this.gba.setVisibility(8);
        }
    }

    public void kD(boolean z) {
        if (this.gaW != null) {
            this.gaW.setVisibility(z ? 0 : 8);
        }
    }

    public void kE(boolean z) {
        if (z) {
            this.gaW.oa();
        } else {
            this.gaW.ob();
        }
    }

    public void bpR() {
        if (this.gbb != null) {
            this.gbb.setVisibility(0);
        }
    }

    public void bpS() {
        if (this.gba != null) {
            this.gba.setVisibility(0);
        }
    }

    public void aOe() {
        if (this.gaY != null) {
            this.gaY.setVisibility(0);
        }
    }

    public void bpT() {
        if (this.gaY != null) {
            this.gaY.setVisibility(8);
        }
    }

    public BdSwitchView bpU() {
        return this.gaW.getSwitchView();
    }

    public BdSwitchView bpV() {
        return this.gaV.getSwitchView();
    }

    public void bpW() {
        if (this.gbc == null) {
            this.gbc = new com.baidu.tbadk.core.dialog.a(this.gaS.getPageContext().getPageActivity());
            this.gbc.gC(d.j.group_dismiss_alert);
            this.gbc.dq(false);
            this.gbc.a(d.j.alert_yes_button, this.gaS);
            this.gbc.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gbc.b(this.gaS.getPageContext());
        }
        this.gbc.aaW();
    }

    public com.baidu.tbadk.core.dialog.a bpX() {
        return this.gbc;
    }

    public void bpY() {
        if (this.gbc != null) {
            this.gbc.dismiss();
            this.gbc = null;
        }
        if (this.gaT != null) {
            this.gaT.dismiss();
            this.gaT = null;
        }
        if (this.gaU != null) {
            this.gaU.dismiss();
            this.gaU = null;
        }
    }
}
