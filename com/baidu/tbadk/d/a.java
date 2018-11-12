package com.baidu.tbadk.d;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.d.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b aiR = null;
    private static a aiS = null;
    private static boolean aiT = false;
    private static String aiU = "";
    private static transient List<String> aiV = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aiS == null) {
            synchronized (a.class) {
                if (aiS == null) {
                    aiS = new a();
                    aiR = b.c(baseFragmentActivity);
                }
            }
        } else if (aiR != null) {
            aiR.setContext(baseFragmentActivity.getPageContext());
        }
        if (aiT && aiR != null) {
            aiR.vz();
            aiR.vA();
            aiT = false;
        }
        return aiS;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        vv();
        if (z) {
            vq();
        }
        if (z2) {
            vr();
        }
        aP(z3);
        a(aVar);
    }

    public void vq() {
        vv();
        if (aiR != null) {
            aiR.vz();
            aiT = false;
        }
    }

    public void vr() {
        vv();
        if (aiR != null) {
            aiR.vA();
            aiT = false;
        }
    }

    public void aP(boolean z) {
        vv();
        if (aiR != null) {
            aiR.aP(z);
        }
    }

    public void a(b.a aVar) {
        vv();
        if (aiR != null) {
            aiR.c(aVar);
        }
    }

    public void b(b.a aVar) {
        vv();
        if (aiR != null) {
            if (aiR.vw()) {
                aiR.c(aVar);
            }
            aiR.vy();
        }
    }

    public void a(int i, b.a aVar) {
        vv();
        if (aiR != null) {
            if (aiR.vw()) {
                aiR.c(aVar);
            }
            aiR.bM(i);
        }
    }

    public void vs() {
        vv();
        if (aiR != null) {
            aiR.vs();
            aiT = true;
        }
    }

    public void vt() {
        vv();
        if (aiR != null) {
            aiR.vt();
        }
    }

    public void vu() {
        vv();
        vt();
        vs();
    }

    private void vv() {
        if (aiR == null) {
        }
    }

    public static void resetAll() {
        try {
            if (aiR != null) {
                if (aiS != null) {
                    aiS.vu();
                }
                aiR.vx();
                aiR.vB();
                aiR = null;
            }
            if (aiS != null) {
                aiS = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
