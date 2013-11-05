package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        be.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str == null || !str.equals(TiebaApplication.H())) && TiebaApplication.G() != null) {
            f.b(TiebaApplication.C());
            AccountData G = TiebaApplication.G();
            if (G != null) {
                G.setPortrait(null);
                G.setAccount(str);
                G.setID(null);
                G.setIsActive(1);
                TiebaApplication.k((String) null);
            }
            com.baidu.tieba.mention.t.a().a(true);
            TiebaApplication.g().S();
            if (str == null || str.equals("BaiduUser")) {
                TiebaApplication.g().d(0);
            }
        }
    }
}
