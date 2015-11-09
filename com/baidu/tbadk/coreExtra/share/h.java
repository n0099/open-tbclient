package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h {
    private static c aja = null;
    private static boolean ajb = false;
    private a ajc;
    private b ajd;
    private String aje = TbadkCoreApplication.m411getInst().getContext().getString(i.h.share_tail);
    private String ajf = String.valueOf(TbadkCoreApplication.m411getInst().getContext().getString(i.h.weibo_share_tail)) + this.aje;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.ajc = null;
        this.ajd = null;
        this.mContext = context;
        if (aVar != null) {
            this.ajc = aVar;
        }
        aj(this.mContext);
        if (aja != null) {
            this.ajd = aja.createWorker(this.mContext, this.ajc);
        }
    }

    public static boolean aj(Context context) {
        if (context == null) {
            return false;
        }
        if (!ajb) {
            try {
                aja = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            ajb = true;
        }
        return aja != null;
    }

    public void c(f fVar) {
        if (this.ajd != null && fVar != null) {
            if (!StringUtils.isNull(fVar.aiW)) {
                fVar.content = fVar.aiW;
            }
            fVar.content = b(fVar.content, 80, 20, this.aje);
            this.ajd.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void d(f fVar) {
        if (this.ajd != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 20, this.aje);
            if (StringUtils.isNull(fVar.aiX)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.aiX;
            }
            this.ajd.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(f fVar) {
        if (this.ajd != null) {
            fVar.content = b(fVar.content, 80, 32, this.aje);
            this.ajd.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void f(f fVar) {
        if (this.ajd != null) {
            fVar.content = b(fVar.content, 140, 20, this.aje);
            this.ajd.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(f fVar) {
        if (this.ajd != null) {
            fVar.content = b(fVar.content, 140, 20, this.ajf);
            this.ajd.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void h(f fVar) {
        if (this.ajd != null) {
            fVar.content = b(fVar.content, 140, 20, this.aje);
            this.ajd.a(a(fVar, "renren"), 7, true);
        }
    }

    private String b(String str, int i, int i2, String str2) {
        if (str != null) {
            int min = Math.min((i - str2.length()) - i2, str.length());
            if (min < str.length()) {
                return String.valueOf(str.substring(0, min - 1)) + ("..." + str2);
            }
            return String.valueOf(str) + str2;
        }
        return str2;
    }

    private f a(f fVar, String str) {
        if (fVar.imageUri == null && fVar.getImageData() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            fVar.imageUri = Uri.parse(str2);
        }
        if (fVar.imageUri != null) {
            fVar.imageUri = Uri.parse(aj(fVar.imageUri.toString(), "sfc=" + str));
        }
        fVar.linkUrl = aj(as.isEmpty(fVar.linkUrl) ? "http://tieba.baidu.com" : fVar.linkUrl, "sfc=" + str);
        return fVar;
    }

    private String aj(String str, String str2) {
        if (as.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
