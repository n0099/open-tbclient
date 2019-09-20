package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static b bBW = null;
    private static a bBX = null;
    private static boolean bBY = false;
    private static String bBZ = "";
    private static transient List<String> bCa = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (bBX == null) {
            synchronized (a.class) {
                if (bBX == null) {
                    bBX = new a();
                    bBW = b.c(baseFragmentActivity);
                }
            }
        } else if (bBW != null) {
            bBW.a(baseFragmentActivity.getPageContext());
        }
        if (bBY && bBW != null) {
            bBW.aaS();
            bBW.aaT();
            bBY = false;
        }
        return bBX;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        aaO();
        if (z) {
            aaJ();
        }
        if (z2) {
            aaK();
        }
        dy(z3);
        a(aVar);
    }

    public void aaJ() {
        aaO();
        if (bBW != null) {
            bBW.aaS();
            bBY = false;
        }
    }

    public void aaK() {
        aaO();
        if (bBW != null) {
            bBW.aaT();
            bBY = false;
        }
    }

    public void dy(boolean z) {
        aaO();
        if (bBW != null) {
            bBW.dy(z);
        }
    }

    public void a(b.a aVar) {
        aaO();
        if (bBW != null) {
            bBW.c(aVar);
        }
    }

    public void b(b.a aVar) {
        aaO();
        if (bBW != null) {
            if (bBW.aaP()) {
                bBW.c(aVar);
            }
            bBW.aaR();
        }
    }

    public void a(int i, b.a aVar) {
        aaO();
        if (bBW != null) {
            if (bBW.aaP()) {
                bBW.c(aVar);
            }
            bBW.gr(i);
        }
    }

    public void aaL() {
        aaO();
        if (bBW != null) {
            bBW.aaL();
            bBY = true;
        }
    }

    public void aaM() {
        aaO();
        if (bBW != null) {
            bBW.aaM();
        }
    }

    public void aaN() {
        aaO();
        aaM();
        aaL();
    }

    private void aaO() {
        if (bBW == null) {
        }
    }

    public static void Km() {
        try {
            if (bBW != null) {
                if (bBX != null) {
                    bBX.aaN();
                }
                bBW.aaQ();
                bBW.aaU();
                bBW = null;
            }
            if (bBX != null) {
                bBX = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
