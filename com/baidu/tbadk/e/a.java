package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private static b dRZ = null;
    private static a dSa = null;
    private static boolean dSb = false;
    private static String dSc = "";
    private static transient List<String> dSd = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (dSa == null) {
            synchronized (a.class) {
                if (dSa == null) {
                    dSa = new a();
                    dRZ = b.c(baseFragmentActivity);
                }
            }
        } else if (dRZ != null) {
            dRZ.a(baseFragmentActivity.getPageContext());
        }
        if (dSb && dRZ != null) {
            dRZ.baL();
            dRZ.baM();
            dSb = false;
        }
        return dSa;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        baI();
        if (z) {
            baE();
        }
        if (z2) {
            baF();
        }
        hC(z3);
        a(aVar);
    }

    public void baE() {
        baI();
        if (dRZ != null) {
            dRZ.baL();
            dSb = false;
        }
    }

    public void baF() {
        baI();
        if (dRZ != null) {
            dRZ.baM();
            dSb = false;
        }
    }

    public void hC(boolean z) {
        baI();
        if (dRZ != null) {
            dRZ.hC(z);
        }
    }

    public void a(b.a aVar) {
        baI();
        if (dRZ != null) {
            dRZ.c(aVar);
        }
    }

    public void b(b.a aVar) {
        baI();
        if (dRZ != null) {
            if (dRZ.baJ()) {
                dRZ.c(aVar);
            }
            dRZ.baK();
        }
    }

    public void a(int i, b.a aVar) {
        baI();
        if (dRZ != null) {
            if (dRZ.baJ()) {
                dRZ.c(aVar);
            }
            dRZ.mG(i);
        }
    }

    public void baG() {
        baI();
        if (dRZ != null) {
            dRZ.baG();
            dSb = true;
        }
    }

    public void resetContext() {
        baI();
        if (dRZ != null) {
            dRZ.resetContext();
        }
    }

    public void baH() {
        baI();
        resetContext();
        baG();
    }

    private void baI() {
        if (dRZ == null) {
        }
    }

    public static void resetAll() {
        try {
            if (dRZ != null) {
                if (dSa != null) {
                    dSa.baH();
                }
                dRZ.removeCallBack();
                dRZ.baN();
                dRZ = null;
            }
            if (dSa != null) {
                dSa = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
