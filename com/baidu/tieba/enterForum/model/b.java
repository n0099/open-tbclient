package com.baidu.tieba.enterForum.model;

import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public static <T> void c(List<T> list, int i, int i2) {
        if (list != null && i != i2 && i >= 0 && i < list.size() && i2 >= 0 && i2 < list.size()) {
            if (i < i2) {
                while (i < i2) {
                    Collections.swap(list, i, i + 1);
                    i++;
                }
                return;
            }
            while (i > i2) {
                Collections.swap(list, i, i - 1);
                i--;
            }
        }
    }

    public static int a(float f, int i, int i2) {
        int i3 = 0;
        if (f < i / 2) {
            i3 = ((int) f) - (i / 2);
        }
        if (f > i2 - (i / 2)) {
            return (((int) f) - i2) + (i / 2);
        }
        return i3;
    }
}
