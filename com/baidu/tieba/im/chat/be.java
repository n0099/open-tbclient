package com.baidu.tieba.im.chat;

import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
class be {

    /* renamed from: a  reason: collision with root package name */
    String f1432a;
    com.baidu.adp.widget.ImageView.e b = null;
    final /* synthetic */ MsglistActivity c;

    public be(MsglistActivity msglistActivity, String str) {
        this.c = msglistActivity;
        this.f1432a = null;
        this.f1432a = str;
    }

    public void a() {
        try {
            if (this.f1432a == null || this.f1432a.length() <= 0) {
                a(this.c.getString(R.string.save_error));
            }
            this.b = new com.baidu.tieba.util.a(this.c).a(this.f1432a, false, true, (com.baidu.tbadk.imageManager.c) new bf(this));
            if (this.b != null) {
                a(a(this.f1432a, this.b.h()));
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
                if (!UtilHelper.a(bArr)) {
                    str2 = Util.PHOTO_DEFAULT_EXT;
                } else {
                    str2 = ".gif";
                }
                String f = com.baidu.tieba.util.bc.f(str);
                if (f == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str3 = f + str2;
                for (int i = 0; com.baidu.tieba.util.w.b(str3) && i < 10000; i++) {
                    str3 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String a2 = com.baidu.tieba.util.w.a(str3, bArr);
                if (a2 != null) {
                    new com.baidu.tieba.util.af(this.c).a(a2);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.w.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("SaveImageAsyncTask", "saveByte", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.c.a(str);
        this.c.m = null;
    }

    public void b() {
        this.c.m = null;
    }
}
