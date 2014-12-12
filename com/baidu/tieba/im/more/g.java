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
    private View.OnClickListener aYQ;
    private TbSettingTextTipView biE;
    private TbSettingTextTipView biF;
    private TbSettingTextTipView biG;
    private TbSettingTextTipView biH;
    private SettingTextSwitchView biI;
    private SecretSettingActivity biJ;
    private View biK;
    private String[] biL;
    private com.baidu.adp.widget.BdSwitchView.c biM;
    private j bix;
    private View mBack;
    private NavigationBar mNavigationBar;
    private LinearLayout mParent;

    public g(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aYQ = new h(this);
        this.biM = new i(this);
        this.biJ = secretSettingActivity;
        secretSettingActivity.setContentView(x.secret_setting_activity);
        d(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.biJ.getLayoutMode().ab(i == 1);
        this.biJ.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.biJ.getPageContext(), i);
        this.biI.cT(i);
    }

    private void d(SecretSettingActivity secretSettingActivity) {
        this.mParent = (LinearLayout) secretSettingActivity.findViewById(w.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(z.secretSetting_title));
        this.biE = (TbSettingTextTipView) secretSettingActivity.findViewById(w.black_address_list);
        this.biF = (TbSettingTextTipView) secretSettingActivity.findViewById(w.privacy_attention_bar);
        this.biH = (TbSettingTextTipView) secretSettingActivity.findViewById(w.privacy_attention_group);
        this.biG = (TbSettingTextTipView) secretSettingActivity.findViewById(w.privacy_attention_forum);
        this.mBack.setOnClickListener(this.aYQ);
        this.biE.setOnClickListener(this.aYQ);
        this.biH.setOnClickListener(this.aYQ);
        this.biF.setOnClickListener(this.aYQ);
        this.biG.setOnClickListener(this.aYQ);
        this.biK = this.biJ.findViewById(w.privacy_setting_container);
        this.biL = this.biJ.getResources().getStringArray(r.privacy_setting_config);
        this.biI = (SettingTextSwitchView) this.biJ.findViewById(w.sv_shared_location);
        this.biI.setSwitchStateChangeListener(this.biM);
    }

    public void a(j jVar) {
        this.bix = jVar;
    }

    public void Rq() {
        this.biE.recycle();
    }

    public void dc(boolean z) {
        if (z) {
            this.biK.setVisibility(0);
        } else {
            this.biK.setVisibility(8);
        }
    }

    public void Q(String str, int i) {
        int i2 = i - 1;
        if (this.biL != null && i2 < this.biL.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.biF.setTip(this.biL[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.biG.setTip(this.biL[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.biH.setTip(this.biL[i2]);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.biL != null) {
            int length = this.biL.length;
            int ux = aVar.ux() - 1;
            if (ux < length && ux >= 0) {
                this.biH.setTip(this.biL[ux]);
            }
            int Rj = aVar.Rj() - 1;
            if (Rj < length && Rj >= 0) {
                this.biF.setTip(this.biL[Rj]);
            }
            int Rh = aVar.Rh() - 1;
            if (Rh < length && Rh >= 0) {
                this.biG.setTip(this.biL[Rh]);
            }
            dd(aVar.Rk());
        }
    }

    public void dd(boolean z) {
        if (z) {
            this.biI.getSwitchView().iI();
        } else {
            this.biI.getSwitchView().iJ();
        }
    }

    public boolean Rr() {
        return this.biI.getSwitchView().iM();
    }
}
