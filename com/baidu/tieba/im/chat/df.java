package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class df {
    String a;
    BaseActivity b;

    public df(String str, BaseActivity baseActivity) {
        this.a = null;
        this.a = str;
        this.b = baseActivity;
    }

    public void a() {
        try {
            if (this.a == null || this.a.length() <= 0) {
                a(this.b.getString(com.baidu.tieba.x.save_error));
            }
            com.baidu.adp.lib.resourceLoader.d.a().a(this.a, 10, new dg(this), this.b.getUniqueId());
        } catch (Exception e) {
            a(this.b.getString(com.baidu.tieba.x.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.s.a(str, bArr, this.b)) {
            case -2:
                return com.baidu.tbadk.core.util.s.b();
            case -1:
            default:
                return this.b.getString(com.baidu.tieba.x.save_error);
            case 0:
                return this.b.getString(com.baidu.tieba.x.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.b.showToast(str);
    }
}
