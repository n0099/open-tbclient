package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class b {
    private Dialog fke;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void x(m mVar) {
        if (mVar != null && this.mContext != null) {
            dismiss();
            this.fke = new a(this.mContext.getPageActivity(), this.mContext, mVar, this);
            this.fke.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (bqq()) {
            sN();
            this.fke = null;
        }
    }

    private void sN() {
        if (this.fke != null && this.fke.isShowing()) {
            try {
                this.fke.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean bqq() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
