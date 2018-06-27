package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class b {
    private TbSettingTextTipView bmA;
    private BaseActivity bmt;
    private LinearLayout bmy;
    private TbSettingTextTipView bmz;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bmt = baseActivity;
        this.mOnClickListener = onClickListener;
        FU();
    }

    private void FU() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bmt).inflate(d.i.account_safe_activity, (ViewGroup) null);
        this.bmy = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.bmz = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.bmA = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.bmz.FW();
        this.bmA.FW();
        this.bmz.setOnClickListener(this.mOnClickListener);
        this.bmA.setOnClickListener(this.mOnClickListener);
    }

    public void ev(int i) {
        this.bmt.getLayoutMode().setNightMode(i == 1);
        this.bmt.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bmA.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bmt = null;
    }
}
