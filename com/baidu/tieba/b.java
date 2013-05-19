package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        com.baidu.tieba.d.ae.e(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str != null && str.equals(TiebaApplication.D())) || TiebaApplication.C() == null) {
            return;
        }
        a.b(TiebaApplication.z());
        com.baidu.tieba.a.a C = TiebaApplication.C();
        if (C != null) {
            C.d(null);
            C.b(str);
            C.a((String) null);
            C.a(1);
        }
        TiebaApplication.d().a(0L, 0L, 0L);
        TiebaApplication.d().O();
        if (str == null || str.equals("BaiduUser")) {
            TiebaApplication.d().d(0);
        }
    }
}
