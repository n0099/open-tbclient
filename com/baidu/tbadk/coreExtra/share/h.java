package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h {
    private static c ajW = null;
    private static boolean ajX = false;
    private a ajY;
    private b ajZ;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.ajY = null;
        this.ajZ = null;
        this.mContext = context;
        if (aVar != null) {
            this.ajY = aVar;
        }
        ak(this.mContext);
        if (ajW != null) {
            this.ajZ = ajW.createWorker(this.mContext, this.ajY);
        }
    }

    public static boolean ak(Context context) {
        if (context == null) {
            return false;
        }
        if (!ajX) {
            try {
                ajW = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            ajX = true;
        }
        return ajW != null;
    }

    public void b(f fVar) {
        if (this.ajZ != null && fVar != null) {
            if (!StringUtils.isNull(fVar.ajS)) {
                fVar.content = fVar.ajS;
            }
            this.ajZ.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void c(f fVar) {
        if (this.ajZ != null && fVar != null) {
            if (StringUtils.isNull(fVar.ajT)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.ajT;
            }
            this.ajZ.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(f fVar) {
        if (this.ajZ != null) {
            fVar.content = e(fVar.content, 80, 32);
            this.ajZ.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void e(f fVar) {
        if (this.ajZ != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.ajZ.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void f(f fVar) {
        if (this.ajZ != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.ajZ.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void g(f fVar) {
        if (this.ajZ != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.ajZ.a(a(fVar, "renren"), 7, true);
        }
    }

    private String e(String str, int i, int i2) {
        String string = TbadkCoreApplication.m411getInst().getContext().getString(i.h.share_tail);
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
        if (fVar.imageUri == null && fVar.getImageData() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            fVar.imageUri = Uri.parse(str2);
        }
        if (fVar.imageUri != null) {
            fVar.imageUri = Uri.parse(ak(fVar.imageUri.toString(), "sfc=" + str));
        }
        fVar.linkUrl = ak(aq.isEmpty(fVar.linkUrl) ? "http://tieba.baidu.com" : fVar.linkUrl, "sfc=" + str);
        return fVar;
    }

    private String ak(String str, String str2) {
        if (aq.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
