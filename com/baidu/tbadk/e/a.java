package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a {
    private static b dUj = null;
    private static a dUk = null;
    private static boolean dUl = false;
    private static String dUm = "";
    private static transient List<String> dUn = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (dUk == null) {
            synchronized (a.class) {
                if (dUk == null) {
                    dUk = new a();
                    dUj = b.c(baseFragmentActivity);
                }
            }
        } else if (dUj != null) {
            dUj.a(baseFragmentActivity.getPageContext());
        }
        if (dUl && dUj != null) {
            dUj.bbF();
            dUj.bbG();
            dUl = false;
        }
        return dUk;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        bbC();
        if (z) {
            bby();
        }
        if (z2) {
            bbz();
        }
        hz(z3);
        a(aVar);
    }

    public void bby() {
        bbC();
        if (dUj != null) {
            dUj.bbF();
            dUl = false;
        }
    }

    public void bbz() {
        bbC();
        if (dUj != null) {
            dUj.bbG();
            dUl = false;
        }
    }

    public void hz(boolean z) {
        bbC();
        if (dUj != null) {
            dUj.hz(z);
        }
    }

    public void a(b.a aVar) {
        bbC();
        if (dUj != null) {
            dUj.c(aVar);
        }
    }

    public void b(b.a aVar) {
        bbC();
        if (dUj != null) {
            if (dUj.bbD()) {
                dUj.c(aVar);
            }
            dUj.bbE();
        }
    }

    public void a(int i, b.a aVar) {
        bbC();
        if (dUj != null) {
            if (dUj.bbD()) {
                dUj.c(aVar);
            }
            dUj.mR(i);
        }
    }

    public void bbA() {
        bbC();
        if (dUj != null) {
            dUj.bbA();
            dUl = true;
        }
    }

    public void resetContext() {
        bbC();
        if (dUj != null) {
            dUj.resetContext();
        }
    }

    public void bbB() {
        bbC();
        resetContext();
        bbA();
    }

    private void bbC() {
        if (dUj == null) {
        }
    }

    public static void resetAll() {
        try {
            if (dUj != null) {
                if (dUk != null) {
                    dUk.bbB();
                }
                dUj.removeCallBack();
                dUj.bbH();
                dUj = null;
            }
            if (dUk != null) {
                dUk = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
