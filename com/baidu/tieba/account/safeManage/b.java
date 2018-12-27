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
    private BaseActivity bBi;
    private LinearLayout bBn;
    private TbSettingTextTipView bBo;
    private TbSettingTextTipView bBp;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bBi = baseActivity;
        this.mOnClickListener = onClickListener;
        Ky();
    }

    private void Ky() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bBi).inflate(e.h.account_safe_activity, (ViewGroup) null);
        this.bBn = (LinearLayout) this.mRootLayout.findViewById(e.g.content_container);
        this.bBo = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.bar_record);
        this.bBp = (TbSettingTextTipView) this.mRootLayout.findViewById(e.g.account_status);
        this.bBo.KA();
        this.bBp.KA();
        this.bBo.setOnClickListener(this.mOnClickListener);
        this.bBp.setOnClickListener(this.mOnClickListener);
    }

    public void fv(int i) {
        this.bBi.getLayoutMode().setNightMode(i == 1);
        this.bBi.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bBp.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bBi = null;
    }
}
