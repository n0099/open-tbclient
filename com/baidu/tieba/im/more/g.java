package com.baidu.tieba.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.r;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.g<SecretSettingActivity> {
    private View.OnClickListener bam;
    private j bjU;
    private TbSettingTextTipView bkb;
    private TbSettingTextTipView bkc;
    private TbSettingTextTipView bkd;
    private TbSettingTextTipView bke;
    private SettingTextSwitchView bkf;
    private SecretSettingActivity bkg;
    private View bkh;
    private String[] bki;
    private com.baidu.adp.widget.BdSwitchView.c bkj;
    private View mBack;
    private NavigationBar mNavigationBar;
    private LinearLayout mParent;

    public g(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.bam = new h(this);
        this.bkj = new i(this);
        this.bkg = secretSettingActivity;
        secretSettingActivity.setContentView(x.secret_setting_activity);
        d(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.bkg.getLayoutMode().ab(i == 1);
        this.bkg.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.bkg.getPageContext(), i);
        this.bkf.da(i);
    }

    private void d(SecretSettingActivity secretSettingActivity) {
        this.mParent = (LinearLayout) secretSettingActivity.findViewById(w.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(z.secretSetting_title));
        this.bkb = (TbSettingTextTipView) secretSettingActivity.findViewById(w.black_address_list);
        this.bkc = (TbSettingTextTipView) secretSettingActivity.findViewById(w.privacy_attention_bar);
        this.bke = (TbSettingTextTipView) secretSettingActivity.findViewById(w.privacy_attention_group);
        this.bkd = (TbSettingTextTipView) secretSettingActivity.findViewById(w.privacy_attention_forum);
        this.mBack.setOnClickListener(this.bam);
        this.bkb.setOnClickListener(this.bam);
        this.bke.setOnClickListener(this.bam);
        this.bkc.setOnClickListener(this.bam);
        this.bkd.setOnClickListener(this.bam);
        this.bkh = this.bkg.findViewById(w.privacy_setting_container);
        this.bki = this.bkg.getResources().getStringArray(r.privacy_setting_config);
        this.bkf = (SettingTextSwitchView) this.bkg.findViewById(w.sv_shared_location);
        this.bkf.setSwitchStateChangeListener(this.bkj);
    }

    public void a(j jVar) {
        this.bjU = jVar;
    }

    public void RM() {
        this.bkb.recycle();
    }

    public void dh(boolean z) {
        if (z) {
            this.bkh.setVisibility(0);
        } else {
            this.bkh.setVisibility(8);
        }
    }

    public void Q(String str, int i) {
        int i2 = i - 1;
        if (this.bki != null && i2 < this.bki.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.bkc.setTip(this.bki[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.bkd.setTip(this.bki[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.bke.setTip(this.bki[i2]);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.bki != null) {
            int length = this.bki.length;
            int uO = aVar.uO() - 1;
            if (uO < length && uO >= 0) {
                this.bke.setTip(this.bki[uO]);
            }
            int RF = aVar.RF() - 1;
            if (RF < length && RF >= 0) {
                this.bkc.setTip(this.bki[RF]);
            }
            int RD = aVar.RD() - 1;
            if (RD < length && RD >= 0) {
                this.bkd.setTip(this.bki[RD]);
            }
            di(aVar.RG());
        }
    }

    public void di(boolean z) {
        if (z) {
            this.bkf.getSwitchView().iJ();
        } else {
            this.bkf.getSwitchView().iK();
        }
    }

    public boolean RN() {
        return this.bkf.getSwitchView().iN();
    }
}
