package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        com.baidu.tieba.c.ag.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str != null && str.equals(TiebaApplication.C())) || TiebaApplication.B() == null) {
            return;
        }
        a.b(TiebaApplication.y());
        com.baidu.tieba.a.a B = TiebaApplication.B();
        if (B != null) {
            B.d(null);
            B.b(str);
            B.a((String) null);
            B.a(1);
        }
        TiebaApplication.b().a(0L, 0L, 0L);
        TiebaApplication.b().N();
        if (str == null || str.equals("BaiduUser")) {
            TiebaApplication.b().d(0);
        }
    }
}
