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
    private LinearLayout eNL;
    private TbSettingTextTipView eNM;
    private TbSettingTextTipView eNN;
    private BaseActivity mActivity;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mOnClickListener = onClickListener;
        bbB();
    }

    private void bbB() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.eNL = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.eNM = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.eNN = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.eNM.bbD();
        this.eNN.bbD();
        this.eNM.setOnClickListener(this.mOnClickListener);
        this.eNN.setOnClickListener(this.mOnClickListener);
    }

    public void mW(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.eNN.setTip(simpleUser.block_msg);
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
