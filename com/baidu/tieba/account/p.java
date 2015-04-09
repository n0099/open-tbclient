package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.core.a.a {
    private static p auQ = null;
    private u auR = null;
    private final com.baidu.tbadk.core.a.b auS = new q(this);
    private final com.baidu.tieba.a.b auT = new s(this);
    private Activity mActivity;

    private p() {
    }

    public static p Ep() {
        if (auQ == null) {
            auQ = new p();
        }
        return auQ;
    }

    @Override // com.baidu.tbadk.core.a.a
    public com.baidu.tbadk.core.a.c bN(String str) {
        com.baidu.tbadk.core.a.c cVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    cVar = new com.baidu.tbadk.core.a.c();
                    try {
                        cVar.xh = split[0];
                        if (split.length >= 2) {
                            cVar.OF = split[1];
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
    public void p(Activity activity) {
        com.baidu.tbadk.core.a.c bN;
        if (com.baidu.adp.lib.util.k.iH()) {
            this.mActivity = activity;
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null && (bN = bN(currentAccountObj.getBDUSS())) != null) {
                com.baidu.tieba.a.d.a(currentAccountObj.getAccount(), bN.xh, bN.OF, this.auS);
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
