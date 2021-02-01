package com.baidu.tieba.horizonalList.a;

import java.util.Random;
/* loaded from: classes.dex */
public final class a {
    private static final Random krL = new Random();

    public static int cH(int i, int i2) {
        return i >= i2 ? i : (int) ((krL.nextFloat() * (i2 - i)) + i);
    }
}
