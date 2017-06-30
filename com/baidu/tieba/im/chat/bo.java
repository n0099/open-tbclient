package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bo {
    BaseActivity bhX;
    String mUrl;

    public bo(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bhX = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bhX.getPageContext().getString(w.l.save_error));
            }
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, 10, new bp(this), this.bhX.getUniqueId());
        } catch (Exception e) {
            showToast(this.bhX.getPageContext().getString(w.l.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.n.a(str, bArr, this.bhX.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.n.us();
            case -1:
            default:
                return this.bhX.getPageContext().getString(w.l.save_error);
            case 0:
                return this.bhX.getPageContext().getString(w.l.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bhX.showToast(str);
    }
}
