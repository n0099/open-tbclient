package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h {
    private static c ana = null;
    private static boolean anb = false;
    private a anc;
    private b and;
    private String ane = TbadkCoreApplication.m9getInst().getContext().getString(r.j.share_tail);
    private String anf = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(r.j.weibo_share_tail)) + this.ane;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.anc = null;
        this.and = null;
        this.mContext = context;
        if (aVar != null) {
            this.anc = aVar;
        }
        am(this.mContext);
        if (ana != null) {
            this.and = ana.createWorker(this.mContext, this.anc);
        }
    }

    public static boolean am(Context context) {
        if (context == null) {
            return false;
        }
        if (!anb) {
            try {
                ana = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            anb = true;
        }
        return ana != null;
    }

    public void c(f fVar) {
        if (this.and != null && fVar != null) {
            if (!StringUtils.isNull(fVar.amW)) {
                fVar.content = fVar.amW;
            }
            fVar.content = b(fVar.content, 80, 20, this.ane);
            this.and.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void d(f fVar) {
        if (this.and != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 20, this.ane);
            if (StringUtils.isNull(fVar.amX)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.amX;
            }
            this.and.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(f fVar) {
        if (this.and != null) {
            fVar.content = b(fVar.content, 80, 32, this.ane);
            this.and.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void f(f fVar) {
        if (this.and != null) {
            fVar.content = b(fVar.content, 140, 20, this.ane);
            this.and.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(f fVar) {
        if (this.and != null) {
            fVar.content = b(fVar.content, 140, 20, this.anf);
            this.and.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void h(f fVar) {
        if (this.and != null) {
            fVar.content = b(fVar.content, 140, 20, this.ane);
            this.and.a(a(fVar, "renren"), 7, true);
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
            if (!eN(uri)) {
                fVar.imageUri = Uri.parse("http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png");
            } else {
                fVar.imageUri = Uri.parse(uri);
                ai(uri, "sfc=" + str);
            }
        }
        fVar.linkUrl = ai(az.isEmpty(fVar.linkUrl) ? "http://tieba.baidu.com" : fVar.linkUrl, "sfc=" + str);
        return fVar;
    }

    private String ai(String str, String str2) {
        if (az.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }

    private boolean eN(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (bh.vL().dN(str)) {
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
