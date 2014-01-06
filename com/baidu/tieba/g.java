package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        com.baidu.tieba.util.bo.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str == null || !str.equals(TiebaApplication.G())) && TiebaApplication.F() != null) {
            f.b(TiebaApplication.A());
            AccountData F = TiebaApplication.F();
            if (F != null) {
                F.setPortrait(null);
                F.setAccount(str);
                F.setID(null);
                F.setIsActive(1);
                TiebaApplication.l((String) null);
            }
            com.baidu.tieba.mention.s.a().a(true);
            TiebaApplication.g().O();
            if (str == null || str.equals("BaiduUser")) {
                TiebaApplication.g().b(0);
            }
        }
    }
}
