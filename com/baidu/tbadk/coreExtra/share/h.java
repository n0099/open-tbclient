package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h {
    private static c amC = null;
    private static boolean amD = false;
    private a amE;
    private b amF;
    private String amG = TbadkCoreApplication.m9getInst().getContext().getString(r.l.share_tail);
    private String amH = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(r.l.weibo_share_tail)) + this.amG;
    private final Context mContext;

    public h(Context context, a aVar) {
        this.amE = null;
        this.amF = null;
        this.mContext = context;
        if (aVar != null) {
            this.amE = aVar;
        }
        am(this.mContext);
        if (amC != null) {
            this.amF = amC.createWorker(this.mContext, this.amE);
        }
    }

    public static boolean am(Context context) {
        if (context == null) {
            return false;
        }
        if (!amD) {
            try {
                amC = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            amD = true;
        }
        return amC != null;
    }

    public void c(f fVar) {
        if (this.amF != null && fVar != null) {
            if (!StringUtils.isNull(fVar.amy)) {
                fVar.content = fVar.amy;
            }
            fVar.content = b(fVar.content, 80, 20, this.amG);
            this.amF.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void d(f fVar) {
        if (this.amF != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 20, this.amG);
            if (StringUtils.isNull(fVar.amz)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.amz;
            }
            this.amF.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(f fVar) {
        if (this.amF != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 32, this.amG);
            this.amF.a(a(fVar, "qqfriend"), 8, true);
        }
    }

    public void f(f fVar) {
        if (this.amF != null) {
            fVar.content = b(fVar.content, 80, 32, this.amG);
            this.amF.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void g(f fVar) {
        if (this.amF != null) {
            fVar.content = b(fVar.content, 140, 20, this.amG);
            this.amF.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void h(f fVar) {
        if (this.amF != null) {
            fVar.content = b(fVar.content, 140, 20, this.amH);
            this.amF.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void i(f fVar) {
        if (this.amF != null) {
            fVar.content = b(fVar.content, 140, 20, this.amG);
            this.amF.a(a(fVar, "renren"), 7, true);
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
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            fVar.imageUri = Uri.parse(str2);
        }
        if (fVar.imageUri != null && !fVar.imageUri.equals("")) {
            String uri = fVar.imageUri.toString();
            if (!eI(uri)) {
                fVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                fVar.imageUri = Uri.parse(uri);
                aj(uri, "sfc=" + str);
            }
        }
        fVar.linkUrl = aj(at.isEmpty(fVar.linkUrl) ? TbDomainConfig.DOMAIN_HTTPS_TIEBA : fVar.linkUrl, "sfc=" + str);
        return fVar;
    }

    private String aj(String str, String str2) {
        if (at.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }

    private boolean eI(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (ba.vt().dL(str)) {
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
