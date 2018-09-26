package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class b {
    private BaseActivity bsQ;
    private LinearLayout bsV;
    private TbSettingTextTipView bsW;
    private TbSettingTextTipView bsX;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bsQ = baseActivity;
        this.mOnClickListener = onClickListener;
        Hg();
    }

    private void Hg() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bsQ).inflate(e.h.account_safe_activity, (ViewGroup) null);
        this.bsV = (LinearLayout) this.mRootLayout.findViewById(e.g.content_container);
        this.bsW = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.bar_record);
        this.bsX = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.account_status);
        this.bsW.Hi();
        this.bsX.Hi();
        this.bsW.setOnClickListener(this.mOnClickListener);
        this.bsX.setOnClickListener(this.mOnClickListener);
    }

    public void eJ(int i) {
        this.bsQ.getLayoutMode().setNightMode(i == 1);
        this.bsQ.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bsX.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bsQ = null;
    }
}
