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
    private BaseActivity bBW;
    private LinearLayout bCb;
    private TbSettingTextTipView bCc;
    private TbSettingTextTipView bCd;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bBW = baseActivity;
        this.mOnClickListener = onClickListener;
        KN();
    }

    private void KN() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bBW).inflate(e.h.account_safe_activity, (ViewGroup) null);
        this.bCb = (LinearLayout) this.mRootLayout.findViewById(e.g.content_container);
        this.bCc = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.bar_record);
        this.bCd = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.account_status);
        this.bCc.KP();
        this.bCd.KP();
        this.bCc.setOnClickListener(this.mOnClickListener);
        this.bCd.setOnClickListener(this.mOnClickListener);
    }

    public void fv(int i) {
        this.bBW.getLayoutMode().setNightMode(i == 1);
        this.bBW.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bCd.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bBW = null;
    }
}
