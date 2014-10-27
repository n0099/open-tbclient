package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class i {
    private static c Nb = null;
    private static boolean Nc = false;
    private a Nd;
    private b Ne;
    private final Context mContext;

    public i(Context context, a aVar) {
        this.Nd = null;
        this.Ne = null;
        this.mContext = context;
        if (aVar != null) {
            this.Nd = aVar;
        }
        y(this.mContext);
        if (Nb != null) {
            this.Ne = Nb.createWorker(this.mContext, this.Nd);
        }
    }

    public static boolean y(Context context) {
        if (context == null) {
            return false;
        }
        if (!Nc) {
            try {
                Nb = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                Log.e("", "Exception in checking ShareCreator", e);
            }
            Nc = true;
        }
        return Nb != null;
    }

    public void a(h hVar) {
        if (this.Ne != null) {
            this.Ne.a(a(hVar, "weixin"), 3, false);
        }
    }

    public void b(h hVar) {
        if (this.Ne != null) {
            hVar.title = hVar.content;
            this.Ne.a(a(hVar, "weixin_timeline"), 2, false);
        }
    }

    public void c(h hVar) {
        if (this.Ne != null) {
            hVar.content = d(hVar.content, 80, 32);
            this.Ne.a(a(hVar, "qzone"), 4, true);
        }
    }

    public void d(h hVar) {
        if (this.Ne != null) {
            hVar.content = d(hVar.content, 140, 20);
            this.Ne.a(a(hVar, "tencent_weibo"), 5, true);
        }
    }

    public void e(h hVar) {
        if (this.Ne != null) {
            hVar.content = d(hVar.content, 140, 20);
            this.Ne.a(a(hVar, "sina_weibo"), 6, true);
        }
    }

    public void f(h hVar) {
        if (this.Ne != null) {
            hVar.content = d(hVar.content, 140, 20);
            this.Ne.a(a(hVar, "renren"), 7, true);
        }
    }

    private String d(String str, int i, int i2) {
        String string = TbadkApplication.m251getInst().getString(y.share_tail);
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
        if (hVar.MX == null && hVar.pN() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            hVar.MX = Uri.parse(str2);
        }
        if (hVar.MX != null) {
            hVar.MX = Uri.parse(Q(hVar.MX.toString(), "sfc=" + str));
        }
        hVar.MW = Q(ay.aA(hVar.MW) ? "http://tieba.baidu.com" : hVar.MW, "sfc=" + str);
        return hVar;
    }

    private String Q(String str, String str2) {
        if (ay.aA(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
