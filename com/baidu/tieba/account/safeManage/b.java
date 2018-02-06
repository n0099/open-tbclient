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
    private BaseActivity bSO;
    private LinearLayout bST;
    private TbSettingTextTipView bSU;
    private TbSettingTextTipView bSV;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bSO = baseActivity;
        this.mOnClickListener = onClickListener;
        Jv();
    }

    private void Jv() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bSO).inflate(d.h.account_safe_activity, (ViewGroup) null);
        this.bST = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.bSU = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.bSV = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.bSU.Jx();
        this.bSV.Jx();
        this.bSU.setOnClickListener(this.mOnClickListener);
        this.bSV.setOnClickListener(this.mOnClickListener);
    }

    public void hr(int i) {
        this.bSO.getLayoutMode().aQ(i == 1);
        this.bSO.getLayoutMode().aM(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bSV.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bSO = null;
    }
}
