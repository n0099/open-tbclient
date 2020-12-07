package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b {
    private Dialog hBP;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void R(w wVar) {
        if (wVar != null && this.mContext != null) {
            dismiss();
            this.hBP = new a(this.mContext.getPageActivity(), this.mContext, wVar, this);
            this.hBP.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (ckq()) {
            ID();
            this.hBP = null;
        }
    }

    private void ID() {
        if (this.hBP != null && this.hBP.isShowing()) {
            try {
                this.hBP.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean ckq() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
