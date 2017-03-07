package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
/* loaded from: classes.dex */
public class LogoActivityStatic {
    private static b aPV;

    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(LogoActivityConfig.class, LogoActivity.class);
        aPV = b.IM();
    }
}
