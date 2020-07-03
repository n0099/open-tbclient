package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
/* loaded from: classes.dex */
public class LogoActivityStatic {
    private static c eTw;

    static {
        TbadkCoreApplication.getInst().RegisterIntent(LogoActivityConfig.class, LogoActivity.class);
        eTw = c.bmq();
    }
}
