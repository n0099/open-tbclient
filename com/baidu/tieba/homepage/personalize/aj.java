package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class aj {
    private static volatile List<Long> cxK = new ArrayList();

    public static void bp(long j) {
        if (cxK.size() > 300) {
            cxK.remove(0);
        }
        cxK.add(Long.valueOf(j));
    }

    public static boolean bq(long j) {
        return cxK.contains(Long.valueOf(j));
    }
}
