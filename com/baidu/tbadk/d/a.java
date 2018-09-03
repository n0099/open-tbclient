package com.baidu.tbadk.d;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.d.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b aaD = null;
    private static a aaE = null;
    private static boolean aaF = false;
    private static String aaG = "";
    private static transient List<String> aaH = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aaE == null) {
            synchronized (a.class) {
                if (aaE == null) {
                    aaE = new a();
                    aaD = b.c(baseFragmentActivity);
                }
            }
        } else if (aaD != null) {
            aaD.setContext(baseFragmentActivity.getPageContext());
        }
        if (aaF && aaD != null) {
            aaD.rZ();
            aaD.sa();
            aaF = false;
        }
        return aaE;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        rU();
        if (z) {
            rP();
        }
        if (z2) {
            rQ();
        }
        af(z3);
        a(aVar);
    }

    public void rP() {
        rU();
        if (aaD != null) {
            aaD.rZ();
            aaF = false;
        }
    }

    public void rQ() {
        rU();
        if (aaD != null) {
            aaD.sa();
            aaF = false;
        }
    }

    public void af(boolean z) {
        rU();
        if (aaD != null) {
            aaD.af(z);
        }
    }

    public void a(b.a aVar) {
        rU();
        if (aaD != null) {
            aaD.c(aVar);
        }
    }

    public void b(b.a aVar) {
        rU();
        if (aaD != null) {
            if (aaD.rW()) {
                aaD.c(aVar);
            }
            aaD.rY();
        }
    }

    public void a(int i, b.a aVar) {
        rU();
        if (aaD != null) {
            if (aaD.rW()) {
                aaD.c(aVar);
            }
            aaD.bc(i);
        }
    }

    public void rR() {
        rU();
        if (aaD != null) {
            aaD.rR();
            aaF = true;
        }
    }

    public void rS() {
        rU();
        if (aaD != null) {
            aaD.rS();
        }
    }

    public void rT() {
        rU();
        rS();
        rR();
    }

    private void rU() {
        if (aaD == null) {
        }
    }

    public static void rV() {
        try {
            if (aaD != null) {
                if (aaE != null) {
                    aaE.rT();
                }
                aaD.rX();
                aaD.sb();
                aaD = null;
            }
            if (aaE != null) {
                aaE = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
