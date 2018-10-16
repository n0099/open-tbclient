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
    private com.baidu.tbadk.core.dialog.a ezA;
    private View ezB;
    private b.InterfaceC0124b eze;
    private GroupSettingActivity ezq;
    private com.baidu.tbadk.core.dialog.b ezr;
    private com.baidu.tbadk.core.dialog.a ezs;
    private SettingTextSwitchView ezt;
    private SettingTextSwitchView ezu;
    private TbSettingTextTipView ezv;
    private TbSettingTextTipView ezw;
    private TbSettingTextTipView ezx;
    private Button ezy;
    private Button ezz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public void a(b.InterfaceC0124b interfaceC0124b) {
        this.eze = interfaceC0124b;
    }

    public b(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity.getPageContext());
        this.ezq = null;
        this.mParent = null;
        this.ezr = null;
        this.ezt = null;
        this.ezu = null;
        this.ezv = null;
        this.ezw = null;
        this.ezx = null;
        this.eze = null;
        this.ezq = groupSettingActivity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ezt.eS(i);
        this.ezu.eS(i);
        this.ezq.getLayoutMode().setNightMode(i == 1);
        this.ezq.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ezq.getPageContext(), i);
        al.i(this.ezy, e.f.big_red_button);
        al.i(this.ezz, e.f.big_red_button);
    }

    public View aMC() {
        return this.ezB;
    }

    public void setGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ezv.setText(str);
        }
    }

    private void initView() {
        this.ezq.setContentView(e.h.group_setting_activity);
        this.ezt = (SettingTextSwitchView) this.ezq.findViewById(e.g.sv_group_msg_notify);
        this.ezu = (SettingTextSwitchView) this.ezq.findViewById(e.g.sv_group_add_group);
        this.ezv = (TbSettingTextTipView) this.ezq.findViewById(e.g.tv_change_name);
        this.ezw = (TbSettingTextTipView) this.ezq.findViewById(e.g.sv_report);
        this.ezx = (TbSettingTextTipView) this.ezq.findViewById(e.g.sv_delete_msg);
        this.ezy = (Button) this.ezq.findViewById(e.g.btn_dismiss);
        this.ezz = (Button) this.ezq.findViewById(e.g.btn_quit);
        this.mParent = (RelativeLayout) this.ezq.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.ezq.findViewById(e.g.view_navigation_bar);
        this.ezB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.group_setting);
    }

    public void initListener() {
        this.ezt.setSwitchStateChangeListener(this.ezq);
        this.ezu.setSwitchStateChangeListener(this.ezq);
        this.ezv.setOnClickListener(this.ezq);
        this.ezw.setOnClickListener(this.ezq);
        this.ezy.setOnClickListener(this.ezq);
        this.ezz.setOnClickListener(this.ezq);
        this.ezx.setOnClickListener(this.ezq);
    }

    public TbSettingTextTipView aMD() {
        return this.ezv;
    }

    public Button aME() {
        return this.ezz;
    }

    public Button aMF() {
        return this.ezy;
    }

    public TbSettingTextTipView aMG() {
        return this.ezw;
    }

    public TbSettingTextTipView aMH() {
        return this.ezx;
    }

    public void aMI() {
        if (this.ezs == null) {
            this.ezs = new com.baidu.tbadk.core.dialog.a(this.ezq.getPageContext().getPageActivity());
            this.ezs.cy(e.j.inform);
            this.ezs.cz(e.j.group_quit_alert);
            this.ezs.aO(false);
            this.ezs.a(e.j.alert_yes_button, this.ezq);
            this.ezs.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ezs.b(this.ezq.getPageContext());
            this.ezs.aP(true);
        }
        this.ezs.Au();
    }

    public com.baidu.tbadk.core.dialog.a aMJ() {
        return this.ezs;
    }

    public void Ed() {
        if (this.ezr == null) {
            this.ezr = new com.baidu.tbadk.core.dialog.b(this.ezq.getPageContext().getPageActivity());
            this.ezr.cC(e.j.group_report);
            this.ezr.a(new CharSequence[]{new SpannableString(this.ezq.getPageContext().getString(e.j.group_report_ad)), new SpannableString(this.ezq.getPageContext().getString(e.j.group_report_sex)), new SpannableString(this.ezq.getPageContext().getString(e.j.group_report_lllegal))}, this.eze);
            this.ezr.d(this.ezq.getPageContext());
        }
        this.ezr.Ax();
    }

    public void aMK() {
        if (this.ezz != null) {
            this.ezz.setVisibility(8);
        }
    }

    public void aML() {
        if (this.ezy != null) {
            this.ezy.setVisibility(8);
        }
    }

    public void hO(boolean z) {
        if (this.ezu != null) {
            this.ezu.setVisibility(z ? 0 : 8);
        }
    }

    public void hP(boolean z) {
        if (z) {
            this.ezu.nU();
        } else {
            this.ezu.nV();
        }
    }

    public void aMM() {
        if (this.ezz != null) {
            this.ezz.setVisibility(0);
        }
    }

    public void aMN() {
        if (this.ezy != null) {
            this.ezy.setVisibility(0);
        }
    }

    public void alT() {
        if (this.ezw != null) {
            this.ezw.setVisibility(0);
        }
    }

    public void aMO() {
        if (this.ezw != null) {
            this.ezw.setVisibility(8);
        }
    }

    public BdSwitchView aMP() {
        return this.ezu.getSwitchView();
    }

    public BdSwitchView aMQ() {
        return this.ezt.getSwitchView();
    }

    public void aMR() {
        if (this.ezA == null) {
            this.ezA = new com.baidu.tbadk.core.dialog.a(this.ezq.getPageContext().getPageActivity());
            this.ezA.cz(e.j.group_dismiss_alert);
            this.ezA.aO(false);
            this.ezA.a(e.j.alert_yes_button, this.ezq);
            this.ezA.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ezA.b(this.ezq.getPageContext());
        }
        this.ezA.Au();
    }

    public com.baidu.tbadk.core.dialog.a aMS() {
        return this.ezA;
    }

    public void aMT() {
        if (this.ezA != null) {
            this.ezA.dismiss();
            this.ezA = null;
        }
        if (this.ezr != null) {
            this.ezr.dismiss();
            this.ezr = null;
        }
        if (this.ezs != null) {
            this.ezs.dismiss();
            this.ezs = null;
        }
    }
}
