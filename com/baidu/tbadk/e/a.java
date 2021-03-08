package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private static b eIz = null;
    private static a eIA = null;
    private static boolean eIB = false;
    private static String eIC = "";
    private static transient List<String> eID = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (eIA == null) {
            synchronized (a.class) {
                if (eIA == null) {
                    eIA = new a();
                    eIz = b.c(baseFragmentActivity);
                }
            }
        } else if (eIz != null) {
            eIz.a(baseFragmentActivity.getPageContext());
        }
        if (eIB && eIz != null) {
            eIz.bkm();
            eIz.bkn();
            eIB = false;
        }
        return eIA;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        bkj();
        if (z) {
            bkf();
        }
        if (z2) {
            bkg();
        }
        jb(z3);
        a(aVar);
    }

    public void bkf() {
        bkj();
        if (eIz != null) {
            eIz.bkm();
            eIB = false;
        }
    }

    public void bkg() {
        bkj();
        if (eIz != null) {
            eIz.bkn();
            eIB = false;
        }
    }

    public void jb(boolean z) {
        bkj();
        if (eIz != null) {
            eIz.jb(z);
        }
    }

    public void a(b.a aVar) {
        bkj();
        if (eIz != null) {
            eIz.c(aVar);
        }
    }

    public void b(b.a aVar) {
        bkj();
        if (eIz != null) {
            if (eIz.bkk()) {
                eIz.c(aVar);
            }
            eIz.bkl();
        }
    }

    public void a(int i, b.a aVar) {
        bkj();
        if (eIz != null) {
            if (eIz.bkk()) {
                eIz.c(aVar);
            }
            eIz.mL(i);
        }
    }

    public void bkh() {
        bkj();
        if (eIz != null) {
            eIz.bkh();
            eIB = true;
        }
    }

    public void resetContext() {
        bkj();
        if (eIz != null) {
            eIz.resetContext();
        }
    }

    public void bki() {
        bkj();
        resetContext();
        bkh();
    }

    private void bkj() {
        if (eIz == null) {
        }
    }

    public static void resetAll() {
        try {
            if (eIz != null) {
                if (eIA != null) {
                    eIA.bki();
                }
                eIz.removeCallBack();
                eIz.bko();
                eIz = null;
            }
            if (eIA != null) {
                eIA = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
