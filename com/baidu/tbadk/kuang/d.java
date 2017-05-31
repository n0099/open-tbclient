package com.baidu.tbadk.kuang;

import android.text.TextUtils;
import com.baidu.adp.base.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0035a {
    private final /* synthetic */ boolean aDo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(boolean z) {
        this.aDo = z;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void cf(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void a(AccountData accountData) {
        if (TextUtils.isEmpty(accountData.getAccount())) {
            if (this.aDo) {
                if (k.Z(com.baidu.adp.base.a.ca().cb()) != null) {
                    a.a((TbPageContext) k.Z(com.baidu.adp.base.a.ca().cb()), accountData);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m9getInst().setIsKuangLogin(true);
            com.baidu.tbadk.core.a.b.b(null);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp());
            a.c(new ReLoginFromKuangMessage(false));
            return;
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        com.baidu.tbadk.core.a.b.c(accountData);
        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
        TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp());
        a.c(new ReLoginFromKuangMessage(true));
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void b(String str, int i, String str2) {
        com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m9getInst().getApp(), str2);
        a.c(new ReLoginFromKuangMessage(false));
    }
}
