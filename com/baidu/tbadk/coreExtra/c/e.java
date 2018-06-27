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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes.dex */
public class e {
    private a aGr;
    private b aGs;
    private String aGt = TbadkCoreApplication.getInst().getContext().getString(d.k.share_tail);
    private String aGu = TbadkCoreApplication.getInst().getContext().getString(d.k.weibo_share_tail) + this.aGt;
    private final Context mContext;

    public e(Context context, a aVar) {
        c cVar;
        this.aGr = null;
        this.aGs = null;
        this.mContext = context;
        this.aGr = aVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, c.class);
        if (runTask.getData() != null && (cVar = (c) runTask.getData()) != null) {
            this.aGs = cVar.a(this.mContext, this.aGr);
        }
    }

    public static boolean aX(Context context) {
        return FH();
    }

    public static boolean FH() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001445);
    }

    public static String an(String str, String str2) {
        return n(str, "copy", str2);
    }

    public void b(d dVar) {
        if (this.aGs != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, dVar.aGo ? this.aGt : "");
            this.aGs.a(a(dVar, "weixin"), 3, false);
        }
    }

    public void c(d dVar) {
        if (this.aGs != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, dVar.aGo ? this.aGt : "");
            if (StringUtils.isNull(dVar.aGg)) {
                dVar.title = dVar.content;
            } else {
                dVar.title = dVar.aGg;
            }
            this.aGs.a(a(dVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(d dVar) {
        if (this.aGs != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 32, dVar.aGo ? this.aGt : "");
            this.aGs.a(a(dVar, "qqfriend"), 8, true);
        }
    }

    public void e(d dVar) {
        if (this.aGs != null) {
            dVar.content = b(dVar.content, 80, 32, dVar.aGo ? this.aGt : "");
            this.aGs.a(a(dVar, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void f(d dVar) {
        if (this.aGs != null) {
            dVar.content = b(dVar.content, 140, 20, dVar.aGo ? this.aGt : "");
            this.aGs.a(a(dVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(d dVar) {
        if (this.aGs != null) {
            dVar.content = b(dVar.content, 140, 20, dVar.aGo ? this.aGu : "");
            this.aGs.a(a(dVar, "sina_weibo"), 6, true);
        }
    }

    public void h(d dVar) {
        if (this.aGs != null) {
            dVar.content = b(dVar.content, 140, 20, dVar.aGo ? this.aGt : "");
            this.aGs.a(a(dVar, "renren"), 7, true);
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
        if ((dVar.imageUri == null || dVar.imageUri.equals("")) && dVar.FE() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            dVar.imageUri = Uri.parse(str2);
        }
        if (dVar.imageUri != null && !dVar.imageUri.equals("")) {
            String uri = dVar.imageUri.toString();
            if (!ga(uri) && !gb(uri)) {
                dVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                dVar.imageUri = Uri.parse(uri);
                ao(uri, "sfc=" + str);
            }
        }
        if (dVar.aGp) {
            dVar.linkUrl = n(dVar.linkUrl, str, dVar.tid);
        }
        return dVar;
    }

    protected boolean ga(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
            try {
                File file = new File(new URI(str));
                return file.isFile() && file.exists();
            } catch (URISyntaxException e) {
                return false;
            }
        }
        return false;
    }

    private static String n(String str, String str2, String str3) {
        String bl;
        if (ap.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String ao = ao(ao(ao(ao(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.hv().aw("android_url_need_cuid") == 1) {
                bl = s.bl(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                bl = s.bl(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return ao(ao, "unique=" + bl);
        }
        return ao;
    }

    private static String ao(String str, String str2) {
        if (ap.isEmpty(Uri.parse(str).getQuery())) {
            str = str + "?";
        }
        return str + "&" + str2;
    }

    private boolean gb(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (az.zV().eW(str)) {
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
