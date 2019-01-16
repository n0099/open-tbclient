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
    private b.InterfaceC0158b eKQ;
    private GroupSettingActivity eLc;
    private com.baidu.tbadk.core.dialog.b eLd;
    private com.baidu.tbadk.core.dialog.a eLe;
    private SettingTextSwitchView eLf;
    private SettingTextSwitchView eLg;
    private TbSettingTextTipView eLh;
    private TbSettingTextTipView eLi;
    private TbSettingTextTipView eLj;
    private Button eLk;
    private Button eLl;
    private com.baidu.tbadk.core.dialog.a eLm;
    private View eLn;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0158b interfaceC0158b) {
        this.eKQ = interfaceC0158b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.eLc = null;
        this.mParent = null;
        this.eLd = null;
        this.eLf = null;
        this.eLg = null;
        this.eLh = null;
        this.eLi = null;
        this.eLj = null;
        this.eKQ = null;
        this.eLc = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.eLf.fv(i);
        this.eLg.fv(i);
        this.eLc.getLayoutMode().setNightMode(i == 1);
        this.eLc.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eLc.getPageContext(), i);
        al.i(this.eLk, e.f.big_red_button);
        al.i(this.eLl, e.f.big_red_button);
    }

    public View aPf() {
        return this.eLn;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eLh.setText(str);
        }
    }

    private void initView() {
        this.eLc.setContentView(e.h.group_setting_activity);
        this.eLf = (SettingTextSwitchView) this.eLc.findViewById(e.g.sv_group_msg_notify);
        this.eLg = (SettingTextSwitchView) this.eLc.findViewById(e.g.sv_group_add_group);
        this.eLh = (TbSettingTextTipView) this.eLc.findViewById(e.g.tv_change_name);
        this.eLi = (TbSettingTextTipView) this.eLc.findViewById(e.g.sv_report);
        this.eLj = (TbSettingTextTipView) this.eLc.findViewById(e.g.sv_delete_msg);
        this.eLk = (Button) this.eLc.findViewById(e.g.btn_dismiss);
        this.eLl = (Button) this.eLc.findViewById(e.g.btn_quit);
        this.mParent = (RelativeLayout) this.eLc.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eLc.findViewById(e.g.view_navigation_bar);
        this.eLn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.group_setting);
    }

    public void initListener() {
        this.eLf.setSwitchStateChangeListener(this.eLc);
        this.eLg.setSwitchStateChangeListener(this.eLc);
        this.eLh.setOnClickListener(this.eLc);
        this.eLi.setOnClickListener(this.eLc);
        this.eLk.setOnClickListener(this.eLc);
        this.eLl.setOnClickListener(this.eLc);
        this.eLj.setOnClickListener(this.eLc);
    }

    public TbSettingTextTipView aPg() {
        return this.eLh;
    }

    public Button aPh() {
        return this.eLl;
    }

    public Button aPi() {
        return this.eLk;
    }

    public TbSettingTextTipView aPj() {
        return this.eLi;
    }

    public TbSettingTextTipView aPk() {
        return this.eLj;
    }

    public void aPl() {
        if (this.eLe == null) {
            this.eLe = new com.baidu.tbadk.core.dialog.a(this.eLc.getPageContext().getPageActivity());
            this.eLe.da(e.j.inform);
            this.eLe.db(e.j.group_quit_alert);
            this.eLe.bg(false);
            this.eLe.a(e.j.alert_yes_button, this.eLc);
            this.eLe.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eLe.b(this.eLc.getPageContext());
            this.eLe.bh(true);
        }
        this.eLe.BS();
    }

    public com.baidu.tbadk.core.dialog.a aPm() {
        return this.eLe;
    }

    public void FF() {
        if (this.eLd == null) {
            this.eLd = new com.baidu.tbadk.core.dialog.b(this.eLc.getPageContext().getPageActivity());
            this.eLd.de(e.j.group_report);
            this.eLd.a(new CharSequence[]{new SpannableString(this.eLc.getPageContext().getString(e.j.group_report_ad)), new SpannableString(this.eLc.getPageContext().getString(e.j.group_report_sex)), new SpannableString(this.eLc.getPageContext().getString(e.j.group_report_lllegal))}, this.eKQ);
            this.eLd.d(this.eLc.getPageContext());
        }
        this.eLd.BV();
    }

    public void aPn() {
        if (this.eLl != null) {
            this.eLl.setVisibility(8);
        }
    }

    public void aPo() {
        if (this.eLk != null) {
            this.eLk.setVisibility(8);
        }
    }

    public void id(boolean z) {
        if (this.eLg != null) {
            this.eLg.setVisibility(z ? 0 : 8);
        }
    }

    public void ie(boolean z) {
        if (z) {
            this.eLg.nV();
        } else {
            this.eLg.nW();
        }
    }

    public void aPp() {
        if (this.eLl != null) {
            this.eLl.setVisibility(0);
        }
    }

    public void aPq() {
        if (this.eLk != null) {
            this.eLk.setVisibility(0);
        }
    }

    public void anz() {
        if (this.eLi != null) {
            this.eLi.setVisibility(0);
        }
    }

    public void aPr() {
        if (this.eLi != null) {
            this.eLi.setVisibility(8);
        }
    }

    public BdSwitchView aPs() {
        return this.eLg.getSwitchView();
    }

    public BdSwitchView aPt() {
        return this.eLf.getSwitchView();
    }

    public void aPu() {
        if (this.eLm == null) {
            this.eLm = new com.baidu.tbadk.core.dialog.a(this.eLc.getPageContext().getPageActivity());
            this.eLm.db(e.j.group_dismiss_alert);
            this.eLm.bg(false);
            this.eLm.a(e.j.alert_yes_button, this.eLc);
            this.eLm.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eLm.b(this.eLc.getPageContext());
        }
        this.eLm.BS();
    }

    public com.baidu.tbadk.core.dialog.a aPv() {
        return this.eLm;
    }

    public void aPw() {
        if (this.eLm != null) {
            this.eLm.dismiss();
            this.eLm = null;
        }
        if (this.eLd != null) {
            this.eLd.dismiss();
            this.eLd = null;
        }
        if (this.eLe != null) {
            this.eLe.dismiss();
            this.eLe = null;
        }
    }
}
