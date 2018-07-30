package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.InterfaceC0101b ejY;
    private GroupSettingActivity ekk;
    private com.baidu.tbadk.core.dialog.b ekl;
    private com.baidu.tbadk.core.dialog.a ekm;
    private SettingTextSwitchView ekn;
    private SettingTextSwitchView eko;
    private TbSettingTextTipView ekp;
    private TbSettingTextTipView ekq;
    private TbSettingTextTipView ekr;
    private Button eks;
    private Button ekt;
    private com.baidu.tbadk.core.dialog.a eku;
    private View ekv;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0101b interfaceC0101b) {
        this.ejY = interfaceC0101b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.ekk = null;
        this.mParent = null;
        this.ekl = null;
        this.ekn = null;
        this.eko = null;
        this.ekp = null;
        this.ekq = null;
        this.ekr = null;
        this.ejY = null;
        this.ekk = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ekn.ey(i);
        this.eko.ey(i);
        this.ekk.getLayoutMode().setNightMode(i == 1);
        this.ekk.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ekk.getPageContext(), i);
        am.i(this.eks, d.f.big_red_button);
        am.i(this.ekt, d.f.big_red_button);
    }

    public View aGZ() {
        return this.ekv;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ekp.setText(str);
        }
    }

    private void initView() {
        this.ekk.setContentView(d.h.group_setting_activity);
        this.ekn = (SettingTextSwitchView) this.ekk.findViewById(d.g.sv_group_msg_notify);
        this.eko = (SettingTextSwitchView) this.ekk.findViewById(d.g.sv_group_add_group);
        this.ekp = (TbSettingTextTipView) this.ekk.findViewById(d.g.tv_change_name);
        this.ekq = (TbSettingTextTipView) this.ekk.findViewById(d.g.sv_report);
        this.ekr = (TbSettingTextTipView) this.ekk.findViewById(d.g.sv_delete_msg);
        this.eks = (Button) this.ekk.findViewById(d.g.btn_dismiss);
        this.ekt = (Button) this.ekk.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.ekk.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.ekk.findViewById(d.g.view_navigation_bar);
        this.ekv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.group_setting);
    }

    public void initListener() {
        this.ekn.setSwitchStateChangeListener(this.ekk);
        this.eko.setSwitchStateChangeListener(this.ekk);
        this.ekp.setOnClickListener(this.ekk);
        this.ekq.setOnClickListener(this.ekk);
        this.eks.setOnClickListener(this.ekk);
        this.ekt.setOnClickListener(this.ekk);
        this.ekr.setOnClickListener(this.ekk);
    }

    public TbSettingTextTipView aHa() {
        return this.ekp;
    }

    public Button aHb() {
        return this.ekt;
    }

    public Button aHc() {
        return this.eks;
    }

    public TbSettingTextTipView aHd() {
        return this.ekq;
    }

    public TbSettingTextTipView aHe() {
        return this.ekr;
    }

    public void aHf() {
        if (this.ekm == null) {
            this.ekm = new com.baidu.tbadk.core.dialog.a(this.ekk.getPageContext().getPageActivity());
            this.ekm.ce(d.j.inform);
            this.ekm.cf(d.j.group_quit_alert);
            this.ekm.au(false);
            this.ekm.a(d.j.alert_yes_button, this.ekk);
            this.ekm.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ekm.b(this.ekk.getPageContext());
            this.ekm.av(true);
        }
        this.ekm.xf();
    }

    public com.baidu.tbadk.core.dialog.a aHg() {
        return this.ekm;
    }

    public void AP() {
        if (this.ekl == null) {
            this.ekl = new com.baidu.tbadk.core.dialog.b(this.ekk.getPageContext().getPageActivity());
            this.ekl.ci(d.j.group_report);
            this.ekl.a(new CharSequence[]{new SpannableString(this.ekk.getPageContext().getString(d.j.group_report_ad)), new SpannableString(this.ekk.getPageContext().getString(d.j.group_report_sex)), new SpannableString(this.ekk.getPageContext().getString(d.j.group_report_lllegal))}, this.ejY);
            this.ekl.d(this.ekk.getPageContext());
        }
        this.ekl.xi();
    }

    public void aHh() {
        if (this.ekt != null) {
            this.ekt.setVisibility(8);
        }
    }

    public void aHi() {
        if (this.eks != null) {
            this.eks.setVisibility(8);
        }
    }

    public void gY(boolean z) {
        if (this.eko != null) {
            this.eko.setVisibility(z ? 0 : 8);
        }
    }

    public void gZ(boolean z) {
        if (z) {
            this.eko.mE();
        } else {
            this.eko.mF();
        }
    }

    public void aHj() {
        if (this.ekt != null) {
            this.ekt.setVisibility(0);
        }
    }

    public void aHk() {
        if (this.eks != null) {
            this.eks.setVisibility(0);
        }
    }

    public void agA() {
        if (this.ekq != null) {
            this.ekq.setVisibility(0);
        }
    }

    public void aHl() {
        if (this.ekq != null) {
            this.ekq.setVisibility(8);
        }
    }

    public BdSwitchView aHm() {
        return this.eko.getSwitchView();
    }

    public BdSwitchView aHn() {
        return this.ekn.getSwitchView();
    }

    public void aHo() {
        if (this.eku == null) {
            this.eku = new com.baidu.tbadk.core.dialog.a(this.ekk.getPageContext().getPageActivity());
            this.eku.cf(d.j.group_dismiss_alert);
            this.eku.au(false);
            this.eku.a(d.j.alert_yes_button, this.ekk);
            this.eku.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eku.b(this.ekk.getPageContext());
        }
        this.eku.xf();
    }

    public com.baidu.tbadk.core.dialog.a aHp() {
        return this.eku;
    }

    public void aHq() {
        if (this.eku != null) {
            this.eku.dismiss();
            this.eku = null;
        }
        if (this.ekl != null) {
            this.ekl.dismiss();
            this.ekl = null;
        }
        if (this.ekm != null) {
            this.ekm.dismiss();
            this.ekm = null;
        }
    }
}
