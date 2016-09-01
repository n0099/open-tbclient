package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.u;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> dkT = new HashMap<>();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.g<Void> gVar);

    protected abstract o<String> awg();

    public abstract com.baidu.tieba.im.pushNotify.a bh(String str, String str2);

    public void v(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.dkT) {
            this.dkT.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.dkT) {
                o<String> awg = awg();
                List<o.c<String>> b = s.b(awg);
                if (b != null) {
                    for (o.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = awg.get(str4)) != null) {
                            this.dkT.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void f(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a bh = bh(str, str2);
        if (bh != null) {
            bh.setAcceptNotify(z);
            a(bh);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.g<Void> gVar) {
        com.baidu.tieba.im.pushNotify.a bh = bh(str, str2);
        if (bh != null) {
            bh.setAcceptNotify(z);
            a(bh, gVar);
        }
    }

    public boolean bi(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a bh = bh(str, str2);
        if (bh == null) {
            return false;
        }
        return bh.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.g<Boolean> gVar) {
        u.b(new b(this, str, str2), gVar);
    }
}
