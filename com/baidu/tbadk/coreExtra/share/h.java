package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h {
    private static c ans = null;
    private static boolean ant = false;
    private a anu;
    private b anv;
    private String anw = TbadkCoreApplication.m9getInst().getContext().getString(t.j.share_tail);
    private String anx = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(t.j.weibo_share_tail)) + this.anw;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.anu = null;
        this.anv = null;
        this.mContext = context;
        if (aVar != null) {
            this.anu = aVar;
        }
        ao(this.mContext);
        if (ans != null) {
            this.anv = ans.createWorker(this.mContext, this.anu);
        }
    }

    public static boolean ao(Context context) {
        if (context == null) {
            return false;
        }
        if (!ant) {
            try {
                ans = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            ant = true;
        }
        return ans != null;
    }

    public void c(f fVar) {
        if (this.anv != null && fVar != null) {
            if (!StringUtils.isNull(fVar.ano)) {
                fVar.content = fVar.ano;
            }
            fVar.content = b(fVar.content, 80, 20, this.anw);
            this.anv.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void d(f fVar) {
        if (this.anv != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 20, this.anw);
            if (StringUtils.isNull(fVar.anp)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.anp;
            }
            this.anv.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(f fVar) {
        if (this.anv != null) {
            fVar.content = b(fVar.content, 80, 32, this.anw);
            this.anv.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void f(f fVar) {
        if (this.anv != null) {
            fVar.content = b(fVar.content, 140, 20, this.anw);
            this.anv.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(f fVar) {
        if (this.anv != null) {
            fVar.content = b(fVar.content, 140, 20, this.anx);
            this.anv.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void h(f fVar) {
        if (this.anv != null) {
            fVar.content = b(fVar.content, 140, 20, this.anw);
            this.anv.a(a(fVar, "renren"), 7, true);
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
            if (!eK(uri)) {
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

    private boolean eK(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (bi.vx().dK(str)) {
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
