package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp {
    String a;
    com.baidu.adp.widget.ImageView.d b = null;
    final /* synthetic */ ba c;

    public bp(ba baVar, String str) {
        this.c = baVar;
        this.a = null;
        this.a = str;
    }

    public void a() {
        try {
            if (this.a == null || this.a.length() <= 0) {
                a(this.c.getString(R.string.save_error));
            }
            this.b = new com.baidu.tieba.util.i(this.c).a(this.a, false, true, (com.baidu.tbadk.imageManager.c) new bq(this));
            if (this.b != null) {
                a(a(this.a, this.b.k()));
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b("SaveImageAsyncTask", "execute", "error" + e.getMessage());
            a(this.c.getString(R.string.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, byte[] bArr) {
        String str2;
        try {
            if (bArr != null) {
                if (!com.baidu.adp.lib.h.g.a(bArr)) {
                    str2 = ".jpg";
                } else {
                    str2 = ".gif";
                }
                String f = com.baidu.tieba.util.bm.f(str);
                if (f == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str3 = f + str2;
                for (int i = 0; com.baidu.tieba.util.aa.b(str3) && i < 10000; i++) {
                    str3 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String a = com.baidu.tieba.util.aa.a(str3, bArr);
                if (a != null) {
                    new com.baidu.tieba.util.as(this.c).a(a);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.aa.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b("SaveImageAsyncTask", "saveByte", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.c.showToast(str);
        this.c.l = null;
    }

    public void b() {
        this.c.l = null;
    }
}
