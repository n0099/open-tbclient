package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bo {
    BaseActivity aSe;
    String mUrl;

    public bo(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.aSe = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.aSe.getPageContext().getString(i.h.save_error));
            }
            com.baidu.adp.lib.f.c.ha().a(this.mUrl, 10, new bp(this), this.aSe.getUniqueId());
        } catch (Exception e) {
            showToast(this.aSe.getPageContext().getString(i.h.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.n.a(str, bArr, this.aSe.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.n.tB();
            case -1:
            default:
                return this.aSe.getPageContext().getString(i.h.save_error);
            case 0:
                return this.aSe.getPageContext().getString(i.h.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.aSe.showToast(str);
    }
}
