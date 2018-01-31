package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private static volatile List<Long> efx = new ArrayList();

    public static void bL(long j) {
        if (efx.size() > 300) {
            efx.remove(0);
        }
        efx.add(Long.valueOf(j));
    }

    public static boolean bM(long j) {
        return efx.contains(Long.valueOf(j));
    }
}
