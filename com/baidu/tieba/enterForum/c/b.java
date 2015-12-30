package com.baidu.tieba.enterForum.c;

import android.widget.AbsListView;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b aUP;

    public static b Kt() {
        if (aUP == null) {
            synchronized (b.class) {
                if (aUP == null) {
                    aUP = new b();
                }
            }
        }
        return aUP;
    }

    private b() {
    }

    public <T> void a(List<T> list, int i, int i2) {
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

    public int a(float f, int i, int i2) {
        int i3 = 0;
        if (f < i / 2) {
            i3 = (int) (f - (i / 2));
        }
        if (f > i2 - (i / 2)) {
            return (int) ((f - i2) + (i / 2));
        }
        return i3;
    }

    public boolean a(AbsListView absListView, int i, int i2) {
        try {
            absListView.getClass().getMethod("smoothScrollBy", Integer.TYPE, Integer.TYPE).invoke(absListView, Integer.valueOf(i), Integer.valueOf(i2));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
