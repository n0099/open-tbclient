package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br {
    String a;
    com.baidu.adp.widget.ImageView.e b = null;
    final /* synthetic */ bc c;

    public br(bc bcVar, String str) {
        this.c = bcVar;
        this.a = null;
        this.a = str;
    }

    public void a() {
        try {
            if (this.a == null || this.a.length() <= 0) {
                a(this.c.getString(R.string.save_error));
            }
            this.b = new com.baidu.tieba.util.i(this.c).a(this.a, false, true, (com.baidu.tbadk.imageManager.c) new bs(this));
            if (this.b != null) {
                a(a(this.a, this.b.i()));
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("SaveImageAsyncTask", "execute", "error" + e.getMessage());
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
                String f = com.baidu.tieba.util.bc.f(str);
                if (f == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str3 = f + str2;
                for (int i = 0; com.baidu.tieba.util.y.b(str3) && i < 10000; i++) {
                    str3 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String a = com.baidu.tieba.util.y.a(str3, bArr);
                if (a != null) {
                    new com.baidu.tieba.util.am(this.c).a(a);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.y.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("SaveImageAsyncTask", "saveByte", "error" + e.getMessage());
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
