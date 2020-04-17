package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static b djH = null;
    private static a djI = null;
    private static boolean djJ = false;
    private static String djK = "";
    private static transient List<String> djL = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (djI == null) {
            synchronized (a.class) {
                if (djI == null) {
                    djI = new a();
                    djH = b.c(baseFragmentActivity);
                }
            }
        } else if (djH != null) {
            djH.a(baseFragmentActivity.getPageContext());
        }
        if (djJ && djH != null) {
            djH.aHk();
            djH.aHl();
            djJ = false;
        }
        return djI;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        aHh();
        if (z) {
            aHd();
        }
        if (z2) {
            aHe();
        }
        gl(z3);
        a(aVar);
    }

    public void aHd() {
        aHh();
        if (djH != null) {
            djH.aHk();
            djJ = false;
        }
    }

    public void aHe() {
        aHh();
        if (djH != null) {
            djH.aHl();
            djJ = false;
        }
    }

    public void gl(boolean z) {
        aHh();
        if (djH != null) {
            djH.gl(z);
        }
    }

    public void a(b.a aVar) {
        aHh();
        if (djH != null) {
            djH.c(aVar);
        }
    }

    public void b(b.a aVar) {
        aHh();
        if (djH != null) {
            if (djH.aHi()) {
                djH.c(aVar);
            }
            djH.aHj();
        }
    }

    public void a(int i, b.a aVar) {
        aHh();
        if (djH != null) {
            if (djH.aHi()) {
                djH.c(aVar);
            }
            djH.ju(i);
        }
    }

    public void aHf() {
        aHh();
        if (djH != null) {
            djH.aHf();
            djJ = true;
        }
    }

    public void resetContext() {
        aHh();
        if (djH != null) {
            djH.resetContext();
        }
    }

    public void aHg() {
        aHh();
        resetContext();
        aHf();
    }

    private void aHh() {
        if (djH == null) {
        }
    }

    public static void resetAll() {
        try {
            if (djH != null) {
                if (djI != null) {
                    djI.aHg();
                }
                djH.removeCallBack();
                djH.aHm();
                djH = null;
            }
            if (djI != null) {
                djI = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
