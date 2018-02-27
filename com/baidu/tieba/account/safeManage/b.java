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
    private BaseActivity bSC;
    private LinearLayout bSH;
    private TbSettingTextTipView bSI;
    private TbSettingTextTipView bSJ;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bSC = baseActivity;
        this.mOnClickListener = onClickListener;
        Ju();
    }

    private void Ju() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bSC).inflate(d.h.account_safe_activity, (ViewGroup) null);
        this.bSH = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.bSI = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.bSJ = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.bSI.Jw();
        this.bSJ.Jw();
        this.bSI.setOnClickListener(this.mOnClickListener);
        this.bSJ.setOnClickListener(this.mOnClickListener);
    }

    public void hr(int i) {
        this.bSC.getLayoutMode().aQ(i == 1);
        this.bSC.getLayoutMode().aM(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bSJ.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bSC = null;
    }
}
