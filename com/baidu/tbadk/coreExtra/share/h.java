package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h {
    private static c aiU = null;
    private static boolean aiV = false;
    private a aiW;
    private b aiX;
    private String aiY = TbadkCoreApplication.m411getInst().getContext().getString(i.h.share_tail);
    private String aiZ = String.valueOf(TbadkCoreApplication.m411getInst().getContext().getString(i.h.weibo_share_tail)) + this.aiY;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.aiW = null;
        this.aiX = null;
        this.mContext = context;
        if (aVar != null) {
            this.aiW = aVar;
        }
        aj(this.mContext);
        if (aiU != null) {
            this.aiX = aiU.createWorker(this.mContext, this.aiW);
        }
    }

    public static boolean aj(Context context) {
        if (context == null) {
            return false;
        }
        if (!aiV) {
            try {
                aiU = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            aiV = true;
        }
        return aiU != null;
    }

    public void c(f fVar) {
        if (this.aiX != null && fVar != null) {
            if (!StringUtils.isNull(fVar.aiQ)) {
                fVar.content = fVar.aiQ;
            }
            fVar.content = b(fVar.content, 80, 20, this.aiY);
            this.aiX.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void d(f fVar) {
        if (this.aiX != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 20, this.aiY);
            if (StringUtils.isNull(fVar.aiR)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.aiR;
            }
            this.aiX.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(f fVar) {
        if (this.aiX != null) {
            fVar.content = b(fVar.content, 80, 32, this.aiY);
            this.aiX.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void f(f fVar) {
        if (this.aiX != null) {
            fVar.content = b(fVar.content, 140, 20, this.aiY);
            this.aiX.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(f fVar) {
        if (this.aiX != null) {
            fVar.content = b(fVar.content, 140, 20, this.aiZ);
            this.aiX.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void h(f fVar) {
        if (this.aiX != null) {
            fVar.content = b(fVar.content, 140, 20, this.aiY);
            this.aiX.a(a(fVar, "renren"), 7, true);
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
        fVar.linkUrl = aj(ar.isEmpty(fVar.linkUrl) ? "http://tieba.baidu.com" : fVar.linkUrl, "sfc=" + str);
        return fVar;
    }

    private String aj(String str, String str2) {
        if (ar.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }
}
