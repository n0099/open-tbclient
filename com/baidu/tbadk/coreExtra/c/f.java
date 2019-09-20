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
import com.baidu.tbadk.core.util.aq;
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
    private b cmj;
    private c cmk;
    private a cmn;
    private final Context mContext;
    private String cml = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
    private String cmm = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.cml;
    private a.InterfaceC0255a cmo = new a.InterfaceC0255a() { // from class: com.baidu.tbadk.coreExtra.c.f.1
        @Override // com.baidu.tbadk.coreExtra.c.a.InterfaceC0255a
        public void d(e eVar) {
            f.this.cmk.a(f.this.a(eVar, "weixin"), 3, false);
        }
    };

    public f(Context context, b bVar) {
        d dVar;
        this.cmj = null;
        this.cmk = null;
        this.mContext = context;
        this.cmj = bVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, d.class);
        if (runTask.getData() != null && (dVar = (d) runTask.getData()) != null) {
            this.cmk = dVar.a(this.mContext, this.cmj);
        }
    }

    public static boolean cJ(Context context) {
        return aqo();
    }

    public static boolean aqo() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001445);
    }

    public static String cb(String str, String str2) {
        return H(str, "copy", str2);
    }

    public void e(e eVar) {
        if (this.cmk != null && eVar != null) {
            if (StringUtils.isNull(eVar.tid)) {
                eVar.content = b(eVar.content, 80, 20, eVar.clY ? this.cml : "");
            }
            if (eVar.cmc && !aq.isEmpty(eVar.cmb)) {
                eVar.imageUri = Uri.parse(eVar.cmb);
                this.cmk.a(a(eVar, "weixin"), 3, false);
            } else if (eVar.cmc && aq.isEmpty(eVar.cmb) && !aq.isEmpty(eVar.tid) && !"0".equals(eVar.tid)) {
                if (this.cmn == null) {
                    this.cmn = new a();
                    this.cmn.a(this.cmo);
                }
                this.cmn.b(eVar);
            } else {
                this.cmk.a(a(eVar, "weixin"), 3, false);
            }
        }
    }

    public void f(e eVar) {
        if (this.cmk != null && eVar != null) {
            eVar.content = b(eVar.content, 80, 20, eVar.clY ? this.cml : "");
            this.cmk.a(a(eVar, "weixin_timeline"), 2, false);
        }
    }

    public void g(e eVar) {
        if (this.cmk != null && eVar != null) {
            eVar.content = b(eVar.content, 80, 32, eVar.clY ? this.cml : "");
            this.cmk.a(a(eVar, "qqfriend"), 8, true);
        }
    }

    public void h(e eVar) {
        if (this.cmk != null) {
            eVar.content = b(eVar.content, 80, 32, eVar.clY ? this.cml : "");
            this.cmk.a(a(eVar, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void i(e eVar) {
        if (this.cmk != null) {
            eVar.content = b(eVar.content, 140, 20, eVar.clY ? this.cml : "");
            this.cmk.a(a(eVar, "tencent_weibo"), 5, true);
        }
    }

    public void j(e eVar) {
        if (this.cmk != null) {
            eVar.content = b(eVar.content, 140, 20, eVar.clY ? this.cmm : "");
            this.cmk.a(a(eVar, "sina_weibo"), 6, true);
        }
    }

    public void k(e eVar) {
        if (this.cmk != null) {
            eVar.content = b(eVar.content, 140, 20, eVar.clY ? this.cml : "");
            this.cmk.a(a(eVar, "renren"), 7, true);
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
        if ((eVar.imageUri == null || eVar.imageUri.equals("")) && eVar.aql() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            eVar.imageUri = Uri.parse(str2);
        }
        if (eVar.imageUri != null && !eVar.imageUri.equals("")) {
            String uri = eVar.imageUri.toString();
            if (!pO(uri) && !pP(uri)) {
                eVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                eVar.imageUri = Uri.parse(uri);
                cc(uri, "sfc=" + str);
            }
        }
        if (eVar.clZ) {
            eVar.linkUrl = H(eVar.linkUrl, str, eVar.tid);
            return eVar;
        }
        return eVar;
    }

    protected boolean pO(String str) {
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

    private static String H(String str, String str2, String str3) {
        String bn;
        if (aq.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String cc = cc(cc(cc(cc(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.hS().az("android_url_need_cuid") == 1) {
                bn = s.bn(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                bn = s.bn(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return cc(cc, "unique=" + bn);
        }
        return cc;
    }

    private static String cc(String str, String str2) {
        String str3 = "&";
        if (!str.contains("?")) {
            str = str + "?";
            str3 = "";
        }
        return str + str3 + str2;
    }

    private boolean pP(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (ba.ajK().ov(str)) {
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
