package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static b bBy = null;
    private static a bBz = null;
    private static boolean bBA = false;
    private static String bBB = "";
    private static transient List<String> bBC = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (bBz == null) {
            synchronized (a.class) {
                if (bBz == null) {
                    bBz = new a();
                    bBy = b.c(baseFragmentActivity);
                }
            }
        } else if (bBy != null) {
            bBy.a(baseFragmentActivity.getPageContext());
        }
        if (bBA && bBy != null) {
            bBy.aaO();
            bBy.aaP();
            bBA = false;
        }
        return bBz;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        aaK();
        if (z) {
            aaF();
        }
        if (z2) {
            aaG();
        }
        dy(z3);
        a(aVar);
    }

    public void aaF() {
        aaK();
        if (bBy != null) {
            bBy.aaO();
            bBA = false;
        }
    }

    public void aaG() {
        aaK();
        if (bBy != null) {
            bBy.aaP();
            bBA = false;
        }
    }

    public void dy(boolean z) {
        aaK();
        if (bBy != null) {
            bBy.dy(z);
        }
    }

    public void a(b.a aVar) {
        aaK();
        if (bBy != null) {
            bBy.c(aVar);
        }
    }

    public void b(b.a aVar) {
        aaK();
        if (bBy != null) {
            if (bBy.aaL()) {
                bBy.c(aVar);
            }
            bBy.aaN();
        }
    }

    public void a(int i, b.a aVar) {
        aaK();
        if (bBy != null) {
            if (bBy.aaL()) {
                bBy.c(aVar);
            }
            bBy.gq(i);
        }
    }

    public void aaH() {
        aaK();
        if (bBy != null) {
            bBy.aaH();
            bBA = true;
        }
    }

    public void aaI() {
        aaK();
        if (bBy != null) {
            bBy.aaI();
        }
    }

    public void aaJ() {
        aaK();
        aaI();
        aaH();
    }

    private void aaK() {
        if (bBy == null) {
        }
    }

    public static void Ki() {
        try {
            if (bBy != null) {
                if (bBz != null) {
                    bBz.aaJ();
                }
                bBy.aaM();
                bBy.aaQ();
                bBy = null;
            }
            if (bBz != null) {
                bBz = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
