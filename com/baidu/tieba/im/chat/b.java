package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private Button jPA;
    private Button jPB;
    private com.baidu.tbadk.core.dialog.a jPC;
    private View jPD;
    private b.InterfaceC0564b jPg;
    private GroupSettingActivity jPr;
    private RelativeLayout jPs;
    private com.baidu.tbadk.core.dialog.b jPt;
    private com.baidu.tbadk.core.dialog.a jPu;
    private SettingTextSwitchView jPv;
    private SettingTextSwitchView jPw;
    private TbSettingTextTipView jPx;
    private TbSettingTextTipView jPy;
    private TbSettingTextTipView jPz;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0564b interfaceC0564b) {
        this.jPg = interfaceC0564b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.jPr = null;
        this.jPs = null;
        this.jPt = null;
        this.jPv = null;
        this.jPw = null;
        this.jPx = null;
        this.jPy = null;
        this.jPz = null;
        this.jPg = null;
        this.jPr = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jPv.qP(i);
        this.jPw.qP(i);
        this.jPr.getLayoutMode().setNightMode(i == 1);
        this.jPr.getLayoutMode().onModeChanged(this.jPs);
        this.mNavigationBar.onChangeSkinType(this.jPr.getPageContext(), i);
        ap.setBackgroundResource(this.jPA, R.drawable.big_red_button);
        ap.setBackgroundResource(this.jPB, R.drawable.big_red_button);
    }

    public View cLT() {
        return this.jPD;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jPx.setText(str);
        }
    }

    private void initView() {
        this.jPr.setContentView(R.layout.group_setting_activity);
        this.jPv = (SettingTextSwitchView) this.jPr.findViewById(R.id.sv_group_msg_notify);
        this.jPw = (SettingTextSwitchView) this.jPr.findViewById(R.id.sv_group_add_group);
        this.jPx = (TbSettingTextTipView) this.jPr.findViewById(R.id.tv_change_name);
        this.jPy = (TbSettingTextTipView) this.jPr.findViewById(R.id.sv_report);
        this.jPz = (TbSettingTextTipView) this.jPr.findViewById(R.id.sv_delete_msg);
        this.jPA = (Button) this.jPr.findViewById(R.id.btn_dismiss);
        this.jPB = (Button) this.jPr.findViewById(R.id.btn_quit);
        this.jPs = (RelativeLayout) this.jPr.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jPr.findViewById(R.id.view_navigation_bar);
        this.jPD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.jPv.setSwitchStateChangeListener(this.jPr);
        this.jPw.setSwitchStateChangeListener(this.jPr);
        this.jPx.setOnClickListener(this.jPr);
        this.jPy.setOnClickListener(this.jPr);
        this.jPA.setOnClickListener(this.jPr);
        this.jPB.setOnClickListener(this.jPr);
        this.jPz.setOnClickListener(this.jPr);
    }

    public TbSettingTextTipView cLU() {
        return this.jPx;
    }

    public Button cLV() {
        return this.jPB;
    }

    public Button cLW() {
        return this.jPA;
    }

    public TbSettingTextTipView cLX() {
        return this.jPy;
    }

    public TbSettingTextTipView cLY() {
        return this.jPz;
    }

    public void cLZ() {
        if (this.jPu == null) {
            this.jPu = new com.baidu.tbadk.core.dialog.a(this.jPr.getPageContext().getPageActivity());
            this.jPu.ol(R.string.inform);
            this.jPu.om(R.string.group_quit_alert);
            this.jPu.iM(false);
            this.jPu.a(R.string.alert_yes_button, this.jPr);
            this.jPu.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jPu.b(this.jPr.getPageContext());
            this.jPu.iN(true);
        }
        this.jPu.bmC();
    }

    public com.baidu.tbadk.core.dialog.a cMa() {
        return this.jPu;
    }

    public void cMb() {
        if (this.jPt == null) {
            this.jPt = new com.baidu.tbadk.core.dialog.b(this.jPr.getPageContext().getPageActivity());
            this.jPt.or(R.string.group_report);
            this.jPt.a(new CharSequence[]{new SpannableString(this.jPr.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.jPr.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.jPr.getPageContext().getString(R.string.group_report_lllegal))}, this.jPg);
            this.jPt.d(this.jPr.getPageContext());
        }
        this.jPt.bmE();
    }

    public void cMc() {
        if (this.jPB != null) {
            this.jPB.setVisibility(8);
        }
    }

    public void cMd() {
        if (this.jPA != null) {
            this.jPA.setVisibility(8);
        }
    }

    public void rj(boolean z) {
        if (this.jPw != null) {
            this.jPw.setVisibility(z ? 0 : 8);
        }
    }

    public void rk(boolean z) {
        if (z) {
            this.jPw.turnOn();
        } else {
            this.jPw.turnOff();
        }
    }

    public void cMe() {
        if (this.jPB != null) {
            this.jPB.setVisibility(0);
        }
    }

    public void cMf() {
        if (this.jPA != null) {
            this.jPA.setVisibility(0);
        }
    }

    public void cgS() {
        if (this.jPy != null) {
            this.jPy.setVisibility(0);
        }
    }

    public void cMg() {
        if (this.jPy != null) {
            this.jPy.setVisibility(8);
        }
    }

    public BdSwitchView cMh() {
        return this.jPw.getSwitchView();
    }

    public BdSwitchView cMi() {
        return this.jPv.getSwitchView();
    }

    public void cMj() {
        if (this.jPC == null) {
            this.jPC = new com.baidu.tbadk.core.dialog.a(this.jPr.getPageContext().getPageActivity());
            this.jPC.om(R.string.group_dismiss_alert);
            this.jPC.iM(false);
            this.jPC.a(R.string.alert_yes_button, this.jPr);
            this.jPC.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jPC.b(this.jPr.getPageContext());
        }
        this.jPC.bmC();
    }

    public com.baidu.tbadk.core.dialog.a cMk() {
        return this.jPC;
    }

    public void cMl() {
        if (this.jPC != null) {
            this.jPC.dismiss();
            this.jPC = null;
        }
        if (this.jPt != null) {
            this.jPt.dismiss();
            this.jPt = null;
        }
        if (this.jPu != null) {
            this.jPu.dismiss();
            this.jPu = null;
        }
    }
}
