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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.InterfaceC0225b gaS;
    private GroupSettingActivity gbe;
    private com.baidu.tbadk.core.dialog.b gbf;
    private com.baidu.tbadk.core.dialog.a gbg;
    private SettingTextSwitchView gbh;
    private SettingTextSwitchView gbi;
    private TbSettingTextTipView gbj;
    private TbSettingTextTipView gbk;
    private TbSettingTextTipView gbl;
    private Button gbm;
    private Button gbn;
    private com.baidu.tbadk.core.dialog.a gbo;
    private View gbp;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0225b interfaceC0225b) {
        this.gaS = interfaceC0225b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gbe = null;
        this.mParent = null;
        this.gbf = null;
        this.gbh = null;
        this.gbi = null;
        this.gbj = null;
        this.gbk = null;
        this.gbl = null;
        this.gaS = null;
        this.gbe = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gbh.jg(i);
        this.gbi.jg(i);
        this.gbe.getLayoutMode().setNightMode(i == 1);
        this.gbe.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gbe.getPageContext(), i);
        al.k(this.gbm, d.f.big_red_button);
        al.k(this.gbn, d.f.big_red_button);
    }

    public View bpK() {
        return this.gbp;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gbj.setText(str);
        }
    }

    private void initView() {
        this.gbe.setContentView(d.h.group_setting_activity);
        this.gbh = (SettingTextSwitchView) this.gbe.findViewById(d.g.sv_group_msg_notify);
        this.gbi = (SettingTextSwitchView) this.gbe.findViewById(d.g.sv_group_add_group);
        this.gbj = (TbSettingTextTipView) this.gbe.findViewById(d.g.tv_change_name);
        this.gbk = (TbSettingTextTipView) this.gbe.findViewById(d.g.sv_report);
        this.gbl = (TbSettingTextTipView) this.gbe.findViewById(d.g.sv_delete_msg);
        this.gbm = (Button) this.gbe.findViewById(d.g.btn_dismiss);
        this.gbn = (Button) this.gbe.findViewById(d.g.btn_quit);
        this.mParent = (RelativeLayout) this.gbe.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.gbe.findViewById(d.g.view_navigation_bar);
        this.gbp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.group_setting);
    }

    public void initListener() {
        this.gbh.setSwitchStateChangeListener(this.gbe);
        this.gbi.setSwitchStateChangeListener(this.gbe);
        this.gbj.setOnClickListener(this.gbe);
        this.gbk.setOnClickListener(this.gbe);
        this.gbm.setOnClickListener(this.gbe);
        this.gbn.setOnClickListener(this.gbe);
        this.gbl.setOnClickListener(this.gbe);
    }

    public TbSettingTextTipView bpL() {
        return this.gbj;
    }

    public Button bpM() {
        return this.gbn;
    }

    public Button bpN() {
        return this.gbm;
    }

    public TbSettingTextTipView bpO() {
        return this.gbk;
    }

    public TbSettingTextTipView bpP() {
        return this.gbl;
    }

    public void bpQ() {
        if (this.gbg == null) {
            this.gbg = new com.baidu.tbadk.core.dialog.a(this.gbe.getPageContext().getPageActivity());
            this.gbg.gC(d.j.inform);
            this.gbg.gD(d.j.group_quit_alert);
            this.gbg.dq(false);
            this.gbg.a(d.j.alert_yes_button, this.gbe);
            this.gbg.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gbg.b(this.gbe.getPageContext());
            this.gbg.dr(true);
        }
        this.gbg.aaZ();
    }

    public com.baidu.tbadk.core.dialog.a bpR() {
        return this.gbg;
    }

    public void aeZ() {
        if (this.gbf == null) {
            this.gbf = new com.baidu.tbadk.core.dialog.b(this.gbe.getPageContext().getPageActivity());
            this.gbf.gG(d.j.group_report);
            this.gbf.a(new CharSequence[]{new SpannableString(this.gbe.getPageContext().getString(d.j.group_report_ad)), new SpannableString(this.gbe.getPageContext().getString(d.j.group_report_sex)), new SpannableString(this.gbe.getPageContext().getString(d.j.group_report_lllegal))}, this.gaS);
            this.gbf.d(this.gbe.getPageContext());
        }
        this.gbf.abc();
    }

    public void bpS() {
        if (this.gbn != null) {
            this.gbn.setVisibility(8);
        }
    }

    public void bpT() {
        if (this.gbm != null) {
            this.gbm.setVisibility(8);
        }
    }

    public void kD(boolean z) {
        if (this.gbi != null) {
            this.gbi.setVisibility(z ? 0 : 8);
        }
    }

    public void kE(boolean z) {
        if (z) {
            this.gbi.oa();
        } else {
            this.gbi.ob();
        }
    }

    public void bpU() {
        if (this.gbn != null) {
            this.gbn.setVisibility(0);
        }
    }

    public void bpV() {
        if (this.gbm != null) {
            this.gbm.setVisibility(0);
        }
    }

    public void aOo() {
        if (this.gbk != null) {
            this.gbk.setVisibility(0);
        }
    }

    public void bpW() {
        if (this.gbk != null) {
            this.gbk.setVisibility(8);
        }
    }

    public BdSwitchView bpX() {
        return this.gbi.getSwitchView();
    }

    public BdSwitchView bpY() {
        return this.gbh.getSwitchView();
    }

    public void bpZ() {
        if (this.gbo == null) {
            this.gbo = new com.baidu.tbadk.core.dialog.a(this.gbe.getPageContext().getPageActivity());
            this.gbo.gD(d.j.group_dismiss_alert);
            this.gbo.dq(false);
            this.gbo.a(d.j.alert_yes_button, this.gbe);
            this.gbo.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gbo.b(this.gbe.getPageContext());
        }
        this.gbo.aaZ();
    }

    public com.baidu.tbadk.core.dialog.a bqa() {
        return this.gbo;
    }

    public void bqb() {
        if (this.gbo != null) {
            this.gbo.dismiss();
            this.gbo = null;
        }
        if (this.gbf != null) {
            this.gbf.dismiss();
            this.gbf = null;
        }
        if (this.gbg != null) {
            this.gbg.dismiss();
            this.gbg = null;
        }
    }
}
