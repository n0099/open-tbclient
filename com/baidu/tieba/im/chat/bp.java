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
    private DialogInterface.OnClickListener aOA;
    private GroupSettingActivity aOI;
    private AlertDialog aOJ;
    private AlertDialog aOK;
    private SettingTextSwitchView aOL;
    private SettingTextSwitchView aOM;
    private TbSettingTextTipView aON;
    private TbSettingTextTipView aOO;
    private TbSettingTextTipView aOP;
    private Button aOQ;
    private Button aOR;
    private AlertDialog aOS;
    private View aOT;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.aOA = onClickListener;
    }

    public bp(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity);
        this.aOI = null;
        this.mParent = null;
        this.aOJ = null;
        this.aOL = null;
        this.aOM = null;
        this.aON = null;
        this.aOO = null;
        this.aOP = null;
        this.aOA = null;
        this.aOI = groupSettingActivity;
        nu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.aOL.cu(i);
        this.aOM.cu(i);
        this.aOI.getLayoutMode().L(i == 1);
        this.aOI.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.h((View) this.aOQ, com.baidu.tieba.u.big_red_button);
        com.baidu.tbadk.core.util.aw.h((View) this.aOR, com.baidu.tieba.u.big_red_button);
    }

    public View JE() {
        return this.aOT;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aON.setText(str);
        }
    }

    private void nu() {
        this.aOI.setContentView(com.baidu.tieba.w.group_setting_activity);
        this.aOL = (SettingTextSwitchView) this.aOI.findViewById(com.baidu.tieba.v.sv_group_msg_notify);
        this.aOM = (SettingTextSwitchView) this.aOI.findViewById(com.baidu.tieba.v.sv_group_add_group);
        this.aON = (TbSettingTextTipView) this.aOI.findViewById(com.baidu.tieba.v.tv_change_name);
        this.aOO = (TbSettingTextTipView) this.aOI.findViewById(com.baidu.tieba.v.sv_report);
        this.aOP = (TbSettingTextTipView) this.aOI.findViewById(com.baidu.tieba.v.sv_delete_msg);
        this.aOQ = (Button) this.aOI.findViewById(com.baidu.tieba.v.btn_dismiss);
        this.aOR = (Button) this.aOI.findViewById(com.baidu.tieba.v.btn_quit);
        this.mParent = (RelativeLayout) this.aOI.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.aOI.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aOT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(com.baidu.tieba.y.group_setting);
    }

    public void HN() {
        this.aOL.setSwitchStateChangeListener(this.aOI);
        this.aOM.setSwitchStateChangeListener(this.aOI);
        this.aON.setOnClickListener(this.aOI);
        this.aOO.setOnClickListener(this.aOI);
        this.aOQ.setOnClickListener(this.aOI);
        this.aOR.setOnClickListener(this.aOI);
        this.aOP.setOnClickListener(this.aOI);
    }

    public TbSettingTextTipView JF() {
        return this.aON;
    }

    public Button JG() {
        return this.aOR;
    }

    public Button JH() {
        return this.aOQ;
    }

    public TbSettingTextTipView JI() {
        return this.aOO;
    }

    public TbSettingTextTipView JJ() {
        return this.aOP;
    }

    public void JK() {
        if (this.aOK == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.aOI);
            builder.setTitle(com.baidu.tieba.y.alert_title);
            builder.setIcon((Drawable) null);
            builder.setCancelable(false);
            builder.setMessage(com.baidu.tieba.y.group_quit_alert);
            builder.setPositiveButton(com.baidu.tieba.y.alert_yes_button, this.aOI);
            builder.setNegativeButton(com.baidu.tieba.y.alert_no_button, new bq(this));
            this.aOK = builder.create();
            this.aOK.setCanceledOnTouchOutside(true);
        }
        if (!this.aOK.isShowing()) {
            com.baidu.adp.lib.g.j.a(this.aOK, this.aOI);
        }
    }

    public AlertDialog JL() {
        return this.aOK;
    }

    public void JM() {
        if (this.aOJ == null) {
            this.aOJ = new AlertDialog.Builder(this.aOI).setTitle(com.baidu.tieba.y.group_report).setItems(new CharSequence[]{new SpannableString(this.aOI.getString(com.baidu.tieba.y.group_report_ad)), new SpannableString(this.aOI.getString(com.baidu.tieba.y.group_report_sex)), new SpannableString(this.aOI.getString(com.baidu.tieba.y.group_report_lllegal))}, this.aOA).create();
        }
        this.aOJ.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.aOJ, this.aOI);
    }

    public void JN() {
        if (this.aOR != null) {
            this.aOR.setVisibility(8);
        }
    }

    public void JO() {
        if (this.aOQ != null) {
            this.aOQ.setVisibility(8);
        }
    }

    public void cy(boolean z) {
        if (this.aOM != null) {
            this.aOM.setVisibility(z ? 0 : 8);
        }
    }

    public void cz(boolean z) {
        if (z) {
            this.aOM.gN();
        } else {
            this.aOM.gO();
        }
    }

    public void JP() {
        if (this.aOR != null) {
            this.aOR.setVisibility(0);
        }
    }

    public void JQ() {
        if (this.aOQ != null) {
            this.aOQ.setVisibility(0);
        }
    }

    public void JR() {
        if (this.aOO != null) {
            this.aOO.setVisibility(0);
        }
    }

    public void JS() {
        if (this.aOO != null) {
            this.aOO.setVisibility(8);
        }
    }

    public BdSwitchView JT() {
        return this.aOM.getSwitchView();
    }

    public BdSwitchView JU() {
        return this.aOL.getSwitchView();
    }

    public void JV() {
        if (this.aOS == null) {
            this.aOS = new AlertDialog.Builder(this.mContext).setTitle(this.mContext.getString(com.baidu.tieba.y.alert_title)).setCancelable(false).setMessage(com.baidu.tieba.y.group_dismiss_alert).setPositiveButton(com.baidu.tieba.y.alert_yes_button, this.aOI).setNegativeButton(com.baidu.tieba.y.alert_no_button, new br(this)).create();
        }
        if (!this.aOS.isShowing()) {
            com.baidu.adp.lib.g.j.a(this.aOS, this.aOI);
        }
    }

    public AlertDialog JW() {
        return this.aOS;
    }

    public void JX() {
        if (this.aOS != null && this.aOS.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.aOS, (Activity) this.mContext);
            this.aOS = null;
        }
        if (this.aOJ != null && this.aOJ.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.aOJ, (Activity) this.mContext);
            this.aOJ = null;
        }
        if (this.aOK != null && this.aOK.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.aOK, (Activity) this.mContext);
            this.aOK = null;
        }
    }
}
