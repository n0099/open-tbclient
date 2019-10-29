package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.i;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class b {
    private Dialog eoi;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void n(i iVar) {
        if (iVar != null && this.mContext != null) {
            dismiss();
            this.eoi = new a(this.mContext.getPageActivity(), this.mContext, iVar, this);
            this.eoi.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (aVV()) {
            aAm();
            this.eoi = null;
        }
    }

    private void aAm() {
        if (this.eoi != null && this.eoi.isShowing()) {
            try {
                this.eoi.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean aVV() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
