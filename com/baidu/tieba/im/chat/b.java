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
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.a hpM;
    private GroupSettingActivity hpX;
    private RelativeLayout hpY;
    private com.baidu.tbadk.core.dialog.b hpZ;
    private com.baidu.tbadk.core.dialog.a hqa;
    private SettingTextSwitchView hqb;
    private SettingTextSwitchView hqc;
    private TbSettingTextTipView hqd;
    private TbSettingTextTipView hqe;
    private TbSettingTextTipView hqf;
    private Button hqg;
    private Button hqh;
    private com.baidu.tbadk.core.dialog.a hqi;
    private View hqj;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.hpM = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.hpX = null;
        this.hpY = null;
        this.hpZ = null;
        this.hqb = null;
        this.hqc = null;
        this.hqd = null;
        this.hqe = null;
        this.hqf = null;
        this.hpM = null;
        this.hpX = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.hqb.lM(i);
        this.hqc.lM(i);
        this.hpX.getLayoutMode().setNightMode(i == 1);
        this.hpX.getLayoutMode().onModeChanged(this.hpY);
        this.mNavigationBar.onChangeSkinType(this.hpX.getPageContext(), i);
        am.setBackgroundResource(this.hqg, R.drawable.big_red_button);
        am.setBackgroundResource(this.hqh, R.drawable.big_red_button);
    }

    public View bQm() {
        return this.hqj;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hqd.setText(str);
        }
    }

    private void initView() {
        this.hpX.setContentView(R.layout.group_setting_activity);
        this.hqb = (SettingTextSwitchView) this.hpX.findViewById(R.id.sv_group_msg_notify);
        this.hqc = (SettingTextSwitchView) this.hpX.findViewById(R.id.sv_group_add_group);
        this.hqd = (TbSettingTextTipView) this.hpX.findViewById(R.id.tv_change_name);
        this.hqe = (TbSettingTextTipView) this.hpX.findViewById(R.id.sv_report);
        this.hqf = (TbSettingTextTipView) this.hpX.findViewById(R.id.sv_delete_msg);
        this.hqg = (Button) this.hpX.findViewById(R.id.btn_dismiss);
        this.hqh = (Button) this.hpX.findViewById(R.id.btn_quit);
        this.hpY = (RelativeLayout) this.hpX.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hpX.findViewById(R.id.view_navigation_bar);
        this.hqj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.hqb.setSwitchStateChangeListener(this.hpX);
        this.hqc.setSwitchStateChangeListener(this.hpX);
        this.hqd.setOnClickListener(this.hpX);
        this.hqe.setOnClickListener(this.hpX);
        this.hqg.setOnClickListener(this.hpX);
        this.hqh.setOnClickListener(this.hpX);
        this.hqf.setOnClickListener(this.hpX);
    }

    public TbSettingTextTipView bQn() {
        return this.hqd;
    }

    public Button bQo() {
        return this.hqh;
    }

    public Button bQp() {
        return this.hqg;
    }

    public TbSettingTextTipView bQq() {
        return this.hqe;
    }

    public TbSettingTextTipView bQr() {
        return this.hqf;
    }

    public void bQs() {
        if (this.hqa == null) {
            this.hqa = new com.baidu.tbadk.core.dialog.a(this.hpX.getPageContext().getPageActivity());
            this.hqa.jE(R.string.inform);
            this.hqa.jF(R.string.group_quit_alert);
            this.hqa.fz(false);
            this.hqa.a(R.string.alert_yes_button, this.hpX);
            this.hqa.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hqa.b(this.hpX.getPageContext());
            this.hqa.fA(true);
        }
        this.hqa.aCp();
    }

    public com.baidu.tbadk.core.dialog.a bQt() {
        return this.hqa;
    }

    public void bQu() {
        if (this.hpZ == null) {
            this.hpZ = new com.baidu.tbadk.core.dialog.b(this.hpX.getPageContext().getPageActivity());
            this.hpZ.jJ(R.string.group_report);
            this.hpZ.a(new CharSequence[]{new SpannableString(this.hpX.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.hpX.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.hpX.getPageContext().getString(R.string.group_report_lllegal))}, this.hpM);
            this.hpZ.d(this.hpX.getPageContext());
        }
        this.hpZ.aCq();
    }

    public void bQv() {
        if (this.hqh != null) {
            this.hqh.setVisibility(8);
        }
    }

    public void bQw() {
        if (this.hqg != null) {
            this.hqg.setVisibility(8);
        }
    }

    public void mY(boolean z) {
        if (this.hqc != null) {
            this.hqc.setVisibility(z ? 0 : 8);
        }
    }

    public void mZ(boolean z) {
        if (z) {
            this.hqc.turnOn();
        } else {
            this.hqc.turnOff();
        }
    }

    public void bQx() {
        if (this.hqh != null) {
            this.hqh.setVisibility(0);
        }
    }

    public void bQy() {
        if (this.hqg != null) {
            this.hqg.setVisibility(0);
        }
    }

    public void bqx() {
        if (this.hqe != null) {
            this.hqe.setVisibility(0);
        }
    }

    public void bQz() {
        if (this.hqe != null) {
            this.hqe.setVisibility(8);
        }
    }

    public BdSwitchView bQA() {
        return this.hqc.getSwitchView();
    }

    public BdSwitchView bQB() {
        return this.hqb.getSwitchView();
    }

    public void bQC() {
        if (this.hqi == null) {
            this.hqi = new com.baidu.tbadk.core.dialog.a(this.hpX.getPageContext().getPageActivity());
            this.hqi.jF(R.string.group_dismiss_alert);
            this.hqi.fz(false);
            this.hqi.a(R.string.alert_yes_button, this.hpX);
            this.hqi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hqi.b(this.hpX.getPageContext());
        }
        this.hqi.aCp();
    }

    public com.baidu.tbadk.core.dialog.a bQD() {
        return this.hqi;
    }

    public void bQE() {
        if (this.hqi != null) {
            this.hqi.dismiss();
            this.hqi = null;
        }
        if (this.hpZ != null) {
            this.hpZ.dismiss();
            this.hpZ = null;
        }
        if (this.hqa != null) {
            this.hqa.dismiss();
            this.hqa = null;
        }
    }
}
