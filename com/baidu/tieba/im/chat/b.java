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
    private View jVA;
    private b.InterfaceC0576b jVd;
    private GroupSettingActivity jVo;
    private RelativeLayout jVp;
    private com.baidu.tbadk.core.dialog.b jVq;
    private com.baidu.tbadk.core.dialog.a jVr;
    private SettingTextSwitchView jVs;
    private SettingTextSwitchView jVt;
    private TbSettingTextTipView jVu;
    private TbSettingTextTipView jVv;
    private TbSettingTextTipView jVw;
    private Button jVx;
    private Button jVy;
    private com.baidu.tbadk.core.dialog.a jVz;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0576b interfaceC0576b) {
        this.jVd = interfaceC0576b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.jVo = null;
        this.jVp = null;
        this.jVq = null;
        this.jVs = null;
        this.jVt = null;
        this.jVu = null;
        this.jVv = null;
        this.jVw = null;
        this.jVd = null;
        this.jVo = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jVs.qZ(i);
        this.jVt.qZ(i);
        this.jVo.getLayoutMode().setNightMode(i == 1);
        this.jVo.getLayoutMode().onModeChanged(this.jVp);
        this.mNavigationBar.onChangeSkinType(this.jVo.getPageContext(), i);
        ap.setBackgroundResource(this.jVx, R.drawable.big_red_button);
        ap.setBackgroundResource(this.jVy, R.drawable.big_red_button);
    }

    public View cOu() {
        return this.jVA;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jVu.setText(str);
        }
    }

    private void initView() {
        this.jVo.setContentView(R.layout.group_setting_activity);
        this.jVs = (SettingTextSwitchView) this.jVo.findViewById(R.id.sv_group_msg_notify);
        this.jVt = (SettingTextSwitchView) this.jVo.findViewById(R.id.sv_group_add_group);
        this.jVu = (TbSettingTextTipView) this.jVo.findViewById(R.id.tv_change_name);
        this.jVv = (TbSettingTextTipView) this.jVo.findViewById(R.id.sv_report);
        this.jVw = (TbSettingTextTipView) this.jVo.findViewById(R.id.sv_delete_msg);
        this.jVx = (Button) this.jVo.findViewById(R.id.btn_dismiss);
        this.jVy = (Button) this.jVo.findViewById(R.id.btn_quit);
        this.jVp = (RelativeLayout) this.jVo.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jVo.findViewById(R.id.view_navigation_bar);
        this.jVA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.jVs.setSwitchStateChangeListener(this.jVo);
        this.jVt.setSwitchStateChangeListener(this.jVo);
        this.jVu.setOnClickListener(this.jVo);
        this.jVv.setOnClickListener(this.jVo);
        this.jVx.setOnClickListener(this.jVo);
        this.jVy.setOnClickListener(this.jVo);
        this.jVw.setOnClickListener(this.jVo);
    }

    public TbSettingTextTipView cOv() {
        return this.jVu;
    }

    public Button cOw() {
        return this.jVy;
    }

    public Button cOx() {
        return this.jVx;
    }

    public TbSettingTextTipView cOy() {
        return this.jVv;
    }

    public TbSettingTextTipView cOz() {
        return this.jVw;
    }

    public void cOA() {
        if (this.jVr == null) {
            this.jVr = new com.baidu.tbadk.core.dialog.a(this.jVo.getPageContext().getPageActivity());
            this.jVr.ov(R.string.inform);
            this.jVr.ow(R.string.group_quit_alert);
            this.jVr.iV(false);
            this.jVr.a(R.string.alert_yes_button, this.jVo);
            this.jVr.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jVr.b(this.jVo.getPageContext());
            this.jVr.iW(true);
        }
        this.jVr.bpc();
    }

    public com.baidu.tbadk.core.dialog.a cOB() {
        return this.jVr;
    }

    public void cOC() {
        if (this.jVq == null) {
            this.jVq = new com.baidu.tbadk.core.dialog.b(this.jVo.getPageContext().getPageActivity());
            this.jVq.oB(R.string.group_report);
            this.jVq.a(new CharSequence[]{new SpannableString(this.jVo.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.jVo.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.jVo.getPageContext().getString(R.string.group_report_lllegal))}, this.jVd);
            this.jVq.d(this.jVo.getPageContext());
        }
        this.jVq.bpe();
    }

    public void cOD() {
        if (this.jVy != null) {
            this.jVy.setVisibility(8);
        }
    }

    public void cOE() {
        if (this.jVx != null) {
            this.jVx.setVisibility(8);
        }
    }

    public void rs(boolean z) {
        if (this.jVt != null) {
            this.jVt.setVisibility(z ? 0 : 8);
        }
    }

    public void rt(boolean z) {
        if (z) {
            this.jVt.turnOn();
        } else {
            this.jVt.turnOff();
        }
    }

    public void cOF() {
        if (this.jVy != null) {
            this.jVy.setVisibility(0);
        }
    }

    public void cOG() {
        if (this.jVx != null) {
            this.jVx.setVisibility(0);
        }
    }

    public void cju() {
        if (this.jVv != null) {
            this.jVv.setVisibility(0);
        }
    }

    public void cOH() {
        if (this.jVv != null) {
            this.jVv.setVisibility(8);
        }
    }

    public BdSwitchView cOI() {
        return this.jVt.getSwitchView();
    }

    public BdSwitchView cOJ() {
        return this.jVs.getSwitchView();
    }

    public void cOK() {
        if (this.jVz == null) {
            this.jVz = new com.baidu.tbadk.core.dialog.a(this.jVo.getPageContext().getPageActivity());
            this.jVz.ow(R.string.group_dismiss_alert);
            this.jVz.iV(false);
            this.jVz.a(R.string.alert_yes_button, this.jVo);
            this.jVz.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jVz.b(this.jVo.getPageContext());
        }
        this.jVz.bpc();
    }

    public com.baidu.tbadk.core.dialog.a cOL() {
        return this.jVz;
    }

    public void cOM() {
        if (this.jVz != null) {
            this.jVz.dismiss();
            this.jVz = null;
        }
        if (this.jVq != null) {
            this.jVq.dismiss();
            this.jVq = null;
        }
        if (this.jVr != null) {
            this.jVr.dismiss();
            this.jVr = null;
        }
    }
}
