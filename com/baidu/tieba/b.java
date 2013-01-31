package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.c.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        af.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str != null && str.equals(TiebaApplication.A())) || TiebaApplication.z() == null) {
            return;
        }
        a.b(TiebaApplication.w());
        com.baidu.tieba.a.a z = TiebaApplication.z();
        if (z != null) {
            z.d(null);
            z.b(str);
            z.a((String) null);
            z.a(1);
        }
        TiebaApplication.b().a(0L, 0L, 0L);
        TiebaApplication.b().L();
        if (str == null || str.equals("BaiduUser")) {
            TiebaApplication.b().d(0);
        }
    }
}
