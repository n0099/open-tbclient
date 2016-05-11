package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
/* loaded from: classes.dex */
public class FrsMoreFeedForumsActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(FrsMoreFeedForumsConfig.class, FrsMoreFeedForumsActivity.class);
    }
}
