package com.baidu.tieba;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.c.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements BaiduAccount.BaiduOnAccountsUpdateListener {
    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
    public void onAccountsUpdated(String str) {
        ae.c(getClass().getName(), "onAccountsUpdated", "account =" + str);
        if ((str == null || !str.equals(TiebaApplication.x())) && TiebaApplication.w() != null) {
            a.b(TiebaApplication.u());
            com.baidu.tieba.a.a w = TiebaApplication.w();
            if (w != null) {
                w.d(null);
                w.b(str);
                w.a((String) null);
                w.a(1);
            }
            TiebaApplication.a().a(0L, 0L, 0L);
            TiebaApplication.a().H();
            if (str == null || str.equals("BaiduUser")) {
                TiebaApplication.a().d(0);
            }
        }
    }
}
