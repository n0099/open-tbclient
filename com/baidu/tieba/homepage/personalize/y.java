package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class y {
    private static volatile List<Long> cFi = new ArrayList();

    public static void bH(long j) {
        if (cFi.size() > 300) {
            cFi.remove(0);
        }
        cFi.add(Long.valueOf(j));
    }

    public static boolean bI(long j) {
        return cFi.contains(Long.valueOf(j));
    }
}
