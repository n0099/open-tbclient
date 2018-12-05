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
    private BaseActivity bBf;
    private LinearLayout bBk;
    private TbSettingTextTipView bBl;
    private TbSettingTextTipView bBm;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bBf = baseActivity;
        this.mOnClickListener = onClickListener;
        Kx();
    }

    private void Kx() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bBf).inflate(e.h.account_safe_activity, (ViewGroup) null);
        this.bBk = (LinearLayout) this.mRootLayout.findViewById(e.g.content_container);
        this.bBl = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.bar_record);
        this.bBm = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.account_status);
        this.bBl.Kz();
        this.bBm.Kz();
        this.bBl.setOnClickListener(this.mOnClickListener);
        this.bBm.setOnClickListener(this.mOnClickListener);
    }

    public void fu(int i) {
        this.bBf.getLayoutMode().setNightMode(i == 1);
        this.bBf.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bBm.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bBf = null;
    }
}
