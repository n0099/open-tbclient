package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.cache.t;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.r;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class m {
    protected HashMap<String, l> a = new HashMap<>();

    public abstract void a(l lVar);

    public abstract l b(String str, String str2);

    protected abstract s<String> c();

    public final void a(Class<? extends l> cls) {
        String a;
        synchronized (this.a) {
            this.a.clear();
        }
        String str = "";
        if (TbadkApplication.N() != null) {
            str = TbadkApplication.N().getID();
        }
        if (str != null && str.length() != 0) {
            String str2 = String.valueOf(str) + "@";
            synchronized (this.a) {
                s<String> c = c();
                List<t<String>> a2 = com.baidu.adp.lib.util.l.a(c);
                if (a2 != null) {
                    for (t<String> tVar : a2) {
                        String str3 = tVar.a;
                        if (str3 != null && str3.startsWith(str2) && (a = c.a(str3)) != null) {
                            this.a.put(str3, (l) new Gson().fromJson(a, (Class<Object>) cls));
                        }
                    }
                }
            }
        }
    }

    public final void d(String str, String str2, boolean z) {
        l b = b(str, str2);
        if (b != null) {
            b.setAcceptNotify(z);
            a(b);
        }
    }

    public final boolean d(String str, String str2) {
        l b = b(str, str2);
        if (b == null) {
            return false;
        }
        return b.isAcceptNotify();
    }

    public final void a(String str, String str2, com.baidu.tieba.im.a<Boolean> aVar) {
        r.a(new n(this, str, str2), aVar);
    }
}
