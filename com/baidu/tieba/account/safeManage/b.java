package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.f;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class b {
    private BaseActivity bnc;
    private LinearLayout bnh;
    private TbSettingTextTipView bni;
    private TbSettingTextTipView bnj;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bnc = baseActivity;
        this.mOnClickListener = onClickListener;
        FQ();
    }

    private void FQ() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bnc).inflate(f.h.account_safe_activity, (ViewGroup) null);
        this.bnh = (LinearLayout) this.mRootLayout.findViewById(f.g.content_container);
        this.bni = (TbSettingTextTipView) this.mRootLayout.findViewById(f.g.bar_record);
        this.bnj = (TbSettingTextTipView) this.mRootLayout.findViewById(f.g.account_status);
        this.bni.FS();
        this.bnj.FS();
        this.bni.setOnClickListener(this.mOnClickListener);
        this.bnj.setOnClickListener(this.mOnClickListener);
    }

    public void ex(int i) {
        this.bnc.getLayoutMode().setNightMode(i == 1);
        this.bnc.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bnj.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bnc = null;
    }
}
