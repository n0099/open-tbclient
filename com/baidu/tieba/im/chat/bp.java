package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bp {
    BaseActivity aPR;
    String mUrl;

    public bp(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.aPR = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.aPR.getPageContext().getString(t.j.save_error));
            }
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 10, new bq(this), this.aPR.getUniqueId());
        } catch (Exception e) {
            showToast(this.aPR.getPageContext().getString(t.j.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.m.a(str, bArr, this.aPR.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.m.tZ();
            case -1:
            default:
                return this.aPR.getPageContext().getString(t.j.save_error);
            case 0:
                return this.aPR.getPageContext().getString(t.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.aPR.showToast(str);
    }
}
