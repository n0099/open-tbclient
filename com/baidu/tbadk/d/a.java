package com.baidu.tbadk.d;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.d.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b aaC = null;
    private static a aaD = null;
    private static boolean aaE = false;
    private static String aaF = "";
    private static transient List<String> aaG = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aaD == null) {
            synchronized (a.class) {
                if (aaD == null) {
                    aaD = new a();
                    aaC = b.c(baseFragmentActivity);
                }
            }
        } else if (aaC != null) {
            aaC.setContext(baseFragmentActivity.getPageContext());
        }
        if (aaE && aaC != null) {
            aaC.sb();
            aaC.sc();
            aaE = false;
        }
        return aaD;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        rW();
        if (z) {
            rR();
        }
        if (z2) {
            rS();
        }
        ae(z3);
        a(aVar);
    }

    public void rR() {
        rW();
        if (aaC != null) {
            aaC.sb();
            aaE = false;
        }
    }

    public void rS() {
        rW();
        if (aaC != null) {
            aaC.sc();
            aaE = false;
        }
    }

    public void ae(boolean z) {
        rW();
        if (aaC != null) {
            aaC.ae(z);
        }
    }

    public void a(b.a aVar) {
        rW();
        if (aaC != null) {
            aaC.c(aVar);
        }
    }

    public void b(b.a aVar) {
        rW();
        if (aaC != null) {
            if (aaC.rY()) {
                aaC.c(aVar);
            }
            aaC.sa();
        }
    }

    public void a(int i, b.a aVar) {
        rW();
        if (aaC != null) {
            if (aaC.rY()) {
                aaC.c(aVar);
            }
            aaC.bc(i);
        }
    }

    public void rT() {
        rW();
        if (aaC != null) {
            aaC.rT();
            aaE = true;
        }
    }

    public void rU() {
        rW();
        if (aaC != null) {
            aaC.rU();
        }
    }

    public void rV() {
        rW();
        rU();
        rT();
    }

    private void rW() {
        if (aaC == null) {
        }
    }

    public static void rX() {
        try {
            if (aaC != null) {
                if (aaD != null) {
                    aaD.rV();
                }
                aaC.rZ();
                aaC.sd();
                aaC = null;
            }
            if (aaD != null) {
                aaD = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
