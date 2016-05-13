package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bo {
    BaseActivity bek;
    String mUrl;

    public bo(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bek = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bek.getPageContext().getString(t.j.save_error));
            }
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, 10, new bp(this), this.bek.getUniqueId());
        } catch (Exception e) {
            showToast(this.bek.getPageContext().getString(t.j.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.m.a(str, bArr, this.bek.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.m.sY();
            case -1:
            default:
                return this.bek.getPageContext().getString(t.j.save_error);
            case 0:
                return this.bek.getPageContext().getString(t.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bek.showToast(str);
    }
}
