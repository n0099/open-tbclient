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
    private BaseActivity bmZ;
    private LinearLayout bne;
    private TbSettingTextTipView bnf;
    private TbSettingTextTipView bng;
    private final View.OnClickListener mOnClickListener;
    private LinearLayout mRootLayout;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.bmZ = baseActivity;
        this.mOnClickListener = onClickListener;
        FQ();
    }

    private void FQ() {
        this.mRootLayout = (LinearLayout) LayoutInflater.from(this.bmZ).inflate(d.h.account_safe_activity, (ViewGroup) null);
        this.bne = (LinearLayout) this.mRootLayout.findViewById(d.g.content_container);
        this.bnf = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.bar_record);
        this.bng = (TbSettingTextTipView) this.mRootLayout.findViewById(d.g.account_status);
        this.bnf.FS();
        this.bng.FS();
        this.bnf.setOnClickListener(this.mOnClickListener);
        this.bng.setOnClickListener(this.mOnClickListener);
    }

    public void ey(int i) {
        this.bmZ.getLayoutMode().setNightMode(i == 1);
        this.bmZ.getLayoutMode().onModeChanged(this.mRootLayout);
    }

    public void a(SimpleUser simpleUser) {
        if (simpleUser != null) {
            this.bng.setTip(simpleUser.block_msg);
        }
    }

    public View getView() {
        return this.mRootLayout;
    }

    public void release() {
        this.mRootLayout.removeAllViews();
        this.bmZ = null;
    }
}
