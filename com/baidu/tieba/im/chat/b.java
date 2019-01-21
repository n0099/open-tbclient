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
    private b.InterfaceC0158b eKR;
    private GroupSettingActivity eLd;
    private com.baidu.tbadk.core.dialog.b eLe;
    private com.baidu.tbadk.core.dialog.a eLf;
    private SettingTextSwitchView eLg;
    private SettingTextSwitchView eLh;
    private TbSettingTextTipView eLi;
    private TbSettingTextTipView eLj;
    private TbSettingTextTipView eLk;
    private Button eLl;
    private Button eLm;
    private com.baidu.tbadk.core.dialog.a eLn;
    private View eLo;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0158b interfaceC0158b) {
        this.eKR = interfaceC0158b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.eLd = null;
        this.mParent = null;
        this.eLe = null;
        this.eLg = null;
        this.eLh = null;
        this.eLi = null;
        this.eLj = null;
        this.eLk = null;
        this.eKR = null;
        this.eLd = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.eLg.fv(i);
        this.eLh.fv(i);
        this.eLd.getLayoutMode().setNightMode(i == 1);
        this.eLd.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eLd.getPageContext(), i);
        al.i(this.eLl, e.f.big_red_button);
        al.i(this.eLm, e.f.big_red_button);
    }

    public View aPf() {
        return this.eLo;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eLi.setText(str);
        }
    }

    private void initView() {
        this.eLd.setContentView(e.h.group_setting_activity);
        this.eLg = (SettingTextSwitchView) this.eLd.findViewById(e.g.sv_group_msg_notify);
        this.eLh = (SettingTextSwitchView) this.eLd.findViewById(e.g.sv_group_add_group);
        this.eLi = (TbSettingTextTipView) this.eLd.findViewById(e.g.tv_change_name);
        this.eLj = (TbSettingTextTipView) this.eLd.findViewById(e.g.sv_report);
        this.eLk = (TbSettingTextTipView) this.eLd.findViewById(e.g.sv_delete_msg);
        this.eLl = (Button) this.eLd.findViewById(e.g.btn_dismiss);
        this.eLm = (Button) this.eLd.findViewById(e.g.btn_quit);
        this.mParent = (RelativeLayout) this.eLd.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eLd.findViewById(e.g.view_navigation_bar);
        this.eLo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.group_setting);
    }

    public void initListener() {
        this.eLg.setSwitchStateChangeListener(this.eLd);
        this.eLh.setSwitchStateChangeListener(this.eLd);
        this.eLi.setOnClickListener(this.eLd);
        this.eLj.setOnClickListener(this.eLd);
        this.eLl.setOnClickListener(this.eLd);
        this.eLm.setOnClickListener(this.eLd);
        this.eLk.setOnClickListener(this.eLd);
    }

    public TbSettingTextTipView aPg() {
        return this.eLi;
    }

    public Button aPh() {
        return this.eLm;
    }

    public Button aPi() {
        return this.eLl;
    }

    public TbSettingTextTipView aPj() {
        return this.eLj;
    }

    public TbSettingTextTipView aPk() {
        return this.eLk;
    }

    public void aPl() {
        if (this.eLf == null) {
            this.eLf = new com.baidu.tbadk.core.dialog.a(this.eLd.getPageContext().getPageActivity());
            this.eLf.da(e.j.inform);
            this.eLf.db(e.j.group_quit_alert);
            this.eLf.bg(false);
            this.eLf.a(e.j.alert_yes_button, this.eLd);
            this.eLf.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eLf.b(this.eLd.getPageContext());
            this.eLf.bh(true);
        }
        this.eLf.BS();
    }

    public com.baidu.tbadk.core.dialog.a aPm() {
        return this.eLf;
    }

    public void FF() {
        if (this.eLe == null) {
            this.eLe = new com.baidu.tbadk.core.dialog.b(this.eLd.getPageContext().getPageActivity());
            this.eLe.de(e.j.group_report);
            this.eLe.a(new CharSequence[]{new SpannableString(this.eLd.getPageContext().getString(e.j.group_report_ad)), new SpannableString(this.eLd.getPageContext().getString(e.j.group_report_sex)), new SpannableString(this.eLd.getPageContext().getString(e.j.group_report_lllegal))}, this.eKR);
            this.eLe.d(this.eLd.getPageContext());
        }
        this.eLe.BV();
    }

    public void aPn() {
        if (this.eLm != null) {
            this.eLm.setVisibility(8);
        }
    }

    public void aPo() {
        if (this.eLl != null) {
            this.eLl.setVisibility(8);
        }
    }

    public void id(boolean z) {
        if (this.eLh != null) {
            this.eLh.setVisibility(z ? 0 : 8);
        }
    }

    public void ie(boolean z) {
        if (z) {
            this.eLh.nV();
        } else {
            this.eLh.nW();
        }
    }

    public void aPp() {
        if (this.eLm != null) {
            this.eLm.setVisibility(0);
        }
    }

    public void aPq() {
        if (this.eLl != null) {
            this.eLl.setVisibility(0);
        }
    }

    public void anz() {
        if (this.eLj != null) {
            this.eLj.setVisibility(0);
        }
    }

    public void aPr() {
        if (this.eLj != null) {
            this.eLj.setVisibility(8);
        }
    }

    public BdSwitchView aPs() {
        return this.eLh.getSwitchView();
    }

    public BdSwitchView aPt() {
        return this.eLg.getSwitchView();
    }

    public void aPu() {
        if (this.eLn == null) {
            this.eLn = new com.baidu.tbadk.core.dialog.a(this.eLd.getPageContext().getPageActivity());
            this.eLn.db(e.j.group_dismiss_alert);
            this.eLn.bg(false);
            this.eLn.a(e.j.alert_yes_button, this.eLd);
            this.eLn.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eLn.b(this.eLd.getPageContext());
        }
        this.eLn.BS();
    }

    public com.baidu.tbadk.core.dialog.a aPv() {
        return this.eLn;
    }

    public void aPw() {
        if (this.eLn != null) {
            this.eLn.dismiss();
            this.eLn = null;
        }
        if (this.eLe != null) {
            this.eLe.dismiss();
            this.eLe = null;
        }
        if (this.eLf != null) {
            this.eLf.dismiss();
            this.eLf = null;
        }
    }
}
