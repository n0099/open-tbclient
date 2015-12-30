package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.n;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> caX = new HashMap<>();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.d<Void> dVar);

    public abstract com.baidu.tieba.im.pushNotify.a aJ(String str, String str2);

    protected abstract o<String> abK();

    public void l(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.caX) {
            this.caX.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.caX) {
                o<String> abK = abK();
                List<o.b<String>> b = s.b(abK);
                if (b != null) {
                    for (o.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = abK.get(str4)) != null) {
                            this.caX.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void e(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a aJ = aJ(str, str2);
        if (aJ != null) {
            aJ.setAcceptNotify(z);
            a(aJ);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.d<Void> dVar) {
        com.baidu.tieba.im.pushNotify.a aJ = aJ(str, str2);
        if (aJ != null) {
            aJ.setAcceptNotify(z);
            a(aJ, dVar);
        }
    }

    public boolean aK(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a aJ = aJ(str, str2);
        if (aJ == null) {
            return false;
        }
        return aJ.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.d<Boolean> dVar) {
        n.b(new b(this, str, str2), dVar);
    }
}
