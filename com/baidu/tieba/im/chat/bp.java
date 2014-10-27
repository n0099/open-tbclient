package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.base.f {
    private TbSettingTextTipView aOA;
    private TbSettingTextTipView aOB;
    private Button aOC;
    private Button aOD;
    private AlertDialog aOE;
    private View aOF;
    private DialogInterface.OnClickListener aOm;
    private GroupSettingActivity aOu;
    private AlertDialog aOv;
    private AlertDialog aOw;
    private SettingTextSwitchView aOx;
    private SettingTextSwitchView aOy;
    private TbSettingTextTipView aOz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.aOm = onClickListener;
    }

    public bp(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity);
        this.aOu = null;
        this.mParent = null;
        this.aOv = null;
        this.aOx = null;
        this.aOy = null;
        this.aOz = null;
        this.aOA = null;
        this.aOB = null;
        this.aOm = null;
        this.aOu = groupSettingActivity;
        nu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.aOx.cu(i);
        this.aOy.cu(i);
        this.aOu.getLayoutMode().L(i == 1);
        this.aOu.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.h((View) this.aOC, com.baidu.tieba.u.big_red_button);
        com.baidu.tbadk.core.util.aw.h((View) this.aOD, com.baidu.tieba.u.big_red_button);
    }

    public View JA() {
        return this.aOF;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aOz.setText(str);
        }
    }

    private void nu() {
        this.aOu.setContentView(com.baidu.tieba.w.group_setting_activity);
        this.aOx = (SettingTextSwitchView) this.aOu.findViewById(com.baidu.tieba.v.sv_group_msg_notify);
        this.aOy = (SettingTextSwitchView) this.aOu.findViewById(com.baidu.tieba.v.sv_group_add_group);
        this.aOz = (TbSettingTextTipView) this.aOu.findViewById(com.baidu.tieba.v.tv_change_name);
        this.aOA = (TbSettingTextTipView) this.aOu.findViewById(com.baidu.tieba.v.sv_report);
        this.aOB = (TbSettingTextTipView) this.aOu.findViewById(com.baidu.tieba.v.sv_delete_msg);
        this.aOC = (Button) this.aOu.findViewById(com.baidu.tieba.v.btn_dismiss);
        this.aOD = (Button) this.aOu.findViewById(com.baidu.tieba.v.btn_quit);
        this.mParent = (RelativeLayout) this.aOu.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.aOu.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aOF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(com.baidu.tieba.y.group_setting);
    }

    public void HJ() {
        this.aOx.setSwitchStateChangeListener(this.aOu);
        this.aOy.setSwitchStateChangeListener(this.aOu);
        this.aOz.setOnClickListener(this.aOu);
        this.aOA.setOnClickListener(this.aOu);
        this.aOC.setOnClickListener(this.aOu);
        this.aOD.setOnClickListener(this.aOu);
        this.aOB.setOnClickListener(this.aOu);
    }

    public TbSettingTextTipView JB() {
        return this.aOz;
    }

    public Button JC() {
        return this.aOD;
    }

    public Button JD() {
        return this.aOC;
    }

    public TbSettingTextTipView JE() {
        return this.aOA;
    }

    public TbSettingTextTipView JF() {
        return this.aOB;
    }

    public void JG() {
        if (this.aOw == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.aOu);
            builder.setTitle(com.baidu.tieba.y.alert_title);
            builder.setIcon((Drawable) null);
            builder.setCancelable(false);
            builder.setMessage(com.baidu.tieba.y.group_quit_alert);
            builder.setPositiveButton(com.baidu.tieba.y.alert_yes_button, this.aOu);
            builder.setNegativeButton(com.baidu.tieba.y.alert_no_button, new bq(this));
            this.aOw = builder.create();
            this.aOw.setCanceledOnTouchOutside(true);
        }
        if (!this.aOw.isShowing()) {
            com.baidu.adp.lib.g.j.a(this.aOw, this.aOu);
        }
    }

    public AlertDialog JH() {
        return this.aOw;
    }

    public void JI() {
        if (this.aOv == null) {
            this.aOv = new AlertDialog.Builder(this.aOu).setTitle(com.baidu.tieba.y.group_report).setItems(new CharSequence[]{new SpannableString(this.aOu.getString(com.baidu.tieba.y.group_report_ad)), new SpannableString(this.aOu.getString(com.baidu.tieba.y.group_report_sex)), new SpannableString(this.aOu.getString(com.baidu.tieba.y.group_report_lllegal))}, this.aOm).create();
        }
        this.aOv.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.aOv, this.aOu);
    }

    public void JJ() {
        if (this.aOD != null) {
            this.aOD.setVisibility(8);
        }
    }

    public void JK() {
        if (this.aOC != null) {
            this.aOC.setVisibility(8);
        }
    }

    public void cy(boolean z) {
        if (this.aOy != null) {
            this.aOy.setVisibility(z ? 0 : 8);
        }
    }

    public void cz(boolean z) {
        if (z) {
            this.aOy.gN();
        } else {
            this.aOy.gO();
        }
    }

    public void JL() {
        if (this.aOD != null) {
            this.aOD.setVisibility(0);
        }
    }

    public void JM() {
        if (this.aOC != null) {
            this.aOC.setVisibility(0);
        }
    }

    public void JN() {
        if (this.aOA != null) {
            this.aOA.setVisibility(0);
        }
    }

    public void JO() {
        if (this.aOA != null) {
            this.aOA.setVisibility(8);
        }
    }

    public BdSwitchView JP() {
        return this.aOy.getSwitchView();
    }

    public BdSwitchView JQ() {
        return this.aOx.getSwitchView();
    }

    public void JR() {
        if (this.aOE == null) {
            this.aOE = new AlertDialog.Builder(this.mContext).setTitle(this.mContext.getString(com.baidu.tieba.y.alert_title)).setCancelable(false).setMessage(com.baidu.tieba.y.group_dismiss_alert).setPositiveButton(com.baidu.tieba.y.alert_yes_button, this.aOu).setNegativeButton(com.baidu.tieba.y.alert_no_button, new br(this)).create();
        }
        if (!this.aOE.isShowing()) {
            com.baidu.adp.lib.g.j.a(this.aOE, this.aOu);
        }
    }

    public AlertDialog JS() {
        return this.aOE;
    }

    public void JT() {
        if (this.aOE != null && this.aOE.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.aOE, (Activity) this.mContext);
            this.aOE = null;
        }
        if (this.aOv != null && this.aOv.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.aOv, (Activity) this.mContext);
            this.aOv = null;
        }
        if (this.aOw != null && this.aOw.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.aOw, (Activity) this.mContext);
            this.aOw = null;
        }
    }
}
