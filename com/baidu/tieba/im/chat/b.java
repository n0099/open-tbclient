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
    private b.a hrN;
    private GroupSettingActivity hrY;
    private RelativeLayout hrZ;
    private com.baidu.tbadk.core.dialog.b hsa;
    private com.baidu.tbadk.core.dialog.a hsb;
    private SettingTextSwitchView hsc;
    private SettingTextSwitchView hsd;
    private TbSettingTextTipView hse;
    private TbSettingTextTipView hsf;
    private TbSettingTextTipView hsg;
    private Button hsh;
    private Button hsi;
    private com.baidu.tbadk.core.dialog.a hsj;
    private View hsk;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.hrN = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.hrY = null;
        this.hrZ = null;
        this.hsa = null;
        this.hsc = null;
        this.hsd = null;
        this.hse = null;
        this.hsf = null;
        this.hsg = null;
        this.hrN = null;
        this.hrY = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.hsc.me(i);
        this.hsd.me(i);
        this.hrY.getLayoutMode().setNightMode(i == 1);
        this.hrY.getLayoutMode().onModeChanged(this.hrZ);
        this.mNavigationBar.onChangeSkinType(this.hrY.getPageContext(), i);
        am.setBackgroundResource(this.hsh, R.drawable.big_red_button);
        am.setBackgroundResource(this.hsi, R.drawable.big_red_button);
    }

    public View bRP() {
        return this.hsk;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hse.setText(str);
        }
    }

    private void initView() {
        this.hrY.setContentView(R.layout.group_setting_activity);
        this.hsc = (SettingTextSwitchView) this.hrY.findViewById(R.id.sv_group_msg_notify);
        this.hsd = (SettingTextSwitchView) this.hrY.findViewById(R.id.sv_group_add_group);
        this.hse = (TbSettingTextTipView) this.hrY.findViewById(R.id.tv_change_name);
        this.hsf = (TbSettingTextTipView) this.hrY.findViewById(R.id.sv_report);
        this.hsg = (TbSettingTextTipView) this.hrY.findViewById(R.id.sv_delete_msg);
        this.hsh = (Button) this.hrY.findViewById(R.id.btn_dismiss);
        this.hsi = (Button) this.hrY.findViewById(R.id.btn_quit);
        this.hrZ = (RelativeLayout) this.hrY.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hrY.findViewById(R.id.view_navigation_bar);
        this.hsk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.hsc.setSwitchStateChangeListener(this.hrY);
        this.hsd.setSwitchStateChangeListener(this.hrY);
        this.hse.setOnClickListener(this.hrY);
        this.hsf.setOnClickListener(this.hrY);
        this.hsh.setOnClickListener(this.hrY);
        this.hsi.setOnClickListener(this.hrY);
        this.hsg.setOnClickListener(this.hrY);
    }

    public TbSettingTextTipView bRQ() {
        return this.hse;
    }

    public Button bRR() {
        return this.hsi;
    }

    public Button bRS() {
        return this.hsh;
    }

    public TbSettingTextTipView bRT() {
        return this.hsf;
    }

    public TbSettingTextTipView bRU() {
        return this.hsg;
    }

    public void bRV() {
        if (this.hsb == null) {
            this.hsb = new com.baidu.tbadk.core.dialog.a(this.hrY.getPageContext().getPageActivity());
            this.hsb.jV(R.string.inform);
            this.hsb.jW(R.string.group_quit_alert);
            this.hsb.fG(false);
            this.hsb.a(R.string.alert_yes_button, this.hrY);
            this.hsb.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hsb.b(this.hrY.getPageContext());
            this.hsb.fH(true);
        }
        this.hsb.aEC();
    }

    public com.baidu.tbadk.core.dialog.a bRW() {
        return this.hsb;
    }

    public void bRX() {
        if (this.hsa == null) {
            this.hsa = new com.baidu.tbadk.core.dialog.b(this.hrY.getPageContext().getPageActivity());
            this.hsa.ka(R.string.group_report);
            this.hsa.a(new CharSequence[]{new SpannableString(this.hrY.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.hrY.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.hrY.getPageContext().getString(R.string.group_report_lllegal))}, this.hrN);
            this.hsa.d(this.hrY.getPageContext());
        }
        this.hsa.aED();
    }

    public void bRY() {
        if (this.hsi != null) {
            this.hsi.setVisibility(8);
        }
    }

    public void bRZ() {
        if (this.hsh != null) {
            this.hsh.setVisibility(8);
        }
    }

    public void na(boolean z) {
        if (this.hsd != null) {
            this.hsd.setVisibility(z ? 0 : 8);
        }
    }

    public void nb(boolean z) {
        if (z) {
            this.hsd.turnOn();
        } else {
            this.hsd.turnOff();
        }
    }

    public void bSa() {
        if (this.hsi != null) {
            this.hsi.setVisibility(0);
        }
    }

    public void bSb() {
        if (this.hsh != null) {
            this.hsh.setVisibility(0);
        }
    }

    public void bsd() {
        if (this.hsf != null) {
            this.hsf.setVisibility(0);
        }
    }

    public void bSc() {
        if (this.hsf != null) {
            this.hsf.setVisibility(8);
        }
    }

    public BdSwitchView bSd() {
        return this.hsd.getSwitchView();
    }

    public BdSwitchView bSe() {
        return this.hsc.getSwitchView();
    }

    public void bSf() {
        if (this.hsj == null) {
            this.hsj = new com.baidu.tbadk.core.dialog.a(this.hrY.getPageContext().getPageActivity());
            this.hsj.jW(R.string.group_dismiss_alert);
            this.hsj.fG(false);
            this.hsj.a(R.string.alert_yes_button, this.hrY);
            this.hsj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hsj.b(this.hrY.getPageContext());
        }
        this.hsj.aEC();
    }

    public com.baidu.tbadk.core.dialog.a bSg() {
        return this.hsj;
    }

    public void bSh() {
        if (this.hsj != null) {
            this.hsj.dismiss();
            this.hsj = null;
        }
        if (this.hsa != null) {
            this.hsa.dismiss();
            this.hsa = null;
        }
        if (this.hsb != null) {
            this.hsb.dismiss();
            this.hsb = null;
        }
    }
}
