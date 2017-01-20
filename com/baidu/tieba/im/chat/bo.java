package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bo {
    BaseActivity aWr;
    String mUrl;

    public bo(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.aWr = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.aWr.getPageContext().getString(r.l.save_error));
            }
            com.baidu.adp.lib.f.c.ey().a(this.mUrl, 10, new bp(this), this.aWr.getUniqueId());
        } catch (Exception e) {
            showToast(this.aWr.getPageContext().getString(r.l.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.l.a(str, bArr, this.aWr.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.l.tX();
            case -1:
            default:
                return this.aWr.getPageContext().getString(r.l.save_error);
            case 0:
                return this.aWr.getPageContext().getString(r.l.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.aWr.showToast(str);
    }
}
