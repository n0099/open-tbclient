package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
/* loaded from: classes.dex */
public class UpdateDialogStatic {
    static {
        TbadkCoreApplication.m10getInst().RegisterIntent(UpdateDialogConfig.class, UpdateDialog.class);
    }
}
