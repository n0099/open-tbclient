package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f {
    private static c avr = null;
    private static boolean avs = false;
    private a avt;
    private b avu;
    private String avv = TbadkCoreApplication.getInst().getContext().getString(d.l.share_tail);
    private String avw = TbadkCoreApplication.getInst().getContext().getString(d.l.weibo_share_tail) + this.avv;
    private final Context mContext;

    public f(Context context, a aVar) {
        this.avt = null;
        this.avu = null;
        this.mContext = context;
        if (aVar != null) {
            this.avt = aVar;
        }
        aQ(this.mContext);
        if (avr != null) {
            this.avu = avr.createWorker(this.mContext, this.avt);
        }
    }

    public static boolean aQ(Context context) {
        if (context == null) {
            return false;
        }
        if (!avs) {
            try {
                avr = (c) context.getClassLoader().loadClass("com.baidu.tbadk.coreExtra.share.implementation.ShareWorkerCreator").newInstance();
            } catch (Exception e) {
                BdLog.e(e);
            }
            avs = true;
        }
        return avr != null;
    }

    public void c(e eVar) {
        if (this.avu != null && eVar != null) {
            if (!StringUtils.isNull(eVar.avl)) {
                eVar.content = eVar.avl;
            }
            eVar.content = b(eVar.content, 80, 20, this.avv);
            this.avu.a(a(eVar, "weixin"), 3, false);
        }
    }

    public void d(e eVar) {
        if (this.avu != null && eVar != null) {
            eVar.content = b(eVar.content, 80, 20, this.avv);
            if (StringUtils.isNull(eVar.avm)) {
                eVar.title = eVar.content;
            } else {
                eVar.title = eVar.avm;
            }
            this.avu.a(a(eVar, "weixin_timeline"), 2, false);
        }
    }

    public void e(e eVar) {
        if (this.avu != null && eVar != null) {
            eVar.content = b(eVar.content, 80, 32, this.avv);
            this.avu.a(a(eVar, "qqfriend"), 8, true);
        }
    }

    public void f(e eVar) {
        if (this.avu != null) {
            eVar.content = b(eVar.content, 80, 32, this.avv);
            this.avu.a(a(eVar, "qzone"), 4, true);
        }
    }

    public void g(e eVar) {
        if (this.avu != null) {
            eVar.content = b(eVar.content, 140, 20, this.avv);
            this.avu.a(a(eVar, "tencent_weibo"), 5, true);
        }
    }

    public void h(e eVar) {
        if (this.avu != null) {
            eVar.content = b(eVar.content, 140, 20, this.avw);
            this.avu.a(a(eVar, "sina_weibo"), 6, true);
        }
    }

    public void i(e eVar) {
        if (this.avu != null) {
            eVar.content = b(eVar.content, 140, 20, this.avv);
            this.avu.a(a(eVar, "renren"), 7, true);
        }
    }

    private String b(String str, int i, int i2, String str2) {
        if (str != null) {
            int min = Math.min((i - str2.length()) - i2, str.length());
            if (min < str.length()) {
                return str.substring(0, min - 1) + ("..." + str2);
            }
            return str + str2;
        }
        return str2;
    }

    private e a(e eVar, String str) {
        if ((eVar.imageUri == null || eVar.imageUri.equals("")) && eVar.getImageData() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            eVar.imageUri = Uri.parse(str2);
        }
        if (eVar.imageUri != null && !eVar.imageUri.equals("")) {
            String uri = eVar.imageUri.toString();
            if (!fi(uri)) {
                eVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                eVar.imageUri = Uri.parse(uri);
                ah(uri, "sfc=" + str);
            }
        }
        eVar.linkUrl = ah(al.isEmpty(eVar.linkUrl) ? TbDomainConfig.DOMAIN_HTTPS_TIEBA : eVar.linkUrl, "sfc=" + str);
        return eVar;
    }

    private String ah(String str, String str2) {
        if (al.isEmpty(Uri.parse(str).getQuery())) {
            str = str + "?";
        }
        return str + "&" + str2;
    }

    private boolean fi(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (at.wg().en(str)) {
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
