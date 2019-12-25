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
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private TbSettingTextTipView hmA;
    private TbSettingTextTipView hmB;
    private TbSettingTextTipView hmC;
    private Button hmD;
    private Button hmE;
    private com.baidu.tbadk.core.dialog.a hmF;
    private View hmG;
    private b.a hmj;
    private GroupSettingActivity hmu;
    private RelativeLayout hmv;
    private com.baidu.tbadk.core.dialog.b hmw;
    private com.baidu.tbadk.core.dialog.a hmx;
    private SettingTextSwitchView hmy;
    private SettingTextSwitchView hmz;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.hmj = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.hmu = null;
        this.hmv = null;
        this.hmw = null;
        this.hmy = null;
        this.hmz = null;
        this.hmA = null;
        this.hmB = null;
        this.hmC = null;
        this.hmj = null;
        this.hmu = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.hmy.lM(i);
        this.hmz.lM(i);
        this.hmu.getLayoutMode().setNightMode(i == 1);
        this.hmu.getLayoutMode().onModeChanged(this.hmv);
        this.mNavigationBar.onChangeSkinType(this.hmu.getPageContext(), i);
        am.setBackgroundResource(this.hmD, R.drawable.big_red_button);
        am.setBackgroundResource(this.hmE, R.drawable.big_red_button);
    }

    public View bPd() {
        return this.hmG;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hmA.setText(str);
        }
    }

    private void initView() {
        this.hmu.setContentView(R.layout.group_setting_activity);
        this.hmy = (SettingTextSwitchView) this.hmu.findViewById(R.id.sv_group_msg_notify);
        this.hmz = (SettingTextSwitchView) this.hmu.findViewById(R.id.sv_group_add_group);
        this.hmA = (TbSettingTextTipView) this.hmu.findViewById(R.id.tv_change_name);
        this.hmB = (TbSettingTextTipView) this.hmu.findViewById(R.id.sv_report);
        this.hmC = (TbSettingTextTipView) this.hmu.findViewById(R.id.sv_delete_msg);
        this.hmD = (Button) this.hmu.findViewById(R.id.btn_dismiss);
        this.hmE = (Button) this.hmu.findViewById(R.id.btn_quit);
        this.hmv = (RelativeLayout) this.hmu.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hmu.findViewById(R.id.view_navigation_bar);
        this.hmG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.hmy.setSwitchStateChangeListener(this.hmu);
        this.hmz.setSwitchStateChangeListener(this.hmu);
        this.hmA.setOnClickListener(this.hmu);
        this.hmB.setOnClickListener(this.hmu);
        this.hmD.setOnClickListener(this.hmu);
        this.hmE.setOnClickListener(this.hmu);
        this.hmC.setOnClickListener(this.hmu);
    }

    public TbSettingTextTipView bPe() {
        return this.hmA;
    }

    public Button bPf() {
        return this.hmE;
    }

    public Button bPg() {
        return this.hmD;
    }

    public TbSettingTextTipView bPh() {
        return this.hmB;
    }

    public TbSettingTextTipView bPi() {
        return this.hmC;
    }

    public void bPj() {
        if (this.hmx == null) {
            this.hmx = new com.baidu.tbadk.core.dialog.a(this.hmu.getPageContext().getPageActivity());
            this.hmx.jE(R.string.inform);
            this.hmx.jF(R.string.group_quit_alert);
            this.hmx.fu(false);
            this.hmx.a(R.string.alert_yes_button, this.hmu);
            this.hmx.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hmx.b(this.hmu.getPageContext());
            this.hmx.fv(true);
        }
        this.hmx.aBW();
    }

    public com.baidu.tbadk.core.dialog.a bPk() {
        return this.hmx;
    }

    public void bPl() {
        if (this.hmw == null) {
            this.hmw = new com.baidu.tbadk.core.dialog.b(this.hmu.getPageContext().getPageActivity());
            this.hmw.jJ(R.string.group_report);
            this.hmw.a(new CharSequence[]{new SpannableString(this.hmu.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.hmu.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.hmu.getPageContext().getString(R.string.group_report_lllegal))}, this.hmj);
            this.hmw.d(this.hmu.getPageContext());
        }
        this.hmw.aBX();
    }

    public void bPm() {
        if (this.hmE != null) {
            this.hmE.setVisibility(8);
        }
    }

    public void bPn() {
        if (this.hmD != null) {
            this.hmD.setVisibility(8);
        }
    }

    public void mM(boolean z) {
        if (this.hmz != null) {
            this.hmz.setVisibility(z ? 0 : 8);
        }
    }

    public void mN(boolean z) {
        if (z) {
            this.hmz.turnOn();
        } else {
            this.hmz.turnOff();
        }
    }

    public void bPo() {
        if (this.hmE != null) {
            this.hmE.setVisibility(0);
        }
    }

    public void bPp() {
        if (this.hmD != null) {
            this.hmD.setVisibility(0);
        }
    }

    public void bpw() {
        if (this.hmB != null) {
            this.hmB.setVisibility(0);
        }
    }

    public void bPq() {
        if (this.hmB != null) {
            this.hmB.setVisibility(8);
        }
    }

    public BdSwitchView bPr() {
        return this.hmz.getSwitchView();
    }

    public BdSwitchView bPs() {
        return this.hmy.getSwitchView();
    }

    public void bPt() {
        if (this.hmF == null) {
            this.hmF = new com.baidu.tbadk.core.dialog.a(this.hmu.getPageContext().getPageActivity());
            this.hmF.jF(R.string.group_dismiss_alert);
            this.hmF.fu(false);
            this.hmF.a(R.string.alert_yes_button, this.hmu);
            this.hmF.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hmF.b(this.hmu.getPageContext());
        }
        this.hmF.aBW();
    }

    public com.baidu.tbadk.core.dialog.a bPu() {
        return this.hmF;
    }

    public void bPv() {
        if (this.hmF != null) {
            this.hmF.dismiss();
            this.hmF = null;
        }
        if (this.hmw != null) {
            this.hmw.dismiss();
            this.hmw = null;
        }
        if (this.hmx != null) {
            this.hmx.dismiss();
            this.hmx = null;
        }
    }
}
