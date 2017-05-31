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
    private static c asd = null;
    private static boolean ase = false;
    private a asf;
    private b asg;
    private String ash = TbadkCoreApplication.m9getInst().getContext().getString(w.l.share_tail);
    private String asi = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(w.l.weibo_share_tail)) + this.ash;
    private final Context mContext;

    public i(Context context, a aVar) {
        this.asf = null;
        this.asg = null;
        this.mContext = context;
        if (aVar != null) {
            this.asf = aVar;
        }
        aP(this.mContext);
        if (asd != null) {
            this.asg = asd.createWorker(this.mContext, this.asf);
        }
    }

    public static boolean aP(Context context) {
        if (context == null) {
            return false;
        }
        if (!ase) {
            try {
                asd = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            ase = true;
        }
        return asd != null;
    }

    public void c(h hVar) {
        if (this.asg != null && hVar != null) {
            if (!StringUtils.isNull(hVar.arX)) {
                hVar.content = hVar.arX;
            }
            hVar.content = b(hVar.content, 80, 20, this.ash);
            this.asg.a(a(hVar, "weixin"), 3, false);
        }
    }

    public void d(h hVar) {
        if (this.asg != null && hVar != null) {
            hVar.content = b(hVar.content, 80, 20, this.ash);
            if (StringUtils.isNull(hVar.arY)) {
                hVar.title = hVar.content;
            } else {
                hVar.title = hVar.arY;
            }
            this.asg.a(a(hVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(h hVar) {
        if (this.asg != null && hVar != null) {
            hVar.content = b(hVar.content, 80, 32, this.ash);
            this.asg.a(a(hVar, "qqfriend"), 8, true);
        }
    }

    public void f(h hVar) {
        if (this.asg != null) {
            hVar.content = b(hVar.content, 80, 32, this.ash);
            this.asg.a(a(hVar, "qzone"), 4, true);
        }
    }

    public void g(h hVar) {
        if (this.asg != null) {
            hVar.content = b(hVar.content, 140, 20, this.ash);
            this.asg.a(a(hVar, "tencent_weibo"), 5, true);
        }
    }

    public void h(h hVar) {
        if (this.asg != null) {
            hVar.content = b(hVar.content, 140, 20, this.asi);
            this.asg.a(a(hVar, "sina_weibo"), 6, true);
        }
    }

    public void i(h hVar) {
        if (this.asg != null) {
            hVar.content = b(hVar.content, 140, 20, this.ash);
            this.asg.a(a(hVar, "renren"), 7, true);
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
            if (!eA(uri)) {
                hVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                hVar.imageUri = Uri.parse(uri);
                ah(uri, "sfc=" + str);
            }
        }
        hVar.linkUrl = ah(au.isEmpty(hVar.linkUrl) ? TbDomainConfig.DOMAIN_HTTPS_TIEBA : hVar.linkUrl, "sfc=" + str);
        return hVar;
    }

    private String ah(String str, String str2) {
        if (au.isEmpty(Uri.parse(str).getQuery())) {
            str = String.valueOf(str) + "?";
        }
        return String.valueOf(str) + "&" + str2;
    }

    private boolean eA(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (bb.vy().dG(str)) {
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
