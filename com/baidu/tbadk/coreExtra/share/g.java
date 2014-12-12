package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class g {
    private static c SQ = null;
    private static boolean SR = false;
    private a SS;
    private b SU;
    private final Context mContext;

    public g(Context context, a aVar) {
        this.SS = null;
        this.SU = null;
        this.mContext = context;
        if (aVar != null) {
            this.SS = aVar;
        }
        V(this.mContext);
        if (SQ != null) {
            this.SU = SQ.createWorker(this.mContext, this.SS);
        }
    }

    public static boolean V(Context context) {
        if (context == null) {
            return false;
        }
        if (!SR) {
            try {
                SQ = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                Log.e("", "Exception in checking ShareCreator", e);
            }
            SR = true;
        }
        return SQ != null;
    }

    public void a(f fVar) {
        if (this.SU != null) {
            this.SU.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void b(f fVar) {
        if (this.SU != null) {
            fVar.title = fVar.content;
            this.SU.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void c(f fVar) {
        if (this.SU != null) {
            fVar.content = e(fVar.content, 80, 32);
            this.SU.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void d(f fVar) {
        if (this.SU != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.SU.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void e(f fVar) {
        if (this.SU != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.SU.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void f(f fVar) {
        if (this.SU != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.SU.a(a(fVar, "renren"), 7, true);
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
        if (fVar.SL == null && fVar.getImageData() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            fVar.SL = Uri.parse(str2);
        }
        if (fVar.SL != null) {
            fVar.SL = Uri.parse(ac(fVar.SL.toString(), "sfc=" + str));
        }
        fVar.SJ = ac(ba.isEmpty(fVar.SJ) ? "http://tieba.baidu.com" : fVar.SJ, "sfc=" + str);
        return fVar;
    }

    private String ac(String str, String str2) {
        if (ba.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
