package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class b {
    private Dialog fkr;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void x(m mVar) {
        if (mVar != null && this.mContext != null) {
            dismiss();
            this.fkr = new a(this.mContext.getPageActivity(), this.mContext, mVar, this);
            this.fkr.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (bqr()) {
            sN();
            this.fkr = null;
        }
    }

    private void sN() {
        if (this.fkr != null && this.fkr.isShowing()) {
            try {
                this.fkr.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean bqr() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
