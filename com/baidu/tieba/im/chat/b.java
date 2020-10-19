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
    private b.InterfaceC0550b jCH;
    private GroupSettingActivity jCS;
    private RelativeLayout jCT;
    private com.baidu.tbadk.core.dialog.b jCU;
    private com.baidu.tbadk.core.dialog.a jCV;
    private SettingTextSwitchView jCW;
    private SettingTextSwitchView jCX;
    private TbSettingTextTipView jCY;
    private TbSettingTextTipView jCZ;
    private TbSettingTextTipView jDa;
    private Button jDb;
    private Button jDc;
    private com.baidu.tbadk.core.dialog.a jDd;
    private View jDe;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0550b interfaceC0550b) {
        this.jCH = interfaceC0550b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.jCS = null;
        this.jCT = null;
        this.jCU = null;
        this.jCW = null;
        this.jCX = null;
        this.jCY = null;
        this.jCZ = null;
        this.jDa = null;
        this.jCH = null;
        this.jCS = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jCW.qE(i);
        this.jCX.qE(i);
        this.jCS.getLayoutMode().setNightMode(i == 1);
        this.jCS.getLayoutMode().onModeChanged(this.jCT);
        this.mNavigationBar.onChangeSkinType(this.jCS.getPageContext(), i);
        ap.setBackgroundResource(this.jDb, R.drawable.big_red_button);
        ap.setBackgroundResource(this.jDc, R.drawable.big_red_button);
    }

    public View cIM() {
        return this.jDe;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jCY.setText(str);
        }
    }

    private void initView() {
        this.jCS.setContentView(R.layout.group_setting_activity);
        this.jCW = (SettingTextSwitchView) this.jCS.findViewById(R.id.sv_group_msg_notify);
        this.jCX = (SettingTextSwitchView) this.jCS.findViewById(R.id.sv_group_add_group);
        this.jCY = (TbSettingTextTipView) this.jCS.findViewById(R.id.tv_change_name);
        this.jCZ = (TbSettingTextTipView) this.jCS.findViewById(R.id.sv_report);
        this.jDa = (TbSettingTextTipView) this.jCS.findViewById(R.id.sv_delete_msg);
        this.jDb = (Button) this.jCS.findViewById(R.id.btn_dismiss);
        this.jDc = (Button) this.jCS.findViewById(R.id.btn_quit);
        this.jCT = (RelativeLayout) this.jCS.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jCS.findViewById(R.id.view_navigation_bar);
        this.jDe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.jCW.setSwitchStateChangeListener(this.jCS);
        this.jCX.setSwitchStateChangeListener(this.jCS);
        this.jCY.setOnClickListener(this.jCS);
        this.jCZ.setOnClickListener(this.jCS);
        this.jDb.setOnClickListener(this.jCS);
        this.jDc.setOnClickListener(this.jCS);
        this.jDa.setOnClickListener(this.jCS);
    }

    public TbSettingTextTipView cIN() {
        return this.jCY;
    }

    public Button cIO() {
        return this.jDc;
    }

    public Button cIP() {
        return this.jDb;
    }

    public TbSettingTextTipView cIQ() {
        return this.jCZ;
    }

    public TbSettingTextTipView cIR() {
        return this.jDa;
    }

    public void cIS() {
        if (this.jCV == null) {
            this.jCV = new com.baidu.tbadk.core.dialog.a(this.jCS.getPageContext().getPageActivity());
            this.jCV.oa(R.string.inform);
            this.jCV.ob(R.string.group_quit_alert);
            this.jCV.iz(false);
            this.jCV.a(R.string.alert_yes_button, this.jCS);
            this.jCV.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jCV.b(this.jCS.getPageContext());
            this.jCV.iA(true);
        }
        this.jCV.bkJ();
    }

    public com.baidu.tbadk.core.dialog.a cIT() {
        return this.jCV;
    }

    public void cIU() {
        if (this.jCU == null) {
            this.jCU = new com.baidu.tbadk.core.dialog.b(this.jCS.getPageContext().getPageActivity());
            this.jCU.og(R.string.group_report);
            this.jCU.a(new CharSequence[]{new SpannableString(this.jCS.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.jCS.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.jCS.getPageContext().getString(R.string.group_report_lllegal))}, this.jCH);
            this.jCU.d(this.jCS.getPageContext());
        }
        this.jCU.bkL();
    }

    public void cIV() {
        if (this.jDc != null) {
            this.jDc.setVisibility(8);
        }
    }

    public void cIW() {
        if (this.jDb != null) {
            this.jDb.setVisibility(8);
        }
    }

    public void qR(boolean z) {
        if (this.jCX != null) {
            this.jCX.setVisibility(z ? 0 : 8);
        }
    }

    public void qS(boolean z) {
        if (z) {
            this.jCX.turnOn();
        } else {
            this.jCX.turnOff();
        }
    }

    public void cIX() {
        if (this.jDc != null) {
            this.jDc.setVisibility(0);
        }
    }

    public void cIY() {
        if (this.jDb != null) {
            this.jDb.setVisibility(0);
        }
    }

    public void cdQ() {
        if (this.jCZ != null) {
            this.jCZ.setVisibility(0);
        }
    }

    public void cIZ() {
        if (this.jCZ != null) {
            this.jCZ.setVisibility(8);
        }
    }

    public BdSwitchView cJa() {
        return this.jCX.getSwitchView();
    }

    public BdSwitchView cJb() {
        return this.jCW.getSwitchView();
    }

    public void cJc() {
        if (this.jDd == null) {
            this.jDd = new com.baidu.tbadk.core.dialog.a(this.jCS.getPageContext().getPageActivity());
            this.jDd.ob(R.string.group_dismiss_alert);
            this.jDd.iz(false);
            this.jDd.a(R.string.alert_yes_button, this.jCS);
            this.jDd.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jDd.b(this.jCS.getPageContext());
        }
        this.jDd.bkJ();
    }

    public com.baidu.tbadk.core.dialog.a cJd() {
        return this.jDd;
    }

    public void cJe() {
        if (this.jDd != null) {
            this.jDd.dismiss();
            this.jDd = null;
        }
        if (this.jCU != null) {
            this.jCU.dismiss();
            this.jCU = null;
        }
        if (this.jCV != null) {
            this.jCV.dismiss();
            this.jCV = null;
        }
    }
}
