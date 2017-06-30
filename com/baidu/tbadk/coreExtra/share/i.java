package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.w;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class i {
    private static c atg = null;
    private static boolean ath = false;
    private a ati;
    private b atj;
    private String atk = TbadkCoreApplication.m9getInst().getContext().getString(w.l.share_tail);
    private String atl = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(w.l.weibo_share_tail)) + this.atk;
    private final Context mContext;

    public i(Context context, a aVar) {
        this.ati = null;
        this.atj = null;
        this.mContext = context;
        if (aVar != null) {
            this.ati = aVar;
        }
        aP(this.mContext);
        if (atg != null) {
            this.atj = atg.createWorker(this.mContext, this.ati);
        }
    }

    public static boolean aP(Context context) {
        if (context == null) {
            return false;
        }
        if (!ath) {
            try {
                atg = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            ath = true;
        }
        return atg != null;
    }

    public void c(h hVar) {
        if (this.atj != null && hVar != null) {
            if (!StringUtils.isNull(hVar.ata)) {
                hVar.content = hVar.ata;
            }
            hVar.content = b(hVar.content, 80, 20, this.atk);
            this.atj.a(a(hVar, "weixin"), 3, false);
        }
    }

    public void d(h hVar) {
        if (this.atj != null && hVar != null) {
            hVar.content = b(hVar.content, 80, 20, this.atk);
            if (StringUtils.isNull(hVar.atb)) {
                hVar.title = hVar.content;
            } else {
                hVar.title = hVar.atb;
            }
            this.atj.a(a(hVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(h hVar) {
        if (this.atj != null && hVar != null) {
            hVar.content = b(hVar.content, 80, 32, this.atk);
            this.atj.a(a(hVar, "qqfriend"), 8, true);
        }
    }

    public void f(h hVar) {
        if (this.atj != null) {
            hVar.content = b(hVar.content, 80, 32, this.atk);
            this.atj.a(a(hVar, "qzone"), 4, true);
        }
    }

    public void g(h hVar) {
        if (this.atj != null) {
            hVar.content = b(hVar.content, 140, 20, this.atk);
            this.atj.a(a(hVar, "tencent_weibo"), 5, true);
        }
    }

    public void h(h hVar) {
        if (this.atj != null) {
            hVar.content = b(hVar.content, 140, 20, this.atl);
            this.atj.a(a(hVar, "sina_weibo"), 6, true);
        }
    }

    public void i(h hVar) {
        if (this.atj != null) {
            hVar.content = b(hVar.content, 140, 20, this.atk);
            this.atj.a(a(hVar, "renren"), 7, true);
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
            if (!eU(uri)) {
                hVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                hVar.imageUri = Uri.parse(uri);
                ah(uri, "sfc=" + str);
            }
        }
        hVar.linkUrl = ah(aw.isEmpty(hVar.linkUrl) ? TbDomainConfig.DOMAIN_HTTPS_TIEBA : hVar.linkUrl, "sfc=" + str);
        return hVar;
    }

    private String ah(String str, String str2) {
        if (aw.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }

    private boolean eU(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (be.vP().ea(str)) {
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
