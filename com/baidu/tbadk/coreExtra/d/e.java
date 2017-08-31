package com.baidu.tbadk.coreExtra.d;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class e {
    private a auN;
    private b auO;
    private String auP = TbadkCoreApplication.getInst().getContext().getString(d.l.share_tail);
    private String auQ = TbadkCoreApplication.getInst().getContext().getString(d.l.weibo_share_tail) + this.auP;
    private final Context mContext;

    public e(Context context, a aVar) {
        c cVar;
        this.auN = null;
        this.auO = null;
        this.mContext = context;
        this.auN = aVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, c.class);
        if (runTask.getData() != null && (cVar = (c) runTask.getData()) != null) {
            this.auO = cVar.a(this.mContext, this.auN);
        }
    }

    public static boolean aV(Context context) {
        return AY();
    }

    public static boolean AY() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public void b(d dVar) {
        if (this.auO != null && dVar != null) {
            dVar.content = a(dVar.content, 80, 20, this.auP);
            this.auO.a(a(dVar, "weixin"), 3, false);
        }
    }

    public void c(d dVar) {
        if (this.auO != null && dVar != null) {
            dVar.content = a(dVar.content, 80, 20, this.auP);
            if (StringUtils.isNull(dVar.auG)) {
                dVar.title = dVar.content;
            } else {
                dVar.title = dVar.auG;
            }
            this.auO.a(a(dVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(d dVar) {
        if (this.auO != null && dVar != null) {
            dVar.content = a(dVar.content, 80, 32, this.auP);
            this.auO.a(a(dVar, "qqfriend"), 8, true);
        }
    }

    public void e(d dVar) {
        if (this.auO != null) {
            dVar.content = a(dVar.content, 80, 32, this.auP);
            this.auO.a(a(dVar, "qzone"), 4, true);
        }
    }

    public void f(d dVar) {
        if (this.auO != null) {
            dVar.content = a(dVar.content, 140, 20, this.auP);
            this.auO.a(a(dVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(d dVar) {
        if (this.auO != null) {
            dVar.content = a(dVar.content, 140, 20, this.auQ);
            this.auO.a(a(dVar, "sina_weibo"), 6, true);
        }
    }

    public void h(d dVar) {
        if (this.auO != null) {
            dVar.content = a(dVar.content, 140, 20, this.auP);
            this.auO.a(a(dVar, "renren"), 7, true);
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
        String str2;
        String aS;
        if ((dVar.auC == null || dVar.auC.equals("")) && dVar.AX() == null) {
            String str3 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str3 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            dVar.auC = Uri.parse(str3);
        }
        if (dVar.auC != null && !dVar.auC.equals("")) {
            String uri = dVar.auC.toString();
            if (!fd(uri)) {
                dVar.auC = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                dVar.auC = Uri.parse(uri);
                ak(uri, "sfc=" + str);
            }
        }
        String ak = ak(ak(ak(am.isEmpty(dVar.linkUrl) ? TbDomainConfig.DOMAIN_HTTPS_TIEBA : dVar.linkUrl, "sfc=" + str), "client_type=2"), "client_version=" + TbConfig.getVersion());
        if (dVar.Xe != null) {
            if (com.baidu.adp.lib.b.d.eW().af("android_url_need_cuid") == 1) {
                aS = r.aS(dVar.Xe + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                aS = r.aS(dVar.Xe + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            str2 = ak(ak, "unique=" + aS);
        } else {
            str2 = ak;
        }
        dVar.linkUrl = str2;
        return dVar;
    }

    private String ak(String str, String str2) {
        if (am.isEmpty(Uri.parse(str).getQuery())) {
            str = str + "?";
        }
        return str + "&" + str2;
    }

    private boolean fd(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (au.wd().ef(str)) {
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
