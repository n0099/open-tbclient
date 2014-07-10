package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.cache.u;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class o {
    protected HashMap<String, n> a = new HashMap<>();

    public abstract void a(n nVar);

    public abstract n b(String str, String str2);

    protected abstract s<String> c();

    public void a(Class<? extends n> cls) {
        String a;
        synchronized (this.a) {
            this.a.clear();
        }
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        if (str != null && str.length() != 0) {
            String str2 = String.valueOf(str) + "@";
            synchronized (this.a) {
                s<String> c = c();
                List<u<String>> a2 = com.baidu.adp.lib.util.o.a(c);
                if (a2 != null) {
                    for (u<String> uVar : a2) {
                        String str3 = uVar.a;
                        if (str3 != null && str3.startsWith(str2) && (a = c.a(str3)) != null) {
                            this.a.put(str3, (n) new Gson().fromJson(a, (Class<Object>) cls));
                        }
                    }
                }
            }
        }
    }

    public void d(String str, String str2, boolean z) {
        n b = b(str, str2);
        if (b != null) {
            b.setAcceptNotify(z);
            a(b);
        }
    }

    public boolean d(String str, String str2) {
        n b = b(str, str2);
        if (b == null) {
            return false;
        }
        return b.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.i.a(new p(this, str, str2), aVar);
    }
}
