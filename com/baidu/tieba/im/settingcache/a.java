package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> dsa = new HashMap<>();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.f<Void> fVar);

    protected abstract o<String> ayC();

    public abstract com.baidu.tieba.im.pushNotify.a bj(String str, String str2);

    public void v(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.dsa) {
            this.dsa.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.dsa) {
                o<String> ayC = ayC();
                List<o.c<String>> b = s.b(ayC);
                if (b != null) {
                    for (o.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = ayC.get(str4)) != null) {
                            this.dsa.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void f(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a bj = bj(str, str2);
        if (bj != null) {
            bj.setAcceptNotify(z);
            a(bj);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.f<Void> fVar) {
        com.baidu.tieba.im.pushNotify.a bj = bj(str, str2);
        if (bj != null) {
            bj.setAcceptNotify(z);
            a(bj, fVar);
        }
    }

    public boolean bk(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a bj = bj(str, str2);
        if (bj == null) {
            return false;
        }
        return bj.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.f<Boolean> fVar) {
        t.b(new b(this, str, str2), fVar);
    }
}
