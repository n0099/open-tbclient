package com.baidu.tbadk.vcode;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
/* loaded from: classes.dex */
public class CommonVcodeActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(CommonVcodeActivityConfig.class, CommonVcodeActivity.class);
    }
}
