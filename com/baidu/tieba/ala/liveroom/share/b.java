package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.r;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public class b {
    private Dialog gIy;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void A(r rVar) {
        if (rVar != null && this.mContext != null) {
            dismiss();
            this.gIy = new a(this.mContext.getPageActivity(), this.mContext, rVar, this);
            this.gIy.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (bWn()) {
            Fd();
            this.gIy = null;
        }
    }

    private void Fd() {
        if (this.gIy != null && this.gIy.isShowing()) {
            try {
                this.gIy.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean bWn() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
