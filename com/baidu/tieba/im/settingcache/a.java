package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.u;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> dmq = new HashMap<>();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.g<Void> gVar);

    protected abstract o<String> awF();

    public abstract com.baidu.tieba.im.pushNotify.a bj(String str, String str2);

    public void v(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.dmq) {
            this.dmq.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.dmq) {
                o<String> awF = awF();
                List<o.c<String>> b = s.b(awF);
                if (b != null) {
                    for (o.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = awF.get(str4)) != null) {
                            this.dmq.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
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

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.g<Void> gVar) {
        com.baidu.tieba.im.pushNotify.a bj = bj(str, str2);
        if (bj != null) {
            bj.setAcceptNotify(z);
            a(bj, gVar);
        }
    }

    public boolean bk(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a bj = bj(str, str2);
        if (bj == null) {
            return false;
        }
        return bj.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.g<Boolean> gVar) {
        u.b(new b(this, str, str2), gVar);
    }
}
