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
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.a hrL;
    private GroupSettingActivity hrW;
    private RelativeLayout hrX;
    private com.baidu.tbadk.core.dialog.b hrY;
    private com.baidu.tbadk.core.dialog.a hrZ;
    private SettingTextSwitchView hsa;
    private SettingTextSwitchView hsb;
    private TbSettingTextTipView hsc;
    private TbSettingTextTipView hsd;
    private TbSettingTextTipView hse;
    private Button hsf;
    private Button hsg;
    private com.baidu.tbadk.core.dialog.a hsh;
    private View hsi;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.hrL = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.hrW = null;
        this.hrX = null;
        this.hrY = null;
        this.hsa = null;
        this.hsb = null;
        this.hsc = null;
        this.hsd = null;
        this.hse = null;
        this.hrL = null;
        this.hrW = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.hsa.me(i);
        this.hsb.me(i);
        this.hrW.getLayoutMode().setNightMode(i == 1);
        this.hrW.getLayoutMode().onModeChanged(this.hrX);
        this.mNavigationBar.onChangeSkinType(this.hrW.getPageContext(), i);
        am.setBackgroundResource(this.hsf, R.drawable.big_red_button);
        am.setBackgroundResource(this.hsg, R.drawable.big_red_button);
    }

    public View bRN() {
        return this.hsi;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hsc.setText(str);
        }
    }

    private void initView() {
        this.hrW.setContentView(R.layout.group_setting_activity);
        this.hsa = (SettingTextSwitchView) this.hrW.findViewById(R.id.sv_group_msg_notify);
        this.hsb = (SettingTextSwitchView) this.hrW.findViewById(R.id.sv_group_add_group);
        this.hsc = (TbSettingTextTipView) this.hrW.findViewById(R.id.tv_change_name);
        this.hsd = (TbSettingTextTipView) this.hrW.findViewById(R.id.sv_report);
        this.hse = (TbSettingTextTipView) this.hrW.findViewById(R.id.sv_delete_msg);
        this.hsf = (Button) this.hrW.findViewById(R.id.btn_dismiss);
        this.hsg = (Button) this.hrW.findViewById(R.id.btn_quit);
        this.hrX = (RelativeLayout) this.hrW.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hrW.findViewById(R.id.view_navigation_bar);
        this.hsi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.hsa.setSwitchStateChangeListener(this.hrW);
        this.hsb.setSwitchStateChangeListener(this.hrW);
        this.hsc.setOnClickListener(this.hrW);
        this.hsd.setOnClickListener(this.hrW);
        this.hsf.setOnClickListener(this.hrW);
        this.hsg.setOnClickListener(this.hrW);
        this.hse.setOnClickListener(this.hrW);
    }

    public TbSettingTextTipView bRO() {
        return this.hsc;
    }

    public Button bRP() {
        return this.hsg;
    }

    public Button bRQ() {
        return this.hsf;
    }

    public TbSettingTextTipView bRR() {
        return this.hsd;
    }

    public TbSettingTextTipView bRS() {
        return this.hse;
    }

    public void bRT() {
        if (this.hrZ == null) {
            this.hrZ = new com.baidu.tbadk.core.dialog.a(this.hrW.getPageContext().getPageActivity());
            this.hrZ.jV(R.string.inform);
            this.hrZ.jW(R.string.group_quit_alert);
            this.hrZ.fG(false);
            this.hrZ.a(R.string.alert_yes_button, this.hrW);
            this.hrZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hrZ.b(this.hrW.getPageContext());
            this.hrZ.fH(true);
        }
        this.hrZ.aEA();
    }

    public com.baidu.tbadk.core.dialog.a bRU() {
        return this.hrZ;
    }

    public void bRV() {
        if (this.hrY == null) {
            this.hrY = new com.baidu.tbadk.core.dialog.b(this.hrW.getPageContext().getPageActivity());
            this.hrY.ka(R.string.group_report);
            this.hrY.a(new CharSequence[]{new SpannableString(this.hrW.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.hrW.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.hrW.getPageContext().getString(R.string.group_report_lllegal))}, this.hrL);
            this.hrY.d(this.hrW.getPageContext());
        }
        this.hrY.aEB();
    }

    public void bRW() {
        if (this.hsg != null) {
            this.hsg.setVisibility(8);
        }
    }

    public void bRX() {
        if (this.hsf != null) {
            this.hsf.setVisibility(8);
        }
    }

    public void na(boolean z) {
        if (this.hsb != null) {
            this.hsb.setVisibility(z ? 0 : 8);
        }
    }

    public void nb(boolean z) {
        if (z) {
            this.hsb.turnOn();
        } else {
            this.hsb.turnOff();
        }
    }

    public void bRY() {
        if (this.hsg != null) {
            this.hsg.setVisibility(0);
        }
    }

    public void bRZ() {
        if (this.hsf != null) {
            this.hsf.setVisibility(0);
        }
    }

    public void bsb() {
        if (this.hsd != null) {
            this.hsd.setVisibility(0);
        }
    }

    public void bSa() {
        if (this.hsd != null) {
            this.hsd.setVisibility(8);
        }
    }

    public BdSwitchView bSb() {
        return this.hsb.getSwitchView();
    }

    public BdSwitchView bSc() {
        return this.hsa.getSwitchView();
    }

    public void bSd() {
        if (this.hsh == null) {
            this.hsh = new com.baidu.tbadk.core.dialog.a(this.hrW.getPageContext().getPageActivity());
            this.hsh.jW(R.string.group_dismiss_alert);
            this.hsh.fG(false);
            this.hsh.a(R.string.alert_yes_button, this.hrW);
            this.hsh.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hsh.b(this.hrW.getPageContext());
        }
        this.hsh.aEA();
    }

    public com.baidu.tbadk.core.dialog.a bSe() {
        return this.hsh;
    }

    public void bSf() {
        if (this.hsh != null) {
            this.hsh.dismiss();
            this.hsh = null;
        }
        if (this.hrY != null) {
            this.hrY.dismiss();
            this.hrY = null;
        }
        if (this.hrZ != null) {
            this.hrZ.dismiss();
            this.hrZ = null;
        }
    }
}
