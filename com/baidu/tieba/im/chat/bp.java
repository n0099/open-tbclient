package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bp {
    BaseActivity aTb;
    String mUrl;

    public bp(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.aTb = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.aTb.getPageContext().getString(r.j.save_error));
            }
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 10, new bq(this), this.aTb.getUniqueId());
        } catch (Exception e) {
            showToast(this.aTb.getPageContext().getString(r.j.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.m.a(str, bArr, this.aTb.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.m.ut();
            case -1:
            default:
                return this.aTb.getPageContext().getString(r.j.save_error);
            case 0:
                return this.aTb.getPageContext().getString(r.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.aTb.showToast(str);
    }
}
