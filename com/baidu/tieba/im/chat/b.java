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
    private b.InterfaceC0086b dRb;
    private GroupSettingActivity dRn;
    private com.baidu.tbadk.core.dialog.b dRo;
    private com.baidu.tbadk.core.dialog.a dRp;
    private SettingTextSwitchView dRq;
    private SettingTextSwitchView dRr;
    private TbSettingTextTipView dRs;
    private TbSettingTextTipView dRt;
    private TbSettingTextTipView dRu;
    private Button dRv;
    private Button dRw;
    private com.baidu.tbadk.core.dialog.a dRx;
    private View dRy;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0086b interfaceC0086b) {
        this.dRb = interfaceC0086b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.dRn = null;
        this.mParent = null;
        this.dRo = null;
        this.dRq = null;
        this.dRr = null;
        this.dRs = null;
        this.dRt = null;
        this.dRu = null;
        this.dRb = null;
        this.dRn = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.dRq.eq(i);
        this.dRr.eq(i);
        this.dRn.getLayoutMode().setNightMode(i == 1);
        this.dRn.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.dRn.getPageContext(), i);
        ak.i(this.dRv, d.f.big_red_button);
        ak.i(this.dRw, d.f.big_red_button);
    }

    public View aAw() {
        return this.dRy;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dRs.setText(str);
        }
    }

    private void initView() {
        this.dRn.setContentView(d.i.group_setting_activity);
        this.dRq = (SettingTextSwitchView) this.dRn.findViewById(d.g.sv_group_msg_notify);
        this.dRr = (SettingTextSwitchView) this.dRn.findViewById(d.g.sv_group_add_group);
        this.dRs = (TbSettingTextTipView) this.dRn.findViewById(d.g.tv_change_name);
        this.dRt = (TbSettingTextTipView) this.dRn.findViewById(d.g.sv_report);
        this.dRu = (TbSettingTextTipView) this.dRn.findViewById(d.g.sv_delete_msg);
        this.dRv = (Button) this.dRn.findViewById(d.g.btn_dismiss);
        this.dRw = (Button) this.dRn.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.dRn.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.dRn.findViewById(d.g.view_navigation_bar);
        this.dRy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.group_setting);
    }

    public void initListener() {
        this.dRq.setSwitchStateChangeListener(this.dRn);
        this.dRr.setSwitchStateChangeListener(this.dRn);
        this.dRs.setOnClickListener(this.dRn);
        this.dRt.setOnClickListener(this.dRn);
        this.dRv.setOnClickListener(this.dRn);
        this.dRw.setOnClickListener(this.dRn);
        this.dRu.setOnClickListener(this.dRn);
    }

    public TbSettingTextTipView aAx() {
        return this.dRs;
    }

    public Button aAy() {
        return this.dRw;
    }

    public Button aAz() {
        return this.dRv;
    }

    public TbSettingTextTipView aAA() {
        return this.dRt;
    }

    public TbSettingTextTipView aAB() {
        return this.dRu;
    }

    public void aAC() {
        if (this.dRp == null) {
            this.dRp = new com.baidu.tbadk.core.dialog.a(this.dRn.getPageContext().getPageActivity());
            this.dRp.bZ(d.k.inform);
            this.dRp.ca(d.k.group_quit_alert);
            this.dRp.ar(false);
            this.dRp.a(d.k.alert_yes_button, this.dRn);
            this.dRp.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.dRp.b(this.dRn.getPageContext());
            this.dRp.as(true);
        }
        this.dRp.tC();
    }

    public com.baidu.tbadk.core.dialog.a aAD() {
        return this.dRp;
    }

    public void xf() {
        if (this.dRo == null) {
            this.dRo = new com.baidu.tbadk.core.dialog.b(this.dRn.getPageContext().getPageActivity());
            this.dRo.cd(d.k.group_report);
            this.dRo.a(new CharSequence[]{new SpannableString(this.dRn.getPageContext().getString(d.k.group_report_ad)), new SpannableString(this.dRn.getPageContext().getString(d.k.group_report_sex)), new SpannableString(this.dRn.getPageContext().getString(d.k.group_report_lllegal))}, this.dRb);
            this.dRo.d(this.dRn.getPageContext());
        }
        this.dRo.tF();
    }

    public void aAE() {
        if (this.dRw != null) {
            this.dRw.setVisibility(8);
        }
    }

    public void aAF() {
        if (this.dRv != null) {
            this.dRv.setVisibility(8);
        }
    }

    public void gF(boolean z) {
        if (this.dRr != null) {
            this.dRr.setVisibility(z ? 0 : 8);
        }
    }

    public void gG(boolean z) {
        if (z) {
            this.dRr.jO();
        } else {
            this.dRr.jP();
        }
    }

    public void aAG() {
        if (this.dRw != null) {
            this.dRw.setVisibility(0);
        }
    }

    public void aAH() {
        if (this.dRv != null) {
            this.dRv.setVisibility(0);
        }
    }

    public void aca() {
        if (this.dRt != null) {
            this.dRt.setVisibility(0);
        }
    }

    public void aAI() {
        if (this.dRt != null) {
            this.dRt.setVisibility(8);
        }
    }

    public BdSwitchView aAJ() {
        return this.dRr.getSwitchView();
    }

    public BdSwitchView aAK() {
        return this.dRq.getSwitchView();
    }

    public void aAL() {
        if (this.dRx == null) {
            this.dRx = new com.baidu.tbadk.core.dialog.a(this.dRn.getPageContext().getPageActivity());
            this.dRx.ca(d.k.group_dismiss_alert);
            this.dRx.ar(false);
            this.dRx.a(d.k.alert_yes_button, this.dRn);
            this.dRx.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.dRx.b(this.dRn.getPageContext());
        }
        this.dRx.tC();
    }

    public com.baidu.tbadk.core.dialog.a aAM() {
        return this.dRx;
    }

    public void aAN() {
        if (this.dRx != null) {
            this.dRx.dismiss();
            this.dRx = null;
        }
        if (this.dRo != null) {
            this.dRo.dismiss();
            this.dRo = null;
        }
        if (this.dRp != null) {
            this.dRp.dismiss();
            this.dRp = null;
        }
    }
}
