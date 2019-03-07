package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.SecretHintActivityConfig;
/* loaded from: classes.dex */
public class LogoActivityStatic {
    private static b cIt;

    static {
        TbadkCoreApplication.getInst().RegisterIntent(LogoActivityConfig.class, LogoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SecretHintActivityConfig.class, SecretHintActivity.class);
        cIt = b.aub();
    }
}
