package com.baidu.tbadk.kuang;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* loaded from: classes.dex */
class b implements j.a {
    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void j(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        com.baidu.tbadk.core.a.b.c(accountData);
        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
        TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp());
        a.c(new ReLoginFromKuangMessage(true));
    }
}
