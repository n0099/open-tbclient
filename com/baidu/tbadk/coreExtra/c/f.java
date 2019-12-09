package com.baidu.tbadk.coreExtra.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.TbConfig;
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
    private b cyr;
    private c cys;
    private a cyv;
    private final Context mContext;
    private String cyt = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
    private String cyu = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.cyt;
    private a.InterfaceC0282a cyw = new a.InterfaceC0282a() { // from class: com.baidu.tbadk.coreExtra.c.f.1
        @Override // com.baidu.tbadk.coreExtra.c.a.InterfaceC0282a
        public void d(e eVar) {
            f.this.cys.a(f.this.a(eVar, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
        }
    };

    public f(Context context, b bVar) {
        d dVar;
        this.cyr = null;
        this.cys = null;
        this.mContext = context;
        this.cyr = bVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, d.class);
        if (runTask.getData() != null && (dVar = (d) runTask.getData()) != null) {
            this.cys = dVar.a(this.mContext, this.cyr);
        }
    }

    public static boolean cv(Context context) {
        return asg();
    }

    public static boolean asg() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public static String bY(String str, String str2) {
        return L(str, "copy", str2);
    }

    public void e(e eVar) {
        if (this.cys != null && eVar != null) {
            if (StringUtils.isNull(eVar.tid)) {
                eVar.content = b(eVar.content, 80, 20, eVar.cyh ? this.cyt : "");
            }
            if (eVar.cyl && !aq.isEmpty(eVar.cyk)) {
                eVar.imageUri = Uri.parse(eVar.cyk);
                this.cys.a(a(eVar, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            } else if (eVar.cyl && aq.isEmpty(eVar.cyk) && !aq.isEmpty(eVar.tid) && !"0".equals(eVar.tid)) {
                if (this.cyv == null) {
                    this.cyv = new a();
                    this.cyv.a(this.cyw);
                }
                this.cyv.b(eVar);
            } else {
                this.cys.a(a(eVar, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            }
        }
    }

    public void f(e eVar) {
        if (this.cys != null && eVar != null) {
            eVar.content = b(eVar.content, 80, 20, eVar.cyh ? this.cyt : "");
            this.cys.a(a(eVar, LogConfig.LIVE_SHARE_WEIXIN_TIMELINE), 2, false);
        }
    }

    public void g(e eVar) {
        if (this.cys != null && eVar != null) {
            eVar.content = b(eVar.content, 80, 32, eVar.cyh ? this.cyt : "");
            this.cys.a(a(eVar, LogConfig.LIVE_SHARE_QQ_FRIEND), 8, true);
        }
    }

    public void h(e eVar) {
        if (this.cys != null) {
            eVar.content = b(eVar.content, 80, 32, eVar.cyh ? this.cyt : "");
            this.cys.a(a(eVar, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void i(e eVar) {
        if (this.cys != null) {
            eVar.content = b(eVar.content, 140, 20, eVar.cyh ? this.cyt : "");
            this.cys.a(a(eVar, "tencent_weibo"), 5, true);
        }
    }

    public void j(e eVar) {
        if (this.cys != null) {
            eVar.content = b(eVar.content, 140, 20, eVar.cyh ? this.cyu : "");
            this.cys.a(a(eVar, "sina_weibo"), 6, true);
        }
    }

    public void k(e eVar) {
        if (this.cys != null) {
            eVar.content = b(eVar.content, 140, 20, eVar.cyh ? this.cyt : "");
            this.cys.a(a(eVar, "renren"), 7, true);
        }
    }

    private String b(String str, int i, int i2, String str2) {
        if (str != null) {
            int min = Math.min((i - str2.length()) - i2, str.length());
            if (min < str.length()) {
                return str.substring(0, min - 1) + (StringHelper.STRING_MORE + str2);
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
        if ((eVar.imageUri == null || eVar.imageUri.equals("")) && eVar.asd() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith(LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND)) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            eVar.imageUri = Uri.parse(str2);
        }
        if (eVar.imageUri != null && !eVar.imageUri.equals("")) {
            String uri = eVar.imageUri.toString();
            if (!oY(uri) && !oZ(uri)) {
                eVar.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                eVar.imageUri = Uri.parse(uri);
                bZ(uri, "sfc=" + str);
            }
        }
        if (eVar.cyi) {
            eVar.linkUrl = L(eVar.linkUrl, str, eVar.tid);
            return eVar;
        }
        return eVar;
    }

    protected boolean oY(String str) {
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

    private static String L(String str, String str2, String str3) {
        String md5;
        if (aq.isEmpty(str)) {
            str = "http://tieba.baidu.com/";
        }
        String bZ = bZ(bZ(bZ(bZ(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.ft().af("android_url_need_cuid") == 1) {
                md5 = s.toMd5(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                md5 = s.toMd5(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return bZ(bZ, "unique=" + md5);
        }
        return bZ;
    }

    private static String bZ(String str, String str2) {
        String str3 = "&";
        if (!str.contains("?")) {
            str = str + "?";
            str3 = "";
        }
        return str + str3 + str2;
    }

    private boolean oZ(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (ba.amO().UrlValidated(str)) {
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
