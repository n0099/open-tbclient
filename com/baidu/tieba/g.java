package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        com.baidu.tieba.util.bd.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str == null || !str.equals(TiebaApplication.G())) && TiebaApplication.F() != null) {
            f.b(TiebaApplication.B());
            AccountData F = TiebaApplication.F();
            if (F != null) {
                F.setPortrait(null);
                F.setAccount(str);
                F.setID(null);
                F.setIsActive(1);
                TiebaApplication.l((String) null);
            }
            com.baidu.tieba.mention.t.a().a(true);
            TiebaApplication.h().O();
            if (str == null || str.equals("BaiduUser")) {
                TiebaApplication.h().b(0);
            }
        }
    }
}
