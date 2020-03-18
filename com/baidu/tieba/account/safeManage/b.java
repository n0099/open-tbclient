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
    private LinearLayout dYY;
    private TbSettingTextTipView dYZ;
    private TbSettingTextTipView dZa;
    private BaseActivity mActivity;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mOnClickListener = onClickListener;
        aMW();
    }

    private void aMW() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.dYY = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.dYZ = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.dZa = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.dYZ.aMY();
        this.dZa.aMY();
        this.dYZ.setOnClickListener(this.mOnClickListener);
        this.dZa.setOnClickListener(this.mOnClickListener);
    }

    public void mg(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.dZa.setTip(simpleUser.block_msg);
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
