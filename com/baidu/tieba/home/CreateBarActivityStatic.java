package com.baidu.tieba.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.CreateForumActivityConfig;
import com.baidu.tbadk.core.atomData.CreateForumSuccessActivityConfig;
/* loaded from: classes6.dex */
public class CreateBarActivityStatic {
    static {
        CreateBarActivityConfig.IS_SUPPORT_CREATE_BAR = true;
        TbadkCoreApplication.getInst().RegisterIntent(CreateBarActivityConfig.class, CreateBarActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(CreateBarGuideActivityConfig.class, CreateBarGuideActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(CreateForumActivityConfig.class, CreateForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(CreateForumSuccessActivityConfig.class, CreateForumSuccessActivity.class);
    }
}
