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
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private com.baidu.tbadk.core.dialog.a idA;
    private SettingTextSwitchView idB;
    private SettingTextSwitchView idC;
    private TbSettingTextTipView idD;
    private TbSettingTextTipView idE;
    private TbSettingTextTipView idF;
    private Button idG;
    private Button idH;
    private com.baidu.tbadk.core.dialog.a idI;
    private View idJ;
    private b.a idi;
    private GroupSettingActivity idw;
    private RelativeLayout idy;
    private com.baidu.tbadk.core.dialog.b idz;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.idi = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.idw = null;
        this.idy = null;
        this.idz = null;
        this.idB = null;
        this.idC = null;
        this.idD = null;
        this.idE = null;
        this.idF = null;
        this.idi = null;
        this.idw = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.idB.ms(i);
        this.idC.ms(i);
        this.idw.getLayoutMode().setNightMode(i == 1);
        this.idw.getLayoutMode().onModeChanged(this.idy);
        this.mNavigationBar.onChangeSkinType(this.idw.getPageContext(), i);
        am.setBackgroundResource(this.idG, R.drawable.big_red_button);
        am.setBackgroundResource(this.idH, R.drawable.big_red_button);
    }

    public View ccH() {
        return this.idJ;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.idD.setText(str);
        }
    }

    private void initView() {
        this.idw.setContentView(R.layout.group_setting_activity);
        this.idB = (SettingTextSwitchView) this.idw.findViewById(R.id.sv_group_msg_notify);
        this.idC = (SettingTextSwitchView) this.idw.findViewById(R.id.sv_group_add_group);
        this.idD = (TbSettingTextTipView) this.idw.findViewById(R.id.tv_change_name);
        this.idE = (TbSettingTextTipView) this.idw.findViewById(R.id.sv_report);
        this.idF = (TbSettingTextTipView) this.idw.findViewById(R.id.sv_delete_msg);
        this.idG = (Button) this.idw.findViewById(R.id.btn_dismiss);
        this.idH = (Button) this.idw.findViewById(R.id.btn_quit);
        this.idy = (RelativeLayout) this.idw.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.idw.findViewById(R.id.view_navigation_bar);
        this.idJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.idB.setSwitchStateChangeListener(this.idw);
        this.idC.setSwitchStateChangeListener(this.idw);
        this.idD.setOnClickListener(this.idw);
        this.idE.setOnClickListener(this.idw);
        this.idG.setOnClickListener(this.idw);
        this.idH.setOnClickListener(this.idw);
        this.idF.setOnClickListener(this.idw);
    }

    public TbSettingTextTipView ccI() {
        return this.idD;
    }

    public Button ccJ() {
        return this.idH;
    }

    public Button ccK() {
        return this.idG;
    }

    public TbSettingTextTipView ccL() {
        return this.idE;
    }

    public TbSettingTextTipView ccM() {
        return this.idF;
    }

    public void ccN() {
        if (this.idA == null) {
            this.idA = new com.baidu.tbadk.core.dialog.a(this.idw.getPageContext().getPageActivity());
            this.idA.kc(R.string.inform);
            this.idA.kd(R.string.group_quit_alert);
            this.idA.gE(false);
            this.idA.a(R.string.alert_yes_button, this.idw);
            this.idA.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.idA.b(this.idw.getPageContext());
            this.idA.gF(true);
        }
        this.idA.aMU();
    }

    public com.baidu.tbadk.core.dialog.a ccO() {
        return this.idA;
    }

    public void ccP() {
        if (this.idz == null) {
            this.idz = new com.baidu.tbadk.core.dialog.b(this.idw.getPageContext().getPageActivity());
            this.idz.kh(R.string.group_report);
            this.idz.a(new CharSequence[]{new SpannableString(this.idw.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.idw.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.idw.getPageContext().getString(R.string.group_report_lllegal))}, this.idi);
            this.idz.d(this.idw.getPageContext());
        }
        this.idz.aMV();
    }

    public void ccQ() {
        if (this.idH != null) {
            this.idH.setVisibility(8);
        }
    }

    public void ccR() {
        if (this.idG != null) {
            this.idG.setVisibility(8);
        }
    }

    public void ok(boolean z) {
        if (this.idC != null) {
            this.idC.setVisibility(z ? 0 : 8);
        }
    }

    public void ol(boolean z) {
        if (z) {
            this.idC.turnOn();
        } else {
            this.idC.turnOff();
        }
    }

    public void ccS() {
        if (this.idH != null) {
            this.idH.setVisibility(0);
        }
    }

    public void ccT() {
        if (this.idG != null) {
            this.idG.setVisibility(0);
        }
    }

    public void bBP() {
        if (this.idE != null) {
            this.idE.setVisibility(0);
        }
    }

    public void ccU() {
        if (this.idE != null) {
            this.idE.setVisibility(8);
        }
    }

    public BdSwitchView ccV() {
        return this.idC.getSwitchView();
    }

    public BdSwitchView ccW() {
        return this.idB.getSwitchView();
    }

    public void ccX() {
        if (this.idI == null) {
            this.idI = new com.baidu.tbadk.core.dialog.a(this.idw.getPageContext().getPageActivity());
            this.idI.kd(R.string.group_dismiss_alert);
            this.idI.gE(false);
            this.idI.a(R.string.alert_yes_button, this.idw);
            this.idI.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.idI.b(this.idw.getPageContext());
        }
        this.idI.aMU();
    }

    public com.baidu.tbadk.core.dialog.a ccY() {
        return this.idI;
    }

    public void ccZ() {
        if (this.idI != null) {
            this.idI.dismiss();
            this.idI = null;
        }
        if (this.idz != null) {
            this.idz.dismiss();
            this.idz = null;
        }
        if (this.idA != null) {
            this.idA.dismiss();
            this.idA = null;
        }
    }
}
