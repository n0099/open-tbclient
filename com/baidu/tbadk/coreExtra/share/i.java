package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class i {
    private static c adC = null;
    private static boolean adD = false;
    private a adE;
    private b adF;
    private final Context mContext;

    public i(Context context, a aVar) {
        this.adE = null;
        this.adF = null;
        this.mContext = context;
        if (aVar != null) {
            this.adE = aVar;
        }
        ae(this.mContext);
        if (adC != null) {
            this.adF = adC.createWorker(this.mContext, this.adE);
        }
    }

    public static boolean ae(Context context) {
        if (context == null) {
            return false;
        }
        if (!adD) {
            try {
                adC = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                Log.e("", "Exception in checking ShareCreator", e);
            }
            adD = true;
        }
        return adC != null;
    }

    public void b(f fVar) {
        if (this.adF != null && fVar != null) {
            if (!StringUtils.isNull(fVar.adx)) {
                fVar.content = fVar.adx;
            }
            this.adF.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void c(f fVar) {
        if (this.adF != null && fVar != null) {
            if (StringUtils.isNull(fVar.ady)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.ady;
            }
            this.adF.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(f fVar) {
        if (this.adF != null) {
            fVar.content = e(fVar.content, 80, 32);
            this.adF.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void e(f fVar) {
        if (this.adF != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.adF.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void f(f fVar) {
        if (this.adF != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.adF.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void g(f fVar) {
        if (this.adF != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.adF.a(a(fVar, "renren"), 7, true);
        }
    }

    private String e(String str, int i, int i2) {
        String string = TbadkCoreApplication.m411getInst().getContext().getString(y.share_tail);
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
        if (fVar.adv == null && fVar.getImageData() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            fVar.adv = Uri.parse(str2);
        }
        if (fVar.adv != null) {
            fVar.adv = Uri.parse(af(fVar.adv.toString(), "sfc=" + str));
        }
        fVar.adu = af(bd.isEmpty(fVar.adu) ? "http://tieba.baidu.com" : fVar.adu, "sfc=" + str);
        return fVar;
    }

    private String af(String str, String str2) {
        if (bd.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
