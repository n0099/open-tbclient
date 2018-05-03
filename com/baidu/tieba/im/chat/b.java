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
    private b.InterfaceC0086b dPU;
    private GroupSettingActivity dQg;
    private com.baidu.tbadk.core.dialog.b dQh;
    private com.baidu.tbadk.core.dialog.a dQi;
    private SettingTextSwitchView dQj;
    private SettingTextSwitchView dQk;
    private TbSettingTextTipView dQl;
    private TbSettingTextTipView dQm;
    private TbSettingTextTipView dQn;
    private Button dQo;
    private Button dQp;
    private com.baidu.tbadk.core.dialog.a dQq;
    private View dQr;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0086b interfaceC0086b) {
        this.dPU = interfaceC0086b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.dQg = null;
        this.mParent = null;
        this.dQh = null;
        this.dQj = null;
        this.dQk = null;
        this.dQl = null;
        this.dQm = null;
        this.dQn = null;
        this.dPU = null;
        this.dQg = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.dQj.ep(i);
        this.dQk.ep(i);
        this.dQg.getLayoutMode().setNightMode(i == 1);
        this.dQg.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.dQg.getPageContext(), i);
        ak.i(this.dQo, d.f.big_red_button);
        ak.i(this.dQp, d.f.big_red_button);
    }

    public View aAy() {
        return this.dQr;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dQl.setText(str);
        }
    }

    private void initView() {
        this.dQg.setContentView(d.i.group_setting_activity);
        this.dQj = (SettingTextSwitchView) this.dQg.findViewById(d.g.sv_group_msg_notify);
        this.dQk = (SettingTextSwitchView) this.dQg.findViewById(d.g.sv_group_add_group);
        this.dQl = (TbSettingTextTipView) this.dQg.findViewById(d.g.tv_change_name);
        this.dQm = (TbSettingTextTipView) this.dQg.findViewById(d.g.sv_report);
        this.dQn = (TbSettingTextTipView) this.dQg.findViewById(d.g.sv_delete_msg);
        this.dQo = (Button) this.dQg.findViewById(d.g.btn_dismiss);
        this.dQp = (Button) this.dQg.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.dQg.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.dQg.findViewById(d.g.view_navigation_bar);
        this.dQr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.group_setting);
    }

    public void initListener() {
        this.dQj.setSwitchStateChangeListener(this.dQg);
        this.dQk.setSwitchStateChangeListener(this.dQg);
        this.dQl.setOnClickListener(this.dQg);
        this.dQm.setOnClickListener(this.dQg);
        this.dQo.setOnClickListener(this.dQg);
        this.dQp.setOnClickListener(this.dQg);
        this.dQn.setOnClickListener(this.dQg);
    }

    public TbSettingTextTipView aAz() {
        return this.dQl;
    }

    public Button aAA() {
        return this.dQp;
    }

    public Button aAB() {
        return this.dQo;
    }

    public TbSettingTextTipView aAC() {
        return this.dQm;
    }

    public TbSettingTextTipView aAD() {
        return this.dQn;
    }

    public void aAE() {
        if (this.dQi == null) {
            this.dQi = new com.baidu.tbadk.core.dialog.a(this.dQg.getPageContext().getPageActivity());
            this.dQi.bY(d.k.inform);
            this.dQi.bZ(d.k.group_quit_alert);
            this.dQi.ar(false);
            this.dQi.a(d.k.alert_yes_button, this.dQg);
            this.dQi.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.dQi.b(this.dQg.getPageContext());
            this.dQi.as(true);
        }
        this.dQi.tD();
    }

    public com.baidu.tbadk.core.dialog.a aAF() {
        return this.dQi;
    }

    public void xg() {
        if (this.dQh == null) {
            this.dQh = new com.baidu.tbadk.core.dialog.b(this.dQg.getPageContext().getPageActivity());
            this.dQh.cc(d.k.group_report);
            this.dQh.a(new CharSequence[]{new SpannableString(this.dQg.getPageContext().getString(d.k.group_report_ad)), new SpannableString(this.dQg.getPageContext().getString(d.k.group_report_sex)), new SpannableString(this.dQg.getPageContext().getString(d.k.group_report_lllegal))}, this.dPU);
            this.dQh.d(this.dQg.getPageContext());
        }
        this.dQh.tG();
    }

    public void aAG() {
        if (this.dQp != null) {
            this.dQp.setVisibility(8);
        }
    }

    public void aAH() {
        if (this.dQo != null) {
            this.dQo.setVisibility(8);
        }
    }

    public void gE(boolean z) {
        if (this.dQk != null) {
            this.dQk.setVisibility(z ? 0 : 8);
        }
    }

    public void gF(boolean z) {
        if (z) {
            this.dQk.jO();
        } else {
            this.dQk.jP();
        }
    }

    public void aAI() {
        if (this.dQp != null) {
            this.dQp.setVisibility(0);
        }
    }

    public void aAJ() {
        if (this.dQo != null) {
            this.dQo.setVisibility(0);
        }
    }

    public void abZ() {
        if (this.dQm != null) {
            this.dQm.setVisibility(0);
        }
    }

    public void aAK() {
        if (this.dQm != null) {
            this.dQm.setVisibility(8);
        }
    }

    public BdSwitchView aAL() {
        return this.dQk.getSwitchView();
    }

    public BdSwitchView aAM() {
        return this.dQj.getSwitchView();
    }

    public void aAN() {
        if (this.dQq == null) {
            this.dQq = new com.baidu.tbadk.core.dialog.a(this.dQg.getPageContext().getPageActivity());
            this.dQq.bZ(d.k.group_dismiss_alert);
            this.dQq.ar(false);
            this.dQq.a(d.k.alert_yes_button, this.dQg);
            this.dQq.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.dQq.b(this.dQg.getPageContext());
        }
        this.dQq.tD();
    }

    public com.baidu.tbadk.core.dialog.a aAO() {
        return this.dQq;
    }

    public void aAP() {
        if (this.dQq != null) {
            this.dQq.dismiss();
            this.dQq = null;
        }
        if (this.dQh != null) {
            this.dQh.dismiss();
            this.dQh = null;
        }
        if (this.dQi != null) {
            this.dQi.dismiss();
            this.dQi = null;
        }
    }
}
