package com.baidu.tieba.account;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.a.a;
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.core.a.a {
    private static k aFs = null;
    private a aFt = null;
    private final a.InterfaceC0040a aFu = new l(this);
    private final a.InterfaceC0055a aFv = new n(this);

    /* loaded from: classes.dex */
    public interface a {
        void cc(String str);

        void onSuccess();
    }

    private k() {
    }

    public static k Gc() {
        if (aFs == null) {
            aFs = new k();
        }
        return aFs;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b cb(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.wr = split[0];
                        if (split.length >= 2) {
                            bVar.TR = split[1];
                            return bVar;
                        }
                        return bVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return bVar;
                    }
                }
            } catch (Exception e3) {
                bVar = null;
                e = e3;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.a.a
    public void ri() {
        AccountData currentAccountObj;
        a.b cb;
        if (com.baidu.adp.lib.util.i.iL() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (cb = cb(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.a.b.a(currentAccountObj.getAccount(), cb.wr, cb.TR, this.aFu);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public void a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a) {
        com.baidu.tieba.a.b.a(str, str2, str3, interfaceC0040a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData k(String str, String str2, String str3) {
        return com.baidu.tieba.a.b.k(str, str2, str3);
    }
}
