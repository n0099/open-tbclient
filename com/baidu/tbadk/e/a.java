package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private static b euC = null;
    private static a euD = null;
    private static boolean euE = false;
    private static String euF = "";
    private static transient List<String> euG = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (euD == null) {
            synchronized (a.class) {
                if (euD == null) {
                    euD = new a();
                    euC = b.c(baseFragmentActivity);
                }
            }
        } else if (euC != null) {
            euC.a(baseFragmentActivity.getPageContext());
        }
        if (euE && euC != null) {
            euC.biG();
            euC.biH();
            euE = false;
        }
        return euD;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        biD();
        if (z) {
            biz();
        }
        if (z2) {
            biA();
        }
        ir(z3);
        a(aVar);
    }

    public void biz() {
        biD();
        if (euC != null) {
            euC.biG();
            euE = false;
        }
    }

    public void biA() {
        biD();
        if (euC != null) {
            euC.biH();
            euE = false;
        }
    }

    public void ir(boolean z) {
        biD();
        if (euC != null) {
            euC.ir(z);
        }
    }

    public void a(b.a aVar) {
        biD();
        if (euC != null) {
            euC.c(aVar);
        }
    }

    public void b(b.a aVar) {
        biD();
        if (euC != null) {
            if (euC.biE()) {
                euC.c(aVar);
            }
            euC.biF();
        }
    }

    public void a(int i, b.a aVar) {
        biD();
        if (euC != null) {
            if (euC.biE()) {
                euC.c(aVar);
            }
            euC.nJ(i);
        }
    }

    public void biB() {
        biD();
        if (euC != null) {
            euC.biB();
            euE = true;
        }
    }

    public void resetContext() {
        biD();
        if (euC != null) {
            euC.resetContext();
        }
    }

    public void biC() {
        biD();
        resetContext();
        biB();
    }

    private void biD() {
        if (euC == null) {
        }
    }

    public static void resetAll() {
        try {
            if (euC != null) {
                if (euD != null) {
                    euD.biC();
                }
                euC.removeCallBack();
                euC.biI();
                euC = null;
            }
            if (euD != null) {
                euD = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
