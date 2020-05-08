package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static b djL = null;
    private static a djM = null;
    private static boolean djN = false;
    private static String djO = "";
    private static transient List<String> djP = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (djM == null) {
            synchronized (a.class) {
                if (djM == null) {
                    djM = new a();
                    djL = b.c(baseFragmentActivity);
                }
            }
        } else if (djL != null) {
            djL.a(baseFragmentActivity.getPageContext());
        }
        if (djN && djL != null) {
            djL.aHi();
            djL.aHj();
            djN = false;
        }
        return djM;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        aHf();
        if (z) {
            aHb();
        }
        if (z2) {
            aHc();
        }
        gl(z3);
        a(aVar);
    }

    public void aHb() {
        aHf();
        if (djL != null) {
            djL.aHi();
            djN = false;
        }
    }

    public void aHc() {
        aHf();
        if (djL != null) {
            djL.aHj();
            djN = false;
        }
    }

    public void gl(boolean z) {
        aHf();
        if (djL != null) {
            djL.gl(z);
        }
    }

    public void a(b.a aVar) {
        aHf();
        if (djL != null) {
            djL.c(aVar);
        }
    }

    public void b(b.a aVar) {
        aHf();
        if (djL != null) {
            if (djL.aHg()) {
                djL.c(aVar);
            }
            djL.aHh();
        }
    }

    public void a(int i, b.a aVar) {
        aHf();
        if (djL != null) {
            if (djL.aHg()) {
                djL.c(aVar);
            }
            djL.ju(i);
        }
    }

    public void aHd() {
        aHf();
        if (djL != null) {
            djL.aHd();
            djN = true;
        }
    }

    public void resetContext() {
        aHf();
        if (djL != null) {
            djL.resetContext();
        }
    }

    public void aHe() {
        aHf();
        resetContext();
        aHd();
    }

    private void aHf() {
        if (djL == null) {
        }
    }

    public static void resetAll() {
        try {
            if (djL != null) {
                if (djM != null) {
                    djM.aHe();
                }
                djL.removeCallBack();
                djL.aHk();
                djL = null;
            }
            if (djM != null) {
                djM = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
