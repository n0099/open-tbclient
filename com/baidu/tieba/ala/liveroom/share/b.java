package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.l;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class b {
    private Dialog fgX;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void s(l lVar) {
        if (lVar != null && this.mContext != null) {
            dismiss();
            this.fgX = new a(this.mContext.getPageActivity(), this.mContext, lVar, this);
            this.fgX.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (boI()) {
            xe();
            this.fgX = null;
        }
    }

    private void xe() {
        if (this.fgX != null && this.fgX.isShowing()) {
            try {
                this.fgX.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean boI() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
