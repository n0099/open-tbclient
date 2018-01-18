package com.baidu.tbadk.coreExtra.c;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class e {
    private a bjr;
    private b bjs;
    private String bjt = TbadkCoreApplication.getInst().getContext().getString(d.j.share_tail);
    private String bju = TbadkCoreApplication.getInst().getContext().getString(d.j.weibo_share_tail) + this.bjt;
    private final Context mContext;

    public e(Context context, a aVar) {
        c cVar;
        this.bjr = null;
        this.bjs = null;
        this.mContext = context;
        this.bjr = aVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, c.class);
        if (runTask.getData() != null && (cVar = (c) runTask.getData()) != null) {
            this.bjs = cVar.a(this.mContext, this.bjr);
        }
    }

    public static boolean bg(Context context) {
        return Ir();
    }

    public static boolean Ir() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public static String ai(String str, String str2) {
        return o(str, "copy", str2);
    }

    public void b(d dVar) {
        if (this.bjs != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, this.bjt);
            this.bjs.a(a(dVar, "weixin"), 3, false);
        }
    }

    public void c(d dVar) {
        if (this.bjs != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, this.bjt);
            if (StringUtils.isNull(dVar.bji)) {
                dVar.title = dVar.content;
            } else {
                dVar.title = dVar.bji;
            }
            this.bjs.a(a(dVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(d dVar) {
        if (this.bjs != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 32, this.bjt);
            this.bjs.a(a(dVar, "qqfriend"), 8, true);
        }
    }

    public void e(d dVar) {
        if (this.bjs != null) {
            dVar.content = b(dVar.content, 80, 32, this.bjt);
            this.bjs.a(a(dVar, "qzone"), 4, true);
        }
    }

    public void f(d dVar) {
        if (this.bjs != null) {
            dVar.content = b(dVar.content, 140, 20, this.bjt);
            this.bjs.a(a(dVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(d dVar) {
        if (this.bjs != null) {
            dVar.content = b(dVar.content, 140, 20, this.bju);
            this.bjs.a(a(dVar, "sina_weibo"), 6, true);
        }
    }

    public void h(d dVar) {
        if (this.bjs != null) {
            dVar.content = b(dVar.content, 140, 20, this.bjt);
            this.bjs.a(a(dVar, "renren"), 7, true);
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
        if ((dVar.bje == null || dVar.bje.equals("")) && dVar.Iq() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            dVar.bje = Uri.parse(str2);
        }
        if (dVar.bje != null && !dVar.bje.equals("")) {
            String uri = dVar.bje.toString();
            if (!fp(uri)) {
                dVar.bje = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                dVar.bje = Uri.parse(uri);
                aj(uri, "sfc=" + str);
            }
        }
        dVar.linkUrl = o(dVar.linkUrl, str, dVar.tid);
        return dVar;
    }

    private static String o(String str, String str2, String str3) {
        String ba;
        if (am.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String aj = aj(aj(aj(aj(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.mz().an("android_url_need_cuid") == 1) {
                ba = s.ba(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                ba = s.ba(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return aj(aj, "unique=" + ba);
        }
        return aj;
    }

    private static String aj(String str, String str2) {
        if (am.isEmpty(Uri.parse(str).getQuery())) {
            str = str + "?";
        }
        return str + "&" + str2;
    }

    private boolean fp(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (av.CZ().em(str)) {
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
