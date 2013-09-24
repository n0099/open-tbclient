package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        com.baidu.tieba.util.av.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str != null && str.equals(TiebaApplication.G())) || TiebaApplication.F() == null) {
            return;
        }
        f.b(TiebaApplication.C());
        AccountData F = TiebaApplication.F();
        if (F != null) {
            F.setBDUSS(null);
            F.setAccount(str);
            F.setID(null);
            F.setIsActive(1);
        }
        com.baidu.tieba.mention.s.a().a(true);
        TiebaApplication.g().R();
        if (str == null || str.equals("BaiduUser")) {
            TiebaApplication.g().d(0);
        }
    }
}
