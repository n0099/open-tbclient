package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class b {
    private BaseActivity bBV;
    private LinearLayout bCa;
    private TbSettingTextTipView bCb;
    private TbSettingTextTipView bCc;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bBV = baseActivity;
        this.mOnClickListener = onClickListener;
        KN();
    }

    private void KN() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bBV).inflate(e.h.account_safe_activity, (ViewGroup) null);
        this.bCa = (LinearLayout) this.mRootLayout.findViewById(e.g.content_container);
        this.bCb = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.bar_record);
        this.bCc = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.account_status);
        this.bCb.KP();
        this.bCc.KP();
        this.bCb.setOnClickListener(this.mOnClickListener);
        this.bCc.setOnClickListener(this.mOnClickListener);
    }

    public void fv(int i) {
        this.bBV.getLayoutMode().setNightMode(i == 1);
        this.bBV.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bCc.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bBV = null;
    }
}
