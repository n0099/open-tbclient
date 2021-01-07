package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static b eJC = null;
    private static a eJD = null;
    private static boolean eJE = false;
    private static String eJF = "";
    private static transient List<String> eJG = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (eJD == null) {
            synchronized (a.class) {
                if (eJD == null) {
                    eJD = new a();
                    eJC = b.c(baseFragmentActivity);
                }
            }
        } else if (eJC != null) {
            eJC.a(baseFragmentActivity.getPageContext());
        }
        if (eJE && eJC != null) {
            eJC.bnK();
            eJC.bnL();
            eJE = false;
        }
        return eJD;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        bnH();
        if (z) {
            bnC();
        }
        if (z2) {
            bnD();
        }
        jd(z3);
        a(aVar);
    }

    public void bnC() {
        bnH();
        if (eJC != null) {
            eJC.bnK();
            eJE = false;
        }
    }

    public void bnD() {
        bnH();
        if (eJC != null) {
            eJC.bnL();
            eJE = false;
        }
    }

    public void jd(boolean z) {
        bnH();
        if (eJC != null) {
            eJC.jd(z);
        }
    }

    public void a(b.a aVar) {
        bnH();
        if (eJC != null) {
            eJC.c(aVar);
        }
    }

    public void b(b.a aVar) {
        bnH();
        if (eJC != null) {
            if (eJC.bnI()) {
                eJC.c(aVar);
            }
            eJC.bnJ();
        }
    }

    public void a(int i, b.a aVar) {
        bnH();
        if (eJC != null) {
            if (eJC.bnI()) {
                eJC.c(aVar);
            }
            eJC.on(i);
        }
    }

    public void bnE() {
        bnH();
        if (eJC != null) {
            eJC.bnE();
            eJE = true;
        }
    }

    public void bnF() {
        bnH();
        if (eJC != null) {
            eJC.bnF();
        }
    }

    public void bnG() {
        bnH();
        bnF();
        bnE();
    }

    private void bnH() {
        if (eJC == null) {
        }
    }

    public static void aKt() {
        try {
            if (eJC != null) {
                if (eJD != null) {
                    eJD.bnG();
                }
                eJC.removeCallBack();
                eJC.bnM();
                eJC = null;
            }
            if (eJD != null) {
                eJD = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
