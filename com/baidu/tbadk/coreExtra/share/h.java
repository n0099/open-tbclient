package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h {
    private static c akn = null;
    private static boolean ako = false;
    private a akp;
    private b akq;
    private String akr = TbadkCoreApplication.m10getInst().getContext().getString(u.j.share_tail);
    private String aks = String.valueOf(TbadkCoreApplication.m10getInst().getContext().getString(u.j.weibo_share_tail)) + this.akr;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.akp = null;
        this.akq = null;
        this.mContext = context;
        if (aVar != null) {
            this.akp = aVar;
        }
        ae(this.mContext);
        if (akn != null) {
            this.akq = akn.createWorker(this.mContext, this.akp);
        }
    }

    public static boolean ae(Context context) {
        if (context == null) {
            return false;
        }
        if (!ako) {
            try {
                akn = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            ako = true;
        }
        return akn != null;
    }

    public void c(f fVar) {
        if (this.akq != null && fVar != null) {
            if (!StringUtils.isNull(fVar.akj)) {
                fVar.content = fVar.akj;
            }
            fVar.content = b(fVar.content, 80, 20, this.akr);
            this.akq.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void d(f fVar) {
        if (this.akq != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 20, this.akr);
            if (StringUtils.isNull(fVar.akk)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.akk;
            }
            this.akq.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(f fVar) {
        if (this.akq != null) {
            fVar.content = b(fVar.content, 80, 32, this.akr);
            this.akq.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void f(f fVar) {
        if (this.akq != null) {
            fVar.content = b(fVar.content, 140, 20, this.akr);
            this.akq.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(f fVar) {
        if (this.akq != null) {
            fVar.content = b(fVar.content, 140, 20, this.aks);
            this.akq.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void h(f fVar) {
        if (this.akq != null) {
            fVar.content = b(fVar.content, 140, 20, this.akr);
            this.akq.a(a(fVar, "renren"), 7, true);
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
        if ((fVar.imageUri == null || fVar.imageUri.equals("")) && fVar.getImageData() == null) {
            String str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            if (str.startsWith("weixin")) {
                str2 = "http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png";
            }
            fVar.imageUri = Uri.parse(str2);
        }
        if (fVar.imageUri != null && !fVar.imageUri.equals("")) {
            String uri = fVar.imageUri.toString();
            if (!eH(uri)) {
                fVar.imageUri = Uri.parse("http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png");
            } else {
                fVar.imageUri = Uri.parse(uri);
                ai(uri, "sfc=" + str);
            }
        }
        fVar.linkUrl = ai(ba.isEmpty(fVar.linkUrl) ? "http://tieba.baidu.com" : fVar.linkUrl, "sfc=" + str);
        return fVar;
    }

    private String ai(String str, String str2) {
        if (ba.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }

    private boolean eH(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (bi.us().dI(str)) {
            if (split == null || split.length <= 0) {
                return true;
            }
            for (String str2 : split) {
                if (str2 != null && !str2.equals("") && (str.endsWith(str2) || str.endsWith(str2.toUpperCase()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
