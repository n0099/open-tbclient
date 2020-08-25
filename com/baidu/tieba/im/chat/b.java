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
    private b.InterfaceC0538b jeY;
    private GroupSettingActivity jfj;
    private RelativeLayout jfk;
    private com.baidu.tbadk.core.dialog.b jfl;
    private com.baidu.tbadk.core.dialog.a jfm;
    private SettingTextSwitchView jfn;
    private SettingTextSwitchView jfo;
    private TbSettingTextTipView jfp;
    private TbSettingTextTipView jfq;
    private TbSettingTextTipView jfr;
    private Button jfs;
    private Button jft;
    private com.baidu.tbadk.core.dialog.a jfu;
    private View jfv;
    private NavigationBar mNavigationBar;

    public void a(b.InterfaceC0538b interfaceC0538b) {
        this.jeY = interfaceC0538b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.jfj = null;
        this.jfk = null;
        this.jfl = null;
        this.jfn = null;
        this.jfo = null;
        this.jfp = null;
        this.jfq = null;
        this.jfr = null;
        this.jeY = null;
        this.jfj = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.jfn.pT(i);
        this.jfo.pT(i);
        this.jfj.getLayoutMode().setNightMode(i == 1);
        this.jfj.getLayoutMode().onModeChanged(this.jfk);
        this.mNavigationBar.onChangeSkinType(this.jfj.getPageContext(), i);
        ap.setBackgroundResource(this.jfs, R.drawable.big_red_button);
        ap.setBackgroundResource(this.jft, R.drawable.big_red_button);
    }

    public View cBv() {
        return this.jfv;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jfp.setText(str);
        }
    }

    private void initView() {
        this.jfj.setContentView(R.layout.group_setting_activity);
        this.jfn = (SettingTextSwitchView) this.jfj.findViewById(R.id.sv_group_msg_notify);
        this.jfo = (SettingTextSwitchView) this.jfj.findViewById(R.id.sv_group_add_group);
        this.jfp = (TbSettingTextTipView) this.jfj.findViewById(R.id.tv_change_name);
        this.jfq = (TbSettingTextTipView) this.jfj.findViewById(R.id.sv_report);
        this.jfr = (TbSettingTextTipView) this.jfj.findViewById(R.id.sv_delete_msg);
        this.jfs = (Button) this.jfj.findViewById(R.id.btn_dismiss);
        this.jft = (Button) this.jfj.findViewById(R.id.btn_quit);
        this.jfk = (RelativeLayout) this.jfj.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jfj.findViewById(R.id.view_navigation_bar);
        this.jfv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.jfn.setSwitchStateChangeListener(this.jfj);
        this.jfo.setSwitchStateChangeListener(this.jfj);
        this.jfp.setOnClickListener(this.jfj);
        this.jfq.setOnClickListener(this.jfj);
        this.jfs.setOnClickListener(this.jfj);
        this.jft.setOnClickListener(this.jfj);
        this.jfr.setOnClickListener(this.jfj);
    }

    public TbSettingTextTipView cBw() {
        return this.jfp;
    }

    public Button cBx() {
        return this.jft;
    }

    public Button cBy() {
        return this.jfs;
    }

    public TbSettingTextTipView cBz() {
        return this.jfq;
    }

    public TbSettingTextTipView cBA() {
        return this.jfr;
    }

    public void cBB() {
        if (this.jfm == null) {
            this.jfm = new com.baidu.tbadk.core.dialog.a(this.jfj.getPageContext().getPageActivity());
            this.jfm.ns(R.string.inform);
            this.jfm.nt(R.string.group_quit_alert);
            this.jfm.m39if(false);
            this.jfm.a(R.string.alert_yes_button, this.jfj);
            this.jfm.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jfm.b(this.jfj.getPageContext());
            this.jfm.ig(true);
        }
        this.jfm.bhg();
    }

    public com.baidu.tbadk.core.dialog.a cBC() {
        return this.jfm;
    }

    public void cBD() {
        if (this.jfl == null) {
            this.jfl = new com.baidu.tbadk.core.dialog.b(this.jfj.getPageContext().getPageActivity());
            this.jfl.nx(R.string.group_report);
            this.jfl.a(new CharSequence[]{new SpannableString(this.jfj.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.jfj.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.jfj.getPageContext().getString(R.string.group_report_lllegal))}, this.jeY);
            this.jfl.d(this.jfj.getPageContext());
        }
        this.jfl.bhi();
    }

    public void cBE() {
        if (this.jft != null) {
            this.jft.setVisibility(8);
        }
    }

    public void cBF() {
        if (this.jfs != null) {
            this.jfs.setVisibility(8);
        }
    }

    public void qb(boolean z) {
        if (this.jfo != null) {
            this.jfo.setVisibility(z ? 0 : 8);
        }
    }

    public void qc(boolean z) {
        if (z) {
            this.jfo.turnOn();
        } else {
            this.jfo.turnOff();
        }
    }

    public void cBG() {
        if (this.jft != null) {
            this.jft.setVisibility(0);
        }
    }

    public void cBH() {
        if (this.jfs != null) {
            this.jfs.setVisibility(0);
        }
    }

    public void bYv() {
        if (this.jfq != null) {
            this.jfq.setVisibility(0);
        }
    }

    public void cBI() {
        if (this.jfq != null) {
            this.jfq.setVisibility(8);
        }
    }

    public BdSwitchView cBJ() {
        return this.jfo.getSwitchView();
    }

    public BdSwitchView cBK() {
        return this.jfn.getSwitchView();
    }

    public void cBL() {
        if (this.jfu == null) {
            this.jfu = new com.baidu.tbadk.core.dialog.a(this.jfj.getPageContext().getPageActivity());
            this.jfu.nt(R.string.group_dismiss_alert);
            this.jfu.m39if(false);
            this.jfu.a(R.string.alert_yes_button, this.jfj);
            this.jfu.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jfu.b(this.jfj.getPageContext());
        }
        this.jfu.bhg();
    }

    public com.baidu.tbadk.core.dialog.a cBM() {
        return this.jfu;
    }

    public void cBN() {
        if (this.jfu != null) {
            this.jfu.dismiss();
            this.jfu = null;
        }
        if (this.jfl != null) {
            this.jfl.dismiss();
            this.jfl = null;
        }
        if (this.jfm != null) {
            this.jfm.dismiss();
            this.jfm = null;
        }
    }
}
