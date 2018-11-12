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
    private GroupSettingActivity eAK;
    private com.baidu.tbadk.core.dialog.b eAL;
    private com.baidu.tbadk.core.dialog.a eAM;
    private SettingTextSwitchView eAN;
    private SettingTextSwitchView eAO;
    private TbSettingTextTipView eAP;
    private TbSettingTextTipView eAQ;
    private TbSettingTextTipView eAR;
    private Button eAS;
    private Button eAT;
    private com.baidu.tbadk.core.dialog.a eAU;
    private View eAV;
    private b.InterfaceC0148b eAy;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0148b interfaceC0148b) {
        this.eAy = interfaceC0148b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.eAK = null;
        this.mParent = null;
        this.eAL = null;
        this.eAN = null;
        this.eAO = null;
        this.eAP = null;
        this.eAQ = null;
        this.eAR = null;
        this.eAy = null;
        this.eAK = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.eAN.fg(i);
        this.eAO.fg(i);
        this.eAK.getLayoutMode().setNightMode(i == 1);
        this.eAK.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eAK.getPageContext(), i);
        al.i(this.eAS, e.f.big_red_button);
        al.i(this.eAT, e.f.big_red_button);
    }

    public View aMa() {
        return this.eAV;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eAP.setText(str);
        }
    }

    private void initView() {
        this.eAK.setContentView(e.h.group_setting_activity);
        this.eAN = (SettingTextSwitchView) this.eAK.findViewById(e.g.sv_group_msg_notify);
        this.eAO = (SettingTextSwitchView) this.eAK.findViewById(e.g.sv_group_add_group);
        this.eAP = (TbSettingTextTipView) this.eAK.findViewById(e.g.tv_change_name);
        this.eAQ = (TbSettingTextTipView) this.eAK.findViewById(e.g.sv_report);
        this.eAR = (TbSettingTextTipView) this.eAK.findViewById(e.g.sv_delete_msg);
        this.eAS = (Button) this.eAK.findViewById(e.g.btn_dismiss);
        this.eAT = (Button) this.eAK.findViewById(e.g.btn_quit);
        this.mParent = (RelativeLayout) this.eAK.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eAK.findViewById(e.g.view_navigation_bar);
        this.eAV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.group_setting);
    }

    public void initListener() {
        this.eAN.setSwitchStateChangeListener(this.eAK);
        this.eAO.setSwitchStateChangeListener(this.eAK);
        this.eAP.setOnClickListener(this.eAK);
        this.eAQ.setOnClickListener(this.eAK);
        this.eAS.setOnClickListener(this.eAK);
        this.eAT.setOnClickListener(this.eAK);
        this.eAR.setOnClickListener(this.eAK);
    }

    public TbSettingTextTipView aMb() {
        return this.eAP;
    }

    public Button aMc() {
        return this.eAT;
    }

    public Button aMd() {
        return this.eAS;
    }

    public TbSettingTextTipView aMe() {
        return this.eAQ;
    }

    public TbSettingTextTipView aMf() {
        return this.eAR;
    }

    public void aMg() {
        if (this.eAM == null) {
            this.eAM = new com.baidu.tbadk.core.dialog.a(this.eAK.getPageContext().getPageActivity());
            this.eAM.cM(e.j.inform);
            this.eAM.cN(e.j.group_quit_alert);
            this.eAM.be(false);
            this.eAM.a(e.j.alert_yes_button, this.eAK);
            this.eAM.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eAM.b(this.eAK.getPageContext());
            this.eAM.bf(true);
        }
        this.eAM.AB();
    }

    public com.baidu.tbadk.core.dialog.a aMh() {
        return this.eAM;
    }

    public void En() {
        if (this.eAL == null) {
            this.eAL = new com.baidu.tbadk.core.dialog.b(this.eAK.getPageContext().getPageActivity());
            this.eAL.cQ(e.j.group_report);
            this.eAL.a(new CharSequence[]{new SpannableString(this.eAK.getPageContext().getString(e.j.group_report_ad)), new SpannableString(this.eAK.getPageContext().getString(e.j.group_report_sex)), new SpannableString(this.eAK.getPageContext().getString(e.j.group_report_lllegal))}, this.eAy);
            this.eAL.d(this.eAK.getPageContext());
        }
        this.eAL.AE();
    }

    public void aMi() {
        if (this.eAT != null) {
            this.eAT.setVisibility(8);
        }
    }

    public void aMj() {
        if (this.eAS != null) {
            this.eAS.setVisibility(8);
        }
    }

    public void hX(boolean z) {
        if (this.eAO != null) {
            this.eAO.setVisibility(z ? 0 : 8);
        }
    }

    public void hY(boolean z) {
        if (z) {
            this.eAO.nS();
        } else {
            this.eAO.nT();
        }
    }

    public void aMk() {
        if (this.eAT != null) {
            this.eAT.setVisibility(0);
        }
    }

    public void aMl() {
        if (this.eAS != null) {
            this.eAS.setVisibility(0);
        }
    }

    public void alt() {
        if (this.eAQ != null) {
            this.eAQ.setVisibility(0);
        }
    }

    public void aMm() {
        if (this.eAQ != null) {
            this.eAQ.setVisibility(8);
        }
    }

    public BdSwitchView aMn() {
        return this.eAO.getSwitchView();
    }

    public BdSwitchView aMo() {
        return this.eAN.getSwitchView();
    }

    public void aMp() {
        if (this.eAU == null) {
            this.eAU = new com.baidu.tbadk.core.dialog.a(this.eAK.getPageContext().getPageActivity());
            this.eAU.cN(e.j.group_dismiss_alert);
            this.eAU.be(false);
            this.eAU.a(e.j.alert_yes_button, this.eAK);
            this.eAU.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eAU.b(this.eAK.getPageContext());
        }
        this.eAU.AB();
    }

    public com.baidu.tbadk.core.dialog.a aMq() {
        return this.eAU;
    }

    public void aMr() {
        if (this.eAU != null) {
            this.eAU.dismiss();
            this.eAU = null;
        }
        if (this.eAL != null) {
            this.eAL.dismiss();
            this.eAL = null;
        }
        if (this.eAM != null) {
            this.eAM.dismiss();
            this.eAM = null;
        }
    }
}
