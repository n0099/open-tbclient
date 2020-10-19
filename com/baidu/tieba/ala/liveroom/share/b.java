package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b {
    private Dialog haQ;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void E(u uVar) {
        if (uVar != null && this.mContext != null) {
            dismiss();
            this.haQ = new a(this.mContext.getPageActivity(), this.mContext, uVar, this);
            this.haQ.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (cbw()) {
            Gz();
            this.haQ = null;
        }
    }

    private void Gz() {
        if (this.haQ != null && this.haQ.isShowing()) {
            try {
                this.haQ.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean cbw() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
