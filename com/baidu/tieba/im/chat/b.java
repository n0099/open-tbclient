package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.InterfaceC0492b iPZ;
    private GroupSettingActivity iQk;
    private RelativeLayout iQl;
    private com.baidu.tbadk.core.dialog.b iQm;
    private com.baidu.tbadk.core.dialog.a iQn;
    private SettingTextSwitchView iQo;
    private SettingTextSwitchView iQp;
    private TbSettingTextTipView iQq;
    private TbSettingTextTipView iQr;
    private TbSettingTextTipView iQs;
    private Button iQt;
    private Button iQu;
    private com.baidu.tbadk.core.dialog.a iQv;
    private View iQw;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0492b interfaceC0492b) {
        this.iPZ = interfaceC0492b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.iQk = null;
        this.iQl = null;
        this.iQm = null;
        this.iQo = null;
        this.iQp = null;
        this.iQq = null;
        this.iQr = null;
        this.iQs = null;
        this.iPZ = null;
        this.iQk = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iQo.nI(i);
        this.iQp.nI(i);
        this.iQk.getLayoutMode().setNightMode(i == 1);
        this.iQk.getLayoutMode().onModeChanged(this.iQl);
        this.mNavigationBar.onChangeSkinType(this.iQk.getPageContext(), i);
        ao.setBackgroundResource(this.iQt, R.drawable.big_red_button);
        ao.setBackgroundResource(this.iQu, R.drawable.big_red_button);
    }

    public View cqD() {
        return this.iQw;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iQq.setText(str);
        }
    }

    private void initView() {
        this.iQk.setContentView(R.layout.group_setting_activity);
        this.iQo = (SettingTextSwitchView) this.iQk.findViewById(R.id.sv_group_msg_notify);
        this.iQp = (SettingTextSwitchView) this.iQk.findViewById(R.id.sv_group_add_group);
        this.iQq = (TbSettingTextTipView) this.iQk.findViewById(R.id.tv_change_name);
        this.iQr = (TbSettingTextTipView) this.iQk.findViewById(R.id.sv_report);
        this.iQs = (TbSettingTextTipView) this.iQk.findViewById(R.id.sv_delete_msg);
        this.iQt = (Button) this.iQk.findViewById(R.id.btn_dismiss);
        this.iQu = (Button) this.iQk.findViewById(R.id.btn_quit);
        this.iQl = (RelativeLayout) this.iQk.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.iQk.findViewById(R.id.view_navigation_bar);
        this.iQw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.iQo.setSwitchStateChangeListener(this.iQk);
        this.iQp.setSwitchStateChangeListener(this.iQk);
        this.iQq.setOnClickListener(this.iQk);
        this.iQr.setOnClickListener(this.iQk);
        this.iQt.setOnClickListener(this.iQk);
        this.iQu.setOnClickListener(this.iQk);
        this.iQs.setOnClickListener(this.iQk);
    }

    public TbSettingTextTipView cqE() {
        return this.iQq;
    }

    public Button cqF() {
        return this.iQu;
    }

    public Button cqG() {
        return this.iQt;
    }

    public TbSettingTextTipView cqH() {
        return this.iQr;
    }

    public TbSettingTextTipView cqI() {
        return this.iQs;
    }

    public void cqJ() {
        if (this.iQn == null) {
            this.iQn = new com.baidu.tbadk.core.dialog.a(this.iQk.getPageContext().getPageActivity());
            this.iQn.lm(R.string.inform);
            this.iQn.ln(R.string.group_quit_alert);
            this.iQn.hJ(false);
            this.iQn.a(R.string.alert_yes_button, this.iQk);
            this.iQn.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iQn.b(this.iQk.getPageContext());
            this.iQn.hK(true);
        }
        this.iQn.aYL();
    }

    public com.baidu.tbadk.core.dialog.a cqK() {
        return this.iQn;
    }

    public void cqL() {
        if (this.iQm == null) {
            this.iQm = new com.baidu.tbadk.core.dialog.b(this.iQk.getPageContext().getPageActivity());
            this.iQm.lr(R.string.group_report);
            this.iQm.a(new CharSequence[]{new SpannableString(this.iQk.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.iQk.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.iQk.getPageContext().getString(R.string.group_report_lllegal))}, this.iPZ);
            this.iQm.d(this.iQk.getPageContext());
        }
        this.iQm.aYN();
    }

    public void cqM() {
        if (this.iQu != null) {
            this.iQu.setVisibility(8);
        }
    }

    public void cqN() {
        if (this.iQt != null) {
            this.iQt.setVisibility(8);
        }
    }

    public void pv(boolean z) {
        if (this.iQp != null) {
            this.iQp.setVisibility(z ? 0 : 8);
        }
    }

    public void pw(boolean z) {
        if (z) {
            this.iQp.turnOn();
        } else {
            this.iQp.turnOff();
        }
    }

    public void cqO() {
        if (this.iQu != null) {
            this.iQu.setVisibility(0);
        }
    }

    public void cqP() {
        if (this.iQt != null) {
            this.iQt.setVisibility(0);
        }
    }

    public void bOv() {
        if (this.iQr != null) {
            this.iQr.setVisibility(0);
        }
    }

    public void cqQ() {
        if (this.iQr != null) {
            this.iQr.setVisibility(8);
        }
    }

    public BdSwitchView cqR() {
        return this.iQp.getSwitchView();
    }

    public BdSwitchView cqS() {
        return this.iQo.getSwitchView();
    }

    public void cqT() {
        if (this.iQv == null) {
            this.iQv = new com.baidu.tbadk.core.dialog.a(this.iQk.getPageContext().getPageActivity());
            this.iQv.ln(R.string.group_dismiss_alert);
            this.iQv.hJ(false);
            this.iQv.a(R.string.alert_yes_button, this.iQk);
            this.iQv.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iQv.b(this.iQk.getPageContext());
        }
        this.iQv.aYL();
    }

    public com.baidu.tbadk.core.dialog.a cqU() {
        return this.iQv;
    }

    public void cqV() {
        if (this.iQv != null) {
            this.iQv.dismiss();
            this.iQv = null;
        }
        if (this.iQm != null) {
            this.iQm.dismiss();
            this.iQm = null;
        }
        if (this.iQn != null) {
            this.iQn.dismiss();
            this.iQn = null;
        }
    }
}
