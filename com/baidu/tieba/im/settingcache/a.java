package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.cache.v;
import com.baidu.adp.lib.util.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, com.baidu.tieba.im.pushNotify.a> bnz = new HashMap<>();

    protected abstract t<String> SU();

    public abstract void a(com.baidu.tieba.im.pushNotify.a aVar);

    public abstract com.baidu.tieba.im.pushNotify.a aD(String str, String str2);

    public void s(Class<? extends com.baidu.tieba.im.pushNotify.a> cls) {
        String str;
        synchronized (this.bnz) {
            this.bnz.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.bnz) {
                t<String> SU = SU();
                List<v<String>> b = x.b(SU);
                if (b != null) {
                    for (v<String> vVar : b) {
                        String str4 = vVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = SU.get(str4)) != null) {
                            this.bnz.put(str4, (com.baidu.tieba.im.pushNotify.a) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void f(String str, String str2, boolean z) {
        com.baidu.tieba.im.pushNotify.a aD = aD(str, str2);
        if (aD != null) {
            aD.setAcceptNotify(z);
            a(aD);
        }
    }

    public boolean aE(String str, String str2) {
        com.baidu.tieba.im.pushNotify.a aD = aD(str, str2);
        if (aD == null) {
            return false;
        }
        return aD.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tieba.im.g<Boolean> gVar) {
        com.baidu.tieba.im.i.a(new b(this, str, str2), gVar);
    }
}
