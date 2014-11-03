package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class i {
    private static c Nf = null;
    private static boolean Ng = false;
    private a Nh;
    private b Ni;
    private final Context mContext;

    public i(Context context, a aVar) {
        this.Nh = null;
        this.Ni = null;
        this.mContext = context;
        if (aVar != null) {
            this.Nh = aVar;
        }
        y(this.mContext);
        if (Nf != null) {
            this.Ni = Nf.createWorker(this.mContext, this.Nh);
        }
    }

    public static boolean y(Context context) {
        if (context == null) {
            return false;
        }
        if (!Ng) {
            try {
                Nf = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                Log.e("", "Exception in checking ShareCreator", e);
            }
            Ng = true;
        }
        return Nf != null;
    }

    public void a(h hVar) {
        if (this.Ni != null) {
            this.Ni.a(a(hVar, "weixin"), 3, false);
        }
    }

    public void b(h hVar) {
        if (this.Ni != null) {
            hVar.title = hVar.content;
            this.Ni.a(a(hVar, "weixin_timeline"), 2, false);
        }
    }

    public void c(h hVar) {
        if (this.Ni != null) {
            hVar.content = d(hVar.content, 80, 32);
            this.Ni.a(a(hVar, "qzone"), 4, true);
        }
    }

    public void d(h hVar) {
        if (this.Ni != null) {
            hVar.content = d(hVar.content, 140, 20);
            this.Ni.a(a(hVar, "tencent_weibo"), 5, true);
        }
    }

    public void e(h hVar) {
        if (this.Ni != null) {
            hVar.content = d(hVar.content, 140, 20);
            this.Ni.a(a(hVar, "sina_weibo"), 6, true);
        }
    }

    public void f(h hVar) {
        if (this.Ni != null) {
            hVar.content = d(hVar.content, 140, 20);
            this.Ni.a(a(hVar, "renren"), 7, true);
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
        if (hVar.Nb == null && hVar.pP() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            hVar.Nb = Uri.parse(str2);
        }
        if (hVar.Nb != null) {
            hVar.Nb = Uri.parse(Q(hVar.Nb.toString(), "sfc=" + str));
        }
        hVar.Na = Q(az.aA(hVar.Na) ? "http://tieba.baidu.com" : hVar.Na, "sfc=" + str);
        return hVar;
    }

    private String Q(String str, String str2) {
        if (az.aA(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
