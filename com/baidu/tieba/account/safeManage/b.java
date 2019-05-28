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
    private BaseActivity cVp;
    private LinearLayout cVu;
    private TbSettingTextTipView cVv;
    private TbSettingTextTipView cVw;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.cVp = baseActivity;
        this.mOnClickListener = onClickListener;
        apq();
    }

    private void apq() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.cVp).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.cVu = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.cVv = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.cVw = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.cVv.aps();
        this.cVw.aps();
        this.cVv.setOnClickListener(this.mOnClickListener);
        this.cVw.setOnClickListener(this.mOnClickListener);
    }

    public void jT(int i) {
        this.cVp.getLayoutMode().setNightMode(i == 1);
        this.cVp.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.cVw.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.cVp = null;
    }
}
