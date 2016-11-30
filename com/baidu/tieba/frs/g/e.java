package com.baidu.tieba.frs.g;

import com.baidu.tieba.tbadkCore.m;
/* loaded from: classes.dex */
public class e {
    public static void c(int i, m mVar) {
        if (mVar != null) {
            if (i == 3 || i == 6) {
                mVar.setLoadType(1);
            } else {
                mVar.setLoadType(2);
            }
        }
    }

    public static boolean b(m mVar) {
        return mVar != null && mVar.getLoadType() == 1;
    }
}
