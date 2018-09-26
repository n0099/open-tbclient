package com.baidu.tbadk.d;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.d.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b adg = null;
    private static a adh = null;
    private static boolean adi = false;
    private static String adj = "";
    private static transient List<String> adk = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (adh == null) {
            synchronized (a.class) {
                if (adh == null) {
                    adh = new a();
                    adg = b.c(baseFragmentActivity);
                }
            }
        } else if (adg != null) {
            adg.setContext(baseFragmentActivity.getPageContext());
        }
        if (adi && adg != null) {
            adg.tf();
            adg.tg();
            adi = false;
        }
        return adh;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        ta();
        if (z) {
            sV();
        }
        if (z2) {
            sW();
        }
        ao(z3);
        a(aVar);
    }

    public void sV() {
        ta();
        if (adg != null) {
            adg.tf();
            adi = false;
        }
    }

    public void sW() {
        ta();
        if (adg != null) {
            adg.tg();
            adi = false;
        }
    }

    public void ao(boolean z) {
        ta();
        if (adg != null) {
            adg.ao(z);
        }
    }

    public void a(b.a aVar) {
        ta();
        if (adg != null) {
            adg.c(aVar);
        }
    }

    public void b(b.a aVar) {
        ta();
        if (adg != null) {
            if (adg.tc()) {
                adg.c(aVar);
            }
            adg.te();
        }
    }

    public void a(int i, b.a aVar) {
        ta();
        if (adg != null) {
            if (adg.tc()) {
                adg.c(aVar);
            }
            adg.bm(i);
        }
    }

    public void sX() {
        ta();
        if (adg != null) {
            adg.sX();
            adi = true;
        }
    }

    public void sY() {
        ta();
        if (adg != null) {
            adg.sY();
        }
    }

    public void sZ() {
        ta();
        sY();
        sX();
    }

    private void ta() {
        if (adg == null) {
        }
    }

    public static void tb() {
        try {
            if (adg != null) {
                if (adh != null) {
                    adh.sZ();
                }
                adg.td();
                adg.th();
                adg = null;
            }
            if (adh != null) {
                adh = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
