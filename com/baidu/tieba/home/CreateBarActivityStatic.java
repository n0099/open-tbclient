package com.baidu.tieba.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
/* loaded from: classes.dex */
public class CreateBarActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(CreateBarActivityConfig.class, CreateBarActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(CreateBarGuideActivityConfig.class, CreateBarGuideActivity.class);
    }
}
