package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
/* loaded from: classes.dex */
public class SapiFastRegActivityStatic {
    static {
        com.baidu.tbadk.coreExtra.act.b.checkPassV6Switch();
        if (!com.baidu.tbadk.coreExtra.act.b.wa()) {
            TbadkCoreApplication.m411getInst().RegisterOrUpdateIntent(RegisterActivityConfig.class, SapiFastRegActivity.class);
        }
    }
}
