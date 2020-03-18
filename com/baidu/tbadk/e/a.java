package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static b cKB = null;
    private static a cKC = null;
    private static boolean cKD = false;
    private static String cKE = "";
    private static transient List<String> cKF = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (cKC == null) {
            synchronized (a.class) {
                if (cKC == null) {
                    cKC = new a();
                    cKB = b.c(baseFragmentActivity);
                }
            }
        } else if (cKB != null) {
            cKB.a(baseFragmentActivity.getPageContext());
        }
        if (cKD && cKB != null) {
            cKB.ayZ();
            cKB.aza();
            cKD = false;
        }
        return cKC;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        ayW();
        if (z) {
            ayS();
        }
        if (z2) {
            ayT();
        }
        fo(z3);
        a(aVar);
    }

    public void ayS() {
        ayW();
        if (cKB != null) {
            cKB.ayZ();
            cKD = false;
        }
    }

    public void ayT() {
        ayW();
        if (cKB != null) {
            cKB.aza();
            cKD = false;
        }
    }

    public void fo(boolean z) {
        ayW();
        if (cKB != null) {
            cKB.fo(z);
        }
    }

    public void a(b.a aVar) {
        ayW();
        if (cKB != null) {
            cKB.c(aVar);
        }
    }

    public void b(b.a aVar) {
        ayW();
        if (cKB != null) {
            if (cKB.ayX()) {
                cKB.c(aVar);
            }
            cKB.ayY();
        }
    }

    public void a(int i, b.a aVar) {
        ayW();
        if (cKB != null) {
            if (cKB.ayX()) {
                cKB.c(aVar);
            }
            cKB.jn(i);
        }
    }

    public void ayU() {
        ayW();
        if (cKB != null) {
            cKB.ayU();
            cKD = true;
        }
    }

    public void resetContext() {
        ayW();
        if (cKB != null) {
            cKB.resetContext();
        }
    }

    public void ayV() {
        ayW();
        resetContext();
        ayU();
    }

    private void ayW() {
        if (cKB == null) {
        }
    }

    public static void resetAll() {
        try {
            if (cKB != null) {
                if (cKC != null) {
                    cKC.ayV();
                }
                cKB.removeCallBack();
                cKB.azb();
                cKB = null;
            }
            if (cKC != null) {
                cKC = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
