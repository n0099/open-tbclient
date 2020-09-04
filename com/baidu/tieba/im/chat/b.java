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
/* loaded from: classes17.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private com.baidu.tbadk.core.dialog.a jfA;
    private View jfB;
    private b.InterfaceC0538b jfe;
    private GroupSettingActivity jfp;
    private RelativeLayout jfq;
    private com.baidu.tbadk.core.dialog.b jfr;
    private com.baidu.tbadk.core.dialog.a jfs;
    private SettingTextSwitchView jft;
    private SettingTextSwitchView jfu;
    private TbSettingTextTipView jfv;
    private TbSettingTextTipView jfw;
    private TbSettingTextTipView jfx;
    private Button jfy;
    private Button jfz;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0538b interfaceC0538b) {
        this.jfe = interfaceC0538b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.jfp = null;
        this.jfq = null;
        this.jfr = null;
        this.jft = null;
        this.jfu = null;
        this.jfv = null;
        this.jfw = null;
        this.jfx = null;
        this.jfe = null;
        this.jfp = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jft.pT(i);
        this.jfu.pT(i);
        this.jfp.getLayoutMode().setNightMode(i == 1);
        this.jfp.getLayoutMode().onModeChanged(this.jfq);
        this.mNavigationBar.onChangeSkinType(this.jfp.getPageContext(), i);
        ap.setBackgroundResource(this.jfy, R.drawable.big_red_button);
        ap.setBackgroundResource(this.jfz, R.drawable.big_red_button);
    }

    public View cBw() {
        return this.jfB;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jfv.setText(str);
        }
    }

    private void initView() {
        this.jfp.setContentView(R.layout.group_setting_activity);
        this.jft = (SettingTextSwitchView) this.jfp.findViewById(R.id.sv_group_msg_notify);
        this.jfu = (SettingTextSwitchView) this.jfp.findViewById(R.id.sv_group_add_group);
        this.jfv = (TbSettingTextTipView) this.jfp.findViewById(R.id.tv_change_name);
        this.jfw = (TbSettingTextTipView) this.jfp.findViewById(R.id.sv_report);
        this.jfx = (TbSettingTextTipView) this.jfp.findViewById(R.id.sv_delete_msg);
        this.jfy = (Button) this.jfp.findViewById(R.id.btn_dismiss);
        this.jfz = (Button) this.jfp.findViewById(R.id.btn_quit);
        this.jfq = (RelativeLayout) this.jfp.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jfp.findViewById(R.id.view_navigation_bar);
        this.jfB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.jft.setSwitchStateChangeListener(this.jfp);
        this.jfu.setSwitchStateChangeListener(this.jfp);
        this.jfv.setOnClickListener(this.jfp);
        this.jfw.setOnClickListener(this.jfp);
        this.jfy.setOnClickListener(this.jfp);
        this.jfz.setOnClickListener(this.jfp);
        this.jfx.setOnClickListener(this.jfp);
    }

    public TbSettingTextTipView cBx() {
        return this.jfv;
    }

    public Button cBy() {
        return this.jfz;
    }

    public Button cBz() {
        return this.jfy;
    }

    public TbSettingTextTipView cBA() {
        return this.jfw;
    }

    public TbSettingTextTipView cBB() {
        return this.jfx;
    }

    public void cBC() {
        if (this.jfs == null) {
            this.jfs = new com.baidu.tbadk.core.dialog.a(this.jfp.getPageContext().getPageActivity());
            this.jfs.ns(R.string.inform);
            this.jfs.nt(R.string.group_quit_alert);
            this.jfs.ig(false);
            this.jfs.a(R.string.alert_yes_button, this.jfp);
            this.jfs.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jfs.b(this.jfp.getPageContext());
            this.jfs.ih(true);
        }
        this.jfs.bhg();
    }

    public com.baidu.tbadk.core.dialog.a cBD() {
        return this.jfs;
    }

    public void cBE() {
        if (this.jfr == null) {
            this.jfr = new com.baidu.tbadk.core.dialog.b(this.jfp.getPageContext().getPageActivity());
            this.jfr.nx(R.string.group_report);
            this.jfr.a(new CharSequence[]{new SpannableString(this.jfp.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.jfp.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.jfp.getPageContext().getString(R.string.group_report_lllegal))}, this.jfe);
            this.jfr.d(this.jfp.getPageContext());
        }
        this.jfr.bhi();
    }

    public void cBF() {
        if (this.jfz != null) {
            this.jfz.setVisibility(8);
        }
    }

    public void cBG() {
        if (this.jfy != null) {
            this.jfy.setVisibility(8);
        }
    }

    public void qd(boolean z) {
        if (this.jfu != null) {
            this.jfu.setVisibility(z ? 0 : 8);
        }
    }

    public void qe(boolean z) {
        if (z) {
            this.jfu.turnOn();
        } else {
            this.jfu.turnOff();
        }
    }

    public void cBH() {
        if (this.jfz != null) {
            this.jfz.setVisibility(0);
        }
    }

    public void cBI() {
        if (this.jfy != null) {
            this.jfy.setVisibility(0);
        }
    }

    public void bYw() {
        if (this.jfw != null) {
            this.jfw.setVisibility(0);
        }
    }

    public void cBJ() {
        if (this.jfw != null) {
            this.jfw.setVisibility(8);
        }
    }

    public BdSwitchView cBK() {
        return this.jfu.getSwitchView();
    }

    public BdSwitchView cBL() {
        return this.jft.getSwitchView();
    }

    public void cBM() {
        if (this.jfA == null) {
            this.jfA = new com.baidu.tbadk.core.dialog.a(this.jfp.getPageContext().getPageActivity());
            this.jfA.nt(R.string.group_dismiss_alert);
            this.jfA.ig(false);
            this.jfA.a(R.string.alert_yes_button, this.jfp);
            this.jfA.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jfA.b(this.jfp.getPageContext());
        }
        this.jfA.bhg();
    }

    public com.baidu.tbadk.core.dialog.a cBN() {
        return this.jfA;
    }

    public void cBO() {
        if (this.jfA != null) {
            this.jfA.dismiss();
            this.jfA = null;
        }
        if (this.jfr != null) {
            this.jfr.dismiss();
            this.jfr = null;
        }
        if (this.jfs != null) {
            this.jfs.dismiss();
            this.jfs = null;
        }
    }
}
