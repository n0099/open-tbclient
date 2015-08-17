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
    private static c ajN = null;
    private static boolean ajO = false;
    private a ajP;
    private b ajQ;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.ajP = null;
        this.ajQ = null;
        this.mContext = context;
        if (aVar != null) {
            this.ajP = aVar;
        }
        ak(this.mContext);
        if (ajN != null) {
            this.ajQ = ajN.createWorker(this.mContext, this.ajP);
        }
    }

    public static boolean ak(Context context) {
        if (context == null) {
            return false;
        }
        if (!ajO) {
            try {
                ajN = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            ajO = true;
        }
        return ajN != null;
    }

    public void b(f fVar) {
        if (this.ajQ != null && fVar != null) {
            if (!StringUtils.isNull(fVar.ajJ)) {
                fVar.content = fVar.ajJ;
            }
            this.ajQ.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void c(f fVar) {
        if (this.ajQ != null && fVar != null) {
            if (StringUtils.isNull(fVar.ajK)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.ajK;
            }
            this.ajQ.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(f fVar) {
        if (this.ajQ != null) {
            fVar.content = e(fVar.content, 80, 32);
            this.ajQ.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void e(f fVar) {
        if (this.ajQ != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.ajQ.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void f(f fVar) {
        if (this.ajQ != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.ajQ.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void g(f fVar) {
        if (this.ajQ != null) {
            fVar.content = e(fVar.content, 140, 20);
            this.ajQ.a(a(fVar, "renren"), 7, true);
        }
    }

    private String e(String str, int i, int i2) {
        String string = TbadkCoreApplication.m411getInst().getContext().getString(i.C0057i.share_tail);
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
