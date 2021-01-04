package com.baidu.tieba.horizonalList.a;

import java.util.Random;
/* loaded from: classes.dex */
public final class a {
    private static final Random koj = new Random();

    public static int cK(int i, int i2) {
        return i >= i2 ? i : (int) ((koj.nextFloat() * (i2 - i)) + i);
    }
}
