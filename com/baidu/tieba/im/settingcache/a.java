package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> bHx = new HashMap<>();

    protected abstract o<String> Xb();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.d<Void> dVar);

    public abstract com.baidu.tieba.im.pushNotify.a aK(String str, String str2);

    public void l(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.bHx) {
            this.bHx.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.bHx) {
                o<String> Xb = Xb();
                List<o.b<String>> b = s.b(Xb);
                if (b != null) {
                    for (o.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = Xb.get(str4)) != null) {
                            this.bHx.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void e(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a aK = aK(str, str2);
        if (aK != null) {
            aK.setAcceptNotify(z);
            a(aK);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.d<Void> dVar) {
        com.baidu.tieba.im.pushNotify.a aK = aK(str, str2);
        if (aK != null) {
            aK.setAcceptNotify(z);
            a(aK, dVar);
        }
    }

    public boolean aL(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a aK = aK(str, str2);
        if (aK == null) {
            return false;
        }
        return aK.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.d<Boolean> dVar) {
        m.b(new b(this, str, str2), dVar);
    }
}
