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
    private static c aiV = null;
    private static boolean aiW = false;
    private a aiX;
    private b aiY;
    private String aiZ = TbadkCoreApplication.m411getInst().getContext().getString(i.h.share_tail);
    private String aja = String.valueOf(TbadkCoreApplication.m411getInst().getContext().getString(i.h.weibo_share_tail)) + this.aiZ;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.aiX = null;
        this.aiY = null;
        this.mContext = context;
        if (aVar != null) {
            this.aiX = aVar;
        }
        aj(this.mContext);
        if (aiV != null) {
            this.aiY = aiV.createWorker(this.mContext, this.aiX);
        }
    }

    public static boolean aj(Context context) {
        if (context == null) {
            return false;
        }
        if (!aiW) {
            try {
                aiV = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            aiW = true;
        }
        return aiV != null;
    }

    public void c(f fVar) {
        if (this.aiY != null && fVar != null) {
            if (!StringUtils.isNull(fVar.aiR)) {
                fVar.content = fVar.aiR;
            }
            fVar.content = b(fVar.content, 80, 20, this.aiZ);
            this.aiY.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void d(f fVar) {
        if (this.aiY != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 20, this.aiZ);
            if (StringUtils.isNull(fVar.aiS)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.aiS;
            }
            this.aiY.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(f fVar) {
        if (this.aiY != null) {
            fVar.content = b(fVar.content, 80, 32, this.aiZ);
            this.aiY.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void f(f fVar) {
        if (this.aiY != null) {
            fVar.content = b(fVar.content, 140, 20, this.aiZ);
            this.aiY.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(f fVar) {
        if (this.aiY != null) {
            fVar.content = b(fVar.content, 140, 20, this.aja);
            this.aiY.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void h(f fVar) {
        if (this.aiY != null) {
            fVar.content = b(fVar.content, 140, 20, this.aiZ);
            this.aiY.a(a(fVar, "renren"), 7, true);
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
