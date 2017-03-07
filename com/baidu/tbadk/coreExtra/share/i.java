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
    private static c arX = null;
    private static boolean arY = false;
    private a arZ;
    private b asa;
    private String asb = TbadkCoreApplication.m9getInst().getContext().getString(w.l.share_tail);
    private String asc = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(w.l.weibo_share_tail)) + this.asb;
    private final Context mContext;

    public i(Context context, a aVar) {
        this.arZ = null;
        this.asa = null;
        this.mContext = context;
        if (aVar != null) {
            this.arZ = aVar;
        }
        aK(this.mContext);
        if (arX != null) {
            this.asa = arX.createWorker(this.mContext, this.arZ);
        }
    }

    public static boolean aK(Context context) {
        if (context == null) {
            return false;
        }
        if (!arY) {
            try {
                arX = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            arY = true;
        }
        return arX != null;
    }

    public void c(g gVar) {
        if (this.asa != null && gVar != null) {
            if (!StringUtils.isNull(gVar.arT)) {
                gVar.content = gVar.arT;
            }
            gVar.content = b(gVar.content, 80, 20, this.asb);
            this.asa.a(a(gVar, "weixin"), 3, false);
        }
    }

    public void d(g gVar) {
        if (this.asa != null && gVar != null) {
            gVar.content = b(gVar.content, 80, 20, this.asb);
            if (StringUtils.isNull(gVar.arU)) {
                gVar.title = gVar.content;
            } else {
                gVar.title = gVar.arU;
            }
            this.asa.a(a(gVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(g gVar) {
        if (this.asa != null && gVar != null) {
            gVar.content = b(gVar.content, 80, 32, this.asb);
            this.asa.a(a(gVar, "qqfriend"), 8, true);
        }
    }

    public void f(g gVar) {
        if (this.asa != null) {
            gVar.content = b(gVar.content, 80, 32, this.asb);
            this.asa.a(a(gVar, "qzone"), 4, true);
        }
    }

    public void g(g gVar) {
        if (this.asa != null) {
            gVar.content = b(gVar.content, 140, 20, this.asb);
            this.asa.a(a(gVar, "tencent_weibo"), 5, true);
        }
    }

    public void h(g gVar) {
        if (this.asa != null) {
            gVar.content = b(gVar.content, 140, 20, this.asc);
            this.asa.a(a(gVar, "sina_weibo"), 6, true);
        }
    }

    public void i(g gVar) {
        if (this.asa != null) {
            gVar.content = b(gVar.content, 140, 20, this.asb);
            this.asa.a(a(gVar, "renren"), 7, true);
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
            if (!ex(uri)) {
                gVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                gVar.imageUri = Uri.parse(uri);
                ah(uri, "sfc=" + str);
            }
        }
        gVar.linkUrl = ah(au.isEmpty(gVar.linkUrl) ? TbDomainConfig.DOMAIN_HTTPS_TIEBA : gVar.linkUrl, "sfc=" + str);
        if (!StringUtils.isNull(gVar.arR)) {
            gVar.arR = ah(gVar.arR, "sfc=" + str);
        }
        return gVar;
    }

    private String ah(String str, String str2) {
        if (au.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }

    private boolean ex(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (bb.vQ().dF(str)) {
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
