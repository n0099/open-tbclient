package com.baidu.tieba.horizonalList.a;

import java.util.Random;
/* loaded from: classes.dex */
public final class a {
    private static final Random kjE = new Random();

    public static int cK(int i, int i2) {
        return i >= i2 ? i : (int) ((kjE.nextFloat() * (i2 - i)) + i);
    }
}
