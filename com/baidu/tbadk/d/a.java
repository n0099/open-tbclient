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
    private static b RO = null;
    private static a RP = null;
    private static boolean RQ = false;
    private static String RR = "";
    private static transient List<String> RS = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0052a {
        private static SparseIntArray RT = new SparseIntArray();

        static {
            RT.put(2, 1);
            RT.put(4, 2);
            RT.put(8, 3);
            RT.put(12, 4);
            RT.put(16, 5);
            RT.put(20, 6);
            RT.put(24, 7);
        }

        public static int aX(int i) {
            return RT.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (RP == null) {
            synchronized (a.class) {
                if (RP == null) {
                    RP = new a();
                    RO = b.b(baseFragmentActivity);
                }
            }
        } else if (RO != null) {
            RO.a(baseFragmentActivity.getPageContext());
        }
        if (RQ && RO != null) {
            RO.ob();
            RO.oc();
            RQ = false;
        }
        return RP;
    }

    public static a b(BaseActivity baseActivity) {
        if (RP == null) {
            synchronized (a.class) {
                if (RP == null) {
                    RP = new a();
                    RO = b.c(baseActivity);
                }
            }
        } else if (RO != null) {
            RO.a(baseActivity.getPageContext());
        }
        if (RQ && RO != null) {
            RO.ob();
            RO.oc();
            RQ = false;
        }
        return RP;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nW();
        if (z) {
            nQ();
        }
        if (z2) {
            nR();
        }
        ad(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nW();
        if (RO != null) {
            RO.a(tbPageContext, str, str2, str3);
        }
    }

    public void nQ() {
        nW();
        if (RO != null) {
            RO.ob();
            RQ = false;
        }
    }

    public void nR() {
        nW();
        if (RO != null) {
            RO.oc();
            RQ = false;
        }
    }

    public void ad(boolean z) {
        nW();
        if (RO != null) {
            RO.ad(z);
        }
    }

    public boolean nS() {
        nW();
        if (RO != null) {
            return RO.nS();
        }
        return false;
    }

    public void a(b.a aVar) {
        nW();
        if (RO != null) {
            RO.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nW();
        if (RO != null) {
            if (RO.nY()) {
                RO.c(aVar);
            }
            RO.oa();
        }
    }

    public void a(int i, b.a aVar) {
        nW();
        if (RO != null) {
            if (RO.nY()) {
                RO.c(aVar);
            }
            RO.aY(i);
        }
    }

    public void nT() {
        nW();
        if (RO != null) {
            RO.nT();
            RQ = true;
        }
    }

    public void nU() {
        nW();
        if (RO != null) {
            RO.nU();
        }
    }

    public void nV() {
        nW();
        nU();
        nT();
    }

    private void nW() {
        if (RO == null) {
        }
    }

    public static void nX() {
        try {
            if (RO != null) {
                if (RP != null) {
                    RP.nV();
                }
                RO.nZ();
                RO.od();
                RO = null;
            }
            if (RP != null) {
                RP = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
