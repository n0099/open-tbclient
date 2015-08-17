package com.baidu.tbadk.kuang;

import android.text.TextUtils;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0040a {
    private final /* synthetic */ boolean aun;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(boolean z) {
        this.aun = z;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cb(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        if (TextUtils.isEmpty(accountData.getAccount())) {
            if (this.aun) {
                if (l.C(com.baidu.adp.base.a.dF().dG()) != null) {
                    b.a((TbPageContext) l.C(com.baidu.adp.base.a.dF().dG()), accountData);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setIsKuangLogin(true);
            com.baidu.tbadk.core.a.b.b(null);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp());
            b.c(new ReLoginFromKuangMessage(false));
            return;
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        com.baidu.tbadk.core.a.b.c(accountData);
        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
        TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp());
        b.c(new ReLoginFromKuangMessage(true));
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        k.showToast(TbadkCoreApplication.m411getInst().getApp(), str2);
        b.c(new ReLoginFromKuangMessage(false));
    }
}
