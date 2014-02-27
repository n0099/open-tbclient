package com.baidu.tieba.im.net;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public final class h {
    private static /* synthetic */ int[] d;
    private k a;
    private j b;
    private i c;

    private static /* synthetic */ int[] a() {
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
        String str2;
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = new k(this);
        this.b = jVar;
        this.a.sendEmptyMessageDelayed(0, 50000L);
        this.c = new i(this, (byte) 0);
        this.c.setSelfExecute(true);
        i iVar = this.c;
        String[] strArr = new String[1];
        switch (a()[UtilHelper.h(TiebaApplication.g().b().getApplicationContext()).ordinal()]) {
            case 2:
                str2 = "ping -c 3 -w 3000 ";
                break;
            case 3:
                str2 = "ping -c 3 -w 10000 ";
                break;
            case 4:
                str2 = "ping -c 3 -w 5000 ";
                break;
            default:
                str2 = "ping -c 3 -w 5000 ";
                break;
        }
        strArr[0] = String.valueOf(str2) + str;
        iVar.execute(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(h hVar) {
        if (hVar.c != null) {
            hVar.c.cancel(true);
        }
        if (hVar.a != null) {
            hVar.a.removeMessages(0);
        }
    }
}
