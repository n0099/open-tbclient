package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static b eGY = null;
    private static a eGZ = null;
    private static boolean eHa = false;
    private static String eHb = "";
    private static transient List<String> eHc = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (eGZ == null) {
            synchronized (a.class) {
                if (eGZ == null) {
                    eGZ = new a();
                    eGY = b.c(baseFragmentActivity);
                }
            }
        } else if (eGY != null) {
            eGY.a(baseFragmentActivity.getPageContext());
        }
        if (eHa && eGY != null) {
            eGY.bkk();
            eGY.bkl();
            eHa = false;
        }
        return eGZ;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        bkh();
        if (z) {
            bkd();
        }
        if (z2) {
            bke();
        }
        jb(z3);
        a(aVar);
    }

    public void bkd() {
        bkh();
        if (eGY != null) {
            eGY.bkk();
            eHa = false;
        }
    }

    public void bke() {
        bkh();
        if (eGY != null) {
            eGY.bkl();
            eHa = false;
        }
    }

    public void jb(boolean z) {
        bkh();
        if (eGY != null) {
            eGY.jb(z);
        }
    }

    public void a(b.a aVar) {
        bkh();
        if (eGY != null) {
            eGY.c(aVar);
        }
    }

    public void b(b.a aVar) {
        bkh();
        if (eGY != null) {
            if (eGY.bki()) {
                eGY.c(aVar);
            }
            eGY.bkj();
        }
    }

    public void a(int i, b.a aVar) {
        bkh();
        if (eGY != null) {
            if (eGY.bki()) {
                eGY.c(aVar);
            }
            eGY.mK(i);
        }
    }

    public void bkf() {
        bkh();
        if (eGY != null) {
            eGY.bkf();
            eHa = true;
        }
    }

    public void resetContext() {
        bkh();
        if (eGY != null) {
            eGY.resetContext();
        }
    }

    public void bkg() {
        bkh();
        resetContext();
        bkf();
    }

    private void bkh() {
        if (eGY == null) {
        }
    }

    public static void resetAll() {
        try {
            if (eGY != null) {
                if (eGZ != null) {
                    eGZ.bkg();
                }
                eGY.removeCallBack();
                eGY.bkm();
                eGY = null;
            }
            if (eGZ != null) {
                eGZ = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
