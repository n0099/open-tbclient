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
    private b.a grX;
    private GroupSettingActivity gsj;
    private com.baidu.tbadk.core.dialog.b gsk;
    private com.baidu.tbadk.core.dialog.a gsl;
    private SettingTextSwitchView gsm;
    private SettingTextSwitchView gsn;
    private TbSettingTextTipView gso;
    private TbSettingTextTipView gsp;
    private TbSettingTextTipView gsq;
    private Button gsr;
    private Button gss;
    private com.baidu.tbadk.core.dialog.a gst;
    private View gsu;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.a aVar) {
        this.grX = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gsj = null;
        this.mParent = null;
        this.gsk = null;
        this.gsm = null;
        this.gsn = null;
        this.gso = null;
        this.gsp = null;
        this.gsq = null;
        this.grX = null;
        this.gsj = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gsm.jT(i);
        this.gsn.jT(i);
        this.gsj.getLayoutMode().setNightMode(i == 1);
        this.gsj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gsj.getPageContext(), i);
        al.k(this.gsr, R.drawable.big_red_button);
        al.k(this.gss, R.drawable.big_red_button);
    }

    public View bxw() {
        return this.gsu;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gso.setText(str);
        }
    }

    private void initView() {
        this.gsj.setContentView(R.layout.group_setting_activity);
        this.gsm = (SettingTextSwitchView) this.gsj.findViewById(R.id.sv_group_msg_notify);
        this.gsn = (SettingTextSwitchView) this.gsj.findViewById(R.id.sv_group_add_group);
        this.gso = (TbSettingTextTipView) this.gsj.findViewById(R.id.tv_change_name);
        this.gsp = (TbSettingTextTipView) this.gsj.findViewById(R.id.sv_report);
        this.gsq = (TbSettingTextTipView) this.gsj.findViewById(R.id.sv_delete_msg);
        this.gsr = (Button) this.gsj.findViewById(R.id.btn_dismiss);
        this.gss = (Button) this.gsj.findViewById(R.id.btn_quit);
        this.mParent = (RelativeLayout) this.gsj.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gsj.findViewById(R.id.view_navigation_bar);
        this.gsu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.gsm.setSwitchStateChangeListener(this.gsj);
        this.gsn.setSwitchStateChangeListener(this.gsj);
        this.gso.setOnClickListener(this.gsj);
        this.gsp.setOnClickListener(this.gsj);
        this.gsr.setOnClickListener(this.gsj);
        this.gss.setOnClickListener(this.gsj);
        this.gsq.setOnClickListener(this.gsj);
    }

    public TbSettingTextTipView bxx() {
        return this.gso;
    }

    public Button bxy() {
        return this.gss;
    }

    public Button bxz() {
        return this.gsr;
    }

    public TbSettingTextTipView bxA() {
        return this.gsp;
    }

    public TbSettingTextTipView bxB() {
        return this.gsq;
    }

    public void bxC() {
        if (this.gsl == null) {
            this.gsl = new com.baidu.tbadk.core.dialog.a(this.gsj.getPageContext().getPageActivity());
            this.gsl.hn(R.string.inform);
            this.gsl.ho(R.string.group_quit_alert);
            this.gsl.dM(false);
            this.gsl.a(R.string.alert_yes_button, this.gsj);
            this.gsl.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gsl.b(this.gsj.getPageContext());
            this.gsl.dN(true);
        }
        this.gsl.afG();
    }

    public com.baidu.tbadk.core.dialog.a bxD() {
        return this.gsl;
    }

    public void ajV() {
        if (this.gsk == null) {
            this.gsk = new com.baidu.tbadk.core.dialog.b(this.gsj.getPageContext().getPageActivity());
            this.gsk.hs(R.string.group_report);
            this.gsk.a(new CharSequence[]{new SpannableString(this.gsj.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.gsj.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.gsj.getPageContext().getString(R.string.group_report_lllegal))}, this.grX);
            this.gsk.d(this.gsj.getPageContext());
        }
        this.gsk.afJ();
    }

    public void bxE() {
        if (this.gss != null) {
            this.gss.setVisibility(8);
        }
    }

    public void bxF() {
        if (this.gsr != null) {
            this.gsr.setVisibility(8);
        }
    }

    public void ls(boolean z) {
        if (this.gsn != null) {
            this.gsn.setVisibility(z ? 0 : 8);
        }
    }

    public void lt(boolean z) {
        if (z) {
            this.gsn.mV();
        } else {
            this.gsn.mW();
        }
    }

    public void bxG() {
        if (this.gss != null) {
            this.gss.setVisibility(0);
        }
    }

    public void bxH() {
        if (this.gsr != null) {
            this.gsr.setVisibility(0);
        }
    }

    public void aUr() {
        if (this.gsp != null) {
            this.gsp.setVisibility(0);
        }
    }

    public void bxI() {
        if (this.gsp != null) {
            this.gsp.setVisibility(8);
        }
    }

    public BdSwitchView bxJ() {
        return this.gsn.getSwitchView();
    }

    public BdSwitchView bxK() {
        return this.gsm.getSwitchView();
    }

    public void bxL() {
        if (this.gst == null) {
            this.gst = new com.baidu.tbadk.core.dialog.a(this.gsj.getPageContext().getPageActivity());
            this.gst.ho(R.string.group_dismiss_alert);
            this.gst.dM(false);
            this.gst.a(R.string.alert_yes_button, this.gsj);
            this.gst.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gst.b(this.gsj.getPageContext());
        }
        this.gst.afG();
    }

    public com.baidu.tbadk.core.dialog.a bxM() {
        return this.gst;
    }

    public void bxN() {
        if (this.gst != null) {
            this.gst.dismiss();
            this.gst = null;
        }
        if (this.gsk != null) {
            this.gsk.dismiss();
            this.gsk = null;
        }
        if (this.gsl != null) {
            this.gsl.dismiss();
            this.gsl = null;
        }
    }
}
