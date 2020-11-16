package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.InterfaceC0574b jVN;
    private GroupSettingActivity jVY;
    private RelativeLayout jVZ;
    private com.baidu.tbadk.core.dialog.b jWa;
    private com.baidu.tbadk.core.dialog.a jWb;
    private SettingTextSwitchView jWc;
    private SettingTextSwitchView jWd;
    private TbSettingTextTipView jWe;
    private TbSettingTextTipView jWf;
    private TbSettingTextTipView jWg;
    private Button jWh;
    private Button jWi;
    private com.baidu.tbadk.core.dialog.a jWj;
    private View jWk;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0574b interfaceC0574b) {
        this.jVN = interfaceC0574b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.jVY = null;
        this.jVZ = null;
        this.jWa = null;
        this.jWc = null;
        this.jWd = null;
        this.jWe = null;
        this.jWf = null;
        this.jWg = null;
        this.jVN = null;
        this.jVY = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jWc.rx(i);
        this.jWd.rx(i);
        this.jVY.getLayoutMode().setNightMode(i == 1);
        this.jVY.getLayoutMode().onModeChanged(this.jVZ);
        this.mNavigationBar.onChangeSkinType(this.jVY.getPageContext(), i);
        ap.setBackgroundResource(this.jWh, R.drawable.big_red_button);
        ap.setBackgroundResource(this.jWi, R.drawable.big_red_button);
    }

    public View cOa() {
        return this.jWk;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jWe.setText(str);
        }
    }

    private void initView() {
        this.jVY.setContentView(R.layout.group_setting_activity);
        this.jWc = (SettingTextSwitchView) this.jVY.findViewById(R.id.sv_group_msg_notify);
        this.jWd = (SettingTextSwitchView) this.jVY.findViewById(R.id.sv_group_add_group);
        this.jWe = (TbSettingTextTipView) this.jVY.findViewById(R.id.tv_change_name);
        this.jWf = (TbSettingTextTipView) this.jVY.findViewById(R.id.sv_report);
        this.jWg = (TbSettingTextTipView) this.jVY.findViewById(R.id.sv_delete_msg);
        this.jWh = (Button) this.jVY.findViewById(R.id.btn_dismiss);
        this.jWi = (Button) this.jVY.findViewById(R.id.btn_quit);
        this.jVZ = (RelativeLayout) this.jVY.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jVY.findViewById(R.id.view_navigation_bar);
        this.jWk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.jWc.setSwitchStateChangeListener(this.jVY);
        this.jWd.setSwitchStateChangeListener(this.jVY);
        this.jWe.setOnClickListener(this.jVY);
        this.jWf.setOnClickListener(this.jVY);
        this.jWh.setOnClickListener(this.jVY);
        this.jWi.setOnClickListener(this.jVY);
        this.jWg.setOnClickListener(this.jVY);
    }

    public TbSettingTextTipView cOb() {
        return this.jWe;
    }

    public Button cOc() {
        return this.jWi;
    }

    public Button cOd() {
        return this.jWh;
    }

    public TbSettingTextTipView cOe() {
        return this.jWf;
    }

    public TbSettingTextTipView cOf() {
        return this.jWg;
    }

    public void cOg() {
        if (this.jWb == null) {
            this.jWb = new com.baidu.tbadk.core.dialog.a(this.jVY.getPageContext().getPageActivity());
            this.jWb.or(R.string.inform);
            this.jWb.os(R.string.group_quit_alert);
            this.jWb.iW(false);
            this.jWb.a(R.string.alert_yes_button, this.jVY);
            this.jWb.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jWb.b(this.jVY.getPageContext());
            this.jWb.iX(true);
        }
        this.jWb.bog();
    }

    public com.baidu.tbadk.core.dialog.a cOh() {
        return this.jWb;
    }

    public void cOi() {
        if (this.jWa == null) {
            this.jWa = new com.baidu.tbadk.core.dialog.b(this.jVY.getPageContext().getPageActivity());
            this.jWa.ox(R.string.group_report);
            this.jWa.a(new CharSequence[]{new SpannableString(this.jVY.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.jVY.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.jVY.getPageContext().getString(R.string.group_report_lllegal))}, this.jVN);
            this.jWa.d(this.jVY.getPageContext());
        }
        this.jWa.boi();
    }

    public void cOj() {
        if (this.jWi != null) {
            this.jWi.setVisibility(8);
        }
    }

    public void cOk() {
        if (this.jWh != null) {
            this.jWh.setVisibility(8);
        }
    }

    public void rv(boolean z) {
        if (this.jWd != null) {
            this.jWd.setVisibility(z ? 0 : 8);
        }
    }

    public void rw(boolean z) {
        if (z) {
            this.jWd.turnOn();
        } else {
            this.jWd.turnOff();
        }
    }

    public void cOl() {
        if (this.jWi != null) {
            this.jWi.setVisibility(0);
        }
    }

    public void cOm() {
        if (this.jWh != null) {
            this.jWh.setVisibility(0);
        }
    }

    public void ciN() {
        if (this.jWf != null) {
            this.jWf.setVisibility(0);
        }
    }

    public void cOn() {
        if (this.jWf != null) {
            this.jWf.setVisibility(8);
        }
    }

    public BdSwitchView cOo() {
        return this.jWd.getSwitchView();
    }

    public BdSwitchView cOp() {
        return this.jWc.getSwitchView();
    }

    public void cOq() {
        if (this.jWj == null) {
            this.jWj = new com.baidu.tbadk.core.dialog.a(this.jVY.getPageContext().getPageActivity());
            this.jWj.os(R.string.group_dismiss_alert);
            this.jWj.iW(false);
            this.jWj.a(R.string.alert_yes_button, this.jVY);
            this.jWj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jWj.b(this.jVY.getPageContext());
        }
        this.jWj.bog();
    }

    public com.baidu.tbadk.core.dialog.a cOr() {
        return this.jWj;
    }

    public void cOs() {
        if (this.jWj != null) {
            this.jWj.dismiss();
            this.jWj = null;
        }
        if (this.jWa != null) {
            this.jWa.dismiss();
            this.jWa = null;
        }
        if (this.jWb != null) {
            this.jWb.dismiss();
            this.jWb = null;
        }
    }
}
