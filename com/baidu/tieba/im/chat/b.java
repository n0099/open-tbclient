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
    private b.a isb;
    private GroupSettingActivity ism;
    private RelativeLayout isn;
    private com.baidu.tbadk.core.dialog.b iso;
    private com.baidu.tbadk.core.dialog.a isp;
    private SettingTextSwitchView isq;
    private SettingTextSwitchView isr;
    private TbSettingTextTipView iss;
    private TbSettingTextTipView ist;
    private TbSettingTextTipView isu;
    private Button isv;
    private Button isw;
    private com.baidu.tbadk.core.dialog.a isx;
    private View isy;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.isb = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.ism = null;
        this.isn = null;
        this.iso = null;
        this.isq = null;
        this.isr = null;
        this.iss = null;
        this.ist = null;
        this.isu = null;
        this.isb = null;
        this.ism = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.isq.mU(i);
        this.isr.mU(i);
        this.ism.getLayoutMode().setNightMode(i == 1);
        this.ism.getLayoutMode().onModeChanged(this.isn);
        this.mNavigationBar.onChangeSkinType(this.ism.getPageContext(), i);
        am.setBackgroundResource(this.isv, R.drawable.big_red_button);
        am.setBackgroundResource(this.isw, R.drawable.big_red_button);
    }

    public View cje() {
        return this.isy;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iss.setText(str);
        }
    }

    private void initView() {
        this.ism.setContentView(R.layout.group_setting_activity);
        this.isq = (SettingTextSwitchView) this.ism.findViewById(R.id.sv_group_msg_notify);
        this.isr = (SettingTextSwitchView) this.ism.findViewById(R.id.sv_group_add_group);
        this.iss = (TbSettingTextTipView) this.ism.findViewById(R.id.tv_change_name);
        this.ist = (TbSettingTextTipView) this.ism.findViewById(R.id.sv_report);
        this.isu = (TbSettingTextTipView) this.ism.findViewById(R.id.sv_delete_msg);
        this.isv = (Button) this.ism.findViewById(R.id.btn_dismiss);
        this.isw = (Button) this.ism.findViewById(R.id.btn_quit);
        this.isn = (RelativeLayout) this.ism.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.ism.findViewById(R.id.view_navigation_bar);
        this.isy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.isq.setSwitchStateChangeListener(this.ism);
        this.isr.setSwitchStateChangeListener(this.ism);
        this.iss.setOnClickListener(this.ism);
        this.ist.setOnClickListener(this.ism);
        this.isv.setOnClickListener(this.ism);
        this.isw.setOnClickListener(this.ism);
        this.isu.setOnClickListener(this.ism);
    }

    public TbSettingTextTipView cjf() {
        return this.iss;
    }

    public Button cjg() {
        return this.isw;
    }

    public Button cjh() {
        return this.isv;
    }

    public TbSettingTextTipView cji() {
        return this.ist;
    }

    public TbSettingTextTipView cjj() {
        return this.isu;
    }

    public void cjk() {
        if (this.isp == null) {
            this.isp = new com.baidu.tbadk.core.dialog.a(this.ism.getPageContext().getPageActivity());
            this.isp.kC(R.string.inform);
            this.isp.kD(R.string.group_quit_alert);
            this.isp.gW(false);
            this.isp.a(R.string.alert_yes_button, this.ism);
            this.isp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.isp.b(this.ism.getPageContext());
            this.isp.gX(true);
        }
        this.isp.aST();
    }

    public com.baidu.tbadk.core.dialog.a cjl() {
        return this.isp;
    }

    public void cjm() {
        if (this.iso == null) {
            this.iso = new com.baidu.tbadk.core.dialog.b(this.ism.getPageContext().getPageActivity());
            this.iso.kH(R.string.group_report);
            this.iso.a(new CharSequence[]{new SpannableString(this.ism.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.ism.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.ism.getPageContext().getString(R.string.group_report_lllegal))}, this.isb);
            this.iso.d(this.ism.getPageContext());
        }
        this.iso.aSU();
    }

    public void cjn() {
        if (this.isw != null) {
            this.isw.setVisibility(8);
        }
    }

    public void cjo() {
        if (this.isv != null) {
            this.isv.setVisibility(8);
        }
    }

    public void oG(boolean z) {
        if (this.isr != null) {
            this.isr.setVisibility(z ? 0 : 8);
        }
    }

    public void oH(boolean z) {
        if (z) {
            this.isr.turnOn();
        } else {
            this.isr.turnOff();
        }
    }

    public void cjp() {
        if (this.isw != null) {
            this.isw.setVisibility(0);
        }
    }

    public void cjq() {
        if (this.isv != null) {
            this.isv.setVisibility(0);
        }
    }

    public void bIg() {
        if (this.ist != null) {
            this.ist.setVisibility(0);
        }
    }

    public void cjr() {
        if (this.ist != null) {
            this.ist.setVisibility(8);
        }
    }

    public BdSwitchView cjs() {
        return this.isr.getSwitchView();
    }

    public BdSwitchView cjt() {
        return this.isq.getSwitchView();
    }

    public void cju() {
        if (this.isx == null) {
            this.isx = new com.baidu.tbadk.core.dialog.a(this.ism.getPageContext().getPageActivity());
            this.isx.kD(R.string.group_dismiss_alert);
            this.isx.gW(false);
            this.isx.a(R.string.alert_yes_button, this.ism);
            this.isx.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.isx.b(this.ism.getPageContext());
        }
        this.isx.aST();
    }

    public com.baidu.tbadk.core.dialog.a cjv() {
        return this.isx;
    }

    public void cjw() {
        if (this.isx != null) {
            this.isx.dismiss();
            this.isx = null;
        }
        if (this.iso != null) {
            this.iso.dismiss();
            this.iso = null;
        }
        if (this.isp != null) {
            this.isp.dismiss();
            this.isp = null;
        }
    }
}
