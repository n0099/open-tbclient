package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.u;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> cZk = new HashMap<>();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.g<Void> gVar);

    protected abstract o<String> ars();

    public abstract com.baidu.tieba.im.pushNotify.a bg(String str, String str2);

    public void v(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.cZk) {
            this.cZk.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.cZk) {
                o<String> ars = ars();
                List<o.c<String>> b = s.b(ars);
                if (b != null) {
                    for (o.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = ars.get(str4)) != null) {
                            this.cZk.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void g(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a bg = bg(str, str2);
        if (bg != null) {
            bg.setAcceptNotify(z);
            a(bg);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.g<Void> gVar) {
        com.baidu.tieba.im.pushNotify.a bg = bg(str, str2);
        if (bg != null) {
            bg.setAcceptNotify(z);
            a(bg, gVar);
        }
    }

    public boolean bh(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a bg = bg(str, str2);
        if (bg == null) {
            return false;
        }
        return bg.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.g<Boolean> gVar) {
        u.b(new b(this, str, str2), gVar);
    }
}
