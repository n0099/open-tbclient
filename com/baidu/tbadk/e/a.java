package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private static b dIO = null;
    private static a dIP = null;
    private static boolean dIQ = false;
    private static String dIR = "";
    private static transient List<String> dIS = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (dIP == null) {
            synchronized (a.class) {
                if (dIP == null) {
                    dIP = new a();
                    dIO = b.c(baseFragmentActivity);
                }
            }
        } else if (dIO != null) {
            dIO.a(baseFragmentActivity.getPageContext());
        }
        if (dIQ && dIO != null) {
            dIO.aSu();
            dIO.aSv();
            dIQ = false;
        }
        return dIP;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        aSr();
        if (z) {
            aSn();
        }
        if (z2) {
            aSo();
        }
        hf(z3);
        a(aVar);
    }

    public void aSn() {
        aSr();
        if (dIO != null) {
            dIO.aSu();
            dIQ = false;
        }
    }

    public void aSo() {
        aSr();
        if (dIO != null) {
            dIO.aSv();
            dIQ = false;
        }
    }

    public void hf(boolean z) {
        aSr();
        if (dIO != null) {
            dIO.hf(z);
        }
    }

    public void a(b.a aVar) {
        aSr();
        if (dIO != null) {
            dIO.c(aVar);
        }
    }

    public void b(b.a aVar) {
        aSr();
        if (dIO != null) {
            if (dIO.aSs()) {
                dIO.c(aVar);
            }
            dIO.aSt();
        }
    }

    public void a(int i, b.a aVar) {
        aSr();
        if (dIO != null) {
            if (dIO.aSs()) {
                dIO.c(aVar);
            }
            dIO.kA(i);
        }
    }

    public void aSp() {
        aSr();
        if (dIO != null) {
            dIO.aSp();
            dIQ = true;
        }
    }

    public void resetContext() {
        aSr();
        if (dIO != null) {
            dIO.resetContext();
        }
    }

    public void aSq() {
        aSr();
        resetContext();
        aSp();
    }

    private void aSr() {
        if (dIO == null) {
        }
    }

    public static void resetAll() {
        try {
            if (dIO != null) {
                if (dIP != null) {
                    dIP.aSq();
                }
                dIO.removeCallBack();
                dIO.aSw();
                dIO = null;
            }
            if (dIP != null) {
                dIP = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
