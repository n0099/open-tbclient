package com.baidu.tieba.im.net;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class p {
    private static p a = null;
    private UtilHelper.NetworkStateInfo b = null;
    private Map<UtilHelper.NetworkStateInfo, Integer> c = null;

    public static p a() {
        if (a == null) {
            synchronized (p.class) {
                if (a == null) {
                    a = new p();
                }
            }
        }
        return a;
    }

    public final void b() {
        this.c = new HashMap();
        a(TiebaApplication.g().aL());
        this.b = UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    public final void a(int[] iArr) {
        int i;
        int i2;
        int i3 = 0;
        if (iArr == null || iArr.length != 3) {
            i = 0;
            i2 = 0;
        } else {
            i2 = iArr[0];
            i = iArr[1];
            i3 = iArr[2];
        }
        if (i2 < 5000) {
            i2 = 20000;
        }
        if (i < 5000) {
            i = 10000;
        }
        int i4 = i3 >= 5000 ? i3 : 5000;
        this.c.put(UtilHelper.NetworkStateInfo.TwoG, Integer.valueOf(i2));
        this.c.put(UtilHelper.NetworkStateInfo.ThreeG, Integer.valueOf(i));
        this.c.put(UtilHelper.NetworkStateInfo.WIFI, Integer.valueOf(i4));
    }

    public final void c() {
        this.b = UtilHelper.h(TiebaApplication.g().b());
    }

    public final int d() {
        int i;
        Integer num;
        if (this.c == null) {
            return 20000;
        }
        if (this.b == null || (num = this.c.get(this.b)) == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        if (i < 5000) {
            return 5000;
        }
        return i;
    }
}
