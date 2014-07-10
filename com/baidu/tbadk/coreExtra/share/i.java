package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class i {
    private static c a = null;
    private static boolean b = false;
    private final Context c;
    private a d;
    private b e;

    public i(Context context, a aVar) {
        this.d = null;
        this.e = null;
        this.c = context;
        if (aVar != null) {
            this.d = aVar;
        }
        a(this.c);
        if (a != null) {
            this.e = a.createWorker(this.c, this.d);
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (!b) {
            try {
                a = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                Log.e("", "Exception in checking ShareCreator", e);
            }
            b = true;
        }
        return a != null;
    }

    public void a(h hVar) {
        if (this.e != null) {
            this.e.a(a(hVar, "weixin"), 3, false);
        }
    }

    public void b(h hVar) {
        if (this.e != null) {
            hVar.a = hVar.b;
            this.e.a(a(hVar, "weixin_timeline"), 2, false);
        }
    }

    public void c(h hVar) {
        if (this.e != null) {
            hVar.b = a(hVar.b, 80, 32);
            this.e.a(a(hVar, "qzone"), 4, true);
        }
    }

    public void d(h hVar) {
        if (this.e != null) {
            hVar.b = a(hVar.b, 140, 20);
            this.e.a(a(hVar, "tencent_weibo"), 5, true);
        }
    }

    public void e(h hVar) {
        if (this.e != null) {
            hVar.b = a(hVar.b, 140, 20);
            this.e.a(a(hVar, "sina_weibo"), 6, true);
        }
    }

    public void f(h hVar) {
        if (this.e != null) {
            hVar.b = a(hVar.b, 140, 20);
            this.e.a(a(hVar, "renren"), 7, true);
        }
    }

    private String a(String str, int i, int i2) {
        String string = this.c.getString(y.share_tail);
        if (str != null) {
            int min = Math.min((i - string.length()) - i2, str.length());
            if (min < str.length()) {
                return String.valueOf(str.substring(0, min - 1)) + ("..." + string);
            }
            return String.valueOf(str) + string;
        }
        return string;
    }

    private h a(h hVar, String str) {
        if (hVar.d == null && hVar.a() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            hVar.d = Uri.parse(str2);
        }
        if (hVar.d != null) {
            hVar.d = Uri.parse(a(hVar.d.toString(), "sfc=" + str));
        }
        hVar.c = a(bm.c(hVar.c) ? "http://tieba.baidu.com" : hVar.c, "sfc=" + str);
        return hVar;
    }

    private String a(String str, String str2) {
        if (bm.c(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
