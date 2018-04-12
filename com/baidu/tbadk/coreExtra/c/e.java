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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes.dex */
public class e {
    private a axk;
    private b axl;
    private String axm = TbadkCoreApplication.getInst().getContext().getString(d.k.share_tail);
    private String axn = TbadkCoreApplication.getInst().getContext().getString(d.k.weibo_share_tail) + this.axm;
    private final Context mContext;

    public e(Context context, a aVar) {
        c cVar;
        this.axk = null;
        this.axl = null;
        this.mContext = context;
        this.axk = aVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, c.class);
        if (runTask.getData() != null && (cVar = (c) runTask.getData()) != null) {
            this.axl = cVar.a(this.mContext, this.axk);
        }
    }

    public static boolean aN(Context context) {
        return BP();
    }

    public static boolean BP() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001445);
    }

    public static String aj(String str, String str2) {
        return n(str, "copy", str2);
    }

    public void b(d dVar) {
        if (this.axl != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, dVar.axh ? this.axm : "");
            this.axl.a(a(dVar, "weixin"), 3, false);
        }
    }

    public void c(d dVar) {
        if (this.axl != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, dVar.axh ? this.axm : "");
            if (StringUtils.isNull(dVar.awZ)) {
                dVar.title = dVar.content;
            } else {
                dVar.title = dVar.awZ;
            }
            this.axl.a(a(dVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(d dVar) {
        if (this.axl != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 32, dVar.axh ? this.axm : "");
            this.axl.a(a(dVar, "qqfriend"), 8, true);
        }
    }

    public void e(d dVar) {
        if (this.axl != null) {
            dVar.content = b(dVar.content, 80, 32, dVar.axh ? this.axm : "");
            this.axl.a(a(dVar, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void f(d dVar) {
        if (this.axl != null) {
            dVar.content = b(dVar.content, 140, 20, dVar.axh ? this.axm : "");
            this.axl.a(a(dVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(d dVar) {
        if (this.axl != null) {
            dVar.content = b(dVar.content, 140, 20, dVar.axh ? this.axn : "");
            this.axl.a(a(dVar, "sina_weibo"), 6, true);
        }
    }

    public void h(d dVar) {
        if (this.axl != null) {
            dVar.content = b(dVar.content, 140, 20, dVar.axh ? this.axm : "");
            this.axl.a(a(dVar, "renren"), 7, true);
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
        if ((dVar.awV == null || dVar.awV.equals("")) && dVar.BM() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            dVar.awV = Uri.parse(str2);
        }
        if (dVar.awV != null && !dVar.awV.equals("")) {
            String uri = dVar.awV.toString();
            if (!fy(uri) && !fz(uri)) {
                dVar.awV = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                dVar.awV = Uri.parse(uri);
                ak(uri, "sfc=" + str);
            }
        }
        if (dVar.axi) {
            dVar.linkUrl = n(dVar.linkUrl, str, dVar.tid);
        }
        return dVar;
    }

    protected boolean fy(String str) {
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
        String aX;
        if (an.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String ak = ak(ak(ak(ak(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.eE().ak("android_url_need_cuid") == 1) {
                aX = s.aX(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                aX = s.aX(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return ak(ak, "unique=" + aX);
        }
        return ak;
    }

    private static String ak(String str, String str2) {
        if (an.isEmpty(Uri.parse(str).getQuery())) {
            str = str + "?";
        }
        return str + "&" + str2;
    }

    private boolean fz(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (ax.wg().eu(str)) {
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
