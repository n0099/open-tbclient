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
    private BaseActivity cWT;
    private LinearLayout cWY;
    private TbSettingTextTipView cWZ;
    private TbSettingTextTipView cXa;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.cWT = baseActivity;
        this.mOnClickListener = onClickListener;
        aqx();
    }

    private void aqx() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.cWT).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.cWY = (LinearLayout) this.mRootLayout.findViewById(R.id.content_container);
        this.cWZ = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.bar_record);
        this.cXa = (TbSettingTextTipView) this.mRootLayout.findViewById(R.id.account_status);
        this.cWZ.aqz();
        this.cXa.aqz();
        this.cWZ.setOnClickListener(this.mOnClickListener);
        this.cXa.setOnClickListener(this.mOnClickListener);
    }

    public void ka(int i) {
        this.cWT.getLayoutMode().setNightMode(i == 1);
        this.cWT.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.cXa.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.cWT = null;
    }
}
