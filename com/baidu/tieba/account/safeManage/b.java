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
    private LinearLayout dYu;
    private TbSettingTextTipView dYv;
    private TbSettingTextTipView dYw;
    private BaseActivity mActivity;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mOnClickListener = onClickListener;
        aMP();
    }

    private void aMP() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.dYu = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.dYv = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.dYw = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.dYv.aMR();
        this.dYw.aMR();
        this.dYv.setOnClickListener(this.mOnClickListener);
        this.dYw.setOnClickListener(this.mOnClickListener);
    }

    public void me(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.dYw.setTip(simpleUser.block_msg);
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
