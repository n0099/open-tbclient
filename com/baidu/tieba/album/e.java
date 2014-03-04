package com.baidu.tieba.album;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
/* loaded from: classes.dex */
public class e {
    private final String a = e.class.getName();
    private final String b = com.baidu.tieba.data.i.k();
    private f c;
    private g d;
    private final Context e;

    public e(Context context) {
        this.e = context;
    }

    public final boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        a();
        this.c = new f(this, oVar);
        this.c.setPriority(3);
        this.c.execute(new Object[0]);
        return true;
    }

    public final boolean a(String str, al alVar) {
        if (alVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        b();
        this.d = new g(this, str, alVar);
        this.d.setPriority(3);
        this.d.execute(new Object[0]);
        return true;
    }

    public final void a() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    public final void b() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }

    public static String a(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
    }
}
