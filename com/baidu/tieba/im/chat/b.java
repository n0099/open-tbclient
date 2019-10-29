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
    private b.a gyR;
    private GroupSettingActivity gzd;
    private RelativeLayout gze;
    private com.baidu.tbadk.core.dialog.b gzf;
    private com.baidu.tbadk.core.dialog.a gzg;
    private SettingTextSwitchView gzh;
    private SettingTextSwitchView gzi;
    private TbSettingTextTipView gzj;
    private TbSettingTextTipView gzk;
    private TbSettingTextTipView gzl;
    private Button gzm;
    private Button gzn;
    private com.baidu.tbadk.core.dialog.a gzo;
    private View gzp;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.gyR = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gzd = null;
        this.gze = null;
        this.gzf = null;
        this.gzh = null;
        this.gzi = null;
        this.gzj = null;
        this.gzk = null;
        this.gzl = null;
        this.gyR = null;
        this.gzd = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gzh.jA(i);
        this.gzi.jA(i);
        this.gzd.getLayoutMode().setNightMode(i == 1);
        this.gzd.getLayoutMode().onModeChanged(this.gze);
        this.mNavigationBar.onChangeSkinType(this.gzd.getPageContext(), i);
        am.setBackgroundResource(this.gzm, R.drawable.big_red_button);
        am.setBackgroundResource(this.gzn, R.drawable.big_red_button);
    }

    public View bxO() {
        return this.gzp;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gzj.setText(str);
        }
    }

    private void initView() {
        this.gzd.setContentView(R.layout.group_setting_activity);
        this.gzh = (SettingTextSwitchView) this.gzd.findViewById(R.id.sv_group_msg_notify);
        this.gzi = (SettingTextSwitchView) this.gzd.findViewById(R.id.sv_group_add_group);
        this.gzj = (TbSettingTextTipView) this.gzd.findViewById(R.id.tv_change_name);
        this.gzk = (TbSettingTextTipView) this.gzd.findViewById(R.id.sv_report);
        this.gzl = (TbSettingTextTipView) this.gzd.findViewById(R.id.sv_delete_msg);
        this.gzm = (Button) this.gzd.findViewById(R.id.btn_dismiss);
        this.gzn = (Button) this.gzd.findViewById(R.id.btn_quit);
        this.gze = (RelativeLayout) this.gzd.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gzd.findViewById(R.id.view_navigation_bar);
        this.gzp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.gzh.setSwitchStateChangeListener(this.gzd);
        this.gzi.setSwitchStateChangeListener(this.gzd);
        this.gzj.setOnClickListener(this.gzd);
        this.gzk.setOnClickListener(this.gzd);
        this.gzm.setOnClickListener(this.gzd);
        this.gzn.setOnClickListener(this.gzd);
        this.gzl.setOnClickListener(this.gzd);
    }

    public TbSettingTextTipView bxP() {
        return this.gzj;
    }

    public Button bxQ() {
        return this.gzn;
    }

    public Button bxR() {
        return this.gzm;
    }

    public TbSettingTextTipView bxS() {
        return this.gzk;
    }

    public TbSettingTextTipView bxT() {
        return this.gzl;
    }

    public void bxU() {
        if (this.gzg == null) {
            this.gzg = new com.baidu.tbadk.core.dialog.a(this.gzd.getPageContext().getPageActivity());
            this.gzg.hT(R.string.inform);
            this.gzg.hU(R.string.group_quit_alert);
            this.gzg.eg(false);
            this.gzg.a(R.string.alert_yes_button, this.gzd);
            this.gzg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gzg.b(this.gzd.getPageContext());
            this.gzg.eh(true);
        }
        this.gzg.akO();
    }

    public com.baidu.tbadk.core.dialog.a bxV() {
        return this.gzg;
    }

    public void aoc() {
        if (this.gzf == null) {
            this.gzf = new com.baidu.tbadk.core.dialog.b(this.gzd.getPageContext().getPageActivity());
            this.gzf.hY(R.string.group_report);
            this.gzf.a(new CharSequence[]{new SpannableString(this.gzd.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.gzd.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.gzd.getPageContext().getString(R.string.group_report_lllegal))}, this.gyR);
            this.gzf.d(this.gzd.getPageContext());
        }
        this.gzf.akP();
    }

    public void bxW() {
        if (this.gzn != null) {
            this.gzn.setVisibility(8);
        }
    }

    public void bxX() {
        if (this.gzm != null) {
            this.gzm.setVisibility(8);
        }
    }

    public void ly(boolean z) {
        if (this.gzi != null) {
            this.gzi.setVisibility(z ? 0 : 8);
        }
    }

    public void lz(boolean z) {
        if (z) {
            this.gzi.turnOn();
        } else {
            this.gzi.turnOff();
        }
    }

    public void bxY() {
        if (this.gzn != null) {
            this.gzn.setVisibility(0);
        }
    }

    public void bxZ() {
        if (this.gzm != null) {
            this.gzm.setVisibility(0);
        }
    }

    public void aXz() {
        if (this.gzk != null) {
            this.gzk.setVisibility(0);
        }
    }

    public void bya() {
        if (this.gzk != null) {
            this.gzk.setVisibility(8);
        }
    }

    public BdSwitchView byb() {
        return this.gzi.getSwitchView();
    }

    public BdSwitchView byc() {
        return this.gzh.getSwitchView();
    }

    public void byd() {
        if (this.gzo == null) {
            this.gzo = new com.baidu.tbadk.core.dialog.a(this.gzd.getPageContext().getPageActivity());
            this.gzo.hU(R.string.group_dismiss_alert);
            this.gzo.eg(false);
            this.gzo.a(R.string.alert_yes_button, this.gzd);
            this.gzo.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gzo.b(this.gzd.getPageContext());
        }
        this.gzo.akO();
    }

    public com.baidu.tbadk.core.dialog.a bye() {
        return this.gzo;
    }

    public void byf() {
        if (this.gzo != null) {
            this.gzo.dismiss();
            this.gzo = null;
        }
        if (this.gzf != null) {
            this.gzf.dismiss();
            this.gzf = null;
        }
        if (this.gzg != null) {
            this.gzg.dismiss();
            this.gzg = null;
        }
    }
}
