package com.baidu.tbadk.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewGodInfo;
/* loaded from: classes.dex */
public class aj {
    public static String a(NewGodInfo newGodInfo) {
        return lA(newGodInfo != null && newGodInfo.type.intValue() == 2);
    }

    public static String rF(int i) {
        return lA(i == 2);
    }

    public static String lA(boolean z) {
        return z ? TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_video_god) : TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
    }
}
