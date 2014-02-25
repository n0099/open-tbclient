package com.baidu.tieba.im.net;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class h {
    private static /* synthetic */ int[] d;
    private k a;
    private j b;
    private i c;

    static /* synthetic */ int[] a() {
        int[] iArr = d;
        if (iArr == null) {
            iArr = new int[UtilHelper.NetworkStateInfo.valuesCustom().length];
            try {
                iArr[UtilHelper.NetworkStateInfo.ThreeG.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.TwoG.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.UNAVAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            d = iArr;
        }
        return iArr;
    }

    public h(String str, j jVar) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = new k(this);
        this.b = jVar;
        this.a.sendEmptyMessageDelayed(0, 50000L);
        this.c = new i(this, null);
        this.c.setSelfExecute(true);
        this.c.execute(String.valueOf(b()) + str);
    }

    private String b() {
        switch (a()[UtilHelper.h(TiebaApplication.g().b().getApplicationContext()).ordinal()]) {
            case 2:
                return "ping -c 3 -w 3000 ";
            case 3:
                return "ping -c 3 -w 10000 ";
            case 4:
                return "ping -c 3 -w 5000 ";
            default:
                return "ping -c 3 -w 5000 ";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.c != null) {
            this.c.cancel(true);
        }
        if (this.a != null) {
            this.a.removeMessages(0);
        }
    }
}
