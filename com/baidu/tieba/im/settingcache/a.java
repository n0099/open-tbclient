package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.n;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> bWY = new HashMap<>();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.d<Void> dVar);

    public abstract com.baidu.tieba.im.pushNotify.a aO(String str, String str2);

    protected abstract o<String> aaC();

    public void m(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.bWY) {
            this.bWY.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.bWY) {
                o<String> aaC = aaC();
                List<o.b<String>> b = s.b(aaC);
                if (b != null) {
                    for (o.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = aaC.get(str4)) != null) {
                            this.bWY.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void e(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a aO = aO(str, str2);
        if (aO != null) {
            aO.setAcceptNotify(z);
            a(aO);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.d<Void> dVar) {
        com.baidu.tieba.im.pushNotify.a aO = aO(str, str2);
        if (aO != null) {
            aO.setAcceptNotify(z);
            a(aO, dVar);
        }
    }

    public boolean aP(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a aO = aO(str, str2);
        if (aO == null) {
            return false;
        }
        return aO.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.d<Boolean> dVar) {
        n.b(new b(this, str, str2), dVar);
    }
}
