package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.a grW;
    private GroupSettingActivity gsi;
    private com.baidu.tbadk.core.dialog.b gsj;
    private com.baidu.tbadk.core.dialog.a gsk;
    private SettingTextSwitchView gsl;
    private SettingTextSwitchView gsm;
    private TbSettingTextTipView gsn;
    private TbSettingTextTipView gso;
    private TbSettingTextTipView gsp;
    private Button gsq;
    private Button gsr;
    private com.baidu.tbadk.core.dialog.a gss;
    private View gst;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.a aVar) {
        this.grW = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gsi = null;
        this.mParent = null;
        this.gsj = null;
        this.gsl = null;
        this.gsm = null;
        this.gsn = null;
        this.gso = null;
        this.gsp = null;
        this.grW = null;
        this.gsi = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gsl.jT(i);
        this.gsm.jT(i);
        this.gsi.getLayoutMode().setNightMode(i == 1);
        this.gsi.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gsi.getPageContext(), i);
        al.k(this.gsq, R.drawable.big_red_button);
        al.k(this.gsr, R.drawable.big_red_button);
    }

    public View bxt() {
        return this.gst;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gsn.setText(str);
        }
    }

    private void initView() {
        this.gsi.setContentView(R.layout.group_setting_activity);
        this.gsl = (SettingTextSwitchView) this.gsi.findViewById(R.id.sv_group_msg_notify);
        this.gsm = (SettingTextSwitchView) this.gsi.findViewById(R.id.sv_group_add_group);
        this.gsn = (TbSettingTextTipView) this.gsi.findViewById(R.id.tv_change_name);
        this.gso = (TbSettingTextTipView) this.gsi.findViewById(R.id.sv_report);
        this.gsp = (TbSettingTextTipView) this.gsi.findViewById(R.id.sv_delete_msg);
        this.gsq = (Button) this.gsi.findViewById(R.id.btn_dismiss);
        this.gsr = (Button) this.gsi.findViewById(R.id.btn_quit);
        this.mParent = (RelativeLayout) this.gsi.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gsi.findViewById(R.id.view_navigation_bar);
        this.gst = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.gsl.setSwitchStateChangeListener(this.gsi);
        this.gsm.setSwitchStateChangeListener(this.gsi);
        this.gsn.setOnClickListener(this.gsi);
        this.gso.setOnClickListener(this.gsi);
        this.gsq.setOnClickListener(this.gsi);
        this.gsr.setOnClickListener(this.gsi);
        this.gsp.setOnClickListener(this.gsi);
    }

    public TbSettingTextTipView bxu() {
        return this.gsn;
    }

    public Button bxv() {
        return this.gsr;
    }

    public Button bxw() {
        return this.gsq;
    }

    public TbSettingTextTipView bxx() {
        return this.gso;
    }

    public TbSettingTextTipView bxy() {
        return this.gsp;
    }

    public void bxz() {
        if (this.gsk == null) {
            this.gsk = new com.baidu.tbadk.core.dialog.a(this.gsi.getPageContext().getPageActivity());
            this.gsk.hn(R.string.inform);
            this.gsk.ho(R.string.group_quit_alert);
            this.gsk.dM(false);
            this.gsk.a(R.string.alert_yes_button, this.gsi);
            this.gsk.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gsk.b(this.gsi.getPageContext());
            this.gsk.dN(true);
        }
        this.gsk.afG();
    }

    public com.baidu.tbadk.core.dialog.a bxA() {
        return this.gsk;
    }

    public void ajV() {
        if (this.gsj == null) {
            this.gsj = new com.baidu.tbadk.core.dialog.b(this.gsi.getPageContext().getPageActivity());
            this.gsj.hs(R.string.group_report);
            this.gsj.a(new CharSequence[]{new SpannableString(this.gsi.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.gsi.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.gsi.getPageContext().getString(R.string.group_report_lllegal))}, this.grW);
            this.gsj.d(this.gsi.getPageContext());
        }
        this.gsj.afJ();
    }

    public void bxB() {
        if (this.gsr != null) {
            this.gsr.setVisibility(8);
        }
    }

    public void bxC() {
        if (this.gsq != null) {
            this.gsq.setVisibility(8);
        }
    }

    public void ls(boolean z) {
        if (this.gsm != null) {
            this.gsm.setVisibility(z ? 0 : 8);
        }
    }

    public void lt(boolean z) {
        if (z) {
            this.gsm.mV();
        } else {
            this.gsm.mW();
        }
    }

    public void bxD() {
        if (this.gsr != null) {
            this.gsr.setVisibility(0);
        }
    }

    public void bxE() {
        if (this.gsq != null) {
            this.gsq.setVisibility(0);
        }
    }

    public void aUo() {
        if (this.gso != null) {
            this.gso.setVisibility(0);
        }
    }

    public void bxF() {
        if (this.gso != null) {
            this.gso.setVisibility(8);
        }
    }

    public BdSwitchView bxG() {
        return this.gsm.getSwitchView();
    }

    public BdSwitchView bxH() {
        return this.gsl.getSwitchView();
    }

    public void bxI() {
        if (this.gss == null) {
            this.gss = new com.baidu.tbadk.core.dialog.a(this.gsi.getPageContext().getPageActivity());
            this.gss.ho(R.string.group_dismiss_alert);
            this.gss.dM(false);
            this.gss.a(R.string.alert_yes_button, this.gsi);
            this.gss.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gss.b(this.gsi.getPageContext());
        }
        this.gss.afG();
    }

    public com.baidu.tbadk.core.dialog.a bxJ() {
        return this.gss;
    }

    public void bxK() {
        if (this.gss != null) {
            this.gss.dismiss();
            this.gss = null;
        }
        if (this.gsj != null) {
            this.gsj.dismiss();
            this.gsj = null;
        }
        if (this.gsk != null) {
            this.gsk.dismiss();
            this.gsk = null;
        }
    }
}
