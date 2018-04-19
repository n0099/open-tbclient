package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.InterfaceC0086b dPX;
    private GroupSettingActivity dQj;
    private com.baidu.tbadk.core.dialog.b dQk;
    private com.baidu.tbadk.core.dialog.a dQl;
    private SettingTextSwitchView dQm;
    private SettingTextSwitchView dQn;
    private TbSettingTextTipView dQo;
    private TbSettingTextTipView dQp;
    private TbSettingTextTipView dQq;
    private Button dQr;
    private Button dQs;
    private com.baidu.tbadk.core.dialog.a dQt;
    private View dQu;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0086b interfaceC0086b) {
        this.dPX = interfaceC0086b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.dQj = null;
        this.mParent = null;
        this.dQk = null;
        this.dQm = null;
        this.dQn = null;
        this.dQo = null;
        this.dQp = null;
        this.dQq = null;
        this.dPX = null;
        this.dQj = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.dQm.ep(i);
        this.dQn.ep(i);
        this.dQj.getLayoutMode().setNightMode(i == 1);
        this.dQj.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.dQj.getPageContext(), i);
        ak.i(this.dQr, d.f.big_red_button);
        ak.i(this.dQs, d.f.big_red_button);
    }

    public View aAy() {
        return this.dQu;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dQo.setText(str);
        }
    }

    private void initView() {
        this.dQj.setContentView(d.i.group_setting_activity);
        this.dQm = (SettingTextSwitchView) this.dQj.findViewById(d.g.sv_group_msg_notify);
        this.dQn = (SettingTextSwitchView) this.dQj.findViewById(d.g.sv_group_add_group);
        this.dQo = (TbSettingTextTipView) this.dQj.findViewById(d.g.tv_change_name);
        this.dQp = (TbSettingTextTipView) this.dQj.findViewById(d.g.sv_report);
        this.dQq = (TbSettingTextTipView) this.dQj.findViewById(d.g.sv_delete_msg);
        this.dQr = (Button) this.dQj.findViewById(d.g.btn_dismiss);
        this.dQs = (Button) this.dQj.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.dQj.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.dQj.findViewById(d.g.view_navigation_bar);
        this.dQu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.group_setting);
    }

    public void initListener() {
        this.dQm.setSwitchStateChangeListener(this.dQj);
        this.dQn.setSwitchStateChangeListener(this.dQj);
        this.dQo.setOnClickListener(this.dQj);
        this.dQp.setOnClickListener(this.dQj);
        this.dQr.setOnClickListener(this.dQj);
        this.dQs.setOnClickListener(this.dQj);
        this.dQq.setOnClickListener(this.dQj);
    }

    public TbSettingTextTipView aAz() {
        return this.dQo;
    }

    public Button aAA() {
        return this.dQs;
    }

    public Button aAB() {
        return this.dQr;
    }

    public TbSettingTextTipView aAC() {
        return this.dQp;
    }

    public TbSettingTextTipView aAD() {
        return this.dQq;
    }

    public void aAE() {
        if (this.dQl == null) {
            this.dQl = new com.baidu.tbadk.core.dialog.a(this.dQj.getPageContext().getPageActivity());
            this.dQl.bY(d.k.inform);
            this.dQl.bZ(d.k.group_quit_alert);
            this.dQl.ar(false);
            this.dQl.a(d.k.alert_yes_button, this.dQj);
            this.dQl.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.dQl.b(this.dQj.getPageContext());
            this.dQl.as(true);
        }
        this.dQl.tD();
    }

    public com.baidu.tbadk.core.dialog.a aAF() {
        return this.dQl;
    }

    public void xg() {
        if (this.dQk == null) {
            this.dQk = new com.baidu.tbadk.core.dialog.b(this.dQj.getPageContext().getPageActivity());
            this.dQk.cc(d.k.group_report);
            this.dQk.a(new CharSequence[]{new SpannableString(this.dQj.getPageContext().getString(d.k.group_report_ad)), new SpannableString(this.dQj.getPageContext().getString(d.k.group_report_sex)), new SpannableString(this.dQj.getPageContext().getString(d.k.group_report_lllegal))}, this.dPX);
            this.dQk.d(this.dQj.getPageContext());
        }
        this.dQk.tG();
    }

    public void aAG() {
        if (this.dQs != null) {
            this.dQs.setVisibility(8);
        }
    }

    public void aAH() {
        if (this.dQr != null) {
            this.dQr.setVisibility(8);
        }
    }

    public void gE(boolean z) {
        if (this.dQn != null) {
            this.dQn.setVisibility(z ? 0 : 8);
        }
    }

    public void gF(boolean z) {
        if (z) {
            this.dQn.jO();
        } else {
            this.dQn.jP();
        }
    }

    public void aAI() {
        if (this.dQs != null) {
            this.dQs.setVisibility(0);
        }
    }

    public void aAJ() {
        if (this.dQr != null) {
            this.dQr.setVisibility(0);
        }
    }

    public void abZ() {
        if (this.dQp != null) {
            this.dQp.setVisibility(0);
        }
    }

    public void aAK() {
        if (this.dQp != null) {
            this.dQp.setVisibility(8);
        }
    }

    public BdSwitchView aAL() {
        return this.dQn.getSwitchView();
    }

    public BdSwitchView aAM() {
        return this.dQm.getSwitchView();
    }

    public void aAN() {
        if (this.dQt == null) {
            this.dQt = new com.baidu.tbadk.core.dialog.a(this.dQj.getPageContext().getPageActivity());
            this.dQt.bZ(d.k.group_dismiss_alert);
            this.dQt.ar(false);
            this.dQt.a(d.k.alert_yes_button, this.dQj);
            this.dQt.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.dQt.b(this.dQj.getPageContext());
        }
        this.dQt.tD();
    }

    public com.baidu.tbadk.core.dialog.a aAO() {
        return this.dQt;
    }

    public void aAP() {
        if (this.dQt != null) {
            this.dQt.dismiss();
            this.dQt = null;
        }
        if (this.dQk != null) {
            this.dQk.dismiss();
            this.dQk = null;
        }
        if (this.dQl != null) {
            this.dQl.dismiss();
            this.dQl = null;
        }
    }
}
