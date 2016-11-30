package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h {
    private static c anT = null;
    private static boolean anU = false;
    private a anV;
    private b anW;
    private String anX = TbadkCoreApplication.m9getInst().getContext().getString(r.j.share_tail);
    private String anY = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(r.j.weibo_share_tail)) + this.anX;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.anV = null;
        this.anW = null;
        this.mContext = context;
        if (aVar != null) {
            this.anV = aVar;
        }
        am(this.mContext);
        if (anT != null) {
            this.anW = anT.createWorker(this.mContext, this.anV);
        }
    }

    public static boolean am(Context context) {
        if (context == null) {
            return false;
        }
        if (!anU) {
            try {
                anT = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            anU = true;
        }
        return anT != null;
    }

    public void c(f fVar) {
        if (this.anW != null && fVar != null) {
            if (!StringUtils.isNull(fVar.shareAbstract)) {
                fVar.content = fVar.shareAbstract;
            }
            fVar.content = b(fVar.content, 80, 20, this.anX);
            this.anW.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void d(f fVar) {
        if (this.anW != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 20, this.anX);
            if (StringUtils.isNull(fVar.anQ)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.anQ;
            }
            this.anW.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(f fVar) {
        if (this.anW != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 32, this.anX);
            this.anW.a(a(fVar, "qqfriend"), 8, true);
        }
    }

    public void f(f fVar) {
        if (this.anW != null) {
            fVar.content = b(fVar.content, 80, 32, this.anX);
            this.anW.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void g(f fVar) {
        if (this.anW != null) {
            fVar.content = b(fVar.content, 140, 20, this.anX);
            this.anW.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void h(f fVar) {
        if (this.anW != null) {
            fVar.content = b(fVar.content, 140, 20, this.anY);
            this.anW.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void i(f fVar) {
        if (this.anW != null) {
            fVar.content = b(fVar.content, 140, 20, this.anX);
            this.anW.a(a(fVar, "renren"), 7, true);
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
            if (!eP(uri)) {
                fVar.imageUri = Uri.parse("http://tb1.bdstatic.com/tb/r/image/2013-10-16/2392e7325ec8c6d2f02c9a39509e4438.png");
            } else {
                fVar.imageUri = Uri.parse(uri);
                aj(uri, "sfc=" + str);
            }
        }
        fVar.linkUrl = aj(ax.isEmpty(fVar.linkUrl) ? "http://tieba.baidu.com" : fVar.linkUrl, "sfc=" + str);
        return fVar;
    }

    private String aj(String str, String str2) {
        if (ax.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }

    private boolean eP(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (bf.vP().dP(str)) {
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
