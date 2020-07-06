package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.a iJU;
    private GroupSettingActivity iKf;
    private RelativeLayout iKg;
    private com.baidu.tbadk.core.dialog.b iKh;
    private com.baidu.tbadk.core.dialog.a iKi;
    private SettingTextSwitchView iKj;
    private SettingTextSwitchView iKk;
    private TbSettingTextTipView iKl;
    private TbSettingTextTipView iKm;
    private TbSettingTextTipView iKn;
    private Button iKo;
    private Button iKp;
    private com.baidu.tbadk.core.dialog.a iKq;
    private View iKr;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.iJU = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.iKf = null;
        this.iKg = null;
        this.iKh = null;
        this.iKj = null;
        this.iKk = null;
        this.iKl = null;
        this.iKm = null;
        this.iKn = null;
        this.iJU = null;
        this.iKf = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.iKj.nq(i);
        this.iKk.nq(i);
        this.iKf.getLayoutMode().setNightMode(i == 1);
        this.iKf.getLayoutMode().onModeChanged(this.iKg);
        this.mNavigationBar.onChangeSkinType(this.iKf.getPageContext(), i);
        an.setBackgroundResource(this.iKo, R.drawable.big_red_button);
        an.setBackgroundResource(this.iKp, R.drawable.big_red_button);
    }

    public View cnd() {
        return this.iKr;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iKl.setText(str);
        }
    }

    private void initView() {
        this.iKf.setContentView(R.layout.group_setting_activity);
        this.iKj = (SettingTextSwitchView) this.iKf.findViewById(R.id.sv_group_msg_notify);
        this.iKk = (SettingTextSwitchView) this.iKf.findViewById(R.id.sv_group_add_group);
        this.iKl = (TbSettingTextTipView) this.iKf.findViewById(R.id.tv_change_name);
        this.iKm = (TbSettingTextTipView) this.iKf.findViewById(R.id.sv_report);
        this.iKn = (TbSettingTextTipView) this.iKf.findViewById(R.id.sv_delete_msg);
        this.iKo = (Button) this.iKf.findViewById(R.id.btn_dismiss);
        this.iKp = (Button) this.iKf.findViewById(R.id.btn_quit);
        this.iKg = (RelativeLayout) this.iKf.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.iKf.findViewById(R.id.view_navigation_bar);
        this.iKr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.iKj.setSwitchStateChangeListener(this.iKf);
        this.iKk.setSwitchStateChangeListener(this.iKf);
        this.iKl.setOnClickListener(this.iKf);
        this.iKm.setOnClickListener(this.iKf);
        this.iKo.setOnClickListener(this.iKf);
        this.iKp.setOnClickListener(this.iKf);
        this.iKn.setOnClickListener(this.iKf);
    }

    public TbSettingTextTipView cne() {
        return this.iKl;
    }

    public Button cnf() {
        return this.iKp;
    }

    public Button cng() {
        return this.iKo;
    }

    public TbSettingTextTipView cnh() {
        return this.iKm;
    }

    public TbSettingTextTipView cni() {
        return this.iKn;
    }

    public void cnj() {
        if (this.iKi == null) {
            this.iKi = new com.baidu.tbadk.core.dialog.a(this.iKf.getPageContext().getPageActivity());
            this.iKi.kS(R.string.inform);
            this.iKi.kT(R.string.group_quit_alert);
            this.iKi.hf(false);
            this.iKi.a(R.string.alert_yes_button, this.iKf);
            this.iKi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iKi.b(this.iKf.getPageContext());
            this.iKi.hg(true);
        }
        this.iKi.aUN();
    }

    public com.baidu.tbadk.core.dialog.a cnk() {
        return this.iKi;
    }

    public void cnl() {
        if (this.iKh == null) {
            this.iKh = new com.baidu.tbadk.core.dialog.b(this.iKf.getPageContext().getPageActivity());
            this.iKh.kX(R.string.group_report);
            this.iKh.a(new CharSequence[]{new SpannableString(this.iKf.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.iKf.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.iKf.getPageContext().getString(R.string.group_report_lllegal))}, this.iJU);
            this.iKh.d(this.iKf.getPageContext());
        }
        this.iKh.aUO();
    }

    public void cnm() {
        if (this.iKp != null) {
            this.iKp.setVisibility(8);
        }
    }

    public void cnn() {
        if (this.iKo != null) {
            this.iKo.setVisibility(8);
        }
    }

    public void oQ(boolean z) {
        if (this.iKk != null) {
            this.iKk.setVisibility(z ? 0 : 8);
        }
    }

    public void oR(boolean z) {
        if (z) {
            this.iKk.turnOn();
        } else {
            this.iKk.turnOff();
        }
    }

    public void cno() {
        if (this.iKp != null) {
            this.iKp.setVisibility(0);
        }
    }

    public void cnp() {
        if (this.iKo != null) {
            this.iKo.setVisibility(0);
        }
    }

    public void bLn() {
        if (this.iKm != null) {
            this.iKm.setVisibility(0);
        }
    }

    public void cnq() {
        if (this.iKm != null) {
            this.iKm.setVisibility(8);
        }
    }

    public BdSwitchView cnr() {
        return this.iKk.getSwitchView();
    }

    public BdSwitchView cns() {
        return this.iKj.getSwitchView();
    }

    public void cnt() {
        if (this.iKq == null) {
            this.iKq = new com.baidu.tbadk.core.dialog.a(this.iKf.getPageContext().getPageActivity());
            this.iKq.kT(R.string.group_dismiss_alert);
            this.iKq.hf(false);
            this.iKq.a(R.string.alert_yes_button, this.iKf);
            this.iKq.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iKq.b(this.iKf.getPageContext());
        }
        this.iKq.aUN();
    }

    public com.baidu.tbadk.core.dialog.a cnu() {
        return this.iKq;
    }

    public void cnv() {
        if (this.iKq != null) {
            this.iKq.dismiss();
            this.iKq = null;
        }
        if (this.iKh != null) {
            this.iKh.dismiss();
            this.iKh = null;
        }
        if (this.iKi != null) {
            this.iKi.dismiss();
            this.iKi = null;
        }
    }
}
