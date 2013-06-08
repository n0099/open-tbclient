package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        com.baidu.tieba.d.ae.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str != null && str.equals(TiebaApplication.F())) || TiebaApplication.E() == null) {
            return;
        }
        a.b(TiebaApplication.B());
        com.baidu.tieba.a.a E = TiebaApplication.E();
        if (E != null) {
            E.d(null);
            E.b(str);
            E.a((String) null);
            E.a(1);
        }
        TiebaApplication.d().a(0L, 0L, 0L, 0L);
        TiebaApplication.d().Q();
        if (str == null || str.equals("BaiduUser")) {
            TiebaApplication.d().f(0);
        }
    }
}
