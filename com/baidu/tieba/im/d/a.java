package com.baidu.tieba.im.d;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private UtilHelper.NetworkStateInfo b = null;
    private Map<UtilHelper.NetworkStateInfo, Integer> c = null;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a aVar = new a();
                    a = aVar;
                    aVar.c = new HashMap();
                    TbadkApplication.j();
                    aVar.a(TbadkApplication.ab());
                    aVar.b = UtilHelper.NetworkStateInfo.UNAVAIL;
                }
            }
        }
        return a;
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
}
