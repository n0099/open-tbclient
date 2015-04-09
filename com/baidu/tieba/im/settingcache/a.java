package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.cache.v;
import com.baidu.adp.lib.util.z;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> bnj = new HashMap<>();

    protected abstract t<String> Tz();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tieba.im.g<Void> gVar);

    public abstract com.baidu.tieba.im.pushNotify.a aE(String str, String str2);

    public void s(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.bnj) {
            this.bnj.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.bnj) {
                t<String> Tz = Tz();
                List<v<String>> b = z.b(Tz);
                if (b != null) {
                    for (v<String> vVar : b) {
                        String str4 = vVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = Tz.get(str4)) != null) {
                            this.bnj.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void e(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a aE = aE(str, str2);
        if (aE != null) {
            aE.setAcceptNotify(z);
            a(aE);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tieba.im.g<Void> gVar) {
        com.baidu.tieba.im.pushNotify.a aE = aE(str, str2);
        if (aE != null) {
            aE.setAcceptNotify(z);
            a(aE, gVar);
        }
    }

    public boolean aF(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a aE = aE(str, str2);
        if (aE == null) {
            return false;
        }
        return aE.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tieba.im.g<Boolean> gVar) {
        com.baidu.tieba.im.l.a(new b(this, str, str2), gVar);
    }
}
