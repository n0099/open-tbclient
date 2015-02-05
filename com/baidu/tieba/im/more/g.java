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
    private View.OnClickListener bal;
    private j bjT;
    private TbSettingTextTipView bka;
    private TbSettingTextTipView bkb;
    private TbSettingTextTipView bkc;
    private TbSettingTextTipView bkd;
    private SettingTextSwitchView bke;
    private SecretSettingActivity bkf;
    private View bkg;
    private String[] bkh;
    private com.baidu.adp.widget.BdSwitchView.c bki;
    private View mBack;
    private NavigationBar mNavigationBar;
    private LinearLayout mParent;

    public g(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.bal = new h(this);
        this.bki = new i(this);
        this.bkf = secretSettingActivity;
        secretSettingActivity.setContentView(x.secret_setting_activity);
        d(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.bkf.getLayoutMode().ab(i == 1);
        this.bkf.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.bkf.getPageContext(), i);
        this.bke.da(i);
    }

    private void d(SecretSettingActivity secretSettingActivity) {
        this.mParent = (LinearLayout) secretSettingActivity.findViewById(w.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(z.secretSetting_title));
        this.bka = (TbSettingTextTipView) secretSettingActivity.findViewById(w.black_address_list);
        this.bkb = (TbSettingTextTipView) secretSettingActivity.findViewById(w.privacy_attention_bar);
        this.bkd = (TbSettingTextTipView) secretSettingActivity.findViewById(w.privacy_attention_group);
        this.bkc = (TbSettingTextTipView) secretSettingActivity.findViewById(w.privacy_attention_forum);
        this.mBack.setOnClickListener(this.bal);
        this.bka.setOnClickListener(this.bal);
        this.bkd.setOnClickListener(this.bal);
        this.bkb.setOnClickListener(this.bal);
        this.bkc.setOnClickListener(this.bal);
        this.bkg = this.bkf.findViewById(w.privacy_setting_container);
        this.bkh = this.bkf.getResources().getStringArray(r.privacy_setting_config);
        this.bke = (SettingTextSwitchView) this.bkf.findViewById(w.sv_shared_location);
        this.bke.setSwitchStateChangeListener(this.bki);
    }

    public void a(j jVar) {
        this.bjT = jVar;
    }

    public void RH() {
        this.bka.recycle();
    }

    public void dh(boolean z) {
        if (z) {
            this.bkg.setVisibility(0);
        } else {
            this.bkg.setVisibility(8);
        }
    }

    public void Q(String str, int i) {
        int i2 = i - 1;
        if (this.bkh != null && i2 < this.bkh.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.bkb.setTip(this.bkh[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.bkc.setTip(this.bkh[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.bkd.setTip(this.bkh[i2]);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.bkh != null) {
            int length = this.bkh.length;
            int uI = aVar.uI() - 1;
            if (uI < length && uI >= 0) {
                this.bkd.setTip(this.bkh[uI]);
            }
            int RA = aVar.RA() - 1;
            if (RA < length && RA >= 0) {
                this.bkb.setTip(this.bkh[RA]);
            }
            int Ry = aVar.Ry() - 1;
            if (Ry < length && Ry >= 0) {
                this.bkc.setTip(this.bkh[Ry]);
            }
            di(aVar.RB());
        }
    }

    public void di(boolean z) {
        if (z) {
            this.bke.getSwitchView().iC();
        } else {
            this.bke.getSwitchView().iD();
        }
    }

    public boolean RI() {
        return this.bke.getSwitchView().iG();
    }
}
