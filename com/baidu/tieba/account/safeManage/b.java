package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import tbclient.SimpleUser;
/* loaded from: classes16.dex */
public class b {
    private LinearLayout fnR;
    private TbSettingTextTipView fnS;
    private TbSettingTextTipView fnT;
    private BaseActivity mActivity;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mOnClickListener = onClickListener;
        bpY();
    }

    private void bpY() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.fnR = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.fnS = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.fnT = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.fnS.bqa();
        this.fnT.bqa();
        this.fnS.setOnClickListener(this.mOnClickListener);
        this.fnT.setOnClickListener(this.mOnClickListener);
    }

    public void pT(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.fnT.setTip(simpleUser.block_msg);
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
