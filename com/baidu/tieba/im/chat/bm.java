package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bm {
    BaseActivity aSJ;
    String mUrl;

    public bm(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.aSJ = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.aSJ.getPageContext().getString(i.C0057i.save_error));
            }
            com.baidu.adp.lib.f.c.hc().a(this.mUrl, 10, new bn(this), this.aSJ.getUniqueId());
        } catch (Exception e) {
            showToast(this.aSJ.getPageContext().getString(i.C0057i.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.n.a(str, bArr, this.aSJ.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.n.ty();
            case -1:
            default:
                return this.aSJ.getPageContext().getString(i.C0057i.save_error);
            case 0:
                return this.aSJ.getPageContext().getString(i.C0057i.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.aSJ.showToast(str);
    }
}
