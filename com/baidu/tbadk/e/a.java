package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static b cKp = null;
    private static a cKq = null;
    private static boolean cKr = false;
    private static String cKs = "";
    private static transient List<String> cKt = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (cKq == null) {
            synchronized (a.class) {
                if (cKq == null) {
                    cKq = new a();
                    cKp = b.c(baseFragmentActivity);
                }
            }
        } else if (cKp != null) {
            cKp.a(baseFragmentActivity.getPageContext());
        }
        if (cKr && cKp != null) {
            cKp.ayW();
            cKp.ayX();
            cKr = false;
        }
        return cKq;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        ayT();
        if (z) {
            ayP();
        }
        if (z2) {
            ayQ();
        }
        fn(z3);
        a(aVar);
    }

    public void ayP() {
        ayT();
        if (cKp != null) {
            cKp.ayW();
            cKr = false;
        }
    }

    public void ayQ() {
        ayT();
        if (cKp != null) {
            cKp.ayX();
            cKr = false;
        }
    }

    public void fn(boolean z) {
        ayT();
        if (cKp != null) {
            cKp.fn(z);
        }
    }

    public void a(b.a aVar) {
        ayT();
        if (cKp != null) {
            cKp.c(aVar);
        }
    }

    public void b(b.a aVar) {
        ayT();
        if (cKp != null) {
            if (cKp.ayU()) {
                cKp.c(aVar);
            }
            cKp.ayV();
        }
    }

    public void a(int i, b.a aVar) {
        ayT();
        if (cKp != null) {
            if (cKp.ayU()) {
                cKp.c(aVar);
            }
            cKp.jn(i);
        }
    }

    public void ayR() {
        ayT();
        if (cKp != null) {
            cKp.ayR();
            cKr = true;
        }
    }

    public void resetContext() {
        ayT();
        if (cKp != null) {
            cKp.resetContext();
        }
    }

    public void ayS() {
        ayT();
        resetContext();
        ayR();
    }

    private void ayT() {
        if (cKp == null) {
        }
    }

    public static void resetAll() {
        try {
            if (cKp != null) {
                if (cKq != null) {
                    cKq.ayS();
                }
                cKp.removeCallBack();
                cKp.ayY();
                cKp = null;
            }
            if (cKq != null) {
                cKq = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
