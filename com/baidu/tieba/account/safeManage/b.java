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
    private BaseActivity cNa;
    private LinearLayout cNf;
    private TbSettingTextTipView cNg;
    private TbSettingTextTipView cNh;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.cNa = baseActivity;
        this.mOnClickListener = onClickListener;
        akq();
    }

    private void akq() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.cNa).inflate(d.h.account_safe_activity, (ViewGroup) null);
        this.cNf = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.cNg = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.cNh = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.cNg.aks();
        this.cNh.aks();
        this.cNg.setOnClickListener(this.mOnClickListener);
        this.cNh.setOnClickListener(this.mOnClickListener);
    }

    public void jg(int i) {
        this.cNa.getLayoutMode().setNightMode(i == 1);
        this.cNa.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.cNh.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.cNa = null;
    }
}
