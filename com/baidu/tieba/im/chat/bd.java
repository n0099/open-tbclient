package com.baidu.tieba.im.chat;

import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
class bd {

    /* renamed from: a  reason: collision with root package name */
    String f1515a;
    com.baidu.adp.widget.ImageView.e b = null;
    final /* synthetic */ MsglistActivity c;

    public bd(MsglistActivity msglistActivity, String str) {
        this.c = msglistActivity;
        this.f1515a = null;
        this.f1515a = str;
    }

    public void a() {
        try {
            if (this.f1515a == null || this.f1515a.length() <= 0) {
                a(this.c.getString(R.string.save_error));
            }
            this.b = new com.baidu.tieba.util.i(this.c).a(this.f1515a, false, true, (com.baidu.tbadk.imageManager.c) new be(this));
            if (this.b != null) {
                a(a(this.f1515a, this.b.i()));
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("SaveImageAsyncTask", "execute", "error" + e.getMessage());
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
                String f = com.baidu.tieba.util.be.f(str);
                if (f == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str3 = f + str2;
                for (int i = 0; com.baidu.tieba.util.af.b(str3) && i < 10000; i++) {
                    str3 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String a2 = com.baidu.tieba.util.af.a(str3, bArr);
                if (a2 != null) {
                    new com.baidu.tieba.util.ao(this.c).a(a2);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.af.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("SaveImageAsyncTask", "saveByte", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.c.showToast(str);
        this.c.k = null;
    }

    public void b() {
        this.c.k = null;
    }
}
