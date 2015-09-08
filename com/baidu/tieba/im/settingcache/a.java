package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> bEj = new HashMap<>();

    protected abstract o<String> Ww();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tieba.im.g<Void> gVar);

    public abstract com.baidu.tieba.im.pushNotify.a aL(String str, String str2);

    public void l(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.bEj) {
            this.bEj.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.bEj) {
                o<String> Ww = Ww();
                List<o.b<String>> b = s.b(Ww);
                if (b != null) {
                    for (o.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = Ww.get(str4)) != null) {
                            this.bEj.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void e(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a aL = aL(str, str2);
        if (aL != null) {
            aL.setAcceptNotify(z);
            a(aL);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tieba.im.g<Void> gVar) {
        com.baidu.tieba.im.pushNotify.a aL = aL(str, str2);
        if (aL != null) {
            aL.setAcceptNotify(z);
            a(aL, gVar);
        }
    }

    public boolean aM(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a aL = aL(str, str2);
        if (aL == null) {
            return false;
        }
        return aL.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tieba.im.g<Boolean> gVar) {
        com.baidu.tieba.im.l.a(new b(this, str, str2), gVar);
    }
}
