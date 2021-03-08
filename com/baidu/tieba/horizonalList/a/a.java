package com.baidu.tieba.horizonalList.a;

import java.util.Random;
/* loaded from: classes.dex */
public final class a {
    private static final Random kub = new Random();

    public static int cI(int i, int i2) {
        return i >= i2 ? i : (int) ((kub.nextFloat() * (i2 - i)) + i);
    }
}
