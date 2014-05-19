package com.baidu.tieba.im.d;

import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.TbConfig;
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
                    a = new a();
                    a.b();
                }
            }
        }
        return a;
    }

    protected void b() {
        this.c = new HashMap();
        a(TbadkApplication.m252getInst().getImTimeOut());
        this.b = UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    public void a(int[] iArr) {
        int i;
        int i2;
        int i3 = KirinConfig.READ_TIME_OUT;
        int i4 = 0;
        if (iArr == null || iArr.length != 3) {
            i = 0;
            i2 = 0;
        } else {
            i2 = iArr[0];
            i = iArr[1];
            i4 = iArr[2];
        }
        if (i2 < 5000) {
            i2 = 20000;
        }
        if (i < 5000) {
            i = TbConfig.BIG_IMAGE_MIN_CAPACITY;
        }
        if (i4 >= 5000) {
            i3 = i4;
        }
        this.c.put(UtilHelper.NetworkStateInfo.TwoG, Integer.valueOf(i2));
        this.c.put(UtilHelper.NetworkStateInfo.ThreeG, Integer.valueOf(i));
        this.c.put(UtilHelper.NetworkStateInfo.WIFI, Integer.valueOf(i3));
    }
}
