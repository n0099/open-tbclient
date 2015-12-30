package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bo {
    BaseActivity bbA;
    String mUrl;

    public bo(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bbA = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bbA.getPageContext().getString(n.j.save_error));
            }
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, 10, new bp(this), this.bbA.getUniqueId());
        } catch (Exception e) {
            showToast(this.bbA.getPageContext().getString(n.j.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.n.a(str, bArr, this.bbA.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.n.tQ();
            case -1:
            default:
                return this.bbA.getPageContext().getString(n.j.save_error);
            case 0:
                return this.bbA.getPageContext().getString(n.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bbA.showToast(str);
    }
}
