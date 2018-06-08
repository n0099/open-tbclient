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
    private BaseActivity bkU;
    private LinearLayout bkZ;
    private TbSettingTextTipView bla;
    private TbSettingTextTipView blb;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bkU = baseActivity;
        this.mOnClickListener = onClickListener;
        FC();
    }

    private void FC() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bkU).inflate(d.i.account_safe_activity, (ViewGroup) null);
        this.bkZ = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.bla = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.blb = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.bla.FE();
        this.blb.FE();
        this.bla.setOnClickListener(this.mOnClickListener);
        this.blb.setOnClickListener(this.mOnClickListener);
    }

    public void eu(int i) {
        this.bkU.getLayoutMode().setNightMode(i == 1);
        this.bkU.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.blb.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bkU = null;
    }
}
