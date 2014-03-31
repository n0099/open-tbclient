package com.baidu.tieba.album;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
/* loaded from: classes.dex */
public class e {
    private final String a = e.class.getName();
    private final String b = com.baidu.tbadk.core.data.n.f();
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String str) {
        String str2;
        int lastIndexOf;
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf2 = str.lastIndexOf(35);
            if (lastIndexOf2 > 0) {
                str = str.substring(0, lastIndexOf2);
            }
            int lastIndexOf3 = str.lastIndexOf(63);
            if (lastIndexOf3 > 0) {
                str = str.substring(0, lastIndexOf3);
            }
            int lastIndexOf4 = str.lastIndexOf(47);
            if (lastIndexOf4 >= 0) {
                str = str.substring(lastIndexOf4 + 1);
            }
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
                str2 = str.substring(lastIndexOf + 1);
                if (str2 != null) {
                    return null;
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
            }
        }
        str2 = "";
        if (str2 != null) {
        }
    }
}
