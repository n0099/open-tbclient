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
    private BaseActivity bcJ;
    private LinearLayout bcO;
    private TbSettingTextTipView bcP;
    private TbSettingTextTipView bcQ;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bcJ = baseActivity;
        this.mOnClickListener = onClickListener;
        Cb();
    }

    private void Cb() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bcJ).inflate(d.i.account_safe_activity, (ViewGroup) null);
        this.bcO = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.bcP = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.bcQ = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.bcP.Cd();
        this.bcQ.Cd();
        this.bcP.setOnClickListener(this.mOnClickListener);
        this.bcQ.setOnClickListener(this.mOnClickListener);
    }

    public void eq(int i) {
        this.bcJ.getLayoutMode().setNightMode(i == 1);
        this.bcJ.getLayoutMode().u(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bcQ.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bcJ = null;
    }
}
