package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b {
    private Dialog gwz;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void y(q qVar) {
        if (qVar != null && this.mContext != null) {
            dismiss();
            this.gwz = new a(this.mContext.getPageActivity(), this.mContext, qVar, this);
            this.gwz.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (bMq()) {
            zA();
            this.gwz = null;
        }
    }

    private void zA() {
        if (this.gwz != null && this.gwz.isShowing()) {
            try {
                this.gwz.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean bMq() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
