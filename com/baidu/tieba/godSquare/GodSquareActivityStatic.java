package com.baidu.tieba.godSquare;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GodSquareActivityConfig;
/* loaded from: classes.dex */
public class GodSquareActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(GodSquareActivityConfig.class, GodSquareActivity.class);
    }
}
