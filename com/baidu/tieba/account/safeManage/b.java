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
    private BaseActivity bcK;
    private LinearLayout bcP;
    private TbSettingTextTipView bcQ;
    private TbSettingTextTipView bcR;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bcK = baseActivity;
        this.mOnClickListener = onClickListener;
        BZ();
    }

    private void BZ() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bcK).inflate(d.i.account_safe_activity, (ViewGroup) null);
        this.bcP = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.bcQ = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.bcR = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.bcQ.Cb();
        this.bcR.Cb();
        this.bcQ.setOnClickListener(this.mOnClickListener);
        this.bcR.setOnClickListener(this.mOnClickListener);
    }

    public void eq(int i) {
        this.bcK.getLayoutMode().setNightMode(i == 1);
        this.bcK.getLayoutMode().u(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bcR.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bcK = null;
    }
}
