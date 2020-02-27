package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static b cKo = null;
    private static a cKp = null;
    private static boolean cKq = false;
    private static String cKr = "";
    private static transient List<String> cKs = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (cKp == null) {
            synchronized (a.class) {
                if (cKp == null) {
                    cKp = new a();
                    cKo = b.c(baseFragmentActivity);
                }
            }
        } else if (cKo != null) {
            cKo.a(baseFragmentActivity.getPageContext());
        }
        if (cKq && cKo != null) {
            cKo.ayU();
            cKo.ayV();
            cKq = false;
        }
        return cKp;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        ayR();
        if (z) {
            ayN();
        }
        if (z2) {
            ayO();
        }
        fn(z3);
        a(aVar);
    }

    public void ayN() {
        ayR();
        if (cKo != null) {
            cKo.ayU();
            cKq = false;
        }
    }

    public void ayO() {
        ayR();
        if (cKo != null) {
            cKo.ayV();
            cKq = false;
        }
    }

    public void fn(boolean z) {
        ayR();
        if (cKo != null) {
            cKo.fn(z);
        }
    }

    public void a(b.a aVar) {
        ayR();
        if (cKo != null) {
            cKo.c(aVar);
        }
    }

    public void b(b.a aVar) {
        ayR();
        if (cKo != null) {
            if (cKo.ayS()) {
                cKo.c(aVar);
            }
            cKo.ayT();
        }
    }

    public void a(int i, b.a aVar) {
        ayR();
        if (cKo != null) {
            if (cKo.ayS()) {
                cKo.c(aVar);
            }
            cKo.jn(i);
        }
    }

    public void ayP() {
        ayR();
        if (cKo != null) {
            cKo.ayP();
            cKq = true;
        }
    }

    public void resetContext() {
        ayR();
        if (cKo != null) {
            cKo.resetContext();
        }
    }

    public void ayQ() {
        ayR();
        resetContext();
        ayP();
    }

    private void ayR() {
        if (cKo == null) {
        }
    }

    public static void resetAll() {
        try {
            if (cKo != null) {
                if (cKp != null) {
                    cKp.ayQ();
                }
                cKo.removeCallBack();
                cKo.ayW();
                cKo = null;
            }
            if (cKp != null) {
                cKp = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
