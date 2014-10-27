package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.cache.v;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    protected HashMap<String, a> bhi = new HashMap<>();

    protected abstract t<String> KC();

    public abstract void a(a aVar);

    public abstract a am(String str, String str2);

    public void h(Class<? extends a> cls) {
        String str;
        synchronized (this.bhi) {
            this.bhi.clear();
        }
        String str2 = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str2 = TbadkApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.bhi) {
                t<String> KC = KC();
                List<v<String>> b = s.b(KC);
                if (b != null) {
                    for (v<String> vVar : b) {
                        String str4 = vVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = KC.get(str4)) != null) {
                            this.bhi.put(str4, (a) i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void e(String str, String str2, boolean z) {
        a am = am(str, str2);
        if (am != null) {
            am.setAcceptNotify(z);
            a(am);
        }
    }

    public boolean av(String str, String str2) {
        a am = am(str, str2);
        if (am == null) {
            return false;
        }
        return am.isAcceptNotify();
    }

    public void b(String str, String str2, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.e.a(new c(this, str, str2), aVar);
    }
}
