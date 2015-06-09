package com.baidu.tieba.account;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.core.a.a {
    private static p awt = null;
    private u awu = null;
    private final com.baidu.tbadk.core.a.b awv = new q(this);
    private final com.baidu.tieba.a.b aww = new s(this);

    private p() {
    }

    public static p Fd() {
        if (awt == null) {
            awt = new p();
        }
        return awt;
    }

    @Override // com.baidu.tbadk.core.a.a
    public com.baidu.tbadk.core.a.c ca(String str) {
        com.baidu.tbadk.core.a.c cVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    cVar = new com.baidu.tbadk.core.a.c();
                    try {
                        cVar.wk = split[0];
                        if (split.length >= 2) {
                            cVar.Pc = split[1];
                            return cVar;
                        }
                        return cVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return cVar;
                    }
                }
            } catch (Exception e3) {
                cVar = null;
                e = e3;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.a.a
    public void qj() {
        AccountData currentAccountObj;
        if (com.baidu.adp.lib.util.k.iX() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null) {
            currentAccountObj.logPrint();
            com.baidu.tbadk.core.a.c ca = ca(currentAccountObj.getBDUSS());
            if (ca != null) {
                com.baidu.tieba.a.d.a(currentAccountObj.getAccount(), ca.wk, ca.Pc, this.awv);
            }
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public void a(String str, String str2, String str3, com.baidu.tbadk.core.a.b bVar) {
        com.baidu.tieba.a.d.a(str, str2, str3, bVar);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData h(String str, String str2, String str3) {
        return com.baidu.tieba.a.d.h(str, str2, str3);
    }
}
