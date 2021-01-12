package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private static b eER = null;
    private static a eES = null;
    private static boolean eET = false;
    private static String eEU = "";
    private static transient List<String> eEV = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (eES == null) {
            synchronized (a.class) {
                if (eES == null) {
                    eES = new a();
                    eER = b.c(baseFragmentActivity);
                }
            }
        } else if (eER != null) {
            eER.a(baseFragmentActivity.getPageContext());
        }
        if (eET && eER != null) {
            eER.bjQ();
            eER.bjR();
            eET = false;
        }
        return eES;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        bjN();
        if (z) {
            bjI();
        }
        if (z2) {
            bjJ();
        }
        iZ(z3);
        a(aVar);
    }

    public void bjI() {
        bjN();
        if (eER != null) {
            eER.bjQ();
            eET = false;
        }
    }

    public void bjJ() {
        bjN();
        if (eER != null) {
            eER.bjR();
            eET = false;
        }
    }

    public void iZ(boolean z) {
        bjN();
        if (eER != null) {
            eER.iZ(z);
        }
    }

    public void a(b.a aVar) {
        bjN();
        if (eER != null) {
            eER.c(aVar);
        }
    }

    public void b(b.a aVar) {
        bjN();
        if (eER != null) {
            if (eER.bjO()) {
                eER.c(aVar);
            }
            eER.bjP();
        }
    }

    public void a(int i, b.a aVar) {
        bjN();
        if (eER != null) {
            if (eER.bjO()) {
                eER.c(aVar);
            }
            eER.mH(i);
        }
    }

    public void bjK() {
        bjN();
        if (eER != null) {
            eER.bjK();
            eET = true;
        }
    }

    public void bjL() {
        bjN();
        if (eER != null) {
            eER.bjL();
        }
    }

    public void bjM() {
        bjN();
        bjL();
        bjK();
    }

    private void bjN() {
        if (eER == null) {
        }
    }

    public static void aGz() {
        try {
            if (eER != null) {
                if (eES != null) {
                    eES.bjM();
                }
                eER.removeCallBack();
                eER.bjS();
                eER = null;
            }
            if (eES != null) {
                eES = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
