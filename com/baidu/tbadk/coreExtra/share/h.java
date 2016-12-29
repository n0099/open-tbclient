package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h {
    private static c anv = null;
    private static boolean anw = false;
    private a anx;
    private b any;
    private final Context mContext;
    private String anz = TbadkCoreApplication.m9getInst().getContext().getString(r.j.share_tail);
    private String anA = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(r.j.weibo_share_tail)) + this.anz;

    public h(Context context, a aVar) {
        this.anx = null;
        this.any = null;
        this.mContext = context;
        if (aVar != null) {
            this.anx = aVar;
        }
        ak(this.mContext);
        if (anv != null) {
            this.any = anv.createWorker(this.mContext, this.anx);
        }
    }

    public static boolean ak(Context context) {
        if (context == null) {
            return false;
        }
        if (!anw) {
            try {
                anv = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            anw = true;
        }
        return anv != null;
    }

    public void c(f fVar) {
        if (this.any != null && fVar != null) {
            if (!StringUtils.isNull(fVar.shareAbstract)) {
                fVar.content = fVar.shareAbstract;
            }
            fVar.content = b(fVar.content, 80, 20, this.anz);
            this.any.a(a(fVar, "weixin"), 3, false);
        }
    }

    public void d(f fVar) {
        if (this.any != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 20, this.anz);
            if (StringUtils.isNull(fVar.ans)) {
                fVar.title = fVar.content;
            } else {
                fVar.title = fVar.ans;
            }
            this.any.a(a(fVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(f fVar) {
        if (this.any != null && fVar != null) {
            fVar.content = b(fVar.content, 80, 32, this.anz);
            this.any.a(a(fVar, "qqfriend"), 8, true);
        }
    }

    public void f(f fVar) {
        if (this.any != null) {
            fVar.content = b(fVar.content, 80, 32, this.anz);
            this.any.a(a(fVar, "qzone"), 4, true);
        }
    }

    public void g(f fVar) {
        if (this.any != null) {
            fVar.content = b(fVar.content, 140, 20, this.anz);
            this.any.a(a(fVar, "tencent_weibo"), 5, true);
        }
    }

    public void h(f fVar) {
        if (this.any != null) {
            fVar.content = b(fVar.content, 140, 20, this.anA);
            this.any.a(a(fVar, "sina_weibo"), 6, true);
        }
    }

    public void i(f fVar) {
        if (this.any != null) {
            fVar.content = b(fVar.content, 140, 20, this.anz);
            this.any.a(a(fVar, "renren"), 7, true);
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
            if (!eL(uri)) {
                fVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                fVar.imageUri = Uri.parse(uri);
                aj(uri, "sfc=" + str);
            }
        }
        fVar.linkUrl = aj(av.isEmpty(fVar.linkUrl) ? TbDomainConfig.DOMAIN_HTTPS_TIEBA : fVar.linkUrl, "sfc=" + str);
        return fVar;
    }

    private String aj(String str, String str2) {
        if (av.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }

    private boolean eL(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (bc.vz().dN(str)) {
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
