package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.k;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class b {
    private Dialog fdR;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void q(k kVar) {
        if (kVar != null && this.mContext != null) {
            dismiss();
            this.fdR = new a(this.mContext.getPageActivity(), this.mContext, kVar, this);
            this.fdR.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (bnI()) {
            wN();
            this.fdR = null;
        }
    }

    private void wN() {
        if (this.fdR != null && this.fdR.isShowing()) {
            try {
                this.fdR.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean bnI() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
