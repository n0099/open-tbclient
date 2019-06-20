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
    private b.a grZ;
    private GroupSettingActivity gsl;
    private com.baidu.tbadk.core.dialog.b gsm;
    private com.baidu.tbadk.core.dialog.a gsn;
    private SettingTextSwitchView gso;
    private SettingTextSwitchView gsp;
    private TbSettingTextTipView gsq;
    private TbSettingTextTipView gsr;
    private TbSettingTextTipView gss;
    private Button gst;
    private Button gsu;
    private com.baidu.tbadk.core.dialog.a gsv;
    private View gsw;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.a aVar) {
        this.grZ = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gsl = null;
        this.mParent = null;
        this.gsm = null;
        this.gso = null;
        this.gsp = null;
        this.gsq = null;
        this.gsr = null;
        this.gss = null;
        this.grZ = null;
        this.gsl = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gso.jT(i);
        this.gsp.jT(i);
        this.gsl.getLayoutMode().setNightMode(i == 1);
        this.gsl.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gsl.getPageContext(), i);
        al.k(this.gst, R.drawable.big_red_button);
        al.k(this.gsu, R.drawable.big_red_button);
    }

    public View bxx() {
        return this.gsw;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gsq.setText(str);
        }
    }

    private void initView() {
        this.gsl.setContentView(R.layout.group_setting_activity);
        this.gso = (SettingTextSwitchView) this.gsl.findViewById(R.id.sv_group_msg_notify);
        this.gsp = (SettingTextSwitchView) this.gsl.findViewById(R.id.sv_group_add_group);
        this.gsq = (TbSettingTextTipView) this.gsl.findViewById(R.id.tv_change_name);
        this.gsr = (TbSettingTextTipView) this.gsl.findViewById(R.id.sv_report);
        this.gss = (TbSettingTextTipView) this.gsl.findViewById(R.id.sv_delete_msg);
        this.gst = (Button) this.gsl.findViewById(R.id.btn_dismiss);
        this.gsu = (Button) this.gsl.findViewById(R.id.btn_quit);
        this.mParent = (RelativeLayout) this.gsl.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gsl.findViewById(R.id.view_navigation_bar);
        this.gsw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.gso.setSwitchStateChangeListener(this.gsl);
        this.gsp.setSwitchStateChangeListener(this.gsl);
        this.gsq.setOnClickListener(this.gsl);
        this.gsr.setOnClickListener(this.gsl);
        this.gst.setOnClickListener(this.gsl);
        this.gsu.setOnClickListener(this.gsl);
        this.gss.setOnClickListener(this.gsl);
    }

    public TbSettingTextTipView bxy() {
        return this.gsq;
    }

    public Button bxz() {
        return this.gsu;
    }

    public Button bxA() {
        return this.gst;
    }

    public TbSettingTextTipView bxB() {
        return this.gsr;
    }

    public TbSettingTextTipView bxC() {
        return this.gss;
    }

    public void bxD() {
        if (this.gsn == null) {
            this.gsn = new com.baidu.tbadk.core.dialog.a(this.gsl.getPageContext().getPageActivity());
            this.gsn.hn(R.string.inform);
            this.gsn.ho(R.string.group_quit_alert);
            this.gsn.dM(false);
            this.gsn.a(R.string.alert_yes_button, this.gsl);
            this.gsn.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gsn.b(this.gsl.getPageContext());
            this.gsn.dN(true);
        }
        this.gsn.afG();
    }

    public com.baidu.tbadk.core.dialog.a bxE() {
        return this.gsn;
    }

    public void ajV() {
        if (this.gsm == null) {
            this.gsm = new com.baidu.tbadk.core.dialog.b(this.gsl.getPageContext().getPageActivity());
            this.gsm.hs(R.string.group_report);
            this.gsm.a(new CharSequence[]{new SpannableString(this.gsl.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.gsl.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.gsl.getPageContext().getString(R.string.group_report_lllegal))}, this.grZ);
            this.gsm.d(this.gsl.getPageContext());
        }
        this.gsm.afJ();
    }

    public void bxF() {
        if (this.gsu != null) {
            this.gsu.setVisibility(8);
        }
    }

    public void bxG() {
        if (this.gst != null) {
            this.gst.setVisibility(8);
        }
    }

    public void lt(boolean z) {
        if (this.gsp != null) {
            this.gsp.setVisibility(z ? 0 : 8);
        }
    }

    public void lu(boolean z) {
        if (z) {
            this.gsp.mV();
        } else {
            this.gsp.mW();
        }
    }

    public void bxH() {
        if (this.gsu != null) {
            this.gsu.setVisibility(0);
        }
    }

    public void bxI() {
        if (this.gst != null) {
            this.gst.setVisibility(0);
        }
    }

    public void aUr() {
        if (this.gsr != null) {
            this.gsr.setVisibility(0);
        }
    }

    public void bxJ() {
        if (this.gsr != null) {
            this.gsr.setVisibility(8);
        }
    }

    public BdSwitchView bxK() {
        return this.gsp.getSwitchView();
    }

    public BdSwitchView bxL() {
        return this.gso.getSwitchView();
    }

    public void bxM() {
        if (this.gsv == null) {
            this.gsv = new com.baidu.tbadk.core.dialog.a(this.gsl.getPageContext().getPageActivity());
            this.gsv.ho(R.string.group_dismiss_alert);
            this.gsv.dM(false);
            this.gsv.a(R.string.alert_yes_button, this.gsl);
            this.gsv.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gsv.b(this.gsl.getPageContext());
        }
        this.gsv.afG();
    }

    public com.baidu.tbadk.core.dialog.a bxN() {
        return this.gsv;
    }

    public void bxO() {
        if (this.gsv != null) {
            this.gsv.dismiss();
            this.gsv = null;
        }
        if (this.gsm != null) {
            this.gsm.dismiss();
            this.gsm = null;
        }
        if (this.gsn != null) {
            this.gsn.dismiss();
            this.gsn = null;
        }
    }
}
