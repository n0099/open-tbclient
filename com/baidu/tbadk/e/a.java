package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static b bTA = null;
    private static a bTB = null;
    private static boolean bTC = false;
    private static String bTD = "";
    private static transient List<String> bTE = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (bTB == null) {
            synchronized (a.class) {
                if (bTB == null) {
                    bTB = new a();
                    bTA = b.c(baseFragmentActivity);
                }
            }
        } else if (bTA != null) {
            bTA.a(baseFragmentActivity.getPageContext());
        }
        if (bTC && bTA != null) {
            bTA.afw();
            bTA.afx();
            bTC = false;
        }
        return bTB;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        aft();
        if (z) {
            afo();
        }
        if (z2) {
            afp();
        }
        dP(z3);
        a(aVar);
    }

    public void afo() {
        aft();
        if (bTA != null) {
            bTA.afw();
            bTC = false;
        }
    }

    public void afp() {
        aft();
        if (bTA != null) {
            bTA.afx();
            bTC = false;
        }
    }

    public void dP(boolean z) {
        aft();
        if (bTA != null) {
            bTA.dP(z);
        }
    }

    public void a(b.a aVar) {
        aft();
        if (bTA != null) {
            bTA.c(aVar);
        }
    }

    public void b(b.a aVar) {
        aft();
        if (bTA != null) {
            if (bTA.afu()) {
                bTA.c(aVar);
            }
            bTA.afv();
        }
    }

    public void a(int i, b.a aVar) {
        aft();
        if (bTA != null) {
            if (bTA.afu()) {
                bTA.c(aVar);
            }
            bTA.hl(i);
        }
    }

    public void afq() {
        aft();
        if (bTA != null) {
            bTA.afq();
            bTC = true;
        }
    }

    public void afr() {
        aft();
        if (bTA != null) {
            bTA.afr();
        }
    }

    public void afs() {
        aft();
        afr();
        afq();
    }

    private void aft() {
        if (bTA == null) {
        }
    }

    public static void Pg() {
        try {
            if (bTA != null) {
                if (bTB != null) {
                    bTB.afs();
                }
                bTA.removeCallBack();
                bTA.afy();
                bTA = null;
            }
            if (bTB != null) {
                bTB = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
