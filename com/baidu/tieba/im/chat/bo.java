package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bo {
    BaseActivity bdK;
    String mUrl;

    public bo(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bdK = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bdK.getPageContext().getString(t.j.save_error));
            }
            com.baidu.adp.lib.g.c.hl().a(this.mUrl, 10, new bp(this), this.bdK.getUniqueId());
        } catch (Exception e) {
            showToast(this.bdK.getPageContext().getString(t.j.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.m.a(str, bArr, this.bdK.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.m.uU();
            case -1:
            default:
                return this.bdK.getPageContext().getString(t.j.save_error);
            case 0:
                return this.bdK.getPageContext().getString(t.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bdK.showToast(str);
    }
}
