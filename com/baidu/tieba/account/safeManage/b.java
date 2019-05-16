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
    private BaseActivity cVo;
    private LinearLayout cVt;
    private TbSettingTextTipView cVu;
    private TbSettingTextTipView cVv;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.cVo = baseActivity;
        this.mOnClickListener = onClickListener;
        apq();
    }

    private void apq() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.cVo).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.cVt = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.cVu = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.cVv = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.cVu.aps();
        this.cVv.aps();
        this.cVu.setOnClickListener(this.mOnClickListener);
        this.cVv.setOnClickListener(this.mOnClickListener);
    }

    public void jT(int i) {
        this.cVo.getLayoutMode().setNightMode(i == 1);
        this.cVo.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.cVv.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.cVo = null;
    }
}
