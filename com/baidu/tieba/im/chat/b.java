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
    private GroupSettingActivity idD;
    private RelativeLayout idE;
    private com.baidu.tbadk.core.dialog.b idF;
    private com.baidu.tbadk.core.dialog.a idG;
    private SettingTextSwitchView idH;
    private SettingTextSwitchView idI;
    private TbSettingTextTipView idJ;
    private TbSettingTextTipView idK;
    private TbSettingTextTipView idL;
    private Button idM;
    private Button idN;
    private com.baidu.tbadk.core.dialog.a idO;
    private View idP;
    private b.a idp;
    private NavigationBar mNavigationBar;

    public void a(b.a aVar) {
        this.idp = aVar;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.idD = null;
        this.idE = null;
        this.idF = null;
        this.idH = null;
        this.idI = null;
        this.idJ = null;
        this.idK = null;
        this.idL = null;
        this.idp = null;
        this.idD = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.idH.ms(i);
        this.idI.ms(i);
        this.idD.getLayoutMode().setNightMode(i == 1);
        this.idD.getLayoutMode().onModeChanged(this.idE);
        this.mNavigationBar.onChangeSkinType(this.idD.getPageContext(), i);
        am.setBackgroundResource(this.idM, R.drawable.big_red_button);
        am.setBackgroundResource(this.idN, R.drawable.big_red_button);
    }

    public View ccG() {
        return this.idP;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.idJ.setText(str);
        }
    }

    private void initView() {
        this.idD.setContentView(R.layout.group_setting_activity);
        this.idH = (SettingTextSwitchView) this.idD.findViewById(R.id.sv_group_msg_notify);
        this.idI = (SettingTextSwitchView) this.idD.findViewById(R.id.sv_group_add_group);
        this.idJ = (TbSettingTextTipView) this.idD.findViewById(R.id.tv_change_name);
        this.idK = (TbSettingTextTipView) this.idD.findViewById(R.id.sv_report);
        this.idL = (TbSettingTextTipView) this.idD.findViewById(R.id.sv_delete_msg);
        this.idM = (Button) this.idD.findViewById(R.id.btn_dismiss);
        this.idN = (Button) this.idD.findViewById(R.id.btn_quit);
        this.idE = (RelativeLayout) this.idD.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.idD.findViewById(R.id.view_navigation_bar);
        this.idP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.group_setting);
    }

    public void initListener() {
        this.idH.setSwitchStateChangeListener(this.idD);
        this.idI.setSwitchStateChangeListener(this.idD);
        this.idJ.setOnClickListener(this.idD);
        this.idK.setOnClickListener(this.idD);
        this.idM.setOnClickListener(this.idD);
        this.idN.setOnClickListener(this.idD);
        this.idL.setOnClickListener(this.idD);
    }

    public TbSettingTextTipView ccH() {
        return this.idJ;
    }

    public Button ccI() {
        return this.idN;
    }

    public Button ccJ() {
        return this.idM;
    }

    public TbSettingTextTipView ccK() {
        return this.idK;
    }

    public TbSettingTextTipView ccL() {
        return this.idL;
    }

    public void ccM() {
        if (this.idG == null) {
            this.idG = new com.baidu.tbadk.core.dialog.a(this.idD.getPageContext().getPageActivity());
            this.idG.kc(R.string.inform);
            this.idG.kd(R.string.group_quit_alert);
            this.idG.gE(false);
            this.idG.a(R.string.alert_yes_button, this.idD);
            this.idG.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.idG.b(this.idD.getPageContext());
            this.idG.gF(true);
        }
        this.idG.aMS();
    }

    public com.baidu.tbadk.core.dialog.a ccN() {
        return this.idG;
    }

    public void ccO() {
        if (this.idF == null) {
            this.idF = new com.baidu.tbadk.core.dialog.b(this.idD.getPageContext().getPageActivity());
            this.idF.kh(R.string.group_report);
            this.idF.a(new CharSequence[]{new SpannableString(this.idD.getPageContext().getString(R.string.group_report_ad)), new SpannableString(this.idD.getPageContext().getString(R.string.group_report_sex)), new SpannableString(this.idD.getPageContext().getString(R.string.group_report_lllegal))}, this.idp);
            this.idF.d(this.idD.getPageContext());
        }
        this.idF.aMT();
    }

    public void ccP() {
        if (this.idN != null) {
            this.idN.setVisibility(8);
        }
    }

    public void ccQ() {
        if (this.idM != null) {
            this.idM.setVisibility(8);
        }
    }

    public void ok(boolean z) {
        if (this.idI != null) {
            this.idI.setVisibility(z ? 0 : 8);
        }
    }

    public void ol(boolean z) {
        if (z) {
            this.idI.turnOn();
        } else {
            this.idI.turnOff();
        }
    }

    public void ccR() {
        if (this.idN != null) {
            this.idN.setVisibility(0);
        }
    }

    public void ccS() {
        if (this.idM != null) {
            this.idM.setVisibility(0);
        }
    }

    public void bBN() {
        if (this.idK != null) {
            this.idK.setVisibility(0);
        }
    }

    public void ccT() {
        if (this.idK != null) {
            this.idK.setVisibility(8);
        }
    }

    public BdSwitchView ccU() {
        return this.idI.getSwitchView();
    }

    public BdSwitchView ccV() {
        return this.idH.getSwitchView();
    }

    public void ccW() {
        if (this.idO == null) {
            this.idO = new com.baidu.tbadk.core.dialog.a(this.idD.getPageContext().getPageActivity());
            this.idO.kd(R.string.group_dismiss_alert);
            this.idO.gE(false);
            this.idO.a(R.string.alert_yes_button, this.idD);
            this.idO.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.idO.b(this.idD.getPageContext());
        }
        this.idO.aMS();
    }

    public com.baidu.tbadk.core.dialog.a ccX() {
        return this.idO;
    }

    public void ccY() {
        if (this.idO != null) {
            this.idO.dismiss();
            this.idO = null;
        }
        if (this.idF != null) {
            this.idF.dismiss();
            this.idF = null;
        }
        if (this.idG != null) {
            this.idG.dismiss();
            this.idG = null;
        }
    }
}
