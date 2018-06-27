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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private TbSettingTextTipView egA;
    private TbSettingTextTipView egB;
    private Button egC;
    private Button egD;
    private com.baidu.tbadk.core.dialog.a egE;
    private View egF;
    private b.InterfaceC0104b egi;
    private GroupSettingActivity egu;
    private com.baidu.tbadk.core.dialog.b egv;
    private com.baidu.tbadk.core.dialog.a egw;
    private SettingTextSwitchView egx;
    private SettingTextSwitchView egy;
    private TbSettingTextTipView egz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0104b interfaceC0104b) {
        this.egi = interfaceC0104b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.egu = null;
        this.mParent = null;
        this.egv = null;
        this.egx = null;
        this.egy = null;
        this.egz = null;
        this.egA = null;
        this.egB = null;
        this.egi = null;
        this.egu = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.egx.ev(i);
        this.egy.ev(i);
        this.egu.getLayoutMode().setNightMode(i == 1);
        this.egu.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.egu.getPageContext(), i);
        am.i(this.egC, d.f.big_red_button);
        am.i(this.egD, d.f.big_red_button);
    }

    public View aFZ() {
        return this.egF;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.egz.setText(str);
        }
    }

    private void initView() {
        this.egu.setContentView(d.i.group_setting_activity);
        this.egx = (SettingTextSwitchView) this.egu.findViewById(d.g.sv_group_msg_notify);
        this.egy = (SettingTextSwitchView) this.egu.findViewById(d.g.sv_group_add_group);
        this.egz = (TbSettingTextTipView) this.egu.findViewById(d.g.tv_change_name);
        this.egA = (TbSettingTextTipView) this.egu.findViewById(d.g.sv_report);
        this.egB = (TbSettingTextTipView) this.egu.findViewById(d.g.sv_delete_msg);
        this.egC = (Button) this.egu.findViewById(d.g.btn_dismiss);
        this.egD = (Button) this.egu.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.egu.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.egu.findViewById(d.g.view_navigation_bar);
        this.egF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.group_setting);
    }

    public void initListener() {
        this.egx.setSwitchStateChangeListener(this.egu);
        this.egy.setSwitchStateChangeListener(this.egu);
        this.egz.setOnClickListener(this.egu);
        this.egA.setOnClickListener(this.egu);
        this.egC.setOnClickListener(this.egu);
        this.egD.setOnClickListener(this.egu);
        this.egB.setOnClickListener(this.egu);
    }

    public TbSettingTextTipView aGa() {
        return this.egz;
    }

    public Button aGb() {
        return this.egD;
    }

    public Button aGc() {
        return this.egC;
    }

    public TbSettingTextTipView aGd() {
        return this.egA;
    }

    public TbSettingTextTipView aGe() {
        return this.egB;
    }

    public void aGf() {
        if (this.egw == null) {
            this.egw = new com.baidu.tbadk.core.dialog.a(this.egu.getPageContext().getPageActivity());
            this.egw.cc(d.k.inform);
            this.egw.cd(d.k.group_quit_alert);
            this.egw.aw(false);
            this.egw.a(d.k.alert_yes_button, this.egu);
            this.egw.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.egw.b(this.egu.getPageContext());
            this.egw.ax(true);
        }
        this.egw.xn();
    }

    public com.baidu.tbadk.core.dialog.a aGg() {
        return this.egw;
    }

    public void AY() {
        if (this.egv == null) {
            this.egv = new com.baidu.tbadk.core.dialog.b(this.egu.getPageContext().getPageActivity());
            this.egv.cg(d.k.group_report);
            this.egv.a(new CharSequence[]{new SpannableString(this.egu.getPageContext().getString(d.k.group_report_ad)), new SpannableString(this.egu.getPageContext().getString(d.k.group_report_sex)), new SpannableString(this.egu.getPageContext().getString(d.k.group_report_lllegal))}, this.egi);
            this.egv.d(this.egu.getPageContext());
        }
        this.egv.xq();
    }

    public void aGh() {
        if (this.egD != null) {
            this.egD.setVisibility(8);
        }
    }

    public void aGi() {
        if (this.egC != null) {
            this.egC.setVisibility(8);
        }
    }

    public void gV(boolean z) {
        if (this.egy != null) {
            this.egy.setVisibility(z ? 0 : 8);
        }
    }

    public void gW(boolean z) {
        if (z) {
            this.egy.mC();
        } else {
            this.egy.mD();
        }
    }

    public void aGj() {
        if (this.egD != null) {
            this.egD.setVisibility(0);
        }
    }

    public void aGk() {
        if (this.egC != null) {
            this.egC.setVisibility(0);
        }
    }

    public void agg() {
        if (this.egA != null) {
            this.egA.setVisibility(0);
        }
    }

    public void aGl() {
        if (this.egA != null) {
            this.egA.setVisibility(8);
        }
    }

    public BdSwitchView aGm() {
        return this.egy.getSwitchView();
    }

    public BdSwitchView aGn() {
        return this.egx.getSwitchView();
    }

    public void aGo() {
        if (this.egE == null) {
            this.egE = new com.baidu.tbadk.core.dialog.a(this.egu.getPageContext().getPageActivity());
            this.egE.cd(d.k.group_dismiss_alert);
            this.egE.aw(false);
            this.egE.a(d.k.alert_yes_button, this.egu);
            this.egE.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.egE.b(this.egu.getPageContext());
        }
        this.egE.xn();
    }

    public com.baidu.tbadk.core.dialog.a aGp() {
        return this.egE;
    }

    public void aGq() {
        if (this.egE != null) {
            this.egE.dismiss();
            this.egE = null;
        }
        if (this.egv != null) {
            this.egv.dismiss();
            this.egv = null;
        }
        if (this.egw != null) {
            this.egw.dismiss();
            this.egw = null;
        }
    }
}
