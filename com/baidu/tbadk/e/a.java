package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static b cKq = null;
    private static a cKr = null;
    private static boolean cKs = false;
    private static String cKt = "";
    private static transient List<String> cKu = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (cKr == null) {
            synchronized (a.class) {
                if (cKr == null) {
                    cKr = new a();
                    cKq = b.c(baseFragmentActivity);
                }
            }
        } else if (cKq != null) {
            cKq.a(baseFragmentActivity.getPageContext());
        }
        if (cKs && cKq != null) {
            cKq.ayW();
            cKq.ayX();
            cKs = false;
        }
        return cKr;
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
        if (cKq != null) {
            cKq.ayW();
            cKs = false;
        }
    }

    public void ayQ() {
        ayT();
        if (cKq != null) {
            cKq.ayX();
            cKs = false;
        }
    }

    public void fn(boolean z) {
        ayT();
        if (cKq != null) {
            cKq.fn(z);
        }
    }

    public void a(b.a aVar) {
        ayT();
        if (cKq != null) {
            cKq.c(aVar);
        }
    }

    public void b(b.a aVar) {
        ayT();
        if (cKq != null) {
            if (cKq.ayU()) {
                cKq.c(aVar);
            }
            cKq.ayV();
        }
    }

    public void a(int i, b.a aVar) {
        ayT();
        if (cKq != null) {
            if (cKq.ayU()) {
                cKq.c(aVar);
            }
            cKq.jn(i);
        }
    }

    public void ayR() {
        ayT();
        if (cKq != null) {
            cKq.ayR();
            cKs = true;
        }
    }

    public void resetContext() {
        ayT();
        if (cKq != null) {
            cKq.resetContext();
        }
    }

    public void ayS() {
        ayT();
        resetContext();
        ayR();
    }

    private void ayT() {
        if (cKq == null) {
        }
    }

    public static void resetAll() {
        try {
            if (cKq != null) {
                if (cKr != null) {
                    cKr.ayS();
                }
                cKq.removeCallBack();
                cKq.ayY();
                cKq = null;
            }
            if (cKr != null) {
                cKr = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
