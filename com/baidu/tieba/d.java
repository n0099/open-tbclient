package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        com.baidu.tieba.util.aj.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str != null && str.equals(TiebaApplication.I())) || TiebaApplication.H() == null) {
            return;
        }
        c.b(TiebaApplication.E());
        AccountData H = TiebaApplication.H();
        if (H != null) {
            H.setBDUSS(null);
            H.setAccount(str);
            H.setID(null);
            H.setIsActive(1);
        }
        TiebaApplication.f().a(0L, 0L, 0L, 0L);
        TiebaApplication.f().T();
        if (str == null || str.equals("BaiduUser")) {
            TiebaApplication.f().d(0);
        }
    }
}
