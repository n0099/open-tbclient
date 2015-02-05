package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class g {
    private static c Ts = null;
    private static boolean Tt = false;
    private a Tu;
    private b Tv;
    private final Context mContext;

    public g(Context context, a aVar) {
        this.Tu = null;
        this.Tv = null;
        this.mContext = context;
        if (aVar != null) {
            this.Tu = aVar;
        }
        V(this.mContext);
        if (Ts != null) {
            this.Tv = Ts.createWorker(this.mContext, this.Tu);
        }
    }

    public static boolean V(Context context) {
        if (context == null) {
            return false;
        }
        if (!Tt) {
            try {
                Ts = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                Log.e("", "Exception in checking ShareCreator", e);
            }
            Tt = true;
        }
        return Ts != null;
    }

    public void a(f fVar) {
        if (this.Tv != null) {
            this.Tv.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void b(f fVar) {
        if (this.Tv != null) {
            fVar.title = fVar.content;
            this.Tv.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void c(f fVar) {
        if (this.Tv != null) {
            fVar.content = e(fVar.content, 80, 32);
            this.Tv.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void d(f fVar) {
        if (this.Tv != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.Tv.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void e(f fVar) {
        if (this.Tv != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.Tv.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void f(f fVar) {
        if (this.Tv != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.Tv.a(a(fVar, "renren"), 7, true);
        }
    }

    private String e(String str, int i, int i2) {
        String string = TbadkCoreApplication.m255getInst().getContext().getString(z.share_tail);
        if (str != null) {
            int min = Math.min((i - string.length()) - i2, str.length());
            if (min < str.length()) {
                return String.valueOf(str.substring(0, min - 1)) + ("..." + string);
            }
            return String.valueOf(str) + string;
        }
        return string;
    }

    private f a(f fVar, String str) {
        if (fVar.To == null && fVar.getImageData() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            fVar.To = Uri.parse(str2);
        }
        if (fVar.To != null) {
            fVar.To = Uri.parse(af(fVar.To.toString(), "sfc=" + str));
        }
        fVar.Tn = af(bf.isEmpty(fVar.Tn) ? "http://tieba.baidu.com" : fVar.Tn, "sfc=" + str);
        return fVar;
    }

    private String af(String str, String str2) {
        if (bf.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
