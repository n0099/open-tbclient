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
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.InterfaceC0533b jnK;
    private GroupSettingActivity jnV;
    private RelativeLayout jnW;
    private com.baidu.tbadk.core.dialog.b jnX;
    private com.baidu.tbadk.core.dialog.a jnY;
    private SettingTextSwitchView jnZ;
    private SettingTextSwitchView joa;
    private TbSettingTextTipView job;
    private TbSettingTextTipView joc;
    private TbSettingTextTipView jod;
    private Button joe;
    private Button jof;
    private com.baidu.tbadk.core.dialog.a jog;
    private View joh;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0533b interfaceC0533b) {
        this.jnK = interfaceC0533b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.jnV = null;
        this.jnW = null;
        this.jnX = null;
        this.jnZ = null;
        this.joa = null;
        this.job = null;
        this.joc = null;
        this.jod = null;
        this.jnK = null;
        this.jnV = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jnZ.qg(i);
        this.joa.qg(i);
        this.jnV.getLayoutMode().setNightMode(i == 1);
        this.jnV.getLayoutMode().onModeChanged(this.jnW);
        this.mNavigationBar.onChangeSkinType(this.jnV.getPageContext(), i);
        ap.setBackgroundResource(this.joe, R.drawable.big_red_button);
        ap.setBackgroundResource(this.jof, R.drawable.big_red_button);
    }

    public View cFd() {
        return this.joh;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.job.setText(str);
        }
    }

    private void initView() {
        this.jnV.setContentView(R.layout.group_setting_activity);
        this.jnZ = (SettingTextSwitchView) this.jnV.findViewById(R.id.sv_group_msg_notify);
        this.joa = (SettingTextSwitchView) this.jnV.findViewById(R.id.sv_group_add_group);
        this.job = (TbSettingTextTipView) this.jnV.findViewById(R.id.tv_change_name);
        this.joc = (TbSettingTextTipView) this.jnV.findViewById(R.id.sv_report);
        this.jod = (TbSettingTextTipView) this.jnV.findViewById(R.id.sv_delete_msg);
        this.joe = (Button) this.jnV.findViewById(R.id.btn_dismiss);
        this.jof = (Button) this.jnV.findViewById(R.id.btn_quit);
        this.jnW = (RelativeLayout) this.jnV.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jnV.findViewById(R.id.view_navigation_bar);
        this.joh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.jnZ.setSwitchStateChangeListener(this.jnV);
        this.joa.setSwitchStateChangeListener(this.jnV);
        this.job.setOnClickListener(this.jnV);
        this.joc.setOnClickListener(this.jnV);
        this.joe.setOnClickListener(this.jnV);
        this.jof.setOnClickListener(this.jnV);
        this.jod.setOnClickListener(this.jnV);
    }

    public TbSettingTextTipView cFe() {
        return this.job;
    }

    public Button cFf() {
        return this.jof;
    }

    public Button cFg() {
        return this.joe;
    }

    public TbSettingTextTipView cFh() {
        return this.joc;
    }

    public TbSettingTextTipView cFi() {
        return this.jod;
    }

    public void cFj() {
        if (this.jnY == null) {
            this.jnY = new com.baidu.tbadk.core.dialog.a(this.jnV.getPageContext().getPageActivity());
            this.jnY.nD(R.string.inform);
            this.jnY.nE(R.string.group_quit_alert);
            this.jnY.id(false);
            this.jnY.a(R.string.alert_yes_button, this.jnV);
            this.jnY.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jnY.b(this.jnV.getPageContext());
            this.jnY.ie(true);
        }
        this.jnY.bia();
    }

    public com.baidu.tbadk.core.dialog.a cFk() {
        return this.jnY;
    }

    public void cFl() {
        if (this.jnX == null) {
            this.jnX = new com.baidu.tbadk.core.dialog.b(this.jnV.getPageContext().getPageActivity());
            this.jnX.nJ(R.string.group_report);
            this.jnX.a(new CharSequence[]{new SpannableString(this.jnV.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.jnV.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.jnV.getPageContext().getString(R.string.group_report_lllegal))}, this.jnK);
            this.jnX.d(this.jnV.getPageContext());
        }
        this.jnX.bic();
    }

    public void cFm() {
        if (this.jof != null) {
            this.jof.setVisibility(8);
        }
    }

    public void cFn() {
        if (this.joe != null) {
            this.joe.setVisibility(8);
        }
    }

    public void ql(boolean z) {
        if (this.joa != null) {
            this.joa.setVisibility(z ? 0 : 8);
        }
    }

    public void qm(boolean z) {
        if (z) {
            this.joa.turnOn();
        } else {
            this.joa.turnOff();
        }
    }

    public void cFo() {
        if (this.jof != null) {
            this.jof.setVisibility(0);
        }
    }

    public void cFp() {
        if (this.joe != null) {
            this.joe.setVisibility(0);
        }
    }

    public void cas() {
        if (this.joc != null) {
            this.joc.setVisibility(0);
        }
    }

    public void cFq() {
        if (this.joc != null) {
            this.joc.setVisibility(8);
        }
    }

    public BdSwitchView cFr() {
        return this.joa.getSwitchView();
    }

    public BdSwitchView cFs() {
        return this.jnZ.getSwitchView();
    }

    public void cFt() {
        if (this.jog == null) {
            this.jog = new com.baidu.tbadk.core.dialog.a(this.jnV.getPageContext().getPageActivity());
            this.jog.nE(R.string.group_dismiss_alert);
            this.jog.id(false);
            this.jog.a(R.string.alert_yes_button, this.jnV);
            this.jog.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jog.b(this.jnV.getPageContext());
        }
        this.jog.bia();
    }

    public com.baidu.tbadk.core.dialog.a cFu() {
        return this.jog;
    }

    public void cFv() {
        if (this.jog != null) {
            this.jog.dismiss();
            this.jog = null;
        }
        if (this.jnX != null) {
            this.jnX.dismiss();
            this.jnX = null;
        }
        if (this.jnY != null) {
            this.jnY.dismiss();
            this.jnY = null;
        }
    }
}
