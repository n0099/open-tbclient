package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import tbclient.SimpleUser;
/* loaded from: classes22.dex */
public class b {
    private TbSettingTextTipView fRA;
    private LinearLayout fRy;
    private TbSettingTextTipView fRz;
    private BaseActivity mActivity;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mOnClickListener = onClickListener;
        bxV();
    }

    private void bxV() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.fRy = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.fRz = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.fRA = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.fRz.bxX();
        this.fRA.bxX();
        this.fRz.setOnClickListener(this.mOnClickListener);
        this.fRA.setOnClickListener(this.mOnClickListener);
    }

    public void qZ(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.fRA.setTip(simpleUser.block_msg);
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
