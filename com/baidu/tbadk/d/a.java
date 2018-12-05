package com.baidu.tbadk.d;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.d.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b amt = null;
    private static a amu = null;
    private static boolean amv = false;
    private static String amw = "";
    private static transient List<String> amx = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (amu == null) {
            synchronized (a.class) {
                if (amu == null) {
                    amu = new a();
                    amt = b.c(baseFragmentActivity);
                }
            }
        } else if (amt != null) {
            amt.setContext(baseFragmentActivity.getPageContext());
        }
        if (amv && amt != null) {
            amt.wD();
            amt.wE();
            amv = false;
        }
        return amu;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        wz();
        if (z) {
            wu();
        }
        if (z2) {
            wv();
        }
        aQ(z3);
        a(aVar);
    }

    public void wu() {
        wz();
        if (amt != null) {
            amt.wD();
            amv = false;
        }
    }

    public void wv() {
        wz();
        if (amt != null) {
            amt.wE();
            amv = false;
        }
    }

    public void aQ(boolean z) {
        wz();
        if (amt != null) {
            amt.aQ(z);
        }
    }

    public void a(b.a aVar) {
        wz();
        if (amt != null) {
            amt.c(aVar);
        }
    }

    public void b(b.a aVar) {
        wz();
        if (amt != null) {
            if (amt.wA()) {
                amt.c(aVar);
            }
            amt.wC();
        }
    }

    public void a(int i, b.a aVar) {
        wz();
        if (amt != null) {
            if (amt.wA()) {
                amt.c(aVar);
            }
            amt.ca(i);
        }
    }

    public void ww() {
        wz();
        if (amt != null) {
            amt.ww();
            amv = true;
        }
    }

    public void wx() {
        wz();
        if (amt != null) {
            amt.wx();
        }
    }

    public void wy() {
        wz();
        wx();
        ww();
    }

    private void wz() {
        if (amt == null) {
        }
    }

    public static void resetAll() {
        try {
            if (amt != null) {
                if (amu != null) {
                    amu.wy();
                }
                amt.wB();
                amt.wF();
                amt = null;
            }
            if (amu != null) {
                amu = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
