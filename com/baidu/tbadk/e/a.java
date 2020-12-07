package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private static b ezZ = null;
    private static a eAa = null;
    private static boolean eAb = false;
    private static String eAc = "";
    private static transient List<String> eAd = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (eAa == null) {
            synchronized (a.class) {
                if (eAa == null) {
                    eAa = new a();
                    ezZ = b.c(baseFragmentActivity);
                }
            }
        } else if (ezZ != null) {
            ezZ.a(baseFragmentActivity.getPageContext());
        }
        if (eAb && ezZ != null) {
            ezZ.blk();
            ezZ.bll();
            eAb = false;
        }
        return eAa;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        blh();
        if (z) {
            blc();
        }
        if (z2) {
            bld();
        }
        iI(z3);
        a(aVar);
    }

    public void blc() {
        blh();
        if (ezZ != null) {
            ezZ.blk();
            eAb = false;
        }
    }

    public void bld() {
        blh();
        if (ezZ != null) {
            ezZ.bll();
            eAb = false;
        }
    }

    public void iI(boolean z) {
        blh();
        if (ezZ != null) {
            ezZ.iI(z);
        }
    }

    public void a(b.a aVar) {
        blh();
        if (ezZ != null) {
            ezZ.c(aVar);
        }
    }

    public void b(b.a aVar) {
        blh();
        if (ezZ != null) {
            if (ezZ.bli()) {
                ezZ.c(aVar);
            }
            ezZ.blj();
        }
    }

    public void a(int i, b.a aVar) {
        blh();
        if (ezZ != null) {
            if (ezZ.bli()) {
                ezZ.c(aVar);
            }
            ezZ.od(i);
        }
    }

    public void ble() {
        blh();
        if (ezZ != null) {
            ezZ.ble();
            eAb = true;
        }
    }

    public void blf() {
        blh();
        if (ezZ != null) {
            ezZ.blf();
        }
    }

    public void blg() {
        blh();
        blf();
        ble();
    }

    private void blh() {
        if (ezZ == null) {
        }
    }

    public static void resetAll() {
        try {
            if (ezZ != null) {
                if (eAa != null) {
                    eAa.blg();
                }
                ezZ.removeCallBack();
                ezZ.blm();
                ezZ = null;
            }
            if (eAa != null) {
                eAa = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
