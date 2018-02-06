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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes.dex */
public class e {
    private a blO;
    private b blP;
    private String blQ = TbadkCoreApplication.getInst().getContext().getString(d.j.share_tail);
    private String blR = TbadkCoreApplication.getInst().getContext().getString(d.j.weibo_share_tail) + this.blQ;
    private final Context mContext;

    public e(Context context, a aVar) {
        c cVar;
        this.blO = null;
        this.blP = null;
        this.mContext = context;
        this.blO = aVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, c.class);
        if (runTask.getData() != null && (cVar = (c) runTask.getData()) != null) {
            this.blP = cVar.a(this.mContext, this.blO);
        }
    }

    public static boolean bc(Context context) {
        return IZ();
    }

    public static boolean IZ() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001445);
    }

    public static String ai(String str, String str2) {
        return n(str, "copy", str2);
    }

    public void b(d dVar) {
        if (this.blP != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, this.blQ);
            this.blP.a(a(dVar, "weixin"), 3, false);
        }
    }

    public void c(d dVar) {
        if (this.blP != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 20, this.blQ);
            if (StringUtils.isNull(dVar.blF)) {
                dVar.title = dVar.content;
            } else {
                dVar.title = dVar.blF;
            }
            this.blP.a(a(dVar, "weixin_timeline"), 2, false);
        }
    }

    public void d(d dVar) {
        if (this.blP != null && dVar != null) {
            dVar.content = b(dVar.content, 80, 32, this.blQ);
            this.blP.a(a(dVar, "qqfriend"), 8, true);
        }
    }

    public void e(d dVar) {
        if (this.blP != null) {
            dVar.content = b(dVar.content, 80, 32, this.blQ);
            this.blP.a(a(dVar, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void f(d dVar) {
        if (this.blP != null) {
            dVar.content = b(dVar.content, 140, 20, this.blQ);
            this.blP.a(a(dVar, "tencent_weibo"), 5, true);
        }
    }

    public void g(d dVar) {
        if (this.blP != null) {
            dVar.content = b(dVar.content, 140, 20, this.blR);
            this.blP.a(a(dVar, "sina_weibo"), 6, true);
        }
    }

    public void h(d dVar) {
        if (this.blP != null) {
            dVar.content = b(dVar.content, 140, 20, this.blQ);
            this.blP.a(a(dVar, "renren"), 7, true);
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
        if ((dVar.blB == null || dVar.blB.equals("")) && dVar.IY() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith("weixin")) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            dVar.blB = Uri.parse(str2);
        }
        if (dVar.blB != null && !dVar.blB.equals("")) {
            String uri = dVar.blB.toString();
            if (!fG(uri)) {
                dVar.blB = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                dVar.blB = Uri.parse(uri);
                aj(uri, "sfc=" + str);
            }
        }
        dVar.linkUrl = n(dVar.linkUrl, str, dVar.tid);
        return dVar;
    }

    private static String n(String str, String str2, String str3) {
        String ba;
        if (am.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String aj = aj(aj(aj(aj(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (com.baidu.adp.lib.b.d.mA().an("android_url_need_cuid") == 1) {
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

    private boolean fG(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (aw.Du().eC(str)) {
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
