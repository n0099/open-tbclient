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
    private b.a gzc;
    private GroupSettingActivity gzo;
    private com.baidu.tbadk.core.dialog.b gzp;
    private com.baidu.tbadk.core.dialog.a gzq;
    private SettingTextSwitchView gzr;
    private SettingTextSwitchView gzs;
    private TbSettingTextTipView gzt;
    private TbSettingTextTipView gzu;
    private TbSettingTextTipView gzv;
    private Button gzw;
    private Button gzx;
    private com.baidu.tbadk.core.dialog.a gzy;
    private View gzz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.a aVar) {
        this.gzc = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gzo = null;
        this.mParent = null;
        this.gzp = null;
        this.gzr = null;
        this.gzs = null;
        this.gzt = null;
        this.gzu = null;
        this.gzv = null;
        this.gzc = null;
        this.gzo = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gzr.ka(i);
        this.gzs.ka(i);
        this.gzo.getLayoutMode().setNightMode(i == 1);
        this.gzo.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gzo.getPageContext(), i);
        am.k(this.gzw, R.drawable.big_red_button);
        am.k(this.gzx, R.drawable.big_red_button);
    }

    public View bAp() {
        return this.gzz;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gzt.setText(str);
        }
    }

    private void initView() {
        this.gzo.setContentView(R.layout.group_setting_activity);
        this.gzr = (SettingTextSwitchView) this.gzo.findViewById(R.id.sv_group_msg_notify);
        this.gzs = (SettingTextSwitchView) this.gzo.findViewById(R.id.sv_group_add_group);
        this.gzt = (TbSettingTextTipView) this.gzo.findViewById(R.id.tv_change_name);
        this.gzu = (TbSettingTextTipView) this.gzo.findViewById(R.id.sv_report);
        this.gzv = (TbSettingTextTipView) this.gzo.findViewById(R.id.sv_delete_msg);
        this.gzw = (Button) this.gzo.findViewById(R.id.btn_dismiss);
        this.gzx = (Button) this.gzo.findViewById(R.id.btn_quit);
        this.mParent = (RelativeLayout) this.gzo.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gzo.findViewById(R.id.view_navigation_bar);
        this.gzz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.gzr.setSwitchStateChangeListener(this.gzo);
        this.gzs.setSwitchStateChangeListener(this.gzo);
        this.gzt.setOnClickListener(this.gzo);
        this.gzu.setOnClickListener(this.gzo);
        this.gzw.setOnClickListener(this.gzo);
        this.gzx.setOnClickListener(this.gzo);
        this.gzv.setOnClickListener(this.gzo);
    }

    public TbSettingTextTipView bAq() {
        return this.gzt;
    }

    public Button bAr() {
        return this.gzx;
    }

    public Button bAs() {
        return this.gzw;
    }

    public TbSettingTextTipView bAt() {
        return this.gzu;
    }

    public TbSettingTextTipView bAu() {
        return this.gzv;
    }

    public void bAv() {
        if (this.gzq == null) {
            this.gzq = new com.baidu.tbadk.core.dialog.a(this.gzo.getPageContext().getPageActivity());
            this.gzq.ht(R.string.inform);
            this.gzq.hu(R.string.group_quit_alert);
            this.gzq.dQ(false);
            this.gzq.a(R.string.alert_yes_button, this.gzo);
            this.gzq.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gzq.b(this.gzo.getPageContext());
            this.gzq.dR(true);
        }
        this.gzq.agK();
    }

    public com.baidu.tbadk.core.dialog.a bAw() {
        return this.gzq;
    }

    public void alc() {
        if (this.gzp == null) {
            this.gzp = new com.baidu.tbadk.core.dialog.b(this.gzo.getPageContext().getPageActivity());
            this.gzp.hy(R.string.group_report);
            this.gzp.a(new CharSequence[]{new SpannableString(this.gzo.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.gzo.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.gzo.getPageContext().getString(R.string.group_report_lllegal))}, this.gzc);
            this.gzp.d(this.gzo.getPageContext());
        }
        this.gzp.agN();
    }

    public void bAx() {
        if (this.gzx != null) {
            this.gzx.setVisibility(8);
        }
    }

    public void bAy() {
        if (this.gzw != null) {
            this.gzw.setVisibility(8);
        }
    }

    public void lH(boolean z) {
        if (this.gzs != null) {
            this.gzs.setVisibility(z ? 0 : 8);
        }
    }

    public void lI(boolean z) {
        if (z) {
            this.gzs.nm();
        } else {
            this.gzs.nn();
        }
    }

    public void bAz() {
        if (this.gzx != null) {
            this.gzx.setVisibility(0);
        }
    }

    public void bAA() {
        if (this.gzw != null) {
            this.gzw.setVisibility(0);
        }
    }

    public void aWr() {
        if (this.gzu != null) {
            this.gzu.setVisibility(0);
        }
    }

    public void bAB() {
        if (this.gzu != null) {
            this.gzu.setVisibility(8);
        }
    }

    public BdSwitchView bAC() {
        return this.gzs.getSwitchView();
    }

    public BdSwitchView bAD() {
        return this.gzr.getSwitchView();
    }

    public void bAE() {
        if (this.gzy == null) {
            this.gzy = new com.baidu.tbadk.core.dialog.a(this.gzo.getPageContext().getPageActivity());
            this.gzy.hu(R.string.group_dismiss_alert);
            this.gzy.dQ(false);
            this.gzy.a(R.string.alert_yes_button, this.gzo);
            this.gzy.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gzy.b(this.gzo.getPageContext());
        }
        this.gzy.agK();
    }

    public com.baidu.tbadk.core.dialog.a bAF() {
        return this.gzy;
    }

    public void bAG() {
        if (this.gzy != null) {
            this.gzy.dismiss();
            this.gzy = null;
        }
        if (this.gzp != null) {
            this.gzp.dismiss();
            this.gzp = null;
        }
        if (this.gzq != null) {
            this.gzq.dismiss();
            this.gzq = null;
        }
    }
}
