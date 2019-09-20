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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private b.a gAT;
    private GroupSettingActivity gBf;
    private com.baidu.tbadk.core.dialog.b gBg;
    private com.baidu.tbadk.core.dialog.a gBh;
    private SettingTextSwitchView gBi;
    private SettingTextSwitchView gBj;
    private TbSettingTextTipView gBk;
    private TbSettingTextTipView gBl;
    private TbSettingTextTipView gBm;
    private Button gBn;
    private Button gBo;
    private com.baidu.tbadk.core.dialog.a gBp;
    private View gBq;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.a aVar) {
        this.gAT = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gBf = null;
        this.mParent = null;
        this.gBg = null;
        this.gBi = null;
        this.gBj = null;
        this.gBk = null;
        this.gBl = null;
        this.gBm = null;
        this.gAT = null;
        this.gBf = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gBi.kd(i);
        this.gBj.kd(i);
        this.gBf.getLayoutMode().setNightMode(i == 1);
        this.gBf.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gBf.getPageContext(), i);
        am.k(this.gBn, R.drawable.big_red_button);
        am.k(this.gBo, R.drawable.big_red_button);
    }

    public View bBd() {
        return this.gBq;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gBk.setText(str);
        }
    }

    private void initView() {
        this.gBf.setContentView(R.layout.group_setting_activity);
        this.gBi = (SettingTextSwitchView) this.gBf.findViewById(R.id.sv_group_msg_notify);
        this.gBj = (SettingTextSwitchView) this.gBf.findViewById(R.id.sv_group_add_group);
        this.gBk = (TbSettingTextTipView) this.gBf.findViewById(R.id.tv_change_name);
        this.gBl = (TbSettingTextTipView) this.gBf.findViewById(R.id.sv_report);
        this.gBm = (TbSettingTextTipView) this.gBf.findViewById(R.id.sv_delete_msg);
        this.gBn = (Button) this.gBf.findViewById(R.id.btn_dismiss);
        this.gBo = (Button) this.gBf.findViewById(R.id.btn_quit);
        this.mParent = (RelativeLayout) this.gBf.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gBf.findViewById(R.id.view_navigation_bar);
        this.gBq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.gBi.setSwitchStateChangeListener(this.gBf);
        this.gBj.setSwitchStateChangeListener(this.gBf);
        this.gBk.setOnClickListener(this.gBf);
        this.gBl.setOnClickListener(this.gBf);
        this.gBn.setOnClickListener(this.gBf);
        this.gBo.setOnClickListener(this.gBf);
        this.gBm.setOnClickListener(this.gBf);
    }

    public TbSettingTextTipView bBe() {
        return this.gBk;
    }

    public Button bBf() {
        return this.gBo;
    }

    public Button bBg() {
        return this.gBn;
    }

    public TbSettingTextTipView bBh() {
        return this.gBl;
    }

    public TbSettingTextTipView bBi() {
        return this.gBm;
    }

    public void bBj() {
        if (this.gBh == null) {
            this.gBh = new com.baidu.tbadk.core.dialog.a(this.gBf.getPageContext().getPageActivity());
            this.gBh.hu(R.string.inform);
            this.gBh.hv(R.string.group_quit_alert);
            this.gBh.dQ(false);
            this.gBh.a(R.string.alert_yes_button, this.gBf);
            this.gBh.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gBh.b(this.gBf.getPageContext());
            this.gBh.dR(true);
        }
        this.gBh.agO();
    }

    public com.baidu.tbadk.core.dialog.a bBk() {
        return this.gBh;
    }

    public void alo() {
        if (this.gBg == null) {
            this.gBg = new com.baidu.tbadk.core.dialog.b(this.gBf.getPageContext().getPageActivity());
            this.gBg.hz(R.string.group_report);
            this.gBg.a(new CharSequence[]{new SpannableString(this.gBf.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.gBf.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.gBf.getPageContext().getString(R.string.group_report_lllegal))}, this.gAT);
            this.gBg.d(this.gBf.getPageContext());
        }
        this.gBg.agR();
    }

    public void bBl() {
        if (this.gBo != null) {
            this.gBo.setVisibility(8);
        }
    }

    public void bBm() {
        if (this.gBn != null) {
            this.gBn.setVisibility(8);
        }
    }

    public void lK(boolean z) {
        if (this.gBj != null) {
            this.gBj.setVisibility(z ? 0 : 8);
        }
    }

    public void lL(boolean z) {
        if (z) {
            this.gBj.nm();
        } else {
            this.gBj.nn();
        }
    }

    public void bBn() {
        if (this.gBo != null) {
            this.gBo.setVisibility(0);
        }
    }

    public void bBo() {
        if (this.gBn != null) {
            this.gBn.setVisibility(0);
        }
    }

    public void aWV() {
        if (this.gBl != null) {
            this.gBl.setVisibility(0);
        }
    }

    public void bBp() {
        if (this.gBl != null) {
            this.gBl.setVisibility(8);
        }
    }

    public BdSwitchView bBq() {
        return this.gBj.getSwitchView();
    }

    public BdSwitchView bBr() {
        return this.gBi.getSwitchView();
    }

    public void bBs() {
        if (this.gBp == null) {
            this.gBp = new com.baidu.tbadk.core.dialog.a(this.gBf.getPageContext().getPageActivity());
            this.gBp.hv(R.string.group_dismiss_alert);
            this.gBp.dQ(false);
            this.gBp.a(R.string.alert_yes_button, this.gBf);
            this.gBp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gBp.b(this.gBf.getPageContext());
        }
        this.gBp.agO();
    }

    public com.baidu.tbadk.core.dialog.a bBt() {
        return this.gBp;
    }

    public void bBu() {
        if (this.gBp != null) {
            this.gBp.dismiss();
            this.gBp = null;
        }
        if (this.gBg != null) {
            this.gBg.dismiss();
            this.gBg = null;
        }
        if (this.gBh != null) {
            this.gBh.dismiss();
            this.gBh = null;
        }
    }
}
