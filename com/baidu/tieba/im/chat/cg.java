package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class cg {
    String a;
    com.baidu.tieba.j b;

    public cg(String str, com.baidu.tieba.j jVar) {
        this.a = null;
        this.a = str;
        this.b = jVar;
    }

    public void a() {
        try {
            if (this.a == null || this.a.length() <= 0) {
                a(this.b.getString(R.string.save_error));
            }
            new com.baidu.tieba.util.i(this.b).a(this.a, false, true, (com.baidu.tbadk.imageManager.c) new ch(this));
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("SaveImageAsyncTask", "execute", "error" + e.getMessage());
            a(this.b.getString(R.string.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, byte[] bArr) {
        String str2;
        try {
            if (bArr != null) {
                if (!com.baidu.adp.lib.g.g.a(bArr)) {
                    str2 = ".jpg";
                } else {
                    str2 = ".gif";
                }
                String f = com.baidu.tieba.util.bu.f(str);
                if (f == null) {
                    return this.b.getString(R.string.save_error);
                }
                String str3 = f + str2;
                for (int i = 0; com.baidu.tieba.util.ad.b(str3) && i < 10000; i++) {
                    str3 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String a = com.baidu.tieba.util.ad.a(str3, bArr);
                if (a != null) {
                    new com.baidu.tieba.util.aw(this.b).a(a);
                    return this.b.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.ad.b();
            }
            return this.b.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("SaveImageAsyncTask", "saveByte", "error" + e.getMessage());
            return this.b.getString(R.string.save_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.b.showToast(str);
    }
}
