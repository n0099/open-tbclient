package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.InterfaceC0097b evb;
    private GroupSettingActivity evn;
    private com.baidu.tbadk.core.dialog.b evo;
    private com.baidu.tbadk.core.dialog.a evp;
    private SettingTextSwitchView evq;
    private SettingTextSwitchView evr;
    private TbSettingTextTipView evs;
    private TbSettingTextTipView evt;
    private TbSettingTextTipView evu;
    private Button evv;
    private Button evw;
    private com.baidu.tbadk.core.dialog.a evx;
    private View evy;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0097b interfaceC0097b) {
        this.evb = interfaceC0097b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.evn = null;
        this.mParent = null;
        this.evo = null;
        this.evq = null;
        this.evr = null;
        this.evs = null;
        this.evt = null;
        this.evu = null;
        this.evb = null;
        this.evn = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.evq.hr(i);
        this.evr.hr(i);
        this.evn.getLayoutMode().aQ(i == 1);
        this.evn.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.evn.getPageContext(), i);
        aj.s(this.evv, d.f.big_red_button);
        aj.s(this.evw, d.f.big_red_button);
    }

    public View aFx() {
        return this.evy;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.evs.setText(str);
        }
    }

    private void initView() {
        this.evn.setContentView(d.h.group_setting_activity);
        this.evq = (SettingTextSwitchView) this.evn.findViewById(d.g.sv_group_msg_notify);
        this.evr = (SettingTextSwitchView) this.evn.findViewById(d.g.sv_group_add_group);
        this.evs = (TbSettingTextTipView) this.evn.findViewById(d.g.tv_change_name);
        this.evt = (TbSettingTextTipView) this.evn.findViewById(d.g.sv_report);
        this.evu = (TbSettingTextTipView) this.evn.findViewById(d.g.sv_delete_msg);
        this.evv = (Button) this.evn.findViewById(d.g.btn_dismiss);
        this.evw = (Button) this.evn.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.evn.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.evn.findViewById(d.g.view_navigation_bar);
        this.evy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.group_setting);
    }

    public void initListener() {
        this.evq.setSwitchStateChangeListener(this.evn);
        this.evr.setSwitchStateChangeListener(this.evn);
        this.evs.setOnClickListener(this.evn);
        this.evt.setOnClickListener(this.evn);
        this.evv.setOnClickListener(this.evn);
        this.evw.setOnClickListener(this.evn);
        this.evu.setOnClickListener(this.evn);
    }

    public TbSettingTextTipView aFy() {
        return this.evs;
    }

    public Button aFz() {
        return this.evw;
    }

    public Button aFA() {
        return this.evv;
    }

    public TbSettingTextTipView aFB() {
        return this.evt;
    }

    public TbSettingTextTipView aFC() {
        return this.evu;
    }

    public void aFD() {
        if (this.evp == null) {
            this.evp = new com.baidu.tbadk.core.dialog.a(this.evn.getPageContext().getPageActivity());
            this.evp.fa(d.j.inform);
            this.evp.fb(d.j.group_quit_alert);
            this.evp.aZ(false);
            this.evp.a(d.j.alert_yes_button, this.evn);
            this.evp.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.evp.b(this.evn.getPageContext());
            this.evp.ba(true);
        }
        this.evp.AU();
    }

    public com.baidu.tbadk.core.dialog.a aFE() {
        return this.evp;
    }

    public void Eu() {
        if (this.evo == null) {
            this.evo = new com.baidu.tbadk.core.dialog.b(this.evn.getPageContext().getPageActivity());
            this.evo.fe(d.j.group_report);
            this.evo.a(new CharSequence[]{new SpannableString(this.evn.getPageContext().getString(d.j.group_report_ad)), new SpannableString(this.evn.getPageContext().getString(d.j.group_report_sex)), new SpannableString(this.evn.getPageContext().getString(d.j.group_report_lllegal))}, this.evb);
            this.evo.d(this.evn.getPageContext());
        }
        this.evo.AX();
    }

    public void aFF() {
        if (this.evw != null) {
            this.evw.setVisibility(8);
        }
    }

    public void aFG() {
        if (this.evv != null) {
            this.evv.setVisibility(8);
        }
    }

    public void gZ(boolean z) {
        if (this.evr != null) {
            this.evr.setVisibility(z ? 0 : 8);
        }
    }

    public void ha(boolean z) {
        if (z) {
            this.evr.rJ();
        } else {
            this.evr.rK();
        }
    }

    public void aFH() {
        if (this.evw != null) {
            this.evw.setVisibility(0);
        }
    }

    public void aFI() {
        if (this.evv != null) {
            this.evv.setVisibility(0);
        }
    }

    public void ahS() {
        if (this.evt != null) {
            this.evt.setVisibility(0);
        }
    }

    public void aFJ() {
        if (this.evt != null) {
            this.evt.setVisibility(8);
        }
    }

    public BdSwitchView aFK() {
        return this.evr.getSwitchView();
    }

    public BdSwitchView aFL() {
        return this.evq.getSwitchView();
    }

    public void aFM() {
        if (this.evx == null) {
            this.evx = new com.baidu.tbadk.core.dialog.a(this.evn.getPageContext().getPageActivity());
            this.evx.fb(d.j.group_dismiss_alert);
            this.evx.aZ(false);
            this.evx.a(d.j.alert_yes_button, this.evn);
            this.evx.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.evx.b(this.evn.getPageContext());
        }
        this.evx.AU();
    }

    public com.baidu.tbadk.core.dialog.a aFN() {
        return this.evx;
    }

    public void aFO() {
        if (this.evx != null) {
            this.evx.dismiss();
            this.evx = null;
        }
        if (this.evo != null) {
            this.evo.dismiss();
            this.evo = null;
        }
        if (this.evp != null) {
            this.evp.dismiss();
            this.evp = null;
        }
    }
}
