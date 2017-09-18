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
    private static b QO = null;
    private static a QP = null;
    private static boolean QR = false;
    private static String QS = "";
    private static transient List<String> QT = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0054a {
        private static SparseIntArray QU = new SparseIntArray();

        static {
            QU.put(2, 1);
            QU.put(4, 2);
            QU.put(8, 3);
            QU.put(12, 4);
            QU.put(16, 5);
            QU.put(20, 6);
            QU.put(24, 7);
        }

        public static int aX(int i) {
            return QU.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (QP == null) {
            synchronized (a.class) {
                if (QP == null) {
                    QP = new a();
                    QO = b.b(baseFragmentActivity);
                }
            }
        } else if (QO != null) {
            QO.a(baseFragmentActivity.getPageContext());
        }
        if (QR && QO != null) {
            QO.nV();
            QO.nW();
            QR = false;
        }
        return QP;
    }

    public static a b(BaseActivity baseActivity) {
        if (QP == null) {
            synchronized (a.class) {
                if (QP == null) {
                    QP = new a();
                    QO = b.c(baseActivity);
                }
            }
        } else if (QO != null) {
            QO.a(baseActivity.getPageContext());
        }
        if (QR && QO != null) {
            QO.nV();
            QO.nW();
            QR = false;
        }
        return QP;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nQ();
        if (z) {
            nK();
        }
        if (z2) {
            nL();
        }
        ad(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nQ();
        if (QO != null) {
            QO.a(tbPageContext, str, str2, str3);
        }
    }

    public void nK() {
        nQ();
        if (QO != null) {
            QO.nV();
            QR = false;
        }
    }

    public void nL() {
        nQ();
        if (QO != null) {
            QO.nW();
            QR = false;
        }
    }

    public void ad(boolean z) {
        nQ();
        if (QO != null) {
            QO.ad(z);
        }
    }

    public boolean nM() {
        nQ();
        if (QO != null) {
            return QO.nM();
        }
        return false;
    }

    public void a(b.a aVar) {
        nQ();
        if (QO != null) {
            QO.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nQ();
        if (QO != null) {
            if (QO.nS()) {
                QO.c(aVar);
            }
            QO.nU();
        }
    }

    public void a(int i, b.a aVar) {
        nQ();
        if (QO != null) {
            if (QO.nS()) {
                QO.c(aVar);
            }
            QO.aY(i);
        }
    }

    public void nN() {
        nQ();
        if (QO != null) {
            QO.nN();
            QR = true;
        }
    }

    public void nO() {
        nQ();
        if (QO != null) {
            QO.nO();
        }
    }

    public void nP() {
        nQ();
        nO();
        nN();
    }

    private void nQ() {
        if (QO == null) {
        }
    }

    public static void nR() {
        try {
            if (QO != null) {
                if (QP != null) {
                    QP.nP();
                }
                QO.nT();
                QO.nX();
                QO = null;
            }
            if (QP != null) {
                QP = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
