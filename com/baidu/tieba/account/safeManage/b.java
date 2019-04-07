package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class b {
    private BaseActivity cNc;
    private LinearLayout cNh;
    private TbSettingTextTipView cNi;
    private TbSettingTextTipView cNj;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.cNc = baseActivity;
        this.mOnClickListener = onClickListener;
        akn();
    }

    private void akn() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.cNc).inflate(d.h.account_safe_activity, (ViewGroup) null);
        this.cNh = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.cNi = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.cNj = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.cNi.akp();
        this.cNj.akp();
        this.cNi.setOnClickListener(this.mOnClickListener);
        this.cNj.setOnClickListener(this.mOnClickListener);
    }

    public void jf(int i) {
        this.cNc.getLayoutMode().setNightMode(i == 1);
        this.cNc.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.cNj.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.cNc = null;
    }
}
