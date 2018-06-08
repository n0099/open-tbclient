package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
/* loaded from: classes.dex */
public class LogoActivityStatic {
    private static b bgw;

    static {
        TbadkCoreApplication.getInst().RegisterIntent(LogoActivityConfig.class, LogoActivity.class);
        bgw = b.Od();
    }
}
