package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ai {
    private static volatile List<Long> czk = new ArrayList();

    public static void bp(long j) {
        if (czk.size() > 300) {
            czk.remove(0);
        }
        czk.add(Long.valueOf(j));
    }

    public static boolean bq(long j) {
        return czk.contains(Long.valueOf(j));
    }
}
