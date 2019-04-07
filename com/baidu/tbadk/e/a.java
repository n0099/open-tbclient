package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static b bty = null;
    private static a btz = null;
    private static boolean btA = false;
    private static String btB = "";
    private static transient List<String> btC = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (btz == null) {
            synchronized (a.class) {
                if (btz == null) {
                    btz = new a();
                    bty = b.c(baseFragmentActivity);
                }
            }
        } else if (bty != null) {
            bty.a(baseFragmentActivity.getPageContext());
        }
        if (btA && bty != null) {
            bty.Vl();
            bty.Vm();
            btA = false;
        }
        return btz;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        Vh();
        if (z) {
            Vc();
        }
        if (z2) {
            Vd();
        }
        da(z3);
        a(aVar);
    }

    public void Vc() {
        Vh();
        if (bty != null) {
            bty.Vl();
            btA = false;
        }
    }

    public void Vd() {
        Vh();
        if (bty != null) {
            bty.Vm();
            btA = false;
        }
    }

    public void da(boolean z) {
        Vh();
        if (bty != null) {
            bty.da(z);
        }
    }

    public void a(b.a aVar) {
        Vh();
        if (bty != null) {
            bty.c(aVar);
        }
    }

    public void b(b.a aVar) {
        Vh();
        if (bty != null) {
            if (bty.Vi()) {
                bty.c(aVar);
            }
            bty.Vk();
        }
    }

    public void a(int i, b.a aVar) {
        Vh();
        if (bty != null) {
            if (bty.Vi()) {
                bty.c(aVar);
            }
            bty.fB(i);
        }
    }

    public void Ve() {
        Vh();
        if (bty != null) {
            bty.Ve();
            btA = true;
        }
    }

    public void Vf() {
        Vh();
        if (bty != null) {
            bty.Vf();
        }
    }

    public void Vg() {
        Vh();
        Vf();
        Ve();
    }

    private void Vh() {
        if (bty == null) {
        }
    }

    public static void Hf() {
        try {
            if (bty != null) {
                if (btz != null) {
                    btz.Vg();
                }
                bty.Vj();
                bty.Vn();
                bty = null;
            }
            if (btz != null) {
                btz = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
