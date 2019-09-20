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
    private BaseActivity cXM;
    private LinearLayout cXR;
    private TbSettingTextTipView cXS;
    private TbSettingTextTipView cXT;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.cXM = baseActivity;
        this.mOnClickListener = onClickListener;
        aqJ();
    }

    private void aqJ() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.cXM).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.cXR = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.cXS = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.cXT = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.cXS.aqL();
        this.cXT.aqL();
        this.cXS.setOnClickListener(this.mOnClickListener);
        this.cXT.setOnClickListener(this.mOnClickListener);
    }

    public void kd(int i) {
        this.cXM.getLayoutMode().setNightMode(i == 1);
        this.cXM.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.cXT.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.cXM = null;
    }
}
