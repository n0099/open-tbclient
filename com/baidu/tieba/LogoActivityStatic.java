package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
/* loaded from: classes.dex */
public class LogoActivityStatic {
    static {
        TbadkCoreApplication.m10getInst().RegisterIntent(LogoActivityConfig.class, LogoActivity.class);
    }
}
