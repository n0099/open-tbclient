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
    private BaseActivity cNd;
    private LinearLayout cNi;
    private TbSettingTextTipView cNj;
    private TbSettingTextTipView cNk;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.cNd = baseActivity;
        this.mOnClickListener = onClickListener;
        akr();
    }

    private void akr() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.cNd).inflate(d.h.account_safe_activity, (ViewGroup) null);
        this.cNi = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.cNj = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.cNk = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.cNj.akt();
        this.cNk.akt();
        this.cNj.setOnClickListener(this.mOnClickListener);
        this.cNk.setOnClickListener(this.mOnClickListener);
    }

    public void jg(int i) {
        this.cNd.getLayoutMode().setNightMode(i == 1);
        this.cNd.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.cNk.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.cNd = null;
    }
}
