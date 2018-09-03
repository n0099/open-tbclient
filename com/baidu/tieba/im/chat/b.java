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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.InterfaceC0101b ejU;
    private GroupSettingActivity ekg;
    private com.baidu.tbadk.core.dialog.b ekh;
    private com.baidu.tbadk.core.dialog.a eki;
    private SettingTextSwitchView ekj;
    private SettingTextSwitchView ekk;
    private TbSettingTextTipView ekl;
    private TbSettingTextTipView ekm;
    private TbSettingTextTipView ekn;
    private Button eko;
    private Button ekp;
    private com.baidu.tbadk.core.dialog.a ekq;
    private View ekr;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0101b interfaceC0101b) {
        this.ejU = interfaceC0101b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.ekg = null;
        this.mParent = null;
        this.ekh = null;
        this.ekj = null;
        this.ekk = null;
        this.ekl = null;
        this.ekm = null;
        this.ekn = null;
        this.ejU = null;
        this.ekg = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ekj.ex(i);
        this.ekk.ex(i);
        this.ekg.getLayoutMode().setNightMode(i == 1);
        this.ekg.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ekg.getPageContext(), i);
        am.i(this.eko, f.C0146f.big_red_button);
        am.i(this.ekp, f.C0146f.big_red_button);
    }

    public View aGW() {
        return this.ekr;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ekl.setText(str);
        }
    }

    private void initView() {
        this.ekg.setContentView(f.h.group_setting_activity);
        this.ekj = (SettingTextSwitchView) this.ekg.findViewById(f.g.sv_group_msg_notify);
        this.ekk = (SettingTextSwitchView) this.ekg.findViewById(f.g.sv_group_add_group);
        this.ekl = (TbSettingTextTipView) this.ekg.findViewById(f.g.tv_change_name);
        this.ekm = (TbSettingTextTipView) this.ekg.findViewById(f.g.sv_report);
        this.ekn = (TbSettingTextTipView) this.ekg.findViewById(f.g.sv_delete_msg);
        this.eko = (Button) this.ekg.findViewById(f.g.btn_dismiss);
        this.ekp = (Button) this.ekg.findViewById(f.g.btn_quit);
        this.mParent = (RelativeLayout) this.ekg.findViewById(f.g.parent);
        this.mNavigationBar = (NavigationBar) this.ekg.findViewById(f.g.view_navigation_bar);
        this.ekr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(f.j.group_setting);
    }

    public void initListener() {
        this.ekj.setSwitchStateChangeListener(this.ekg);
        this.ekk.setSwitchStateChangeListener(this.ekg);
        this.ekl.setOnClickListener(this.ekg);
        this.ekm.setOnClickListener(this.ekg);
        this.eko.setOnClickListener(this.ekg);
        this.ekp.setOnClickListener(this.ekg);
        this.ekn.setOnClickListener(this.ekg);
    }

    public TbSettingTextTipView aGX() {
        return this.ekl;
    }

    public Button aGY() {
        return this.ekp;
    }

    public Button aGZ() {
        return this.eko;
    }

    public TbSettingTextTipView aHa() {
        return this.ekm;
    }

    public TbSettingTextTipView aHb() {
        return this.ekn;
    }

    public void aHc() {
        if (this.eki == null) {
            this.eki = new com.baidu.tbadk.core.dialog.a(this.ekg.getPageContext().getPageActivity());
            this.eki.ce(f.j.inform);
            this.eki.cf(f.j.group_quit_alert);
            this.eki.av(false);
            this.eki.a(f.j.alert_yes_button, this.ekg);
            this.eki.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eki.b(this.ekg.getPageContext());
            this.eki.aw(true);
        }
        this.eki.xe();
    }

    public com.baidu.tbadk.core.dialog.a aHd() {
        return this.eki;
    }

    public void AM() {
        if (this.ekh == null) {
            this.ekh = new com.baidu.tbadk.core.dialog.b(this.ekg.getPageContext().getPageActivity());
            this.ekh.ci(f.j.group_report);
            this.ekh.a(new CharSequence[]{new SpannableString(this.ekg.getPageContext().getString(f.j.group_report_ad)), new SpannableString(this.ekg.getPageContext().getString(f.j.group_report_sex)), new SpannableString(this.ekg.getPageContext().getString(f.j.group_report_lllegal))}, this.ejU);
            this.ekh.d(this.ekg.getPageContext());
        }
        this.ekh.xh();
    }

    public void aHe() {
        if (this.ekp != null) {
            this.ekp.setVisibility(8);
        }
    }

    public void aHf() {
        if (this.eko != null) {
            this.eko.setVisibility(8);
        }
    }

    public void gY(boolean z) {
        if (this.ekk != null) {
            this.ekk.setVisibility(z ? 0 : 8);
        }
    }

    public void gZ(boolean z) {
        if (z) {
            this.ekk.mE();
        } else {
            this.ekk.mF();
        }
    }

    public void aHg() {
        if (this.ekp != null) {
            this.ekp.setVisibility(0);
        }
    }

    public void aHh() {
        if (this.eko != null) {
            this.eko.setVisibility(0);
        }
    }

    public void agC() {
        if (this.ekm != null) {
            this.ekm.setVisibility(0);
        }
    }

    public void aHi() {
        if (this.ekm != null) {
            this.ekm.setVisibility(8);
        }
    }

    public BdSwitchView aHj() {
        return this.ekk.getSwitchView();
    }

    public BdSwitchView aHk() {
        return this.ekj.getSwitchView();
    }

    public void aHl() {
        if (this.ekq == null) {
            this.ekq = new com.baidu.tbadk.core.dialog.a(this.ekg.getPageContext().getPageActivity());
            this.ekq.cf(f.j.group_dismiss_alert);
            this.ekq.av(false);
            this.ekq.a(f.j.alert_yes_button, this.ekg);
            this.ekq.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ekq.b(this.ekg.getPageContext());
        }
        this.ekq.xe();
    }

    public com.baidu.tbadk.core.dialog.a aHm() {
        return this.ekq;
    }

    public void aHn() {
        if (this.ekq != null) {
            this.ekq.dismiss();
            this.ekq = null;
        }
        if (this.ekh != null) {
            this.ekh.dismiss();
            this.ekh = null;
        }
        if (this.eki != null) {
            this.eki.dismiss();
            this.eki = null;
        }
    }
}
