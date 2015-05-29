package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i {
    private static c aeG = null;
    private static boolean aeH = false;
    private a aeI;
    private b aeJ;
    private final Context mContext;

    public i(Context context, a aVar) {
        this.aeI = null;
        this.aeJ = null;
        this.mContext = context;
        if (aVar != null) {
            this.aeI = aVar;
        }
        ai(this.mContext);
        if (aeG != null) {
            this.aeJ = aeG.createWorker(this.mContext, this.aeI);
        }
    }

    public static boolean ai(Context context) {
        if (context == null) {
            return false;
        }
        if (!aeH) {
            try {
                aeG = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                Log.e("", "Exception in checking ShareCreator", e);
            }
            aeH = true;
        }
        return aeG != null;
    }

    public void b(g gVar) {
        if (this.aeJ != null && gVar != null) {
            if (!StringUtils.isNull(gVar.aeC)) {
                gVar.content = gVar.aeC;
            }
            this.aeJ.a(a(gVar, "weixin"), 3, false);
        }
    }

    public void c(g gVar) {
        if (this.aeJ != null && gVar != null) {
            if (StringUtils.isNull(gVar.aeD)) {
                gVar.title = gVar.content;
            } else {
                gVar.title = gVar.aeD;
            }
            this.aeJ.a(a(gVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(g gVar) {
        if (this.aeJ != null) {
            gVar.content = e(gVar.content, 80, 32);
            this.aeJ.a(a(gVar, "qzone"), 4, true);
        }
    }

    public void e(g gVar) {
        if (this.aeJ != null) {
            gVar.content = e(gVar.content, 140, 20);
            this.aeJ.a(a(gVar, "tencent_weibo"), 5, true);
        }
    }

    public void f(g gVar) {
        if (this.aeJ != null) {
            gVar.content = e(gVar.content, 140, 20);
            this.aeJ.a(a(gVar, "sina_weibo"), 6, true);
        }
    }

    public void g(g gVar) {
        if (this.aeJ != null) {
            gVar.content = e(gVar.content, 140, 20);
            this.aeJ.a(a(gVar, "renren"), 7, true);
        }
    }

    private String e(String str, int i, int i2) {
        String string = TbadkCoreApplication.m411getInst().getContext().getString(t.share_tail);
        if (str != null) {
            int min = Math.min((i - string.length()) - i2, str.length());
            if (min < str.length()) {
                return String.valueOf(str.substring(0, min - 1)) + ("..." + string);
            }
            return String.valueOf(str) + string;
        }
        return string;
    }

    private g a(g gVar, String str) {
        if (gVar.imageUri == null && gVar.getImageData() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-11/6e28217cc80f804e61251d35ba4c5fbd.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            gVar.imageUri = Uri.parse(str2);
        }
        if (gVar.imageUri != null) {
            gVar.imageUri = Uri.parse(ak(gVar.imageUri.toString(), "sfc=" + str));
        }
        gVar.linkUrl = ak(bb.isEmpty(gVar.linkUrl) ? "http://tieba.baidu.com" : gVar.linkUrl, "sfc=" + str);
        return gVar;
    }

    private String ak(String str, String str2) {
        if (bb.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
