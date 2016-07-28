package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class y {
    private static volatile List<Long> ctD = new ArrayList();

    public static void bl(long j) {
        if (ctD.size() > 300) {
            ctD.remove(0);
        }
        ctD.add(Long.valueOf(j));
    }

    public static boolean bm(long j) {
        return ctD.contains(Long.valueOf(j));
    }
}
