package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b {
    private Dialog hNY;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void U(ab abVar) {
        if (abVar != null && this.mContext != null) {
            dismiss();
            this.hNY = new a(this.mContext.getPageActivity(), this.mContext, abVar, this);
            this.hNY.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (cku()) {
            FA();
            this.hNY = null;
        }
    }

    private void FA() {
        if (this.hNY != null && this.hNY.isShowing()) {
            try {
                this.hNY.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean cku() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
