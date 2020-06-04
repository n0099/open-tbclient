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
    private b.a isO;
    private GroupSettingActivity isZ;
    private RelativeLayout ita;
    private com.baidu.tbadk.core.dialog.b itb;
    private com.baidu.tbadk.core.dialog.a itc;
    private SettingTextSwitchView itd;
    private SettingTextSwitchView ite;
    private TbSettingTextTipView itf;
    private TbSettingTextTipView itg;
    private TbSettingTextTipView ith;
    private Button iti;
    private Button itj;
    private com.baidu.tbadk.core.dialog.a itk;
    private View itl;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.isO = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.isZ = null;
        this.ita = null;
        this.itb = null;
        this.itd = null;
        this.ite = null;
        this.itf = null;
        this.itg = null;
        this.ith = null;
        this.isO = null;
        this.isZ = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.itd.mW(i);
        this.ite.mW(i);
        this.isZ.getLayoutMode().setNightMode(i == 1);
        this.isZ.getLayoutMode().onModeChanged(this.ita);
        this.mNavigationBar.onChangeSkinType(this.isZ.getPageContext(), i);
        am.setBackgroundResource(this.iti, R.drawable.big_red_button);
        am.setBackgroundResource(this.itj, R.drawable.big_red_button);
    }

    public View cjn() {
        return this.itl;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.itf.setText(str);
        }
    }

    private void initView() {
        this.isZ.setContentView(R.layout.group_setting_activity);
        this.itd = (SettingTextSwitchView) this.isZ.findViewById(R.id.sv_group_msg_notify);
        this.ite = (SettingTextSwitchView) this.isZ.findViewById(R.id.sv_group_add_group);
        this.itf = (TbSettingTextTipView) this.isZ.findViewById(R.id.tv_change_name);
        this.itg = (TbSettingTextTipView) this.isZ.findViewById(R.id.sv_report);
        this.ith = (TbSettingTextTipView) this.isZ.findViewById(R.id.sv_delete_msg);
        this.iti = (Button) this.isZ.findViewById(R.id.btn_dismiss);
        this.itj = (Button) this.isZ.findViewById(R.id.btn_quit);
        this.ita = (RelativeLayout) this.isZ.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.isZ.findViewById(R.id.view_navigation_bar);
        this.itl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.itd.setSwitchStateChangeListener(this.isZ);
        this.ite.setSwitchStateChangeListener(this.isZ);
        this.itf.setOnClickListener(this.isZ);
        this.itg.setOnClickListener(this.isZ);
        this.iti.setOnClickListener(this.isZ);
        this.itj.setOnClickListener(this.isZ);
        this.ith.setOnClickListener(this.isZ);
    }

    public TbSettingTextTipView cjo() {
        return this.itf;
    }

    public Button cjp() {
        return this.itj;
    }

    public Button cjq() {
        return this.iti;
    }

    public TbSettingTextTipView cjr() {
        return this.itg;
    }

    public TbSettingTextTipView cjs() {
        return this.ith;
    }

    public void cjt() {
        if (this.itc == null) {
            this.itc = new com.baidu.tbadk.core.dialog.a(this.isZ.getPageContext().getPageActivity());
            this.itc.kE(R.string.inform);
            this.itc.kF(R.string.group_quit_alert);
            this.itc.gW(false);
            this.itc.a(R.string.alert_yes_button, this.isZ);
            this.itc.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.itc.b(this.isZ.getPageContext());
            this.itc.gX(true);
        }
        this.itc.aST();
    }

    public com.baidu.tbadk.core.dialog.a cju() {
        return this.itc;
    }

    public void cjv() {
        if (this.itb == null) {
            this.itb = new com.baidu.tbadk.core.dialog.b(this.isZ.getPageContext().getPageActivity());
            this.itb.kJ(R.string.group_report);
            this.itb.a(new CharSequence[]{new SpannableString(this.isZ.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.isZ.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.isZ.getPageContext().getString(R.string.group_report_lllegal))}, this.isO);
            this.itb.d(this.isZ.getPageContext());
        }
        this.itb.aSU();
    }

    public void cjw() {
        if (this.itj != null) {
            this.itj.setVisibility(8);
        }
    }

    public void cjx() {
        if (this.iti != null) {
            this.iti.setVisibility(8);
        }
    }

    public void oG(boolean z) {
        if (this.ite != null) {
            this.ite.setVisibility(z ? 0 : 8);
        }
    }

    public void oH(boolean z) {
        if (z) {
            this.ite.turnOn();
        } else {
            this.ite.turnOff();
        }
    }

    public void cjy() {
        if (this.itj != null) {
            this.itj.setVisibility(0);
        }
    }

    public void cjz() {
        if (this.iti != null) {
            this.iti.setVisibility(0);
        }
    }

    public void bIi() {
        if (this.itg != null) {
            this.itg.setVisibility(0);
        }
    }

    public void cjA() {
        if (this.itg != null) {
            this.itg.setVisibility(8);
        }
    }

    public BdSwitchView cjB() {
        return this.ite.getSwitchView();
    }

    public BdSwitchView cjC() {
        return this.itd.getSwitchView();
    }

    public void cjD() {
        if (this.itk == null) {
            this.itk = new com.baidu.tbadk.core.dialog.a(this.isZ.getPageContext().getPageActivity());
            this.itk.kF(R.string.group_dismiss_alert);
            this.itk.gW(false);
            this.itk.a(R.string.alert_yes_button, this.isZ);
            this.itk.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.itk.b(this.isZ.getPageContext());
        }
        this.itk.aST();
    }

    public com.baidu.tbadk.core.dialog.a cjE() {
        return this.itk;
    }

    public void cjF() {
        if (this.itk != null) {
            this.itk.dismiss();
            this.itk = null;
        }
        if (this.itb != null) {
            this.itb.dismiss();
            this.itb = null;
        }
        if (this.itc != null) {
            this.itc.dismiss();
            this.itc = null;
        }
    }
}
