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
    private a atG;
    private b atH;
    private String atI = TbadkCoreApplication.getInst().getContext().getString(d.l.share_tail);
    private String atJ = TbadkCoreApplication.getInst().getContext().getString(d.l.weibo_share_tail) + this.atI;
    private final Context mContext;

    public e(Context context, a aVar) {
        c cVar;
        this.atG = null;
        this.atH = null;
        this.mContext = context;
        this.atG = aVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, c.class);
        if (runTask.getData() != null && (cVar = (c) runTask.getData()) != null) {
            this.atH = cVar.a(this.mContext, this.atG);
        }
    }

    public static boolean aV(Context context) {
        return Aq();
    }

    public static boolean Aq() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public static String aj(String str, String str2) {
        return m(str, "copy", str2);
    }

    public void b(d dVar) {
        if (this.atH != null && dVar != null) {
            dVar.content = a(dVar.content, 80, 20, this.atI);
            this.atH.a(a(dVar, "weixin"), 3, false);
        }
    }

    public void c(d dVar) {
        if (this.atH != null && dVar != null) {
            dVar.content = a(dVar.content, 80, 20, this.atI);
            if (StringUtils.isNull(dVar.atz)) {
                dVar.title = dVar.content;
            } else {
                dVar.title = dVar.atz;
            }
            this.atH.a(a(dVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(d dVar) {
        if (this.atH != null && dVar != null) {
            dVar.content = a(dVar.content, 80, 32, this.atI);
            this.atH.a(a(dVar, "qqfriend"), 8, true);
        }
    }

    public void e(d dVar) {
        if (this.atH != null) {
            dVar.content = a(dVar.content, 80, 32, this.atI);
            this.atH.a(a(dVar, "qzone"), 4, true);
        }
    }

    public void f(d dVar) {
        if (this.atH != null) {
            dVar.content = a(dVar.content, 140, 20, this.atI);
            this.atH.a(a(dVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(d dVar) {
        if (this.atH != null) {
            dVar.content = a(dVar.content, 140, 20, this.atJ);
            this.atH.a(a(dVar, "sina_weibo"), 6, true);
        }
    }

    public void h(d dVar) {
        if (this.atH != null) {
            dVar.content = a(dVar.content, 140, 20, this.atI);
            this.atH.a(a(dVar, "renren"), 7, true);
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
        if ((dVar.atv == null || dVar.atv.equals("")) && dVar.Ap() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            dVar.atv = Uri.parse(str2);
        }
        if (dVar.atv != null && !dVar.atv.equals("")) {
            String uri = dVar.atv.toString();
            if (!eV(uri)) {
                dVar.atv = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                dVar.atv = Uri.parse(uri);
                ak(uri, "sfc=" + str);
            }
        }
        dVar.linkUrl = m(dVar.linkUrl, str, dVar.WT);
        return dVar;
    }

    private static String m(String str, String str2, String str3) {
        String aS;
        if (am.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String ak = ak(ak(ak(ak(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.eV().af("android_url_need_cuid") == 1) {
                aS = s.aS(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                aS = s.aS(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return ak(ak, "unique=" + aS);
        }
        return ak;
    }

    private static String ak(String str, String str2) {
        if (am.isEmpty(Uri.parse(str).getQuery())) {
            str = str + "?";
        }
        return str + "&" + str2;
    }

    private boolean eV(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (av.vA().dX(str)) {
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
