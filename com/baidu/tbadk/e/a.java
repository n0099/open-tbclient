package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static b cFY = null;
    private static a cFZ = null;
    private static boolean cGa = false;
    private static String cGb = "";
    private static transient List<String> cGc = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (cFZ == null) {
            synchronized (a.class) {
                if (cFZ == null) {
                    cFZ = new a();
                    cFY = b.c(baseFragmentActivity);
                }
            }
        } else if (cFY != null) {
            cFY.a(baseFragmentActivity.getPageContext());
        }
        if (cGa && cFY != null) {
            cFY.awo();
            cFY.awp();
            cGa = false;
        }
        return cFZ;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        awl();
        if (z) {
            awh();
        }
        if (z2) {
            awi();
        }
        fb(z3);
        a(aVar);
    }

    public void awh() {
        awl();
        if (cFY != null) {
            cFY.awo();
            cGa = false;
        }
    }

    public void awi() {
        awl();
        if (cFY != null) {
            cFY.awp();
            cGa = false;
        }
    }

    public void fb(boolean z) {
        awl();
        if (cFY != null) {
            cFY.fb(z);
        }
    }

    public void a(b.a aVar) {
        awl();
        if (cFY != null) {
            cFY.c(aVar);
        }
    }

    public void b(b.a aVar) {
        awl();
        if (cFY != null) {
            if (cFY.awm()) {
                cFY.c(aVar);
            }
            cFY.awn();
        }
    }

    public void a(int i, b.a aVar) {
        awl();
        if (cFY != null) {
            if (cFY.awm()) {
                cFY.c(aVar);
            }
            cFY.iW(i);
        }
    }

    public void awj() {
        awl();
        if (cFY != null) {
            cFY.awj();
            cGa = true;
        }
    }

    public void resetContext() {
        awl();
        if (cFY != null) {
            cFY.resetContext();
        }
    }

    public void awk() {
        awl();
        resetContext();
        awj();
    }

    private void awl() {
        if (cFY == null) {
        }
    }

    public static void resetAll() {
        try {
            if (cFY != null) {
                if (cFZ != null) {
                    cFZ.awk();
                }
                cFY.removeCallBack();
                cFY.awq();
                cFY = null;
            }
            if (cFZ != null) {
                cFZ = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
