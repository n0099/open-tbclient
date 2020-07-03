package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static b dCR = null;
    private static a dCS = null;
    private static boolean dCT = false;
    private static String dCU = "";
    private static transient List<String> dCV = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (dCS == null) {
            synchronized (a.class) {
                if (dCS == null) {
                    dCS = new a();
                    dCR = b.c(baseFragmentActivity);
                }
            }
        } else if (dCR != null) {
            dCR.a(baseFragmentActivity.getPageContext());
        }
        if (dCT && dCR != null) {
            dCR.aOz();
            dCR.aOA();
            dCT = false;
        }
        return dCS;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        aOw();
        if (z) {
            aOs();
        }
        if (z2) {
            aOt();
        }
        gK(z3);
        a(aVar);
    }

    public void aOs() {
        aOw();
        if (dCR != null) {
            dCR.aOz();
            dCT = false;
        }
    }

    public void aOt() {
        aOw();
        if (dCR != null) {
            dCR.aOA();
            dCT = false;
        }
    }

    public void gK(boolean z) {
        aOw();
        if (dCR != null) {
            dCR.gK(z);
        }
    }

    public void a(b.a aVar) {
        aOw();
        if (dCR != null) {
            dCR.c(aVar);
        }
    }

    public void b(b.a aVar) {
        aOw();
        if (dCR != null) {
            if (dCR.aOx()) {
                dCR.c(aVar);
            }
            dCR.aOy();
        }
    }

    public void a(int i, b.a aVar) {
        aOw();
        if (dCR != null) {
            if (dCR.aOx()) {
                dCR.c(aVar);
            }
            dCR.kh(i);
        }
    }

    public void aOu() {
        aOw();
        if (dCR != null) {
            dCR.aOu();
            dCT = true;
        }
    }

    public void resetContext() {
        aOw();
        if (dCR != null) {
            dCR.resetContext();
        }
    }

    public void aOv() {
        aOw();
        resetContext();
        aOu();
    }

    private void aOw() {
        if (dCR == null) {
        }
    }

    public static void resetAll() {
        try {
            if (dCR != null) {
                if (dCS != null) {
                    dCS.aOv();
                }
                dCR.removeCallBack();
                dCR.aOB();
                dCR = null;
            }
            if (dCS != null) {
                dCS = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
