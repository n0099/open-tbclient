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
public class i {
    private static c ast = null;
    private static boolean asu = false;
    private a asv;
    private b asw;
    private String asx = TbadkCoreApplication.m9getInst().getContext().getString(w.l.share_tail);
    private String asy = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(w.l.weibo_share_tail)) + this.asx;
    private final Context mContext;

    public i(Context context, a aVar) {
        this.asv = null;
        this.asw = null;
        this.mContext = context;
        if (aVar != null) {
            this.asv = aVar;
        }
        aP(this.mContext);
        if (ast != null) {
            this.asw = ast.createWorker(this.mContext, this.asv);
        }
    }

    public static boolean aP(Context context) {
        if (context == null) {
            return false;
        }
        if (!asu) {
            try {
                ast = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            asu = true;
        }
        return ast != null;
    }

    public void c(h hVar) {
        if (this.asw != null && hVar != null) {
            if (!StringUtils.isNull(hVar.asn)) {
                hVar.content = hVar.asn;
            }
            hVar.content = b(hVar.content, 80, 20, this.asx);
            this.asw.a(a(hVar, "weixin"), 3, false);
        }
    }

    public void d(h hVar) {
        if (this.asw != null && hVar != null) {
            hVar.content = b(hVar.content, 80, 20, this.asx);
            if (StringUtils.isNull(hVar.aso)) {
                hVar.title = hVar.content;
            } else {
                hVar.title = hVar.aso;
            }
            this.asw.a(a(hVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(h hVar) {
        if (this.asw != null && hVar != null) {
            hVar.content = b(hVar.content, 80, 32, this.asx);
            this.asw.a(a(hVar, "qqfriend"), 8, true);
        }
    }

    public void f(h hVar) {
        if (this.asw != null) {
            hVar.content = b(hVar.content, 80, 32, this.asx);
            this.asw.a(a(hVar, "qzone"), 4, true);
        }
    }

    public void g(h hVar) {
        if (this.asw != null) {
            hVar.content = b(hVar.content, 140, 20, this.asx);
            this.asw.a(a(hVar, "tencent_weibo"), 5, true);
        }
    }

    public void h(h hVar) {
        if (this.asw != null) {
            hVar.content = b(hVar.content, 140, 20, this.asy);
            this.asw.a(a(hVar, "sina_weibo"), 6, true);
        }
    }

    public void i(h hVar) {
        if (this.asw != null) {
            hVar.content = b(hVar.content, 140, 20, this.asx);
            this.asw.a(a(hVar, "renren"), 7, true);
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

    private h a(h hVar, String str) {
        if ((hVar.imageUri == null || hVar.imageUri.equals("")) && hVar.getImageData() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            hVar.imageUri = Uri.parse(str2);
        }
        if (hVar.imageUri != null && !hVar.imageUri.equals("")) {
            String uri = hVar.imageUri.toString();
            if (!eC(uri)) {
                hVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                hVar.imageUri = Uri.parse(uri);
                ai(uri, "sfc=" + str);
            }
        }
        hVar.linkUrl = ai(au.isEmpty(hVar.linkUrl) ? TbDomainConfig.DOMAIN_HTTPS_TIEBA : hVar.linkUrl, "sfc=" + str);
        return hVar;
    }

    private String ai(String str, String str2) {
        if (au.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }

    private boolean eC(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (bb.vB().dJ(str)) {
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
