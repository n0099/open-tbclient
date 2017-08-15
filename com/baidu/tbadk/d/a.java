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
    private static b RM = null;
    private static a RO = null;
    private static boolean RP = false;
    private static String RQ = "";
    private static transient List<String> RR = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0052a {
        private static SparseIntArray RS = new SparseIntArray();

        static {
            RS.put(2, 1);
            RS.put(4, 2);
            RS.put(8, 3);
            RS.put(12, 4);
            RS.put(16, 5);
            RS.put(20, 6);
            RS.put(24, 7);
        }

        public static int aX(int i) {
            return RS.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (RO == null) {
            synchronized (a.class) {
                if (RO == null) {
                    RO = new a();
                    RM = b.b(baseFragmentActivity);
                }
            }
        } else if (RM != null) {
            RM.a(baseFragmentActivity.getPageContext());
        }
        if (RP && RM != null) {
            RM.oa();
            RM.ob();
            RP = false;
        }
        return RO;
    }

    public static a b(BaseActivity baseActivity) {
        if (RO == null) {
            synchronized (a.class) {
                if (RO == null) {
                    RO = new a();
                    RM = b.c(baseActivity);
                }
            }
        } else if (RM != null) {
            RM.a(baseActivity.getPageContext());
        }
        if (RP && RM != null) {
            RM.oa();
            RM.ob();
            RP = false;
        }
        return RO;
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
        if (RM != null) {
            RM.a(tbPageContext, str, str2, str3);
        }
    }

    public void nP() {
        nV();
        if (RM != null) {
            RM.oa();
            RP = false;
        }
    }

    public void nQ() {
        nV();
        if (RM != null) {
            RM.ob();
            RP = false;
        }
    }

    public void ad(boolean z) {
        nV();
        if (RM != null) {
            RM.ad(z);
        }
    }

    public boolean nR() {
        nV();
        if (RM != null) {
            return RM.nR();
        }
        return false;
    }

    public void a(b.a aVar) {
        nV();
        if (RM != null) {
            RM.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nV();
        if (RM != null) {
            if (RM.nX()) {
                RM.c(aVar);
            }
            RM.nZ();
        }
    }

    public void a(int i, b.a aVar) {
        nV();
        if (RM != null) {
            if (RM.nX()) {
                RM.c(aVar);
            }
            RM.aY(i);
        }
    }

    public void nS() {
        nV();
        if (RM != null) {
            RM.nS();
            RP = true;
        }
    }

    public void nT() {
        nV();
        if (RM != null) {
            RM.nT();
        }
    }

    public void nU() {
        nV();
        nT();
        nS();
    }

    private void nV() {
        if (RM == null) {
        }
    }

    public static void nW() {
        try {
            if (RM != null) {
                if (RO != null) {
                    RO.nU();
                }
                RM.nY();
                RM.oc();
                RM = null;
            }
            if (RO != null) {
                RO = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
