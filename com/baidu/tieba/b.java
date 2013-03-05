package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.c.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        ag.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str != null && str.equals(TiebaApplication.B())) || TiebaApplication.A() == null) {
            return;
        }
        a.b(TiebaApplication.x());
        com.baidu.tieba.a.a A = TiebaApplication.A();
        if (A != null) {
            A.d(null);
            A.b(str);
            A.a((String) null);
            A.a(1);
        }
        TiebaApplication.b().a(0L, 0L, 0L);
        TiebaApplication.b().M();
        if (str == null || str.equals("BaiduUser")) {
            TiebaApplication.b().d(0);
        }
    }
}
