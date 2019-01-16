package com.baidu.tbadk.d;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.d.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b amN = null;
    private static a amO = null;
    private static boolean amP = false;
    private static String amQ = "";
    private static transient List<String> amR = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (amO == null) {
            synchronized (a.class) {
                if (amO == null) {
                    amO = new a();
                    amN = b.c(baseFragmentActivity);
                }
            }
        } else if (amN != null) {
            amN.setContext(baseFragmentActivity.getPageContext());
        }
        if (amP && amN != null) {
            amN.wK();
            amN.wL();
            amP = false;
        }
        return amO;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        wG();
        if (z) {
            wB();
        }
        if (z2) {
            wC();
        }
        aR(z3);
        a(aVar);
    }

    public void wB() {
        wG();
        if (amN != null) {
            amN.wK();
            amP = false;
        }
    }

    public void wC() {
        wG();
        if (amN != null) {
            amN.wL();
            amP = false;
        }
    }

    public void aR(boolean z) {
        wG();
        if (amN != null) {
            amN.aR(z);
        }
    }

    public void a(b.a aVar) {
        wG();
        if (amN != null) {
            amN.c(aVar);
        }
    }

    public void b(b.a aVar) {
        wG();
        if (amN != null) {
            if (amN.wH()) {
                amN.c(aVar);
            }
            amN.wJ();
        }
    }

    public void a(int i, b.a aVar) {
        wG();
        if (amN != null) {
            if (amN.wH()) {
                amN.c(aVar);
            }
            amN.ca(i);
        }
    }

    public void wD() {
        wG();
        if (amN != null) {
            amN.wD();
            amP = true;
        }
    }

    public void wE() {
        wG();
        if (amN != null) {
            amN.wE();
        }
    }

    public void wF() {
        wG();
        wE();
        wD();
    }

    private void wG() {
        if (amN == null) {
        }
    }

    public static void resetAll() {
        try {
            if (amN != null) {
                if (amO != null) {
                    amO.wF();
                }
                amN.wI();
                amN.wM();
                amN = null;
            }
            if (amO != null) {
                amO = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
