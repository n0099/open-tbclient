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
    private b.a gya;
    private GroupSettingActivity gym;
    private RelativeLayout gyn;
    private com.baidu.tbadk.core.dialog.b gyo;
    private com.baidu.tbadk.core.dialog.a gyp;
    private SettingTextSwitchView gyq;
    private SettingTextSwitchView gyr;
    private TbSettingTextTipView gys;
    private TbSettingTextTipView gyt;
    private TbSettingTextTipView gyu;
    private Button gyv;
    private Button gyw;
    private com.baidu.tbadk.core.dialog.a gyx;
    private View gyy;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.gya = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.gym = null;
        this.gyn = null;
        this.gyo = null;
        this.gyq = null;
        this.gyr = null;
        this.gys = null;
        this.gyt = null;
        this.gyu = null;
        this.gya = null;
        this.gym = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gyq.jz(i);
        this.gyr.jz(i);
        this.gym.getLayoutMode().setNightMode(i == 1);
        this.gym.getLayoutMode().onModeChanged(this.gyn);
        this.mNavigationBar.onChangeSkinType(this.gym.getPageContext(), i);
        am.setBackgroundResource(this.gyv, R.drawable.big_red_button);
        am.setBackgroundResource(this.gyw, R.drawable.big_red_button);
    }

    public View bxM() {
        return this.gyy;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gys.setText(str);
        }
    }

    private void initView() {
        this.gym.setContentView(R.layout.group_setting_activity);
        this.gyq = (SettingTextSwitchView) this.gym.findViewById(R.id.sv_group_msg_notify);
        this.gyr = (SettingTextSwitchView) this.gym.findViewById(R.id.sv_group_add_group);
        this.gys = (TbSettingTextTipView) this.gym.findViewById(R.id.tv_change_name);
        this.gyt = (TbSettingTextTipView) this.gym.findViewById(R.id.sv_report);
        this.gyu = (TbSettingTextTipView) this.gym.findViewById(R.id.sv_delete_msg);
        this.gyv = (Button) this.gym.findViewById(R.id.btn_dismiss);
        this.gyw = (Button) this.gym.findViewById(R.id.btn_quit);
        this.gyn = (RelativeLayout) this.gym.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gym.findViewById(R.id.view_navigation_bar);
        this.gyy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.gyq.setSwitchStateChangeListener(this.gym);
        this.gyr.setSwitchStateChangeListener(this.gym);
        this.gys.setOnClickListener(this.gym);
        this.gyt.setOnClickListener(this.gym);
        this.gyv.setOnClickListener(this.gym);
        this.gyw.setOnClickListener(this.gym);
        this.gyu.setOnClickListener(this.gym);
    }

    public TbSettingTextTipView bxN() {
        return this.gys;
    }

    public Button bxO() {
        return this.gyw;
    }

    public Button bxP() {
        return this.gyv;
    }

    public TbSettingTextTipView bxQ() {
        return this.gyt;
    }

    public TbSettingTextTipView bxR() {
        return this.gyu;
    }

    public void bxS() {
        if (this.gyp == null) {
            this.gyp = new com.baidu.tbadk.core.dialog.a(this.gym.getPageContext().getPageActivity());
            this.gyp.hS(R.string.inform);
            this.gyp.hT(R.string.group_quit_alert);
            this.gyp.eg(false);
            this.gyp.a(R.string.alert_yes_button, this.gym);
            this.gyp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gyp.b(this.gym.getPageContext());
            this.gyp.eh(true);
        }
        this.gyp.akM();
    }

    public com.baidu.tbadk.core.dialog.a bxT() {
        return this.gyp;
    }

    public void aoa() {
        if (this.gyo == null) {
            this.gyo = new com.baidu.tbadk.core.dialog.b(this.gym.getPageContext().getPageActivity());
            this.gyo.hX(R.string.group_report);
            this.gyo.a(new CharSequence[]{new SpannableString(this.gym.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.gym.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.gym.getPageContext().getString(R.string.group_report_lllegal))}, this.gya);
            this.gyo.d(this.gym.getPageContext());
        }
        this.gyo.akN();
    }

    public void bxU() {
        if (this.gyw != null) {
            this.gyw.setVisibility(8);
        }
    }

    public void bxV() {
        if (this.gyv != null) {
            this.gyv.setVisibility(8);
        }
    }

    public void ly(boolean z) {
        if (this.gyr != null) {
            this.gyr.setVisibility(z ? 0 : 8);
        }
    }

    public void lz(boolean z) {
        if (z) {
            this.gyr.turnOn();
        } else {
            this.gyr.turnOff();
        }
    }

    public void bxW() {
        if (this.gyw != null) {
            this.gyw.setVisibility(0);
        }
    }

    public void bxX() {
        if (this.gyv != null) {
            this.gyv.setVisibility(0);
        }
    }

    public void aXx() {
        if (this.gyt != null) {
            this.gyt.setVisibility(0);
        }
    }

    public void bxY() {
        if (this.gyt != null) {
            this.gyt.setVisibility(8);
        }
    }

    public BdSwitchView bxZ() {
        return this.gyr.getSwitchView();
    }

    public BdSwitchView bya() {
        return this.gyq.getSwitchView();
    }

    public void byb() {
        if (this.gyx == null) {
            this.gyx = new com.baidu.tbadk.core.dialog.a(this.gym.getPageContext().getPageActivity());
            this.gyx.hT(R.string.group_dismiss_alert);
            this.gyx.eg(false);
            this.gyx.a(R.string.alert_yes_button, this.gym);
            this.gyx.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gyx.b(this.gym.getPageContext());
        }
        this.gyx.akM();
    }

    public com.baidu.tbadk.core.dialog.a byc() {
        return this.gyx;
    }

    public void byd() {
        if (this.gyx != null) {
            this.gyx.dismiss();
            this.gyx = null;
        }
        if (this.gyo != null) {
            this.gyo.dismiss();
            this.gyo = null;
        }
        if (this.gyp != null) {
            this.gyp.dismiss();
            this.gyp = null;
        }
    }
}
