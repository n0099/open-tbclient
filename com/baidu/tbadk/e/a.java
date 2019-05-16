package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static b bAB = null;
    private static a bAC = null;
    private static boolean bAD = false;
    private static String bAE = "";
    private static transient List<String> bAF = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (bAC == null) {
            synchronized (a.class) {
                if (bAC == null) {
                    bAC = new a();
                    bAB = b.c(baseFragmentActivity);
                }
            }
        } else if (bAB != null) {
            bAB.a(baseFragmentActivity.getPageContext());
        }
        if (bAD && bAB != null) {
            bAB.ZP();
            bAB.ZQ();
            bAD = false;
        }
        return bAC;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        ZL();
        if (z) {
            ZG();
        }
        if (z2) {
            ZH();
        }
        dt(z3);
        a(aVar);
    }

    public void ZG() {
        ZL();
        if (bAB != null) {
            bAB.ZP();
            bAD = false;
        }
    }

    public void ZH() {
        ZL();
        if (bAB != null) {
            bAB.ZQ();
            bAD = false;
        }
    }

    public void dt(boolean z) {
        ZL();
        if (bAB != null) {
            bAB.dt(z);
        }
    }

    public void a(b.a aVar) {
        ZL();
        if (bAB != null) {
            bAB.c(aVar);
        }
    }

    public void b(b.a aVar) {
        ZL();
        if (bAB != null) {
            if (bAB.ZM()) {
                bAB.c(aVar);
            }
            bAB.ZO();
        }
    }

    public void a(int i, b.a aVar) {
        ZL();
        if (bAB != null) {
            if (bAB.ZM()) {
                bAB.c(aVar);
            }
            bAB.gm(i);
        }
    }

    public void ZI() {
        ZL();
        if (bAB != null) {
            bAB.ZI();
            bAD = true;
        }
    }

    public void ZJ() {
        ZL();
        if (bAB != null) {
            bAB.ZJ();
        }
    }

    public void ZK() {
        ZL();
        ZJ();
        ZI();
    }

    private void ZL() {
        if (bAB == null) {
        }
    }

    public static void Jv() {
        try {
            if (bAB != null) {
                if (bAC != null) {
                    bAC.ZK();
                }
                bAB.ZN();
                bAB.ZR();
                bAB = null;
            }
            if (bAC != null) {
                bAC = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
