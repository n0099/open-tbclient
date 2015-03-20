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
    private static c adu = null;
    private static boolean adv = false;
    private a adw;
    private b adx;
    private final Context mContext;

    public i(Context context, a aVar) {
        this.adw = null;
        this.adx = null;
        this.mContext = context;
        if (aVar != null) {
            this.adw = aVar;
        }
        ae(this.mContext);
        if (adu != null) {
            this.adx = adu.createWorker(this.mContext, this.adw);
        }
    }

    public static boolean ae(Context context) {
        if (context == null) {
            return false;
        }
        if (!adv) {
            try {
                adu = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                Log.e("", "Exception in checking ShareCreator", e);
            }
            adv = true;
        }
        return adu != null;
    }

    public void b(f fVar) {
        if (this.adx != null && fVar != null) {
            if (!StringUtils.isNull(fVar.adp)) {
                fVar.content = fVar.adp;
            }
            this.adx.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void c(f fVar) {
        if (this.adx != null && fVar != null) {
            if (StringUtils.isNull(fVar.adq)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.adq;
            }
            this.adx.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(f fVar) {
        if (this.adx != null) {
            fVar.content = e(fVar.content, 80, 32);
            this.adx.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void e(f fVar) {
        if (this.adx != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.adx.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void f(f fVar) {
        if (this.adx != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.adx.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void g(f fVar) {
        if (this.adx != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.adx.a(a(fVar, "renren"), 7, true);
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
        if (fVar.adn == null && fVar.getImageData() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            fVar.adn = Uri.parse(str2);
        }
        if (fVar.adn != null) {
            fVar.adn = Uri.parse(af(fVar.adn.toString(), "sfc=" + str));
        }
        fVar.adm = af(bd.isEmpty(fVar.adm) ? "http://tieba.baidu.com" : fVar.adm, "sfc=" + str);
        return fVar;
    }

    private String af(String str, String str2) {
        if (bd.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
