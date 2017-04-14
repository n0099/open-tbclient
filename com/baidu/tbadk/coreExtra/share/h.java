package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h {
    private static c asn = null;
    private static boolean aso = false;
    private a asp;
    private b asq;
    private String asr = TbadkCoreApplication.m9getInst().getContext().getString(w.l.share_tail);
    private String ass = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(w.l.weibo_share_tail)) + this.asr;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.asp = null;
        this.asq = null;
        this.mContext = context;
        if (aVar != null) {
            this.asp = aVar;
        }
        aM(this.mContext);
        if (asn != null) {
            this.asq = asn.createWorker(this.mContext, this.asp);
        }
    }

    public static boolean aM(Context context) {
        if (context == null) {
            return false;
        }
        if (!aso) {
            try {
                asn = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            aso = true;
        }
        return asn != null;
    }

    public void c(g gVar) {
        if (this.asq != null && gVar != null) {
            if (!StringUtils.isNull(gVar.asj)) {
                gVar.content = gVar.asj;
            }
            gVar.content = b(gVar.content, 80, 20, this.asr);
            this.asq.a(a(gVar, "weixin"), 3, false);
        }
    }

    public void d(g gVar) {
        if (this.asq != null && gVar != null) {
            gVar.content = b(gVar.content, 80, 20, this.asr);
            if (StringUtils.isNull(gVar.ask)) {
                gVar.title = gVar.content;
            } else {
                gVar.title = gVar.ask;
            }
            this.asq.a(a(gVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(g gVar) {
        if (this.asq != null && gVar != null) {
            gVar.content = b(gVar.content, 80, 32, this.asr);
            this.asq.a(a(gVar, "qqfriend"), 8, true);
        }
    }

    public void f(g gVar) {
        if (this.asq != null) {
            gVar.content = b(gVar.content, 80, 32, this.asr);
            this.asq.a(a(gVar, "qzone"), 4, true);
        }
    }

    public void g(g gVar) {
        if (this.asq != null) {
            gVar.content = b(gVar.content, 140, 20, this.asr);
            this.asq.a(a(gVar, "tencent_weibo"), 5, true);
        }
    }

    public void h(g gVar) {
        if (this.asq != null) {
            gVar.content = b(gVar.content, 140, 20, this.ass);
            this.asq.a(a(gVar, "sina_weibo"), 6, true);
        }
    }

    public void i(g gVar) {
        if (this.asq != null) {
            gVar.content = b(gVar.content, 140, 20, this.asr);
            this.asq.a(a(gVar, "renren"), 7, true);
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

    private g a(g gVar, String str) {
        if ((gVar.imageUri == null || gVar.imageUri.equals("")) && gVar.getImageData() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            gVar.imageUri = Uri.parse(str2);
        }
        if (gVar.imageUri != null && !gVar.imageUri.equals("")) {
            String uri = gVar.imageUri.toString();
            if (!eD(uri)) {
                gVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                gVar.imageUri = Uri.parse(uri);
                ai(uri, "sfc=" + str);
            }
        }
        gVar.linkUrl = ai(au.isEmpty(gVar.linkUrl) ? TbDomainConfig.DOMAIN_HTTPS_TIEBA : gVar.linkUrl, "sfc=" + str);
        return gVar;
    }

    private String ai(String str, String str2) {
        if (au.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }

    private boolean eD(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (bb.wn().dL(str)) {
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
