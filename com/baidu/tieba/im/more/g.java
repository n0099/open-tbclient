package com.baidu.tieba.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.q;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.f {
    private View Js;
    private View.OnClickListener aGz;
    private j beQ;
    private TbSettingTextTipView beX;
    private TbSettingTextTipView beY;
    private TbSettingTextTipView beZ;
    private TbSettingTextTipView bfa;
    private SettingTextSwitchView bfb;
    private SecretSettingActivity bfc;
    private View bfd;
    private String[] bfe;
    private com.baidu.adp.widget.BdSwitchView.c bff;
    private NavigationBar mNavigationBar;
    private LinearLayout mParent;

    public g(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity);
        this.mNavigationBar = null;
        this.aGz = new h(this);
        this.bff = new i(this);
        this.bfc = secretSettingActivity;
        secretSettingActivity.setContentView(w.secret_setting_activity);
        d(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.bfc.getLayoutMode().L(i == 1);
        this.bfc.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
        this.bfb.cu(i);
    }

    private void d(SecretSettingActivity secretSettingActivity) {
        this.mParent = (LinearLayout) secretSettingActivity.findViewById(v.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(v.view_navigation_bar);
        this.Js = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getString(y.secretSetting_title));
        this.beX = (TbSettingTextTipView) secretSettingActivity.findViewById(v.black_address_list);
        this.beY = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_bar);
        this.bfa = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_group);
        this.beZ = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_forum);
        this.Js.setOnClickListener(this.aGz);
        this.beX.setOnClickListener(this.aGz);
        this.bfa.setOnClickListener(this.aGz);
        this.beY.setOnClickListener(this.aGz);
        this.beZ.setOnClickListener(this.aGz);
        this.bfd = this.bfc.findViewById(v.privacy_setting_container);
        this.bfe = this.bfc.getResources().getStringArray(q.privacy_setting_config);
        this.bfb = (SettingTextSwitchView) this.bfc.findViewById(v.sv_shared_location);
        this.bfb.setSwitchStateChangeListener(this.bff);
    }

    public void a(j jVar) {
        this.beQ = jVar;
    }

    public void QO() {
        this.beX.recycle();
    }

    public void dn(boolean z) {
        if (z) {
            this.bfd.setVisibility(0);
        } else {
            this.bfd.setVisibility(8);
        }
    }

    public void J(String str, int i) {
        int i2 = i - 1;
        if (this.bfe != null && i2 < this.bfe.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.beY.setTip(this.bfe[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.beZ.setTip(this.bfe[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.bfa.setTip(this.bfe[i2]);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.bfe != null) {
            int length = this.bfe.length;
            int qT = aVar.qT() - 1;
            if (qT < length && qT >= 0) {
                this.bfa.setTip(this.bfe[qT]);
            }
            int QH = aVar.QH() - 1;
            if (QH < length && QH >= 0) {
                this.beY.setTip(this.bfe[QH]);
            }
            int QF = aVar.QF() - 1;
            if (QF < length && QF >= 0) {
                this.beZ.setTip(this.bfe[QF]);
            }
            dp(aVar.QI());
        }
    }

    public void dp(boolean z) {
        if (z) {
            this.bfb.getSwitchView().gL();
        } else {
            this.bfb.getSwitchView().gM();
        }
    }

    public boolean QP() {
        return this.bfb.getSwitchView().gP();
    }
}
