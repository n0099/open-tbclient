package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class b {
    private Dialog gdY;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void w(q qVar) {
        if (qVar != null && this.mContext != null) {
            dismiss();
            this.gdY = new a(this.mContext.getPageActivity(), this.mContext, qVar, this);
            this.gdY.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (bGc()) {
            yy();
            this.gdY = null;
        }
    }

    private void yy() {
        if (this.gdY != null && this.gdY.isShowing()) {
            try {
                this.gdY.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean bGc() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
