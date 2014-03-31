package com.baidu.tbadk.d;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.af;
import com.baidu.tbadk.core.b.ag;
import com.baidu.tbadk.core.b.ah;
import com.baidu.tbadk.core.b.l;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class d {
    public static boolean a(Context context, String str) {
        if (str != null) {
            try {
                if (str.contains("jump=outer")) {
                    com.baidu.tbadk.browser.a.c(context, str);
                    return true;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(d.class.getName(), "jumpTiebaNative", e.getMessage());
            }
        }
        if (str != null && str.contains("jump=finish_this_page") && (context instanceof com.baidu.tbadk.a)) {
            ((com.baidu.tbadk.a) context).finish();
            return true;
        }
        if (str != null && str.contains("jump_tieba_native=1")) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2010021, new com.baidu.tbadk.core.b.f(context)));
                return true;
            } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new ag(context, a(str, "userid="), a(str, "un="))));
                return true;
            } else if (str.contains("jump_chat=1")) {
                String a = a(str, "userid=");
                String a2 = a(str, "username=");
                String a3 = a(str, "portrait=");
                if (a != null && a.length() > 0) {
                    try {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001005, new ah(context, Long.parseLong(a), a2, a3, 0)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2008012));
                }
                return true;
            } else if (str.contains("kz=")) {
                String a4 = a(str, "kz=");
                if (a4 != null && a4.length() >= 0) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2004001, new af(context).a(a4, null, "allthread")));
                }
                return true;
            } else if (str.contains("kw=")) {
                String a5 = a(str, "kw=");
                if (a5 != null && a5.length() >= 0) {
                    if (context instanceof com.baidu.tbadk.a) {
                        ((com.baidu.tbadk.a) context).sendMessage(new com.baidu.adp.framework.message.a(2003000, new l(context).a(a5, "allthread")));
                    } else if (context instanceof com.baidu.tbadk.core.e) {
                        ((com.baidu.tbadk.core.e) context).a(new com.baidu.adp.framework.message.a(2003000, new l(context).a(a5, "allthread")));
                    }
                }
                return true;
            } else if (str.contains("jumptologin=1") && (context instanceof Activity)) {
                LoginActivity.a((Activity) context, "", true, 0);
                return true;
            } else if (str.contains("jumptobubble_list") && (context instanceof Activity)) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.d(context)));
                return true;
            } else if (str.contains("pay=1") && (context instanceof Activity)) {
                ((Activity) context).finish();
                com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2010040));
            }
        }
        return false;
    }

    private static String a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = str2.length() + indexOf;
            int i = length;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            return URLDecoder.decode(str.substring(length, i));
        }
        return "";
    }
}
