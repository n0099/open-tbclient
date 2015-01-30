package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class g {
    private static c Tv = null;
    private static boolean Tw = false;
    private a Tx;
    private b Ty;
    private final Context mContext;

    public g(Context context, a aVar) {
        this.Tx = null;
        this.Ty = null;
        this.mContext = context;
        if (aVar != null) {
            this.Tx = aVar;
        }
        V(this.mContext);
        if (Tv != null) {
            this.Ty = Tv.createWorker(this.mContext, this.Tx);
        }
    }

    public static boolean V(Context context) {
        if (context == null) {
            return false;
        }
        if (!Tw) {
            try {
                Tv = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                Log.e("", "Exception in checking ShareCreator", e);
            }
            Tw = true;
        }
        return Tv != null;
    }

    public void a(f fVar) {
        if (this.Ty != null) {
            this.Ty.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void b(f fVar) {
        if (this.Ty != null) {
            fVar.title = fVar.content;
            this.Ty.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void c(f fVar) {
        if (this.Ty != null) {
            fVar.content = e(fVar.content, 80, 32);
            this.Ty.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void d(f fVar) {
        if (this.Ty != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.Ty.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void e(f fVar) {
        if (this.Ty != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.Ty.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void f(f fVar) {
        if (this.Ty != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.Ty.a(a(fVar, "renren"), 7, true);
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
        if (fVar.Tr == null && fVar.getImageData() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            fVar.Tr = Uri.parse(str2);
        }
        if (fVar.Tr != null) {
            fVar.Tr = Uri.parse(af(fVar.Tr.toString(), "sfc=" + str));
        }
        fVar.Tq = af(bf.isEmpty(fVar.Tq) ? "http://tieba.baidu.com" : fVar.Tq, "sfc=" + str);
        return fVar;
    }

    private String af(String str, String str2) {
        if (bf.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
