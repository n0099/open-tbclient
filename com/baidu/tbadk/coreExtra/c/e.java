package com.baidu.tbadk.coreExtra.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes.dex */
public class e {
    private a aSx;
    private b aSy;
    private final Context mContext;
    private String aSz = TbadkCoreApplication.getInst().getContext().getString(e.j.share_tail);
    private String aSA = TbadkCoreApplication.getInst().getContext().getString(e.j.weibo_share_tail) + this.aSz;

    public e(Context context, a aVar) {
        c cVar;
        this.aSx = null;
        this.aSy = null;
        this.mContext = context;
        this.aSx = aVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, c.class);
        if (runTask.getData() != null && (cVar = (c) runTask.getData()) != null) {
            this.aSy = cVar.a(this.mContext, this.aSx);
        }
    }

    public static boolean bL(Context context) {
        return Kl();
    }

    public static boolean Kl() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001445);
    }

    public static String aG(String str, String str2) {
        return r(str, "copy", str2);
    }

    public void b(d dVar) {
        if (this.aSy != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, dVar.aSu ? this.aSz : "");
            this.aSy.a(a(dVar, "weixin"), 3, false);
        }
    }

    public void c(d dVar) {
        if (this.aSy != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, dVar.aSu ? this.aSz : "");
            if (StringUtils.isNull(dVar.aSm)) {
                dVar.title = dVar.content;
            } else {
                dVar.title = dVar.aSm;
            }
            this.aSy.a(a(dVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(d dVar) {
        if (this.aSy != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 32, dVar.aSu ? this.aSz : "");
            this.aSy.a(a(dVar, "qqfriend"), 8, true);
        }
    }

    public void e(d dVar) {
        if (this.aSy != null) {
            dVar.content = b(dVar.content, 80, 32, dVar.aSu ? this.aSz : "");
            this.aSy.a(a(dVar, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void f(d dVar) {
        if (this.aSy != null) {
            dVar.content = b(dVar.content, 140, 20, dVar.aSu ? this.aSz : "");
            this.aSy.a(a(dVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(d dVar) {
        if (this.aSy != null) {
            dVar.content = b(dVar.content, 140, 20, dVar.aSu ? this.aSA : "");
            this.aSy.a(a(dVar, "sina_weibo"), 6, true);
        }
    }

    public void h(d dVar) {
        if (this.aSy != null) {
            dVar.content = b(dVar.content, 140, 20, dVar.aSu ? this.aSz : "");
            this.aSy.a(a(dVar, "renren"), 7, true);
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

    private d a(d dVar, String str) {
        if ((dVar.imageUri == null || dVar.imageUri.equals("")) && dVar.Ki() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            dVar.imageUri = Uri.parse(str2);
        }
        if (dVar.imageUri != null && !dVar.imageUri.equals("")) {
            String uri = dVar.imageUri.toString();
            if (!hd(uri) && !he(uri)) {
                dVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                dVar.imageUri = Uri.parse(uri);
                aH(uri, "sfc=" + str);
            }
        }
        if (dVar.aSv) {
            dVar.linkUrl = r(dVar.linkUrl, str, dVar.tid);
        }
        return dVar;
    }

    protected boolean hd(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("file://")) {
            try {
                File file = new File(new URI(str));
                return file.isFile() && file.exists();
            } catch (URISyntaxException e) {
                return false;
            }
        }
        return false;
    }

    private static String r(String str, String str2, String str3) {
        String bC;
        if (ao.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String aH = aH(aH(aH(aH(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.iQ().aO("android_url_need_cuid") == 1) {
                bC = s.bC(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                bC = s.bC(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return aH(aH, "unique=" + bC);
        }
        return aH;
    }

    private static String aH(String str, String str2) {
        String str3 = ETAG.ITEM_SEPARATOR;
        if (!str.contains("?")) {
            str = str + "?";
            str3 = "";
        }
        return str + str3 + str2;
    }

    private boolean he(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (ay.Ef().fT(str)) {
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
