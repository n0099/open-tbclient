package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class b {
    private BaseActivity bSF;
    private LinearLayout bSK;
    private TbSettingTextTipView bSL;
    private TbSettingTextTipView bSM;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bSF = baseActivity;
        this.mOnClickListener = onClickListener;
        Jv();
    }

    private void Jv() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bSF).inflate(d.h.account_safe_activity, (ViewGroup) null);
        this.bSK = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.bSL = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.bSM = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.bSL.Jx();
        this.bSM.Jx();
        this.bSL.setOnClickListener(this.mOnClickListener);
        this.bSM.setOnClickListener(this.mOnClickListener);
    }

    public void hr(int i) {
        this.bSF.getLayoutMode().aQ(i == 1);
        this.bSF.getLayoutMode().aM(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bSM.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bSF = null;
    }
}
