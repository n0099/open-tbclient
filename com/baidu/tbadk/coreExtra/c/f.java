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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.c.a;
import com.baidu.tieba.R;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes.dex */
public class f {
    private b cjW;
    private c cjX;
    private a cka;
    private final Context mContext;
    private String cjY = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
    private String cjZ = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.cjY;
    private a.InterfaceC0244a ckb = new a.InterfaceC0244a() { // from class: com.baidu.tbadk.coreExtra.c.f.1
        @Override // com.baidu.tbadk.coreExtra.c.a.InterfaceC0244a
        public void d(e eVar) {
            f.this.cjX.a(f.this.a(eVar, "weixin"), 3, false);
        }
    };

    public f(Context context, b bVar) {
        d dVar;
        this.cjW = null;
        this.cjX = null;
        this.mContext = context;
        this.cjW = bVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, d.class);
        if (runTask.getData() != null && (dVar = (d) runTask.getData()) != null) {
            this.cjX = dVar.a(this.mContext, this.cjW);
        }
    }

    public static boolean cI(Context context) {
        return aoU();
    }

    public static boolean aoU() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001445);
    }

    public static String ca(String str, String str2) {
        return G(str, "copy", str2);
    }

    public void e(e eVar) {
        if (this.cjX != null && eVar != null) {
            if (StringUtils.isNull(eVar.tid)) {
                eVar.content = b(eVar.content, 80, 20, eVar.cjR ? this.cjY : "");
            }
            if (!ap.isEmpty(eVar.cjU)) {
                eVar.imageUri = Uri.parse(eVar.cjU);
                this.cjX.a(a(eVar, "weixin"), 3, false);
            } else if (ap.isEmpty(eVar.cjU) && !ap.isEmpty(eVar.tid) && !"0".equals(eVar.tid)) {
                if (this.cka == null) {
                    this.cka = new a();
                    this.cka.a(this.ckb);
                }
                this.cka.b(eVar);
            } else {
                this.cjX.a(a(eVar, "weixin"), 3, false);
            }
        }
    }

    public void f(e eVar) {
        if (this.cjX != null && eVar != null) {
            eVar.content = b(eVar.content, 80, 20, eVar.cjR ? this.cjY : "");
            this.cjX.a(a(eVar, "weixin_timeline"), 2, false);
        }
    }

    public void g(e eVar) {
        if (this.cjX != null && eVar != null) {
            eVar.content = b(eVar.content, 80, 32, eVar.cjR ? this.cjY : "");
            this.cjX.a(a(eVar, "qqfriend"), 8, true);
        }
    }

    public void h(e eVar) {
        if (this.cjX != null) {
            eVar.content = b(eVar.content, 80, 32, eVar.cjR ? this.cjY : "");
            this.cjX.a(a(eVar, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void i(e eVar) {
        if (this.cjX != null) {
            eVar.content = b(eVar.content, 140, 20, eVar.cjR ? this.cjY : "");
            this.cjX.a(a(eVar, "tencent_weibo"), 5, true);
        }
    }

    public void j(e eVar) {
        if (this.cjX != null) {
            eVar.content = b(eVar.content, 140, 20, eVar.cjR ? this.cjZ : "");
            this.cjX.a(a(eVar, "sina_weibo"), 6, true);
        }
    }

    public void k(e eVar) {
        if (this.cjX != null) {
            eVar.content = b(eVar.content, 140, 20, eVar.cjR ? this.cjY : "");
            this.cjX.a(a(eVar, "renren"), 7, true);
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

    /* JADX INFO: Access modifiers changed from: private */
    public e a(e eVar, String str) {
        if (eVar == null) {
            return null;
        }
        if ((eVar.imageUri == null || eVar.imageUri.equals("")) && eVar.aoR() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            eVar.imageUri = Uri.parse(str2);
        }
        if (eVar.imageUri != null && !eVar.imageUri.equals("")) {
            String uri = eVar.imageUri.toString();
            if (!pm(uri) && !pn(uri)) {
                eVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                eVar.imageUri = Uri.parse(uri);
                cb(uri, "sfc=" + str);
            }
        }
        if (eVar.cjS) {
            eVar.linkUrl = G(eVar.linkUrl, str, eVar.tid);
            return eVar;
        }
        return eVar;
    }

    protected boolean pm(String str) {
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

    private static String G(String str, String str2, String str3) {
        String bm;
        if (ap.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String cb = cb(cb(cb(cb(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.hI().ay("android_url_need_cuid") == 1) {
                bm = s.bm(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                bm = s.bm(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return cb(cb, "unique=" + bm);
        }
        return cb;
    }

    private static String cb(String str, String str2) {
        String str3 = "&";
        if (!str.contains("?")) {
            str = str + "?";
            str3 = "";
        }
        return str + str3 + str2;
    }

    private boolean pn(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (ba.aiz().oa(str)) {
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
