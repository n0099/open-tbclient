package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bo {
    BaseActivity bdY;
    String mUrl;

    public bo(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bdY = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bdY.getPageContext().getString(w.l.save_error));
            }
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, 10, new bp(this), this.bdY.getUniqueId());
        } catch (Exception e) {
            showToast(this.bdY.getPageContext().getString(w.l.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.l.a(str, bArr, this.bdY.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.l.ue();
            case -1:
            default:
                return this.bdY.getPageContext().getString(w.l.save_error);
            case 0:
                return this.bdY.getPageContext().getString(w.l.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bdY.showToast(str);
    }
}
