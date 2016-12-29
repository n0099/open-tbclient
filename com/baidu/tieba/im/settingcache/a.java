package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> cWU = new HashMap<>();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.f<Void> fVar);

    protected abstract o<String> atb();

    public abstract com.baidu.tieba.im.pushNotify.a bf(String str, String str2);

    public void v(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.cWU) {
            this.cWU.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.cWU) {
                o<String> atb = atb();
                List<o.c<String>> b = s.b(atb);
                if (b != null) {
                    for (o.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = atb.get(str4)) != null) {
                            this.cWU.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void f(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a bf = bf(str, str2);
        if (bf != null) {
            bf.setAcceptNotify(z);
            a(bf);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.f<Void> fVar) {
        com.baidu.tieba.im.pushNotify.a bf = bf(str, str2);
        if (bf != null) {
            bf.setAcceptNotify(z);
            a(bf, fVar);
        }
    }

    public boolean bg(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a bf = bf(str, str2);
        if (bf == null) {
            return false;
        }
        return bf.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.f<Boolean> fVar) {
        t.b(new b(this, str, str2), fVar);
    }
}
