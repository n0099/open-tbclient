package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class b {
    private Dialog fPj;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void w(n nVar) {
        if (nVar != null && this.mContext != null) {
            dismiss();
            this.fPj = new a(this.mContext.getPageActivity(), this.mContext, nVar, this);
            this.fPj.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (bzR()) {
            xl();
            this.fPj = null;
        }
    }

    private void xl() {
        if (this.fPj != null && this.fPj.isShowing()) {
            try {
                this.fPj.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean bzR() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
