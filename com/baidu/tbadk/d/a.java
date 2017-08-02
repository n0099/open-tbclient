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
    private static b Qm = null;
    private static a Qn = null;
    private static boolean Qo = false;
    private static String Qp = "";
    private static transient List<String> Qq = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0052a {
        private static SparseIntArray Qr = new SparseIntArray();

        static {
            Qr.put(2, 1);
            Qr.put(4, 2);
            Qr.put(8, 3);
            Qr.put(12, 4);
            Qr.put(16, 5);
            Qr.put(20, 6);
            Qr.put(24, 7);
        }

        public static int aV(int i) {
            return Qr.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Qn == null) {
            synchronized (a.class) {
                if (Qn == null) {
                    Qn = new a();
                    Qm = b.b(baseFragmentActivity);
                }
            }
        } else if (Qm != null) {
            Qm.a(baseFragmentActivity.getPageContext());
        }
        if (Qo && Qm != null) {
            Qm.nQ();
            Qm.nR();
            Qo = false;
        }
        return Qn;
    }

    public static a b(BaseActivity baseActivity) {
        if (Qn == null) {
            synchronized (a.class) {
                if (Qn == null) {
                    Qn = new a();
                    Qm = b.c(baseActivity);
                }
            }
        } else if (Qm != null) {
            Qm.a(baseActivity.getPageContext());
        }
        if (Qo && Qm != null) {
            Qm.nQ();
            Qm.nR();
            Qo = false;
        }
        return Qn;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nL();
        if (z) {
            nF();
        }
        if (z2) {
            nG();
        }
        ad(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nL();
        if (Qm != null) {
            Qm.a(tbPageContext, str, str2, str3);
        }
    }

    public void nF() {
        nL();
        if (Qm != null) {
            Qm.nQ();
            Qo = false;
        }
    }

    public void nG() {
        nL();
        if (Qm != null) {
            Qm.nR();
            Qo = false;
        }
    }

    public void ad(boolean z) {
        nL();
        if (Qm != null) {
            Qm.ad(z);
        }
    }

    public boolean nH() {
        nL();
        if (Qm != null) {
            return Qm.nH();
        }
        return false;
    }

    public void a(b.a aVar) {
        nL();
        if (Qm != null) {
            Qm.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nL();
        if (Qm != null) {
            if (Qm.nN()) {
                Qm.c(aVar);
            }
            Qm.nP();
        }
    }

    public void a(int i, b.a aVar) {
        nL();
        if (Qm != null) {
            if (Qm.nN()) {
                Qm.c(aVar);
            }
            Qm.aW(i);
        }
    }

    public void nI() {
        nL();
        if (Qm != null) {
            Qm.nI();
            Qo = true;
        }
    }

    public void nJ() {
        nL();
        if (Qm != null) {
            Qm.nJ();
        }
    }

    public void nK() {
        nL();
        nJ();
        nI();
    }

    private void nL() {
        if (Qm == null) {
        }
    }

    public static void nM() {
        try {
            if (Qm != null) {
                if (Qn != null) {
                    Qn.nK();
                }
                Qm.nO();
                Qm.nS();
                Qm = null;
            }
            if (Qn != null) {
                Qn = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
