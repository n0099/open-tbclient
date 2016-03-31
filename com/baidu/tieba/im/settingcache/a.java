package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.q;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> cqc = new HashMap<>();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.g<Void> gVar);

    protected abstract o<String> aij();

    public abstract com.baidu.tieba.im.pushNotify.a bb(String str, String str2);

    public void o(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.cqc) {
            this.cqc.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.cqc) {
                o<String> aij = aij();
                List<o.b<String>> b = s.b(aij);
                if (b != null) {
                    for (o.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = aij.get(str4)) != null) {
                            this.cqc.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void f(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a bb = bb(str, str2);
        if (bb != null) {
            bb.setAcceptNotify(z);
            a(bb);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.g<Void> gVar) {
        com.baidu.tieba.im.pushNotify.a bb = bb(str, str2);
        if (bb != null) {
            bb.setAcceptNotify(z);
            a(bb, gVar);
        }
    }

    public boolean bc(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a bb = bb(str, str2);
        if (bb == null) {
            return false;
        }
        return bb.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.g<Boolean> gVar) {
        q.b(new b(this, str, str2), gVar);
    }
}
