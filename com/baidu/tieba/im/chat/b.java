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
    private SettingTextSwitchView gyA;
    private TbSettingTextTipView gyB;
    private TbSettingTextTipView gyC;
    private TbSettingTextTipView gyD;
    private Button gyE;
    private Button gyF;
    private com.baidu.tbadk.core.dialog.a gyG;
    private View gyH;
    private b.a gyk;
    private GroupSettingActivity gyw;
    private com.baidu.tbadk.core.dialog.b gyx;
    private com.baidu.tbadk.core.dialog.a gyy;
    private SettingTextSwitchView gyz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.a aVar) {
        this.gyk = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gyw = null;
        this.mParent = null;
        this.gyx = null;
        this.gyz = null;
        this.gyA = null;
        this.gyB = null;
        this.gyC = null;
        this.gyD = null;
        this.gyk = null;
        this.gyw = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gyz.jZ(i);
        this.gyA.jZ(i);
        this.gyw.getLayoutMode().setNightMode(i == 1);
        this.gyw.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gyw.getPageContext(), i);
        am.k(this.gyE, R.drawable.big_red_button);
        am.k(this.gyF, R.drawable.big_red_button);
    }

    public View bAb() {
        return this.gyH;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gyB.setText(str);
        }
    }

    private void initView() {
        this.gyw.setContentView(R.layout.group_setting_activity);
        this.gyz = (SettingTextSwitchView) this.gyw.findViewById(R.id.sv_group_msg_notify);
        this.gyA = (SettingTextSwitchView) this.gyw.findViewById(R.id.sv_group_add_group);
        this.gyB = (TbSettingTextTipView) this.gyw.findViewById(R.id.tv_change_name);
        this.gyC = (TbSettingTextTipView) this.gyw.findViewById(R.id.sv_report);
        this.gyD = (TbSettingTextTipView) this.gyw.findViewById(R.id.sv_delete_msg);
        this.gyE = (Button) this.gyw.findViewById(R.id.btn_dismiss);
        this.gyF = (Button) this.gyw.findViewById(R.id.btn_quit);
        this.mParent = (RelativeLayout) this.gyw.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gyw.findViewById(R.id.view_navigation_bar);
        this.gyH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.gyz.setSwitchStateChangeListener(this.gyw);
        this.gyA.setSwitchStateChangeListener(this.gyw);
        this.gyB.setOnClickListener(this.gyw);
        this.gyC.setOnClickListener(this.gyw);
        this.gyE.setOnClickListener(this.gyw);
        this.gyF.setOnClickListener(this.gyw);
        this.gyD.setOnClickListener(this.gyw);
    }

    public TbSettingTextTipView bAc() {
        return this.gyB;
    }

    public Button bAd() {
        return this.gyF;
    }

    public Button bAe() {
        return this.gyE;
    }

    public TbSettingTextTipView bAf() {
        return this.gyC;
    }

    public TbSettingTextTipView bAg() {
        return this.gyD;
    }

    public void bAh() {
        if (this.gyy == null) {
            this.gyy = new com.baidu.tbadk.core.dialog.a(this.gyw.getPageContext().getPageActivity());
            this.gyy.ht(R.string.inform);
            this.gyy.hu(R.string.group_quit_alert);
            this.gyy.dQ(false);
            this.gyy.a(R.string.alert_yes_button, this.gyw);
            this.gyy.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gyy.b(this.gyw.getPageContext());
            this.gyy.dR(true);
        }
        this.gyy.agI();
    }

    public com.baidu.tbadk.core.dialog.a bAi() {
        return this.gyy;
    }

    public void ala() {
        if (this.gyx == null) {
            this.gyx = new com.baidu.tbadk.core.dialog.b(this.gyw.getPageContext().getPageActivity());
            this.gyx.hy(R.string.group_report);
            this.gyx.a(new CharSequence[]{new SpannableString(this.gyw.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.gyw.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.gyw.getPageContext().getString(R.string.group_report_lllegal))}, this.gyk);
            this.gyx.d(this.gyw.getPageContext());
        }
        this.gyx.agL();
    }

    public void bAj() {
        if (this.gyF != null) {
            this.gyF.setVisibility(8);
        }
    }

    public void bAk() {
        if (this.gyE != null) {
            this.gyE.setVisibility(8);
        }
    }

    public void lH(boolean z) {
        if (this.gyA != null) {
            this.gyA.setVisibility(z ? 0 : 8);
        }
    }

    public void lI(boolean z) {
        if (z) {
            this.gyA.nm();
        } else {
            this.gyA.nn();
        }
    }

    public void bAl() {
        if (this.gyF != null) {
            this.gyF.setVisibility(0);
        }
    }

    public void bAm() {
        if (this.gyE != null) {
            this.gyE.setVisibility(0);
        }
    }

    public void aWp() {
        if (this.gyC != null) {
            this.gyC.setVisibility(0);
        }
    }

    public void bAn() {
        if (this.gyC != null) {
            this.gyC.setVisibility(8);
        }
    }

    public BdSwitchView bAo() {
        return this.gyA.getSwitchView();
    }

    public BdSwitchView bAp() {
        return this.gyz.getSwitchView();
    }

    public void bAq() {
        if (this.gyG == null) {
            this.gyG = new com.baidu.tbadk.core.dialog.a(this.gyw.getPageContext().getPageActivity());
            this.gyG.hu(R.string.group_dismiss_alert);
            this.gyG.dQ(false);
            this.gyG.a(R.string.alert_yes_button, this.gyw);
            this.gyG.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gyG.b(this.gyw.getPageContext());
        }
        this.gyG.agI();
    }

    public com.baidu.tbadk.core.dialog.a bAr() {
        return this.gyG;
    }

    public void bAs() {
        if (this.gyG != null) {
            this.gyG.dismiss();
            this.gyG = null;
        }
        if (this.gyx != null) {
            this.gyx.dismiss();
            this.gyx = null;
        }
        if (this.gyy != null) {
            this.gyy.dismiss();
            this.gyy = null;
        }
    }
}
