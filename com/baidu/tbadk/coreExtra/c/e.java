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
    private b bjA;
    private String bjB = TbadkCoreApplication.getInst().getContext().getString(d.j.share_tail);
    private String bjC = TbadkCoreApplication.getInst().getContext().getString(d.j.weibo_share_tail) + this.bjB;
    private a bjz;
    private final Context mContext;

    public e(Context context, a aVar) {
        c cVar;
        this.bjz = null;
        this.bjA = null;
        this.mContext = context;
        this.bjz = aVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, c.class);
        if (runTask.getData() != null && (cVar = (c) runTask.getData()) != null) {
            this.bjA = cVar.a(this.mContext, this.bjz);
        }
    }

    public static boolean bd(Context context) {
        return It();
    }

    public static boolean It() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public static String ah(String str, String str2) {
        return o(str, "copy", str2);
    }

    public void b(d dVar) {
        if (this.bjA != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, this.bjB);
            this.bjA.a(a(dVar, "weixin"), 3, false);
        }
    }

    public void c(d dVar) {
        if (this.bjA != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, this.bjB);
            if (StringUtils.isNull(dVar.bjq)) {
                dVar.title = dVar.content;
            } else {
                dVar.title = dVar.bjq;
            }
            this.bjA.a(a(dVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(d dVar) {
        if (this.bjA != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 32, this.bjB);
            this.bjA.a(a(dVar, "qqfriend"), 8, true);
        }
    }

    public void e(d dVar) {
        if (this.bjA != null) {
            dVar.content = b(dVar.content, 80, 32, this.bjB);
            this.bjA.a(a(dVar, "qzone"), 4, true);
        }
    }

    public void f(d dVar) {
        if (this.bjA != null) {
            dVar.content = b(dVar.content, 140, 20, this.bjB);
            this.bjA.a(a(dVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(d dVar) {
        if (this.bjA != null) {
            dVar.content = b(dVar.content, 140, 20, this.bjC);
            this.bjA.a(a(dVar, "sina_weibo"), 6, true);
        }
    }

    public void h(d dVar) {
        if (this.bjA != null) {
            dVar.content = b(dVar.content, 140, 20, this.bjB);
            this.bjA.a(a(dVar, "renren"), 7, true);
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
        if ((dVar.bjm == null || dVar.bjm.equals("")) && dVar.Is() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            dVar.bjm = Uri.parse(str2);
        }
        if (dVar.bjm != null && !dVar.bjm.equals("")) {
            String uri = dVar.bjm.toString();
            if (!fx(uri)) {
                dVar.bjm = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                dVar.bjm = Uri.parse(uri);
                ai(uri, "sfc=" + str);
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
        String ai = ai(ai(ai(ai(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.mA().an("android_url_need_cuid") == 1) {
                ba = s.ba(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                ba = s.ba(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return ai(ai, "unique=" + ba);
        }
        return ai;
    }

    private static String ai(String str, String str2) {
        if (am.isEmpty(Uri.parse(str).getQuery())) {
            str = str + "?";
        }
        return str + "&" + str2;
    }

    private boolean fx(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (av.Da().er(str)) {
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
