package com.baidu.tbadk.coreExtra.d;

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
    private a atS;
    private b atT;
    private String atU = TbadkCoreApplication.getInst().getContext().getString(d.l.share_tail);
    private String atV = TbadkCoreApplication.getInst().getContext().getString(d.l.weibo_share_tail) + this.atU;
    private final Context mContext;

    public e(Context context, a aVar) {
        c cVar;
        this.atS = null;
        this.atT = null;
        this.mContext = context;
        this.atS = aVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, c.class);
        if (runTask.getData() != null && (cVar = (c) runTask.getData()) != null) {
            this.atT = cVar.a(this.mContext, this.atS);
        }
    }

    public static boolean aW(Context context) {
        return Aw();
    }

    public static boolean Aw() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public static String ak(String str, String str2) {
        return m(str, "copy", str2);
    }

    public void b(d dVar) {
        if (this.atT != null && dVar != null) {
            dVar.content = a(dVar.content, 80, 20, this.atU);
            this.atT.a(a(dVar, "weixin"), 3, false);
        }
    }

    public void c(d dVar) {
        if (this.atT != null && dVar != null) {
            dVar.content = a(dVar.content, 80, 20, this.atU);
            if (StringUtils.isNull(dVar.atL)) {
                dVar.title = dVar.content;
            } else {
                dVar.title = dVar.atL;
            }
            this.atT.a(a(dVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(d dVar) {
        if (this.atT != null && dVar != null) {
            dVar.content = a(dVar.content, 80, 32, this.atU);
            this.atT.a(a(dVar, "qqfriend"), 8, true);
        }
    }

    public void e(d dVar) {
        if (this.atT != null) {
            dVar.content = a(dVar.content, 80, 32, this.atU);
            this.atT.a(a(dVar, "qzone"), 4, true);
        }
    }

    public void f(d dVar) {
        if (this.atT != null) {
            dVar.content = a(dVar.content, 140, 20, this.atU);
            this.atT.a(a(dVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(d dVar) {
        if (this.atT != null) {
            dVar.content = a(dVar.content, 140, 20, this.atV);
            this.atT.a(a(dVar, "sina_weibo"), 6, true);
        }
    }

    public void h(d dVar) {
        if (this.atT != null) {
            dVar.content = a(dVar.content, 140, 20, this.atU);
            this.atT.a(a(dVar, "renren"), 7, true);
        }
    }

    private String a(String str, int i, int i2, String str2) {
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
        if ((dVar.atH == null || dVar.atH.equals("")) && dVar.Av() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            dVar.atH = Uri.parse(str2);
        }
        if (dVar.atH != null && !dVar.atH.equals("")) {
            String uri = dVar.atH.toString();
            if (!eW(uri)) {
                dVar.atH = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                dVar.atH = Uri.parse(uri);
                al(uri, "sfc=" + str);
            }
        }
        dVar.linkUrl = m(dVar.linkUrl, str, dVar.Xf);
        return dVar;
    }

    private static String m(String str, String str2, String str3) {
        String aS;
        if (am.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String al = al(al(al(al(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.eV().af("android_url_need_cuid") == 1) {
                aS = s.aS(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                aS = s.aS(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return al(al, "unique=" + aS);
        }
        return al;
    }

    private static String al(String str, String str2) {
        if (am.isEmpty(Uri.parse(str).getQuery())) {
            str = str + "?";
        }
        return str + "&" + str2;
    }

    private boolean eW(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (av.vH().dY(str)) {
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
