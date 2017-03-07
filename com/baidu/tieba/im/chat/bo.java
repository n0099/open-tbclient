package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bo {
    BaseActivity bcF;
    String mUrl;

    public bo(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bcF = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bcF.getPageContext().getString(w.l.save_error));
            }
            com.baidu.adp.lib.f.c.fG().a(this.mUrl, 10, new bp(this), this.bcF.getUniqueId());
        } catch (Exception e) {
            showToast(this.bcF.getPageContext().getString(w.l.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.l.a(str, bArr, this.bcF.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.l.uv();
            case -1:
            default:
                return this.bcF.getPageContext().getString(w.l.save_error);
            case 0:
                return this.bcF.getPageContext().getString(w.l.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bcF.showToast(str);
    }
}
