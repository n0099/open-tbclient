package com.baidu.tbadk.system.portrait;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
/* loaded from: classes.dex */
public class ChangeSystemPhotoStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(ChangeSystemPhotoActivityConfig.class, ChangeSystemPhotoActivity.class);
    }
}
