package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        com.baidu.tieba.d.ae.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str != null && str.equals(TiebaApplication.G())) || TiebaApplication.F() == null) {
            return;
        }
        a.b(TiebaApplication.C());
        com.baidu.tieba.a.a F = TiebaApplication.F();
        if (F != null) {
            F.d(null);
            F.b(str);
            F.a((String) null);
            F.a(1);
        }
        TiebaApplication.e().a(0L, 0L, 0L, 0L);
        TiebaApplication.e().R();
        if (str == null || str.equals("BaiduUser")) {
            TiebaApplication.e().f(0);
        }
    }
}
