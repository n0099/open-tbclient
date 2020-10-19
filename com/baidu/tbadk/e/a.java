package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private static b egk = null;
    private static a egm = null;
    private static boolean egn = false;
    private static String ego = "";
    private static transient List<String> egp = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (egm == null) {
            synchronized (a.class) {
                if (egm == null) {
                    egm = new a();
                    egk = b.c(baseFragmentActivity);
                }
            }
        } else if (egk != null) {
            egk.a(baseFragmentActivity.getPageContext());
        }
        if (egn && egk != null) {
            egk.ben();
            egk.beo();
            egn = false;
        }
        return egm;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        bek();
        if (z) {
            beg();
        }
        if (z2) {
            beh();
        }
        hV(z3);
        a(aVar);
    }

    public void beg() {
        bek();
        if (egk != null) {
            egk.ben();
            egn = false;
        }
    }

    public void beh() {
        bek();
        if (egk != null) {
            egk.beo();
            egn = false;
        }
    }

    public void hV(boolean z) {
        bek();
        if (egk != null) {
            egk.hV(z);
        }
    }

    public void a(b.a aVar) {
        bek();
        if (egk != null) {
            egk.c(aVar);
        }
    }

    public void b(b.a aVar) {
        bek();
        if (egk != null) {
            if (egk.bel()) {
                egk.c(aVar);
            }
            egk.bem();
        }
    }

    public void a(int i, b.a aVar) {
        bek();
        if (egk != null) {
            if (egk.bel()) {
                egk.c(aVar);
            }
            egk.no(i);
        }
    }

    public void bei() {
        bek();
        if (egk != null) {
            egk.bei();
            egn = true;
        }
    }

    public void resetContext() {
        bek();
        if (egk != null) {
            egk.resetContext();
        }
    }

    public void bej() {
        bek();
        resetContext();
        bei();
    }

    private void bek() {
        if (egk == null) {
        }
    }

    public static void resetAll() {
        try {
            if (egk != null) {
                if (egm != null) {
                    egm.bej();
                }
                egk.removeCallBack();
                egk.bep();
                egk = null;
            }
            if (egm != null) {
                egm = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
