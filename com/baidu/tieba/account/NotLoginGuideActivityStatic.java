package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
/* loaded from: classes.dex */
public class NotLoginGuideActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(NotLoginGuideActivityConfig.class, NotLoginGuideActivity.class);
    }
}
