package com.baidu.tbadk.d;

import android.util.SparseIntArray;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.d.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static b RK = null;
    private static a RL = null;
    private static boolean RM = false;
    private static String RO = "";
    private static transient List<String> RP = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0052a {
        private static SparseIntArray RQ = new SparseIntArray();

        static {
            RQ.put(2, 1);
            RQ.put(4, 2);
            RQ.put(8, 3);
            RQ.put(12, 4);
            RQ.put(16, 5);
            RQ.put(20, 6);
            RQ.put(24, 7);
        }

        public static int aX(int i) {
            return RQ.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (RL == null) {
            synchronized (a.class) {
                if (RL == null) {
                    RL = new a();
                    RK = b.b(baseFragmentActivity);
                }
            }
        } else if (RK != null) {
            RK.a(baseFragmentActivity.getPageContext());
        }
        if (RM && RK != null) {
            RK.oa();
            RK.ob();
            RM = false;
        }
        return RL;
    }

    public static a b(BaseActivity baseActivity) {
        if (RL == null) {
            synchronized (a.class) {
                if (RL == null) {
                    RL = new a();
                    RK = b.c(baseActivity);
                }
            }
        } else if (RK != null) {
            RK.a(baseActivity.getPageContext());
        }
        if (RM && RK != null) {
            RK.oa();
            RK.ob();
            RM = false;
        }
        return RL;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nV();
        if (z) {
            nP();
        }
        if (z2) {
            nQ();
        }
        ad(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nV();
        if (RK != null) {
            RK.a(tbPageContext, str, str2, str3);
        }
    }

    public void nP() {
        nV();
        if (RK != null) {
            RK.oa();
            RM = false;
        }
    }

    public void nQ() {
        nV();
        if (RK != null) {
            RK.ob();
            RM = false;
        }
    }

    public void ad(boolean z) {
        nV();
        if (RK != null) {
            RK.ad(z);
        }
    }

    public boolean nR() {
        nV();
        if (RK != null) {
            return RK.nR();
        }
        return false;
    }

    public void a(b.a aVar) {
        nV();
        if (RK != null) {
            RK.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nV();
        if (RK != null) {
            if (RK.nX()) {
                RK.c(aVar);
            }
            RK.nZ();
        }
    }

    public void a(int i, b.a aVar) {
        nV();
        if (RK != null) {
            if (RK.nX()) {
                RK.c(aVar);
            }
            RK.aY(i);
        }
    }

    public void nS() {
        nV();
        if (RK != null) {
            RK.nS();
            RM = true;
        }
    }

    public void nT() {
        nV();
        if (RK != null) {
            RK.nT();
        }
    }

    public void nU() {
        nV();
        nT();
        nS();
    }

    private void nV() {
        if (RK == null) {
        }
    }

    public static void nW() {
        try {
            if (RK != null) {
                if (RL != null) {
                    RL.nU();
                }
                RK.nY();
                RK.oc();
                RK = null;
            }
            if (RL != null) {
                RL = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
