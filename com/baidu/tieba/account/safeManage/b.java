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
    private BaseActivity cWM;
    private LinearLayout cWR;
    private TbSettingTextTipView cWS;
    private TbSettingTextTipView cWT;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.cWM = baseActivity;
        this.mOnClickListener = onClickListener;
        aqv();
    }

    private void aqv() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.cWM).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.cWR = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.cWS = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.cWT = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.cWS.aqx();
        this.cWT.aqx();
        this.cWS.setOnClickListener(this.mOnClickListener);
        this.cWT.setOnClickListener(this.mOnClickListener);
    }

    public void jZ(int i) {
        this.cWM.getLayoutMode().setNightMode(i == 1);
        this.cWM.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.cWT.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.cWM = null;
    }
}
