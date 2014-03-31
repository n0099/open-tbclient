package com.baidu.tbadk.coreExtra.d;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public final class i {
    private static /* synthetic */ int[] d;
    private l a;
    private k b;
    private j c;

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

    public i(String str, k kVar) {
        String str2;
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = new l(this);
        this.b = kVar;
        this.a.sendEmptyMessageDelayed(0, 50000L);
        this.c = new j(this, (byte) 0);
        this.c.setSelfExecute(true);
        j jVar = this.c;
        String[] strArr = new String[1];
        switch (a()[UtilHelper.d(TbadkApplication.j().b().getApplicationContext()).ordinal()]) {
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
        jVar.execute(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(i iVar) {
        if (iVar.c != null) {
            iVar.c.cancel(true);
        }
        if (iVar.a != null) {
            iVar.a.removeMessages(0);
        }
    }
}
