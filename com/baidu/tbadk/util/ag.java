package com.baidu.tbadk.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewGodInfo;
/* loaded from: classes.dex */
public class ag {
    public static String a(NewGodInfo newGodInfo) {
        return lx(newGodInfo != null && newGodInfo.type.intValue() == 2);
    }

    public static String rA(int i) {
        return lx(i == 2);
    }

    public static String lx(boolean z) {
        return z ? TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_video_god) : TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
    }
}
