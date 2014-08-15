package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.cache.v;
import com.baidu.adp.lib.util.o;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected HashMap<String, a> a = new HashMap<>();

    public abstract void a(a aVar);

    public abstract a b(String str, String str2);

    protected abstract t<String> c();

    public void a(Class<? extends a> cls) {
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
                t<String> c = c();
                List<v<String>> a2 = o.a(c);
                if (a2 != null) {
                    for (v<String> vVar : a2) {
                        String str3 = vVar.a;
                        if (str3 != null && str3.startsWith(str2) && (a = c.a(str3)) != null) {
                            this.a.put(str3, (a) new Gson().fromJson(a, (Class<Object>) cls));
                        }
                    }
                }
            }
        }
    }

    public void a(String str, String str2, boolean z) {
        a b = b(str, str2);
        if (b != null) {
            b.setAcceptNotify(z);
            a(b);
        }
    }

    public boolean c(String str, String str2) {
        a b = b(str, str2);
        if (b == null) {
            return false;
        }
        return b.isAcceptNotify();
    }

    public void b(String str, String str2, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.e.a(new c(this, str, str2), aVar);
    }
}
