package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.cache.v;
import com.baidu.adp.lib.util.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> boV = new HashMap<>();

    protected abstract t<String> Tl();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tieba.im.g<Void> gVar);

    public abstract com.baidu.tieba.im.pushNotify.a aG(String str, String str2);

    public void s(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.boV) {
            this.boV.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.boV) {
                t<String> Tl = Tl();
                List<v<String>> b = x.b(Tl);
                if (b != null) {
                    for (v<String> vVar : b) {
                        String str4 = vVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = Tl.get(str4)) != null) {
                            this.boV.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void f(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a aG = aG(str, str2);
        if (aG != null) {
            aG.setAcceptNotify(z);
            a(aG);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tieba.im.g<Void> gVar) {
        com.baidu.tieba.im.pushNotify.a aG = aG(str, str2);
        if (aG != null) {
            aG.setAcceptNotify(z);
            a(aG, gVar);
        }
    }

    public boolean aH(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a aG = aG(str, str2);
        if (aG == null) {
            return false;
        }
        return aG.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tieba.im.g<Boolean> gVar) {
        com.baidu.tieba.im.i.a(new b(this, str, str2), gVar);
    }
}
