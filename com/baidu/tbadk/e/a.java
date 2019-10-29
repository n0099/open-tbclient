package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static b bUr = null;
    private static a bUs = null;
    private static boolean bUt = false;
    private static String bUu = "";
    private static transient List<String> bUv = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (bUs == null) {
            synchronized (a.class) {
                if (bUs == null) {
                    bUs = new a();
                    bUr = b.c(baseFragmentActivity);
                }
            }
        } else if (bUr != null) {
            bUr.a(baseFragmentActivity.getPageContext());
        }
        if (bUt && bUr != null) {
            bUr.afy();
            bUr.afz();
            bUt = false;
        }
        return bUs;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        afv();
        if (z) {
            afq();
        }
        if (z2) {
            afr();
        }
        dP(z3);
        a(aVar);
    }

    public void afq() {
        afv();
        if (bUr != null) {
            bUr.afy();
            bUt = false;
        }
    }

    public void afr() {
        afv();
        if (bUr != null) {
            bUr.afz();
            bUt = false;
        }
    }

    public void dP(boolean z) {
        afv();
        if (bUr != null) {
            bUr.dP(z);
        }
    }

    public void a(b.a aVar) {
        afv();
        if (bUr != null) {
            bUr.c(aVar);
        }
    }

    public void b(b.a aVar) {
        afv();
        if (bUr != null) {
            if (bUr.afw()) {
                bUr.c(aVar);
            }
            bUr.afx();
        }
    }

    public void a(int i, b.a aVar) {
        afv();
        if (bUr != null) {
            if (bUr.afw()) {
                bUr.c(aVar);
            }
            bUr.hm(i);
        }
    }

    public void afs() {
        afv();
        if (bUr != null) {
            bUr.afs();
            bUt = true;
        }
    }

    public void aft() {
        afv();
        if (bUr != null) {
            bUr.aft();
        }
    }

    public void afu() {
        afv();
        aft();
        afs();
    }

    private void afv() {
        if (bUr == null) {
        }
    }

    public static void Pf() {
        try {
            if (bUr != null) {
                if (bUs != null) {
                    bUs.afu();
                }
                bUr.removeCallBack();
                bUr.afA();
                bUr = null;
            }
            if (bUs != null) {
                bUs = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
