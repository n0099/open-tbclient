package com.baidu.tieba.ala.liveroom.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class b {
    private Dialog hJm;
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void S(x xVar) {
        if (xVar != null && this.mContext != null) {
            dismiss();
            this.hJm = new a(this.mContext.getPageActivity(), this.mContext, xVar, this);
            this.hJm.show();
        }
    }

    public void onDestroy() {
        dismiss();
    }

    public void dismiss() {
        if (cjo()) {
            Ek();
            this.hJm = null;
        }
    }

    private void Ek() {
        if (this.hJm != null && this.hJm.isShowing()) {
            try {
                this.hJm.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean cjo() {
        if (this.mContext == null || this.mContext.getPageActivity() == null) {
            return false;
        }
        Activity pageActivity = this.mContext.getPageActivity();
        return Build.VERSION.SDK_INT >= 17 ? (pageActivity.isDestroyed() || pageActivity.isFinishing()) ? false : true : !pageActivity.isFinishing();
    }
}
