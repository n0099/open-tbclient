package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private static b eoJ = null;
    private static a eoK = null;
    private static boolean eoL = false;
    private static String eoM = "";
    private static transient List<String> eoN = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (eoK == null) {
            synchronized (a.class) {
                if (eoK == null) {
                    eoK = new a();
                    eoJ = b.c(baseFragmentActivity);
                }
            }
        } else if (eoJ != null) {
            eoJ.a(baseFragmentActivity.getPageContext());
        }
        if (eoL && eoJ != null) {
            eoJ.bgg();
            eoJ.bgh();
            eoL = false;
        }
        return eoK;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        bgd();
        if (z) {
            bfZ();
        }
        if (z2) {
            bga();
        }
        ii(z3);
        a(aVar);
    }

    public void bfZ() {
        bgd();
        if (eoJ != null) {
            eoJ.bgg();
            eoL = false;
        }
    }

    public void bga() {
        bgd();
        if (eoJ != null) {
            eoJ.bgh();
            eoL = false;
        }
    }

    public void ii(boolean z) {
        bgd();
        if (eoJ != null) {
            eoJ.ii(z);
        }
    }

    public void a(b.a aVar) {
        bgd();
        if (eoJ != null) {
            eoJ.c(aVar);
        }
    }

    public void b(b.a aVar) {
        bgd();
        if (eoJ != null) {
            if (eoJ.bge()) {
                eoJ.c(aVar);
            }
            eoJ.bgf();
        }
    }

    public void a(int i, b.a aVar) {
        bgd();
        if (eoJ != null) {
            if (eoJ.bge()) {
                eoJ.c(aVar);
            }
            eoJ.nz(i);
        }
    }

    public void bgb() {
        bgd();
        if (eoJ != null) {
            eoJ.bgb();
            eoL = true;
        }
    }

    public void resetContext() {
        bgd();
        if (eoJ != null) {
            eoJ.resetContext();
        }
    }

    public void bgc() {
        bgd();
        resetContext();
        bgb();
    }

    private void bgd() {
        if (eoJ == null) {
        }
    }

    public static void resetAll() {
        try {
            if (eoJ != null) {
                if (eoK != null) {
                    eoK.bgc();
                }
                eoJ.removeCallBack();
                eoJ.bgi();
                eoJ = null;
            }
            if (eoK != null) {
                eoK = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
