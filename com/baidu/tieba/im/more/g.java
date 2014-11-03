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
    private View Jt;
    private View.OnClickListener aGJ;
    private j bfe;
    private TbSettingTextTipView bfl;
    private TbSettingTextTipView bfm;
    private TbSettingTextTipView bfn;
    private TbSettingTextTipView bfo;
    private SettingTextSwitchView bfp;
    private SecretSettingActivity bfq;
    private View bfr;
    private String[] bfs;
    private com.baidu.adp.widget.BdSwitchView.c bft;
    private NavigationBar mNavigationBar;
    private LinearLayout mParent;

    public g(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity);
        this.mNavigationBar = null;
        this.aGJ = new h(this);
        this.bft = new i(this);
        this.bfq = secretSettingActivity;
        secretSettingActivity.setContentView(w.secret_setting_activity);
        d(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.bfq.getLayoutMode().L(i == 1);
        this.bfq.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
        this.bfp.cu(i);
    }

    private void d(SecretSettingActivity secretSettingActivity) {
        this.mParent = (LinearLayout) secretSettingActivity.findViewById(v.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(v.view_navigation_bar);
        this.Jt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getString(y.secretSetting_title));
        this.bfl = (TbSettingTextTipView) secretSettingActivity.findViewById(v.black_address_list);
        this.bfm = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_bar);
        this.bfo = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_group);
        this.bfn = (TbSettingTextTipView) secretSettingActivity.findViewById(v.privacy_attention_forum);
        this.Jt.setOnClickListener(this.aGJ);
        this.bfl.setOnClickListener(this.aGJ);
        this.bfo.setOnClickListener(this.aGJ);
        this.bfm.setOnClickListener(this.aGJ);
        this.bfn.setOnClickListener(this.aGJ);
        this.bfr = this.bfq.findViewById(v.privacy_setting_container);
        this.bfs = this.bfq.getResources().getStringArray(q.privacy_setting_config);
        this.bfp = (SettingTextSwitchView) this.bfq.findViewById(v.sv_shared_location);
        this.bfp.setSwitchStateChangeListener(this.bft);
    }

    public void a(j jVar) {
        this.bfe = jVar;
    }

    public void QR() {
        this.bfl.recycle();
    }

    public void dn(boolean z) {
        if (z) {
            this.bfr.setVisibility(0);
        } else {
            this.bfr.setVisibility(8);
        }
    }

    public void J(String str, int i) {
        int i2 = i - 1;
        if (this.bfs != null && i2 < this.bfs.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.bfm.setTip(this.bfs[i2]);
            } else if (TextUtils.equals(str, "post")) {
                this.bfn.setTip(this.bfs[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.bfo.setTip(this.bfs[i2]);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.bfs != null) {
            int length = this.bfs.length;
            int qV = aVar.qV() - 1;
            if (qV < length && qV >= 0) {
                this.bfo.setTip(this.bfs[qV]);
            }
            int QK = aVar.QK() - 1;
            if (QK < length && QK >= 0) {
                this.bfm.setTip(this.bfs[QK]);
            }
            int QI = aVar.QI() - 1;
            if (QI < length && QI >= 0) {
                this.bfn.setTip(this.bfs[QI]);
            }
            dp(aVar.QL());
        }
    }

    public void dp(boolean z) {
        if (z) {
            this.bfp.getSwitchView().gL();
        } else {
            this.bfp.getSwitchView().gM();
        }
    }

    public boolean QS() {
        return this.bfp.getSwitchView().gP();
    }
}
