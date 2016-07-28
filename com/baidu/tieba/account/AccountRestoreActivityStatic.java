package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
/* loaded from: classes.dex */
public class AccountRestoreActivityStatic {
    static {
        TbadkCoreApplication.m10getInst().RegisterIntent(AccountRestoreActivityConfig.class, AccountRestoreActivity.class);
    }
}
