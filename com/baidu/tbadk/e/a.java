package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private static b dRV = null;
    private static a dRW = null;
    private static boolean dRX = false;
    private static String dRY = "";
    private static transient List<String> dRZ = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (dRW == null) {
            synchronized (a.class) {
                if (dRW == null) {
                    dRW = new a();
                    dRV = b.c(baseFragmentActivity);
                }
            }
        } else if (dRV != null) {
            dRV.a(baseFragmentActivity.getPageContext());
        }
        if (dRX && dRV != null) {
            dRV.baL();
            dRV.baM();
            dRX = false;
        }
        return dRW;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        baI();
        if (z) {
            baE();
        }
        if (z2) {
            baF();
        }
        hB(z3);
        a(aVar);
    }

    public void baE() {
        baI();
        if (dRV != null) {
            dRV.baL();
            dRX = false;
        }
    }

    public void baF() {
        baI();
        if (dRV != null) {
            dRV.baM();
            dRX = false;
        }
    }

    public void hB(boolean z) {
        baI();
        if (dRV != null) {
            dRV.hB(z);
        }
    }

    public void a(b.a aVar) {
        baI();
        if (dRV != null) {
            dRV.c(aVar);
        }
    }

    public void b(b.a aVar) {
        baI();
        if (dRV != null) {
            if (dRV.baJ()) {
                dRV.c(aVar);
            }
            dRV.baK();
        }
    }

    public void a(int i, b.a aVar) {
        baI();
        if (dRV != null) {
            if (dRV.baJ()) {
                dRV.c(aVar);
            }
            dRV.mG(i);
        }
    }

    public void baG() {
        baI();
        if (dRV != null) {
            dRV.baG();
            dRX = true;
        }
    }

    public void resetContext() {
        baI();
        if (dRV != null) {
            dRV.resetContext();
        }
    }

    public void baH() {
        baI();
        resetContext();
        baG();
    }

    private void baI() {
        if (dRV == null) {
        }
    }

    public static void resetAll() {
        try {
            if (dRV != null) {
                if (dRW != null) {
                    dRW.baH();
                }
                dRV.removeCallBack();
                dRV.baN();
                dRV = null;
            }
            if (dRW != null) {
                dRW = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
