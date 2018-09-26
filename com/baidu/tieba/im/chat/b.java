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
    private GroupSettingActivity erA;
    private com.baidu.tbadk.core.dialog.b erB;
    private com.baidu.tbadk.core.dialog.a erC;
    private SettingTextSwitchView erD;
    private SettingTextSwitchView erE;
    private TbSettingTextTipView erF;
    private TbSettingTextTipView erG;
    private TbSettingTextTipView erH;
    private Button erI;
    private Button erJ;
    private com.baidu.tbadk.core.dialog.a erK;
    private View erL;
    private b.InterfaceC0100b ern;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0100b interfaceC0100b) {
        this.ern = interfaceC0100b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.erA = null;
        this.mParent = null;
        this.erB = null;
        this.erD = null;
        this.erE = null;
        this.erF = null;
        this.erG = null;
        this.erH = null;
        this.ern = null;
        this.erA = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.erD.eJ(i);
        this.erE.eJ(i);
        this.erA.getLayoutMode().setNightMode(i == 1);
        this.erA.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.erA.getPageContext(), i);
        al.i(this.erI, e.f.big_red_button);
        al.i(this.erJ, e.f.big_red_button);
    }

    public View aJl() {
        return this.erL;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.erF.setText(str);
        }
    }

    private void initView() {
        this.erA.setContentView(e.h.group_setting_activity);
        this.erD = (SettingTextSwitchView) this.erA.findViewById(e.g.sv_group_msg_notify);
        this.erE = (SettingTextSwitchView) this.erA.findViewById(e.g.sv_group_add_group);
        this.erF = (TbSettingTextTipView) this.erA.findViewById(e.g.tv_change_name);
        this.erG = (TbSettingTextTipView) this.erA.findViewById(e.g.sv_report);
        this.erH = (TbSettingTextTipView) this.erA.findViewById(e.g.sv_delete_msg);
        this.erI = (Button) this.erA.findViewById(e.g.btn_dismiss);
        this.erJ = (Button) this.erA.findViewById(e.g.btn_quit);
        this.mParent = (RelativeLayout) this.erA.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.erA.findViewById(e.g.view_navigation_bar);
        this.erL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.group_setting);
    }

    public void initListener() {
        this.erD.setSwitchStateChangeListener(this.erA);
        this.erE.setSwitchStateChangeListener(this.erA);
        this.erF.setOnClickListener(this.erA);
        this.erG.setOnClickListener(this.erA);
        this.erI.setOnClickListener(this.erA);
        this.erJ.setOnClickListener(this.erA);
        this.erH.setOnClickListener(this.erA);
    }

    public TbSettingTextTipView aJm() {
        return this.erF;
    }

    public Button aJn() {
        return this.erJ;
    }

    public Button aJo() {
        return this.erI;
    }

    public TbSettingTextTipView aJp() {
        return this.erG;
    }

    public TbSettingTextTipView aJq() {
        return this.erH;
    }

    public void aJr() {
        if (this.erC == null) {
            this.erC = new com.baidu.tbadk.core.dialog.a(this.erA.getPageContext().getPageActivity());
            this.erC.co(e.j.inform);
            this.erC.cp(e.j.group_quit_alert);
            this.erC.aE(false);
            this.erC.a(e.j.alert_yes_button, this.erA);
            this.erC.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.erC.b(this.erA.getPageContext());
            this.erC.aF(true);
        }
        this.erC.yl();
    }

    public com.baidu.tbadk.core.dialog.a aJs() {
        return this.erC;
    }

    public void BY() {
        if (this.erB == null) {
            this.erB = new com.baidu.tbadk.core.dialog.b(this.erA.getPageContext().getPageActivity());
            this.erB.cs(e.j.group_report);
            this.erB.a(new CharSequence[]{new SpannableString(this.erA.getPageContext().getString(e.j.group_report_ad)), new SpannableString(this.erA.getPageContext().getString(e.j.group_report_sex)), new SpannableString(this.erA.getPageContext().getString(e.j.group_report_lllegal))}, this.ern);
            this.erB.d(this.erA.getPageContext());
        }
        this.erB.yo();
    }

    public void aJt() {
        if (this.erJ != null) {
            this.erJ.setVisibility(8);
        }
    }

    public void aJu() {
        if (this.erI != null) {
            this.erI.setVisibility(8);
        }
    }

    public void hw(boolean z) {
        if (this.erE != null) {
            this.erE.setVisibility(z ? 0 : 8);
        }
    }

    public void hx(boolean z) {
        if (z) {
            this.erE.nK();
        } else {
            this.erE.nL();
        }
    }

    public void aJv() {
        if (this.erJ != null) {
            this.erJ.setVisibility(0);
        }
    }

    public void aJw() {
        if (this.erI != null) {
            this.erI.setVisibility(0);
        }
    }

    public void aio() {
        if (this.erG != null) {
            this.erG.setVisibility(0);
        }
    }

    public void aJx() {
        if (this.erG != null) {
            this.erG.setVisibility(8);
        }
    }

    public BdSwitchView aJy() {
        return this.erE.getSwitchView();
    }

    public BdSwitchView aJz() {
        return this.erD.getSwitchView();
    }

    public void aJA() {
        if (this.erK == null) {
            this.erK = new com.baidu.tbadk.core.dialog.a(this.erA.getPageContext().getPageActivity());
            this.erK.cp(e.j.group_dismiss_alert);
            this.erK.aE(false);
            this.erK.a(e.j.alert_yes_button, this.erA);
            this.erK.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.erK.b(this.erA.getPageContext());
        }
        this.erK.yl();
    }

    public com.baidu.tbadk.core.dialog.a aJB() {
        return this.erK;
    }

    public void aJC() {
        if (this.erK != null) {
            this.erK.dismiss();
            this.erK = null;
        }
        if (this.erB != null) {
            this.erB.dismiss();
            this.erB = null;
        }
        if (this.erC != null) {
            this.erC.dismiss();
            this.erC = null;
        }
    }
}
