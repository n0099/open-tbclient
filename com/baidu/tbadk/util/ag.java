package com.baidu.tbadk.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewGodInfo;
/* loaded from: classes.dex */
public class ag {
    public static String a(NewGodInfo newGodInfo) {
        return lB(newGodInfo != null && newGodInfo.type.intValue() == 2);
    }

    public static String tg(int i) {
        return lB(i == 2);
    }

    public static String lB(boolean z) {
        return z ? TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_video_god) : TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
    }
}
