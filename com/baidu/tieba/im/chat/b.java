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
    private com.baidu.tbadk.core.dialog.a eKA;
    private View eKB;
    private b.InterfaceC0158b eKe;
    private GroupSettingActivity eKq;
    private com.baidu.tbadk.core.dialog.b eKr;
    private com.baidu.tbadk.core.dialog.a eKs;
    private SettingTextSwitchView eKt;
    private SettingTextSwitchView eKu;
    private TbSettingTextTipView eKv;
    private TbSettingTextTipView eKw;
    private TbSettingTextTipView eKx;
    private Button eKy;
    private Button eKz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0158b interfaceC0158b) {
        this.eKe = interfaceC0158b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.eKq = null;
        this.mParent = null;
        this.eKr = null;
        this.eKt = null;
        this.eKu = null;
        this.eKv = null;
        this.eKw = null;
        this.eKx = null;
        this.eKe = null;
        this.eKq = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.eKt.fv(i);
        this.eKu.fv(i);
        this.eKq.getLayoutMode().setNightMode(i == 1);
        this.eKq.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eKq.getPageContext(), i);
        al.i(this.eKy, e.f.big_red_button);
        al.i(this.eKz, e.f.big_red_button);
    }

    public View aOF() {
        return this.eKB;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eKv.setText(str);
        }
    }

    private void initView() {
        this.eKq.setContentView(e.h.group_setting_activity);
        this.eKt = (SettingTextSwitchView) this.eKq.findViewById(e.g.sv_group_msg_notify);
        this.eKu = (SettingTextSwitchView) this.eKq.findViewById(e.g.sv_group_add_group);
        this.eKv = (TbSettingTextTipView) this.eKq.findViewById(e.g.tv_change_name);
        this.eKw = (TbSettingTextTipView) this.eKq.findViewById(e.g.sv_report);
        this.eKx = (TbSettingTextTipView) this.eKq.findViewById(e.g.sv_delete_msg);
        this.eKy = (Button) this.eKq.findViewById(e.g.btn_dismiss);
        this.eKz = (Button) this.eKq.findViewById(e.g.btn_quit);
        this.mParent = (RelativeLayout) this.eKq.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eKq.findViewById(e.g.view_navigation_bar);
        this.eKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.group_setting);
    }

    public void initListener() {
        this.eKt.setSwitchStateChangeListener(this.eKq);
        this.eKu.setSwitchStateChangeListener(this.eKq);
        this.eKv.setOnClickListener(this.eKq);
        this.eKw.setOnClickListener(this.eKq);
        this.eKy.setOnClickListener(this.eKq);
        this.eKz.setOnClickListener(this.eKq);
        this.eKx.setOnClickListener(this.eKq);
    }

    public TbSettingTextTipView aOG() {
        return this.eKv;
    }

    public Button aOH() {
        return this.eKz;
    }

    public Button aOI() {
        return this.eKy;
    }

    public TbSettingTextTipView aOJ() {
        return this.eKw;
    }

    public TbSettingTextTipView aOK() {
        return this.eKx;
    }

    public void aOL() {
        if (this.eKs == null) {
            this.eKs = new com.baidu.tbadk.core.dialog.a(this.eKq.getPageContext().getPageActivity());
            this.eKs.da(e.j.inform);
            this.eKs.db(e.j.group_quit_alert);
            this.eKs.bf(false);
            this.eKs.a(e.j.alert_yes_button, this.eKq);
            this.eKs.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eKs.b(this.eKq.getPageContext());
            this.eKs.bg(true);
        }
        this.eKs.BF();
    }

    public com.baidu.tbadk.core.dialog.a aOM() {
        return this.eKs;
    }

    public void Fs() {
        if (this.eKr == null) {
            this.eKr = new com.baidu.tbadk.core.dialog.b(this.eKq.getPageContext().getPageActivity());
            this.eKr.de(e.j.group_report);
            this.eKr.a(new CharSequence[]{new SpannableString(this.eKq.getPageContext().getString(e.j.group_report_ad)), new SpannableString(this.eKq.getPageContext().getString(e.j.group_report_sex)), new SpannableString(this.eKq.getPageContext().getString(e.j.group_report_lllegal))}, this.eKe);
            this.eKr.d(this.eKq.getPageContext());
        }
        this.eKr.BI();
    }

    public void aON() {
        if (this.eKz != null) {
            this.eKz.setVisibility(8);
        }
    }

    public void aOO() {
        if (this.eKy != null) {
            this.eKy.setVisibility(8);
        }
    }

    public void id(boolean z) {
        if (this.eKu != null) {
            this.eKu.setVisibility(z ? 0 : 8);
        }
    }

    public void ie(boolean z) {
        if (z) {
            this.eKu.nR();
        } else {
            this.eKu.nS();
        }
    }

    public void aOP() {
        if (this.eKz != null) {
            this.eKz.setVisibility(0);
        }
    }

    public void aOQ() {
        if (this.eKy != null) {
            this.eKy.setVisibility(0);
        }
    }

    public void anc() {
        if (this.eKw != null) {
            this.eKw.setVisibility(0);
        }
    }

    public void aOR() {
        if (this.eKw != null) {
            this.eKw.setVisibility(8);
        }
    }

    public BdSwitchView aOS() {
        return this.eKu.getSwitchView();
    }

    public BdSwitchView aOT() {
        return this.eKt.getSwitchView();
    }

    public void aOU() {
        if (this.eKA == null) {
            this.eKA = new com.baidu.tbadk.core.dialog.a(this.eKq.getPageContext().getPageActivity());
            this.eKA.db(e.j.group_dismiss_alert);
            this.eKA.bf(false);
            this.eKA.a(e.j.alert_yes_button, this.eKq);
            this.eKA.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eKA.b(this.eKq.getPageContext());
        }
        this.eKA.BF();
    }

    public com.baidu.tbadk.core.dialog.a aOV() {
        return this.eKA;
    }

    public void aOW() {
        if (this.eKA != null) {
            this.eKA.dismiss();
            this.eKA = null;
        }
        if (this.eKr != null) {
            this.eKr.dismiss();
            this.eKr = null;
        }
        if (this.eKs != null) {
            this.eKs.dismiss();
            this.eKs = null;
        }
    }
}
