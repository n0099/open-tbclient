package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class cq {
    String a;
    com.baidu.tieba.f b;

    public cq(String str, com.baidu.tieba.f fVar) {
        this.a = null;
        this.a = str;
        this.b = fVar;
    }

    public void a() {
        try {
            if (this.a == null || this.a.length() <= 0) {
                a(this.b.getString(R.string.save_error));
            }
            new com.baidu.tieba.util.i(this.b).a(this.a, false, true, (com.baidu.tbadk.imageManager.d) new cr(this));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("SaveImageAsyncTask", "execute", "error" + e.getMessage());
            a(this.b.getString(R.string.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, byte[] bArr) {
        String str2;
        String f;
        try {
            if (bArr != null) {
                if (!BdUtilHelper.a(bArr)) {
                    str2 = ".jpg";
                } else {
                    str2 = ".gif";
                }
                if (com.baidu.tieba.util.bs.f(str) == null) {
                    return this.b.getString(R.string.save_error);
                }
                String str3 = String.valueOf(f) + str2;
                for (int i = 0; com.baidu.tieba.util.af.b(str3) && i < 10000; i++) {
                    str3 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String a = com.baidu.tieba.util.af.a(str3, bArr);
                if (a != null) {
                    new com.baidu.tieba.util.ay(this.b).a(a);
                    return this.b.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.af.b();
            }
            return this.b.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("SaveImageAsyncTask", "saveByte", "error" + e.getMessage());
            return this.b.getString(R.string.save_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.b.showToast(str);
    }
}
