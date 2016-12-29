package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bp {
    BaseActivity aSs;
    String mUrl;

    public bp(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.aSs = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.aSs.getPageContext().getString(r.j.save_error));
            }
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 10, new bq(this), this.aSs.getUniqueId());
        } catch (Exception e) {
            showToast(this.aSs.getPageContext().getString(r.j.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.m.a(str, bArr, this.aSs.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.m.ud();
            case -1:
            default:
                return this.aSs.getPageContext().getString(r.j.save_error);
            case 0:
                return this.aSs.getPageContext().getString(r.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.aSs.showToast(str);
    }
}
