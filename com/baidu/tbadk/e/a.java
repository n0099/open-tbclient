package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static b dxL = null;
    private static a dxM = null;
    private static boolean dxN = false;
    private static String dxO = "";
    private static transient List<String> dxP = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (dxM == null) {
            synchronized (a.class) {
                if (dxM == null) {
                    dxM = new a();
                    dxL = b.c(baseFragmentActivity);
                }
            }
        } else if (dxL != null) {
            dxL.a(baseFragmentActivity.getPageContext());
        }
        if (dxN && dxL != null) {
            dxL.aMW();
            dxL.aMX();
            dxN = false;
        }
        return dxM;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        aMT();
        if (z) {
            aMP();
        }
        if (z2) {
            aMQ();
        }
        gD(z3);
        a(aVar);
    }

    public void aMP() {
        aMT();
        if (dxL != null) {
            dxL.aMW();
            dxN = false;
        }
    }

    public void aMQ() {
        aMT();
        if (dxL != null) {
            dxL.aMX();
            dxN = false;
        }
    }

    public void gD(boolean z) {
        aMT();
        if (dxL != null) {
            dxL.gD(z);
        }
    }

    public void a(b.a aVar) {
        aMT();
        if (dxL != null) {
            dxL.c(aVar);
        }
    }

    public void b(b.a aVar) {
        aMT();
        if (dxL != null) {
            if (dxL.aMU()) {
                dxL.c(aVar);
            }
            dxL.aMV();
        }
    }

    public void a(int i, b.a aVar) {
        aMT();
        if (dxL != null) {
            if (dxL.aMU()) {
                dxL.c(aVar);
            }
            dxL.jU(i);
        }
    }

    public void aMR() {
        aMT();
        if (dxL != null) {
            dxL.aMR();
            dxN = true;
        }
    }

    public void resetContext() {
        aMT();
        if (dxL != null) {
            dxL.resetContext();
        }
    }

    public void aMS() {
        aMT();
        resetContext();
        aMR();
    }

    private void aMT() {
        if (dxL == null) {
        }
    }

    public static void resetAll() {
        try {
            if (dxL != null) {
                if (dxM != null) {
                    dxM.aMS();
                }
                dxL.removeCallBack();
                dxL.aMY();
                dxL = null;
            }
            if (dxM != null) {
                dxM = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
