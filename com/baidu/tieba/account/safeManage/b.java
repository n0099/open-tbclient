package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class b {
    private LinearLayout dYv;
    private TbSettingTextTipView dYw;
    private TbSettingTextTipView dYx;
    private BaseActivity mActivity;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mOnClickListener = onClickListener;
        aMR();
    }

    private void aMR() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.dYv = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.dYw = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.dYx = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.dYw.aMT();
        this.dYx.aMT();
        this.dYw.setOnClickListener(this.mOnClickListener);
        this.dYx.setOnClickListener(this.mOnClickListener);
    }

    public void me(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.dYx.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.mActivity = null;
    }
}
