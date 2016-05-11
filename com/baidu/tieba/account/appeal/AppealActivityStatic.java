package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
/* loaded from: classes.dex */
public class AppealActivityStatic {
    static {
        AppealActivityConfig.isExistActivity = true;
        TbadkCoreApplication.m11getInst().RegisterIntent(AppealActivityConfig.class, AppealActivity.class);
    }
}
