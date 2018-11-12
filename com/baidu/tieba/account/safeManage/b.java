package com.baidu.tieba.account.safeManage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class b {
    private BaseActivity bxI;
    private LinearLayout bxN;
    private TbSettingTextTipView bxO;
    private TbSettingTextTipView bxP;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bxI = baseActivity;
        this.mOnClickListener = onClickListener;
        Jt();
    }

    private void Jt() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bxI).inflate(e.h.account_safe_activity, (ViewGroup) null);
        this.bxN = (LinearLayout) this.mRootLayout.findViewById(e.g.content_container);
        this.bxO = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.bar_record);
        this.bxP = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.account_status);
        this.bxO.Jv();
        this.bxP.Jv();
        this.bxO.setOnClickListener(this.mOnClickListener);
        this.bxP.setOnClickListener(this.mOnClickListener);
    }

    public void fg(int i) {
        this.bxI.getLayoutMode().setNightMode(i == 1);
        this.bxI.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bxP.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bxI = null;
    }
}
