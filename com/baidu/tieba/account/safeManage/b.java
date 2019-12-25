package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import tbclient.SimpleUser;
/* loaded from: classes6.dex */
public class b {
    private LinearLayout dUh;
    private TbSettingTextTipView dUi;
    private TbSettingTextTipView dUj;
    private BaseActivity mActivity;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mOnClickListener = onClickListener;
        aKa();
    }

    private void aKa() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.dUh = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.dUi = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.dUj = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.dUi.aKc();
        this.dUj.aKc();
        this.dUi.setOnClickListener(this.mOnClickListener);
        this.dUj.setOnClickListener(this.mOnClickListener);
    }

    public void lM(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.dUj.setTip(simpleUser.block_msg);
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
