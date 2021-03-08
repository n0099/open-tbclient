package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class b {
    private Dialog hPH;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void U(ab abVar) {
        if (abVar != null && this.mContext != null) {
            dismiss();
            this.hPH = new a(this.mContext.getPageActivity(), this.mContext, abVar, this);
            this.hPH.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (ckA()) {
            FD();
            this.hPH = null;
        }
    }

    private void FD() {
        if (this.hPH != null && this.hPH.isShowing()) {
            try {
                this.hPH.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean ckA() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
