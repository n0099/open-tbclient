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
    private b.InterfaceC0492b iQb;
    private GroupSettingActivity iQm;
    private RelativeLayout iQn;
    private com.baidu.tbadk.core.dialog.b iQo;
    private com.baidu.tbadk.core.dialog.a iQp;
    private SettingTextSwitchView iQq;
    private SettingTextSwitchView iQr;
    private TbSettingTextTipView iQs;
    private TbSettingTextTipView iQt;
    private TbSettingTextTipView iQu;
    private Button iQv;
    private Button iQw;
    private com.baidu.tbadk.core.dialog.a iQx;
    private View iQy;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0492b interfaceC0492b) {
        this.iQb = interfaceC0492b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.iQm = null;
        this.iQn = null;
        this.iQo = null;
        this.iQq = null;
        this.iQr = null;
        this.iQs = null;
        this.iQt = null;
        this.iQu = null;
        this.iQb = null;
        this.iQm = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iQq.nI(i);
        this.iQr.nI(i);
        this.iQm.getLayoutMode().setNightMode(i == 1);
        this.iQm.getLayoutMode().onModeChanged(this.iQn);
        this.mNavigationBar.onChangeSkinType(this.iQm.getPageContext(), i);
        ao.setBackgroundResource(this.iQv, R.drawable.big_red_button);
        ao.setBackgroundResource(this.iQw, R.drawable.big_red_button);
    }

    public View cqD() {
        return this.iQy;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iQs.setText(str);
        }
    }

    private void initView() {
        this.iQm.setContentView(R.layout.group_setting_activity);
        this.iQq = (SettingTextSwitchView) this.iQm.findViewById(R.id.sv_group_msg_notify);
        this.iQr = (SettingTextSwitchView) this.iQm.findViewById(R.id.sv_group_add_group);
        this.iQs = (TbSettingTextTipView) this.iQm.findViewById(R.id.tv_change_name);
        this.iQt = (TbSettingTextTipView) this.iQm.findViewById(R.id.sv_report);
        this.iQu = (TbSettingTextTipView) this.iQm.findViewById(R.id.sv_delete_msg);
        this.iQv = (Button) this.iQm.findViewById(R.id.btn_dismiss);
        this.iQw = (Button) this.iQm.findViewById(R.id.btn_quit);
        this.iQn = (RelativeLayout) this.iQm.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.iQm.findViewById(R.id.view_navigation_bar);
        this.iQy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.iQq.setSwitchStateChangeListener(this.iQm);
        this.iQr.setSwitchStateChangeListener(this.iQm);
        this.iQs.setOnClickListener(this.iQm);
        this.iQt.setOnClickListener(this.iQm);
        this.iQv.setOnClickListener(this.iQm);
        this.iQw.setOnClickListener(this.iQm);
        this.iQu.setOnClickListener(this.iQm);
    }

    public TbSettingTextTipView cqE() {
        return this.iQs;
    }

    public Button cqF() {
        return this.iQw;
    }

    public Button cqG() {
        return this.iQv;
    }

    public TbSettingTextTipView cqH() {
        return this.iQt;
    }

    public TbSettingTextTipView cqI() {
        return this.iQu;
    }

    public void cqJ() {
        if (this.iQp == null) {
            this.iQp = new com.baidu.tbadk.core.dialog.a(this.iQm.getPageContext().getPageActivity());
            this.iQp.lm(R.string.inform);
            this.iQp.ln(R.string.group_quit_alert);
            this.iQp.hJ(false);
            this.iQp.a(R.string.alert_yes_button, this.iQm);
            this.iQp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iQp.b(this.iQm.getPageContext());
            this.iQp.hK(true);
        }
        this.iQp.aYL();
    }

    public com.baidu.tbadk.core.dialog.a cqK() {
        return this.iQp;
    }

    public void cqL() {
        if (this.iQo == null) {
            this.iQo = new com.baidu.tbadk.core.dialog.b(this.iQm.getPageContext().getPageActivity());
            this.iQo.lr(R.string.group_report);
            this.iQo.a(new CharSequence[]{new SpannableString(this.iQm.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.iQm.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.iQm.getPageContext().getString(R.string.group_report_lllegal))}, this.iQb);
            this.iQo.d(this.iQm.getPageContext());
        }
        this.iQo.aYN();
    }

    public void cqM() {
        if (this.iQw != null) {
            this.iQw.setVisibility(8);
        }
    }

    public void cqN() {
        if (this.iQv != null) {
            this.iQv.setVisibility(8);
        }
    }

    public void pv(boolean z) {
        if (this.iQr != null) {
            this.iQr.setVisibility(z ? 0 : 8);
        }
    }

    public void pw(boolean z) {
        if (z) {
            this.iQr.turnOn();
        } else {
            this.iQr.turnOff();
        }
    }

    public void cqO() {
        if (this.iQw != null) {
            this.iQw.setVisibility(0);
        }
    }

    public void cqP() {
        if (this.iQv != null) {
            this.iQv.setVisibility(0);
        }
    }

    public void bOv() {
        if (this.iQt != null) {
            this.iQt.setVisibility(0);
        }
    }

    public void cqQ() {
        if (this.iQt != null) {
            this.iQt.setVisibility(8);
        }
    }

    public BdSwitchView cqR() {
        return this.iQr.getSwitchView();
    }

    public BdSwitchView cqS() {
        return this.iQq.getSwitchView();
    }

    public void cqT() {
        if (this.iQx == null) {
            this.iQx = new com.baidu.tbadk.core.dialog.a(this.iQm.getPageContext().getPageActivity());
            this.iQx.ln(R.string.group_dismiss_alert);
            this.iQx.hJ(false);
            this.iQx.a(R.string.alert_yes_button, this.iQm);
            this.iQx.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iQx.b(this.iQm.getPageContext());
        }
        this.iQx.aYL();
    }

    public com.baidu.tbadk.core.dialog.a cqU() {
        return this.iQx;
    }

    public void cqV() {
        if (this.iQx != null) {
            this.iQx.dismiss();
            this.iQx = null;
        }
        if (this.iQo != null) {
            this.iQo.dismiss();
            this.iQo = null;
        }
        if (this.iQp != null) {
            this.iQp.dismiss();
            this.iQp = null;
        }
    }
}
