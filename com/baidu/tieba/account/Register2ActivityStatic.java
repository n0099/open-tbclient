package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
/* loaded from: classes.dex */
public class Register2ActivityStatic {
    static {
        if (TbadkCoreApplication.m411getInst().getIntentClass(RegisterActivityConfig.class) == null || com.baidu.tbadk.coreExtra.act.a.uW()) {
            TbadkCoreApplication.m411getInst().RegisterOrUpdateIntent(RegisterActivityConfig.class, Register2Activity.class);
        }
    }
}
