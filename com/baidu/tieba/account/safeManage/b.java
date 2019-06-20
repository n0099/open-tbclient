package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class b {
    private BaseActivity cVq;
    private LinearLayout cVv;
    private TbSettingTextTipView cVw;
    private TbSettingTextTipView cVx;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.cVq = baseActivity;
        this.mOnClickListener = onClickListener;
        apq();
    }

    private void apq() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.cVq).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.cVv = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.cVw = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.cVx = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.cVw.aps();
        this.cVx.aps();
        this.cVw.setOnClickListener(this.mOnClickListener);
        this.cVx.setOnClickListener(this.mOnClickListener);
    }

    public void jT(int i) {
        this.cVq.getLayoutMode().setNightMode(i == 1);
        this.cVq.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.cVx.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.cVq = null;
    }
}
