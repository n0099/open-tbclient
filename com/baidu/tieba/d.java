package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        com.baidu.tieba.util.z.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str != null && str.equals(TiebaApplication.H())) || TiebaApplication.G() == null) {
            return;
        }
        c.b(TiebaApplication.E());
        AccountData G = TiebaApplication.G();
        if (G != null) {
            G.setBDUSS(null);
            G.setAccount(str);
            G.setID(null);
            G.setIsActive(1);
        }
        TiebaApplication.f().a(0L, 0L, 0L, 0L);
        TiebaApplication.f().S();
        if (str == null || str.equals("BaiduUser")) {
            TiebaApplication.f().f(0);
        }
    }
}
