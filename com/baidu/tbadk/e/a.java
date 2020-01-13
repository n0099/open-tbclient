package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private static b cGk = null;
    private static a cGl = null;
    private static boolean cGm = false;
    private static String cGn = "";
    private static transient List<String> cGo = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (cGl == null) {
            synchronized (a.class) {
                if (cGl == null) {
                    cGl = new a();
                    cGk = b.c(baseFragmentActivity);
                }
            }
        } else if (cGk != null) {
            cGk.a(baseFragmentActivity.getPageContext());
        }
        if (cGm && cGk != null) {
            cGk.awH();
            cGk.awI();
            cGm = false;
        }
        return cGl;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        awE();
        if (z) {
            awA();
        }
        if (z2) {
            awB();
        }
        fg(z3);
        a(aVar);
    }

    public void awA() {
        awE();
        if (cGk != null) {
            cGk.awH();
            cGm = false;
        }
    }

    public void awB() {
        awE();
        if (cGk != null) {
            cGk.awI();
            cGm = false;
        }
    }

    public void fg(boolean z) {
        awE();
        if (cGk != null) {
            cGk.fg(z);
        }
    }

    public void a(b.a aVar) {
        awE();
        if (cGk != null) {
            cGk.c(aVar);
        }
    }

    public void b(b.a aVar) {
        awE();
        if (cGk != null) {
            if (cGk.awF()) {
                cGk.c(aVar);
            }
            cGk.awG();
        }
    }

    public void a(int i, b.a aVar) {
        awE();
        if (cGk != null) {
            if (cGk.awF()) {
                cGk.c(aVar);
            }
            cGk.iW(i);
        }
    }

    public void awC() {
        awE();
        if (cGk != null) {
            cGk.awC();
            cGm = true;
        }
    }

    public void resetContext() {
        awE();
        if (cGk != null) {
            cGk.resetContext();
        }
    }

    public void awD() {
        awE();
        resetContext();
        awC();
    }

    private void awE() {
        if (cGk == null) {
        }
    }

    public static void resetAll() {
        try {
            if (cGk != null) {
                if (cGl != null) {
                    cGl.awD();
                }
                cGk.removeCallBack();
                cGk.awJ();
                cGk = null;
            }
            if (cGl != null) {
                cGl = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
