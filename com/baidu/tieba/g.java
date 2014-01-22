package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        com.baidu.adp.lib.g.e.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str == null || !str.equals(TiebaApplication.F())) && TiebaApplication.E() != null) {
            f.b(TiebaApplication.A());
            AccountData E = TiebaApplication.E();
            if (E != null) {
                E.setPortrait(null);
                E.setAccount(str);
                E.setID(null);
                E.setIsActive(1);
                TiebaApplication.k((String) null);
            }
            com.baidu.tieba.mention.s.a().a(true);
            TiebaApplication.h().N();
            if (str == null || str.equals("BaiduUser")) {
                TiebaApplication.h().b(0);
            }
        }
    }
}
