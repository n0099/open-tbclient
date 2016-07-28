package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bp {
    BaseActivity bem;
    String mUrl;

    public bp(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bem = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bem.getPageContext().getString(u.j.save_error));
            }
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, 10, new bq(this), this.bem.getUniqueId());
        } catch (Exception e) {
            showToast(this.bem.getPageContext().getString(u.j.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.m.a(str, bArr, this.bem.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.m.sU();
            case -1:
            default:
                return this.bem.getPageContext().getString(u.j.save_error);
            case 0:
                return this.bem.getPageContext().getString(u.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bem.showToast(str);
    }
}
