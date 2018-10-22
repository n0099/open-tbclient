package com.baidu.tieba.im.chat;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<GroupSettingActivity> {
    private Button ezA;
    private com.baidu.tbadk.core.dialog.a ezB;
    private View ezC;
    private b.InterfaceC0124b ezf;
    private GroupSettingActivity ezr;
    private com.baidu.tbadk.core.dialog.b ezs;
    private com.baidu.tbadk.core.dialog.a ezt;
    private SettingTextSwitchView ezu;
    private SettingTextSwitchView ezv;
    private TbSettingTextTipView ezw;
    private TbSettingTextTipView ezx;
    private TbSettingTextTipView ezy;
    private Button ezz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0124b interfaceC0124b) {
        this.ezf = interfaceC0124b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.ezr = null;
        this.mParent = null;
        this.ezs = null;
        this.ezu = null;
        this.ezv = null;
        this.ezw = null;
        this.ezx = null;
        this.ezy = null;
        this.ezf = null;
        this.ezr = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ezu.eS(i);
        this.ezv.eS(i);
        this.ezr.getLayoutMode().setNightMode(i == 1);
        this.ezr.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ezr.getPageContext(), i);
        al.i(this.ezz, e.f.big_red_button);
        al.i(this.ezA, e.f.big_red_button);
    }

    public View aMC() {
        return this.ezC;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ezw.setText(str);
        }
    }

    private void initView() {
        this.ezr.setContentView(e.h.group_setting_activity);
        this.ezu = (SettingTextSwitchView) this.ezr.findViewById(e.g.sv_group_msg_notify);
        this.ezv = (SettingTextSwitchView) this.ezr.findViewById(e.g.sv_group_add_group);
        this.ezw = (TbSettingTextTipView) this.ezr.findViewById(e.g.tv_change_name);
        this.ezx = (TbSettingTextTipView) this.ezr.findViewById(e.g.sv_report);
        this.ezy = (TbSettingTextTipView) this.ezr.findViewById(e.g.sv_delete_msg);
        this.ezz = (Button) this.ezr.findViewById(e.g.btn_dismiss);
        this.ezA = (Button) this.ezr.findViewById(e.g.btn_quit);
        this.mParent = (RelativeLayout) this.ezr.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.ezr.findViewById(e.g.view_navigation_bar);
        this.ezC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.group_setting);
    }

    public void initListener() {
        this.ezu.setSwitchStateChangeListener(this.ezr);
        this.ezv.setSwitchStateChangeListener(this.ezr);
        this.ezw.setOnClickListener(this.ezr);
        this.ezx.setOnClickListener(this.ezr);
        this.ezz.setOnClickListener(this.ezr);
        this.ezA.setOnClickListener(this.ezr);
        this.ezy.setOnClickListener(this.ezr);
    }

    public TbSettingTextTipView aMD() {
        return this.ezw;
    }

    public Button aME() {
        return this.ezA;
    }

    public Button aMF() {
        return this.ezz;
    }

    public TbSettingTextTipView aMG() {
        return this.ezx;
    }

    public TbSettingTextTipView aMH() {
        return this.ezy;
    }

    public void aMI() {
        if (this.ezt == null) {
            this.ezt = new com.baidu.tbadk.core.dialog.a(this.ezr.getPageContext().getPageActivity());
            this.ezt.cy(e.j.inform);
            this.ezt.cz(e.j.group_quit_alert);
            this.ezt.aO(false);
            this.ezt.a(e.j.alert_yes_button, this.ezr);
            this.ezt.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ezt.b(this.ezr.getPageContext());
            this.ezt.aP(true);
        }
        this.ezt.Au();
    }

    public com.baidu.tbadk.core.dialog.a aMJ() {
        return this.ezt;
    }

    public void Ed() {
        if (this.ezs == null) {
            this.ezs = new com.baidu.tbadk.core.dialog.b(this.ezr.getPageContext().getPageActivity());
            this.ezs.cC(e.j.group_report);
            this.ezs.a(new CharSequence[]{new SpannableString(this.ezr.getPageContext().getString(e.j.group_report_ad)), new SpannableString(this.ezr.getPageContext().getString(e.j.group_report_sex)), new SpannableString(this.ezr.getPageContext().getString(e.j.group_report_lllegal))}, this.ezf);
            this.ezs.d(this.ezr.getPageContext());
        }
        this.ezs.Ax();
    }

    public void aMK() {
        if (this.ezA != null) {
            this.ezA.setVisibility(8);
        }
    }

    public void aML() {
        if (this.ezz != null) {
            this.ezz.setVisibility(8);
        }
    }

    public void hO(boolean z) {
        if (this.ezv != null) {
            this.ezv.setVisibility(z ? 0 : 8);
        }
    }

    public void hP(boolean z) {
        if (z) {
            this.ezv.nU();
        } else {
            this.ezv.nV();
        }
    }

    public void aMM() {
        if (this.ezA != null) {
            this.ezA.setVisibility(0);
        }
    }

    public void aMN() {
        if (this.ezz != null) {
            this.ezz.setVisibility(0);
        }
    }

    public void alU() {
        if (this.ezx != null) {
            this.ezx.setVisibility(0);
        }
    }

    public void aMO() {
        if (this.ezx != null) {
            this.ezx.setVisibility(8);
        }
    }

    public BdSwitchView aMP() {
        return this.ezv.getSwitchView();
    }

    public BdSwitchView aMQ() {
        return this.ezu.getSwitchView();
    }

    public void aMR() {
        if (this.ezB == null) {
            this.ezB = new com.baidu.tbadk.core.dialog.a(this.ezr.getPageContext().getPageActivity());
            this.ezB.cz(e.j.group_dismiss_alert);
            this.ezB.aO(false);
            this.ezB.a(e.j.alert_yes_button, this.ezr);
            this.ezB.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ezB.b(this.ezr.getPageContext());
        }
        this.ezB.Au();
    }

    public com.baidu.tbadk.core.dialog.a aMS() {
        return this.ezB;
    }

    public void aMT() {
        if (this.ezB != null) {
            this.ezB.dismiss();
            this.ezB = null;
        }
        if (this.ezs != null) {
            this.ezs.dismiss();
            this.ezs = null;
        }
        if (this.ezt != null) {
            this.ezt.dismiss();
            this.ezt = null;
        }
    }
}
