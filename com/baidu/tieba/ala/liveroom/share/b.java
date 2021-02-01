package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b {
    private Dialog hNK;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void U(ab abVar) {
        if (abVar != null && this.mContext != null) {
            dismiss();
            this.hNK = new a(this.mContext.getPageActivity(), this.mContext, abVar, this);
            this.hNK.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (ckn()) {
            FA();
            this.hNK = null;
        }
    }

    private void FA() {
        if (this.hNK != null && this.hNK.isShowing()) {
            try {
                this.hNK.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean ckn() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
