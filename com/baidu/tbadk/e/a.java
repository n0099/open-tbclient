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
            eJC.bnJ();
            eJC.bnK();
            eJE = false;
        }
        return eJD;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        bnG();
        if (z) {
            bnB();
        }
        if (z2) {
            bnC();
        }
        jd(z3);
        a(aVar);
    }

    public void bnB() {
        bnG();
        if (eJC != null) {
            eJC.bnJ();
            eJE = false;
        }
    }

    public void bnC() {
        bnG();
        if (eJC != null) {
            eJC.bnK();
            eJE = false;
        }
    }

    public void jd(boolean z) {
        bnG();
        if (eJC != null) {
            eJC.jd(z);
        }
    }

    public void a(b.a aVar) {
        bnG();
        if (eJC != null) {
            eJC.c(aVar);
        }
    }

    public void b(b.a aVar) {
        bnG();
        if (eJC != null) {
            if (eJC.bnH()) {
                eJC.c(aVar);
            }
            eJC.bnI();
        }
    }

    public void a(int i, b.a aVar) {
        bnG();
        if (eJC != null) {
            if (eJC.bnH()) {
                eJC.c(aVar);
            }
            eJC.on(i);
        }
    }

    public void bnD() {
        bnG();
        if (eJC != null) {
            eJC.bnD();
            eJE = true;
        }
    }

    public void bnE() {
        bnG();
        if (eJC != null) {
            eJC.bnE();
        }
    }

    public void bnF() {
        bnG();
        bnE();
        bnD();
    }

    private void bnG() {
        if (eJC == null) {
        }
    }

    public static void aKs() {
        try {
            if (eJC != null) {
                if (eJD != null) {
                    eJD.bnF();
                }
                eJC.removeCallBack();
                eJC.bnL();
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
