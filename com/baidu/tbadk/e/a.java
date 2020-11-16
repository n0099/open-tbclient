package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a {
    private static b esW = null;
    private static a esX = null;
    private static boolean esY = false;
    private static String esZ = "";
    private static transient List<String> eta = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (esX == null) {
            synchronized (a.class) {
                if (esX == null) {
                    esX = new a();
                    esW = b.c(baseFragmentActivity);
                }
            }
        } else if (esW != null) {
            esW.a(baseFragmentActivity.getPageContext());
        }
        if (esY && esW != null) {
            esW.bia();
            esW.bib();
            esY = false;
        }
        return esX;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        bhX();
        if (z) {
            bhT();
        }
        if (z2) {
            bhU();
        }
        it(z3);
        a(aVar);
    }

    public void bhT() {
        bhX();
        if (esW != null) {
            esW.bia();
            esY = false;
        }
    }

    public void bhU() {
        bhX();
        if (esW != null) {
            esW.bib();
            esY = false;
        }
    }

    public void it(boolean z) {
        bhX();
        if (esW != null) {
            esW.it(z);
        }
    }

    public void a(b.a aVar) {
        bhX();
        if (esW != null) {
            esW.c(aVar);
        }
    }

    public void b(b.a aVar) {
        bhX();
        if (esW != null) {
            if (esW.bhY()) {
                esW.c(aVar);
            }
            esW.bhZ();
        }
    }

    public void a(int i, b.a aVar) {
        bhX();
        if (esW != null) {
            if (esW.bhY()) {
                esW.c(aVar);
            }
            esW.nF(i);
        }
    }

    public void bhV() {
        bhX();
        if (esW != null) {
            esW.bhV();
            esY = true;
        }
    }

    public void resetContext() {
        bhX();
        if (esW != null) {
            esW.resetContext();
        }
    }

    public void bhW() {
        bhX();
        resetContext();
        bhV();
    }

    private void bhX() {
        if (esW == null) {
        }
    }

    public static void resetAll() {
        try {
            if (esW != null) {
                if (esX != null) {
                    esX.bhW();
                }
                esW.removeCallBack();
                esW.bic();
                esW = null;
            }
            if (esX != null) {
                esX = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
