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
    private b.a hrZ;
    private GroupSettingActivity hsk;
    private RelativeLayout hsl;
    private com.baidu.tbadk.core.dialog.b hsm;
    private com.baidu.tbadk.core.dialog.a hsn;
    private SettingTextSwitchView hso;
    private SettingTextSwitchView hsp;
    private TbSettingTextTipView hsq;
    private TbSettingTextTipView hsr;
    private TbSettingTextTipView hss;
    private Button hst;
    private Button hsu;
    private com.baidu.tbadk.core.dialog.a hsv;
    private View hsw;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.hrZ = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.hsk = null;
        this.hsl = null;
        this.hsm = null;
        this.hso = null;
        this.hsp = null;
        this.hsq = null;
        this.hsr = null;
        this.hss = null;
        this.hrZ = null;
        this.hsk = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.hso.me(i);
        this.hsp.me(i);
        this.hsk.getLayoutMode().setNightMode(i == 1);
        this.hsk.getLayoutMode().onModeChanged(this.hsl);
        this.mNavigationBar.onChangeSkinType(this.hsk.getPageContext(), i);
        am.setBackgroundResource(this.hst, R.drawable.big_red_button);
        am.setBackgroundResource(this.hsu, R.drawable.big_red_button);
    }

    public View bRQ() {
        return this.hsw;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hsq.setText(str);
        }
    }

    private void initView() {
        this.hsk.setContentView(R.layout.group_setting_activity);
        this.hso = (SettingTextSwitchView) this.hsk.findViewById(R.id.sv_group_msg_notify);
        this.hsp = (SettingTextSwitchView) this.hsk.findViewById(R.id.sv_group_add_group);
        this.hsq = (TbSettingTextTipView) this.hsk.findViewById(R.id.tv_change_name);
        this.hsr = (TbSettingTextTipView) this.hsk.findViewById(R.id.sv_report);
        this.hss = (TbSettingTextTipView) this.hsk.findViewById(R.id.sv_delete_msg);
        this.hst = (Button) this.hsk.findViewById(R.id.btn_dismiss);
        this.hsu = (Button) this.hsk.findViewById(R.id.btn_quit);
        this.hsl = (RelativeLayout) this.hsk.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hsk.findViewById(R.id.view_navigation_bar);
        this.hsw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.hso.setSwitchStateChangeListener(this.hsk);
        this.hsp.setSwitchStateChangeListener(this.hsk);
        this.hsq.setOnClickListener(this.hsk);
        this.hsr.setOnClickListener(this.hsk);
        this.hst.setOnClickListener(this.hsk);
        this.hsu.setOnClickListener(this.hsk);
        this.hss.setOnClickListener(this.hsk);
    }

    public TbSettingTextTipView bRR() {
        return this.hsq;
    }

    public Button bRS() {
        return this.hsu;
    }

    public Button bRT() {
        return this.hst;
    }

    public TbSettingTextTipView bRU() {
        return this.hsr;
    }

    public TbSettingTextTipView bRV() {
        return this.hss;
    }

    public void bRW() {
        if (this.hsn == null) {
            this.hsn = new com.baidu.tbadk.core.dialog.a(this.hsk.getPageContext().getPageActivity());
            this.hsn.jV(R.string.inform);
            this.hsn.jW(R.string.group_quit_alert);
            this.hsn.fG(false);
            this.hsn.a(R.string.alert_yes_button, this.hsk);
            this.hsn.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hsn.b(this.hsk.getPageContext());
            this.hsn.fH(true);
        }
        this.hsn.aEC();
    }

    public com.baidu.tbadk.core.dialog.a bRX() {
        return this.hsn;
    }

    public void bRY() {
        if (this.hsm == null) {
            this.hsm = new com.baidu.tbadk.core.dialog.b(this.hsk.getPageContext().getPageActivity());
            this.hsm.ka(R.string.group_report);
            this.hsm.a(new CharSequence[]{new SpannableString(this.hsk.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.hsk.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.hsk.getPageContext().getString(R.string.group_report_lllegal))}, this.hrZ);
            this.hsm.d(this.hsk.getPageContext());
        }
        this.hsm.aED();
    }

    public void bRZ() {
        if (this.hsu != null) {
            this.hsu.setVisibility(8);
        }
    }

    public void bSa() {
        if (this.hst != null) {
            this.hst.setVisibility(8);
        }
    }

    public void na(boolean z) {
        if (this.hsp != null) {
            this.hsp.setVisibility(z ? 0 : 8);
        }
    }

    public void nb(boolean z) {
        if (z) {
            this.hsp.turnOn();
        } else {
            this.hsp.turnOff();
        }
    }

    public void bSb() {
        if (this.hsu != null) {
            this.hsu.setVisibility(0);
        }
    }

    public void bSc() {
        if (this.hst != null) {
            this.hst.setVisibility(0);
        }
    }

    public void bse() {
        if (this.hsr != null) {
            this.hsr.setVisibility(0);
        }
    }

    public void bSd() {
        if (this.hsr != null) {
            this.hsr.setVisibility(8);
        }
    }

    public BdSwitchView bSe() {
        return this.hsp.getSwitchView();
    }

    public BdSwitchView bSf() {
        return this.hso.getSwitchView();
    }

    public void bSg() {
        if (this.hsv == null) {
            this.hsv = new com.baidu.tbadk.core.dialog.a(this.hsk.getPageContext().getPageActivity());
            this.hsv.jW(R.string.group_dismiss_alert);
            this.hsv.fG(false);
            this.hsv.a(R.string.alert_yes_button, this.hsk);
            this.hsv.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hsv.b(this.hsk.getPageContext());
        }
        this.hsv.aEC();
    }

    public com.baidu.tbadk.core.dialog.a bSh() {
        return this.hsv;
    }

    public void bSi() {
        if (this.hsv != null) {
            this.hsv.dismiss();
            this.hsv = null;
        }
        if (this.hsm != null) {
            this.hsm.dismiss();
            this.hsm = null;
        }
        if (this.hsn != null) {
            this.hsn.dismiss();
            this.hsn = null;
        }
    }
}
